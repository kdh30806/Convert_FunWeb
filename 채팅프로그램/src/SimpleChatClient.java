

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SimpleChatClient extends JFrame {
	private JTextArea ta;
    private JTextField tf;
    private JLabel lblStatus;
    
    private Socket socket;
    
    private DataInputStream dis;
    private DataOutputStream dos;
    
    private boolean connectStatus; // 서버 접속 여부 저장
    private boolean stopSignal; // 쓰레드 종료 신호 저장
    
	public SimpleChatClient() {
		showFrame();
	}
	
	public void showFrame() {
		setTitle("1:1 채팅 클라이언트");
		setBounds(1200, 400, 500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 채팅 서버 - 클라이언트 연결 상태를 표시할 JLabel
		lblStatus = new JLabel("서버 연결 상태 : 미연결");
		add(lblStatus, BorderLayout.NORTH);
		
		// 채팅 메세지를 표시할 JTextArea - 텍스트 입력이 금지되도록 설정
        ta = new JTextArea();
        ta.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        ta.setEditable(false); // 텍스트 입력 금지
        ta.setBackground(Color.LIGHT_GRAY); // 배경색 변경
        getContentPane().add(ta, BorderLayout.CENTER);
        
        JScrollPane scrollPane = new JScrollPane();
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        scrollPane.setViewportView(ta);
        
        tf = new JTextField();
        tf.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
        getContentPane().add(tf, BorderLayout.SOUTH);
        
        tf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				sendMessage();
			}
		});
		
		setVisible(true);
		
		startService();
		
		tf.requestFocus(); // 현재 텍스트필드에 커서 요청
		
	}
	
	public void startService() {
		// 서버 접속 시도
		String password = prepareConnect();
		boolean connectResult = connectServer(password);
		
		// 서버 접속 결과 판별하여 패스워드 일치할 때까지 패스워드 입력 후 접속 시도
		while(!connectResult) {
			password = prepareConnect();
			connectResult = connectServer(password);
			System.out.println("클라이언트 연결 결과 : " + connectResult);
		}
		
		ta.append("서버 접속 패스워드 일치!\n");
		
		// 멀티쓰레딩 구현하여 receiveMessage() 메서드 호출
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				receiveMessage();
			}
		}).start();
	}
	
	public String prepareConnect() {
		// 서버 접속을 위한 패스워드 입력
		// => 아무 입력 없이 확인을 눌렀을 경우("" 입력 시) 
		// 다이얼로그를 사용하여 "패스워드 입력 필수!" 출력 후 다시 입력 받기
		// => 단, password 가 null 이 아닐 때만 판별 수행
		String password = JOptionPane.showInputDialog(this, "패스워드 입력");
		
		while(password != null && password.equals("")) {
			JOptionPane.showMessageDialog(
					this, "패스워드 입력 필수!", "경고", JOptionPane.WARNING_MESSAGE);
			password = JOptionPane.showInputDialog(this, "패스워드 입력");
		}
		
		// 취소 버튼 눌렀을 경우(null 입력 시) 
		// ConfirmDialog 를 사용하여 "종료하시겠습니까?" 질문에 예/아니오 선택받기
		if(password == null) {
			int confirm = JOptionPane.showConfirmDialog(
					this, "종료하시겠습니까?", "종료 확인", JOptionPane.YES_NO_OPTION);
//					System.out.println(confirm);
			// 선택된 버튼의 값을 JOptionPane.XXX_OPTION 상수와 비교
			if(confirm == JOptionPane.YES_OPTION) { // 예(Y) 선택 시 현재 프로그램 종료
				System.exit(0); // 프로그램 강제 종료(정상적인 강제 종료)
			}
			
			return null;
		}
		
		// 입력된 패스워드 리턴
		return password;
	}
	
	public boolean connectServer(String password) {
		try {
			ta.append("채팅 서버에 접속을 시도중입니다...\n");
			// Socket 객체를 생성하여 IP주소와 포트번호 전달 => 서버 접속 시도
			socket = new Socket("localhost", 59876);
			
			// DataOutputStream 객체 생성 후 패스워드 출력
			dos = new DataOutputStream(socket.getOutputStream());
			dos.writeUTF(password);
			ta.append("서버 접속 완료!\n");
			
			ta.append("패스워드 확인중...\n");
			// DataInputStream 객체 생성 후 전달받은 접속 요청 결과 출력
			dis = new DataInputStream(socket.getInputStream());
			
			boolean connectResult = dis.readBoolean();
//			System.out.println(connectResult);
			
			// 전달받은 접속 요청 결과 판별
			if(!connectResult) {
				ta.append("패스워드 불일치로 접속 실패!\n");
				return false;
			} else {
				lblStatus.setText("서버 연결 상태 : 연결됨!\n");
				connectStatus = true;
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return true;
		
	}
	
	public void receiveMessage() {
		// 멀티쓰레딩으로 메세지 수신 처리 작업 수행
		// boolean 타입 멤버변수 stopSignal 이 false 일 동안 반복해서 메세지 수신
		try {
			while(!stopSignal) {
				// 서버가 writeUTF() 메서드로 전송한 메세지를 입력받아 출력
				ta.append("서버 : " + dis.readUTF() + "\n");
			}
			
			// stopSignal 이 true 가 되면 메세지 수신 종료되므로 dis 와 socket 반환
			dis.close();
			socket.close();
		} catch (EOFException e) {
			// 상대방이 접속 해제할 경우 소켓이 제거되면서 발생하는 예외
			ta.append("서버 접속이 해제되었습니다!\n");
			lblStatus.setText("서버 연결 상태 : 미연결");
			connectStatus = false;
		} catch (SocketException e) {
			ta.append("서버 접속이 해제되었습니다!\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendMessage() {
		try {
			// 입력받은 메세지를 텍스트에어리어에 출력
			String msg = tf.getText();
			ta.append(msg + "\n");
			
			if(msg.equals("/exit")) { // 입력된 메세지가 "/exit" 일 경우
				// 텍스트에어리어에 "bye" 출력 후 
				// stopSignal 을 true 로 설정, 스트림 반환, 소켓 반환
				stopSignal = true;
				dos.close();
				socket.close();
				// 프로그램 종료
				System.exit(0);
			} else { // 입력된 메세지가 "/exit" 가 아닐 경우(전송할 메세지인 경우)
				// 클라이언트에게 메세지 전송
				dos.writeUTF(msg);
				
				// 텍스트필드 초기화 및 커서 요청
				tf.setText("");
				tf.requestFocus();
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new SimpleChatClient();
	}

}
