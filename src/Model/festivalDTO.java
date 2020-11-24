package Model;

import java.sql.Date;

public class festivalDTO {
	
	private String ftitle;
	private Date start_date;
	private Date last_date;
	private String flocation;
	private String ftheme;
	private int now_number;
	
	public festivalDTO(String ftitle, Date start_date, Date last_date, String flocation, String ftheme,
			int now_number) {
		super();
		this.ftitle = ftitle;
		this.start_date = start_date;
		this.last_date = last_date;
		this.flocation = flocation;
		this.ftheme = ftheme;
		this.now_number = now_number;
	}
	public String getFtitle() {
		return ftitle;
	}
	public Date getStart_date() {
		return start_date;
	}
	public Date getLast_date() {
		return last_date;
	}
	public String getFlocation() {
		return flocation;
	}
	public String getFtheme() {
		return ftheme;
	}
	public int getNow_number() {
		return now_number;
	}
	
	
	

}