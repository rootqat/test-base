package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseClass;

public class LoginPage { //extends BaseClass 
	   WebDriver driver;
	   public LoginPage(WebDriver d) {
		   //driver=d;
		   this.driver=d;
		   PageFactory.initElements(d, this);
		 }
//	  public LoginPage(WebDriver driver){
//	      this.driver=driver;
//		  PageFactory.initElements(driver,this);
//	   }
	   @FindBy(id="user-name")
	   
	   WebElement textUsername;
	   
	   @FindBy(id="password")
	   WebElement textpassword;
	   
	   @FindBy(id="login-button")
	   WebElement clickButton;
	   
	   @FindBy(id="react-burger-menu-btn")
	   WebElement logOutButton;
	   
	   @FindBy(xpath="//div/div/nav/a[3]")
	   WebElement logOut;
	   
	   
	   public void SetUsername(String key) {
		   textUsername.sendKeys(key);
	   }
	   public void SetPassword(String pwd) {
		   textpassword.sendKeys(pwd);
	   }
	   public void clickSubmit() {
		   clickButton.click();
	   }
	   public void logout() {
		   logOutButton.click();
		   logOut.click();
	   }
}
