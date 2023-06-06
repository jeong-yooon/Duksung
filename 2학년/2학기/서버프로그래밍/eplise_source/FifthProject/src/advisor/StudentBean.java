package advisor;

public class StudentBean {
	private int snum;
	private String name;
	private String id;
	private String passwd;
	private String phone;
	private String advisor_name;
	
	public int getSnum() {
		return snum;
	}
	public void setSnum(int snum) {
		this.snum = snum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAdvisor_name() {
		return advisor_name;
	}
	public void setAdvisor_name(String advisor_name) {
		this.advisor_name = advisor_name;
	}
	public String printStudent() {
		StringBuffer sb = new StringBuffer();
		sb.append("학번:" + snum);
		sb.append(" 이름:" + name);
		sb.append(" 지도교수:" + advisor_name);
		return sb.toString();
	}
}
