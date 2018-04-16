package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.CSS, using = ".cart-button") 
	private WebElement button_Cart;
	
	@FindBy(how = How.CSS, using = ".checkout-button.alt") 
	private WebElement button_ContinueToCheckout;
	
	
	public void clickOn_Cart() {
		button_Cart.click();
	}
	
	public void clickOn_ContinueToCheckout(){
		button_ContinueToCheckout.click();
		try { Thread.sleep(5000);}
		catch (InterruptedException e) {}
	}
	
}