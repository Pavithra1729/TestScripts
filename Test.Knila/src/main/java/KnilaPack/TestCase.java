package KnilaPack;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import webPageobjects.LoginPageObjects;
import webPageobjects.PatientDetailsPageObjects;
import webPageobjects.PatientRecordObjects;
import webPageobjects.RegisterPatientOjects;
import webPageobjects.StartVisitObjects;

public class TestCase extends CommonFunctions{

	String Id;

	@Test(priority=0)
	public void LoginTestCase() throws IOException {

		ExtentTest Test = extentReports.createTest("Login Test Case");

		Test.log(Status.INFO,"Login into the OpenMRS Web Application by providing credentials");

		PageFactory.initElements(driver,LoginPageObjects.class);

		LoginPageObjects.UserName.sendKeys(properties.getProperty("username"));

		LoginPageObjects.PassWord.sendKeys(properties.getProperty("password"));

		LoginPageObjects.Location.click();

		LoginPageObjects.LoginButton.click();

		Test.log(Status.PASS, "Successfully logged into the Application");

		WebElement Logged = LoginPageObjects.Logged;
		String Title = Logged.getText().trim();

		System.out.println(Title);

		Assert.assertEquals(Title,"Logged in as Super User (admin) at Outpatient Clinic.");

		Test.log(Status.PASS,"Successfully Logged into the OpenMRS Web Application by providing credentials");

		TakesScreenshot screenshot= (TakesScreenshot) driver; 
		File SourceFile =screenshot.getScreenshotAs(OutputType.FILE); 
		File DestinationFile = new File(".\\Screenshots\\LoginPage.png");
		FileHandler.copy(SourceFile, DestinationFile);
		Test.addScreenCaptureFromPath(".\\Screenshots\\LoginPage.png"); 

	}

	@Test(priority=1)
	public void RegisterTestCase() throws IOException, InterruptedException
	{

		ExtentTest Test = extentReports.createTest("Register a Patient Test Case");

		Test.log(Status.INFO,"Filling the patient details");

		PageFactory.initElements(driver, RegisterPatientOjects.class);

		RegisterPatientOjects.RegisPatient.click();

		RegisterPatientOjects.PatientName.sendKeys(properties.getProperty("firstname"));

		RegisterPatientOjects.FamilyName.sendKeys(properties.getProperty("lastname"));

		RegisterPatientOjects.NextButton.click();

		WebElement Gender = RegisterPatientOjects.Gender;

		Select selectGender = new Select(Gender);
		selectGender.selectByValue("F");

		RegisterPatientOjects.NextButton1.click();

		RegisterPatientOjects.Birth.sendKeys(properties.getProperty("Bdate"));

		WebElement Month = RegisterPatientOjects.Month;

		Select selectMonth = new Select(Month);
		selectMonth.selectByVisibleText("March");

		RegisterPatientOjects.BirthYear.sendKeys(properties.getProperty("Byr"));

		RegisterPatientOjects.NextButton2.click();

		RegisterPatientOjects.Add1.sendKeys(properties.getProperty("add1"));

		RegisterPatientOjects.Add2.sendKeys(properties.getProperty("add2"));

		RegisterPatientOjects.City.sendKeys(properties.getProperty("city"));

		RegisterPatientOjects.State.sendKeys(properties.getProperty("state"));

		RegisterPatientOjects.Country.sendKeys(properties.getProperty("country"));

		RegisterPatientOjects.PostalCode.sendKeys(properties.getProperty("postalcd"));

		RegisterPatientOjects.NextButton3.click();

		RegisterPatientOjects.PhoneNo.sendKeys(properties.getProperty("phoneno"));

		RegisterPatientOjects.NextButton4.click();

		WebElement RelationType = RegisterPatientOjects.RelationType;

		Select selectRT = new Select(RelationType);
		selectRT.selectByIndex(5);

		RegisterPatientOjects.NextButton5.click();
		
		  String FLName =
		  driver.findElement(By.xpath("//div[@id='dataCanvas']/div/p[1]")).getText();

		  System.out.println(FLName);
		
		  String GenderVerify =
				driver.findElement(By.xpath("//div[@id='dataCanvas']/div/p[2]")).getText();
		System.out.println(GenderVerify);
		
		String Date =
				driver.findElement(By.xpath("//div[@id='dataCanvas']/div/p[3]")).getText();
		System.out.println(Date);
		
		String Address =
				driver.findElement(By.xpath("//div[@id='dataCanvas']/div/p[4]")).getText();
		
		System.out.println(Address);
		
		String Phone =
				driver.findElement(By.xpath("//div[@id='dataCanvas']/div/p[5]")).getText();
		
		System.out.println(Phone);
		
		Thread.sleep(1000);

		Assert.assertEquals(FLName,"Name: FirstName, LastName");	  
		Assert.assertEquals(GenderVerify, "Gender: Female");
		Assert.assertEquals(Date, "Birthdate: 12, March, 1998");
		Assert.assertEquals(Address, "Address: No-14, St, Road, TN, India, 612345");
		Assert.assertEquals(Phone, "Phone Number: 9876543210");
		
		System.out.println("Assert Equals verified");

		RegisterPatientOjects.Confirm.click();

		Test.log(Status.PASS,"Successfully patient details are provided and verified");
		
		TakesScreenshot screenshot= (TakesScreenshot) driver; 
		File SourceFile =screenshot.getScreenshotAs(OutputType.FILE); 
		File DestinationFile = new File(".\\Screenshots\\ConfirmPage.png");
		FileHandler.copy(SourceFile, DestinationFile);
		Test.addScreenCaptureFromPath(".\\Screenshots\\ConfirmPage.png"); 

		

	}

	@Test(priority=2)
	public void StartVisitTestCase() throws AWTException, IOException
	{
		ExtentTest Test = extentReports.createTest("Start a visit Test Case");

		Test.log(Status.INFO,"Start visit functionalities");
		
		Robot RB = new Robot();
		RB.delay(2000);

		PageFactory.initElements(driver,StartVisitObjects.class);

		StartVisitObjects.StartVisit.click();

		StartVisitObjects.Confirmbutton.click();

		StartVisitObjects.Attachments.click();

		StartVisitObjects.Upload.click();

		RB.delay(2000);

		String File = "C:\\Users\\REVANTH\\Downloads\\TechAssessmentAuto.txt";

		StringSelection selection = new
				StringSelection(File);

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null);

		Robot robot = new Robot(); 
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_ENTER);

		StartVisitObjects.Caption.sendKeys("Text file");
		robot.delay(1000);

		StartVisitObjects.UploadFile.click();
		
        String deletedSuccess = driver.findElement(By.xpath("//div[@class='toast-item-close']//following::p")).getText();
        
        System.out.println(deletedSuccess);
		
		String ExpectedStatement = "The attachment was successfully uploaded.";
		
		if (deletedSuccess.equals(ExpectedStatement)) 
		{
			Test.log(Status.PASS,"Successfully patient details were deleted by giving reason");
			
			TakesScreenshot screenshot= (TakesScreenshot) driver; 
			File SourceFile =screenshot.getScreenshotAs(OutputType.FILE); 
			File DestinationFile = new File(".\\Screenshots\\PatientDetails.png");
			FileHandler.copy(SourceFile, DestinationFile);
			Test.addScreenCaptureFromPath(".\\Screenshots\\PatientDetails.png"); 
		}
		
		else
		{
			Test.log(Status.FAIL,"Patient details were not deleted");
			TakesScreenshot screenshot= (TakesScreenshot) driver; 
			File SourceFile =screenshot.getScreenshotAs(OutputType.FILE); 
			File DestinationFile = new File(".\\Screenshots\\PatientDetailsF.png");
			FileHandler.copy(SourceFile, DestinationFile);
			Test.addScreenCaptureFromPath(".\\Screenshots\\PatientDetailsF.png"); 
		}

		StartVisitObjects.PDetails.click();

		TakesScreenshot screenshot= (TakesScreenshot) driver; 
		File SourceFile =screenshot.getScreenshotAs(OutputType.FILE); 
		File DestinationFile = new File(".\\Screenshots\\StartVisitPage.png");
		FileHandler.copy(SourceFile, DestinationFile);
		Test.addScreenCaptureFromPath(".\\Screenshots\\StartVisitPage.png"); 
		
		Test.log(Status.PASS,"Successfully patient recent visit has added");

	}
	@Test(priority=3)
	public void PatientDetails() throws AWTException, IOException
	{
		ExtentTest Test = extentReports.createTest("Patient Details");

		Test.log(Status.INFO,"Patient Details page with all entered and visit details ");

		PageFactory.initElements(driver, PatientDetailsPageObjects.class);

		Robot robot = new Robot();
		robot.delay(2000);

		WebElement RecentVisit =
				PatientDetailsPageObjects.RecentVisit;
		String RecentDate = RecentVisit.getText();

		Assert.assertEquals("14.Nov.2022", RecentDate,"Recent Visit has one entry for the current date");

		if((PatientDetailsPageObjects.AttachmentsTag).isDisplayed())
		{
			System.out.println("Attachment tag found for the recent visit");
		}

		if((PatientDetailsPageObjects.AttachmentsThumbNail).isDisplayed())
		{
			System.out.println("Attachement thumb nail found for the recent visit");
		}

		WebElement PatientId =
				PatientDetailsPageObjects.PatientId;
		Id = PatientId.getText();

		System.out.println(Id);

		PatientDetailsPageObjects.EndVisit.click();

		PatientDetailsPageObjects.EndVisitYes.click();

		System.out.println("Yes Clicked");
		
		robot.delay(1000);

		PatientDetailsPageObjects.DeletePatient.click();
		
		robot.delay(1000);
		
		PatientDetailsPageObjects.DeleteReason.sendKeys("Duplicate");

		robot.delay(2000);

		PatientDetailsPageObjects.DeleteConfirm.click();

		String deletedSuccess = driver.findElement(By.xpath("//div[@class='toast-item-close']//following::p")).getText();
		
		String ExpectedStatement = "Patient has been deleted successfully";
		
		if (deletedSuccess.equals(ExpectedStatement)) 
		{
			Test.log(Status.PASS,"Successfully patient details were deleted by giving reason");
			
			TakesScreenshot screenshot= (TakesScreenshot) driver; 
			File SourceFile =screenshot.getScreenshotAs(OutputType.FILE); 
			File DestinationFile = new File(".\\Screenshots\\PatientDetails.png");
			FileHandler.copy(SourceFile, DestinationFile);
			Test.addScreenCaptureFromPath(".\\Screenshots\\PatientDetails.png"); 
		}
		
		else
		{
			Test.log(Status.FAIL,"Patient details were not deleted");
			TakesScreenshot screenshot= (TakesScreenshot) driver; 
			File SourceFile =screenshot.getScreenshotAs(OutputType.FILE); 
			File DestinationFile = new File(".\\Screenshots\\PatientDetailsF.png");
			FileHandler.copy(SourceFile, DestinationFile);
			Test.addScreenCaptureFromPath(".\\Screenshots\\PatientDetailsF.png"); 
		}
	}


	@Test(priority=4)
	public void PatientRecordSearch() throws IOException
	{
		ExtentTest Test = extentReports.createTest("Patient Record Search");

		Test.log(Status.INFO,"Deleted Patient record is searched using patient ID");

		PageFactory.initElements(driver, PatientRecordObjects.class);

		PatientRecordObjects.PatientSearch.sendKeys(Id);

		WebElement MatchRecord =
				PatientRecordObjects.MatchRecord;
		String RecordMatch = MatchRecord.getText();

		System.out.println(RecordMatch);
		
		Assert.assertEquals("No matching records found", RecordMatch,"Deleted patient should not be listed in the table");	

		TakesScreenshot screenshot= (TakesScreenshot) driver; 
		File SourceFile =screenshot.getScreenshotAs(OutputType.FILE); 
		File DestinationFile = new File(".\\Screenshots\\PatientRecordSearch.png");
		FileHandler.copy(SourceFile, DestinationFile);
		Test.addScreenCaptureFromPath(".\\Screenshots\\PatientRecordSearch.png"); 
		
		Test.log(Status.PASS,"Successfully patient details are deleted and not found");

	}


}
