/**
 * 
 */
package com.cura.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cura.base.BaseClass;
import com.cura.pageobjects.HomePage;
import com.cura.pageobjects.IndexPage;
import com.cura.pageobjects.LoginPage;
import com.cura.utility.Log;

/**
 * @author maxxmuthu
 *
 */
public class scenario_001 extends BaseClass {
	
	
	IndexPage indexpage;
	LoginPage loginpage;
	HomePage homepage;
	
	@BeforeMethod
	public void setup() {
		
		launchApp();
	}

	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	
	
	@Test
    public void startpageAndlogin() throws Throwable {
		
		Log.startTestCase("scenario_001");
		Log.info("This is scenario_001");
		
		indexpage = new IndexPage();
		
		Log.info("Click on Appointment button");
		loginpage = indexpage.makeAppointment();
		
		Log.info("Entering the Login Details");
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		//Thread.sleep(5000);
		//String a = driver.findElement(By.xpath("//h2[text()='Make Appointment']")).getText();
		//System.out.println(a);
		String actualURL = homepage.hometext();
		String expectedURL = "Make Appointment";
		
		Log.info("Validate the Homepage URL");
		Assert.assertEquals(actualURL,expectedURL);
		
		//homepage.hospitalCheckbox();
		Log.endTestCase("scenario_001");
	}
	
}
