package Model;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

import com.toedter.calendar.JDateChooser;

public class ListDAO {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	public void getConnect() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// DB연결
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String user_id = "hr";
			String user_pw = "hr";

			conn = DriverManager.getConnection(url, user_id, user_pw);

			if (conn != null) {
				System.out.println("연결 성공");
			} else {
				System.out.println("연결 실패");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void close() {

		try {
			if (rs != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();

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

	public ArrayList<ListDTO> Festivalinfo() {
		getConnect();
		String sql = "select name,day_start,day_last,loc,theme,num,n_num,money from List_F";
		ArrayList<ListDTO> FestivalList_1 = new ArrayList<ListDTO>();
		try {
			psmt = conn.prepareStatement(sql);
			
			rs = psmt.executeQuery();

			while (rs.next()) {
				String name = rs.getString(1);
				Date day_start = rs.getDate(2); // 날짜는 date사용해주고 Date import도 해줘야됨
				Date day_last = rs.getDate(3);
				String loc = rs.getString(4);
				String theme = rs.getString(5);
				int num = rs.getInt(6);
				int n_num = rs.getInt(7);
				int money = rs.getInt(8);
				// DTO애 담아 ㅁArrayList에 다시담기
				FestivalList_1.add(new ListDTO(name, day_start,day_last, loc, theme, num, n_num,money));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return FestivalList_1;
	}

	
	
	
	
	public int Update_num(int n, String name) {

		getConnect();
		String sql = "update List_F set  n_num =? where name =?";
		int cnt = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, n);
			psmt.setString(2, name);
			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return n;

	}
	public int Update_money(int m,String name) {	
		getConnect();
		String sql = "update List_F set  money =? where name =?";
		int cnt = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, m);
			psmt.setString(2, name);
			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		System.out.println(m);
		return m;
		
	}
	

	
	public int joinFest(String festName,Date date,Date date2,String festPlace,String festTheme,int festMinmember) {
		int cnt =0;
		getConnect();
		String sql = "insert into List_F(name,day_start,day_last,loc,theme,num) values(?,?,?,?,?,?)";
		try {
			psmt= conn.prepareStatement(sql);
			psmt.setString(1, festName);
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

	public int delFest(String name) {
		getConnect();
		int cnt = 0;
		String sql = "delete from List_F where name = ? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
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
