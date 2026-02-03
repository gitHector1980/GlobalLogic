package com.seleniumpractice.tutorial;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ElementosDinamicos {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@Test
	public void lookForDinamicElelemt() {
		
		List<WebElement> elements = driver.findElements(By.xpath("//*[@id='content']/div"));
		
		for(WebElement element:elements) {
			String elementText = element.getText();
			System.out.println(elementText);
		}
		for(int i = elements.size(); i==4; i++) {
			if(isElementPresent (By.xpath("//*[@id='content']/div[3]"))) {
			System.out.println("******************");
			System.out.println("Cuarto elemento dinamico está presente");			
			driver.findElement(By.xpath("//*[@id='content']/div[3]")).click();
			
			}else {
				System.out.println("Elemento no esta presente");
			}
		}
	}
	
	private boolean isElementPresent(By xpath) {
		
		return true;
	}

	@BeforeMethod
	public void setUp () {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\vedde\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/dynamic_content?with_content=static");		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
