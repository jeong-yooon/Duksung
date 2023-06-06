package advisor;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseBean {
	private static DatabaseBean instance = new DatabaseBean();
	
	private DatabaseBean() {}
	
	public static DatabaseBean getInstance() {
		return instance;
	}
	
	private Connection getConnection() throws Exception {
		String jdbcUrl ="jdbc:mysql://localhost:3306/advisordb";
		String dbUser = "root";
		String dbPass = "duksung";
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(jdbcUrl, dbUser, dbPass);
		return conn;
	}

	public void insertStudent(StudentBean student) {
		Connection conn=null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		int advisor_id = 1;
		try {
			conn = getConnection();
			String query = "select pid from professor where name=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,student.getAdvisor_name());
			rs = pstmt.executeQuery();
			if(rs.next()){
				advisor_id = rs.getInt(1);
			}
			query = "insert into student values(?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,student.getSnum());
			pstmt.setString(2,student.getName());
			pstmt.setString(3,student.getId());
			pstmt.setString(4,student.getPasswd());
			pstmt.setString(5,student.getPhone());
			pstmt.setInt(6,advisor_id);
			pstmt.executeUpdate();
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
			if(conn != null) conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int userCheck(String id, String passwd) {
		Connection conn=null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		int x = -1;
		try {
			conn = getConnection();
			String query = "select passwd from student where id = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,id);

			rs = pstmt.executeQuery();
			while(rs.next()){
				String dbpasswd= rs.getString(1); 
				if(passwd.equals(dbpasswd))
					x = 1;
				else
					x = 0;
			}
			
			if(rs !=null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch(Exception e ) {
			e.printStackTrace();
		}
		return(x);
	}
	
	public ArrayList<StudentBean> getStudents(String advisor_name) {
		Connection conn=null;	
		ArrayList<StudentBean> studentArray = new ArrayList<StudentBean>(10);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String query = "select student.snum, student.name, student.id,";
			query += " student.passwd, student.phone";
			query += " from student, professor";
			query += " where student.advisor_id=professor.pid";
			query += " and professor.name=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,advisor_name);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				StudentBean student = new StudentBean();
				student.setSnum(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setId(rs.getString(3));
				student.setPasswd(rs.getString(4));
				student.setPhone(rs.getString(5));
				student.setAdvisor_name(advisor_name);
				studentArray.add(student);
			}
			if(rs !=null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch(Exception e ) {
			e.printStackTrace();
		}
		return studentArray;
	}
}
