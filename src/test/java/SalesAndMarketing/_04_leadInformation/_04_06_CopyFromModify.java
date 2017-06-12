package SalesAndMarketing._04_leadInformation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.util.concurrent.TimeUnit;

public class _04_06_CopyFromModify {
	WebDriver driver;
	By mobiletxtBx = By.id("txtMobileHeader");
	By salesUnitDropDown = By.id("cboxSalesUnitPerson");
	By nicTxtBx = By.id("txtNIC");

	public _04_06_CopyFromModify(WebDriver driver){
		this.driver=driver;
	}
	
	public void CopyFromModify(String newMobileNumber,String newSalesUnit,String newIDNUmber){
		this.modifyVals(newMobileNumber,newSalesUnit,newIDNUmber);
	}
	
	public void modifyVals(String newMobileNumber, String newSalesUnit,String newIDNUmber){
		Actions action = new Actions(driver);
		
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		//Mobile Number
			Reporter.log("User on edit screen");
		wait.until(ExpectedConditions.elementToBeClickable(mobiletxtBx));
		WebElement clickIt = driver.findElement(mobiletxtBx);
			action.moveToElement(clickIt).click().build().perform();
		driver.findElement(mobiletxtBx).clear();
			action.moveToElement(clickIt).sendKeys(newMobileNumber).build().perform();
			
		//Sales unit
			wait.until(ExpectedConditions.elementToBeClickable(salesUnitDropDown));	
			Select salesUnitDD = new Select(driver.findElement(salesUnitDropDown));
			salesUnitDD.selectByVisibleText(newSalesUnit);
		
		//NIC
			wait.until(ExpectedConditions.elementToBeClickable(nicTxtBx));
			WebElement clickIt3 = driver.findElement(nicTxtBx);
				action.moveToElement(clickIt3).click().build().perform();
			driver.findElement(nicTxtBx).clear();
				action.moveToElement(clickIt3).sendKeys(newIDNUmber).build().perform();
				
				Reporter.log("Relevant fields vales have changed");
	}
}
