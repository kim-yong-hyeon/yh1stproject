package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.*; // 테두리 지우는거
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class mainGUI {

	private JFrame frame;

	// 이미지 크기 맞출때 필요
	public String imgPath;
	public ImageIcon originIcon;
	public Image originImg;
	public Image changedImg;
	public ImageIcon ficon;
	/**
	 *
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainGUI window = new mainGUI();
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
	public mainGUI() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("image/icon_Party.png"));
		frame.setResizable(false); // 창크기 조절 
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 435, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// 축제 등록하기
		JButton btn_upload = new JButton("\uCD95\uC81C \uB4F1\uB85D\uD558\uAE30");
		btn_upload.setHorizontalAlignment(SwingConstants.LEFT);
		btn_upload.setFont(new Font("넥슨 풋볼고딕 B", Font.PLAIN, 17));
		btn_upload.addMouseListener(new MouseAdapter() {

			@Override // 마우스가 버튼 안으로 들어오면 글씨가 지정색으로 바뀜
			public void mouseEntered(MouseEvent e) {
				JButton btn_upload = (JButton) e.getSource();
				btn_upload.setForeground(Color.white);
			}

			@Override // 마우스가 버튼 밖으로 나가면 검은글씨로 바뀜
			public void mouseExited(MouseEvent e) {
				JButton btn_upload = (JButton) e.getSource();
				btn_upload.setForeground(Color.black);
			}
		});
		// 축제 등록 버튼 누르면 ==> 축제 등록으로 이동
		btn_upload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Join_Festival jf = new Join_Festival();
			}
		});
		btn_upload.setBounds(242, 334, 136, 27);
		frame.getContentPane().add(btn_upload);

		btn_upload.setContentAreaFilled(false); // 버튼 투명하게 하기
		btn_upload.setBorderPainted(false); // 버튼 라인 없애기

		// 메인 제목
		JLabel lbl_Title = new JLabel("???\uC774\uB984???");
		lbl_Title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Title.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 21));
		lbl_Title.setBounds(155, 12, 136, 34);
		frame.getContentPane().add(lbl_Title);

		// 메인 제목 아래 선(Line)
		JLabel lbl_line = new JLabel("");
		imgPath = "image/Line.png";

		originIcon = new ImageIcon(imgPath); // 이미지 크기 맞추기
		originImg = originIcon.getImage();
		changedImg = originImg.getScaledInstance(385, 5, Image.SCALE_SMOOTH);
		ficon = new ImageIcon(changedImg);
		lbl_line.setIcon(ficon);

		lbl_line.setBounds(23, 50, 385, 5);
		frame.getContentPane().add(lbl_line);

		// 메인 사진
		JLabel lbl_main_image = new JLabel("New label");
		lbl_main_image.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) {
			}

			public void ancestorMoved(AncestorEvent arg0) {
			}

			public void ancestorRemoved(AncestorEvent arg0) {
			}
		});
		lbl_main_image.setHorizontalAlignment(SwingConstants.CENTER);
		imgPath = "image/Main.png";

		originIcon = new ImageIcon(imgPath); // 이미지 크기 맞추기
		originImg = originIcon.getImage();
		changedImg = originImg.getScaledInstance(385, 272, Image.SCALE_SMOOTH);
		ficon = new ImageIcon(changedImg);
		lbl_main_image.setIcon(ficon);

		lbl_main_image.setBounds(23, 104, 385, 272);
		frame.getContentPane().add(lbl_main_image);

		// 축제확정 이미지1
		JButton btn_image1 = new JButton("");
		btn_image1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				info1 info = new info1();
			}
		});
		imgPath = "image/image1.jpg";

		originIcon = new ImageIcon(imgPath); // 이미지 크기 맞추기
		originImg = originIcon.getImage();
		changedImg = originImg.getScaledInstance(118, 86, Image.SCALE_SMOOTH);
		ficon = new ImageIcon(changedImg);
		btn_image1.setIcon(ficon);

		btn_image1.setFont(new Font("HY엽서M", Font.PLAIN, 18));
		btn_image1.setBounds(23, 415, 118, 86);
		frame.getContentPane().add(btn_image1);

		// 축제확정 이미지2
		JButton btn_image2 = new JButton("");
		imgPath = "image/image2.png";

		originIcon = new ImageIcon(imgPath); // 이미지 크기 맞추기
		originImg = originIcon.getImage();
		changedImg = originImg.getScaledInstance(118, 86, Image.SCALE_SMOOTH);
		ficon = new ImageIcon(changedImg);
		btn_image2.setIcon(ficon);

		btn_image2.setFont(new Font("HY엽서M", Font.PLAIN, 18));
		btn_image2.setBounds(155, 415, 118, 86);
		frame.getContentPane().add(btn_image2);

		// 축제확정 이미지3
		JButton btn_image3 = new JButton("");
		imgPath = "image/image3.jpg";

		originIcon = new ImageIcon(imgPath); // 이미지 크기 맞추기
		originImg = originIcon.getImage();
		changedImg = originImg.getScaledInstance(118, 86, Image.SCALE_SMOOTH);
		ficon = new ImageIcon(changedImg);
		btn_image3.setIcon(ficon);

		btn_image3.setFont(new Font("HY엽서M", Font.PLAIN, 18));
		btn_image3.setBounds(287, 415, 118, 86);
		frame.getContentPane().add(btn_image3);

		// 축제확정 이미지4
		JButton btn_image4 = new JButton("");
		imgPath = "image/image4.jpg";

		originIcon = new ImageIcon(imgPath); // 이미지 크기 맞추기
		originImg = originIcon.getImage();
		changedImg = originImg.getScaledInstance(118, 86, Image.SCALE_SMOOTH);
		ficon = new ImageIcon(changedImg);
		btn_image4.setIcon(ficon);

		btn_image4.setFont(new Font("HY엽서M", Font.PLAIN, 18));
		btn_image4.setBounds(23, 551, 118, 86);
		frame.getContentPane().add(btn_image4);

		// 축제확정 이미지5
		JButton btn_image5 = new JButton("");
		imgPath = "image/image5.jpg";

		originIcon = new ImageIcon(imgPath); // 이미지 크기 맞추기
		originImg = originIcon.getImage();
		changedImg = originImg.getScaledInstance(118, 86, Image.SCALE_SMOOTH);
		ficon = new ImageIcon(changedImg);
		btn_image5.setIcon(ficon);

		btn_image5.setFont(new Font("HY엽서M", Font.PLAIN, 18));
		btn_image5.setBounds(155, 551, 118, 86);
		frame.getContentPane().add(btn_image5);

		// 축제확정 이미지6
		JButton btn_image6 = new JButton("");
		imgPath = "image/image6.jpg";

		originIcon = new ImageIcon(imgPath); // 이미지 크기 맞추기
		originImg = originIcon.getImage();
		changedImg = originImg.getScaledInstance(118, 86, Image.SCALE_SMOOTH);
		ficon = new ImageIcon(changedImg);
		btn_image6.setIcon(ficon);

		btn_image6.setFont(new Font("HY엽서M", Font.PLAIN, 18));
		btn_image6.setBounds(287, 551, 118, 86);
		frame.getContentPane().add(btn_image6);

		// 자물쇠 아이콘 unlock
		JLabel lbl_unlock = new JLabel("");
		imgPath = "image/icon_unlock.png";

		originIcon = new ImageIcon(imgPath); // 이미지 크기 맞추기
		originImg = originIcon.getImage();
		changedImg = originImg.getScaledInstance(23, 23, Image.SCALE_SMOOTH);
		ficon = new ImageIcon(changedImg);
		lbl_unlock.setIcon(ficon);

		lbl_unlock.setBounds(23, 388, 23, 23);
		frame.getContentPane().add(lbl_unlock);

		// 자물쇠 아이콘 lock
		JLabel lbl_lock = new JLabel("");
		imgPath = "image/icon_lock.png";

		originIcon = new ImageIcon(imgPath); // 이미지 크기 맞추기
		originImg = originIcon.getImage();
		changedImg = originImg.getScaledInstance(23, 23, Image.SCALE_SMOOTH);
		ficon = new ImageIcon(changedImg);
		lbl_lock.setIcon(ficon);

		lbl_lock.setBounds(23, 526, 23, 23);
		frame.getContentPane().add(lbl_lock);

		// 공간대여 버튼
		JButton btn_space = new JButton("\uACF5\uAC04\uB300\uC5EC");
		btn_space.setForeground(new Color(0, 0, 0));
		btn_space.setBackground(Color.WHITE);
		btn_space.setFont(new Font("넥슨 풋볼고딕 B", Font.PLAIN, 19));

		btn_space.addMouseListener(new MouseAdapter() {

			@Override // 마우스가 버튼 안으로 들어오면 글씨가 지정색으로 바뀜
			public void mouseEntered(MouseEvent e) {
				JButton btn_space = (JButton) e.getSource();
				btn_space.setForeground(Color.orange);
			}

			@Override // 마우스가 버튼 밖으로 나가면 검은글씨로 바뀜
			public void mouseExited(MouseEvent e) {
				JButton btn_space = (JButton) e.getSource();
				btn_space.setForeground(Color.black);
			}
		});
		// 공간 대여 버튼 누르면 ==> 공간 대여 페이지로 이동
		btn_space.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				place_FestivalGUI pf = new place_FestivalGUI();
			}
		});
		btn_space.setBounds(286, 68, 122, 29);
		btn_space.setBorderPainted(false); // 테두리 삭제
		// btn_space.setFocusPainted(false); // 포커스 표시 삭제
		btn_space.setContentAreaFilled(false); // 버튼 배경 투명하게 하기
		frame.getContentPane().add(btn_space);

		// 예정 죽제 버튼 ==> 축제 Soon
		JButton btn_Soon = new JButton("\uCD95\uC81C Soon");
		btn_Soon.addMouseListener(new MouseAdapter() {

			@Override // 마우스가 버튼 안으로 들어오면 글씨가 지정색으로 바뀜
			public void mouseEntered(MouseEvent e) {
				JButton btn_Soon = (JButton) e.getSource();
				btn_Soon.setForeground(Color.orange);
			}

			@Override // 마우스가 버튼 밖으로 나가면 검은글씨로 바뀜
			public void mouseExited(MouseEvent e) {
				JButton btn_Soon = (JButton) e.getSource();
				btn_Soon.setForeground(Color.black);
			}
		});
		
		// 공간 대여 버튼 누르면 ==> 공간 대여 페이지로 이동
		btn_Soon.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						frame.dispose();
						List_GUI listgui = new List_GUI(null,0,0);
					}
				});
		
		
		btn_Soon.setBackground(Color.WHITE);
		btn_Soon.setFont(new Font("넥슨 풋볼고딕 B", Font.PLAIN, 19));
		btn_Soon.setBounds(150, 68, 141, 29);

		btn_Soon.setBorderPainted(false); // 테두리 삭제
		btn_Soon.setFocusPainted(false); // 포커스 표시 삭제
		// btn_Soon.setContentAreaFilled(false); // 버튼 배경 투명하게 하기

		frame.getContentPane().add(btn_Soon);

		// 진행중인 축제 버튼 ==> 축제 Go
		JButton btn_Go = new JButton("\uCD95\uC81C Go");
		btn_Go.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				festivalInfoGUI infogui = new festivalInfoGUI();
				frame.dispose();
			
			}
		});
		btn_Go.setBackground(Color.WHITE);
		btn_Go.addMouseListener(new MouseAdapter() {

			@Override // 마우스가 버튼 안으로 들어오면 글씨가 지정색으로 바뀜
			public void mouseEntered(MouseEvent e) {
				JButton btn_Go = (JButton) e.getSource();
				btn_Go.setForeground(Color.orange);
			}

			@Override // 마우스가 버튼 밖으로 나가면 검은글씨로 바뀜
			public void mouseExited(MouseEvent e) {
				JButton btn_Go = (JButton) e.getSource();
				btn_Go.setForeground(Color.black);
			}
		});

		btn_Go.setFont(new Font("넥슨 풋볼고딕 B", Font.PLAIN, 19));
		btn_Go.setBounds(23, 68, 109, 29);

		btn_Go.setBorderPainted(false); // 테두리 삭제
		btn_Go.setFocusPainted(false); // 포커스 표시 삭제
		// btn_Go.setContentAreaFilled(false); // 버튼 배경 투명하게 하기

		frame.getContentPane().add(btn_Go);
		
		JLabel lblNewLabel = new JLabel("\uC9C4\uD589\uC911\uC778 \uCD95\uC81C");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel.setBounds(49, 394, 116, 18);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("\uC9C4\uD589\uC608\uC815 \uCD95\uC81C");
		label.setFont(new Font("굴림", Font.BOLD, 15));
		label.setBounds(49, 530, 116, 18);
		frame.getContentPane().add(label);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}