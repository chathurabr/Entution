package SalesAndMarketing._03_CollectionUnits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class _03_04_ColUnitCopyFrom {
	WebDriver driver;
	By copyFromBtn = By.xpath("//*[@id='permissionBar']/a[3]");
	//Collection Unit Search and dblclick
	By enterColUnitCodeTxtfld = By.xpath("//*[@id='txtg1029']");
	By colUnitSearchIcon = By.xpath("//*[@id='g1029']/div[1]/span[2]");
	By colUnitTblColumn	= By.xpath("//*[@id='g1029-t']/table/tbody/tr");
	//Collection unit code,name,comm rate, employee, com rate
	By colUnitCode = By.id("txtCUCode");
	By colUnitName = By.id("txtCUName");
	By comRate = By.id("txtComRate");
	//Employee details
	By empSharingRate = By.xpath("//*[@id='tblEmpdata']/tbody/tr/td[7]/input");
	By empSelectedCode = By.xpath("//*[@id='tblEmpdata']/tbody/tr/td[4]/input");
	By empSelectedName = By.xpath("//*[@id='tblEmpdata']/tbody/tr/td[6]/input");
	
	public _03_04_ColUnitCopyFrom(WebDriver driver){
		
		this.driver=driver;
		
	}
	
	
	
	public void ColUnitCopyFrom(String collectionUnitCode, String NewcollectionUnitCode){
		this.colunitCopyFromBtnfunc();
		this.selectColUnit(collectionUnitCode);
		this.verifyColUnit();
		this.enterColUnitCode(NewcollectionUnitCode);
		
	}
	
	public void colunitCopyFromBtnfunc(){
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.elementToBeClickable(copyFromBtn));
		driver.findElement(copyFromBtn).click();
			Reporter.log("Successfully clicked on copy from button and Collection unit window pop up");
	}
	public void selectColUnit(String collectionUnitCode){
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.elementToBeClickable(enterColUnitCodeTxtfld));
		driver.findElement(enterColUnitCodeTxtfld).sendKeys(collectionUnitCode);

		wait.until(ExpectedConditions.elementToBeClickable(colUnitSearchIcon));
		driver.findElement(colUnitSearchIcon).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(colUnitTblColumn));
		WebElement dblClick = driver.findElement(colUnitTblColumn);
		action.moveToElement(dblClick).doubleClick().build().perform();
			Reporter.log("Existing collection units appeared and created Collection unit selected");
			Reporter.log("selected collection unit appeared");
		
	}
	
	public void verifyColUnit(){
		SoftAssert soAssert = new SoftAssert();
		String printSme;
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.elementToBeClickable(colUnitCode));
		soAssert.assertEquals("",printSme = driver.findElement(colUnitCode).getAttribute("value"));
		System.out.println("++++++++++++++++++++++++++++++"+printSme);
		
		wait.until(ExpectedConditions.elementToBeClickable(colUnitName));
		soAssert.assertEquals(printSme = driver.findElement(colUnitName).getAttribute("value"),"Phones");
		System.out.println("++++++++++++++++++++++++++++++"+printSme);
		
		wait.until(ExpectedConditions.elementToBeClickable(comRate));
		soAssert.assertEquals(printSme = driver.findElement(comRate).getAttribute("value"),"50.00");
		System.out.println("++++++++++++++++++++++++++++++"+printSme);
		//Employee
		wait.until(ExpectedConditions.elementToBeClickable(empSharingRate));
		soAssert.assertEquals(printSme = driver.findElement(empSharingRate).getAttribute("value"),"50.00");
		System.out.println("++++++++++++++++++++++++++++++"+printSme);
		
		wait.until(ExpectedConditions.elementToBeClickable(empSelectedCode));
		soAssert.assertEquals(printSme = driver.findElement(empSelectedName).getAttribute("value"),"Perera");
		System.out.println("++++++++++++++++++++++++++++++"+printSme);
		
		wait.until(ExpectedConditions.elementToBeClickable(empSelectedName));
		soAssert.assertEquals(printSme = driver.findElement(empSelectedName).getAttribute("value"),"Perera");
		System.out.println("++++++++++++++++++++++++++++++"+printSme);
		
		soAssert.assertAll();
	}
	
	public void enterColUnitCode(String collectionUnitCode){
		//SoftAssert soAssert = new SoftAssert();
		Actions action = new Actions(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.elementToBeClickable(colUnitCode));
		WebElement colUnitCodetxtBxClick = driver.findElement(colUnitCode);
		action.moveToElement(colUnitCodetxtBxClick).click().build().perform();
		action.moveToElement(colUnitCodetxtBxClick).sendKeys(collectionUnitCode).build().perform();
		//soAssert.assertEquals(driver.findElement(colUnitCode).getText(),collectionUnitCode);
			Reporter.log("Collection Unit code entered successfully");
		//soAssert.assertAll();
	}
}
