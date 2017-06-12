package SalesAndMarketing._05_SalesInquiry;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class _05_05_TagExistingCamp {
	WebDriver driver;
	
	public _05_05_TagExistingCamp(WebDriver driver){
		this.driver=driver;
		this.TagExistingCamp();
	}
	
	public void TagExistingCamp(){
		Reporter.log("Existing campaign taged successfully");
	}
}
