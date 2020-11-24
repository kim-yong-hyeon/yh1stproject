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
import javax.swing.border.*; // �׵θ� ����°�
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class mainGUI {

	private JFrame frame;

	// �̹��� ũ�� ���⶧ �ʿ�
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
		frame.setResizable(false); // âũ�� ���� 
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 435, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// ���� ����ϱ�
		JButton btn_upload = new JButton("\uCD95\uC81C \uB4F1\uB85D\uD558\uAE30");
		btn_upload.setHorizontalAlignment(SwingConstants.LEFT);
		btn_upload.setFont(new Font("�ؽ� ǲ����� B", Font.PLAIN, 17));
		btn_upload.addMouseListener(new MouseAdapter() {

			@Override // ���콺�� ��ư ������ ������ �۾��� ���������� �ٲ�
			public void mouseEntered(MouseEvent e) {
				JButton btn_upload = (JButton) e.getSource();
				btn_upload.setForeground(Color.white);
			}

			@Override // ���콺�� ��ư ������ ������ �����۾��� �ٲ�
			public void mouseExited(MouseEvent e) {
				JButton btn_upload = (JButton) e.getSource();
				btn_upload.setForeground(Color.black);
			}
		});
		// ���� ��� ��ư ������ ==> ���� ������� �̵�
		btn_upload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Join_Festival jf = new Join_Festival();
			}
		});
		btn_upload.setBounds(242, 334, 136, 27);
		frame.getContentPane().add(btn_upload);

		btn_upload.setContentAreaFilled(false); // ��ư �����ϰ� �ϱ�
		btn_upload.setBorderPainted(false); // ��ư ���� ���ֱ�

		// ���� ����
		JLabel lbl_Title = new JLabel("???\uC774\uB984???");
		lbl_Title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Title.setFont(new Font("�޸յձ�������", Font.PLAIN, 21));
		lbl_Title.setBounds(155, 12, 136, 34);
		frame.getContentPane().add(lbl_Title);

		// ���� ���� �Ʒ� ��(Line)
		JLabel lbl_line = new JLabel("");
		imgPath = "image/Line.png";

		originIcon = new ImageIcon(imgPath); // �̹��� ũ�� ���߱�
		originImg = originIcon.getImage();
		changedImg = originImg.getScaledInstance(385, 5, Image.SCALE_SMOOTH);
		ficon = new ImageIcon(changedImg);
		lbl_line.setIcon(ficon);

		lbl_line.setBounds(23, 50, 385, 5);
		frame.getContentPane().add(lbl_line);

		// ���� ����
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

		originIcon = new ImageIcon(imgPath); // �̹��� ũ�� ���߱�
		originImg = originIcon.getImage();
		changedImg = originImg.getScaledInstance(385, 272, Image.SCALE_SMOOTH);
		ficon = new ImageIcon(changedImg);
		lbl_main_image.setIcon(ficon);

		lbl_main_image.setBounds(23, 104, 385, 272);
		frame.getContentPane().add(lbl_main_image);

		// ����Ȯ�� �̹���1
		JButton btn_image1 = new JButton("");
		btn_image1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				info1 info = new info1();
			}
		});
		imgPath = "image/image1.jpg";

		originIcon = new ImageIcon(imgPath); // �̹��� ũ�� ���߱�
		originImg = originIcon.getImage();
		changedImg = originImg.getScaledInstance(118, 86, Image.SCALE_SMOOTH);
		ficon = new ImageIcon(changedImg);
		btn_image1.setIcon(ficon);

		btn_image1.setFont(new Font("HY����M", Font.PLAIN, 18));
		btn_image1.setBounds(23, 415, 118, 86);
		frame.getContentPane().add(btn_image1);

		// ����Ȯ�� �̹���2
		JButton btn_image2 = new JButton("");
		imgPath = "image/image2.png";

		originIcon = new ImageIcon(imgPath); // �̹��� ũ�� ���߱�
		originImg = originIcon.getImage();
		changedImg = originImg.getScaledInstance(118, 86, Image.SCALE_SMOOTH);
		ficon = new ImageIcon(changedImg);
		btn_image2.setIcon(ficon);

		btn_image2.setFont(new Font("HY����M", Font.PLAIN, 18));
		btn_image2.setBounds(155, 415, 118, 86);
		frame.getContentPane().add(btn_image2);

		// ����Ȯ�� �̹���3
		JButton btn_image3 = new JButton("");
		imgPath = "image/image3.jpg";

		originIcon = new ImageIcon(imgPath); // �̹��� ũ�� ���߱�
		originImg = originIcon.getImage();
		changedImg = originImg.getScaledInstance(118, 86, Image.SCALE_SMOOTH);
		ficon = new ImageIcon(changedImg);
		btn_image3.setIcon(ficon);

		btn_image3.setFont(new Font("HY����M", Font.PLAIN, 18));
		btn_image3.setBounds(287, 415, 118, 86);
		frame.getContentPane().add(btn_image3);

		// ����Ȯ�� �̹���4
		JButton btn_image4 = new JButton("");
		imgPath = "image/image4.jpg";

		originIcon = new ImageIcon(imgPath); // �̹��� ũ�� ���߱�
		originImg = originIcon.getImage();
		changedImg = originImg.getScaledInstance(118, 86, Image.SCALE_SMOOTH);
		ficon = new ImageIcon(changedImg);
		btn_image4.setIcon(ficon);

		btn_image4.setFont(new Font("HY����M", Font.PLAIN, 18));
		btn_image4.setBounds(23, 551, 118, 86);
		frame.getContentPane().add(btn_image4);

		// ����Ȯ�� �̹���5
		JButton btn_image5 = new JButton("");
		imgPath = "image/image5.jpg";

		originIcon = new ImageIcon(imgPath); // �̹��� ũ�� ���߱�
		originImg = originIcon.getImage();
		changedImg = originImg.getScaledInstance(118, 86, Image.SCALE_SMOOTH);
		ficon = new ImageIcon(changedImg);
		btn_image5.setIcon(ficon);

		btn_image5.setFont(new Font("HY����M", Font.PLAIN, 18));
		btn_image5.setBounds(155, 551, 118, 86);
		frame.getContentPane().add(btn_image5);

		// ����Ȯ�� �̹���6
		JButton btn_image6 = new JButton("");
		imgPath = "image/image6.jpg";

		originIcon = new ImageIcon(imgPath); // �̹��� ũ�� ���߱�
		originImg = originIcon.getImage();
		changedImg = originImg.getScaledInstance(118, 86, Image.SCALE_SMOOTH);
		ficon = new ImageIcon(changedImg);
		btn_image6.setIcon(ficon);

		btn_image6.setFont(new Font("HY����M", Font.PLAIN, 18));
		btn_image6.setBounds(287, 551, 118, 86);
		frame.getContentPane().add(btn_image6);

		// �ڹ��� ������ unlock
		JLabel lbl_unlock = new JLabel("");
		imgPath = "image/icon_unlock.png";

		originIcon = new ImageIcon(imgPath); // �̹��� ũ�� ���߱�
		originImg = originIcon.getImage();
		changedImg = originImg.getScaledInstance(23, 23, Image.SCALE_SMOOTH);
		ficon = new ImageIcon(changedImg);
		lbl_unlock.setIcon(ficon);

		lbl_unlock.setBounds(23, 388, 23, 23);
		frame.getContentPane().add(lbl_unlock);

		// �ڹ��� ������ lock
		JLabel lbl_lock = new JLabel("");
		imgPath = "image/icon_lock.png";

		originIcon = new ImageIcon(imgPath); // �̹��� ũ�� ���߱�
		originImg = originIcon.getImage();
		changedImg = originImg.getScaledInstance(23, 23, Image.SCALE_SMOOTH);
		ficon = new ImageIcon(changedImg);
		lbl_lock.setIcon(ficon);

		lbl_lock.setBounds(23, 526, 23, 23);
		frame.getContentPane().add(lbl_lock);

		// �����뿩 ��ư
		JButton btn_space = new JButton("\uACF5\uAC04\uB300\uC5EC");
		btn_space.setForeground(new Color(0, 0, 0));
		btn_space.setBackground(Color.WHITE);
		btn_space.setFont(new Font("�ؽ� ǲ����� B", Font.PLAIN, 19));

		btn_space.addMouseListener(new MouseAdapter() {

			@Override // ���콺�� ��ư ������ ������ �۾��� ���������� �ٲ�
			public void mouseEntered(MouseEvent e) {
				JButton btn_space = (JButton) e.getSource();
				btn_space.setForeground(Color.orange);
			}

			@Override // ���콺�� ��ư ������ ������ �����۾��� �ٲ�
			public void mouseExited(MouseEvent e) {
				JButton btn_space = (JButton) e.getSource();
				btn_space.setForeground(Color.black);
			}
		});
		// ���� �뿩 ��ư ������ ==> ���� �뿩 �������� �̵�
		btn_space.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				place_FestivalGUI pf = new place_FestivalGUI();
			}
		});
		btn_space.setBounds(286, 68, 122, 29);
		btn_space.setBorderPainted(false); // �׵θ� ����
		// btn_space.setFocusPainted(false); // ��Ŀ�� ǥ�� ����
		btn_space.setContentAreaFilled(false); // ��ư ��� �����ϰ� �ϱ�
		frame.getContentPane().add(btn_space);

		// ���� ���� ��ư ==> ���� Soon
		JButton btn_Soon = new JButton("\uCD95\uC81C Soon");
		btn_Soon.addMouseListener(new MouseAdapter() {

			@Override // ���콺�� ��ư ������ ������ �۾��� ���������� �ٲ�
			public void mouseEntered(MouseEvent e) {
				JButton btn_Soon = (JButton) e.getSource();
				btn_Soon.setForeground(Color.orange);
			}

			@Override // ���콺�� ��ư ������ ������ �����۾��� �ٲ�
			public void mouseExited(MouseEvent e) {
				JButton btn_Soon = (JButton) e.getSource();
				btn_Soon.setForeground(Color.black);
			}
		});
		
		// ���� �뿩 ��ư ������ ==> ���� �뿩 �������� �̵�
		btn_Soon.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						frame.dispose();
						List_GUI listgui = new List_GUI(null,0,0);
					}
				});
		
		
		btn_Soon.setBackground(Color.WHITE);
		btn_Soon.setFont(new Font("�ؽ� ǲ����� B", Font.PLAIN, 19));
		btn_Soon.setBounds(150, 68, 141, 29);

		btn_Soon.setBorderPainted(false); // �׵θ� ����
		btn_Soon.setFocusPainted(false); // ��Ŀ�� ǥ�� ����
		// btn_Soon.setContentAreaFilled(false); // ��ư ��� �����ϰ� �ϱ�

		frame.getContentPane().add(btn_Soon);

		// �������� ���� ��ư ==> ���� Go
		JButton btn_Go = new JButton("\uCD95\uC81C Go");
		btn_Go.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				festivalInfoGUI infogui = new festivalInfoGUI();
				frame.dispose();
			
			}
		});
		btn_Go.setBackground(Color.WHITE);
		btn_Go.addMouseListener(new MouseAdapter() {

			@Override // ���콺�� ��ư ������ ������ �۾��� ���������� �ٲ�
			public void mouseEntered(MouseEvent e) {
				JButton btn_Go = (JButton) e.getSource();
				btn_Go.setForeground(Color.orange);
			}

			@Override // ���콺�� ��ư ������ ������ �����۾��� �ٲ�
			public void mouseExited(MouseEvent e) {
				JButton btn_Go = (JButton) e.getSource();
				btn_Go.setForeground(Color.black);
			}
		});

		btn_Go.setFont(new Font("�ؽ� ǲ����� B", Font.PLAIN, 19));
		btn_Go.setBounds(23, 68, 109, 29);

		btn_Go.setBorderPainted(false); // �׵θ� ����
		btn_Go.setFocusPainted(false); // ��Ŀ�� ǥ�� ����
		// btn_Go.setContentAreaFilled(false); // ��ư ��� �����ϰ� �ϱ�

		frame.getContentPane().add(btn_Go);
		
		JLabel lblNewLabel = new JLabel("\uC9C4\uD589\uC911\uC778 \uCD95\uC81C");
		lblNewLabel.setFont(new Font("����", Font.BOLD, 15));
		lblNewLabel.setBounds(49, 394, 116, 18);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("\uC9C4\uD589\uC608\uC815 \uCD95\uC81C");
		label.setFont(new Font("����", Font.BOLD, 15));
		label.setBounds(49, 530, 116, 18);
		frame.getContentPane().add(label);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}