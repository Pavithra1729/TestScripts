package webPageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPatientOjects {

	@FindBy(xpath="//*[@class='icon-user']")
	public static WebElement RegisPatient; 

	@FindBy (name="givenName")
	public static WebElement PatientName;

	@FindBy (name="familyName")
	public static WebElement FamilyName;

	@FindBy (id="next-button")
	public static WebElement NextButton;

	@FindBy(id="gender-field")
	public static WebElement Gender; 
	
	@FindBy (id="next-button")
	public static WebElement NextButton1;

	@FindBy (id="birthdateDay-field")
	public static WebElement Birth;
	
	@FindBy (id="birthdateMonth-field")
	public static WebElement Month;

	@FindBy (id="birthdateYear-field")
	public static WebElement BirthYear;

	@FindBy (id="next-button")
	public static WebElement NextButton2;

	@FindBy (id="address1")
	public static WebElement Add1;

	@FindBy (id="address2")
	public static WebElement Add2;

	@FindBy (id="cityVillage")
	public static WebElement City;

	@FindBy (id="stateProvince")
	public static WebElement State;

	@FindBy (id="country")
	public static WebElement Country;

	@FindBy (id="postalCode")
	public static WebElement PostalCode;

	@FindBy (id="next-button")
	public static WebElement NextButton3;

	@FindBy (name="phoneNumber")
	public static WebElement PhoneNo;

	@FindBy (id="next-button")
	public static WebElement NextButton4;
	
	@FindBy (id="relationship_type")
	public static WebElement RelationType;

	@FindBy (id="next-button")
	public static WebElement NextButton5;

	@FindBy (id="submit")
	public static WebElement Confirm;

}
