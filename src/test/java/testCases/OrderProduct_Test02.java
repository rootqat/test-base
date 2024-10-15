package testCases;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import pageObjectModel.HomePage;
import pageObjectModel.LoginPage;

public class OrderProduct_Test02 extends BaseClass {
	
	HomePage hp;
	public OrderProduct_Test02() {
		super();	
	}
	@Test(priority=3)
	public void addProductToCart() {
		hp=new HomePage(driver);
		hp.selectProduct();
	}
	@Test(priority=2)
	public void selectDropdown() throws InterruptedException {
		 hp= new HomePage(driver);
      Thread.sleep(1000);
		hp.selectDropdown();
		
	}
	@Test(priority=4)
	public void clickonCart() {
		 hp= new HomePage(driver);
		hp.clickonCart();
	}
	@Test(priority=5)
	public void checkout() {
		 hp= new HomePage(driver);
		hp.checkout();
	}
	@Test(priority=6)
	public void information() {
		 hp= new HomePage(driver);
		hp.information(pro.getProperty("Name"), pro.getProperty("lastname"), pro.getProperty("code"));
	}
	@Test(priority=7)
	public void paymentInform() {
		hp=new HomePage(driver);
		hp.paymentInformation();
	}
	@Test(priority=8)
	public void finish() {
		 hp= new HomePage(driver);
		hp.finish();
	}
}
