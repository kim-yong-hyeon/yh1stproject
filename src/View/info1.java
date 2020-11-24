package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;

public class info1 {

	private JFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					info1 window = new info1();
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
	public info1() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 452, 513);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		
		JLabel lblNewLabel = new JLabel("\uCD95\uC81C\uBA85 : ");
		lblNewLabel.setBounds(13, 371, 70, 26);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("\uCD95\uC81C\uC7A5\uC18C : ");
		label.setBounds(167, 443, 70, 26);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\uD604\uC7AC\uC778\uC6D0 : ");
		label_1.setBounds(252, 371, 81, 26);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel(" \uCD95\uC81C\uC2DC\uC791\uC77C : ");
		label_2.setBounds(12, 407, 81, 26);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\uCD95\uC81C\uC885\uB8CC\uC77C : ");
		label_3.setBounds(174, 407, 89, 26);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("\uCD95\uC81C\uD14C\uB9C8 : ");
		label_4.setBounds(13, 443, 70, 26);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("\uD50C\uB9AC\uB9C8\uCF13");
		label_5.setBounds(85, 443, 70, 26);
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("\uC190\uC5D0\uC11C \uAF43\uD53C\uB294 \uBE5B\uACE0\uC744 \uD50C\uB9AC\uB9C8\uCF13");
		label_6.setBounds(61, 362, 179, 44);
		frame.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("\uC720\uC2A4\uD018\uC5B4 \uAD11\uC7A5");
		label_7.setBounds(237, 443, 96, 26);
		frame.getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("2020.07.01");
		label_8.setBounds(92, 407, 70, 26);
		frame.getContentPane().add(label_8);
		
		JLabel label_9 = new JLabel("2020.08.01");
		label_9.setBounds(248, 407, 70, 26);
		frame.getContentPane().add(label_9);
		
		JLabel label_10 = new JLabel("25\uBA85");
		label_10.setBounds(321, 371, 70, 26);
		frame.getContentPane().add(label_10);
		
		JButton btnNewButton = new JButton("");
		String imgPath = "image/image1.jpg";

		ImageIcon originIcon = new ImageIcon(imgPath); // 이미지 크기 맞추기
		Image originImg = originIcon.getImage();
		Image changedImg = originImg.getScaledInstance(412, 327, Image.SCALE_SMOOTH);
		ImageIcon ficon = new ImageIcon(changedImg);
		btnNewButton.setIcon(ficon);
		btnNewButton.setBounds(13, 34, 412, 327);
		frame.getContentPane().add(btnNewButton);
		
		JButton btn_home = new JButton("");
		String imgPath2 = "image/icon_home.png";
		originIcon = new ImageIcon(imgPath2); // 이미지 크기 맞추기
		originImg = originIcon.getImage();
		changedImg = originImg.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
		ficon = new ImageIcon(changedImg);
		btn_home.setIcon(ficon);

		btn_home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				mainGUI maingui = new mainGUI(); // 메인 화면으로 돌아가기
				
			}
		});
		
		btn_home.setContentAreaFilled(false); // 버튼 투명하게 하기
		btn_home.setBorderPainted(false); // 버튼 라인 없애기
		
		btn_home.setBounds(12, 1, 35, 35);
		frame.getContentPane().add(btn_home);
		
		JLabel lblNewLabel_3 = new JLabel("");
		imgPath = "image/info_Background.jpg";
        originIcon = new ImageIcon(imgPath); // 이미지 크기 맞추기
        originImg = originIcon.getImage();
        changedImg = originImg.getScaledInstance(436, 473, Image.SCALE_SMOOTH);
        ficon = new ImageIcon(changedImg);
        lblNewLabel_3.setIcon(ficon);
		
        lblNewLabel_3.setBounds(0, 1, 436, 473);
		frame.getContentPane().add(lblNewLabel_3);
		
		
	}
}
