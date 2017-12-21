package programs.examples.init;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ConfigInititalizer implements ServletContextListener
{
    private File file;
    private FileReader fileReader;
    private Properties appProperties = new Properties();
    String propertiesFilePath = "D:\\property files\\";
    String propertyFileName = "application.properties";
    ServletContext context;
    
	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("Initializing data for Application !!!!");		
		try {
			file = new File(propertiesFilePath+propertyFileName);
			if (!file.exists()) {
				System.out.println("Application properties file dosent exist");
				throw new FileNotFoundException("Property file not found at path : "+propertiesFilePath);
			}
			fileReader = new FileReader(file);
			appProperties.load(fileReader);			
			context = event.getServletContext();
			context.setAttribute("config", appProperties);
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
	
	public ConfigInititalizer getConfig() {
		 return (ConfigInititalizer) context.getAttribute("config");
	}
	
	public String getProperty(String key){
		return appProperties.getProperty(key);
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
	   	
	}
   
}
