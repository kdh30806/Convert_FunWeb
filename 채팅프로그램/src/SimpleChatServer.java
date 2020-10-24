

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

import javax.swing.JScrollPane;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;

public class SimpleChatServer extends JFrame {
	private JTextArea ta;
    private JTextField tf;
    private JLabel lblStatus;
    
    private ServerSocket serverSocket;
    private Socket socket;
    
    private DataInputStream dis;
    private DataOutputStream dos;
    
    private boolean connectStatus; // 클라이언트 접속 여부 저장
    private boolean stopSignal; // 쓰레드 종료 신호 저장
    
    private String password = "1234"; // 클라이언트에서 접속용으로 사용할 패스워드
    private JScrollPane scrollPane;
    
	public SimpleChatServer() {
		showFrame();
		startService(); // 채팅 서버 시작
	}
	
	public void showFrame() {
		setTitle("1:1 채팅 서버");
		setBounds(400, 400, 500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 채팅 서버 - 클라이언트 연결 상태를 표시할 JLabel
		lblStatus = new JLabel("클라이언트 연결 상태 : 연결 없음");
		getContentPane().add(lblStatus, BorderLayout.NORTH);
		
        // 채팅 메세지를 표시할 JTextArea - 텍스트 입력이 금지되도록 설정
        ta = new JTextArea();
        ta.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        ta.setEditable(false); // 텍스트 입력 금지
        ta.setBackground(Color.LIGHT_GRAY); // 배경색 변경
        
        tf = new JTextField();
        tf.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
        getContentPane().add(tf, BorderLayout.SOUTH);
        
        scrollPane = new JScrollPane();
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        scrollPane.setViewportView(ta);
        
        tf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				sendMessage();
			}
		});
		
		setVisible(true);
		
		tf.requestFocus(); // 현재 텍스트필드에 커서 요청
	}
	
	public void startService() {
		try {
			ta.append("채팅 서비스 준비중...\n");
			
			// ServerSocket 객체를 생성하여 지정된 포트(59876)를 개방
			serverSocket = new ServerSocket(59876);
			ta.append("서비스 준비 완료!\n");
			
			// 클라이언트로부터 접속이 성공할 때까지 접속 무한 대기
			connectStatus = false;
			
			while(!connectStatus) {
				ta.append("클라이언트 접속 대기중...\n");
				// ServerSocket 객체의 accept() 메서드를 호출하여 클라이언트 연결 대기
				// => 연결 완료 시 Socket 객체 리턴됨
				socket = serverSocket.accept();
				// 접속된 클라이언트에 대한 IP 주소 정보 출력
				ta.append("클라이언트가 접속하였습니다. (" + socket.getInetAddress() + ")\n");
				
				// DataInputStream 객체 생성 후 입력되는 패스워드 가져와서 출력
				dis = new DataInputStream(socket.getInputStream());
				String clientPassword = dis.readUTF();
//				System.out.println("전달된 패스워드 : " + clientPassword);
				
				// DataOutStream 객체 생성
				dos = new DataOutputStream(socket.getOutputStream());
				
				// 입력받은 패스워드와 저장된 패스워드 비교
				if(!clientPassword.equals(password)) { // 일치하지 않을 경우
//					dos.writeUTF("패스워드 불일치!");
					dos.writeBoolean(false);
					
					ta.append("클라이언트 패스워드 불일치로 접속 해제됨!\n");
				} else { // 일치할 경우
					connectStatus = true;
					ta.append("클라이언트 패스워드 일치!\n");
					lblStatus.setText("클라이언트 연결 상태 : 연결됨");
					// 클라이언트에게 성공(true) 값 전송
					dos.writeBoolean(true);
				}
			}
			
			// Runnable 인터페이스를 구현하여 Thread 객체에 전달 후 start() 메서드 호출
			
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					// 클라이언트로부터 전송되는 메세지를 처리할 receiveMessage() 메서드 호출
					receiveMessage();
				}
			}).start(); // => 바로 쓰레드 실행까지 처리됨
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void receiveMessage() {
		// 멀티쓰레딩으로 메세지 수신 처리 작업 수행
		// boolean 타입 멤버변수 stopSignal 이 false 일 동안 반복해서 메세지 수신
		try {
			while(!stopSignal) {
				// 클라이언트가 writeUTF() 메서드로 전송한 메세지를 입력받아 출력
				ta.append("클라이언트 : " + dis.readUTF() + "\n");
			}
			
			// stopSignal 이 true 가 되면 메세지 수신 종료되므로 dis 와 socket 반환
			dis.close();
			socket.close();
		} catch (EOFException e) {
			// 상대방이 접속 해제할 경우 소켓이 제거되면서 발생하는 예외
			ta.append("클라이언트 접속이 해제되었습니다!\n");
			lblStatus.setText("클라이언트 연결 상태 : 미연결");
			connectStatus = false;
		} catch (SocketException e) {
			ta.append("클라이언트 접속이 해제되었습니다!\n");
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
		new SimpleChatServer();
	}

}
