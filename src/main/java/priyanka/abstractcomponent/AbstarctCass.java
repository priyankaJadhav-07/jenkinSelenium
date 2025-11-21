package priyanka.abstractcomponent;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstarctCass {
	
	public void Elementtobeappeared(By findBy)
	{
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

	List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

}
}