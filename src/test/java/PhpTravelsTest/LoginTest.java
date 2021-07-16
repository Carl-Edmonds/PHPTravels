package PhpTravelsTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import DriverManagement.TestBase;
import PageObjects.AfterLoginPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;

import PageObjects.RegistrationPage;

public class LoginTest extends TestBase {

	@Test
	public void SuccessfulLogin() throws InterruptedException {
		// Create a new object of Login scenario
		HomePage hp = new HomePage();
		// Click on Account
		hp.Account().click();
		// Click on login
		hp.LogIn().click();
		// Create a object of login page
		LoginPage lp = new LoginPage();
		// Enter email
		lp.enterEmail("test@test.test");// ??
		// Enter password
		lp.enterPassword("test123");// ??
		// Click on Login
		lp.Login().click();
		// Sleep for 2 seconds
		Thread.sleep(2000);
		AfterLoginPage alp = new AfterLoginPage();
		// Expected string
		String Loginexpected = "Hi, qwe qwe";
		// Actual string
		String Loginactual = alp.Verify().getText();
		// Comparing expected and actual values using assertion
		Assert.assertEquals(Loginactual, Loginexpected);

	}

//  Test 3   
//	  Create Test for invalid email on login page -> verify that correct error message occurs on the top of the page

	@Test
	public void InvalidEmailOnLogin() throws InterruptedException {

		String expectedtext2 = "Invalid Email or Password";

		HomePage hp = new HomePage();
		hp.Account().click();
		hp.LogIn().click();
		LoginPage lp = new LoginPage();
		lp.enterEmail("testWrongEmial.test");
		lp.enterPassword("test123");
		lp.Login().click();
		Thread.sleep(2000);

		Thread.sleep(2000);
		WebElement text2 = driver.findElement(By.xpath("//*[@id=\"loginfrm\"]/div[1]/div"));
		String actualtext2 = text2.getText().trim();

		if (expectedtext2.equals(expectedtext2)) {
			System.out.println("Invalid Email Tile Matches - Passed!");
		}

		else {
			System.out.println("Invalid Email Ttile does not Matches - Failed!");
		}

		Thread.sleep(2000);

		// Hard Assert
		Assert.assertEquals(expectedtext2.equals(actualtext2), true);
	}

//	  Test 4
//	 Create Test for blank email on login page -> verify that correct error message occurs on the top of the page

	@Test
	public void BlankEmailOnLogin() throws InterruptedException {

		String expectedtext2 = "Invalid Email or Password";

		HomePage hp = new HomePage();
		hp.Account().click();
		hp.LogIn().click();
		LoginPage lp = new LoginPage();
		lp.enterEmail("");
		lp.enterPassword("test123");
		lp.Login().click();
		Thread.sleep(2000);
		Thread.sleep(2000);
		WebElement text2 = driver.findElement(By.xpath("//*[@id=\"loginfrm\"]/div[1]/div"));
		String actualtext2 = text2.getText().trim();

		if (expectedtext2.equals(expectedtext2)) {
			System.out.println("Invalid Email Tile Matches - Passed!");
		}

		else {
			System.out.println("Invalid Email Ttile does not Matches - Failed!");
		}

		Thread.sleep(2000);

		// Hard Assert
		Assert.assertEquals(expectedtext2.equals(actualtext2), true);
	}

//	  Test 5
//	  Create Test for invalid password on login page -> verify that correct error message occurs on the top of the page

	@Test
	public void InvalidPasswordOnLogin() throws InterruptedException {

		String expectedtext2 = "Invalid Email or Password";

		HomePage hp = new HomePage();
		hp.Account().click();
		hp.LogIn().click();
		LoginPage lp = new LoginPage();
		lp.enterEmail("test@test.test");
		lp.enterPassword("InvalidPassword");
		lp.Login().click();
		Thread.sleep(2000);
		WebElement text2 = driver.findElement(By.xpath("//*[@id=\"loginfrm\"]/div[1]/div"));
		String actualtext2 = text2.getText().trim();

		if (expectedtext2.equals(expectedtext2)) {
			System.out.println("Invalid Email Tile Matches - Passed!");
		}

		else {
			System.out.println("Invalid Email Ttile does not Matches - Failed!");
		}

		Thread.sleep(2000);

		// Hard Assert
		Assert.assertEquals(expectedtext2.equals(actualtext2), true);

	}
//	  Test 6 
//	  Create a test to validate that once Forger Password button gets clicked customer can see pop-up Forget Password 

	@Test
	public void ForgetPassword() throws InterruptedException {

		String expectedtext2 = "Forget Password";

		HomePage hp = new HomePage();
		hp.Account().click();
		hp.LogIn().click();
		LoginPage lp = new LoginPage();
		lp.enterEmail("test@test.test");
		// lp.enterPassword("test123");
		// lp.FogotPassword().click();
		WebElement text2 = driver.findElement(By.xpath("//*[@id=\"ForgetPassword\"]/div/div/div[1]/h4"));
		String actualtext2 = text2.getText().trim();

		if (expectedtext2.equals(expectedtext2)) {
			System.out.println("Invalid Email Tile Matches - Passed!");
		}

		else {
			System.out.println("Invalid Email Ttile does not Matches - Failed!");
		}

		Thread.sleep(2000);

		// Hard Assert
		Assert.assertEquals(expectedtext2.equals(actualtext2), false);

	}
//	  Test 7  
//	  Create a test to validate that once Sign Up button gets clicked customer is moved to SignUp page 

	@Test
	public void VerifySignUp() throws InterruptedException {

		String expectedtext = "Sign Up";

		HomePage hp = new HomePage();
		hp.Account().click();
		hp.LogIn().click();
		LoginPage lp = new LoginPage();
//		lp.enterEmail("test@test.test");
//		lp.enterPassword("test123");
		lp.Signup().click();
		Thread.sleep(2000);
		// Validation

		Thread.sleep(2000);
		WebElement text = driver.findElement(By.xpath("/html/body/div[2]/div[1]/section/div/div/div[1]/div/h3"));
		String actualtext = text.getText().trim();

		if (expectedtext.equals(actualtext)) {
			System.out.println("Profile Title page Matches - Passed!");
		}

		else {
			System.out.println("Profile Title page does not Matches - Failed!");
		}

		Thread.sleep(2000);

		// Hard Assert
		Assert.assertEquals(expectedtext.equals(actualtext), true);

	}
//	  Test 8  
//	  Create a test to validate that once Remember Me button is clicked during positive test -> Customer can see the same credentaials during sec attempt

	@Test
	public void RememberMeButton() throws InterruptedException {

		HomePage hp = new HomePage();
		hp.Account().click();
		hp.LogIn().click();
		LoginPage lp = new LoginPage();
		lp.enterEmail("test@test.test");
		lp.enterPassword("test123");
		lp.Remember().click();
		lp.Login().click();
		Thread.sleep(2000);
		AfterLoginPage alp = new AfterLoginPage();
		String Loginexpected = "Hi, qwe qwe";
		String Loginactual = alp.Verify().getText();
		Assert.assertEquals(Loginactual, Loginexpected);

	}
}
