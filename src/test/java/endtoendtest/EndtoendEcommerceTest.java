package endtoendtest;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EndtoendEcommerceTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/client/#/auth/login");
    }

    @Test
    public void endToEndPurchaseFlow() {
        String productName = "ADIDAS ORIGINAL";

        // Login
        driver.findElement(By.id("userEmail")).sendKeys("priya.rj111@gmail.com");
        driver.findElement(By.id("userPassword")).sendKeys("Priy@nka123");
        driver.findElement(By.id("login")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

        // Find products
        List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

        WebElement prod = products.stream()
                .filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName))
                .findFirst()
                .orElse(null);

        Assert.assertNotNull(prod, "Product not found!");

        // Add to cart
        prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

        // Toast waits
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));

        // Go to cart
        driver.findElement(By.cssSelector("[routerlink*='/dashboard/cart']")).click();

        // Validate cart item
        List<WebElement> cartProducts = driver.findElements(By.xpath("//div[@class='cartSection']/h3"));

        boolean match = cartProducts.stream()
                .anyMatch(cartProd -> cartProd.getText().equalsIgnoreCase(productName));

        Assert.assertTrue(match, "Product not found in cart!");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
