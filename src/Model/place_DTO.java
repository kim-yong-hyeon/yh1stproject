package Model;

public class place_DTO {

	String gegu;
	String name;
	String address;
	String tel;
	String homepage;
	
	

	public String getGegu() {
		return gegu;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}
	public String getTel() {
		return tel;
	}
	
	public String getHomepage() {
		return homepage;
	}
	
	public place_DTO( String gegu, String name, String address) {
		super();
		this.gegu = gegu;
		this.name = name;
		this.address = address;
	}
	
	public place_DTO(String name, String address, String tel, String homepage) {
		super();
		this.name = name;
		this.address = address;
		this.tel = tel;
		this.homepage = homepage;
	}
}
