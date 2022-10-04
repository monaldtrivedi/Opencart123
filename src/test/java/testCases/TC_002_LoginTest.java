package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass
{
	
	@Test(groups = {"sanity","master"})
	public void test_login()
	{
		try
		{
		logger.info("****** Starting TC_002_LoginTest******");
		
		
		HomePage hp=new HomePage(driver);
		
		hp.clickMyAccount();
		logger.info("clicked on MyAccount");
		hp.clickLogin();
		logger.info("clicked on Login");
		
		
		LoginPage lp=new LoginPage(driver);
		
		lp.setEmail(rb.getString("email"));	//valid email, get it from config properties file
		logger.info("Provided E-mail Address");
		lp.setPassword(rb.getString("password"));	//valid password, get it from config properties file
		logger.info("Provided Password");
		lp.clickLogin();
		logger.info("Clicked to Login");
		
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetpage=macc.isMyAccountPageExists();
		
		Assert.assertEquals(targetpage, true);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("****** Finished TC_002_LoginTest *******");
		
	}
}
