package Webautomation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Webautomation.pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcase1 {

	public static void main(String[] args) {
		
		String productname= "ADIDAS ORIGINAL";

		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
				
		LandingPage landingPage=new LandingPage(driver);
		
		landingPage.goTo();
		
		landingPage.loginpage("priya.rj111@gmail.com", "Priy@nka123");
				
		//driver.findElement(By.id("userEmail")).sendKeys("priya.rj111@gmail.com");
		
		//driver.findElement(By.id("userPassword")).sendKeys("Priy@nka123");
		
		//driver.findElement(By.id("login")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		
		WebElement prod = products.stream()
                .filter(product -> product.findElement(By.cssSelector("b"))
                        .getText().equals(productname))
                .findFirst()
                .orElse(null);
		
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		
       driver.findElement(By.cssSelector("[routerlink*='/dashboard/cart']")).click();
       
      List <WebElement> carproducts = driver.findElements(By.xpath(".cartSection h3"));
      
      carproducts.stream().anyMatch(carproducts>- carproducts.getText().equalIgnores());
	
	
	
		
		
		
		


		
		
	}

}
