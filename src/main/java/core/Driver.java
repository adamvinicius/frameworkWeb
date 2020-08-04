package core;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.org.apache.bcel.internal.ExceptionConstants;

public class Driver {
	private static WebDriver driver;
	private static WebDriverWait wait;
	
	public static void abreNavegador() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(false);
		

		
		driver = new ChromeDriver(options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		driver.manage().window().maximize();
		
	}
	
	public static void fechaNavegador() {
		driver.quit();
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	public static void setUrl(String url) {
		driver.get(url);
	}
	
	public static WebElement waitVisibleElement(By by) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	public static void waitInvisibilityElemnt(By by) {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}
	
	public static WebElement waitClickableElement(By by) {
		return wait.until(ExpectedConditions.elementToBeClickable(by));
	}
	
	
	
	
	
}
