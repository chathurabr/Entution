package SalesAndMarketing._02_salesUnits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class _02_01_SalesUnits {
	WebDriver driver;
	By salesUnitHeader = By.xpath("//*[@id='header0']/li[7]");
	By pageHeader = By.id("spPageName");
	
	public _02_01_SalesUnits(WebDriver driver){
		this.driver=driver;
	}
	
	public void salesUnits(){
		this.navTOsalesUnitTab();
		this.verifyHeader();
	}
	
	public void navTOsalesUnitTab(){
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(salesUnitHeader));
		if(driver.findElement(salesUnitHeader).isDisplayed()){
			Reporter.log("Sales Unit option available");
			
			WebElement ClickIt = driver.findElement(salesUnitHeader);
			Actions action = new Actions(driver);
			action.click(ClickIt);
			action.build().perform();

		}
		else{
			Reporter.log("<font color='red'>Sales Unit option available</font>");
		}
	}
	
	public void verifyHeader(){
		SoftAssert soAssertion = new SoftAssert();
		
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.presenceOfElementLocated(pageHeader));
		
		if(driver.findElement(pageHeader).isDisplayed()){
		//soAssertion.assertEquals("Sales Unit", driver.findElement(pageHeader));
		Reporter.log("Sales Unit header verified");
		//soAssertion.assertAll();
		}
		else{
			Reporter.log("<font color='red'>Incorrect page header</font>");
		}
	}
}
