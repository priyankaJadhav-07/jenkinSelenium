package Webautomation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import priyanka.abstractcomponent.AbstarctCass;

public class LandingPage extends AbstarctCass {
		
		WebDriver driver;
		
		public LandingPage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this); //it will take care of all driver object operations
		}
		
		//Pagefactory
		
		@FindBy(id = "userEmail")
	    WebElement userEmail;

	    @FindBy(id = "userPassword")
	    WebElement userPassword;

	    @FindBy(id = "login")
	    WebElement submit;
		
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
