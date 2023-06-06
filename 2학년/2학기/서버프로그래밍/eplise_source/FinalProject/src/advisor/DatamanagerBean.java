package advisor;

import java.sql.*;
import java.util.ArrayList;

public class DatamanagerBean {
	int jobid=1;
	int emplid=1;
	
	private static DatamanagerBean instance = new DatamanagerBean();
	
	private DatamanagerBean() {}
	
	public static DatamanagerBean getInstance() {
		return instance;
	}
	
	private Connection getConnection() throws Exception {
		String jdbcUrl ="jdbc:mysql://localhost:3306/empldb";
		String dbUser = "root";
		String dbPass = "duksung";
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(jdbcUrl, dbUser, dbPass);
		return conn;
	}

	public void insertEmployee(EmployeeBean employee) {
		
		Connection conn=null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			String query = "select jobid from job where dept=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,employee.getDept());
			rs = pstmt.executeQuery();
			if(rs.next()){ //해당 부서가 있으면
				jobid = rs.getInt(1);
			}
			
			query = "select emplid from assignment where jobid=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,jobid);
			rs = pstmt.executeQuery();
			if(rs.next()){ //해당 고용번호 있으면
				emplid = rs.getInt(1);
			}
			
			query = "insert into assignment values(?,?,?,?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,employee.getEmplid());
			pstmt.setInt(2,jobid);
			pstmt.setString(3,employee.getStartdate());
			pstmt.setString(4,employee.getTermdate());
			pstmt.executeUpdate();
			
			query = "insert into employee values(?,?,?,?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,employee.getEmplid());
			pstmt.setString(2,employee.getName());
			pstmt.setString(3,employee.getAddress());
			pstmt.setInt(4,employee.getSsn());
			pstmt.executeUpdate();
		
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int userCheck(String id, String passwd) {
		Connection conn=null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		int x = -1; //해당 아이디 없음
		try {
			conn = getConnection();
			String query = "select ssn from employee where emplid = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();
			while(rs.next()) { // 해당 아이디가 있으면 수행
				String dbpasswd= rs.getString(1); 
				if(passwd.equals(dbpasswd))
					x= 1; // 인증성공
				else
					x= 0; // 비밀번호 틀림
			}
			
			if(rs !=null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch(Exception e ) {
			e.printStackTrace();
		}
		return(x);
	}
	
	public ArrayList<EmployeeBean> getEmployees(String deptName) {
		Connection conn=null;	
		ArrayList<EmployeeBean> employeeArray = new ArrayList<EmployeeBean>(10);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = "select employee.emplid, employee.name, employee.address, employee.ssn";
			sql += " from employee, job, assignment";
			sql += " where employee.emplid = assignment.emplid and ";
			sql += "job.jobid = assignment.jobid and job.dept=? and ";
			sql += "assignment.termdate is null";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,deptName);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				EmployeeBean employee = new EmployeeBean();
				employee.setEmplid(rs.getInt(1));
				employee.setName(rs.getString(2));
				employee.setAddress(rs.getString(3));
				employee.setSsn(rs.getInt(4));

				employeeArray.add(employee);
			}
			if(rs !=null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch(Exception e ) {
			e.printStackTrace();
		}
		return employeeArray;
	}
	
	public ArrayList<EmployeeBean> getNameDept(String emplid) {
		Connection conn=null;	
		ArrayList<EmployeeBean> employeeidArray = new ArrayList<EmployeeBean>(10);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//String result = "다시입력!";
		try {
			conn = getConnection();
			String sql = "select job.dept, employee.name";
			sql += " from employee, job, assignment";
			sql += " where employee.emplid = assignment.emplid and ";
			sql += "job.jobid = assignment.jobid and employee.emplid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,emplid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				EmployeeBean employee = new EmployeeBean();
				employee.setDept(rs.getString(1));
				employee.setName(rs.getString(2));
				
				employeeidArray.add(employee);
			}
			if(rs !=null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch(Exception e ) {
			e.printStackTrace();
		}
		return employeeidArray;
	}
}
