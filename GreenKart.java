package com.seleniumpractice.tutorial;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;

public class GreenKart {

	private WebDriver driver;
	private WebDriverWait wait;
	// Elementos de la pagina de GreenKart
	@Test
	public void addToGreenKart1() {
									
		By productBrocolli = By.xpath("//*[@id='root']/div/div[1]/div/div[1]/div[3]/button");
		wait.until(ExpectedConditions.visibilityOfElementLocated(productBrocolli));
		By productCauliflower = By.xpath("//*[@id='root']/div/div[1]/div/div[2]/div[3]/button");
		By productCucumber = By.xpath("//*[@id='root']/div/div[1]/div/div[3]/div[3]/button");
		By productBeetroot = By.xpath("//*[@id='root']/div/div[1]/div/div[4]/div[3]/button");
		By productCarrot = By.xpath("//*[@id='root']/div/div[1]/div/div[5]/div[3]/button");
		By productTomato = By.xpath("//*[@id='root']/div/div[1]/div/div[6]/div[3]/button");
		By productBeans = By.xpath("//*[@id='root']/div/div[1]/div/div[7]/div[3]/button");
		By productBrinjal = By.xpath("//*[@id='root']/div/div[1]/div/div[8]/div[3]/button");

		By[] products = { productBrocolli, productCauliflower, productCucumber, productBeetroot, productCarrot,

				productTomato, productBeans, productBrinjal };

		for (By product : products) {

			if (!driver.findElement(product).isDisplayed()) {
				System.out.println("Alguno de los productos No están visibles");
				throw new AssertionError("Product not visible: " + product);
			}else {			
			driver.findElement(product).click();
			}
		}
		System.out.println("Todos los productos estan visibles");
	
	}
	// Set up the property and the browser to open the web page
	@BeforeEach
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\vedde\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

	}
	@AfterEach
	public void tearDown() {
		driver.quit();
	}

}
