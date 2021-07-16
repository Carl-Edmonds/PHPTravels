package PhpTravelsTest;

import java.io.IOException;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import DriverManagement.DriverManager;
import DriverManagement.TestBase;
import PageObjects.RegistrationPage;

import PageObjects.AfterLoginPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;

public class RegistrationTest extends TestBase {

	@Test(enabled = false)
	public void DataDrivenRegistrationTest() throws InterruptedException, IOException {

		// Actual result

		HomePage hp = new HomePage();
		RegistrationPage rp = hp.SignUpProcess();
		AfterLoginPage alp = rp.LoginProcess();
		// alp.VerifyProcess();

		Thread.sleep(3000);
		String expected = "Hi, Tensa Zangetsu";

		String actual = alp.Verify().getText();
		Assert.assertEquals(actual, expected);

	}

	// The same test with manually passing values

	@Test(enabled = false)
	public void ManualPassingValuesRegistrationTest() throws InterruptedException, IOException {
		// you are creating object of the first homepage
		HomePage hp = new HomePage();
		// Click on Account button
		hp.Account().click();
		// Click on sign up button
		hp.SignUp().click();
		// redirected to sec Reg Page and that is why you are creating object of that
		// page
		RegistrationPage reg = new RegistrationPage();
		// Enter first name
		reg.enterName("Santhosh");
		// Enter last name
		reg.enterLast("Gabriellito");
		// Enter contact
		reg.enterContactNumber("999667");
		// Enter email
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(1000);
		String ema = "username" + randomInt + "@gmail.com";
		reg.enterEmail(ema);
		// Enter password
		String ps = RandomStringUtils.randomAlphanumeric(8);
		reg.enterPassword(ps);
		// Confirm Password
		reg.enterConfirmPassword(ps);
		// Click Sign up button
		((JavascriptExecutor) DriverManager.getWebDriver()).executeScript("arguments[0].scrollIntoView(true);",
				reg.signUpButton());
		reg.signUpButton().click();
		// customer get navigated to account page - new object needs to be created
		AfterLoginPage alp = new AfterLoginPage();
		Thread.sleep(2000);
		// Expected message
		String expected = "Hi, Santhosh Gabriellito";
		// Actual message
		String actual = alp.Verify().getText();
		// Compare the values using assertion
		Assert.assertEquals(actual, expected);
		// Click on current user
		alp.CurrentUser().click();
		// Click on logout
		alp.Logout().click();

	}

//	  Test 3
//	  
//	  Create Test for invalid email on registration page -> verify that correct
//	  error message occurs on the top of the page
	// you are creating object of the first homepage

	@Test()
	public void InvalidEmailTest() throws InterruptedException, IOException {
		HomePage hp = new HomePage();
		Thread.sleep(1000);
		hp.Account().click();
		Thread.sleep(1000);
		hp.SignUp().click();
		Thread.sleep(1000);
		RegistrationPage reg = new RegistrationPage();
		reg.enterName("Carl");
		Thread.sleep(1000);
		reg.enterLast("Edmonds");
		Thread.sleep(1000);
		reg.enterContactNumber("0871234567");
		Thread.sleep(1000);
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(1000);
		Thread.sleep(1000);
		String ema = "username" + randomInt + "gmail.com";
		reg.enterEmail(ema);
		Thread.sleep(1000);
		String ps = RandomStringUtils.randomAlphanumeric(8);
		reg.enterPassword(ps);
		Thread.sleep(1000);
		reg.enterConfirmPassword(ps);
		Thread.sleep(1000);
		((JavascriptExecutor) DriverManager.getWebDriver()).executeScript("arguments[0].scrollIntoView(true);",
				reg.signUpButton());
		reg.signUpButton().click();

	}

//		  Test 4
//		  
//		  Create Test for blank email on registration page -> verify that correct error
//		  message occurs on the top of the page

	@Test()
	public void BlankEmailTest() throws InterruptedException, IOException {
		HomePage hp = new HomePage();
		Thread.sleep(1000);
		hp.Account().click();
		Thread.sleep(1000);
		hp.SignUp().click();
		Thread.sleep(1000);
		RegistrationPage reg = new RegistrationPage();
		reg.enterName("Carl");
		Thread.sleep(1000);
		reg.enterLast("Edmonds");
		Thread.sleep(1000);
		reg.enterContactNumber("0871234567");
		Thread.sleep(1000);
//			Random randomGenerator = new Random();
//			int randomInt = randomGenerator.nextInt(1000);
//			Thread.sleep(1000);
//			String ema = "username" + randomInt + "gmail.com";
//			reg.enterEmail(ema);
//			Thread.sleep(1000);
		String ps = RandomStringUtils.randomAlphanumeric(8);
		reg.enterPassword(ps);
		Thread.sleep(1000);
		reg.enterConfirmPassword(ps);
		Thread.sleep(1000);
		((JavascriptExecutor) DriverManager.getWebDriver()).executeScript("arguments[0].scrollIntoView(true);",
				reg.signUpButton());
		reg.signUpButton().click();

	}

//		  Test 5
//		  
//		  Create Test for password doesnt match confirmation password on registration
//		  page -> verify that correct error message occurs on the top of the page

	@Test()
	public void ConfirmationPasswordTest() throws InterruptedException, IOException {
		HomePage hp = new HomePage();
		Thread.sleep(1000);
		hp.Account().click();
		Thread.sleep(1000);
		hp.SignUp().click();
		Thread.sleep(1000);
		RegistrationPage reg = new RegistrationPage();
		reg.enterName("Carl");
		Thread.sleep(1000);
		reg.enterLast("Edmonds");
		Thread.sleep(1000);
		reg.enterContactNumber("0871234567");
		Thread.sleep(1000);
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(1000);
		Thread.sleep(1000);
		String ema = "username" + randomInt + "@gmail.com";
		reg.enterEmail(ema);
		Thread.sleep(1000);
		String ps = RandomStringUtils.randomAlphanumeric(8);
		String confirmpass = "12345678";
		reg.enterPassword(ps);
		Thread.sleep(1000);
//			reg.enterConfirmPassword(ps);
		reg.enterConConfirmPassword(confirmpass);
		Thread.sleep(1000);
		((JavascriptExecutor) DriverManager.getWebDriver()).executeScript("arguments[0].scrollIntoView(true);",
				reg.signUpButton());
		reg.signUpButton().click();

	}

//		  Test 6
//		  
//		  Create Test for less than 6 character password on registration page -> verify
//		  that correct error message occurs on the top of the page

	@Test()
	public void LassCaractersTest() throws InterruptedException, IOException {
		HomePage hp = new HomePage();
		Thread.sleep(1000);
		hp.Account().click();
		Thread.sleep(1000);
		hp.SignUp().click();
		Thread.sleep(1000);
		RegistrationPage reg = new RegistrationPage();
		reg.enterName("Carl");
		Thread.sleep(1000);
		reg.enterLast("Edmonds");
		Thread.sleep(1000);
		reg.enterContactNumber("0871234567");
		Thread.sleep(1000);
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(1000);
		Thread.sleep(1000);
		String ema = "username" + randomInt + "@gmail.com";
		reg.enterEmail(ema);
		Thread.sleep(1000);
		String ps = RandomStringUtils.randomAlphanumeric(6);
		reg.enterPassword(ps);
		Thread.sleep(1000);
		reg.enterConfirmPassword(ps);
		Thread.sleep(1000);
		((JavascriptExecutor) DriverManager.getWebDriver()).executeScript("arguments[0].scrollIntoView(true);",
				reg.signUpButton());
		reg.signUpButton().click();

	}

}
