package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class TestDataReader {
	
private static Properties property;
    
    static {
    	try {
    		File file = new File("./src/test/resources/testdata/env.properties");//loading everything from env.properties file
    		FileInputStream input = new FileInputStream(file);//pass all values and keys from env.properties
    		property = new Properties();//create property object
    		property.load(input);//load everything to property object
    		input.close();
    	} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public static String getProperty(String key) {
    	return property.getProperty(key);//read the key from env.properies file and return the value which is chrome
    }

}
