package programs.examples.utils;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EmployeeHelper 
{
   public static String getHashFromPassword(String password) throws NoSuchAlgorithmException{
	   MessageDigest md = MessageDigest.getInstance( "SHA-256" );
	    // Change this to UTF-16 if needed
	    md.update( password.getBytes( StandardCharsets.UTF_8 ) );
	    byte[] digest = md.digest();

	    String hex = String.format( "%064x", new BigInteger( 1, digest ) );
	    return hex;
   } 
   
   public static boolean isEmpty(String abc){
	   if(abc == null || abc.trim().length() == 0)
		   return true;
	   return false;
   }
}
