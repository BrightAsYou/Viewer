package prs.rfh.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
	
	private static Properties properties = new Properties();
	
	public static String getPropertieyByKey(String key,File file) throws FileNotFoundException, IOException{
		getProperties().load(new FileInputStream(file));
		return (String)getProperties().get(key);
	}
	
	public static synchronized Properties getProperties(){
		return properties;
	}
}
