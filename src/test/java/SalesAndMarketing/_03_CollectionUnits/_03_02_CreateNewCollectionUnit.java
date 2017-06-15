package SalesAndMarketing._03_CollectionUnits;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class _03_02_CreateNewCollectionUnit {
	WebDriver driver;
	@FindBy(id="txtCUCode")
			private WebElement colUnitCode;
	@FindBy(id="txtCUName")
			private WebElement colUnitName;
	@FindBy(id="txtComRate")
			private WebElement comRate;
	//
	@FindBy(xpath ="//*[@id='tblEmpdata']/tbody/tr/td[4]/span")
			private WebElement empSearchIcon;
	@FindBy(xpath = "//*[@id='txtg1002']")
			private WebElement empName;
	@FindBy(xpath ="//*[@id='g1002']/div[1]/span[2]")
			private WebElement empSearchBtn;
	@FindBy(xpath = "//*[@id='g1002-t']/table/tbody/tr[1]")
			private WebElement empTblColumn;
	@FindBy(xpath="//*[@id='tblEmpdata']/tbody/tr/td[7]/input")
			private WebElement empSharingRate;
	//
	@FindBy (xpath = "//*[@id='lnkTeplateStatus']")
			private WebElement satusActiveLbl;

	
	public _03_02_CreateNewCollectionUnit(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	} 
	
	public void CreateNewCollectionUnit(String collectionUnitCode,String collectionUnitName,String collectionUnitComRate,String employeeName,String employeeSharingRate){ //createNewColUnit,searchEmp
		this.createNewColUnit(collectionUnitCode, collectionUnitName, collectionUnitComRate);
		this.searchEmp(employeeName, employeeSharingRate);
		this.verifyHeader();
	}
	
	public void createNewColUnit(String collectionUnitCode, String collectionUnitName, String collectionUnitComRate){
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.elementToBeClickable(colUnitCode));
		colUnitCode.sendKeys(collectionUnitCode);
			Reporter.log("Collection Unit Code entered");
		
		wait.until(ExpectedConditions.elementToBeClickable(colUnitName));
		colUnitName.sendKeys(collectionUnitName);
			Reporter.log("Collection Unit Name entered");
		
		wait.until(ExpectedConditions.elementToBeClickable(comRate));
		comRate.clear();
		comRate.sendKeys(collectionUnitComRate);
			Reporter.log("Collection Unit Commision Rate entered");
	}
	
	public void searchEmp(String employeeName, String employeeSharingRate){
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.elementToBeClickable(empSearchIcon));

			action.moveToElement(empSearchIcon).click().build().perform();
				Reporter.log("Successfully clicked on employee search icon");
		
		wait.until(ExpectedConditions.elementToBeClickable(empName));
		empName.sendKeys(employeeName);
		action.moveToElement(empSearchBtn).sendKeys(Keys.ENTER).build().perform();
		
		
		wait.until(ExpectedConditions.elementToBeClickable(empTblColumn));
		action.moveToElement(empTblColumn).doubleClick().build().perform();
			Reporter.log("Successfully clicked on employee refresh button and select created employee");
		
		wait.until(ExpectedConditions.elementToBeClickable(empSharingRate));
		empSharingRate.clear();
		empSharingRate.sendKeys(employeeSharingRate);
			Reporter.log("Successfully entered employee sharing rate");
	}
	
	public void verifyHeader(){
		SoftAssert soAssert = new SoftAssert();
		
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='lnkTeplateStatus']")));
		String activeLbl = satusActiveLbl.getText();
		System.out.println("-----------------------------------"+activeLbl);
		//soAssert.assertEquals("ACTIVEc",activeLbl);
		Assert.assertEquals(activeLbl,"ACTIVE");
		//soAssert.assertAll();
			Reporter.log("Status changed as Active");
	}
}
