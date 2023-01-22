/**
 * 
 */
package com.cura.pageobjects;

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
public class IndexPage extends BaseClass  {
	
	Generic generic = new Generic();
	
	@FindBy(id = "btn-make-appointment") 
	public WebElement MakeAppoBtn;
	
	public IndexPage() {
		PageFactory.initElements(driver, this);
	}
	

	public LoginPage makeAppointment() throws Throwable {
		generic.fluentWait(driver, MakeAppoBtn, 10);
		generic.clickobject(driver, MakeAppoBtn);
		return new LoginPage();
	}
	

}