package webPageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartVisitObjects {
	
	@FindBy(linkText="Start Visit")
	public static WebElement StartVisit;
	
	@FindBy(xpath="(//button[text()='Confirm'])[4]")
	public static WebElement Confirmbutton;
	
	@FindBy(xpath="//a[text()=' Attachments']")
	public static WebElement Attachments;
	
	@FindBy(xpath="//*[text()='Click or drop a file here.']")
	public static WebElement Upload;
	
	@FindBy(xpath="//textarea[@placeholder='Enter a caption']")
	public static WebElement Caption;
	
	@FindBy (xpath="//button[text()='Clear forms']//preceding-sibling::button")
	public static WebElement UploadFile;
	
	@FindBy (xpath="//i[@class='icon-chevron-right link']/following-sibling::a")
	public static WebElement PDetails;
}
