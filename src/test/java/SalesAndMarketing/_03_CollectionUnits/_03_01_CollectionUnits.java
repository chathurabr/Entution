package SalesAndMarketing._03_CollectionUnits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class _03_01_CollectionUnits {
	// Navigate to Collection unit screen
	WebDriver driver;
	@FindBy(xpath = "//*[@id='header0']/li[3]")
			private WebElement collUnitTab;
	@FindBy(id = "btnUpdate")
			private WebElement newColUnitBtn;

	By headerLbl = By.id("lblTemplateFormHeader");
	
	public  _03_01_CollectionUnits(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void CollectionUnits(){
		this.navToCollUnit();
		this.newColUnit();
		this.verifyHeader();
	}
	
	public void navToCollUnit(){
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.elementToBeClickable(collUnitTab));
		action.moveToElement(collUnitTab).click().build().perform();
			Reporter.log("User clicked on collection unit tab and navigate to Collection Unit page");
		
	}
	
	public void newColUnit(){
			Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.elementToBeClickable(newColUnitBtn));
			action.moveToElement(newColUnitBtn).click().build().perform();
				Reporter.log("User clicked on collection unit tab adn navigate to Collection Unit page");
	}
	
	public void verifyHeader(){
		SoftAssert soAsert = new SoftAssert();
		
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(headerLbl));
		soAsert.assertEquals("New", driver.findElement(headerLbl).getText());
		
		soAsert.assertAll();
			Reporter.log("Collection Unit Header verified");
	}
	
	
}
