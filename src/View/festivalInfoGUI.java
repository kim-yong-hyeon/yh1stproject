package View;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Model.festivalDAO;
import Model.festivalDTO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class festivalInfoGUI {

	private JFrame frame;
	private JTable table;
	JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					festivalInfoGUI window = new festivalInfoGUI();
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
	public festivalInfoGUI() {
		initialize();
		frame.setVisible(true);
	}
	
	public static java.sql.Date convert(java.util.Date uDate){
		java.sql.Date sDate = new java.sql.Date(uDate.getTime());
		return sDate;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 621, 443);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("\uD604\uC7AC \uC9C4\uD589\uC911\uC778 \uCD95\uC81C");
		lblNewLabel.setFont(new Font("���� ���", Font.BOLD, 23));
		lblNewLabel.setBounds(206, 35, 221, 31);
		frame.getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 88, 548, 287);
		frame.getContentPane().add(scrollPane);
		scrollPane.setOpaque(false); // pane �����ϰ�
		
		String[] colName = { "������", "����������","����������", "�������", "�׸�","�����ο�"};
		festivalDAO dao = new festivalDAO();
		ArrayList<festivalDTO> memberList = dao.festivalSelect();
		Object[][] data = new Object[memberList.size()][6];
		
		for(int i = 0; i < data.length; i++) {
			
			data[i][0] = memberList.get(i).getFtitle();
			data[i][1] = memberList.get(i).getStart_date();
			data[i][2] = memberList.get(i).getLast_date();
			data[i][3] = memberList.get(i).getFlocation();
			data[i][4] = memberList.get(i).getFtheme();
			data[i][5] = memberList.get(i).getNow_number();
			
		}
		
		
		table = new JTable(data, colName);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				place_FestivalGUI festgui = new place_FestivalGUI();
			
			}
		});
		scrollPane.setViewportView(table);
		
		// �ڷΰ��� ��ư
				JButton btn_back = new JButton("");
				
				String imgPath = "image/icon_left.png";

				ImageIcon originIcon = new ImageIcon(imgPath); // �̹��� ũ�� ���߱�
				Image originImg = originIcon.getImage();
				Image changedImg = originImg.getScaledInstance(38, 38, Image.SCALE_SMOOTH);
				ImageIcon ficon = new ImageIcon(changedImg);
				btn_back.setIcon(ficon);
				
				btn_back.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame.dispose();
						mainGUI maingui = new mainGUI();  //���� ȭ������ ���ư���
					}
				});
				btn_back.setContentAreaFilled(false); // ��ư �����ϰ� �ϱ�
				btn_back.setBorderPainted(false); // ��ư ���� ���ֱ�
				btn_back.setBounds(36, 28, 38, 38);
				frame.getContentPane().add(btn_back);
				
				// ����̹���
				JLabel lbl_Background = new JLabel("");
				imgPath = "image/info_Background.jpg";

				originIcon = new ImageIcon(imgPath); // �̹��� ũ�� ���߱�
				originImg = originIcon.getImage();
				changedImg = originImg.getScaledInstance(614, 408, Image.SCALE_SMOOTH);
				ficon = new ImageIcon(changedImg);
				lbl_Background.setIcon(ficon);

				
				lbl_Background.setBounds(1, 0, 614, 408);
				frame.getContentPane().add(lbl_Background);
				
	}
}