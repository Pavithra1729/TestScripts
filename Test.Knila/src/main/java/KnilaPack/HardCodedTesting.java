package KnilaPack;

import org.testng.annotations.Test;

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
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;

public class HardCodedTesting {

	WebDriver driver;

	@BeforeSuite
	public void beforeSuite() {
		driver = new ChromeDriver();

		driver.get("https://qa-refapp.openmrs.org/openmrs/login.htm");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Test
	public void LoginTestCase() throws AWTException {


		WebElement UserName = driver.findElement(By.id("username"));
		UserName.sendKeys("Admin");

		WebElement PassWord = driver.findElement(By.id("password"));
		PassWord.sendKeys("Admin123");

		WebElement Location = driver.findElement(By.id("Outpatient Clinic"));
		Location.click();

		WebElement LoginButton = driver.findElement(By.id("loginButton"));
		LoginButton.click();

		WebElement RegisPatient = driver.findElement(By.xpath("//*[@class=\"icon-user\"]"));
		RegisPatient.click();

		WebElement PatientName = driver.findElement(By.name("givenName"));
		PatientName.sendKeys("Firstname");

		WebElement FamilyName = driver.findElement(By.name("familyName"));
		FamilyName.sendKeys("Lastname");

		WebElement NextButton = driver.findElement(By.id("next-button"));
		NextButton.click();

		WebElement Gender = driver.findElement(By.id("gender-field"));

		Select selectGender = new Select(Gender);
		selectGender.selectByValue("F");

		WebElement NextButton1 = driver.findElement(By.id("next-button"));
		NextButton1.click();

		WebElement Birth = driver.findElement(By.id("birthdateDay-field"));
		Birth.sendKeys("12");

		WebElement Month = driver.findElement(By.id("birthdateMonth-field"));

		Select selectMonth = new Select(Month);
		selectMonth.selectByVisibleText("March");

		WebElement BirthYear = driver.findElement(By.id("birthdateYear-field"));
		BirthYear.sendKeys("1998");

		WebElement NextButton2 = driver.findElement(By.id("next-button"));
		NextButton2.click();

		WebElement Add1 = driver.findElement(By.id("address1"));
		Add1.sendKeys("19");

		WebElement Add2 = driver.findElement(By.id("address2"));
		Add2.sendKeys("98");

		WebElement City = driver.findElement(By.id("cityVillage"));
		City.sendKeys("Road");

		WebElement State = driver.findElement(By.id("stateProvince"));
		State.sendKeys("TN");

		WebElement Country = driver.findElement(By.id("country"));
		Country.sendKeys("India");

		WebElement PostalCode = driver.findElement(By.id("postalCode"));
		PostalCode.sendKeys("124");

		WebElement NextButton3 = driver.findElement(By.id("next-button"));
		NextButton3.click();

		WebElement PhoneNo = driver.findElement(By.name("phoneNumber"));
		PhoneNo.sendKeys("1235");

		WebElement NextButton4 = driver.findElement(By.id("next-button"));
		NextButton4.click();

		WebElement RelationType = driver.findElement(By.id("relationship_type"));

		Select selectRT = new Select(RelationType);
		selectRT.selectByIndex(5);

		WebElement NextButton5 = driver.findElement(By.id("next-button"));
		NextButton5.click();

		//		  Assert.assertEquals(1, 2,"Name match");
		//		  assertEquals("Female", "Female");

		WebElement Confirm = driver.findElement(By.id("submit"));
		Confirm.submit();

		WebElement StartVisit = driver.findElement(By.linkText("Start Visit"));
		StartVisit.click();

		WebElement Confirmbutton = driver.findElement(By.xpath("(//button[text()='Confirm'])[4]"));
		Confirmbutton.click();

		WebElement Attachments = driver.findElement(By.xpath("//a[text()=' Attachments']"));
		Attachments.click();

		WebElement Upload = driver.findElement(By.xpath("//*[text()='Click or drop a file here.']"));
		Upload.click();

		Robot RB = new Robot();
		RB.delay(2000);
		
		String File = "C:\\Users\\REVANTH\\Downloads\\TechAssessmentAuto.txt";

		StringSelection selection = new StringSelection(File);

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,
				null);

		Robot robot = new Robot(); robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V); robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		robot.keyPress(KeyEvent.VK_ENTER); robot.keyPress(KeyEvent.VK_ENTER);

		WebElement Caption =
				driver.findElement(By.xpath("//textarea[@placeholder='Enter a caption']"));
		Caption.sendKeys("Text file");

		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[text()='Clear forms']//preceding-sibling::button"))));

		robot.delay(1000);

		WebElement UploadFile =
				driver.findElement(By.xpath("//button[text()='Clear forms']//preceding-sibling::button"));
		UploadFile.click();
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
//
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()='The attachment was successfully uploaded.']")));

		robot.delay(1000);
		
//		 String ToastMsg = driver.findElement(By.
//		  xpath("/html/body/div[2]/div/div/p")).getText();
//		 
//			robot.delay(1000);
//			
//		 Assert.assertEquals(" The attachment was successfully uploaded.",
//		  ToastMsg,"Actual Toast Message matches with the expected message");
		

		
		//toast-item-close
	}

	@AfterSuite
	public void afterSuite() {
		// driver.quit();
	}

}

