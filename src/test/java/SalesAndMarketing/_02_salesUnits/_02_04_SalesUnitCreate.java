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

public class _02_04_SalesUnitCreate {
	WebDriver driver;
	By empNameTxtField = By.id("txtg1002");
	By empColumn = By.xpath("//*[@id='g1002-t']/table/tbody/tr[1]");
	By sharingRate = By.xpath("//*[@id='tblEmpdata']/tbody/tr/td[8]/input");
	By draftAndNewBtn = By.xpath("//*[@id='permissionBar']/a[2]");
	By newLabel = By.id("lblTemplateFormHeader");
	
	public _02_04_SalesUnitCreate(WebDriver driver){
		this.driver=driver;
	}
	public void NewSalesUnitCrate(String sharingRateVal){
		this.enterSharingRate(sharingRateVal);
	}
	
	public void enterSharingRate(String sharingRateVal){
		SoftAssert soAssert = new SoftAssert();
		
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(30, TimeUnit.SECONDS);

		
		wait.until(ExpectedConditions.elementToBeClickable(sharingRate));
		driver.findElement(sharingRate).clear();
		driver.findElement(sharingRate).sendKeys(sharingRateVal);

		/*wait.until(ExpectedConditions.elementToBeClickable(newLabel));
		soAssert.assertEquals("New", driver.findElement(newLabel).getText());
		soAssert.assertAll();*/
	}
}
