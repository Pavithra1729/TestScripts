package webPageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PatientRecordObjects {

	@FindBy(id="patient-search")
	public static WebElement PatientSearch;
	
	@FindBy(xpath="//td[@class='dataTables_empty']")
	public static WebElement MatchRecord;
	
	
}
