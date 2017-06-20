package SalesAndMarketing._03_CollectionUnits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.util.concurrent.TimeUnit;

public class _03_07_ActionDropdown {
 WebDriver driver;
 By actionDropdownBtn = By.xpath("//*[@id='sys-actions']/span[2]/span");
 By actionHistoryIcon = By.xpath("//*[@id='permissionBar']/div/div/a[1]");
 By actionActivitiesIcon = By.xpath("//*[@id='permissionBar']/div/div/a[2]");
 //
 By descriptionOne = By.xpath("//*[@id='ctrlActionHistory-t']/table/tbody/tr[1]/td[5]");
 By descriptionTwo	= By.xpath("//*[@id='ctrlActionHistory-t']/table/tbody/tr[2]/td[5]");
 
 public _03_07_ActionDropdown(WebDriver driver){
	 this.driver=driver;		 
 }
 
 public void ActionDropdown(){
	 this.actionDropDownFunc();
	 this.verifyHistory();
 }
 
 public void actionDropDownFunc(){
	 WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(actionDropdownBtn));
		driver.findElement(actionDropdownBtn).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(actionHistoryIcon));
		driver.findElement(actionHistoryIcon).click();
		Reporter.log("History option available");
		
		wait.until(ExpectedConditions.elementToBeClickable(actionActivitiesIcon));
		Reporter.log("Activities option available");
 }
 
 public void verifyHistory(){
	 WebDriverWait wait = new WebDriverWait(driver, 40);
	 wait.pollingEvery(30, TimeUnit.SECONDS);
	 
	 
	 wait.until(ExpectedConditions.presenceOfElementLocated(descriptionOne));
	 wait.until(ExpectedConditions.presenceOfElementLocated(descriptionTwo));
	 	Reporter.log("History viewed successfully");
 }
}
