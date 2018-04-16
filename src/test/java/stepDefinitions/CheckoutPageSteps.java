package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.When;
import pageObjects.CheckoutPage;

public class CheckoutPageSteps {
	TestContext testContext;
	CheckoutPage checkout;
	
	public CheckoutPageSteps(TestContext context) {
		testContext = context;
		checkout = testContext.getPageObjectManager().getCheckoutPage();
	}
	
	@When("^enter personal details on checkout page$")
	public void enter_personal_details_on_checkout_page(){
		checkout.fill_PersonalDetails("Nancy", "Stevens", "7896543201", "nan.stevens@gmail.com", "India", "Delhi", "Shalimar Bagh", "110088", "Delhi");
		System.out.println("----- Billing form filled -----");
	}
	
	@When("^select same delivery address$")
	public void select_same_delivery_address(){
		checkout.check_ShipToDifferentAddress(false);
		System.out.println("----- Delivery address confirmed -----");
	}
	
	@When("^select payment method as \"([^\"]*)\" payment$")
	public void select_payment_method_as_payment(String arg1) throws InterruptedException{
		checkout.select_PaymentMethod("ChequePayment", testContext.getWebDriverManager().getDriver());
		System.out.println("----- Payment method chosen -----");
	}

	@When("^place the order$")
	public void place_the_order() {
		checkout.check_TermsAndCondition(true);
		System.out.println("----- T&C accepted -----");
		checkout.clickOn_PlaceOrder();		
		System.out.println("----- Order placed -----");
		testContext.getWebDriverManager().closeDriver();;
	}	

}