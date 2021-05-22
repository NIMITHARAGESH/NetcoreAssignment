package com.netcore.Genericlib;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
	
	public String getPropertyKeyValue(String key) throws Throwable  {
		  
		FileInputStream fis = new FileInputStream(Autoconstants.propfilepath);//"./TestData/data.properties"
		 Properties prop = new Properties();
		 prop.load(fis);
		 String value = prop.getProperty(key);
	
	return value;

}
}
