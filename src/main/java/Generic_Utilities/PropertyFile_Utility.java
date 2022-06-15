package Generic_Utilities;

import java.io.FileInputStream;
import java.util.Properties;

/*
 * it contains Property File Specific libraries
 * @author Abhishek Gowda 
 */


public class PropertyFile_Utility {
	
	/*
	 * This Method is used to get the Value from property file with the help of key
	 * @param key
	 * @return String 
	 */
	
	
	public String getDataFromProperty(String key) throws Throwable {
		
		FileInputStream fin = new FileInputStream("./data/commondata.properties");
		Properties pro = new Properties();
		pro.load(fin);
		String data = pro.getProperty(key);

		return data;
	}
}
