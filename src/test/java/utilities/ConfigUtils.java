package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigUtils {
	Properties prop;

	public String getProp(String key) throws Exception {
		try {
			File configPath = new File(
					"./configuration/config.properties");
			FileInputStream load = new FileInputStream(configPath);
			prop = new Properties();
			prop.load(load);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return prop.getProperty(key);
	}

	public String getUrl() {
		return prop.getProperty("url");
	}

	public String getUsername() {
		return prop.getProperty("username");
	}

	public String getPassword() {
		return prop.getProperty("password");
	}

}
