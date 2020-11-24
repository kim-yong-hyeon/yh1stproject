package Model;

import java.beans.Statement;
import java.lang.Thread.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class MembershipDAO {
	 
	// DAO : 데이터 접근 객체 , DB처리 클래스 ( DB연결, Select, update, insert, delete )
	// 데이터베이스에 접근하는 객체

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null; // 나중에 셀렉트문 들어올것을 대비해서 전역변수

		// * DB연결 getConnect 메소드 ==> 그대로 복사해오면 됨
		public void getConnect() {

			    // 1.동적로딩하기
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");

				// 2.DB연결
				String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
				String user_id = "hr";
				String user_pw = "hr";

				conn = DriverManager.getConnection(url, user_id, user_pw);

				if (conn != null) {
					System.out.println("가입성공");
				} else {
					System.out.println("가입실패");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// * 통로닫기 close 메소드 ==> 그대로 복사해오면 됨
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
				e.printStackTrace();
			}
		}
		
		// ** 로그인  확인 **
		public MembershipDTO loginSelect(String id, String pw) {
			
			getConnect();
			MembershipDTO dto =null;
			String sql = "select * from membership where id=? and pw=?";
			try {
				psmt = conn.prepareStatement(sql);
	
				psmt.setString(1, id);  
				psmt.setString(2, pw);
				rs = psmt.executeQuery();  
				while(rs.next()) {
					String loginid = rs.getString(1);
					String loginpw = rs.getString(2);
					String pwCheck = rs.getString(3);
					String sex = rs.getString(3);
					String email = rs.getString(4);
					String agegroup = rs.getString(5);
					dto = new MembershipDTO(loginid, loginpw, pwCheck,sex, email, agegroup);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			
			}finally {
				close();
			}
			return dto;
		}
		
		// ** 회원가입 **
		public int insertMember(MembershipDTO dto) {
		
			int cnt = 0;
			getConnect();
			String sql = " insert into membership values(?,?,?,?,?)";
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, dto.getId());
				psmt.setString(2, dto.getPw());
				// psmt.setString(3, dto.getPwcheck());
				psmt.setString(3, dto.getSex());
				psmt.setString(4, dto.getEmail());
				psmt.setString(5, dto.getAgegroup());

				cnt = psmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close();
			}
			return cnt;
		}
		
		// ** 중복체크  **  gui에서 어찌 구현??
		
		public boolean idoverlap(String id) {
			boolean result = false;
			getConnect();
			String sql = " select * from membership where id = ?";
			try{
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, id);
				rs = psmt.executeQuery();
				if(rs.next()) {
					result = true;
				}
			}catch (Exception e) {
					e.printStackTrace();
				}finally {
					try {rs.close();}catch(SQLException s) {}
					try {psmt.close();}catch(SQLException s) {}
					try {conn.close();}catch(SQLException s) {}
				}
			return result;
		}
}
//		public void idoverlap(String id) {
//			
//			getConnect();
//			int cnt = 0;
//			psmt = null;
//			rs = null;
//		     String sql = " select * from membership where id = ?";
//		     
//		     try {
//					psmt = conn.prepareStatement(sql.toString());
//					psmt.setString(1, id); // 첫번째 ?에 id 변수값 지정
//				    rs = psmt.executeQuery(); // SQL 실행
//					
//				    if ( rs.next() == true ) { // 최초 첫번째 레코드로 이동
//						cnt = psmt.executeUpdate();
//				    }  else {
//						JOptionPane.showMessageDialog(null,  "사용 가능한 ID입니다.");
//				    }        
//		        }catch(Exception e){
//		            System.out.println(e.toString());
//		        }finally{
//		            close();
//		        }
//		       
//		     
//		    }
				    
//			try {
//				psmt = conn.prepareStatement(sql);
//				psmt.setString(1, id);
//				rs = psmt.executeQuery();
//				
//				if(rs.next()) {
//					JOptionPane.showMessageDialog(null, "이미 사용중인 ID입니다.");
//					conn.close();
//				}else {
//					JOptionPane.showMessageDialog(null,  "사용 가능한 ID입니다.");
//					conn.close();
//				}	
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//			}finally {
//				close();
	

	
		
		

