package com.w2a.base;


//my base class for all test cases
//this class is extends for all testcases


import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.hc.core5.util.Timeout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.log4testng.Logger;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;


			
	@BeforeSuite
	public void setUp() {

		if (driver == null) {
			
			

			try {
				fis = new FileInputStream(
						"C:\\Users\\mansi\\eclipse-workspace\\DataDrivenBasics\\src\\test\\resources\\properties\\Config.Properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
			

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				fis = new FileInputStream(
						"C:\\Users\\mansi\\eclipse-workspace\\DataDrivenBasics\\src\\test\\resources\\properties\\OR.Properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

				if (config.getProperty("browser").equals("firefox")) {

					// System.setProperty("webdriver.gecko.driver","gecko.exe");
					WebDriverManager.firefoxdriver().setup();

					driver = new FirefoxDriver();

				} else if (config.getProperty("browser").equals("chrome")) {

					/*
					 * System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
					 * + "\\src\\test\\resources\\executables\\chromedriver.exe");
					 */
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();

				} 

				else if (config.getProperty("browser").equals("edge")) {

					/*
					 * System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") +
					 * "\\src\\test\\resources\\executables\\IEDriverServer.exe");
					 */
					
					WebDriverManager.edgedriver().setup();
					driver = new EdgeDriver();
				}

				driver.get(config.getProperty("testsiteurl"));
				driver.manage().window().maximize();

				driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicity.wait")),
						TimeUnit.SECONDS);

			
		}
	}

	@AfterSuite
	public void tearDown() {

		if (driver != null) {

			driver.quit();
		}
	}
}
