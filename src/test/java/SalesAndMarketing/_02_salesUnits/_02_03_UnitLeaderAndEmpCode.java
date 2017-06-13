package SalesAndMarketing._02_salesUnits;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class _02_03_UnitLeaderAndEmpCode {
	WebDriver driver;
	//Other
	By salesUnitCode = By.id("txtSUCode");
	By salesUnitName = By.id("txtSUName");
	By comRate = By.id("txtComRate");
	//UnitLead
	By unitLeader = By.xpath("//*[@id='divGen']/div[2]/table/tbody/tr[6]/td[2]/div/span[2]/span");
	By unitLeaderName = By.id("txtg1002");
	By unitLeaderColumnName =By.id("txtUnitLeader");
	By unitLeaderColumn = By.xpath("//*[@id='g1002-t']/table/tbody/tr[1]");
	
	//Employee Code
	By empCodeIcon = By.xpath("//*[@id='tblEmpdata']/tbody/tr/td[4]/span");
	By empName = By.id("txtg1002");
	By empTable = By.xpath("//*[@id='g1002-t']");
	By empColumn = By.xpath("//*[@id='g1002-t']/table/tbody/tr[1]");
	
	public _02_03_UnitLeaderAndEmpCode(WebDriver driver){
		this.driver=driver;
		
	}
	
	public void UnitLeaderAndEmpCode(String salesUniCod,String salesUniName, String CommisionRate,String unitLeadName,String unitLeaderColName){
		this.insertOtherInfo(salesUniCod, salesUniName, CommisionRate);
		this.insertUnitLeadName(unitLeadName);
		this.verifyUnitLead(unitLeaderColName);
		this.selectUnitLeader();
		this.insertUnitLead();
		this.clkOnEmpCodeIcon();
		this.enterEmpCode(unitLeadName);
		this.selectEmployeeCode();
		this.verifyEmpCode();
		//
	}
	public void insertOtherInfo(String salesUniCod,String salesUniName, String CommisionRate){
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(salesUnitCode));
		driver.findElement(salesUnitCode).click();
		driver.findElement(salesUnitCode).sendKeys(salesUniCod);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(salesUnitName));
		driver.findElement(salesUnitName).click();
		driver.findElement(salesUnitName).sendKeys(salesUniName);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(comRate));
		driver.findElement(comRate).clear();
		driver.findElement(comRate).sendKeys(CommisionRate);
		
	}
	public void insertUnitLeadName(String unitLeadName){
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(unitLeader));
		driver.findElement(unitLeader).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(unitLeaderName));
		WebElement ClickIt = driver.findElement(unitLeaderName);

		ClickIt.sendKeys(unitLeadName);
		ClickIt.sendKeys(Keys.ENTER);

	}

	public void selectUnitLeader(){
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(10, TimeUnit.SECONDS);

		//Select searched Unit Leader
		wait.until(ExpectedConditions.elementToBeClickable(unitLeaderColumn));
		WebElement columnOne = driver.findElement(unitLeaderColumn);
		action.moveToElement(columnOne).doubleClick().build().perform();
	}
	public void verifyUnitLead(String unitLeaderColName){
		SoftAssert soAssertion = new SoftAssert();
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(30, TimeUnit.SECONDS);

		wait.until(ExpectedConditions.presenceOfElementLocated(unitLeaderColumnName));
		String columnText = driver.findElement(unitLeaderColumnName).getAttribute("value");
		//000003 [P.Perera]
		soAssertion.assertEquals(unitLeaderColName,columnText);
		soAssertion.assertAll();
	}
	public void insertUnitLead(){
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(10, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.presenceOfElementLocated(unitLeaderColumn));
		
		WebElement clickIt = driver.findElement(unitLeaderColumn);	
		Actions action = new Actions(driver);
		action.doubleClick(clickIt);
		action.build().perform();
		
	}
	
	public void clkOnEmpCodeIcon(){
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.presenceOfElementLocated(empCodeIcon));
		driver.findElement(empCodeIcon).click();
		
	}
	
	public void enterEmpCode(String unitLeadName){
		
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.presenceOfElementLocated(empName));
		WebElement clickIt = driver.findElement(empName);
		Actions action = new Actions(driver);
		action.click(clickIt).build().perform();
		clickIt.clear();
		action.sendKeys(unitLeadName).build().perform();
		action.sendKeys(Keys.ENTER).build().perform();
	}
	 public void selectEmployeeCode(){

		 try {
			 Thread.sleep(5000);
		 } catch (InterruptedException e) {
			 e.printStackTrace();
		 }
		 Actions action = new Actions(driver);
		 WebDriverWait wait = new WebDriverWait(driver, 40);
		 wait.pollingEvery(30, TimeUnit.SECONDS);

		 wait.until(ExpectedConditions.elementToBeClickable(empColumn));
		 WebElement colOne = driver.findElement(empColumn);

		 action.moveToElement(colOne).doubleClick().build().perform();
		 if(colOne.isDisplayed()){
			 action.moveToElement(colOne).doubleClick().build().perform();
			 System.out.println("If condition executed");
		 }
	 }
	public void verifyEmpCode(){////////////////////////////////////////////// 			Find 
		
	/*	Dimension columnSize = driver.findElement(empColumn).getSize();
	if(columnSize == null ){
		Reporter.log("Unit leader and EMployee code is not same");
	}else{
		Reporter.log("<font color='red'>Same employee visible</font>");
	}*/
	}
}
