package SalesAndMarketing._02_salesUnits;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class RegressionTesting {
	WebDriver driver;
	By salesUnitCode = By.id("txtSUCode");
	By salesUnitName = By.id("txtSUName");
	//UnitLead
	By unitLeader = By.xpath("//*[@id='divGen']/div[2]/table/tbody/tr[6]/td[2]/div/span[2]/span");
	By unitLeaderName = By.id("txtg1002");
	By unitLeaderColumnName =By.xpath("//*[@id='g1002-t']/table/tbody/tr[1]/td[7]");
	By unitLeaderColumn = By.xpath("//*[@id='g1002-t']/table/tbody/tr[1]");
	
	//Employee Code
	By empCodeIcon = By.xpath("//*[@id='tblEmpdata']/tbody/tr/td[4]/span");
	By empName = By.id("txtg1002");
	By empTable = By.xpath("//*[@id='g1002-t']");
	By empColumn = By.xpath("//*[@id='g1002-t']/table/tbody/tr[1]");
	By empSharingRate = By.xpath("//*[@id='tblEmpdata']/tbody/tr/td[8]/input");
	//Commision Rate error msg
	By errorMsgCloseBtn = By.xpath("//*[@id='validator']/a/i");
	By commisionRateErrMsg = By.xpath("//*[@id='divGen']/div[2]/table/tbody/tr[3]/td[2]/div/label");
	
	public RegressionTesting(WebDriver driver){
		this.driver=driver;
	}
	
	public void RegressionTestingCon(String salUniCode, String salesUniName, String unitLeadName, String emploName, String employeeSharingRateAmount){
		this.newCollectionUnitCannotDraftedWithoutACommissionRate(salUniCode,salesUniName);
		this.insertUnitLeadName(unitLeadName);
		this.insertUnitLead();
		this.clkOnEmpCodeIcon();
		this.enterEmpCode(emploName);
		this.enterSharingRate(employeeSharingRateAmount);
		this.verifyCommissionRateErrMsg();
	}
	
	public void newCollectionUnitCannotDraftedWithoutACommissionRate(String salUniCode, String salesUniName){
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.elementToBeClickable(salesUnitCode));
		WebElement salesUniCode = driver.findElement(salesUnitCode);
		action.moveToElement(salesUniCode).click().build().perform();
		action.moveToElement(salesUniCode).sendKeys(salUniCode).build().perform();
		
		wait.until(ExpectedConditions.elementToBeClickable(salesUnitName));
		WebElement salUniName = driver.findElement(salesUnitName);
		action.moveToElement(salUniName).click().build().perform();
		action.moveToElement(salUniName).sendKeys(salesUniName).build().perform();
	}
	
	public void insertUnitLeadName(String unitLeadName){
		
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.elementToBeClickable(unitLeader));
		driver.findElement(unitLeader).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(unitLeaderName));
		WebElement ClickIt = driver.findElement(unitLeaderName);
		Actions action = new Actions(driver);
		action.click(ClickIt);
		action.sendKeys(unitLeadName);
		action.sendKeys(Keys.ENTER);
		action.build().perform();
		
		
	}
	
	public void insertUnitLead(){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(unitLeaderColumn));
		
		WebElement clickIt = driver.findElement(unitLeaderColumn);	
		Actions action = new Actions(driver);
		action.doubleClick(clickIt);
		action.build().perform();
		
	}
	public void clkOnEmpCodeIcon(){
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(empCodeIcon));
		driver.findElement(empCodeIcon).click();
		
	}
	
	public void enterEmpCode(String emploName){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(empName));
		WebElement clickIt = driver.findElement(empName);
		Actions action = new Actions(driver);
		action.click(clickIt);
		driver.findElement(empName).clear();
		action.click(clickIt);
		action.sendKeys(emploName);
		action.sendKeys(Keys.ENTER).build().perform();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement clickItt = driver.findElement(empColumn);	
		Actions actionn = new Actions(driver);
		actionn.doubleClick(clickItt);
		actionn.build().perform();
	}
	
	public void enterSharingRate(String employeeSharingRateAmount){
		
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(empSharingRate));
		driver.findElement(empSharingRate).click();
		driver.findElement(empSharingRate).clear();
		driver.findElement(empSharingRate).click();
		driver.findElement(empSharingRate).sendKeys(employeeSharingRateAmount);//action.sendKeys(employeeSharingRateAmount).build().perform();
	}
	
	public void verifyCommissionRateErrMsg(){
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.elementToBeClickable(errorMsgCloseBtn));
		driver.findElement(errorMsgCloseBtn).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(commisionRateErrMsg));
	}
}
