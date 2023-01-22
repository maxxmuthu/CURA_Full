/**
 * 
 */
package com.cura.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cura.genericdriver.Generic;
import com.cura.base.BaseClass;



/**
 * @author maxxmuthu
 *
 */
public class LoginPage extends BaseClass {

	Generic generic = new Generic();
	
	@FindBy(id="txt-username")
	public WebElement userName;
	
	@FindBy(id="txt-password")
	public WebElement password;

	@FindBy(xpath="//button[@id='btn-login']")
	public WebElement signInBtn;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public HomePage login(String uname, String pswd) throws Throwable {
		
		generic.type(userName, uname);
		generic.type(password, pswd);
		generic.clickobject(driver, signInBtn);
		Thread.sleep(2000);
		return new HomePage();
	}
	
}
