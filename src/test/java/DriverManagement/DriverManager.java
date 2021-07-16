package DriverManagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

	private static WebDriver driver;

	private DriverManager() {

	}

	public static WebDriver getWebDriver() {
		if (driver == null) {
			//initiating driver using WebDriverManager
			WebDriverManager.chromedriver().setup();
			//below lines only used once you are using driver installed on your system
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\santvina\\Desktop\\new\\chromedriver.exe");
//			// Initiate chrome driver
			driver = new ChromeDriver();
			 

		}
		return driver;

	}

	public static void killDriver() {
		driver.close();
		driver.quit();
		driver = null;

	}

}
