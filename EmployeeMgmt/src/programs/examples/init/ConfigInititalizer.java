package programs.examples.init;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ConfigInititalizer implements ServletContextListener
{
    private File file;
    private FileReader fileReader;
    Properties appProperties = new Properties();
    String propertiesFilePath = "D:\\property files\\";
    String propertyFileName = "application.properties";
    
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	   	
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("Initializing data for Application !!!!");		
		try {
			file = new File(propertiesFilePath+propertyFileName);
			if (!file.exists()) {
				System.out.println("Application properties file dosent exist");
				throw new FileNotFoundException("Property file not found at path : "+propertiesFilePath);
			}
			fileReader = new FileReader(file);
			appProperties.load(fileReader);			
			System.out.println(appProperties.getProperty("var1"));
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}

	}
   
}
