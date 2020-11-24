package View;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Model.Festival_DAO;
import Model.ListDAO;

import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import java.awt.Font;

public class Join_Festival {

	private JFrame frame;
	JTextPane tp_festName;
	JComboBox comboBox;
	JDateChooser date_start;
	JDateChooser date_last;
	JRadioButton btn_Place_0;
	JRadioButton btn_Place_1;
	JRadioButton btn_Place_2;
	JRadioButton btn_Place_3;
	JRadioButton btn_Place_4;
	JRadioButton btn_Place_5;
	JRadioButton btn_Theme_0;
	JRadioButton btn_Theme_1;
	JRadioButton btn_Theme_2;
	JRadioButton btn_Theme_3;
	JRadioButton btn_Theme_4;
	JRadioButton btn_Theme_5;
	JRadioButton btn_Who_0;
	JRadioButton btn_Who_1;
	JRadioButton btn_Who_2;
	JRadioButton btn_Who_3;
	JRadioButton btn_Who_4;

	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	JRadioButton[] arr = new JRadioButton[6];
	JRadioButton[] arr2 = new JRadioButton[6];
	JRadioButton[] arr3 = new JRadioButton[5];
	Festival_DAO dao = new Festival_DAO();
	ListDAO listdao = new ListDAO();
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Join_Festival window = new Join_Festival();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public Join_Festival() {
		initialize();
		frame.setVisible(true);
	}

	public static java.sql.Date convert(java.util.Date uDate){
		java.sql.Date sDate = new java.sql.Date(uDate.getTime());
		return sDate;
	} // util을 sql로 바꿔주는 메소드
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 455, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uCD95\uC81C\uB4F1\uB85D");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 10, 415, 56);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uCD95\uC81C\uBA85 : ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(6, 60, 93, 30);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel label = new JLabel("\uCD95\uC81C \uB0A0\uC9DC : ");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(22, 122, 93, 21);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\uC608\uC815 \uC7A5\uC18C : ");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(12, 162, 93, 30);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\uCD95\uC81C \uD14C\uB9C8 : ");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(12, 228, 93, 30);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\uCD5C\uC18C\uC778\uC6D0 : ");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(12, 293, 93, 30);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("\uCD95\uC81C \uAE30\uD68D\uC758\uB3C4 : ");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(12, 388, 93, 30);
		frame.getContentPane().add(label_4);
		
		 tp_festName = new JTextPane();
		tp_festName.setBounds(105, 60, 328, 21);
		frame.getContentPane().add(tp_festName);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setBounds(12, 428, 415, 139);
		frame.getContentPane().add(textPane_2);
		
		btn_Place_0 = new JRadioButton("\uAD11\uC8FC \uB3D9\uAD6C");
		buttonGroup.add(btn_Place_0);
		btn_Place_0.setBounds(99, 162, 93, 23);
		frame.getContentPane().add(btn_Place_0);
		btn_Place_0 .setContentAreaFilled(false); // 버튼 투명하게 하기
		btn_Place_0 .setBorderPainted(false); // 버튼 라인 없애기
		
		btn_Place_2 = new JRadioButton("\uAD11\uC8FC \uB0A8\uAD6C");
		buttonGroup.add(btn_Place_2);
		btn_Place_2.setBounds(310, 162, 93, 23);
		frame.getContentPane().add(btn_Place_2);
		btn_Place_2 .setContentAreaFilled(false); // 버튼 투명하게 하기
		btn_Place_2 .setBorderPainted(false); // 버튼 라인 없애기
		
		btn_Place_3 = new JRadioButton("\uAD11\uC8FC \uBD81\uAD6C");
		buttonGroup.add(btn_Place_3);
		btn_Place_3.setBounds(99, 194, 93, 23);
		frame.getContentPane().add(btn_Place_3);
		btn_Place_3 .setContentAreaFilled(false); // 버튼 투명하게 하기
		btn_Place_3 .setBorderPainted(false); // 버튼 라인 없애기
		
		btn_Place_1 = new JRadioButton("\uAD11\uC8FC \uC11C\uAD6C");
		buttonGroup.add(btn_Place_1);
		btn_Place_1.setBounds(196, 162, 93, 23);
		frame.getContentPane().add(btn_Place_1);
		btn_Place_1 .setContentAreaFilled(false); // 버튼 투명하게 하기
		btn_Place_1 .setBorderPainted(false); // 버튼 라인 없애기
		
		btn_Place_4 = new JRadioButton("\uAD11\uC8FC \uAD11\uC0B0\uAD6C");
		buttonGroup.add(btn_Place_4);
		btn_Place_4.setBounds(196, 194, 93, 23);
		frame.getContentPane().add(btn_Place_4);
		btn_Place_4 .setContentAreaFilled(false); // 버튼 투명하게 하기
		btn_Place_4 .setBorderPainted(false); // 버튼 라인 없애기
		
		btn_Place_5 = new JRadioButton("\uAE30\uD0C0");
		buttonGroup.add(btn_Place_5);
		btn_Place_5.setBounds(310, 194, 93, 23);
		frame.getContentPane().add(btn_Place_5);
		btn_Place_5 .setContentAreaFilled(false); // 버튼 투명하게 하기
		btn_Place_5 .setBorderPainted(false); // 버튼 라인 없애기
		
		btn_Theme_0 = new JRadioButton("\uC7AC\uB2A5 \uAE30\uBD80");
		buttonGroup_1.add(btn_Theme_0);
		btn_Theme_0.setBounds(99, 232, 84, 23);
		frame.getContentPane().add(btn_Theme_0);
		btn_Theme_0.setContentAreaFilled(false); // 버튼 투명하게 하기
		btn_Theme_0.setBorderPainted(false); // 버튼 라인 없애기
		
		btn_Theme_1 = new JRadioButton("\uBC84\uC2A4\uD0B9");
		buttonGroup_1.add(btn_Theme_1);
		btn_Theme_1.setBounds(196, 232, 84, 23);
		frame.getContentPane().add(btn_Theme_1);
		btn_Theme_1.setContentAreaFilled(false); // 버튼 투명하게 하기
		btn_Theme_1.setBorderPainted(false); // 버튼 라인 없애기
		
		btn_Theme_2 = new JRadioButton("\uCCB4\uD5D8");
		buttonGroup_1.add(btn_Theme_2);
		btn_Theme_2.setBounds(310, 232, 84, 23);
		frame.getContentPane().add(btn_Theme_2);
		btn_Theme_2.setContentAreaFilled(false); // 버튼 투명하게 하기
		btn_Theme_2.setBorderPainted(false); // 버튼 라인 없애기
		
		btn_Theme_3 = new JRadioButton("\uD50C\uB9AC\uB9C8\uCF13");
		buttonGroup_1.add(btn_Theme_3);
		btn_Theme_3.setBounds(99, 264, 84, 23);
		frame.getContentPane().add(btn_Theme_3);
		btn_Theme_3.setContentAreaFilled(false); // 버튼 투명하게 하기
		btn_Theme_3.setBorderPainted(false); // 버튼 라인 없애기
		
		btn_Theme_4 = new JRadioButton("\uC804\uC2DC\uD68C");
		buttonGroup_1.add(btn_Theme_4);
		btn_Theme_4.setBounds(196, 264, 84, 23);
		frame.getContentPane().add(btn_Theme_4);
		btn_Theme_4.setContentAreaFilled(false); // 버튼 투명하게 하기
		btn_Theme_4.setBorderPainted(false); // 버튼 라인 없애기
		
		btn_Theme_5 = new JRadioButton("\uAE30\uD0C0");
		buttonGroup_1.add(btn_Theme_5);
		btn_Theme_5.setBounds(310, 264, 84, 23);
		frame.getContentPane().add(btn_Theme_5);
		btn_Theme_5.setContentAreaFilled(false); // 버튼 투명하게 하기
		btn_Theme_5.setBorderPainted(false); // 버튼 라인 없애기
		
		comboBox = new JComboBox();
		comboBox.setMaximumRowCount(10);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"5", "10", "15", "20", "25", "30", "35", "40", "45", "50"}));
		comboBox.setBounds(99, 298, 276, 25);
		frame.getContentPane().add(comboBox);
		
		btn_Who_2 = new JRadioButton("\uC544\uC774\uB3D9\uBC18");
		buttonGroup_2.add(btn_Who_2);
		btn_Who_2.setBounds(310, 329, 84, 23);
		frame.getContentPane().add(btn_Who_2);
		btn_Who_2.setContentAreaFilled(false); // 버튼 투명하게 하기
		btn_Who_2.setBorderPainted(false); // 버튼 라인 없애기
		
		btn_Who_4 = new JRadioButton("\uAE30\uD0C0");
		buttonGroup_2.add(btn_Who_4);
		btn_Who_4.setBounds(196, 361, 84, 23);
		frame.getContentPane().add(btn_Who_4);
		btn_Who_4.setContentAreaFilled(false); // 버튼 투명하게 하기
		btn_Who_4.setBorderPainted(false); // 버튼 라인 없애기
		
		btn_Who_1 = new JRadioButton("20,30\uB300");
		buttonGroup_2.add(btn_Who_1);
		btn_Who_1.setBounds(196, 329, 84, 23);
		frame.getContentPane().add(btn_Who_1);
		btn_Who_1.setContentAreaFilled(false); // 버튼 투명하게 하기
		btn_Who_1.setBorderPainted(false); // 버튼 라인 없애기
		
		btn_Who_3 = new JRadioButton("\uBC18\uB824\uB3D9\uBB3C");
		buttonGroup_2.add(btn_Who_3);
		btn_Who_3.setBounds(99, 361, 84, 23);
		frame.getContentPane().add(btn_Who_3);
		btn_Who_3.setContentAreaFilled(false); // 버튼 투명하게 하기
		btn_Who_3.setBorderPainted(false); // 버튼 라인 없애기
		
		btn_Who_0 = new JRadioButton("\uCCAD\uC18C\uB144");
		buttonGroup_2.add(btn_Who_0);
		btn_Who_0.setBounds(99, 329, 84, 23);
		frame.getContentPane().add(btn_Who_0);
		btn_Who_0.setContentAreaFilled(false); // 버튼 투명하게 하기
		btn_Who_0.setBorderPainted(false); // 버튼 라인 없애기
		
		
		JLabel label_5 = new JLabel("\uB300\uC0C1\uC790 : ");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(12, 329, 93, 30);
		frame.getContentPane().add(label_5);
		
		date_start = new JDateChooser();
		date_start.setBounds(137, 122, 89, 21);
		frame.getContentPane().add(date_start);
		
		
		date_last = new JDateChooser();
		date_last.setBounds(301, 122, 89, 21);
		frame.getContentPane().add(date_last);
		
		
		JButton btnNewButton = new JButton("\uB4F1\uB85D\uD558\uAE30");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//main 나오게
				//1.장소
				String festPlace = null;
				arr[0] = btn_Place_0;
				arr[1] = btn_Place_1;
				arr[2] = btn_Place_2;
				arr[3] = btn_Place_3;
				arr[4] = btn_Place_4;
				arr[5] = btn_Place_5;
				for(int i=0;i<arr.length;i++) {
					if(arr[i].isSelected()) {
						festPlace = arr[i].getText();
					}
				}
				//2. 테마
				String festTheme=null;
				arr2[0] = btn_Theme_0;
				arr2[1] = btn_Theme_1;
				arr2[2] = btn_Theme_2;
				arr2[3] = btn_Theme_3;
				arr2[4] = btn_Theme_4;
				arr2[5] = btn_Theme_5;
				for(int i=0;i<arr2.length;i++) {
					if(arr2[i].isSelected()) {
						festTheme = arr2[i].getText();
					}
				}
				//3. 최소인원
				int festMinmember = Integer.parseInt((String)comboBox.getSelectedItem());
				System.out.println(festMinmember);
				//4. 대상자
				String festWho = null;
				arr3[0] = btn_Who_0;
				arr3[1] = btn_Who_1;
				arr3[2] = btn_Who_2;
				arr3[3] = btn_Who_3;
				arr3[4] = btn_Who_4;
				for(int i=0;i<arr3.length;i++) {
					if(arr3[i].isSelected()) {
						festTheme = arr3[i].getText();
					}
				}
		
				
				java.sql.Date sqlDate = convert(date_start.getDate()); // date_start 를 sql_date 형태로 바꿔주기 
				java.sql.Date sqlDate2 = convert(date_last.getDate()); // 동일
				
				listdao.joinFest(tp_festName.getText(), sqlDate, sqlDate2, festPlace, festTheme, festMinmember);
				//등록하기 누르면 예정중인 축제목록으로 넘겨주기
				
				frame.dispose();
			}
		});
		btnNewButton.setBounds(99, 590, 235, 47);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("~");
		lblNewLabel_2.setBounds(261, 125, 28, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lbl_background = new JLabel("");
		String imgPath = "image/info_Background.jpeg";
		ImageIcon originIcon = new ImageIcon(imgPath); // 이미지 크기 맞추기
		Image originImg = originIcon.getImage();
		Image changedImg = originImg.getScaledInstance(439, 661, Image.SCALE_SMOOTH);
		ImageIcon ficon = new ImageIcon(changedImg);
		lbl_background.setIcon(ficon);

		
		lbl_background.setBounds(0, 0, 439, 661);
		frame.getContentPane().add(lbl_background);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				mainGUI mn = new mainGUI();
			}
		});
	}
}
