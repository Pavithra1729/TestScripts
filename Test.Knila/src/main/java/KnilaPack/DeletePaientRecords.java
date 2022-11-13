package KnilaPack;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DeletePaientRecords {

	@Test
	public void DeletePaitent() throws AWTException
	{
		WebDriver driver = new ChromeDriver();
		 driver.get("https://qa-refapp.openmrs.org/openmrs/login.htm");
		 WebElement UserName = driver.findElement(By.id("username"));
			UserName.sendKeys("Admin");

			WebElement PassWord = driver.findElement(By.id("password"));
			PassWord.sendKeys("Admin123");

			WebElement Location = driver.findElement(By.id("Outpatient Clinic"));
			Location.click();

			WebElement LoginButton = driver.findElement(By.id("loginButton"));
			LoginButton.click();
			
			WebElement Search = driver.findElement(By.linkText("Find Patient Record"));
			Search.click();
			
			for(int i=1;i<=8;i++)
			{
				Robot robot = new Robot();
				robot.delay(2000);
				
			WebElement PatientSearch =
					driver.findElement(By.id("patient-search"));
			PatientSearch.sendKeys("FirstName"+Keys.ENTER);
			
			
			robot.delay(3000);
			
			WebElement MatchRecord =
					driver.findElement(By.xpath("(//tbody[@role='alert']//tr)[1]"));
			MatchRecord.click();
			
			WebElement DeletePatient =
					driver.findElement(By.linkText("Delete Patient"));
			DeletePatient.click();
			
			WebElement DeleteReason =
					driver.findElement(By.id("delete-reason"));
			DeleteReason.sendKeys("Duplicate");
			
			robot.delay(3000);
			
			WebElement DeleteConfirm =
					driver.findElement(By.xpath("(//button[text()='Confirm'])[3]"));
			DeleteConfirm.click();
			}
	}
}
