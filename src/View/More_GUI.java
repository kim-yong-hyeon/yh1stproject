package View;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

import javax.swing.SwingConstants;

import Model.ListDAO;
import java.awt.Font;
import java.awt.Color;

public class More_GUI {

	private JFrame frame;
	private JTextField F_name;
	private List_GUI me;
	int sum;
	int sum_money;

	// �̹��� ũ�� ���⶧ �ʿ�
	public String imgPath;
	public ImageIcon originIcon;
	public Image originImg;
	public Image changedImg;
	public ImageIcon ficon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					More_GUI window = new More_GUI();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
	}

	/**
	 * Create the application.
	 * 
	 * @wbp.parser.entryPoint
	 */
	public More_GUI(String f, int n, int m) {// (String name)
		initialize(f, n, m);
		// (name)
		frame.setVisible(true);
	}
//	public More_GUI(List_GUI me, String index){
////		super(me,"���̾�α�");
//		this.me=me;
//	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String f, int n, int m) {// (String name)
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("image/icon_Party.png"));
		frame.setResizable(false); // âũ�� ����
		frame.setBounds(100, 100, 621, 443);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		// System.out.println(n+"More_GUI�� n ���� �����ϸ�ǰ���?");
		JLabel Now_num = new JLabel("���� �ο��� " + n + "�� �Դϴ�!");
		Now_num.setFont(new Font("���� ���", Font.BOLD, 16));
		Now_num.setHorizontalAlignment(SwingConstants.CENTER);
		Now_num.setBounds(86, 285, 187, 29);
		frame.getContentPane().add(Now_num);

		sum = n;
		JButton btn_join = new JButton("\uCC38\uC5EC\uD558\uAE30");
		btn_join.setFont(new Font("����", Font.BOLD, 15));
		btn_join.setBackground(Color.ORANGE);
		btn_join.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "�����Ͻðڽ��ϱ�?", "��������", JOptionPane.YES_NO_OPTION);

				if (result == JOptionPane.YES_OPTION) {
					sum = sum + 1;
					Now_num.setText("���� �ο��� " + (sum) + "�� �Դϴ�!");

				} else if (result == JOptionPane.NO_OPTION) {
					Now_num.setText("���� �ο��� " + (sum) + "�� �Դϴ�!");
				}
				System.out.println(sum);
			}
		});

		btn_join.setBounds(128, 343, 113, 31);
		frame.getContentPane().add(btn_join);

		JLabel Now_money = new JLabel("�Ŀ��ݾ��� " + m + "�� �Դϴ�!");
		Now_money.setFont(new Font("���� ���", Font.BOLD, 16));
		Now_money.setHorizontalAlignment(SwingConstants.CENTER);
		Now_money.setBounds(334, 285, 191, 29);
		frame.getContentPane().add(Now_money);

		sum_money = m;
		JButton btn_support = new JButton("\uD6C4\uC6D0\uD558\uAE30");
		btn_support.setFont(new Font("����", Font.BOLD, 15));
		btn_support.setBackground(Color.ORANGE);
		btn_support.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Support, result;
				Support = JOptionPane.showInputDialog("�Ŀ� �ݾ��� �Է��Ͻÿ� >>");
				int money = Integer.parseInt(Support);
				if (money > 0) {
					result = "�Ŀ� ����帳�ϴ� ��";
					JOptionPane.showMessageDialog(null, result);
					sum_money = sum_money + money;
					Now_money.setText("�Ŀ��ݾ��� " + sum_money + "�� �Դϴ�!");
				} else if (money < 0) {
					result = "�ݾ��� �Է��� �ּ���!";
					JOptionPane.showMessageDialog(null, result);
				}

			}
		});
		btn_support.setBounds(267, 343, 113, 31);
		frame.getContentPane().add(btn_support);

		JButton btn_comment = new JButton("\uC758\uACAC\uB0A8\uAE30\uAE30");
		btn_comment.setFont(new Font("����", Font.BOLD, 15));
		btn_comment.setBackground(Color.ORANGE);
		btn_comment.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				Reply_GUI re_gui = new Reply_GUI(f, m, m);
			}
		});
		btn_comment.setBounds(405, 343, 113, 31);
		frame.getContentPane().add(btn_comment);

		// �ڷΰ��� ��ư
		JButton btn_back = new JButton("");
		imgPath = "image/icon_left.png";

		originIcon = new ImageIcon(imgPath); // �̹��� ũ�� ���߱�
		originImg = originIcon.getImage();
		changedImg = originImg.getScaledInstance(38, 38, Image.SCALE_SMOOTH);
		ficon = new ImageIcon(changedImg);
		btn_back.setIcon(ficon);

		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ListDAO dao = new ListDAO();
				dao.Update_num(sum, f);
				dao.Update_money(sum_money, f);
				List_GUI List = new List_GUI(f, m, m); // ����Ʈ ȭ������ ���ư���
			}
		});
		btn_back.setContentAreaFilled(false); // ��ư �����ϰ� �ϱ�
		btn_back.setBorderPainted(false); // ��ư ���� ���ֱ�
		btn_back.setBounds(36, 28, 38, 38);
		frame.getContentPane().add(btn_back);

		F_name = new JTextField(f);
		F_name.setHorizontalAlignment(SwingConstants.CENTER);
		F_name.setBounds(219, 28, 220, 34);
		frame.getContentPane().add(F_name);
		F_name.setColumns(10);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setText(
				"<html><body>\t\r\n\t\uAD11\uC8FC \uC720\uC77C\uC758 \uD06C\uB9AC\uC2A4\uB9C8\uC2A4 \uD2B8\uB9AC\uCD95\uC81C! <br>\r\n\t\uB2E4\uC591\uD55C \uD2B8\uB9AC 180\uC5EC\uAC1C \uC810\uB4F1 \uBC0F <br>\r\n\t\uC774\uC6C3\uC0AC\uB791 \uC2E4\uCC9C \uB098\uB214 \uC74C\uC545\uD68C <br>\r\n\t\uB4F1 \uB2E4\uC591\uD55C \uD504\uB85C\uADF8\uB7A8 \uC5D0\uC815 <br>\r\n\t\r\n\t\uC77C\uC2DC 12\uC6D4 , \uC7A5\uC18C \uC591\uB9BC\uC624\uAC70\uB9AC<br>\r\n\r\n\t\uC591\uB9BC\uB3D9\uC5D0\uC11C \uC800\uBB3C\uC5B4\uAC00\uB294 \uD55C\uD574\uB97C <br>\r\n\t\uC815\uB9AC\uD558\uBA70 \uC18C\uC911\uD55C \uCD94\uC5B5\uC313\uAE30!!\r\n\r\n\r\n");
		lblNewLabel.setBounds(44, 96, 258, 150);
		frame.getContentPane().add(lblNewLabel);

		// ������ ����
		JButton btn_poster = new JButton("");
		
		imgPath = "image/image4.jpg";

		originIcon = new ImageIcon(imgPath); // �̹��� ũ�� ���߱�
		originImg = originIcon.getImage();
		changedImg = originImg.getScaledInstance(243, 140, Image.SCALE_SMOOTH);
		ficon = new ImageIcon(changedImg);
		btn_poster.setIcon(ficon);

		btn_poster.setBounds(328, 106, 243, 140);
		frame.getContentPane().add(btn_poster);
		
		btn_poster.setBorderPainted(false); // �׵θ� ����
		btn_poster.setFocusPainted(false); // ��Ŀ�� ǥ�� ����
		
		//Ÿ��Ʋ
		JLabel lblNewLabel_1 = new JLabel(
				"\uAD11\uC8FC \uC720\uC77C\uC758 \uD06C\uB9AC\uC2A4\uB9C8\uC2A4 \uD2B8\uB9AC\uCD95\uC81C! ");
		lblNewLabel_1.setFont(new Font("HY�߰��", Font.BOLD, 16));
		lblNewLabel_1.setBounds(66, 76, 270, 18);
		frame.getContentPane().add(lblNewLabel_1);

		// ����̹���
		JLabel lbl_Background = new JLabel("");
		lbl_Background.setToolTipText("");

		imgPath = "image/info_Background.jpg";

		originIcon = new ImageIcon(imgPath); // �̹��� ũ�� ���߱�
		originImg = originIcon.getImage();
		changedImg = originImg.getScaledInstance(614, 424, Image.SCALE_SMOOTH);
		ficon = new ImageIcon(changedImg);
		lbl_Background.setIcon(ficon);

		lbl_Background.setBounds(1, 0, 614, 424);
		frame.getContentPane().add(lbl_Background);


	}
}