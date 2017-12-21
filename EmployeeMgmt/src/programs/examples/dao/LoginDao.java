package programs.examples.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import programs.examples.model.EmployeeInfo;

public class LoginDao 
{
   private static LoginDao loginDao;
   
   private static final Logger LOGGER = LoggerFactory.getLogger(LoginDao.class);
   
   private LoginDao(){}
   
   public static LoginDao getLoginInstance(){
	   if(loginDao == null)
		   loginDao = new LoginDao();
	   return loginDao;
   }
   
   public EmployeeInfo getEmployeeInfo(){
	   return null;
   }
}
