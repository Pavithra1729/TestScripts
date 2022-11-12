package KnilaPack;

import org.testng.annotations.Test;

import webPageobjects.LoginPageObjects;
import webPageobjects.RegisterPatientOjects;
import webPageobjects.StartVisitObjects;

import org.testng.annotations.BeforeSuite;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;

public class Testing {

	WebDriver driver;

	@BeforeSuite
	public void beforeSuite() {
		driver = new ChromeDriver();

		driver.get("https://qa-refapp.openmrs.org/openmrs/login.htm");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void LoginTestCase() {
		
		PageFactory.initElements(driver,LoginPageObjects.class);
		
		LoginPageObjects.UserName.sendKeys("Admin");

		LoginPageObjects.PassWord.sendKeys("Admin123");
		
		LoginPageObjects.Location.click();

		LoginPageObjects.LoginButton.click();
		
	}
	
    @Test
    public void RegisterTestCase()
	{

    	PageFactory.initElements(driver, RegisterPatientOjects.class);
		
    	RegisterPatientOjects.RegisPatient.click();
    	
    	RegisterPatientOjects.PatientName.sendKeys("Firstname");

    	RegisterPatientOjects.FamilyName.sendKeys("Lastname");

    	RegisterPatientOjects.NextButton.click();

		WebElement Gender = driver.findElement(By.id("gender-field"));

		Select selectGender = new Select(Gender);
	    selectGender.selectByValue("F");

		RegisterPatientOjects.NextButton1.click();

		RegisterPatientOjects.Birth.sendKeys("12");

		WebElement Month = driver.findElement(By.id("birthdateMonth-field"));

		Select selectMonth = new Select(Month);
		selectMonth.selectByVisibleText("March");

		RegisterPatientOjects.BirthYear.sendKeys("1998");

		RegisterPatientOjects.NextButton2.click();

		RegisterPatientOjects.Add1.sendKeys("123");

		RegisterPatientOjects.Add2.sendKeys("456");

		RegisterPatientOjects.City.sendKeys("Road");

		RegisterPatientOjects.State.sendKeys("TN");

		RegisterPatientOjects.Country.sendKeys("India");

		RegisterPatientOjects.PostalCode.sendKeys("124");

		RegisterPatientOjects.NextButton3.click();

		RegisterPatientOjects.PhoneNo.sendKeys("1235");

		RegisterPatientOjects.NextButton4.click();

		WebElement RelationType = driver.findElement(By.id("relationship_type"));

		Select selectRT = new Select(RelationType);
		selectRT.selectByIndex(5);

		RegisterPatientOjects.NextButton5.click();

//	  Assert.assertEquals(1, 2,"Name match");
//	  assertEquals("Female", "Female");

		RegisterPatientOjects.Confirm.submit();
	}
    
    @Test
    public void StartVisitTestCase() throws AWTException
	{
    	PageFactory.initElements(driver,StartVisitObjects.class);
		
    	StartVisitObjects.StartVisit.click();

    	StartVisitObjects.Confirmbutton.click();

    	StartVisitObjects.Attachments.click();

    	StartVisitObjects.Upload.click();

		  StringSelection selection = new
		  StringSelection("\"C:\\Users\\REVANTH\\Downloads\\TechAssessmentAuto.txt\"");
		  
		  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,
		  null);
		  
		  Robot robot = new Robot(); 
		  robot.keyPress(KeyEvent.VK_CONTROL);
		  robot.keyPress(KeyEvent.VK_V);
		  robot.keyRelease(KeyEvent.VK_V);
		  robot.keyRelease(KeyEvent.VK_CONTROL);
		  
		  robot.keyPress(KeyEvent.VK_ENTER);
		  robot.keyPress(KeyEvent.VK_ENTER);
	
		  StartVisitObjects.Caption.sendKeys("Text file");
		  
	
	}

	@AfterSuite
	public void afterSuite() {
		// driver.quit();
	}

}
