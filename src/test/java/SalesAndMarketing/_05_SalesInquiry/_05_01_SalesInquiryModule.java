package SalesAndMarketing._05_SalesInquiry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class _05_01_SalesInquiryModule {
	WebDriver driver;
	By salesInquiryModule = By.xpath("//*[@id='header0']/li[6]");
	By pageName = By.id("spPageName");
	
	public _05_01_SalesInquiryModule(WebDriver driver){
		this.driver=driver;
	}
	public void SalesInquiryModule(){
		this.goToSSalesInquiryModule();
		this.verifyPageHeading();
	}
	
	public void goToSSalesInquiryModule(){
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(2, TimeUnit.SECONDS);
	
		wait.until(ExpectedConditions.elementToBeClickable(salesInquiryModule));
		WebElement salesInqTab = driver.findElement(salesInquiryModule);
		action.moveToElement(salesInqTab).click().build().perform();
		
			Reporter.log("User successfully navigate to Sales Inquery page");
	}
	
	public void verifyPageHeading(){
		Actions action = new Actions(driver);
		SoftAssert soAssert = new SoftAssert();
				
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(pageName));
		
		soAssert.assertEquals("Sales Inquiry", driver.findElement(pageName).getText());
		
			Reporter.log("Page header verified");
			soAssert.assertAll();
	}
}
