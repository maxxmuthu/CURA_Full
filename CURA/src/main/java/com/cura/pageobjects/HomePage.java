/**
 * 
 */
package com.cura.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cura.base.BaseClass;
import com.cura.genericdriver.Generic;

/**
 * @author maxxmuthu
 *
 */
public class HomePage extends BaseClass {
	
	Generic generic = new Generic();
	
	@FindBy(xpath="//h2[text()='Make Appointment']")
	public WebElement mapp;
	
	@FindBy(xpath="//select[@id='combo_facility']")
	public WebElement facl;

	@FindBy(id="chk_hospotal_readmission")
	public WebElement hospCheck;
	
	@FindBy(xpath="(//input[@type='radio'])[2]")
	public WebElement health;
	
	@FindBy(xpath="//input[@id='txt_visit_date']")
	public WebElement date;
	
	@FindBy(xpath="//textarea[@id='txt_comment']")
	public WebElement comment;
	
	@FindBy(xpath="//button[@id='btn-book-appointment']")
	public WebElement booking;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String hometext() throws InterruptedException {
		
		String homepagetext = mapp.getText();
		Thread.sleep(5000);
		System.out.println(homepagetext);
		return homepagetext;
	}
	
	public void hospitalCheckbox() throws InterruptedException {
		
		generic.clickobject(driver, hospCheck);
		
	}
	
	
	public void Facility_Hongkong() {
		
		generic.selectByValue(facl, "Hongkong CURA Healthcare Center");
		
	}
	
	public void Facility_Seoul() {
		
		generic.selectByValue(facl, "Seoul CURA Healthcare Center");
		
	}
	
    public void healthprogram() {
    	
    	generic.clickobject(driver, health);
		
	}
    
   public void visitdate(String data) {
    	
    	generic.type(date, data);
    	date.sendKeys(Keys.ENTER);
		
	}
   
   
   public void commentssection(String data) {
   	
   	generic.type(comment, data);
		
	}
    
   public ConfirmationPage bookappointment() {
   	
   	generic.clickobject(driver, booking);
	return new ConfirmationPage();
		
	}
}
