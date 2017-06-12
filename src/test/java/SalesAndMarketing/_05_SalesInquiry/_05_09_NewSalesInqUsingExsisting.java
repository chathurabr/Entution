package SalesAndMarketing._05_SalesInquiry;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class _05_09_NewSalesInqUsingExsisting {
	WebDriver driver;
	
	By srchTxtBx = By.id("txtg1037");
	//*[@id="g1037-t"]/table/tbody/tr/td[4]/a
	By colOne = By.xpath("//*[@id='g1037-t']/table/tbody/tr/td[4]/a");
	//Assertion
	By leadName = By.id("txtAgainst");
	By InqueryAbout = By.id("txtOppName");
	By category = By.id("cboxCategory");
	By InqueryOrigin = By.id("cboxOrigin");
	By BudgetCost = By.id("txtAmount");
	By description = By.id("txtDesc");
	By ResponsibleEmployee = By.id("txtAsEmp");
	By NotificationEmailTick = By.id("chkEmail");
	
	public _05_09_NewSalesInqUsingExsisting(WebDriver driver){
		this.driver=driver;
		}
	public void NewSalesInqUsingExsisting(String searchText){
		this.searchForSalesInq(searchText);
		this.clickOnTheColumnOne();
		this.verifyData();
	}
	
	public void searchForSalesInq(String searchText){
		Actions action = new Actions(driver);
		
        WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(2, TimeUnit.SECONDS);
		//Send text into the search textbox
		wait.until(ExpectedConditions.elementToBeClickable(srchTxtBx));
		WebElement cliknSend = driver.findElement(srchTxtBx);
		
		String str1 = cliknSend.getText();
		String str2 = cliknSend.getAttribute("value");
		System.out.println(",;,;,;,;;,;,;,;,;,;,;,;,;,;,,;,;,;,;Get Text,;,;,;,;,;,;,;,;,;,;,:<:<:<:<<:<:<:<"+str1);
		System.out.println(",;,;,;,;;,;,;,;,;,;,;,;,;,;,,;,;,;,Get Attribute;,;,;,;,;,;,;,;,;,;,;,:<:<:<:<:<::<:<:<"+str2);
		action.moveToElement(cliknSend).click().build().perform();
		action.moveToElement(cliknSend).sendKeys(searchText).sendKeys(Keys.ENTER).build().perform();
		
	}
	
	public void clickOnTheColumnOne(){
		//Actions action =  new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(2, TimeUnit.SECONDS);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		wait.until(ExpectedConditions.elementToBeClickable(colOne));
		driver.findElement(colOne).click();
		/*WebElement ele = driver.findElement(colOne);
		action.moveToElement(ele).click().build().perform();*/

	}
	
	public void verifyData(){

		SoftAssert soAssert = new SoftAssert();
		
        WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(2, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(leadName));
		soAssert.assertEquals("adasda", driver.findElement(leadName).getAttribute("value"));
		
		wait.until(ExpectedConditions.presenceOfElementLocated(InqueryAbout));
		soAssert.assertEquals("Inquery About - An Issue", driver.findElement(InqueryAbout).getAttribute("value"));
		
		wait.until(ExpectedConditions.presenceOfElementLocated(category));
		soAssert.assertEquals("4", driver.findElement(category).getAttribute("value"));
		
		wait.until(ExpectedConditions.presenceOfElementLocated(InqueryOrigin));
		soAssert.assertEquals("3", driver.findElement(InqueryOrigin).getAttribute("value"));
		
		wait.until(ExpectedConditions.presenceOfElementLocated(BudgetCost));
		soAssert.assertEquals("50,000.00", driver.findElement(BudgetCost).getAttribute("value"));
		
		wait.until(ExpectedConditions.presenceOfElementLocated(description));
		soAssert.assertEquals("Inquery description comes here", driver.findElement(description).getAttribute("value"));
		
		wait.until(ExpectedConditions.presenceOfElementLocated(ResponsibleEmployee));
		soAssert.assertEquals("001/30/001 [R Silva]", driver.findElement(ResponsibleEmployee).getAttribute("value"));
		
		wait.until(ExpectedConditions.presenceOfElementLocated(NotificationEmailTick));
		soAssert.assertEquals("on", driver.findElement(NotificationEmailTick).getAttribute("value"));
		
		
		System.out.println("--------------------------Lead aname:-"+driver.findElement(leadName).getAttribute("value"));
		System.out.println("--------------------------inquiry about:-"+driver.findElement(InqueryAbout).getAttribute("value"));
		System.out.println("--------------------------category:-"+driver.findElement(category).getAttribute("value"));
		System.out.println("--------------------------Inquery Origin:-"+driver.findElement(InqueryOrigin).getAttribute("value"));
		System.out.println("--------------------------Budget Cost:-"+driver.findElement(BudgetCost).getAttribute("value"));
		System.out.println("--------------------------description:-"+driver.findElement(description).getAttribute("value"));
		System.out.println("--------------------------Responsible Employee:-"+driver.findElement(ResponsibleEmployee).getAttribute("value"));
		System.out.println("--------------------------Notification Email Tick:-"+driver.findElement(NotificationEmailTick).getAttribute("value"));
			Reporter.log("Existing data remained as same");
		soAssert.assertAll();
	}
}
