package SalesAndMarketing._05_SalesInquiry;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class _05_11_ChangeCopyFromDetails {
	WebDriver driver;
	//Change the lead
	By leadAcSearchIcon = By.xpath("//*[@id='divGeneral']/div[1]/div[1]/table/tbody/tr[1]/td[2]/div/span[2]/span");
	//popUp
	By leadAcSearchPop = By.id("txtg1011");
	By colOne = By.xpath("//*[@id='g1011-t']/table/tbody/tr[1]");
	//
	By InqueryAbout = By.id("txtOppName");
	By category = By.id("cboxCategory");
	By InqueryOrigin = By.id("cboxOrigin");
	
	By BudgetCurrency = By.id("cboxAmount");
	By BudgetCost = By.id("txtAmount");
	By description = By.id("txtDesc");
	By ResponsibleEmployee = By.id("txtAsEmp");
	By NotificationEmailTick = By.id("chkEmail");
	
	public _05_11_ChangeCopyFromDetails(WebDriver driver){
		this.driver=driver;
	}
	
	public void ChangeCopyFromDetails(String EditInqueryBout,String budgCurrency,String BudgetCostAmount,String newDescription,String responsibleEmployeeName){
		this.changeData();
		this.changeInquryAbout(EditInqueryBout);
		this.changeCategory();
		this.changeInqueryOrigin();
		this.BudgetCurr(budgCurrency);
		this.BudgetCost(BudgetCostAmount);
		this.changeDescription(newDescription);
		this.changeResponsibleEmployee(responsibleEmployeeName);
	}
	
	public void changeData(){
		Actions action = new Actions(driver);
		
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.pollingEvery(2, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.elementToBeClickable(leadAcSearchIcon));
		WebElement ele = driver.findElement(leadAcSearchIcon);
		action.moveToElement(ele).click().build().perform();
		
			wait.until(ExpectedConditions.elementToBeClickable(leadAcSearchPop));
			WebElement ele2 = driver.findElement(leadAcSearchPop);
			action.moveToElement(ele2).click().build().perform();
			action.moveToElement(ele2).sendKeys(Keys.ENTER).build().perform();	
		
				wait.until(ExpectedConditions.elementToBeClickable(colOne));
				WebElement ele3 = driver.findElement(colOne);
				action.moveToElement(ele3).doubleClick().build().perform();
		}		
		public void changeInquryAbout(String EditInqueryBout){	
		//InqueryAbout
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(2, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.elementToBeClickable(InqueryAbout));
		WebElement ele4 = driver.findElement(InqueryAbout);
		action.moveToElement(ele4).click().build().perform();
		action.moveToElement(ele4).sendKeys(EditInqueryBout).build().perform();
		}
		
		public void changeCategory(){
		//category
		
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(2, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.elementToBeClickable(category));
		Select categorydropdown = new Select(driver.findElement(category));
		categorydropdown.selectByVisibleText("NOKIA");
		}
		public void changeInqueryOrigin(){
		//InqueryOrigin
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(2, TimeUnit.SECONDS);
			
		wait.until(ExpectedConditions.elementToBeClickable(InqueryOrigin));
		Select categorydropdownInqueryOrigin = new Select(driver.findElement(InqueryOrigin));
		categorydropdownInqueryOrigin.selectByVisibleText("Internet Search");
		}
		
		public void BudgetCurr(String budgCurrency){//BudgetCurrency
			
			WebDriverWait wait = new WebDriverWait(driver,40);
			wait.pollingEvery(2, TimeUnit.SECONDS);
			
			wait.until(ExpectedConditions.elementToBeClickable(BudgetCurrency));
			Select budjCurr = new Select(driver.findElement(BudgetCurrency));
			budjCurr.selectByVisibleText(budgCurrency);
		}
		
		public void BudgetCost(String BudgetCostAmount){
		//BudgetCost
			Actions action = new Actions(driver);
			WebDriverWait wait = new WebDriverWait(driver,40);
			wait.pollingEvery(2, TimeUnit.SECONDS);
			
		wait.until(ExpectedConditions.elementToBeClickable(BudgetCost));
		WebElement ele5 = driver.findElement(BudgetCost);
		action.moveToElement(ele5).click().build().perform();
		action.moveToElement(ele5).sendKeys(BudgetCostAmount).build().perform();
		}
		
		public void changeDescription(String newDescription){
		//description
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(2, TimeUnit.SECONDS);
			
		wait.until(ExpectedConditions.elementToBeClickable(description));
		WebElement ele6 = driver.findElement(description);
		action.moveToElement(ele6).click().build().perform();
		action.moveToElement(ele6).sendKeys(newDescription).build().perform();
		}
		public void changeResponsibleEmployee(String responsibleEmployeeName){
		//ResponsibleEmployee
			Actions action = new Actions(driver);
			SoftAssert soAssert = new SoftAssert();
			
			WebDriverWait wait = new WebDriverWait(driver,40);
			wait.pollingEvery(2, TimeUnit.SECONDS);
			
		wait.until(ExpectedConditions.elementToBeClickable(ResponsibleEmployee));
		WebElement ele7 = driver.findElement(ResponsibleEmployee);
		action.moveToElement(ele7).click().build().perform();
		action.moveToElement(ele7).sendKeys(responsibleEmployeeName).build().perform();
		//Check the tick
		soAssert.assertEquals("on", driver.findElement(NotificationEmailTick).getAttribute("value"));
		soAssert.assertAll();
		}
	}

