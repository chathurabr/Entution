package SalesAndMarketing._06_Campaigns;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.util.concurrent.TimeUnit;

public class _06_03_CreateNewCampaign {
	WebDriver driver;
	
	By campaignCode = By.id("txtCampaignCode");
	By campaignName = By.id("txtCampaignName");
	By campaignType = By.id("cboxType");
	//parent Campaign
	By parentCampaignTxtBx = By.xpath("txtParent");
	By parentCampaignSrchBtn = By.xpath("//*[@id='divGen']/div[1]/table/tbody/tr[4]/td[2]/div/span[1]/span");
	By parentCampaignSrchTxtBx = By.id("txtg1026");
	By parentCampaignColOne = By.xpath("//*[@id='g1026-t']/table/tbody/tr");
	//Date
	By startDate = By.id("txtStart");
	By endDate = By.id("txtEnd");
	
	By salesUnit = By.id("cboxSalesUnitPerson");
	By accountOwner = By.id("cboxAccountOwner");
	By expectedResponse = By.id("txtExpected");
	
	By expectedRevenueCurrency = By.id("cboxRevenue");
	By expectedRevenueTxt = By.id("txtRevenue");
	
	By budgetedCostCurrency = By.id("cboxBudget");
	By budgetedCostTxt = By.id("txtBudget");
	
	By actualCostCurrency = By.id("cboxActual");
	By actualCostTxt = By.id("txtActual");
	
	public _06_03_CreateNewCampaign(WebDriver driver){
		this.driver=driver;
	}
	public void CreateNewCampaign(String campaignCodeTxt2,String campaignNameTxt2,String ExpectedResponsePrecentage,String expectedRevenueValue,String budgetedCostValue,String actualCostValue,String CampaignNameTxt,String sDay,String sMonth,String sYear,String eDay,String eMonth,String eYear){
		this.campaignCodeEnter(campaignCodeTxt2);
		this.campaignNameEnter(campaignNameTxt2);
		this.EnterNewCampaignDetails(ExpectedResponsePrecentage, expectedRevenueValue,budgetedCostValue,actualCostValue);
		this.enterParentCampaign(CampaignNameTxt);
		this.selectStartDate(sDay, sMonth, sYear);
		this.selectEndDate(eDay, eMonth, eYear);
	}
	
	public void campaignCodeEnter(String campaignCodeTxt2){
		Actions action = new Actions(driver);
		
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		//Campaign Code
		wait.until(ExpectedConditions.elementToBeClickable(campaignCode));
			WebElement cmpCod = driver.findElement(campaignCode);
			action.moveToElement(cmpCod).click().build().perform();
			action.moveToElement(cmpCod).sendKeys(campaignCodeTxt2).build().perform();
			//action.moveToElement(cmpCod).sendKeys(Keys.ENTER).build().perform();
	}
	
	public void campaignNameEnter(String campaignNameTxt2){
		Actions action = new Actions(driver);
		
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(30, TimeUnit.SECONDS);

		//campaign Name
		wait.until(ExpectedConditions.elementToBeClickable(campaignName));	
			WebElement cmpName = driver.findElement(campaignName);
			action.moveToElement(cmpName).click().sendKeys(campaignNameTxt2).sendKeys(Keys.ENTER).build().perform();
	}
	public void EnterNewCampaignDetails(String ExpectedResponsePrecentage, String expectedRevenueValue, String budgetedCostValue, String actualCostValue){
		Actions action = new Actions(driver);
		
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
			
		//campaign Type
		wait.until(ExpectedConditions.elementToBeClickable(campaignType));	
			Select CampaignTypeDD = new Select(driver.findElement(campaignType));
			CampaignTypeDD.selectByVisibleText("Telemarketing");
		//Click on srch icon
		wait.until(ExpectedConditions.elementToBeClickable(parentCampaignSrchBtn));
			WebElement parentCampScrchBtn = driver.findElement(parentCampaignSrchBtn);
			action.moveToElement(parentCampScrchBtn).click().build().perform();
		//Sales unit
		wait.until(ExpectedConditions.elementToBeClickable(salesUnit));
			Select slsUni = new Select(driver.findElement(salesUnit));
			slsUni.selectByVisibleText("PhoneSales");
		//Expected response
		wait.until(ExpectedConditions.elementToBeClickable(expectedResponse));
			WebElement expRes = driver.findElement(expectedResponse);
			action.moveToElement(expRes).click().build().perform();
			expRes.clear();
			action.moveToElement(expRes).sendKeys(ExpectedResponsePrecentage).build().perform();
		//expected Revenue Currency
		wait.until(ExpectedConditions.elementToBeClickable(expectedRevenueCurrency));
			Select expRevCurr = new Select(driver.findElement(expectedRevenueCurrency));
			expRevCurr.selectByVisibleText("LKR");
			//expected Revenue Txt
			wait.until(ExpectedConditions.elementToBeClickable(expectedRevenueTxt));
				WebElement expRevTxt = driver.findElement(expectedRevenueTxt);
				action.moveToElement(expRevTxt).click().build().perform();
				expRevTxt.clear();
				action.moveToElement(expRevTxt).sendKeys(expectedRevenueValue).build().perform();
		//budgetedCostCurrency
		wait.until(ExpectedConditions.elementToBeClickable(budgetedCostCurrency));
			Select budCostCurr = new Select(driver.findElement(budgetedCostCurrency));
			budCostCurr.selectByVisibleText("LKR");
			//budgeted Cost Txt
			wait.until(ExpectedConditions.elementToBeClickable(budgetedCostTxt));
			WebElement budCostTxt = driver.findElement(budgetedCostTxt);
			action.moveToElement(budCostTxt).click().build().perform();
			budCostTxt.clear();
			action.moveToElement(budCostTxt).sendKeys(budgetedCostValue).build().perform();
		//actualCostCurrency
		wait.until(ExpectedConditions.elementToBeClickable(actualCostCurrency));
			Select actCostCurr = new Select(driver.findElement(actualCostCurrency));
			actCostCurr.selectByVisibleText("LKR");
			//actualCostTxt
			wait.until(ExpectedConditions.elementToBeClickable(actualCostTxt));
				WebElement actCostTxt = driver.findElement(actualCostTxt);
				action.moveToElement(actCostTxt).click().build().perform();
				actCostTxt.clear();
				action.moveToElement(actCostTxt).sendKeys(actualCostValue).build().perform();
				
		Reporter.log("User filled data into relevant fields");
	}
	
	public void enterParentCampaign(String CampaignNameTxt){
	
		Actions action = new Actions(driver);
		
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
	
		//Enter searchKeyword
		wait.until(ExpectedConditions.elementToBeClickable(parentCampaignSrchTxtBx));
				WebElement CampScrchTxtBx = driver.findElement(parentCampaignSrchTxtBx);
				CampScrchTxtBx.click();
				CampScrchTxtBx.sendKeys(CampaignNameTxt);
				action.moveToElement(CampScrchTxtBx).sendKeys(Keys.ENTER).build().perform();
				
		//Click on the 1st column
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		wait.until(ExpectedConditions.elementToBeClickable(parentCampaignColOne));
			WebElement CampColOne = driver.findElement(parentCampaignColOne);
			action.moveToElement(CampColOne).doubleClick().build().perform();
	}
	
	public void selectStartDate(String sDay,String sMonth,String sYear){
		Actions action = new Actions(driver);
		
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.elementToBeClickable(startDate));
		WebElement strDat = driver.findElement(startDate);
		action.moveToElement(strDat).click().build().perform();
		action.moveToElement(strDat).sendKeys(sDay).sendKeys("/").sendKeys(sMonth).sendKeys("/").sendKeys(sYear).sendKeys(Keys.ENTER).build().perform();
	}
	
	public void selectEndDate(String eDay,String eMonth,String eYear){
		Actions action = new Actions(driver);
		
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.elementToBeClickable(endDate));
		WebElement endDat = driver.findElement(endDate);
		action.moveToElement(endDat).click().build().perform();
		action.moveToElement(endDat).sendKeys(eDay).sendKeys("/").sendKeys(eMonth).sendKeys("/").sendKeys(eYear).sendKeys(Keys.ENTER).build().perform();	
	}
}
