package SalesAndMarketing._05_SalesInquiry;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class _05_04_Campaing {
	WebDriver driver;
	By campaingSearchIcon = By.xpath("//*[@id='divGeneral']/div[1]/div[2]/table/tbody/tr[5]/td[2]/div/span[1]/span");
	By campaingPopUpWindow  = By.id("d1026");
	//New campaing info
	By campCode = By.id("txtCampaignCode");
	By campName = By.id("txtCampaignName");
	By campTypeDropD = By.id("cboxType");
	//Search popUp
	By searchTxtField = By.id("txtg1026");
	By columnOne = By.xpath("//*[@id='g1026-t']/table/tbody/tr[1]");
	
	public String campaingCodeCommon;
	
	public _05_04_Campaing(WebDriver driver){
		this.driver=driver;
	}
	
	public void Campaing(String campaingCode,String campaingName,String dropDownItem, String campaingNameEdited, String searchCmapCode){
		campaingCodeCommon = campaingCode;
		this.clkSearchIcon();
		this.campaingInfo(campaingCodeCommon,campaingName,dropDownItem);
		this.editCampInfo(campaingNameEdited);
		this.searchCreatedCampaing(campaingCodeCommon); 
	}
	
	public void clkSearchIcon(){
		Actions action = new Actions(driver);
		
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(2, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.elementToBeClickable(campaingSearchIcon));
		WebElement clickIt = driver.findElement(campaingSearchIcon);
		action.moveToElement(clickIt).click().build().perform();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(campaingPopUpWindow));
			Reporter.log("campaing popup window displayed");
		
	}
	
	public void campaingInfo(String campaingCodePara, String campaingName, String dropDownItem){
		Actions action = new Actions(driver);
		Select dropdwn = new Select(driver.findElement(campTypeDropD));
		
        WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(2, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.elementToBeClickable(campCode));
		WebElement campCodeEle = driver.findElement(campCode);
		action.moveToElement(campCodeEle).click().build().perform();
		campCodeEle.sendKeys(campaingCodePara);
		
		wait.until(ExpectedConditions.elementToBeClickable(campName));
		WebElement campNameEle = driver.findElement(campName);
		action.moveToElement(campNameEle).click().build().perform();
		campNameEle.sendKeys(campaingName);
		
		wait.until(ExpectedConditions.elementToBeClickable(campTypeDropD));
		dropdwn.selectByVisibleText(dropDownItem);
		
			Reporter.log("Mandatory fields filled");
		
	}
	
	public void editCampInfo(String campaingNameEdited ){
		Actions action = new Actions(driver);
		
        WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(2, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.elementToBeClickable(campName));
		WebElement campNameEle = driver.findElement(campName);
		action.moveToElement(campNameEle).click().build().perform();
		campNameEle.clear();
		campNameEle.sendKeys(campaingNameEdited);
			Reporter.log("Campaing details edited succesfully");
			
			
	}
	
	public void searchCreatedCampaing(String campaingCodeCommonPara){
		
		Actions action = new Actions(driver);
		SoftAssert soAssert = new SoftAssert();
		
        WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(2, TimeUnit.SECONDS);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Search created campaing by entering campaing code
		wait.until(ExpectedConditions.elementToBeClickable(searchTxtField));
		WebElement srchTxtFld = driver.findElement(searchTxtField);
		action.moveToElement(srchTxtFld).sendKeys(Keys.ENTER).build().perform();
		action.moveToElement(srchTxtFld).click().build().perform();
		
		action.moveToElement(srchTxtFld).sendKeys(campaingCodeCommonPara).sendKeys(Keys.ENTER).build().perform();
		//Select 1st column
		wait.until(ExpectedConditions.elementToBeClickable(columnOne));
		WebElement colOne = driver.findElement(columnOne);
		action.moveToElement(colOne).doubleClick().build().perform();
			Reporter.log("Campaign details appeared");
		//Verify selected campaing visible on the textfield
		soAssert.assertEquals(driver.findElement(By.id("txtCamp")).getAttribute("value"), campaingCodeCommonPara);
		soAssert.assertAll();
		
	}
}
