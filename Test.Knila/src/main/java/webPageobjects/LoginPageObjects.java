package webPageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageObjects {
	 
	@FindBy(id = "username")
	  public static WebElement UserName; 

	  @FindBy(id="password")
	  public static WebElement PassWord; 
	  
	  @FindBy(id="Outpatient Clinic")
	  public static WebElement Location; 
	  
	  @FindBy(id="loginButton")
	  public static WebElement LoginButton; 
	  
}
