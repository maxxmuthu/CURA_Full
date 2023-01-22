/**
 * 
 */
package com.cura.testcases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cura.base.BaseClass;
import com.cura.genericdriver.Generic;
import com.cura.pageobjects.ConfirmationPage;
import com.cura.pageobjects.HomePage;
import com.cura.pageobjects.IndexPage;
import com.cura.pageobjects.LoginPage;
import com.cura.utility.Log;
import com.cura.utility.ReadExcel;



/**
 * @author maxxmuthu
 *
 */
public class scenario_002 extends BaseClass {
	
	
	IndexPage indexpage;
	LoginPage loginpage;
	HomePage homepage;
	ConfirmationPage confirmationpage;
	//Generic gen;
	Generic generic = new Generic();
	
	@BeforeMethod
	public void setup() {
		
		launchApp();
	}

	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	
	
	@Test(priority=1, dataProvider="ExcelDataRead", dataProviderClass = ReadExcel.class) //pass the DataProvider class from the utility package // ReadExcel class is used in this run
    public void startpageAndlogin(String data[]) throws Throwable {
		
		Log.startTestCase("scenario_002");
		Log.info("This is scenario_002");
		
		indexpage = new IndexPage();
		
		Log.info("Click on Appointment button");
		loginpage = indexpage.makeAppointment();
		
		Log.info("Entering the Login Details");
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		Log.info("Verifing the Homepage Text");
		homepage.hometext();
		
		Log.info("Clicking the hospital readmission");
		homepage.hospitalCheckbox();
		
		Log.info("Selecting the Hongkong Facility");
		homepage.Facility_Hongkong();
		
		Log.info("Choosing the health program");
		homepage.healthprogram();
		
		Log.info("Entering the comments");
		homepage.commentssection(data[0]);
		
		Log.info("Entering the visit date");
		homepage.visitdate(data[1]);
		
		Log.info("Clicking the book appointment");
		confirmationpage = homepage.bookappointment();
		
		
		String actual_val = confirmationpage.confirmationtext();   //confirmationpage.confirmationtext();   - Here Web Element Screenshot is  also present
		String expected_val = "Appointment Confirmation1";
		
		Log.info("Validate the confirmation page text");
		Assert.assertEquals(actual_val,expected_val);
		
		Log.info("Generate the full page screenshot");
		generic.fullpageScreenshot(driver, "confirmpage");   // it take fullpage screenshot
		
		//Thread.sleep(5000);
		//String a = driver.findElement(By.xpath("//h2[text()='Make Appointment']")).getText();
		//System.out.println(a);
		//String actualURL = homepage.hometext();
		//String expectedURL = "Make Appointment";
		//Assert.assertEquals(actualURL,expectedURL);
		
		Log.endTestCase("scenario_002");
	}
	
	@Test(priority=2)
	public void sampletest() throws InterruptedException, IOException {
		
		String actual_val = confirmationpage.confirmationtext();   
		String expected_val = "Appointment Confirmation1";
		
		Assert.assertEquals(actual_val,expected_val);
		System.out.println("Testing fail test");
		
		
	}
	
}
