package View;
import java.awt.EventQueue;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Desktop;

import javax.swing.JTable;

import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableModel;

import Model.place_DAO;
import Model.place_DTO;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.Font;
import javax.swing.SwingConstants;

public class place_FestivalGUI2  
{

	private JFrame frame;
	private JTable table;
	private JButton btn_back;
	String model2;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					place_FestivalGUI2 window = new place_FestivalGUI2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}  */

	/**
	 * Create the application.
	 */
	

	
	public place_FestivalGUI2(String gegu) {
		initialize(gegu);
		frame.setVisible(true);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String gegu) {
		frame = new JFrame();
		frame.setBounds(100, 100, 668, 354);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 91, 618, 202);
		frame.getContentPane().add(scrollPane);
		
		String [] colName = {"번호", "지역구","업체명","업체주소"};
		
		place_DAO dao = new place_DAO();
			ArrayList<place_DTO> memberList = dao.selectPlace(gegu);
			Object [][] data = new Object[memberList.size()][4]; //2차원 배열 형성
			int num = 1;
			for(int i=0; i<data.length;i++) {
			data[i][0] = num;
			data[i][1] = memberList.get(i).getGegu();
			data[i][2] = memberList.get(i).getName();
			data[i][3] = memberList.get(i).getAddress();
			num ++;
			}
		
		table = new JTable(data,colName);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int index = table.getSelectedRow();
				TableModel model = table.getModel();
				 model2 = (String)table.getValueAt(index, 2);
			}
		});
		scrollPane.setViewportView(table);
		
		btn_back = new JButton("");
		String imgPath = "image/icon_left.png";
		ImageIcon originIcon = new ImageIcon(imgPath); // 이미지 크기 맞추기
		Image originImg = originIcon.getImage();
		Image changedImg = originImg.getScaledInstance(38, 38, Image.SCALE_SMOOTH);
		ImageIcon ficon = new ImageIcon(changedImg);
		btn_back.setIcon(ficon);
		
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				place_FestivalGUI maingui = new place_FestivalGUI();  //메인 화면으로 돌아가기
			}
		});
		btn_back.setContentAreaFilled(false); // 버튼 투명하게 하기
		btn_back.setBorderPainted(false); // 버튼 라인 없애기
		btn_back.setBounds(36, 28, 38, 38);
		frame.getContentPane().add(btn_back);
		
		JButton btnNewButton_1 = new JButton("\uB354\uBCF4\uAE30");
		btnNewButton_1.setFont(new Font("굴림", Font.BOLD, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<table.getRowCount();i++) {
					if(model2.equals(data[i][2])) {
						place_infoGUI info = new place_infoGUI(model2);
					}
				}
			}
		});
		btnNewButton_1.setBounds(514, 19, 116, 47);
		btnNewButton_1.setContentAreaFilled(false); // 버튼 투명하게 하기
		btnNewButton_1.setBorderPainted(false); // 버튼 라인 없애기
		frame.getContentPane().add(btnNewButton_1);
		
		
		lblNewLabel_1 = new JLabel("\uB300\uC5EC \uC5C5\uCCB4 \uBAA9\uB85D");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_1.setBounds(80, 19, 447, 62);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel = new JLabel("");
		imgPath = "image/info_Background.jpg";

		originIcon = new ImageIcon(imgPath); // 이미지 크기 맞추기
		originImg = originIcon.getImage();
		changedImg = originImg.getScaledInstance(652, 315, Image.SCALE_SMOOTH);
		ficon = new ImageIcon(changedImg);
		lblNewLabel.setIcon(ficon);
		
		lblNewLabel.setBounds(0, 0, 652, 315);
		frame.getContentPane().add(lblNewLabel);
		
		
	}
}
