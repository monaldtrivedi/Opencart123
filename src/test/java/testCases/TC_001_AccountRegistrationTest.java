package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass
{
	
	
	
	
	@Test(groups= {"regression","master"})
	void test_account_registraion()
	{
		logger.info("*******Starting TC_001_AccountRegistrationTest*********");
		try
		{
		HomePage hp=new HomePage(driver);
		
		hp.clickMyAccount();
		logger.info("clicked on MyAccount");
		hp.clickRegister();
		logger.info("clicked on Register");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		regpage.setFirstName(randomString().toUpperCase());
		logger.info("Provided first name");
		
		regpage.setLastName(randomString().toUpperCase());
		logger.info("provided Last name");
		
		regpage.setEmail(randomString() + "@gmail.com"); //randomly generated the email
		logger.info("Provided Email");
		
		regpage.setTelephone(randomNumber());		
		logger.info("Provided Telephone Number");
		
		regpage.setPassword("test@123");
		logger.info("Provided Password");
		
		regpage.setConfirmPassword("test@123");
		logger.info("Provided ConfirmPassword");
		
		regpage.setPrivatePolicy();
		logger.info("Provided PrivatePolicy");
		
		regpage.clickContinue();
		logger.info("Clicked to Continue");
		String confmsg=regpage.getConfirmationMsg();
		
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			Assert.fail();
			logger.error("Rejistration test failed...");
		}
		logger.info("*******Finished_TC_001_AccountRgistrationTest*******");
	}

}
