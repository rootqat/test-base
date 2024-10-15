package testCases;



import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import pageObjectModel.HomePage;
import pageObjectModel.LoginPage;



public class LoginTest_01 extends BaseClass {
	LoginPage lp;
	public LoginTest_01() {
		super();
	}
	@BeforeTest
	public void LoginTest() throws InterruptedException {
       // setup();
		lp = new LoginPage(driver);
		lp.SetUsername(pro.getProperty("username"));
		lp.SetPassword(pro.getProperty("password"));
		lp.clickSubmit();
	}
//	@BeforeMethod
//	@Test(dataProvider="Login data")
//	public void LoginTest(String user,String pwd1) {
//		lp= new LoginPage(driver);
//		lp.SetUsername(user);
//		lp.SetPassword(pwd1);
//		lp.clickSubmit();
//	}
	
	@Test(priority=1)
	public void getTitle() {
		System.out.println(driver.getTitle());
		if (driver.getTitle().equals("Swag Labs")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertFalse(false);
		}
	}
	@AfterTest
	public void Logout() throws InterruptedException {
		Thread.sleep(2000);
		lp= new LoginPage(driver);
		lp.logout();
	}
	
	@DataProvider(name="Login data")
   public Object[][] loginData() {
	Object [][]data = {{"standard_user","secret_sauce"},{"performance_glitch_user","secretsauce"},{"problem_user","secret_sauce"}};
			
	return data;
}
}

