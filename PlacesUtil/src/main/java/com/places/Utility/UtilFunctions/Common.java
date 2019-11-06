package com.places.Utility.UtilFunctions;

import org.springframework.stereotype.Component;

@Component
public class Common {
    
	public static boolean isEmpty(String s) {
		if (s == null || s.trim().length() == 0)
			return true;
		return false;
	}
	
}
