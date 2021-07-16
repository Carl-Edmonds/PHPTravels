package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DriverManagement.DriverManager;

public class HomePage {


	public HomePage() {

		PageFactory.initElements(DriverManager.getWebDriver(), this);
	}

	@FindBy(xpath = "//div[@class='dropdown dropdown-login dropdown-tab']/a")
	WebElement account;

	@FindBy(xpath = "//div/a[contains(text(),'Sign Up')]")
	WebElement signUp;
	
	@FindBy(xpath = "//div/a[contains(text(),'Login')]")
	WebElement logIn;

	public WebElement LogIn() {
		return logIn;
	}

	public WebElement Account() {
		return account;
	}

	public WebElement SignUp() {
		return signUp;
	}

	public RegistrationPage SignUpProcess() {

		// Click on myAccount button
		account.click();
		// Click on Sign up button
		signUp.click();
		return new RegistrationPage();
	}
}
