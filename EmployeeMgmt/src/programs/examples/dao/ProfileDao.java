package programs.examples.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import com.programs.database.Database;

import programs.examples.model.EmployeeInfo;
import programs.examples.model.LoginModel;

@Repository
public class ProfileDao {
	@Autowired
	private Environment env;

	private static final Logger LOGGER = LoggerFactory.getLogger(ProfileDao.class);

	public EmployeeInfo getEmployeeInfoWithoutAddress(int empid) {
		EmployeeInfo employeeInfo = new EmployeeInfo();
		String getEmployeeInfoQuery = "select * from employee_info where empid = ?;";
		try (Connection conn = Database.getConnection(env);
				PreparedStatement pstmt = conn.prepareStatement(getEmployeeInfoQuery);) {
			pstmt.setInt(1, empid);

			ResultSet resultSet = pstmt.executeQuery();
			if (conn != null) {
				while (resultSet.next()) {
					employeeInfo.setUserId(resultSet.getInt("empid"));
					employeeInfo.setEmail(resultSet.getString("email"));
					employeeInfo.setDate_of_joinig(resultSet.getDate("date_of_joining"));
					employeeInfo.setProfileStatus(resultSet.getString("fname"));
					employeeInfo.setFname(resultSet.getString("fname") == null ? "" : resultSet.getString("fname"));
					employeeInfo.setLname(resultSet.getString("lname") == null ? "" : resultSet.getString("lname"));
					employeeInfo.setMobile(resultSet.getString("mobile_official") == null ? ""
							: resultSet.getString("mobile_official"));
					employeeInfo.setEmail_official(
							resultSet.getString("email_official") == null ? "" : resultSet.getString("email_official"));
				}

			}
		} catch (SQLException e) {
			LOGGER.error("Error while fetching EmployeeInfo [{}] with error [{}]", empid, e);

		}
		return employeeInfo;
	}
}
