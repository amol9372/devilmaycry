package programs.examples.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import programs.examples.dao.ProfileDao;
import programs.examples.model.EmployeeInfo;
import programs.examples.model.LoginModel;

@Service
public class ProfileService 
{
	
	@Autowired
	private ProfileDao profileDao;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProfileService.class);

//	public EmployeeInfo getEmployeeInfo(LoginModel loginModel){
//		
//		LOGGER.info("Fetching employee Profile for employee {} without Address",loginModel.getUserid());
//		EmployeeInfo employeeInfo = profileDao.getEmployeeInfoWithoutAddress(loginModel);
//		return employeeInfo;
//	}
	
    public EmployeeInfo getEmployeeInfo(int empid){
		
		LOGGER.info("Fetching employee Profile for employee {} without Address",empid);
		EmployeeInfo employeeInfo = profileDao.getEmployeeInfoWithoutAddress(empid);
		return employeeInfo;
	}
	
	
}
