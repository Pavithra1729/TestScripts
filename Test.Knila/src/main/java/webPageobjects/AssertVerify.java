package webPageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AssertVerify 
{

	@FindBy(xpath="//div[@id='dataCanvas']/div/p[1]")
	public static WebElement FLNameVerify;
	
	@FindBy(xpath="//div[@id='dataCanvas']/div/p[2]")
	public static WebElement GenderVerify;
	
	@FindBy(xpath="//div[@id='dataCanvas']/div/p[3]")
	public static WebElement DateVerify;
	
	@FindBy(xpath="//div[@id='dataCanvas']/div/p[4]")
	public static WebElement AddressVerify;
	
	@FindBy(xpath="//div[@id='dataCanvas']/div/p[5]")
	public static WebElement PhoneNoVerify;
}
