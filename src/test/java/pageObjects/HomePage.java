package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage
{
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	//Elements
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement lnkMyaccount;
	
	@FindBy(linkText="Register")
	WebElement lnkregister;
	
	
	@FindBy(linkText="Login")	//login link added in step 6
	WebElement linkLogin;
	
	//Action Methods
	public void clickMyAccount() 
	{
		lnkMyaccount.click();
	}
	
	public void clickRegister() 
	{
		lnkregister.click();
	}
	
	public void clickLogin()	//add in step 6
	{
		linkLogin.click();
	}
	
	
}
