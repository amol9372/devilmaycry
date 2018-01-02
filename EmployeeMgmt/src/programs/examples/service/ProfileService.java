package programs.examples.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import programs.examples.dao.LoginDao;

public class ProfileService 
{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProfileService.class);

	private static ProfileService profileService;

	//ProfileDao profileDao = LoginDao.getProfileInstance();

	public static ProfileService getProfileInstance(){
    	if(profileService == null)
    		profileService = new ProfileService();
    	return profileService;
	}
	
}
