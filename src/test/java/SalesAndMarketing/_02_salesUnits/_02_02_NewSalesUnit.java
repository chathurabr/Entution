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

public class _02_02_NewSalesUnit {
	WebDriver driver;
	By newSalesUnitBtn = By.id("btnUpdate");
	By draftBtn = By.xpath("//*[@id='permissionBar']/a[1]");
	
	By msgValidator = By.id("validator");
	By msgValidatorClose = By.xpath("//*[@id='validator']/a/i");
	//Mandatory list
	By salesUniCodeMsg = By.xpath("//*[@id='divGen']/div[2]/table/tbody/tr[1]/td[2]/div/label");
	By salesUniNamMsg1 = By.xpath("//*[@id='divGen']/div[2]/table/tbody/tr[2]/td[2]/div/label[1]");
	By salesUniNamMsg2 = By.xpath("//*[@id='divGen']/div[2]/table/tbody/tr[2]/td[2]/div/label[2]");
	By commRateMsg = By.xpath("//*[@id='divGen']/div[2]/table/tbody/tr[3]/td[2]/div/label");
	By unitLeaderMsg = By.xpath("//*[@id='divGen']/div[2]/table/tbody/tr[6]/td[2]/div[2]/label");
	By empCodeMsgImg1 = By.xpath("//*[@id='divGen']/div[4]/div[2]/div/div[1]/div/table/thead/tr/th[1]/span");
	By empCodeMsgImg2 = By.xpath("//*[@id='tblEmpdata']/tbody/tr/td[1]/span");
	
	public _02_02_NewSalesUnit(WebDriver driver){
		this.driver=driver;
	}
	
	public void NewSalesUnit(){
		this.newSalesUnitClk();
		this.chkMandatoryFields();
	}
	
	public void newSalesUnitClk(){
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(newSalesUnitBtn));
		if(driver.findElement(newSalesUnitBtn).isDisplayed()){
			driver.findElement(newSalesUnitBtn).click();
			Reporter.log("Successfully navigate to New Sales Unit page");
		}
	}
	
	public void chkMandatoryFields(){
		SoftAssert soAssertion = new SoftAssert();
		
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(draftBtn));
		driver.findElement(draftBtn).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(msgValidator));
		wait.until(ExpectedConditions.presenceOfElementLocated(msgValidatorClose));
		
		WebElement clickIt = driver.findElement(msgValidatorClose);
		Actions action = new Actions(driver);
		action.click(clickIt);
		action.build().perform();
		
		
		//Mandatory error messages
		wait.until(ExpectedConditions.presenceOfElementLocated(salesUniCodeMsg));
		soAssertion.assertEquals("You must enter a value.", driver.findElement(salesUniCodeMsg).getText());
		//
			wait.until(ExpectedConditions.presenceOfElementLocated(salesUniNamMsg1));
			soAssertion.assertEquals("You must enter a value.", driver.findElement(salesUniNamMsg1).getText());
		//
			wait.until(ExpectedConditions.presenceOfElementLocated(salesUniNamMsg2));
			soAssertion.assertEquals("You must enter a Name.", driver.findElement(salesUniNamMsg2).getText());
		//
		wait.until(ExpectedConditions.presenceOfElementLocated(commRateMsg));
		soAssertion.assertEquals("Commission rate can't be zero.",driver.findElement(commRateMsg).getText());
		//
		wait.until(ExpectedConditions.presenceOfElementLocated(unitLeaderMsg));
		soAssertion.assertEquals("You must enter a value.", driver.findElement(unitLeaderMsg).getText());
		//
			wait.until(ExpectedConditions.presenceOfElementLocated(empCodeMsgImg1));
			if(driver.findElement(empCodeMsgImg1).isDisplayed()){
			
			}
			else{
				Reporter.log("<font color='red'>Employee Code error message is not visible</font>");
			}
		//
			
			wait.until(ExpectedConditions.presenceOfElementLocated(empCodeMsgImg2));
			if(driver.findElement(empCodeMsgImg1).isDisplayed()){
			
			}
			else{
				Reporter.log("<font color='red'>Employee Code error message is not visible</font>");
			}
			Reporter.log("All mandatory fields gave error messages");
			
			driver.navigate().refresh();
	}
}
