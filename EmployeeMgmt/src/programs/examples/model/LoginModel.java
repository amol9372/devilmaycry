package programs.examples.model;

public class LoginModel 
{
	private int userid;
	private String password_hash;
	private String user_created_date;
	private String last_login_date;
	private String email;

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getPassword_hash() {
		return password_hash;
	}

	public void setPassword_hash(String password_hash) {
		this.password_hash = password_hash;
	}

	public String getUser_created_date() {
		return user_created_date;
	}

	public void setUser_created_date(String user_created_date) {
		this.user_created_date = user_created_date;
	}

	public String getLast_login_date() {
		return last_login_date;
	}

	public void setLast_login_date(String last_login_date) {
		this.last_login_date = last_login_date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "LoginModel [userid=" + userid + ", password_hash=" + password_hash + ", user_created_date="
				+ user_created_date + ", last_login_date=" + last_login_date + ", email=" + email + "]";
	}

}
