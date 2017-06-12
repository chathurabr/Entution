package SalesAndMarketing._03_CollectionUnits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.util.concurrent.TimeUnit;

public class _03_05_ModifyCopyFromDate {
	WebDriver driver;
	//Collection unit name,comm rate
		By colUnitName = By.id("txtCUName");
		By comRate = By.id("txtComRate");
	//Employee details
		By empSharingRate = By.xpath("//*[@id='tblEmpdata']/tbody/tr/td[7]/input");
	public _03_05_ModifyCopyFromDate(WebDriver driver){
		this.driver=driver;
	}
	
	public void ModifyCopyFromDate(String newColectionUnitName, String newComRate, String newEmployeeSharingRate ){
		this.ModifyCopyFromDateFunc(newColectionUnitName, newComRate, newEmployeeSharingRate);
	}
	
	public void ModifyCopyFromDateFunc(String newColectionUnitName,String newComRate, String newEmployeeSharingRate ){
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.elementToBeClickable(colUnitName));
		driver.findElement(colUnitName).clear();
		driver.findElement(colUnitName).sendKeys(newColectionUnitName);
		
		wait.until(ExpectedConditions.elementToBeClickable(comRate));
		driver.findElement(comRate).clear();
		driver.findElement(comRate).sendKeys(newComRate);
		
		wait.until(ExpectedConditions.elementToBeClickable(empSharingRate));
		driver.findElement(empSharingRate).clear();
		driver.findElement(empSharingRate).sendKeys(newEmployeeSharingRate);
			Reporter.log("Collection Unit name and Commission rate entered successfully");
	}
}
