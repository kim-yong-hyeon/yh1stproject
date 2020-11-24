package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class place_DAO {
	

	Connection conn = null;
	PreparedStatement psmt =null;
	ResultSet rs = null;
	
	public void getConnect() {
	//1.동적로딩
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//2.DB 연결
		String url ="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user_id = "hr";
		String user_pw = "hr";
		
		 conn = DriverManager.getConnection(url, user_id, user_pw);
		
		if(conn != null) {
			System.out.println("연결성공");
			} else {
			System.out.println("연결실패");
			}
		} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			if(rs != null) {
				rs.close();
			}
			if(psmt != null) {
			psmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
	}
	
	public ArrayList<place_DTO> selectPlace(String where) {
		getConnect();
		String sql = "select gegu,name,address from place where gegu=?";
		ArrayList<place_DTO> memberList = new ArrayList<place_DTO>();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, where);
			rs = psmt.executeQuery();
			while(rs.next()) {
				
				String gegu = rs.getString(1);
				String name = rs.getString(2);
				String address = rs.getString(3);
				memberList.add(new place_DTO(gegu,name,address));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		} return memberList;}
	
		
		public ArrayList<place_DTO> selectInfo(String name2) {
			getConnect();
			String sql = "select name,address,tel,homepage from place where name=?";
			ArrayList<place_DTO> memberList2 = new ArrayList<place_DTO>();
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, name2);
				rs = psmt.executeQuery();
				while(rs.next()) {
					String name = rs.getString(1);
					String address = rs.getString(2);
					String tel = rs.getString(3);
					String homepage = rs.getString(4);
					memberList2.add(new place_DTO(name, address,tel,homepage));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				close();
			} 
			return memberList2;
	} 
	
	
	
}
