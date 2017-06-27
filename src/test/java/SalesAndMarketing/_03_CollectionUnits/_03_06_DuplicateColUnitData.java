package SalesAndMarketing._03_CollectionUnits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.util.concurrent.TimeUnit;

public class _03_06_DuplicateColUnitData {
	WebDriver driver;
	By duplicateBtn = By.xpath("//*[@id='permissionBar']/a[2]");
	
	By enterColUnitCodeTxtfld = By.id("txtCUCode");
	
	public _03_06_DuplicateColUnitData(WebDriver driver){
		this.driver=driver;
		
	}
	
	public void DuplicateColUnitData(String NewCollectionUnitCode){
		this.clkOnDuplicate();
		this.fillMandatoryFields(NewCollectionUnitCode);
	}
	
	public void clkOnDuplicate(){
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.elementToBeClickable(duplicateBtn));

		//driver.findElement(duplicateBtn).click();
			Reporter.log("Navigated to new page and work object opened with relevant data ");
	}
	
	public void fillMandatoryFields(String NewCollectionUnitCode){
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.elementToBeClickable(enterColUnitCodeTxtfld));
		driver.findElement(enterColUnitCodeTxtfld).clear();
		driver.findElement(enterColUnitCodeTxtfld).sendKeys(NewCollectionUnitCode);
			Reporter.log("User able to enter relevant values");
	}
}
