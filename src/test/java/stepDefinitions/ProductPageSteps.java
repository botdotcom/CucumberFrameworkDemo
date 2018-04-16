package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.When;
import pageObjects.ProductListingPage;

public class ProductPageSteps {
	
	TestContext testContext;
	ProductListingPage productListingPage;
	
	public ProductPageSteps(TestContext context) {
		testContext = context;
		productListingPage = testContext.getPageObjectManager().getProductListingPage();
	}

	@When("^choose to buy the first item$")
	public void choose_to_buy_the_first_item() {
		productListingPage.select_Product(0);
		System.out.println("----- Item chosen and clicked -----");
		productListingPage.clickOn_AddToCart();	
		System.out.println("----- Item added to cart -----");
	}
}