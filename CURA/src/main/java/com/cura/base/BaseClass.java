/**
 * 
 */
package com.cura.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.cura.genericdriver.Generic;
import com.cura.utility.Log;
import com.cura.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author maxxmuthu
 *
 */
public class BaseClass {
	public static Properties prop;
	public static WebDriver driver;
	
	//To Create a config.properties file -> 1. Right click on the folder --> New --> File (AND) 2. Enter file name as config.properties and click finish

	//loadConfig method is to load the configuration
		@BeforeSuite()
		public void loadConfig() {	
			
			try {
				prop = new Properties();       //here we setup and load the config.properties
				FileInputStream ip = new FileInputStream(
						System.getProperty("user.dir") + "\\Configuration\\config.properties");
				prop.load(ip);
				
				ExtentManager.setExtent();  // Configure setExtent() method
				
				DOMConfigurator.configure("log4j.xml");  //here we are configure log4j.xml
				Log.info("This is beforeSuite Method");

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public void launchApp() {
			
			 String browserName = prop.getProperty("browser");
			 
			if (browserName.equalsIgnoreCase("Chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();	
				
			} else if (browserName.equalsIgnoreCase("FireFox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				
			} else if (browserName.equalsIgnoreCase("IE")) {
				WebDriverManager.iedriver().setup();
				driver = new EdgeDriver();
				
			}
			
			Generic.implicitWait(driver, 10);
			Generic.pageLoadTimeOut(driver, 30);
			driver.get(prop.getProperty("url"));
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			
			
		}
		
		 @AfterSuite
		 public void afterSuite() {
			 
	      ExtentManager.endReport();	  // Configure endReport() method
		  Log.info("This is afterSuite Method");
		 }
		
}
