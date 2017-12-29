package programs.examples.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.programs.database.Database;

import programs.examples.model.LoginModel;

public class RegisterDao 
{
	private static RegisterDao registerDao;
    
	@Autowired
	private Environment env;
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null ;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RegisterDao.class);

	private RegisterDao() {
	}

	public static RegisterDao getRegisterInstance() {
		if (registerDao == null)
			registerDao = new RegisterDao();
		return registerDao;
	}
	
	public void registerEmployeeByAdmin(LoginModel loginModel,Environment env){		
		try {
			Connection conn = Database.getConnection(env);
			String addEmployeeQuery = "insert into employee_login (loginid,password_hash,user_created_date,last_login_date,"
					+ "email,first_time_login values (?,?,?,?,?,?))";
			pstmt = conn.prepareStatement(addEmployeeQuery);
			if(conn!=null){
			   pstmt.setInt(1, loginModel.getUserid());
			   pstmt.setString(2, loginModel.getPassword_hash());
			   pstmt.setTimestamp(3, new java.sql.Timestamp(System.currentTimeMillis()));
			   pstmt.setTimestamp(4, new java.sql.Timestamp(loginModel.getLast_login_date()));
			   pstmt.setString(5, loginModel.getEmail());
			   pstmt.setInt(6, 0);
			   pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			LOGGER.error("Error while adding user [{}] with error [{}]",loginModel.toString(),e);
		}
	}
}
