package programs.examples.dao;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;

import com.programs.database.Database;

import programs.examples.model.LoginModel;
import programs.examples.utils.EmployeeHelper;

public class RegisterDao 
{
	private static RegisterDao registerDao;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RegisterDao.class);

	private RegisterDao() {
	}

	public static RegisterDao getRegisterInstance() {
		if (registerDao == null)
			registerDao = new RegisterDao();
		return registerDao;
	}
	
	public void registerEmployeeByAdmin(LoginModel loginModel,Environment env){		
		String addEmployeeQuery = "insert into employee_login (loginid,password_hash,user_created_date,"
				+ "email) values (?,?,?,?);";
		try(Connection conn = Database.getConnection(env);
				PreparedStatement pstmt = conn.prepareStatement(addEmployeeQuery);	
				) {
			
			if(conn!=null){
			   pstmt.setInt(1, loginModel.getUserid());
			   pstmt.setString(2, EmployeeHelper.getHashFromPassword(loginModel.getPassword_hash()));
			   pstmt.setTimestamp(3, new java.sql.Timestamp(System.currentTimeMillis()));
			   pstmt.setString(4, loginModel.getEmail());
			   pstmt.executeUpdate();
			}
		} catch (SQLException | NoSuchAlgorithmException e) {
			LOGGER.error("Error while adding user [{}] with error [{}]",loginModel.toString(),e);
		}
	}
		
}
