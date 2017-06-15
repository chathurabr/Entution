package SalesAndMarketing._03_CollectionUnits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class _03_03_ColUniDraftAndNew {
	WebDriver driver;
	By draftAndNewBtn = By.xpath("//*[@id='permissionBar']/a[2]");
	//
	By statusLbl = By.id("lnkTeplateStatus");
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
	
	public void verifyColUnitExsistingData(){

		
		SoftAssert soAssert = new SoftAssert();
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(10, TimeUnit.SECONDS);

		wait.until(ExpectedConditions.presenceOfElementLocated(statusLbl));

		wait.until(ExpectedConditions.presenceOfElementLocated(colUnitCode));
		WebElement CUC = driver.findElement(colUnitCode);
		Assert.assertEquals(CUC.getText(),"");
	//	soAssert.assertEquals(driver.findElement(colUnitCode).getAttribute("value"),"");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(colUnitName));
		WebElement CUN = driver.findElement(colUnitCode);
		Assert.assertEquals(CUN.getAttribute("value"),"");
	//	soAssert.assertEquals(driver.findElement(colUnitName).getAttribute("value"),"");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(comRate));
		WebElement COMR = driver.findElement(colUnitCode);
		Assert.assertEquals(COMR.getAttribute("value"),"");
	//	soAssert.assertEquals(driver.findElement(comRate).getAttribute("value"),"0.00");
			Reporter.log(" Collection unit Code, Collection Unit Name and Commission rate entered");
			
		wait.until(ExpectedConditions.presenceOfElementLocated(empSharingRate));
		WebElement ESR = driver.findElement(colUnitCode);
		Assert.assertEquals(ESR.getAttribute("value"),"");
	//	soAssert.assertEquals(driver.findElement(empSharingRate).getAttribute("value"),"0.00");
			Reporter.log("Successfully clicked on search icon under Employee code and select created employee");
			Reporter.log("Sharing rate entered successfully");
		wait.until(ExpectedConditions.presenceOfElementLocated(empSelectedCode));
		WebElement ESC = driver.findElement(colUnitCode);
		Assert.assertEquals(ESC.getText(),"");
	//	soAssert.assertEquals("",driver.findElement(empSelectedCode).getText());
		
		soAssert.assertAll();
	}
	
	
}
