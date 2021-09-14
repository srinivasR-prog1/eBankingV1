package com.enetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

public class ReadConfig {

	Properties prop;

	public ReadConfig() {

		File src = new File("./Configuration/config.properties");

		try {

			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);

		} catch (Exception e) {
			System.out.println("The message is :" + e.getMessage());

		}

	}

	public String getApplicationURL() {

		String url = prop.getProperty("baseURL");
		return url;

	}

	public String getUsername() {

		String usrName = prop.getProperty("username");
		return usrName;

	}

	public String getPwd() {
		String pwd = prop.getProperty("password");
		return pwd;
	}

}
