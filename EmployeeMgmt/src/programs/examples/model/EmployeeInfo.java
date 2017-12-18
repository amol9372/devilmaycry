package programs.examples.model;

public class EmployeeInfo 
{
	private int userId;
	private String fname;
	private String lname;
	private char gender;
	private String mobile;
	private String email_official;
	private String deptId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail_official() {
		return email_official;
	}

	public void setEmail_official(String email_official) {
		this.email_official = email_official;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	@Override
	public String toString() {
		return "EmployeeInfo [userId=" + userId + ", fname=" + fname + ", lname=" + lname + ", gender=" + gender
				+ ", mobile=" + mobile + ", email_official=" + email_official + ", deptId=" + deptId + "]";
	}

}
