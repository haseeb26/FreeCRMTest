package com.crm.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class HomePage extends TestBase {

	@FindBy(xpath="//span[@class='user-display']")
	WebElement userNameLabel;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	
	@FindBy(xpath="//span[contains(text(),'Deals']")
	WebElement dealsLink;
	
	@FindBy(xpath="//span[contains(text(),'Tasks']")
	WebElement tasksLink;
	
	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		String username = driver.getTitle();
		return username;
	}
	
	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();

	}
	
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink() {
		tasksLink.click();
		return new TasksPage();
	}
	
	
	
	
	
	
	
		
	
	
	
	
}
