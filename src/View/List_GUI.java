package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Model.ListDAO;
import Model.ListDTO;
import Model.festivalDAO;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class List_GUI {

	private JFrame frame;
	private String festivalname;

	private JTable table;
	public String imgPath;
	public ImageIcon originIcon;
	public Image originImg;
	public Image changedImg;
	public ImageIcon ficon;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					List_GUI window = new List_GUI();
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
	public List_GUI(String f, int n, int m) {
		initialize(f,n,m);
		frame.setVisible(true);
	}
	

	//util.Date�� sql.Date�� ��ȯ
	public static java.sql.Date convert(java.util.Date uDate){
		java.sql.Date sDate = new java.sql.Date(uDate.getTime());
		return sDate;
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String f, int n, int m) {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("image/icon_Party.png"));
		frame.setResizable(false); // âũ�� ���� 
		frame.setBounds(100, 100, 621, 443);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC9C4\uD589\uC608\uC815 \uCD95\uC81C\uBAA9\uB85D");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("����", Font.BOLD, 25));
		lblNewLabel.setBounds(182, 21, 235, 27);
		frame.getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(47, 72, 497, 296);
		frame.getContentPane().add(scrollPane);
		scrollPane.setOpaque(false); // pane �����ϰ� 
		scrollPane.getViewport().setOpaque(false);
		
		String[] colName = {"��ȣ","������","���ۿ�����¥","���Ό����¥","�������","�׸�����","����","�����ο�","���Ŀ��ݾ�"};
		ListDAO dao = new ListDAO();
		ArrayList<ListDTO> FestivalList_1 = dao.Festivalinfo();
		//System.out.println(dao.Festivalinfo().get(1).getNum());
		Object[][] data = new Object[FestivalList_1.size()][9];
		//if(dao.Festivalinfo().get(6)>=dao.Festivalinfo().get(7)) {}
		
		int num2=1;
		for(int i=0;i<data.length;i++) {
			data[i][0]=num2;
			data[i][1]=FestivalList_1.get(i).getName();
			data[i][2]=FestivalList_1.get(i).getDay_start();
			data[i][3]=FestivalList_1.get(i).getDay_last();
			data[i][4]=FestivalList_1.get(i).getLoc();
			data[i][5]=FestivalList_1.get(i).getTheme();
			data[i][6]=FestivalList_1.get(i).getNum();
			data[i][7]=FestivalList_1.get(i).getN_num();
			data[i][8]=FestivalList_1.get(i).getMoney();
			num2++;
		}
		
		
		table = new JTable(data,colName);
		table.getColumn("���Ŀ��ݾ�").setWidth(0);
		table.getColumn("���Ŀ��ݾ�").setMinWidth(0);
		table.getColumn("���Ŀ��ݾ�").setMaxWidth(0);

		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				TableModel model = table.getModel();
				String f = (String) model.getValueAt(index, 1);
				int n = (int) model.getValueAt(index, 7);
				int m = (int) model.getValueAt(index, 8);
				//System.out.println(n+"List gui�� n");
				More_GUI more = new More_GUI(f,n,m);
				frame.dispose();

			}
		});
		scrollPane.setViewportView(table);
		
		// �ڷΰ��� ��ư
				JButton btn_back = new JButton("");
				
				imgPath = "image/icon_left.png";

				
		
		for(int i=0;i<data.length;i++) {
			if(FestivalList_1.get(i).getN_num()>=FestivalList_1.get(i).getNum()) {
			//delete ��Ű�� 
				festivalDAO festdao = new festivalDAO();
				java.sql.Date stDate = convert(FestivalList_1.get(i).getDay_start());
				java.sql.Date laDate = convert(FestivalList_1.get(i).getDay_last());
				//����
				festdao.PlusFest(FestivalList_1.get(i).getName(),stDate, laDate, FestivalList_1.get(i).getLoc(),FestivalList_1.get(i).getTheme(),FestivalList_1.get(i).getN_num());
				//db�ݰ�
				dao.delFest(FestivalList_1.get(i).getName()); //�����ʿ�
				System.out.println(FestivalList_1.get(i).getName());
				//insert ��Ű��
		}
		} 
	
		originIcon = new ImageIcon(imgPath); // �̹��� ũ�� ���߱�
		originImg = originIcon.getImage();
		changedImg = originImg.getScaledInstance(38, 38, Image.SCALE_SMOOTH);
		ficon = new ImageIcon(changedImg);
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
		
		JLabel lblNewLabel_1 = new JLabel("");
		imgPath = "image/info_Background.jpg";

		originIcon = new ImageIcon(imgPath); // �̹��� ũ�� ���߱�
		originImg = originIcon.getImage();
		changedImg = originImg.getScaledInstance(615, 411, Image.SCALE_SMOOTH);
		ficon = new ImageIcon(changedImg);
		lblNewLabel_1.setIcon(ficon);
		lblNewLabel_1.setBounds(0, 3, 615, 411);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		
		

	
	
	

		
	}
	

}
