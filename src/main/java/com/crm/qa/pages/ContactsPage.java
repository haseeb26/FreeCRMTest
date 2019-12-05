package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	WebElement contactsLabel;
	
	@FindBy(xpath="//td[contains(text(),'Test1 test1')]")
	WebElement selectLabel1;
	
	@FindBy(xpath="//button[contains(text(),'New')]")
	WebElement newContactLink; 
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement lastName;
	
	@FindBy(xpath="//div[@name='company']//input[@class='search']")
	WebElement company;
	
	@FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement savBtn;
	
	
	
	
	

	// Initializing the Page Objects 
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}
	
	public void selectContactsByName() {
		selectLabel1.click();
	}
	
	public void clickOnNewContactLink() {
		newContactLink.click();
	}
	
	
	
	public void createNewContact(String ftName,String ltName,String comp) {
		
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		company.sendKeys(comp);
		savBtn.click();
	}
	
	
	
	
	
	
	
	

}
