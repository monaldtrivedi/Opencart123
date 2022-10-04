package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {
	
	public static WebDriver driver;
	
	public Logger logger;	//for logging

	
	public ResourceBundle rb;	//for reading properties file
	@BeforeClass(groups= {"sanity","regression","master"})
	@Parameters("browser")
	public void setup(String br)
	{	
		//Loading config.properties file
		rb=ResourceBundle.getBundle("config");
		
		
		//logging
		logger=LogManager.getLogger(this.getClass());	//for logging
		
		if(br.equals("chrome") || br.equals("") )
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(br.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else 
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(rb.getString("appURL"));
		
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups = {"sanity","regression","master"})
	public void tearDown()
	{
		driver.quit();
	}
	
	public String randomString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public String randomNumber()

	{
		String generatedString2=RandomStringUtils.randomNumeric(10);
		return generatedString2;
	}
	
	public String captureScreen(String tname) throws IOException
	{
		String timeStamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takesScreenshot=(TakesScreenshot)driver;
		File source=takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir") + "\\screenshorts\\" + tname + "_" + timeStamp + ".png";
		
		try 
		{
			FileUtils.copyFile(source, new File(destination));
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		return destination;
	}
}
