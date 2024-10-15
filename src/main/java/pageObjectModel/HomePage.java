package pageObjectModel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import basePackage.BaseClass;

public class HomePage  {//extends BaseClass
    WebDriver driver;
	public HomePage(WebDriver d1) {
		//driver=d1;
		this.driver=d1;
		PageFactory.initElements(d1,this);
	}
	@FindBy(className="product_sort_container")
	WebElement Dropdown;
	
	@FindBy(id="add-to-cart-sauce-labs-onesie")
	WebElement Product;
	
	@FindBy(id="add-to-cart-sauce-labs-backpack")
	WebElement Product2;
	
	@FindBy(xpath="//div[@class='inventory_item_name']")
	List<WebElement> products;
	
	@FindBy(xpath="//div//a[@class='shopping_cart_link']")
	WebElement clickOnCart;
	
	@FindBy(id="checkout")
	WebElement checkout;
	
	@FindBy(id="first-name")WebElement InformName;
	@FindBy(id="last-name")WebElement InformLastName;
	@FindBy(id="postal-code")WebElement postalCode;
	@FindBy(id="continue")WebElement clickContinue;
	
	@FindBy(className="summary_value_label")WebElement paymentInformation;
	@FindBy(id="finish")WebElement Finish;
	
	public void selectProduct() {
		//Product.click();
		//Product2.click();
	//	WebElement prod=products.stream().filter(items->items.getText().equals("Sauce Labs Fleece Jacket"));
	}
	public void selectDropdown() {
		Dropdown.click();
		Select sc=new Select(Dropdown);
		sc.selectByValue("lohi");
	}
	public void clickonCart() {
		clickOnCart.click();
	}
	public void checkout() {
		checkout.click();
	}
	public void information(String uName, String lName,String pCode) {
		InformName.sendKeys(uName);
		InformLastName.sendKeys(lName);
		postalCode.sendKeys(pCode);
		clickContinue.click();
	}
	public void paymentInformation() {
		String pi=paymentInformation.getText();
		System.out.println(pi);
		Assert.assertEquals(pi, "sauce");
	}
	public void finish() {
		Finish.click();
	}
	
}
