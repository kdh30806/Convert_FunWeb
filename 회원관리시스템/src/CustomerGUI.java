import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

public class CustomerGUI extends JFrame {
	private JTextField tfDBIP, tfDBUsername;
    private JPasswordField pfDBPassword;
    private JTextField tfIdx, tfName, tfId, tfPassword, tfJumin;
    private JButton btnLogin, btnInsert, btnSelect, btnDelete;
    private String dbIP, dbUsername, dbPassword; // DB 접속 정보 저장 변수
    private JScrollPane scrollPane;
    private JTable table;
    
    private boolean isLogin = false; // 로그인 여부 체크 변수
    
    public CustomerGUI() {
        showFrame();
    }
    
    public void showFrame() {
        setTitle("고객관리 프로그램");
        setBounds(500, 300, 900, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // ----------------------- 상단 데이터베이스 정보 입력 패널 -----------------------
        JPanel pNorth = new JPanel();
        pNorth.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
        getContentPane().add(pNorth, BorderLayout.NORTH);
        pNorth.setLayout(new GridLayout(0, 4, 0, 0));
        
        
        // Database IP 주소 입력 패널
        JPanel pDBIP = new JPanel();
        pNorth.add(pDBIP);
        
        pDBIP.add(new JLabel("IP"));
        
        tfDBIP = new JTextField("localhost"); // 편의상 임시로 주소 자동 입력
        pDBIP.add(tfDBIP);
        tfDBIP.setColumns(10);
        
        
        // Database 계정명 입력 패널
        JPanel pDBUsername = new JPanel();
        pNorth.add(pDBUsername);
        
        pDBUsername.add(new JLabel("Username"));
        
        tfDBUsername = new JTextField(""); // 편의상 임시로 계정명 자동 입력
        pDBUsername.add(tfDBUsername);
        tfDBUsername.setColumns(10);

        
        // Database 암호 입력 패널
        JPanel pDBPassword = new JPanel();
        pNorth.add(pDBPassword);
        
        pDBPassword.add(new JLabel("Password"));
        
        pfDBPassword = new JPasswordField();
        pDBPassword.add(pfDBPassword);
        pfDBPassword.setColumns(10);
        
        
        btnLogin = new JButton("Login");
        pNorth.add(btnLogin);
        
        // ----------------------- 좌측 회원가입 정보 입력 패널 ----------------------- 
        JPanel pWest = new JPanel();
        pWest.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
        getContentPane().add(pWest, BorderLayout.WEST);
        pWest.setLayout(new GridLayout(5, 0, 0, 0));

        
        // 번호 입력 패널
        JPanel pIdx = new JPanel();
        FlowLayout flowLayout = (FlowLayout) pIdx.getLayout();
        flowLayout.setAlignment(FlowLayout.RIGHT);
        pWest.add(pIdx);
        
        pIdx.add(new JLabel("번 호"));
        
        tfIdx = new JTextField();
        tfIdx.setEditable(false); // 번호 입력 못하도록 잠금
        pIdx.add(tfIdx);
        tfIdx.setColumns(10);
        
        
        // 이름 입력 패널
        JPanel pName = new JPanel();
        FlowLayout flowLayout_1 = (FlowLayout) pName.getLayout();
        flowLayout_1.setAlignment(FlowLayout.RIGHT);
        pWest.add(pName);
        
        pName.add(new JLabel("이 름"));
        
        tfName = new JTextField();
        pName.add(tfName);
        tfName.setColumns(10);
        
        
        // 아이디 입력 패널
        JPanel pId = new JPanel();
        FlowLayout flowLayout_2 = (FlowLayout) pId.getLayout();
        flowLayout_2.setAlignment(FlowLayout.RIGHT);
        pWest.add(pId);
        
        pId.add(new JLabel("아이디"));
        
        tfId = new JTextField();
        pId.add(tfId);
        tfId.setColumns(10);

        
        // 패스워드 입력 패널
        JPanel pPassword = new JPanel();
        FlowLayout flowLayout_3 = (FlowLayout) pPassword.getLayout();
        flowLayout_3.setAlignment(FlowLayout.RIGHT);
        pWest.add(pPassword);
        
        pPassword.add(new JLabel("패스워드"));
        
        tfPassword = new JTextField();
        pPassword.add(tfPassword);
        tfPassword.setColumns(10);
        
        
        // 주민번호 입력 패널
        JPanel pJumin = new JPanel();
        FlowLayout flowLayout_4 = (FlowLayout) pJumin.getLayout();
        flowLayout_4.setAlignment(FlowLayout.RIGHT);
        pWest.add(pJumin);
        
        pJumin.add(new JLabel("주민번호"));
        
        tfJumin = new JTextField();
        pJumin.add(tfJumin);
        tfJumin.setColumns(10);
        
        

        
        // ----------------------- 하단 버튼 패널 ----------------------- 
        JPanel pSouth = new JPanel();
        pSouth.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
        getContentPane().add(pSouth, BorderLayout.SOUTH);
        
        btnInsert = new JButton("회원추가");
        pSouth.add(btnInsert);
        
        btnSelect = new JButton("회원목록");
        pSouth.add(btnSelect);
        
        btnDelete = new JButton("회원삭제");
        pSouth.add(btnDelete);
        
        
        // ---------------------- 테이블이 표시될 CENTER 영역 ---------------------
        // 미리 JTable 객체를 생성해놓고 차후에 DefaultTableModel에 새로운 데이터 레코드만 추가하기
        scrollPane = new JScrollPane();
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        table = new JTable();
        table.getTableHeader().setReorderingAllowed(false); // 셀 고정
        
        scrollPane.setViewportView(table);
        
        // 테이블 컬럼명 초기 설정
        Vector<String> columnNames = new Vector<String>(
        		Arrays.asList("번 호", "이 름", "나 이", "E-Mail", "주민번호")); 
//        DefaultTableModel dtm = new DefaultTableModel(columnNames, 0); // 컬럼명 추가
        // 테이블 셀 편집이 불가능하도록 설정할 경우
        DefaultTableModel dtm = new DefaultTableModel(columnNames, 0) {
        	// isCellEditable() 메서드 오버라이딩하여 false 리턴
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
        	
        };
        
        table.setModel(dtm); // 모델 객체 테이블에 추가
        
        setVisible(true);
        
        // ----------------------- 이벤트 처리 --------------------------
        btnLogin.addActionListener(listener);
        btnInsert.addActionListener(listener);
        btnDelete.addActionListener(listener);
        btnSelect.addActionListener(listener);
        
        // 테이블 마우스 클릭 시 동작하는 MouseListener 연결
        table.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// 마우스 클릭 시 회원 정보를 표시할 메서드 호출
				showCustomerInfo();
			}
        	
		});
        
    }
    
    // 버튼 구별하여 각 메서드 호출
    ActionListener listener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnLogin) {
				login();
			} else if(e.getSource() == btnInsert) {
				insert();
			} else if(e.getSource() == btnDelete) {
				delete();
			} else if(e.getSource() == btnSelect) {
				select();
			}
		}
	};
	
	// DB 로그인 기능
	public void login() {
		// 현재 로그인 여부를 판별하여 로그인 상태가 아닐 때 로그인 작업 수행하고,
		// 로그인 상태일 때 로그아웃 작업 수행
		if(!isLogin) { // 로그인 상태가 아닐 경우 로그인 작업 수행
			String dbIp = tfDBIP.getText();
			String dbUsername = tfDBUsername.getText();
			String dbPassword = new String(pfDBPassword.getPassword());
			
			if(dbIp.length() <= 0) {
				JOptionPane.showMessageDialog(
						this, "서버 IP 주소를 입력하세요.", "실패", JOptionPane.WARNING_MESSAGE);
				tfDBIP.requestFocus(); // 해당 텍스트필드에 커서 요청
				return;
			} else if(!(dbUsername.equals("admin"))) {
				JOptionPane.showMessageDialog(
						this, "괸리자가 아닙니다!!", "실패", JOptionPane.WARNING_MESSAGE);
				tfDBUsername.requestFocus(); // 해당 텍스트필드에 커서 요청
			}else if(dbUsername.length() <= 0) {
				JOptionPane.showMessageDialog(
						this, "로그인 ID 를 입력하세요.", "실패", JOptionPane.WARNING_MESSAGE);
				tfDBUsername.requestFocus(); // 해당 텍스트필드에 커서 요청
				return;
			} else if(dbPassword.length() <= 0) {
				JOptionPane.showMessageDialog(
						this, "로그인 Password 를 입력하세요.", "실패", JOptionPane.WARNING_MESSAGE);
				pfDBPassword.requestFocus(); // 해당 텍스트필드에 커서 요청
				return;
			} 
			
			// 입력 확인됐을 때 customer 테이블의 ID, Password 사용하여 로그인 수행
			// 로그인 실패 시 "로그인 실패!" 메세지 출력하고 return
			// 로그인 성공 시 IP, ID, Password 입력창 잠금 설정 후
			// Login 버튼 텍스트를 Logout 으로 변경
			// => CustomerDAO 객체의 login() 메서드를 호출하여 수행
			CustomerDAO dao = CustomerDAO.getInstance();
			
			try {
				boolean result = dao.login(dbIp, dbUsername, dbPassword);
				
				// 로그인 성공(result == true) 시 메세지 출력 및 잠금 설정, 버튼 텍스트 변경
				JOptionPane.showMessageDialog(this, "로그인 성공!");
				tfDBIP.setEditable(false);
				tfDBUsername.setEditable(false);
				pfDBPassword.setEditable(false);
				btnLogin.setText("Logout");
				
				isLogin = true;
			} catch (LoginFailException e) {
				// 로그인 실패(예외 발생) 시 예외 메세지를 출력
				JOptionPane.showMessageDialog(
						this, "로그인 실패 : " + e.getMessage(), "오류", JOptionPane.ERROR_MESSAGE);
			}
		} else { // 로그인 상태일 경우 로그아웃 작업 수행
			// Logout 버튼 텍스트를 Login 으로 변경
			btnLogin.setText("Login");
			// DB 접속을 위한 ID 와 패스워드 입력창 편집 가능하도록 변경 및 패스워드 제거
			tfDBUsername.setEditable(true);
			pfDBPassword.setEditable(true);
			pfDBPassword.setText("");
			// isLogin 변수값을 false 로 변경 및 "로그아웃 성공!" 메세지 출력
			isLogin = false;
			JOptionPane.showMessageDialog(this, "로그아웃 성공!");
		}
		
	}
	
	public void insert() { // 회원추가 버튼 클릭 시 호출되는 메서드
		// 로그인 상태가 아니면 메서드 수행 종료
		if(!isLogin) { // 또는 btnLogin.getText().equals("Logout")
			JOptionPane.showMessageDialog(
                    this, "로그인 필수!", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		// 입력받은 데이터 가져오기
		String name = tfName.getText();
		String id = tfId.getText();
		String password = tfPassword.getText();
		String jumin = tfJumin.getText();
		
        if(name.length() <= 0) {
        	JOptionPane.showMessageDialog(
                    this, "이름을 입력하세요.", "실패", JOptionPane.WARNING_MESSAGE);
            tfName.requestFocus(); // 해당 텍스트필드에 커서 요청
            return;
        } else if(id.length() <= 0) {
        	JOptionPane.showMessageDialog(
        			this, "나이를 입력하세요.", "실패", JOptionPane.WARNING_MESSAGE);
        	tfId.requestFocus(); // 해당 텍스트필드에 커서 요청
            return;
        } else if(password.length() <= 0) {
        	JOptionPane.showMessageDialog(
        			this, "E-mail을 입력하세요.", "실패", JOptionPane.WARNING_MESSAGE);
            tfPassword.requestFocus(); // 해당 텍스트필드에 커서 요청
            return;
        } else if(jumin.length() <= 0) {
        	JOptionPane.showMessageDialog(
        			this, "주민번호를 입력하세요.", "실패", JOptionPane.WARNING_MESSAGE);
            tfJumin.requestFocus(); // 해당 텍스트필드에 커서 요청
            return;
        }
        
        // CustomerDAO 인스턴스 가져오기
        CustomerDAO dao = CustomerDAO.getInstance();
        
        // DAO 객체의 insert() 메서드를 호출하여 입력받은 데이터를 전달
        boolean result = dao.insert(name, id, password, jumin);
        
        if(result) {
        	JOptionPane.showMessageDialog(this, "회원추가 성공!");
        	// 입력된 회원 정보창 초기화
        	tfName.setText("");
        	tfId.setText("");
        	tfPassword.setText("");
        	tfJumin.setText("");
        } else {
        	JOptionPane.showMessageDialog(this, "회원추가 실패!");
        }
        
        // 새로운 테이블 정보 갱신
        select();
        
	}
    
	public void delete() {
		// 로그인 상태가 아니면 메서드 수행 종료
		if(!isLogin) { // 또는 btnLogin.getText().equals("Logout")
			JOptionPane.showMessageDialog(
	                this, "로그인 필수!", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}
				
				
		// 삭제할 회원번호를 입력받는 다이얼로그 표시를 위해
		// JOptionPane 객체의 showInputDialog() 메서드 호출
		// => 입력받은 데이터는 String 타입으로 리턴됨
		// => 데이터 입력 없이 확인 버튼 누르면 널스트링("") 리턴됨
		// => 취소 버튼 클릭 시 null 리턴됨
		String inputData = JOptionPane.showInputDialog(this, "삭제할 회원 번호를 입력하세요");
//		System.out.println("입력된 번호 : " + inputData);
		
		// 리턴값이 null 일 경우 현재 메서드 그냥 종료(return)
		// 널스트링("") 일 경우 "삭제할 번호를 입력하세요" 메세지 출력 후 return
		
		// 입력값이 null 이면 입력 종료, 입력값의 길이가 0이면 입력 요청 반복
		while(inputData == null || inputData.length() == 0) {
			if(inputData == null) {
				return;
			} else if(inputData.length() == 0) {
				JOptionPane.showMessageDialog(
	        			this, "삭제할 번호를 입력하세요.", "입력 오류", JOptionPane.WARNING_MESSAGE);
				inputData = JOptionPane.showInputDialog(this, "삭제할 회원 번호를 입력하세요");
			} 
			
			
		}
		
		// 입력된 데이터가 숫자일 때만 처리 
		String regex = "^[0-9]{1,}$";
		if(!Pattern.matches(regex, inputData)) { // 정규표현식에 맞지 않을 경우
			JOptionPane.showMessageDialog(
        			this, "번호만 입력 가능!", "입력 오류", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		int idx = Integer.parseInt(inputData); // 문자열 -> 정수 변환
		
		// 입력된 데이터가 있을 경우
		// DAO 객체의 delete() 메서드를 호출하여 삭제할 번호 전달 후 결과 리턴
		// CustomerDAO 인스턴스 가져오기
        CustomerDAO dao = CustomerDAO.getInstance();
        
        boolean result = dao.delete(idx);
        
        if(result) {
        	JOptionPane.showMessageDialog(this, "회원삭제 성공!");
        } else {
        	JOptionPane.showMessageDialog(this, "회원삭제 실패!");
        }
        
        // 새로운 테이블 정보 갱신
        select();
		
	}
	
	
	public void select() {
		// 로그인 상태가 아니면 메서드 수행 종료
		if(!isLogin) { // 또는 btnLogin.getText().equals("Logout")
			JOptionPane.showMessageDialog(
	                this, "로그인 필수!", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		
		// DAO 객체의 select() 메서드를 호출하여 전체 회원 정보를 Vector 객체로 리턴받기
		// => 리턴받은 Vector 객체 내의 모든 정보 출력
		// CustomerDAO 인스턴스 가져오기
        CustomerDAO dao = CustomerDAO.getInstance();
        
        Vector<Vector> data = dao.select();
        
        // 기존 테이블(JTable) 객체로부터 DefaultTableModel 객체 가져오기(형변환 필요)
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        dtm.setRowCount(0); // 모델 객체의 rowCount 를 0으로 초기화
        
        for(Vector rowData : data) {
//        	System.out.println(rowData);
        	// 1개 레코드 데이터인 Vector 객체(rowData)를 
        	// addRow() 메서드를 호출하여 바로 DefaultTableModel 객체에 추가
        	// => 단, 데이터를 추가하기 전 객체 생성 후 rowCount 를 0 으로 초기화 필수!
        	dtm.addRow(rowData);
        }
		
	}
	
	
	public void showCustomerInfo() {
//		System.out.println("Click");
		
		// 클릭된 테이블의 행과 열 번호 가져오기
//		System.out.println(table.getSelectedRow() + ", " + table.getSelectedColumn());
		
		// 클릭된 셀(행, 열)에 해당하는 값 가져오기
//		System.out.println(
//				table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()));
		
		// 클릭된 셀의 행번로를 고정하여 0 ~ 4번열 까지 데이터를 
		// 좌측 회원정보 입력 텍스트필드에 차례대로 표시
		// => 단, getValueAt() 메서드 리턴타입이 Object 이므로 String 타입으로 변환 필요
		tfIdx.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
		tfName.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
		tfId.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
		tfPassword.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
		tfJumin.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
		
	}
	
    
    public static void main(String[] args) {
		new CustomerGUI();
	}

}














