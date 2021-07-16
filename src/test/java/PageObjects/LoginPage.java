package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DriverManagement.DriverManager;

public class LoginPage {
	
	public LoginPage() {

		PageFactory.initElements(DriverManager.getWebDriver(), this);
	}
	
	@FindBy(xpath = "//input[@type='email']")
	WebElement email;

	@FindBy(xpath = "//input[@type='password']")
	WebElement password;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement login;
	
	@FindBy(xpath = "//*[@id=\"loginfrm\"]/div[4]/div[3]/a")
	WebElement ForgotPassword;
	
	@FindBy(xpath = "//*[@id=\"loginfrm\"]/div[4]/div[1]/a")
	WebElement Signup;
	
	@FindBy(xpath = "//*[@id=\"loginfrm\"]/div[3]/div[3]/label")
	WebElement Remember;
	

	public WebElement Email() {
		return email;
	}

	public WebElement Password() {
		return password;
	}
	
	public WebElement Login() {
		return login;
	}
	
	public WebElement FogotPassword() {
		return ForgotPassword;
	}
	
	public WebElement Signup() {
		return Signup;
	}
	
	public WebElement Remember() {
		return Remember;
	}
	
	public void fillDetails(String Email,String ppass)
	{
		email.sendKeys(Email);
		password.sendKeys(ppass);
	}
	
	public void enterEmail(String Email)
	{
		email.sendKeys(Email);
	}
	
	public void enterPassword(String ppass)
	{
		password.sendKeys(ppass);
	}
	
	public void ForgotPassword(String forgot)
	{
		ForgotPassword.sendKeys(forgot);
	}
		
	public void fillDetails()
	{
		RegistrationPage rp = new RegistrationPage();
		email.sendKeys(rp.em);
		password.sendKeys(rp.s);
		login.click();
	}
}
