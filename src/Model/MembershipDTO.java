package Model;
public class MembershipDTO {
	
	// DTO : 데이터 전송(이동) 객체 , DB처리하는데 이용, 테이블의 한 레코드
	// 한명의 회원정보를 저장하는 클래스
	
	private String id;
	private String pw;
	private String pwCheck;
	private String sex;
	private String email;
	private String agegroup;
	
	public MembershipDTO(String id, String pw, String pwCheck, String sex, String email, String agegroup) {
		super();
		this.id = id;
		this.pw = pw;
		this.pwCheck = pwCheck;
		this.sex = sex;
		this.email = email;
		this.agegroup = agegroup;
	}

	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	public String getPwCheck() {
		return pwCheck;
	}

	public String getSex() {
		return sex;
	}

	public String getEmail() {
		return email;
	}

	public String getAgegroup() {
		return agegroup;
	}

}
