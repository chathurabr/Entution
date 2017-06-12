package SalesAndMarketing._05_SalesInquiry;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.util.concurrent.TimeUnit;

public class _05_10_NewSalesInqUsingCopyFrom {
	WebDriver driver;
	By srchTxtField = By.id("txtg1037");
	By colOne = By.xpath("//*[@id='g1037-t']/table/tbody/tr[1]");
	
	public _05_10_NewSalesInqUsingCopyFrom(WebDriver driver){
		this.driver=driver;
	}
	
	public void NewSalesInqUsingCopyFrom(String scrchKeyword){
		this.copyFromPopUp(scrchKeyword);
		this.dblClkOnColOne();
	}
	
	public void copyFromPopUp(String scrchKeyword){
		Actions action = new Actions(driver);
		
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(2, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.elementToBeClickable(srchTxtField));
		WebElement SrchEle = driver.findElement(srchTxtField);
		action.moveToElement(SrchEle).sendKeys(scrchKeyword).sendKeys(Keys.ENTER).build().perform();
	}
	
	public void dblClkOnColOne(){
		Actions action = new Actions(driver);
		
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(2, TimeUnit.SECONDS);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		wait.until(ExpectedConditions.elementToBeClickable(colOne));
		WebElement DblClkEle = driver.findElement(colOne);
		action.moveToElement(DblClkEle).doubleClick().build().perform();
			Reporter.log("Selected lead appeared on the screen");
		
	}
}
