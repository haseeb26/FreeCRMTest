package com.crm.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	public HomePageTest() {
		super();
	}
	
	// test cases should be separated -- independent with each other
	// before each test cases -- launch the browser and login
	//@test -- execute the test case
	//after each test case -- close the browser
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage(); 
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() throws InterruptedException {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Cogmento CRM", "Home page title not matched");
		Thread.sleep(7000);
	}
	
	@Test(priority=2)
	public void verifyUserNameTest() throws InterruptedException {
		Assert.assertTrue(homePage.verifyCorrectUserName());
		Thread.sleep(5000);
		System.out.println(homePage.verifyHomePageTitle());

	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest() throws InterruptedException {
		Thread.sleep(7000);
		contactsPage = homePage.clickOnContactsLink();
		Thread.sleep(3000);

		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	}
	

	@AfterMethod
	public void teardown() {	
		driver.quit();
	}
}
