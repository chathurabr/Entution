package SalesAndMarketing._06_Campaigns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class _06_01_NavToCampaign {
	WebDriver driver;
	By campaingMod = By.xpath("//*[@id='header2']/li/a[1]");
	By pageName = By.id("spPageName");
	By NewCampaignbtn = By.id("btnUpdate");
	
	public _06_01_NavToCampaign(WebDriver driver){
		this.driver=driver;
	}
	public void NavToCampaign(){
		this.navigationToCampaign();
		this.verifyPageHeading();
		this.verifyButton();
		
	}
	public void navigationToCampaign(){
		Actions action = new Actions(driver);
		
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.elementToBeClickable(campaingMod));
		WebElement clickIt = driver.findElement(campaingMod);
		action.moveToElement(clickIt).click().build().perform();
			Reporter.log("User successfully navigate to Campaign page");
	}
	
	public void verifyPageHeading(){
		SoftAssert soAssert = new SoftAssert();
				
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(pageName));
		
		soAssert.assertEquals("Campaign", driver.findElement(pageName).getText());
		
			Reporter.log("Page header verified");
			soAssert.assertAll();
	}
	
	public void verifyButton(){
		SoftAssert soAssert = new SoftAssert();
		Actions action = new Actions(driver);
		
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.elementToBeClickable(NewCampaignbtn));
		soAssert.assertTrue(driver.findElement(NewCampaignbtn).isDisplayed());
			Reporter.log("New Campaign button is visible");
		soAssert.assertAll();
		
	}
}
