 package Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class festivalDAO {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
	public void getConnect() {
		try { // 동적로딩하는부분
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// DB 연결하기
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String user_id = "hr";
			String user_pw = "hr";

			conn = DriverManager.getConnection(url, user_id, user_pw);

			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	//Close메소드 닫아주기
	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//진행중인 축제 목록을 보여주는 메소드.
	public ArrayList<festivalDTO> festivalSelect() {
		ArrayList<festivalDTO> memberList = new ArrayList<festivalDTO>();
		getConnect();
		String sql = "select ftitle,start_date,last_date,flocation,ftheme,now_num from pfestival";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				String ftitle = rs.getString(1);
				Date start_date = rs.getDate(2);
				Date last_date = rs.getDate(3);
				String flocation = rs.getString(4);
				String ftheme = rs.getString(5);
				int now_num = rs.getInt(6);
				memberList.add(new festivalDTO( ftitle, start_date,last_date, flocation, ftheme,now_num));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return memberList;
	}
	//진행 예정 축제 목록 추가하기.
	public int PlusFest(String ftitle,Date date,Date date2,String festPlace,String festTheme,int festMinmember) {
		int cnt =0;
		getConnect();
		//? 값 안넣어주면 오류 생김.
		String sql = "insert into pfestival values(?, ?, ?, ?, ?, ?)";
		try {
			psmt= conn.prepareStatement(sql);
			psmt.setString(1, ftitle);
			psmt.setDate(2, date);//애가 유틸데이트라고
			psmt.setDate(3, date2);
			psmt.setString(4, festPlace);
			psmt.setString(5, festTheme);
			psmt.setInt(6, festMinmember);
			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	} 
	

}