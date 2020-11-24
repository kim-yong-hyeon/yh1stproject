package Model;

import java.util.Date;

public class ListDTO {
	
	private String name;
	private Date day_start;
	private Date day_last;
	private String loc;
	private String theme;
	private int num;
	private int n_num;
	private int money;
	
	public ListDTO(String name, Date day_start, Date day_last, String loc, String theme, int num, int n_num,
			int money) {
		super();
		this.name = name;
		this.day_start = day_start;
		this.day_last = day_last;
		this.loc = loc;
		this.theme = theme;
		this.num = num;
		this.n_num = n_num;
		this.money = money;
	}

	private String reply;
	
	public String getName() {
		return name;
	}

	public Date getDay_start() {
		return day_start;
	}

	public Date getDay_last() {
		return day_last;
	}

	public String getLoc() {
		return loc;
	}

	public String getTheme() {
		return theme;
	}

	public int getNum() {
		return num;
	}

	public int getN_num() {
		return n_num;
	}

	public String getReply() {
		return reply;
	}

	public int getMoney() {
		return money;
	}

	public ListDTO(String name, Date day_start, Date day_last, String loc, String theme, int num, int n_num,
			String reply, int money) {
		super();
		this.name = name;
		this.day_start = day_start;
		this.day_last = day_last;
		this.loc = loc;
		this.theme = theme;
		this.num = num;
		this.n_num = n_num;
		this.reply = reply;
		this.money = money;
	}


}
