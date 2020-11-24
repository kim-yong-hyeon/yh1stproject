package Model;

public class Festival_DTO {
	
	private String festName;
	private String festDate ;
	private String festPlace;
	private String festTheme;
	private String festMinmember;
	private String festWho;
	
	
	public Festival_DTO(String festName, String festDate, String festPlace, String festTheme, String festMinmember,
			String festWho) {
		super();
		this.festName = festName;
		this.festDate = festDate;
		this.festPlace = festPlace;
		this.festTheme = festTheme;
		this.festMinmember = festMinmember;
		this.festWho = festWho;
	}
	
	public String getFestName() {
		return festName;
	}

	public String getFestDate() {
		return festDate;
	}

	public String getFestPlace() {
		return festPlace;
	}

	public String getFestTheme() {
		return festTheme;
	}

	public String getFestMinmember() {
		return festMinmember;
	}

	public String getFestWho() {
		return festWho;
	}

	
	
	
	
}
