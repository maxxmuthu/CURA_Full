/**
 * 
 */
package com.cura.pageobjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cura.base.BaseClass;
import com.cura.genericdriver.Generic;
import com.cura.pageobjects.LoginPage;

/**
 * @author maxxmuthu
 *
 */
public class ConfirmationPage extends BaseClass  {
	
	Generic generic = new Generic();
	
	@FindBy(xpath = "//h2[text()='Appointment Confirmation']") 
	public WebElement Appoint_Confirm;
	
	@FindBy(className = "lead") 
	public WebElement plz_txt;
	
	// driver.findElement(By.linkText("Go to Homepage")).getText();
	
	public ConfirmationPage() {
		PageFactory.initElements(driver, this);
	}
	

	public String confirmationtext() throws InterruptedException, IOException {
		
		//generic.webElementScreenshot(driver, Appoint_Confirm, "Test"); //Web Element Screenshot
		//generic.croppingScreenshot(driver, plz_txt, "crop");
		String confirmpagetext = Appoint_Confirm.getText();
		Thread.sleep(5000);
		System.out.println(confirmpagetext);
		return confirmpagetext;
		
	}

}