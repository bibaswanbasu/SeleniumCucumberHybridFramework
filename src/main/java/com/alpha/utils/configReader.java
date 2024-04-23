package com.alpha.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class configReader {

	private static Properties prop;
	private static String CONFIG_PATH = System.getProperty("user.dir") + "/src/test/resources/config.properties";

	public Properties init_prop() {
		try {
			FileInputStream ip = new FileInputStream(CONFIG_PATH);
			prop = new Properties();
			prop.load(ip);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		return prop;
	}

}
