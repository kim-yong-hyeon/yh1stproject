package View;



import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Model.ListDAO;
import Model.ListDTO;
import View.More_GUI;

import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

public class Reply_GUI {

	private JFrame frame;
	private JTextField txt_comments;
	private JTable table;
	
	// 이미지 크기 맞출때 필요
		public String imgPath;
		public ImageIcon originIcon;
		public Image originImg;
		public Image changedImg;
		public ImageIcon ficon;
		public ImageIcon ficon1;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Reply_GUI window = new Reply_GUI(n,m,f);
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
	public Reply_GUI(String f, int n, int m) {
		initialize(f,n,m);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String f, int n, int m) {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("image/icon_Party.png"));
		frame.setResizable(false); // 창크기 조절 
		frame.setBounds(100, 100, 424, 407);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Vector<String> colNames;
		Vector<Vector<String>> rowData;
		
		colNames = new Vector<String>();
		rowData = new Vector<Vector<String>>();
		
		colNames.add("찾고 있던 축제인데 광주에서 열린다니...♥");
		
		rowData.add(colNames);
		Vector<String> re =new Vector<String>();
	
		// 전체댓글 리스트 공간
		table = new JTable(rowData,colNames);
		table.setBounds(34, 193, 353, 139);
		frame.getContentPane().add(table);
		
		// 의견남기는 공간
		txt_comments = new JTextField();
		txt_comments.setBounds(34, 73, 353, 60);
		frame.getContentPane().add(txt_comments);
		txt_comments.setColumns(10);
		
		// 의견 등록 버튼
		JButton btn_insert = new JButton("\uB4F1\uB85D");
		btn_insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			String reply =txt_comments.getText();
			Vector<String> v =new Vector<String>();
			v.add(reply);
			rowData.add(v);
			
			table.updateUI();
			
		    txt_comments.setText("");
			}
		});
		btn_insert.setBounds(290, 136, 97, 23);
		frame.getContentPane().add(btn_insert);
		
		
		// 의견 삭제 버튼
		JButton btn_delete = new JButton("\uC0AD\uC81C");
		btn_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selection = table.getSelectedRow();
				rowData.remove(selection);
				table.updateUI();
			}
		});
		
	  
		btn_delete.setBounds(290, 337, 97, 23);
		frame.getContentPane().add(btn_delete);
		
		JLabel lblNewLabel = new JLabel("=== \uC804\uCCB4 \uB313\uAE00 ===");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 17));
		lblNewLabel.setBounds(134, 172, 158, 18);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("\uC758\uACAC\uB0A8\uAE30\uAE30");
		label.setFont(new Font("굴림", Font.BOLD, 13));
		label.setBounds(34, 53, 77, 18);
		frame.getContentPane().add(label);
		
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
				More_GUI moregui = new More_GUI(f, m, m);  //메인 화면으로 돌아가기
			}
		});
		btn_back.setContentAreaFilled(false); // 버튼 투명하게 하기
		btn_back.setBorderPainted(false); // 버튼 라인 없애기
		btn_back.setBounds(14, 12, 38, 38);
		frame.getContentPane().add(btn_back);
		
		
		// 배경이미지
		JLabel lbl_Background = new JLabel("");
		

		imgPath = "image/info_Background.jpeg";

		originIcon = new ImageIcon(imgPath); // 이미지 크기 맞추기
		originImg = originIcon.getImage();
		changedImg = originImg.getScaledInstance(424, 407, Image.SCALE_SMOOTH);
		ficon = new ImageIcon(changedImg);
		lbl_Background.setIcon(ficon);

		
		lbl_Background.setBounds(1, 0, 424, 407);
		frame.getContentPane().add(lbl_Background);
		
}
		
	}