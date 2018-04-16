package pageObjects;


import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	
	public CheckoutPage(WebDriver driver) {
	    PageFactory.initElements(driver, this);
	}
	
	//objects
	@FindBy(how = How.CSS, using = "#billing_first_name") 
	private WebElement textbox_FirstName;
	
	@FindBy(how = How.CSS, using = "#billing_last_name") 
	private WebElement textbox_LastName;
	
	@FindBy(how = How.CSS, using = "#billing_email") 
	private WebElement textbox_Email;
	
	@FindBy(how = How.CSS, using = "#billing_phone") 
	private WebElement textbox_Phone;
	
	@FindBy(how = How.CSS, using = "#billing_country_field .select2-arrow") 
	private WebElement dropdown_CountryDropDownArrow;
	
	@FindBy(how = How.CSS, using = "#billing_state_field .select2-arrow") 
	private WebElement dropdown_CountyDropDownArrow;
	
	@FindAll(@FindBy(how = How.CSS, using = "#select2-drop ul li"))
	private List<WebElement> country_List;	
	
	@FindBy(how = How.CSS, using = "#billing_city") 
	private WebElement textbox_City;
	
	@FindBy(how = How.CSS, using = "#billing_address_1") 
	private WebElement textbox_Address;
	
	@FindBy(how = How.CSS, using = "#billing_postcode") 
	private WebElement textbox_PostCode;
	
	@FindBy(how = How.CSS, using = "#ship-to-different-address-checkbox") 
	private WebElement checkbox_ShipToDifferetAddress;
	
	@FindAll(@FindBy(how = How.CSS, using = "ul.wc_payment_methods li"))
	private List<WebElement> paymentMethod_List;	
	
	@FindBy(how = How.CSS, using = "#terms.input-checkbox") 
	private WebElement checkbox_AcceptTermsAndCondition;
	
	@FindBy(how = How.CSS, using = "#place_order") 
	private WebElement button_PlaceOrder;
	
	//methods
	public void enter_FirstName(String name) {
		textbox_FirstName.sendKeys(name);
	}
	
	public void enter_LastName(String lastName) {
		textbox_LastName.sendKeys(lastName);
	}

	public void enter_Email(String email) {
		textbox_Email.sendKeys(email);
	}
	
	public void enter_Phone(String phone) {
		textbox_Phone.sendKeys(phone);
	}
	
	public void enter_City(String city) {
		textbox_City.sendKeys(city);
	}
	
	public void enter_Address(String address) {
		textbox_Address.sendKeys(address);
	}
	
	public void enter_PostCode(String postCode) {
		textbox_PostCode.sendKeys(postCode);
	}
	
	public void check_ShipToDifferentAddress(boolean value) {
		if(!value) checkbox_ShipToDifferetAddress.click();
		try { Thread.sleep(3000);}
		catch (InterruptedException e) {}
	}
	
	public void select_Country(String countryName) {
		dropdown_CountryDropDownArrow.click();
		try { Thread.sleep(2000);}
		catch (InterruptedException e) {}

		for(WebElement country : country_List){
			if(country.getText().equals(countryName)) {
				country.click();	
				try { Thread.sleep(3000);}
				catch (InterruptedException e) {}
				break;
			}
		}
	}
	
	public void select_State(String countyName) {
		dropdown_CountyDropDownArrow.click();
		try { Thread.sleep(2000);}
		catch (InterruptedException e) {}

		for(WebElement county : country_List){
			if(county.getText().equals(countyName)) {
				county.click();	
				try { Thread.sleep(3000);}
				catch (InterruptedException e) {}
				break;
			}
		}
	}
	
	public void select_PaymentMethod(String paymentMethod, WebDriver driver) throws InterruptedException {
		WebElement payment = null;
		if(paymentMethod.equals("ChequePayment")) {
			//paymentMethod_List.get(0).click();
			payment = paymentMethod_List.get(0);
		}
		else if(paymentMethod.equals("CashPayment")) {
			//paymentMethod_List.get(1).click();
			payment = paymentMethod_List.get(1);
		}
		else {
			new Exception("Payment Method not recognised : " + paymentMethod);
		}
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView()", payment);
		Thread.sleep(3000);
		payment.click();
		
		try { 
			Thread.sleep(3000);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public void check_TermsAndCondition(boolean value) {
		if(value) checkbox_AcceptTermsAndCondition.click();
	}
	
	public void clickOn_PlaceOrder() {
		button_PlaceOrder.submit();
	}
	
	
	/*public void fill_PersonalDetails() {
		enter_FirstName("Nancy");
		enter_LastName("Stevens");
		System.out.println("--- Name input ---");
		enter_Phone("07896543201");
		enter_Email("nan.stevens@gmail.com");
		System.out.println("--- Contact input ---");
		select_Country("India");
		enter_City("Delhi");
		enter_Address("Shalimar Bagh");
		enter_PostCode("110088");
		select_State("Delhi");		
		System.out.println("--- Address input ---");
	}*/
	
	public void fill_PersonalDetails(String firstName, String lastName, String phoneNo, String email, String country, String city, String address, String postalCode, String state) {
		enter_FirstName(firstName);
		enter_LastName(lastName);
		System.out.println("--- Name input ---");
		enter_Phone(phoneNo);
		enter_Email(email);
		System.out.println("--- Contact input ---");
		select_Country(country);
		enter_City(city);
		enter_Address(address);
		enter_PostCode(postalCode);
		select_State(state);		
		System.out.println("--- Address input ---");
	}

}