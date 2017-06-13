package SalesAndMarketing._03_CollectionUnits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class _03_03_ColUniDraftAndNew {
	WebDriver driver;
	By draftAndNewBtn = By.xpath("//*[@id='permissionBar']/a[2]");
	//
	By colUnitCode = By.id("txtCUCode");
	By colUnitName = By.id("txtCUName");
	By comRate = By.id("txtComRate");
	//
	
	By empSharingRate = By.xpath("//*[@id='tblEmpdata']/tbody/tr/td[7]/input");
	By empSelectedCode = By.xpath("//*[@id='tblEmpdata']/tbody/tr/td[4]/input");
	
	public _03_03_ColUniDraftAndNew(WebDriver driver){
		this.driver=driver;
	}
	
	public void ColUniDraftAndNew(){

		this.verifyColUnitExsistingData();
	}
	
	/*public void draftAndNew(){
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.elementToBeClickable(draftAndNewBtn));
		driver.findElement(draftAndNewBtn).click();
		
	}*/
	
	public void verifyColUnitExsistingData(){
		
	/*	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		SoftAssert soAssert = new SoftAssert();
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.elementToBeClickable(colUnitCode));
		soAssert.assertEquals("",driver.findElement(colUnitCode).getAttribute("value"));
		
		wait.until(ExpectedConditions.elementToBeClickable(colUnitName));
		soAssert.assertEquals("",driver.findElement(colUnitName).getAttribute("value"));
		
		wait.until(ExpectedConditions.elementToBeClickable(comRate));
		soAssert.assertEquals("0.00",driver.findElement(comRate).getAttribute("value"));
			Reporter.log(" Collection unit Code, Collection Unit Name and Commission rate entered");
			
		wait.until(ExpectedConditions.elementToBeClickable(empSharingRate));
		soAssert.assertEquals("0.00",driver.findElement(empSharingRate).getAttribute("value"));
			Reporter.log("Successfully clicked on search icon under Employee code and select created employee");
			Reporter.log("Sharing rate entered successfully");
		wait.until(ExpectedConditions.elementToBeClickable(empSelectedCode));
		soAssert.assertEquals("",driver.findElement(empSelectedCode).getText());
		
		soAssert.assertAll();
	}
	
	
}
