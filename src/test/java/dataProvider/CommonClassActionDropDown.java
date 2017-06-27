package dataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.util.concurrent.TimeUnit;

/***************************************************************************************
 * 										This class contains 
 *					Action Dropdown, History
 *					Convert to Account
 *														
 *****************************************************************************************/
public class CommonClassActionDropDown extends CommonClass {
	//public static WebDriver driver;
	static WebDriver wdd = CommonClass.driver;
		
		public static WebDriver HistoryGoto(){
			WebDriverWait wait = new WebDriverWait(wdd, 40);
			wait.pollingEvery(30, TimeUnit.SECONDS);
																		
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sys-actions']/span[2]/span")));
			wdd.findElement(By.xpath("//*[@id='sys-actions']/span[2]/span")).click();
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='permissionBar']/div/div/a[1]")));
			wdd.findElement(By.xpath("//*[@id='permissionBar']/div/div/a[1]")).click();
			Reporter.log("History option available");
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='permissionBar']/div/div/a[2]")));
				
			return wdd;
		}
		
		public static WebDriver convertToAccount(){
			WebDriverWait wait = new WebDriverWait(wdd, 40);
			wait.pollingEvery(30, TimeUnit.SECONDS);
																		
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sys-actions']/span[2]/span")));
			wdd.findElement(By.xpath("//*[@id='sys-actions']/span[2]/span")).click();
			
			wait.until(ExpectedConditions.elementToBeClickable(By.className("spltbtnitm")));
			wdd.findElement(By.className("spltbtnitm")).click();
			Reporter.log("Convert to account option available");
				
			return wdd;
		}
}
