package View;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Model.place_DAO;
import Model.place_DTO;

import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;

public class place_infoGUI {

	private JFrame frame;
	String name2;
	private JTable table;

	/**
	 * Launch the application.
	 */
   	/* public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					place_infoGUI window = new place_infoGUI(name2);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} */

	/**
	 * Create the application.
	 */
	public place_infoGUI(String name2) {
		initialize(name2);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param name2 
	 */
	private void initialize(String name2) {
		frame = new JFrame();
		frame.setBounds(100, 100, 599, 402);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC5C5\uCCB4 \uC815\uBCF4");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(67, 10, 474, 59);
		frame.getContentPane().add(lblNewLabel);
		
		String [] colName = {"업체명","주소", "전화번호","홈페이지"};
		
		place_DAO dao = new place_DAO();
			ArrayList<place_DTO> memberList2 = dao.selectInfo(name2);
			
			Object [][] data = new Object[memberList2.size()][4]; //2차원 배열 형성
		for(int i=0; i<data.length;i++) {
			data[i][0] = memberList2.get(i).getName();
			data[i][1] = memberList2.get(i).getAddress();
			data[i][2] = memberList2.get(i).getTel();
			data[i][3] = memberList2.get(i).getHomepage();
			}
		
		JLabel lblNewLabel_1 = new JLabel("\uC5C5\uCCB4 \uC18C\uAC1C");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(12, 122, 86, 21);
		frame.getContentPane().add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 67, 558, 45);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable(data,colName);
		scrollPane.setViewportView(table);
		
		JLabel lbl_label_info1 = new JLabel("<html><body>\t\r\n\t\uC5F0\uC2B5\uACF5\uAC04\uC81C\uACF5 <br>\r\n\t\uC545\uAE30\uC758 \uACBD\uC6B0\uC5D0\uB294 \uC81C\uACF5\uB4DC\uB9AC\uC9C0 \uC54A\uC2B5\uB2C8\uB2E4.(\uB514\uC9C0\uD138 \uD53C\uC544\uB178 \uAD6C\uBE44) <br>\r\n\t\uAC74\uBB3C\uC804\uCCB4 \uAE08\uC5F0 <br>\r\n\t\uC601\uC5C5\uC2DC\uAC04 0~24\uC2DC(\uD734\uBB34\uC77C\uC5C6\uC74C) <br>\r\n\t\uD658\uBD88 \uADDC\uC815 <br>\r\n\t8\uC77C\uC804 - \uC804\uC561\uD658\uBD88 \t6\uC77C\uC804- 80%\uD658\uBD88\t4\uC77C\uC804- 50%\uD658\uBD88 <br>\r\n\t2\uC77C\uC804 - 20%\uD658\uBD88\t\uC774\uC6A9\uC804\uB0A0&\uC774\uC6A9\uB2F9\uC77C - \uD658\uBD88\uBD88\uAC00 <br></body></html>\r\n");
		lbl_label_info1.setBounds(22, 153, 549, 137);
		frame.getContentPane().add(lbl_label_info1);
		lbl_label_info1.setVisible(false);
		if(data[0][0].equals("금남로연습실 저스트스튜디오")) {
			lbl_label_info1.setVisible(true);
		}
		
		JLabel lbl_label_info2 = new JLabel("<html><body>\t\r\n\t\uD30C\uD2F0\uB8F8 <br>\r\n\t1,2,\uB8E8\uD504\uD0D1 \uC81C\uACF5  <br>\r\n\t\uC601\uC5C5\uC2DC\uAC04 9~24\uC2DC(\uD734\uBB34\uC77C \uC5C6\uC74C)  <br>\r\n\t\uBE54\uD504\uB85C\uC81D\uD130, \uAE30\uBCF8\uC2DD\uAE30, \uBC14\uBCA0\uD050 \uC5EC\uBD80\uB294 \uD611\uC758\uD558\uC154\uC57C \uD569\uB2C8\uB2E4.  <br>\r\n\t\uD658\uBD88 \uADDC\uC815  <br>\r\n\t8\uC77C\uC804 - 100%\uD658\uBD88 \t6\uC77C\uC804 - \uAE08\uC561\uC75880%\uD658\uBD88\t3\uC77C\uC804 - \uAE08\uC561\uC75850%\uD658\uBD88  <br>\r\n\t2\uC77C\uC804 - \uAE08\uC561\uC75830%\uD658\uBD88\t\uC774\uC6A9\uC804\uB0A0&\uC774\uC6A9\uB2F9\uC77C - \uD658\uBD88\uBD88\uAC00 </body></html>");
		lbl_label_info2.setBounds(22, 171, 549, 119);
		frame.getContentPane().add(lbl_label_info2);
		lbl_label_info2.setVisible(false);
		if(data[0][0].equals("지산낙원")) {
			lbl_label_info2.setVisible(true);
		}
		
		JButton btn_reserve = new JButton("\uC608\uC57D\uD558\uAE30");
		btn_reserve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Desktop.getDesktop().browse(new URI((String)data[0][3]));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btn_reserve.setBounds(143, 296, 304, 57);
		btn_reserve.setContentAreaFilled(false); // 버튼 투명하게 하기
		btn_reserve.setBorderPainted(false); // 버튼 라인 없애기
		frame.getContentPane().add(btn_reserve);
		
		JButton btn_back = new JButton("");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				place_FestivalGUI festgui = new place_FestivalGUI();
			}
		});
		String imgPath = "image/icon_left.png";
		ImageIcon originIcon = new ImageIcon(imgPath); // 이미지 크기 맞추기
		Image originImg = originIcon.getImage();
		Image changedImg = originImg.getScaledInstance(38, 38, Image.SCALE_SMOOTH);
		ImageIcon ficon = new ImageIcon(changedImg);
		btn_back.setIcon(ficon);
		btn_back.setBounds(28, 10, 51, 47);
		frame.getContentPane().add(btn_back);
		btn_back.setContentAreaFilled(false); // 버튼 투명하게 하기
		btn_back.setBorderPainted(false); // 버튼 라인 없애기
		
		
		JLabel lbl_background = new JLabel("");
		 imgPath = "image/info_Background.jpg";
		 originIcon = new ImageIcon(imgPath); // 이미지 크기 맞추기
		 originImg = originIcon.getImage();
		 changedImg = originImg.getScaledInstance(585, 363, Image.SCALE_SMOOTH);
		 ficon = new ImageIcon(changedImg);
		 lbl_background.setIcon(ficon);
		lbl_background.setBounds(-2, 0, 585, 363);
		frame.getContentPane().add(lbl_background);
		
		
	}
}
