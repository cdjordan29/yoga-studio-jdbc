import java.sql.*;
/**
 * DataSource class contains all interactions with the database.
 * 
 * @authors Daniel
 * @version 12/7/2017
 */
public class DataSource {

	private String user, pass;

	/**
	 * Constructor that establishes the JDBC connection.
	 */
	public DataSource(String _user, String _pass) {
		// initializing the username and password for DB connection.
		this.user = _user;
		this.pass = _pass;
		try {
			//establishing the database connection and the correct username and password
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		} catch (SQLException e) {
			System.out.println("Could not establish a connection the database, error: " + e);
		}
	}

	/**
	 * getClassStudentDetail : [String] -> [String]
	 * Returns the results from the database based on the given query q.
	 * @param q 
	 * @return Results from columns class_name, first, and last.
	 */
	public String getClassStudentDetail(String q) {
		String resultSoFar = "";
		int countSoFar = 0;
		try{
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@Picard2.radford.edu:1521:itec2", user, pass);
		Statement stmt = conn.createStatement();
		ResultSet rset = stmt.executeQuery(q);
	
			while(rset.next()){
				resultSoFar += "-" + rset.getString("class_name") + " " + 
			                         rset.getString("first") + " " +
						             rset.getString("last") + "\n";
				countSoFar++;
			}
			conn.close();
		} catch (SQLException e){
			System.out.println("Could not execute query for Class/Student Detail, error: " + e);
		}
		return "-----CLASS/STUDENT DETAILS-----" + "\n" + 
		       resultSoFar + "\n" +
		       "-----Returned " + Integer.toString(countSoFar) + " rows -----" + "\n" + "\n";
	}

	/**
	 * getInstructorDetail : [String] -> [String]
	 * Returns the results from the database based on the given query q
	 * @param q 
	 * @return results from columns fname, lname, class_name, and count(sid)
	 */
	public String getInstructorDetail(String q) {
		String resultSoFar = "";
		int countSoFar = 0;
		try{
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@Picard2.radford.edu:1521:itec2", user, pass);
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(q);
		
				while(rset.next()){
					resultSoFar += "-" + rset.getString("fname") + " " +
				                         rset.getString("lname") + " " + 
							             rset.getString("class_name") + " " + 
				                         rset.getString("count(sid)") + "\n";
					countSoFar++;
				}
				conn.close();
			} catch (SQLException e){
				System.out.println("Could not execute query for Instructor Detail, error: " + e);
			}
		return "-----INSTRUCTOR DETAILS-----" + "\n" + 
			   resultSoFar + "\n" +
		       "-----Returned " + Integer.toString(countSoFar) + " rows -----" + "\n" + "\n";
	}

	/**
	 * getClassStudentDetail : [String] -> [String]
	 * Returns the results from the database based on the given query q.
	 * @param q 
	 * @return Results from columns first, last, exp_level, and class_name
	 */
	public String getStudentDetail(String q) {
		String resultSoFar = "";
		int countSoFar = 0;
		try{
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@Picard2.radford.edu:1521:itec2", user, pass);
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(q);
		
				while(rset.next()){
					resultSoFar += "-" + rset.getString("first") + " " +
				                         rset.getString("last") + " " + 
							             rset.getString("exp_level") + " " + 
				                         rset.getString("class_name") + "\n";
					countSoFar++;
				}
				conn.close();
			} catch (SQLException e){
				System.out.println("Could not execute query for Student Detail, error: " + e);
			}
		return "-----STUDENT DETAIL-----" + "\n" +
			    resultSoFar + "\n" + 
			    "-----Returned " + Integer.toString(countSoFar) + " rows -----" + "\n" + "\n";
	}
}
