package SalesAndMarketing._04_leadInformation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class _04_10_ConvertLeadAsAccount {
	WebDriver driver;
	By AccountCodeTxtBx = By.id("txtAccountCode");
	By AccountGroupDD = By.id("cboxAccountGroup");
	//
	By accountInformationScrn = By.xpath("//*[@id='trnpageheader']/a");
	By accountInfoPageHeading = By.id("spPageName");
	By accInfoFindBox = By.id("txtg1012");
	By accInfoSrchBtn = By.xpath("//*[@id='g1012']/div[1]/span[3]");
	By accInfoColOne = By.xpath("//*[@id='g1012-t']/table/tbody/tr");
	
	String accNumb;
	
	public _04_10_ConvertLeadAsAccount(WebDriver driver){
		this.driver = driver;
	}
	
	public void ConvertLeadAsAccount(String accountCode, String selectDropdownItem){
		this.fillAccountInfo(accountCode, selectDropdownItem);
		this.chkAccountInfo();
	}
	
	public void fillAccountInfo(String accountCode, String selectDropdownItem){
		Actions action = new Actions(driver);
		accNumb = accountCode;
		
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		
		//Name Title
		wait.until(ExpectedConditions.presenceOfElementLocated(AccountCodeTxtBx));
		if(driver.findElement(AccountCodeTxtBx).isEnabled()){
			wait.until(ExpectedConditions.elementToBeClickable(AccountCodeTxtBx));
			WebElement clickIt = driver.findElement(AccountCodeTxtBx);
			action.moveToElement(clickIt).click().build().perform();
				driver.findElement(AccountCodeTxtBx).clear();
			action.moveToElement(clickIt).sendKeys(accountCode).build().perform();
		} else{
			Reporter.log("Auto generated account code");
		}
		
		
		Select dropDown = new Select(driver.findElement(AccountGroupDD));
		dropDown.selectByVisibleText(selectDropdownItem);
			Reporter.log("Filled the mandatory fields");
	}
	
	public void chkAccountInfo(){
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SoftAssert soAssert = new SoftAssert();
		
		Actions action = new Actions(driver);
		
		//fillAccountInfo(accNumb, accountCode);
		
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		//Name Title
		wait.until(ExpectedConditions.elementToBeClickable(accountInformationScrn));
		WebElement clickIt = driver.findElement(accountInformationScrn);
			action.moveToElement(clickIt).click().build().perform();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(accountInfoPageHeading));
		
		wait.until(ExpectedConditions.elementToBeClickable(accInfoFindBox));
		WebElement clickSearchbx = driver.findElement(accInfoFindBox);
			action.moveToElement(clickSearchbx).click().build().perform();
			action.moveToElement(clickSearchbx).sendKeys(accNumb).build().perform();
			
		wait.until(ExpectedConditions.elementToBeClickable(accInfoSrchBtn));
		WebElement clickSearchBtn = driver.findElement(accInfoSrchBtn);
		action.moveToElement(clickSearchBtn).click().build().perform();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(accInfoColOne));
	}
}
