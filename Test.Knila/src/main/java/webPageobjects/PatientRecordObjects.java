package webPageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PatientRecordObjects {

	@FindBy(id="patient-search")
	public static WebElement PatientSearch;
	
	@FindBy(xpath="//td[text()='No matching records found']")
	public static WebElement MatchRecord;
	
	
}
