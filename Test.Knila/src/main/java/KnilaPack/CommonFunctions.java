package KnilaPack;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class CommonFunctions {
 
	public static WebDriver driver;
	public static Properties properties=null;

	ExtentSparkReporter ExtentSpark = new ExtentSparkReporter("Extent Reports.html");;
	
	ExtentReports extentReports;
	
	public Properties LoadPropFile() throws IOException
	{
		FileInputStream fileInputStream= new FileInputStream("Setting.properties");
	    properties= new Properties();
		properties.load(fileInputStream);
		return properties;
	}
	
	@BeforeSuite
		public void BrowserLaunch() throws IOException, AWTException
	{
		    LoadPropFile();
		    extentReports = new ExtentReports();
			  
		    extentReports.attachReporter(ExtentSpark);
			  
			  ExtentTest Test = extentReports.createTest("Url Launch");
			  
			  String browser=properties.getProperty("browser");
			  String url=properties.getProperty("url");
			
			driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			
			driver.get(url);
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			 
			Test.log(Status.INFO,"Launching OpenMRS" ); 
		
				Test.log(Status.PASS,"Actual title and Expected title are equal");
				TakesScreenshot screenshot= (TakesScreenshot) driver; 
				File SourceFile =screenshot.getScreenshotAs(OutputType.FILE); 
				File DestinationFile = new File(".\\OpenMRS1.png");
				FileHandler.copy(SourceFile, DestinationFile);
			    Test.addScreenCaptureFromPath(".\\OpenMRS1.png"); 
			   
  }
	@AfterSuite
	public void Browserclose() throws InterruptedException
	{
		extentReports.flush();
		 
		 Thread.sleep(3000);
		 
		 driver.quit();
	}
}
