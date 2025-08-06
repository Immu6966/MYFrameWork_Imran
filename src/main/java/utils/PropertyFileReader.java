package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {

	public static String getKeyValue(String key) throws IOException {
		
		
		
		String val=null;
	try	{
			
		 String path = System.getProperty("user.dir")+"\\Resources\\UI_Properties.properties";
		FileInputStream fis =new FileInputStream(path);
		
		Properties prop = new Properties();
		prop.load(fis);
		
		 val = prop.getProperty(key);
	}
	catch(Exception e)
	{
		
System.out.println("Exception occured "+e);
		
		
	}
	return val;	

}}
