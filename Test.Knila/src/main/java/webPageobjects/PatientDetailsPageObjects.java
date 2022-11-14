package webPageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class PatientDetailsPageObjects {
	
	@FindBy(xpath="(//a[@class='ng-binding'])[1]")
	public static WebElement RecentVisit;
  
	@FindBy(xpath="(//a[@class='ng-binding']//following-sibling::div)[1]")
	public static WebElement AttachmentsTag;
	
	@FindBy(xpath="//span[@class='att_thumbnail-extension']")
	public static WebElement AttachmentsThumbNail;

	@FindBy(xpath="//*[text()='Patient ID']/following-sibling::span")
	public static WebElement PatientId;
	
	@FindBy(linkText ="End Visit")
	public static WebElement EndVisit;
	
	@FindBy(xpath ="(//span[text()='Are you sure you want to end this visit?']//following::button)[1]")
	public static WebElement EndVisitYes;
	
	@FindBy(linkText ="Delete Patient")
	public static WebElement DeletePatient;
	
	@FindBy(id="delete-reason")
	public static WebElement DeleteReason;
	
	@FindBy (xpath="(//button[text()='Confirm'])[4]")
	public static WebElement DeleteConfirm;
	
}
