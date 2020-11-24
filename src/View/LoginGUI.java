package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Image; // 이미지 불러오기
import javax.swing.Icon;
import javax.swing.border.*; // 테두리 지우는거

import Model.MembershipDAO;
import Model.MembershipDTO;
import oracle.net.aso.g;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import java.awt.Toolkit;

public class LoginGUI {

	private JFrame frame;
	private JTextField tf_login_id;
	private JPasswordField pf_login_pw;
	JButton btn_join;
	
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
					LoginGUI window = new LoginGUI();
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
	public LoginGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\SMT032\\Desktop\\\uC774\uBBF8\uC9C0\\icon_Party.png"));
		frame.setResizable(false); // 창크기 조절 X
		
		frame.setBounds(100, 100, 435, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// 로그인 배경
		
		JPanel Image_panel = new JPanel(); 
		
		Image_panel.setBounds(0, 0, 429, 665);
		frame.getContentPane().add(Image_panel);
		Image_panel.setLayout(null);
		
		// 아이디 입력창
		tf_login_id = new JTextField();
		tf_login_id.setFont(new Font("돋움체", Font.BOLD, 20));
		tf_login_id.setBounds(172, 266, 184, 24);
		Image_panel.add(tf_login_id);
		tf_login_id.setColumns(10);
		tf_login_id.setBorder(null);
		tf_login_id.setBackground(new Color(224, 220, 243));
	
		// 패스워드 입력창
		pf_login_pw = new JPasswordField();
		pf_login_pw.setFont(new Font("돋움체", Font.BOLD, 20));
		pf_login_pw.setBounds(172, 366, 184, 24);
		Image_panel.add(pf_login_pw);
		pf_login_pw.setColumns(10);
		pf_login_pw.setBorder(null);
		pf_login_pw.setBackground(new Color(235,221,238));
		
		
		// 로그인 버튼 
		JButton btn_login = new JButton("\uB85C\uADF8\uC778");
		btn_login.setForeground(Color.BLACK);
		btn_login.setBounds(72, 489, 300, 31);
		Image_panel.add(btn_login);
		
		btn_login.addMouseListener(new MouseAdapter() {
			@Override // 마우스가 버튼 안으로 들어오면 글씨가 지정색으로 바뀜
			public void mouseEntered(MouseEvent e) {
				JButton btn_login = (JButton) e.getSource();
				btn_login.setForeground(Color.magenta);
			}

			@Override // 마우스가 버튼 밖으로 나가면 검은글씨로 바뀜
			public void mouseExited(MouseEvent e) {
				JButton btn_login = (JButton) e.getSource();
				btn_login.setForeground(Color.black);
			}
		});
		
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MembershipDAO dao = new MembershipDAO();
				String id = tf_login_id.getText(); // 아이디 입력 훕 맞는지 비교
				String pw = pf_login_pw.getText(); // 비밀번호 입력 후 맞는지 비교
				MembershipDTO dto = dao.loginSelect(id, pw);
				
				System.out.println(dto);
				
				if(dto == null) {
					// 다이얼로그띄우기
					// 에러메세기 -> 4개 매개변수                                 메세지 , 타이틀 , 메세지 종류(에러타입으로 넣을꺼야)
					JOptionPane.showMessageDialog(null, "로그인 실패", "로그인", JOptionPane.ERROR_MESSAGE);
					pf_login_pw.setText(""); //로그인 실패시 비밀번호 지우기
				}else { // 로그인 성공시
					JOptionPane.showMessageDialog(null, "환영합니다^^", "로그인", JOptionPane.PLAIN_MESSAGE);
					frame.dispose();
					mainGUI mn = new mainGUI();
					
				}
				
			}
		});
		btn_login.setFont(new Font("한컴 고딕", Font.BOLD, 18));
		btn_login.setBackground(Color.WHITE);
		btn_login.setBorderPainted(false); // 테두리 삭제
		btn_login.setFocusPainted(false); // 포커스 표시 삭제
		btn_login.setContentAreaFilled(false); // 버튼 배경 투명하게 하기
		
		// 회원가입 버튼 누르면 ==> 회원가입 창 켜짐
		btn_join = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btn_join.setForeground(Color.BLACK);
		btn_join.setBounds(72, 568, 300, 27);
		Image_panel.add(btn_join);
		
		btn_join.addMouseListener(new MouseAdapter() {
			@Override // 마우스가 버튼 안으로 들어오면 글씨가 지정색으로 바뀜
			public void mouseEntered(MouseEvent e) {
				JButton btn_join = (JButton) e.getSource();
				btn_join.setForeground(Color.magenta);
			}

			@Override // 마우스가 버튼 밖으로 나가면 검은글씨로 바뀜
			public void mouseExited(MouseEvent e) {
				JButton btn_join = (JButton) e.getSource();
				btn_join.setForeground(Color.black);
			}
		});
		
		btn_join.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose(); // 현재창 꺼짐
				MembershipGUI join = new MembershipGUI(); 
				
			}
		});
		btn_join.setFont(new Font("한컴 고딕", Font.BOLD, 18));
		btn_join.setBorderPainted(false); // 테두리 삭제
		btn_join.setFocusPainted(false); // 포커스 표시 삭제
		btn_join.setContentAreaFilled(false); // 버튼 배경 투명하게 하기
		
		
		// 로그인 페이지 배경
		JLabel lbl_Background = new JLabel("");
		imgPath = "image/login.png";

		originIcon = new ImageIcon(imgPath); // 이미지 크기 맞추기
		originImg = originIcon.getImage();
		changedImg = originImg.getScaledInstance(435, 700, Image.SCALE_SMOOTH);
		ficon = new ImageIcon(changedImg);
		lbl_Background.setIcon(ficon);
		
		lbl_Background.setBounds(0, 0, 435, 700);
		Image_panel.add(lbl_Background);
		
		
		
		
	}
}
