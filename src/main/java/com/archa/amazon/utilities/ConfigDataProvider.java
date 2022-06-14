package com.archa.amazon.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {

	Properties prop;

	/*
	 * This constructor finds the desired properties file
	 * */
	public ConfigDataProvider() {
		File src = new File("./Config/data.properties");
		try {

			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Not able to load config file");
			e.printStackTrace();

		}
	}

	/*
	 * Getting the browser from the properties file
	 * */
	public String getBrowser() {
		return prop.getProperty("browser");
	}

	/*
	 * Getting the url from the properties file
	 * */
	public String getUrl() {
		return prop.getProperty("url");
	}
}