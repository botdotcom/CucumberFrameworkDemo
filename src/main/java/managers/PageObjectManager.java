package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.ProductListingPage;

public class PageObjectManager {

	private WebDriver driver;
	private ProductListingPage products;
	private CartPage cart;
	private HomePage home;
	private CheckoutPage checkout;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}	

	public HomePage getHomePage(){
		return (home == null) ? home = new HomePage(driver) : home;
	}

	public ProductListingPage getProductListingPage() {
		return (products == null) ? products = new ProductListingPage(driver) : products;
	}

	public CartPage getCartPage() {
		return (cart == null) ? cart = new CartPage(driver) : cart;
	}

	public CheckoutPage getCheckoutPage() {
		return (checkout == null) ? checkout = new CheckoutPage(driver) : checkout;
	}
}