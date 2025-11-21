package Webautomation.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCatalog {
		
		WebDriver driver;
		
		public ProductCatalog(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this); //it will take care of all driver object operations
		}
		
	
		//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

		@FindBy(css = ".mb-3")

		public void loginpage(String email, String password)
		{
			userEmail.sendKeys(email);
	        userPassword.sendKeys(password);
	        submit.click();

	    }

        public void goTo()
        {
    		driver.get("https://rahulshettyacademy.com/client/#/auth/login");

        }
        
}
