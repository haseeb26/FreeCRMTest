/*
 * @author Haseeb ur Rahman 
 */
package com.crm.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	String sheetName = "contacts";
	
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		loginPage = new LoginPage(); 
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		Thread.sleep(7000);
		contactsPage = homePage.clickOnContactsLink();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		//Thread.sleep(4000);
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabel() {
		Assert.assertTrue(contactsPage.verifyContactsLabel(),"contacts label is missing on the page");
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

	}
	
	@Test(priority=2)
	public void selectContactsTest() throws InterruptedException {
		contactsPage.selectContactsByName();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

	}
	/*
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][]= TestUtil.getTestData(sheetName);
		return data;
	}
	*/
	
	
	
	
	@Test(priority=3 )
	public void validateCreateNewContact() throws InterruptedException {
		contactsPage.clickOnNewContactLink();
		
		contactsPage.createNewContact("Tom","Peter" ,"Google");
		//contactsPage.createNewContact(firstName, lastName, company);
		Thread.sleep(3000);
	}
	
	
	
	
	
	
	
	
	@AfterMethod
	public void teardown() {	
		driver.quit();
	}
	
	
}
