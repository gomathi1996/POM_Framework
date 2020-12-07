package com.automation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	Properties prop;

	public ConfigReader() {
		File src = new File("./config/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		} catch (IOException e) {
			System.out.println("Not able to read data from config file " + e.getMessage());
		}
	}

	public String getBrowser() {

		return prop.getProperty("browser");
	}

	public String getAppUrl() {

		return prop.getProperty("url");
	}

}
