package View;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

public class place_FestivalGUI {

	private JFrame frame;
	JButton btn;
	private JButton btn_E;
	private JButton btn_W;
	private JButton btn_S;
	private JButton btn_N;
	private JButton btn_G;

	// 이미지 크기 맞출때 필요
	public String imgPath;
	public ImageIcon originIcon;
	public Image originImg;
	public Image changedImg;
	public ImageIcon ficon;
	public ImageIcon ficon1;
	
	private JButton button;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					place_FestivalGUI window = new place_FestivalGUI();
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

	/**
	 * Initialize the contents of the frame.
	 */

	public place_FestivalGUI() {
		initialize();
		frame.setVisible(true);

	}

	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("image/icon_Party.png"));
		frame.setResizable(false); // 창크기 조절 
		frame.setBounds(100, 100, 424, 407);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// 뒤로가기 버튼
				JButton btn_back = new JButton("");
				
				imgPath = "image/icon_left.png";

				originIcon = new ImageIcon(imgPath); // 이미지 크기 맞추기
				originImg = originIcon.getImage();
				changedImg = originImg.getScaledInstance(38, 38, Image.SCALE_SMOOTH);
				ficon = new ImageIcon(changedImg);
				btn_back.setIcon(ficon);
				
				btn_back.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame.dispose();
						mainGUI maingui = new mainGUI();  //메인 화면으로 돌아가기
					}
				});
				btn_back.setContentAreaFilled(false); // 버튼 투명하게 하기
				btn_back.setBorderPainted(false); // 버튼 라인 없애기
				btn_back.setBounds(25, 21, 38, 38);
				frame.getContentPane().add(btn_back);

		

		// 동구 버튼
		btn_E = new JButton("");
		
		imgPath = "image/icon_pin.png";

		originIcon = new ImageIcon(imgPath); // 이미지 크기 맞추기
		originImg = originIcon.getImage();
		changedImg = originImg.getScaledInstance(30, 43, Image.SCALE_SMOOTH);
		ficon = new ImageIcon(changedImg);
		btn_E.setIcon(ficon);
		
		
		btn_E.setBounds(298, 196, 35,43);
		frame.getContentPane().add(btn_E);

		btn_E.setBorderPainted(false); // 테두리 삭제
		btn_E.setFocusPainted(false); // 포커스 표시 삭제
		btn_E.setContentAreaFilled(false); // 버튼 배경 투명하게 하기
		
		btn_E.addActionListener(new ActionListener() { // 버튼 누르면 동구 리스트 화면 띄우기
			public void actionPerformed(ActionEvent e) {
				place_FestivalGUI2 place = new place_FestivalGUI2("동구");
				frame.dispose();
				/*try {
					System.out.println("된건가?");
					Process process = Runtime.getRuntime().exec("Project_Festival.ipynb");
					process.getErrorStream().close();
					process.getInputStream().close();
					process.getOutputStream().close();
					try {
						
						process.waitFor();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					System.out.println("안된건디");
					e1.printStackTrace();
				} */
			}
		});
		

		// 서구 버튼
		btn_W = new JButton("");
		imgPath = "image/icon_pin.png";

		originIcon = new ImageIcon(imgPath); // 이미지 크기 맞추기
		originImg = originIcon.getImage();
		changedImg = originImg.getScaledInstance(30, 43, Image.SCALE_SMOOTH);
		ficon = new ImageIcon(changedImg);
		btn_W.setIcon(ficon);
		
		
		btn_W.setBounds(208, 162, 30,43);
		frame.getContentPane().add(btn_W);

		btn_W.setBorderPainted(false); // 테두리 삭제
		btn_W.setFocusPainted(false); // 포커스 표시 삭제
		btn_W.setContentAreaFilled(false); // 버튼 배경 투명하게 하기
		
		btn_W.addActionListener(new ActionListener() { // 버튼 누르면 서구 리스트 화면 띄우기
			public void actionPerformed(ActionEvent e) {
				place_FestivalGUI2 place = new place_FestivalGUI2("서구");
				frame.dispose();
			}
		});

		// 남구 버튼
		btn_S = new JButton("");
		
		imgPath = "image/icon_pin.png";

		originIcon = new ImageIcon(imgPath); // 이미지 크기 맞추기
		originImg = originIcon.getImage();
		changedImg = originImg.getScaledInstance(30, 43, Image.SCALE_SMOOTH);
		ficon = new ImageIcon(changedImg);
		btn_S.setIcon(ficon);
		
		btn_S.setBounds(209, 224, 30, 43);
		frame.getContentPane().add(btn_S);
		
		btn_S.setBorderPainted(false); // 테두리 삭제
		btn_S.setFocusPainted(false); // 포커스 표시 삭제
		btn_S.setContentAreaFilled(false); // 버튼 배경 투명하게 하기

		btn_S.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				place_FestivalGUI2 place = new place_FestivalGUI2("남구");
				frame.dispose();
			}
		});

		// 북구 버튼
		btn_N = new JButton("");
		
		imgPath = "image/icon_pin.png";
		originIcon = new ImageIcon(imgPath); // 이미지 크기 맞추기
		originImg = originIcon.getImage();
		changedImg = originImg.getScaledInstance(30, 43, Image.SCALE_SMOOTH);
		ficon = new ImageIcon(changedImg);
		btn_N.setIcon(ficon);
		
		btn_N.setBounds(275, 110, 30, 43);
		frame.getContentPane().add(btn_N);

		btn_N.setBorderPainted(false); // 테두리 삭제
		btn_N.setFocusPainted(false); // 포커스 표시 삭제
		btn_N.setContentAreaFilled(false); // 버튼 배경 투명하게 하기
		
		btn_N.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				place_FestivalGUI2 place = new place_FestivalGUI2("북구");
				frame.dispose();
			}
		});

		// 광산구 버튼
		btn_G = new JButton("");
		
		imgPath = "image/icon_pin.png";
		originIcon = new ImageIcon(imgPath); // 이미지 크기 맞추기
		originImg = originIcon.getImage();
		changedImg = originImg.getScaledInstance(30, 43, Image.SCALE_SMOOTH);
		ficon = new ImageIcon(changedImg);
		btn_G.setIcon(ficon);
		
		btn_G.setBounds(110, 139, 30,43);
		frame.getContentPane().add(btn_G);
		
		btn_G.setBorderPainted(false); // 테두리 삭제
		btn_G.setFocusPainted(false); // 포커스 표시 삭제
		btn_G.setContentAreaFilled(false); // 버튼 배경 투명하게 하기
		
		btn_G.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				place_FestivalGUI2 place = new place_FestivalGUI2("광산구");
				frame.dispose();
			}
		});
		
		// 지도 이미지
		lblNewLabel = new JLabel("");
		
		
		
		imgPath = "image/map.png";

		originIcon = new ImageIcon(imgPath); // 이미지 크기 맞추기
		originImg = originIcon.getImage();
		changedImg = originImg.getScaledInstance(368, 282, Image.SCALE_SMOOTH);
		ficon = new ImageIcon(changedImg);
		lblNewLabel.setIcon(ficon);
		
		lblNewLabel.setBounds(25, 66, 368, 282);
		frame.getContentPane().add(lblNewLabel);
	
			
		
		}
}

