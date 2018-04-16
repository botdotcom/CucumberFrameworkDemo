package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import managers.FileReaderManager;

import dataProviders.ConfigFileReader;

public class HomePage {
	WebDriver driver;
	ConfigFileReader configs;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		//configs = new ConfigFileReader();
	}
	
	public void perform_Search(String search) {
		driver.navigate().to(FileReaderManager.getInstance().getConfigReader().getApplicationUrl() + "/?s=" + search + "&post_type=product");		
	}
	
	public void navigateTo_HomePage() {
		//driver.get("http://www.shop.demoqa.com");
		//driver.get(configs.getApplicationUrl());
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
	}

}