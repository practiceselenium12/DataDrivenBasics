package com.w2a.rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {
	

	public static void main(String[] args) throws IOException {

		System.out.println(System.getProperty("user.dir"));

		Properties config = new Properties();
		Properties OR = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\mansi\\eclipse-workspace\\DataDrivenBasics\\src\\test\\resources\\properties\\Config.Properties");
		config.load(fis);
		fis = new FileInputStream(
				"C:\\Users\\mansi\\eclipse-workspace\\DataDrivenBasics\\src\\test\\resources\\properties\\OR.Properties");
       OR.load(fis);
       
       
       System.out.println(config.getProperty("browser"));
       
       
       
       //driver.findElement(By.cssSelector(OR.getProperty("bmlBtn"))).click();
       System.out.println(OR.getProperty("bmlBtn"));
       
	}   
} 


