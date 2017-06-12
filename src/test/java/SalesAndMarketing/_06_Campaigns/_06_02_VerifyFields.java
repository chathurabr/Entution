package SalesAndMarketing._06_Campaigns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class _06_02_VerifyFields {
	WebDriver driver;
	
	By campaignCode = By.id("txtCampaignCode");
	By campaignName = By.id("txtCampaignName");
	By campaignType = By.id("cboxType");
	//parent Campaign
	By parentCampaignSrchBtn = By.xpath("//*[@id='divGen']/div[1]/table/tbody/tr[4]/td[2]/div/span[1]/span");
	By parentCampaignTxtBx = By.xpath("txtParent");
	
	By startDate = By.id("txtStart");
	By endDate = By.id("txtEnd");
	By salesUnit = By.id("cboxSalesUnitPerson");
	By accountOwner = By.id("cboxAccountOwner");
	By expectedRevenue = By.id("cboxRevenue");
	By budgetedCost = By.id("cboxBudget");
	By actualCost = By.id("cboxActual");
	
	public _06_02_VerifyFields(WebDriver driver){
		this.driver=driver;
	}
	
	public void VerifyFields(){
		this.verifyAllFields();
	}
	
	public void verifyAllFields(){
		SoftAssert soAssert = new SoftAssert();
		Actions action = new Actions(driver);
		
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.elementToBeClickable(campaignCode));
		soAssert.assertTrue(driver.findElement(campaignCode).isDisplayed());
		
		wait.until(ExpectedConditions.elementToBeClickable(campaignName));
		soAssert.assertTrue(driver.findElement(campaignName).isDisplayed());
		
		wait.until(ExpectedConditions.elementToBeClickable(campaignType));
		soAssert.assertTrue(driver.findElement(campaignType).isDisplayed());
		
		wait.until(ExpectedConditions.elementToBeClickable(parentCampaignSrchBtn));
		soAssert.assertTrue(driver.findElement(parentCampaignSrchBtn).isDisplayed());
		
		wait.until(ExpectedConditions.elementToBeClickable(startDate));
		soAssert.assertTrue(driver.findElement(startDate).isDisplayed());
		
		wait.until(ExpectedConditions.elementToBeClickable(endDate));
		soAssert.assertTrue(driver.findElement(endDate).isDisplayed());
		
		wait.until(ExpectedConditions.elementToBeClickable(salesUnit));
		soAssert.assertTrue(driver.findElement(salesUnit).isDisplayed());
		
		wait.until(ExpectedConditions.elementToBeClickable(accountOwner));
		soAssert.assertTrue(driver.findElement(accountOwner).isDisplayed());
		
		wait.until(ExpectedConditions.elementToBeClickable(expectedRevenue));
		soAssert.assertTrue(driver.findElement(expectedRevenue).isDisplayed());
		
		wait.until(ExpectedConditions.elementToBeClickable(budgetedCost));
		soAssert.assertTrue(driver.findElement(budgetedCost).isDisplayed());
		
		wait.until(ExpectedConditions.elementToBeClickable(actualCost));
		soAssert.assertTrue(driver.findElement(actualCost).isDisplayed());
		
		soAssert.assertAll();
		 Reporter.log("All fields are available");

	}
}
