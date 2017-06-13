package SalesAndMarketing._03_CollectionUnits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class _03_02_CreateNewCollectionUnit {
	WebDriver driver;
	By colUnitCode = By.id("txtCUCode");
	By colUnitName = By.id("txtCUName");
	By comRate = By.id("txtComRate");
	//
	By empSearchIcon = By.xpath("//*[@id='tblEmpdata']/tbody/tr/td[4]/span");
	By empName = By.xpath("//*[@id='txtg1002']");
	
	By empSearchBtn = By.xpath("//*[@id='g1002']/div[1]/span[2]");
	By empTblColumn = By.xpath("//*[@id='g1002-t']/table/tbody/tr[1]");
	By empSharingRate = By.xpath("//*[@id='tblEmpdata']/tbody/tr/td[7]/input");
	//
	By draftBtn = By.xpath("//*[@id='permissionBar']/a[1]");
	By releaseBtn = By.xpath("//*[@id='permissionBar']/a[2]");
	//
	By statusLbl = By.id("lbldocstatus");
	
	By satusActiveLbl = By.xpath("//*[@id='lnkTeplateStatus']");
	
	public _03_02_CreateNewCollectionUnit(WebDriver driver){
		this.driver=driver;
	} 
	
	public void CreateNewCollectionUnit(String collectionUnitCode,String collectionUnitName,String collectionUnitComRate,String employeeName,String employeeSharingRate){ //createNewColUnit,searchEmp
		this.createNewColUnit(collectionUnitCode, collectionUnitName, collectionUnitComRate);
		this.searchEmp(employeeName, employeeSharingRate);
		//this.draftReleaseColUnit();
		this.verifyHeader();
	}
	
	public void createNewColUnit(String collectionUnitCode, String collectionUnitName, String collectionUnitComRate){
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.elementToBeClickable(colUnitCode));
		driver.findElement(colUnitCode).sendKeys(collectionUnitCode);
			Reporter.log("Collection Unit Code entered");
		
		wait.until(ExpectedConditions.elementToBeClickable(colUnitName));
		driver.findElement(colUnitName).sendKeys(collectionUnitName);
			Reporter.log("Collection Unit Name entered");
		
		wait.until(ExpectedConditions.elementToBeClickable(comRate));
		driver.findElement(comRate).clear();
		driver.findElement(comRate).sendKeys(collectionUnitComRate);
			Reporter.log("Collection Unit Commision Rate entered");
	}
	
	public void searchEmp(String employeeName, String employeeSharingRate){
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.elementToBeClickable(empSearchIcon));
		WebElement clickIt = driver.findElement(empSearchIcon);
			action.moveToElement(clickIt).click().build().perform();
				Reporter.log("Successfully clicked on employee search icon");
		
		wait.until(ExpectedConditions.elementToBeClickable(empName));
		driver.findElement(empName).sendKeys(employeeName);
		
		wait.until(ExpectedConditions.elementToBeClickable(empSearchBtn));
		WebElement empSrchBtnClk = driver.findElement(empSearchBtn);
			action.moveToElement(empSrchBtnClk).click().build().perform();
		
		
		wait.until(ExpectedConditions.elementToBeClickable(empTblColumn));
		WebElement dblClick = driver.findElement(empTblColumn);
		action.moveToElement(dblClick).doubleClick().build().perform();
			Reporter.log("Successfully clicked on employee refresh button and select created employee");
		
		wait.until(ExpectedConditions.elementToBeClickable(empSharingRate));
		driver.findElement(empSharingRate).clear();
		driver.findElement(empSharingRate).sendKeys(employeeSharingRate);
			Reporter.log("Successfully entered employee sharing rate");
	}
	
	/*public void draftReleaseColUnit(){
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.elementToBeClickable(draftBtn));
		driver.findElement(draftBtn).click();
		Reporter.log("Collection unit drafted successfully");
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		wait.until(ExpectedConditions.elementToBeClickable(releaseBtn));
		driver.findElement(releaseBtn).click();
		Reporter.log("Successfully clicked on draft button and then released created collection unit");
	}*/
	
	public void verifyHeader(){
		SoftAssert soAssert = new SoftAssert();
		
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		
		/*wait.until(ExpectedConditions.elementToBeClickable(statusLbl));
		soAssert.assertEquals("(Released)", driver.findElement(statusLbl).getText());
		Reporter.log("Collection unit released successfully");*/
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		wait.until(ExpectedConditions.presenceOfElementLocated(satusActiveLbl));
		String activeLbl = driver.findElement(satusActiveLbl).getText();
		System.out.println("-----------------------------------"+activeLbl);
		//soAssert.assertEquals("ACTIVEc",activeLbl);
		Assert.assertEquals(activeLbl,"ACTIVE");
		//soAssert.assertAll();
			Reporter.log("Status changed as Active");
	}
}
