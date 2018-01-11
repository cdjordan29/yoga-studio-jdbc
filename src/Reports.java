/**
 * Reports class generate the reports for P03
 * 
 * @authors Daniel
 * @version 12/7/2017
 */
public class Reports {
	/**Username and pass for Daniel**/ 	
	private String user = "cjordan29";
	private String pass = "password";
	
	/**
	 * classStudentDetail
	 * Simply returns the result from the given query, q1.
	 */
	public void classStudentDetail() {		
		String q1 = "select class_name, first, last from enroll inner join student on enroll.sid = student.sid order by last asc";
		DataSource d1 = new DataSource(user, pass);
		System.out.println(d1.getClassStudentDetail(q1));
	}

	/**
	 * instructorDetail
	 * Simply returns the result from the given query, q2.
	 */
	public void instructorDetail() {
		String q2 = "select fname, lname, class_name, count(sid) from enroll inner join instructor on enroll.tid = instructor.tid group by fname, lname, class_name";
		DataSource d2 = new DataSource(user, pass);
		System.out.println(d2.getInstructorDetail(q2));
	}

	/**
	 * studentDetail
	 * Simply returns the result from the given query, q3.
	 */
	public void studentDetail() {
		String q3 = "select first, last, exp_level, class_name from student inner join enroll on student.sid = enroll.sid";
		DataSource d3 = new DataSource(user, pass);
		System.out.println(d3.getStudentDetail(q3));
	}
	
}
