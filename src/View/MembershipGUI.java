package View;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;	
import javax.swing.JTextField;

import Model.MembershipDAO;
import Model.MembershipDTO;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;




public class MembershipGUI {

	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null; // 나중에 셀렉트문 들어올것을 대비해서 전역변수
	
	
	private JFrame frame;
	private JTextField tf_id;
	private JPasswordField pf_pw;
	private JPasswordField pf_pwcheck;
	private JTextField tf_email;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	
	JButton btn_join;
	JButton btn_id_overlap;
	
	// 이미지 크기 맞출때 필요
		public String imgPath;
		public ImageIcon originIcon;
		public Image originImg;
		public Image changedImg;
		public ImageIcon ficon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MembershipGUI window = new MembershipGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MembershipGUI() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {   // 아래 코드 복사해서 창크기 통일!!
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\SMT032\\Desktop\\\uC774\uBBF8\uC9C0\\icon_Party.png"));
		frame.setResizable(false); // 창크기 조절 X
		frame.setBounds(100, 100, 435, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC544\uC774\uB514");
		lblNewLabel.setFont(new Font("한컴 고딕", Font.BOLD, 16));
		lblNewLabel.setBounds(46, 91, 62, 18);
		frame.getContentPane().add(lblNewLabel);
		
		tf_id = new JTextField();
		tf_id.setFont(new Font("굴림", Font.PLAIN, 16));
		tf_id.setBounds(159, 91, 192, 24);
		frame.getContentPane().add(tf_id);
		tf_id.setColumns(10);
		
		JLabel label = new JLabel("\uBE44\uBC00\uBC88\uD638");
		label.setFont(new Font("한컴 고딕", Font.BOLD, 16));
		label.setBounds(46, 178, 89, 18);
		frame.getContentPane().add(label);
		
		pf_pw = new JPasswordField();
		pf_pw.setFont(new Font("굴림", Font.PLAIN, 16));
		pf_pw.setBounds(159, 178, 192, 24);
		frame.getContentPane().add(pf_pw);
		
		JLabel label_1 = new JLabel("\uBE44\uBC00\uBC88\uD638 \uD655\uC778");
		label_1.setFont(new Font("한컴 고딕", Font.BOLD, 16));
		label_1.setBounds(46, 214, 108, 18);
		frame.getContentPane().add(label_1);
		
		pf_pwcheck = new JPasswordField();
		pf_pwcheck.setFont(new Font("굴림", Font.PLAIN, 16));
		pf_pwcheck.setBounds(159, 217, 192, 24);
		frame.getContentPane().add(pf_pwcheck);
		
		JLabel lbl_sex = new JLabel("\uC131   \uBCC4");
		lbl_sex.setFont(new Font("한컴 고딕", Font.BOLD, 16));
		lbl_sex.setBounds(46, 265, 62, 18);
		frame.getContentPane().add(lbl_sex);
		
		// 성별 체크박스 (여)
		JRadioButton rb_woman = new JRadioButton("\uC5EC");
		rb_woman.setFont(new Font("굴림", Font.PLAIN, 16));
		buttonGroup.add(rb_woman);
		rb_woman.setSelected(true);
		rb_woman.setBounds(160, 267, 62, 27);
		frame.getContentPane().add(rb_woman);
		rb_woman.setBorderPainted(false); // 테두리 삭제
		rb_woman.setFocusPainted(false); // 포커스 표시 삭제
		rb_woman.setContentAreaFilled(false); // 버튼 배경 투명하게 하기
		
		// 성별 체크박스 (남)
		JRadioButton rb_man = new JRadioButton("\uB0A8");
		rb_man.setFont(new Font("굴림", Font.PLAIN, 16));
		buttonGroup.add(rb_man);
		rb_man.setBounds(252, 267, 62, 27);
		frame.getContentPane().add(rb_man);
		rb_man.setBorderPainted(false); // 테두리 삭제
		rb_man.setFocusPainted(false); // 포커스 표시 삭제
		rb_man.setContentAreaFilled(false); // 버튼 배경 투명하게 하기
		
		JLabel label_2 = new JLabel("\uC774\uBA54\uC77C");
		label_2.setFont(new Font("한컴 고딕", Font.BOLD, 16));
		label_2.setBounds(46, 309, 89, 18);
		frame.getContentPane().add(label_2);
		
		JLabel lbl_agegroup = new JLabel("\uC5F0\uB839\uB300");
		lbl_agegroup.setFont(new Font("한컴 고딕", Font.BOLD, 16));
		lbl_agegroup.setBounds(46, 369, 89, 18);
		frame.getContentPane().add(lbl_agegroup);
		
		// 연령대 체크 박스 => 10대, 20대, 30대, 40대, 50대, 60대~
		JCheckBox cb_age10s = new JCheckBox("10\uB300");
		cb_age10s.setFont(new Font("굴림", Font.PLAIN, 16));
		cb_age10s.setBounds(119, 371, 74, 27);
		frame.getContentPane().add(cb_age10s);
		cb_age10s.setBorderPainted(false); // 테두리 삭제
		cb_age10s.setFocusPainted(false); // 포커스 표시 삭제
		cb_age10s.setContentAreaFilled(false); // 버튼 배경 투명하게 하기
		
		JCheckBox cb_age20s = new JCheckBox("20\uB300");
		cb_age20s.setFont(new Font("굴림", Font.PLAIN, 16));
		cb_age20s.setBounds(199, 371, 74, 27);
		frame.getContentPane().add(cb_age20s);
		cb_age20s.setBorderPainted(false); // 테두리 삭제
		cb_age20s.setFocusPainted(false); // 포커스 표시 삭제
		cb_age20s.setContentAreaFilled(false); // 버튼 배경 투명하게 하기
		
		JCheckBox cb_age30s = new JCheckBox("30\uB300");
		cb_age30s.setFont(new Font("굴림", Font.PLAIN, 16));
		cb_age30s.setBounds(277, 371, 74, 27);
		frame.getContentPane().add(cb_age30s);
		cb_age30s.setBorderPainted(false); // 테두리 삭제
		cb_age30s.setFocusPainted(false); // 포커스 표시 삭제
		cb_age30s.setContentAreaFilled(false); // 버튼 배경 투명하게 하기
		
		JCheckBox cb_age40s = new JCheckBox("40\uB300");
		cb_age40s.setFont(new Font("굴림", Font.PLAIN, 16));
		cb_age40s.setBounds(119, 401, 74, 27);
		frame.getContentPane().add(cb_age40s);
		cb_age40s.setBorderPainted(false); // 테두리 삭제
		cb_age40s.setFocusPainted(false); // 포커스 표시 삭제
		cb_age40s.setContentAreaFilled(false); // 버튼 배경 투명하게 하기
		
		JCheckBox cb_age50s = new JCheckBox("50\uB300");
		cb_age50s.setFont(new Font("굴림", Font.PLAIN, 16));
		cb_age50s.setBounds(199, 401, 74, 27);
		frame.getContentPane().add(cb_age50s);
		cb_age50s.setBorderPainted(false); // 테두리 삭제
		cb_age50s.setFocusPainted(false); // 포커스 표시 삭제
		cb_age50s.setContentAreaFilled(false); // 버튼 배경 투명하게 하기
		
		JCheckBox cb_age60s = new JCheckBox("60\uB300~");
		cb_age60s.setFont(new Font("굴림", Font.PLAIN, 16));
		cb_age60s.setBounds(277, 401, 74, 27);
		frame.getContentPane().add(cb_age60s);
		cb_age60s.setBorderPainted(false); // 테두리 삭제
		cb_age60s.setFocusPainted(false); // 포커스 표시 삭제
		cb_age60s.setContentAreaFilled(false); // 버튼 배경 투명하게 하기
		
		// 중복확인 버튼
		btn_id_overlap = new JButton("\uC911\uBCF5\uD655\uC778");
		btn_id_overlap.setBackground(Color.WHITE);
		btn_id_overlap.setFont(new Font("한컴 고딕", Font.BOLD, 13));
		btn_id_overlap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = tf_id.getText();
				MembershipDAO dao = new MembershipDAO();
				boolean result = dao.idoverlap(id);	
				
				System.out.println(result);
				
				if(result) {                       
					JOptionPane.showMessageDialog(null, "이미 사용중인 ID입니다.", "중복확인", JOptionPane.ERROR_MESSAGE);
					tf_id.setText(""); //중복시 id 지우기
				} else if(id.equals("")) { 
					JOptionPane.showMessageDialog(null, "아이디를 입력하세요.", "중복확인", JOptionPane.ERROR_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "사용가능한 ID입니다.", "중복확인", JOptionPane.PLAIN_MESSAGE);
		          
			System.out.println(1234);
				}
			}
		});
		btn_id_overlap.setBounds(262, 118, 89, 24);
		frame.getContentPane().add(btn_id_overlap);
		
		
		// 회원가입 버튼
				btn_join = new JButton("\uD68C\uC6D0\uAC00\uC785");
				btn_join.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						MembershipDAO dao = new MembershipDAO();
						
						String id = tf_id.getText(); 
						String pw = pf_pw.getText();
						String pwcheck = pf_pwcheck.getText();
					    String email = tf_email.getText();
					   
					    String sex =null;
					    if(rb_woman.isSelected()) {
					    	 sex = rb_woman.getText();
					    } else {
					    	sex = rb_man.getText();
					    }
					    String agegroup = null;
					    if(cb_age10s.isSelected()) {
					    	agegroup = cb_age10s.getText();
					    }else if(cb_age20s.isSelected()) {
					    	agegroup = cb_age20s.getText();
					    }else if(cb_age30s.isSelected()) {
					    	agegroup = cb_age30s.getText();
					    }else if(cb_age40s.isSelected()) {
					    	agegroup = cb_age40s.getText();
					    }else if(cb_age50s.isSelected()) {
					    	agegroup = cb_age50s.getText();
					    }else {
					    	agegroup = cb_age60s.getText();
					    }
					   
							    
					    MembershipDTO dto = new MembershipDTO(id, pw, pwcheck, sex, email, agegroup);
						int cnt = dao.insertMember(dto);
		
						if(cnt == 0 ||id.equals("") || pw.equals("") || pwcheck.equals("") || email.equals("")) {
							// 다이얼로그띄우기
							// 에러메세기 -> 4개 매개변수                                 메세지 , 타이틀 , 메세지 종류(에러타입으로 넣을꺼야)
							JOptionPane.showMessageDialog(null, "회원가입 실패!! 모든 항목 입력하세요", "회원가입", JOptionPane.ERROR_MESSAGE);
						
						}else {
							JOptionPane.showMessageDialog(null, "회원가입 성공!", "회원가입", JOptionPane.PLAIN_MESSAGE);
				               frame.dispose();//로그인 성공시 메인창으로 다시돌아가기
				          
					
						}
					}
				
	
		});
		btn_join.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btn_join.setBackground(Color.WHITE);
		btn_join.setForeground(Color.BLACK);
		btn_join.setBounds(252, 587, 130, 38);
		frame.getContentPane().add(btn_join);
		
		tf_email = new JTextField();
		tf_email.setFont(new Font("굴림", Font.PLAIN, 16));
		tf_email.setColumns(10);
		tf_email.setBounds(159, 313, 192, 24);
		frame.getContentPane().add(tf_email);
		
		// 뒤로가기 버튼
		JButton btnNewButton = new JButton("");
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 8));
		imgPath = "image/icon_left.png";

		originIcon = new ImageIcon(imgPath); // 이미지 크기 맞추기
		originImg = originIcon.getImage();
		changedImg = originImg.getScaledInstance(38, 38, Image.SCALE_SMOOTH);
		ficon = new ImageIcon(changedImg);
		btnNewButton.setIcon(ficon);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				LoginGUI logingui = new LoginGUI();  //로그인 화면으로 돌아가기
				
			}
		});
		
		btnNewButton.setContentAreaFilled(false); // 버튼 투명하게 하기
		btnNewButton.setBorderPainted(false); // 버튼 라인 없애기
		
		btnNewButton.setBounds(14, 12, 38, 38);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("\uD68C\uC6D0\uAC00\uC785");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("넥슨 풋볼고딕 B", Font.BOLD, 23));
		lblNewLabel_1.setBounds(159, 32, 135, 24);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lbl_Background = new JLabel("");
		imgPath = "image/info_Background.jpg";
		originIcon = new ImageIcon(imgPath); // 이미지 크기 맞추기
		originImg = originIcon.getImage();
		changedImg = originImg.getScaledInstance(435, 700, Image.SCALE_SMOOTH);
		ficon = new ImageIcon(changedImg);
		lbl_Background.setIcon(ficon);
		
		lbl_Background.setBounds(0, 0, 435, 700);
		frame.getContentPane().add(lbl_Background);
	}
}