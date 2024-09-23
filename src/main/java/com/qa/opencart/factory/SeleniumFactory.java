package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class SeleniumFactory {
  
	Properties properties;
	public Properties init_Properties() throws IOException {
		FileInputStream fis=new FileInputStream("./src//test//resources//config//config.properties");
		//FileReader f=new FileReader(".\\resources\\config\\config.properties");
		properties=new Properties();
		properties.load(fis);
		return properties;
	}
}

