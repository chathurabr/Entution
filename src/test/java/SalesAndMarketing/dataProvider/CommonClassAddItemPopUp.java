package SalesAndMarketing.dataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.util.concurrent.TimeUnit;


/***************************************************************************************
 * 										This class contains 
 *							Search textBox - diffrent ID, Search button(send enter key), 1st Column double click - diffrent
 *							refresh button	
 *****************************************************************************************/
public class CommonClassAddItemPopUp {
	
	 static WebDriver wdd = CommonClass.driver;
	 
		public static WebDriver searchTxtBoxSendText(String searchText){
			 
		 	WebDriverWait wait = new WebDriverWait(wdd, 40);
			wait.pollingEvery(30, TimeUnit.SECONDS);
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='txtg1011']")));
			//driver.findElement(By.xpath("//*[@id='txtg1011']")).click();
			wdd.findElement(By.id("txtg1011")).sendKeys(searchText);
			
		 return wdd;
	 }
		
		 public static WebDriver searchBtnClk(){
			 Actions action = new Actions(wdd);
			 
			 	WebDriverWait wait = new WebDriverWait(wdd, 40);
				wait.pollingEvery(30, TimeUnit.SECONDS);
				
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='g1011']/div[1]/span[2]")));
				WebElement clickEle = wdd.findElement(By.xpath("//*[@id='g1011']/div[1]/span[2]"));
				action.moveToElement(clickEle).click().build().perform();
				
			 return wdd;
		 }
		 
		 public static WebDriver firstColDblClk(){
			 
			 Actions action = new Actions(wdd);
			 
			 	WebDriverWait wait = new WebDriverWait(wdd, 40);
				wait.pollingEvery(30, TimeUnit.SECONDS);
				
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='g1011-t']/table/tbody/tr[1]")));
				WebElement clickEle = wdd.findElement(By.xpath("//*[@id='g1011-t']/table/tbody/tr[1]"));
				action.moveToElement(clickEle).doubleClick().build().perform();
			 
			 return wdd;
		 }
		 
		 public static WebDriver refreshButton(){
			 Actions action = new Actions(wdd);
			 
			 	WebDriverWait wait = new WebDriverWait(wdd, 40);
				wait.pollingEvery(30, TimeUnit.SECONDS);
				
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='A17']/i")));
				WebElement clickIt = wdd.findElement(By.xpath("//*[@id='A17']/i"));
				action.moveToElement(clickIt).click().build().perform();
				
					Reporter.log("Clicked on refresh button");
				
			return wdd;
		 }
		 
}
