package advisor;

public class EmployeeBean {
	private int emplid;
	private String name;
	private String address;
	private int ssn;
	private String dept;
	private String startdate;
	private int jobid;
	
	public int getEmplid() {
		return emplid;
	}
	public void setEmplid(int emplid) {
		this.emplid = emplid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	public String getDept() {
		String[] array = dept.split(" ");
		return array[0];
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getJobtitle() {
		String[] array = dept.split(" ");
		return array[1];
	}
	/*
	public void setJobtitle(String jobtitle) {
		this.dept = dept;
	}
	*/
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public int getJobid() {
		int num = 0;
		if(dept == "사장") num = 1;
		else if(dept == "영업부 차장") num = 30;
		else if(dept == "영업부 매장주임") num = 5;
		else if(dept == "영업부 부장") num = 6;
		else if(dept == "인사부 부장") num = 10;
		else if(dept == "인사부 과장") num = 11;
		else if(dept == "경리부 사원") num = 24;
		else if(dept == "인사부 비서") num = 25;
		else if(dept == "경리부 비서") num = 26;
		else if(dept == "영업부 과장") num = 29;
		
		return num;
	}
	public String getTermdate() {
		String termdate = null;
		return termdate;
	}
}
