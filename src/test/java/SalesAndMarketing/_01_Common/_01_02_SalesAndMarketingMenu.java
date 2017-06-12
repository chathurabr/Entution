package SalesAndMarketing._01_Common;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class _01_02_SalesAndMarketingMenu {
	WebDriver driver;
	By itemMainNavMenu 		= By.xpath("html/body/div[1]/div[1]/div[1]/span[1]/img");
	By itemSalesAndMktMenu 	= By.xpath("/html/body/div[1]/div[3]/div/ul/li[4]");
	
	public _01_02_SalesAndMarketingMenu(WebDriver driver){
		this.driver=driver;
	}
	
	public void salesAndMktMenu(){
		this.mainMenuFunc();
		this.salesAndMketMenuFunc();
		this.chkItems();
	}
	
	public void mainMenuFunc(){
		
		boolean bool1 = false;
		 SoftAssert soAssertion = new SoftAssert();
		
			WebDriverWait wait = new WebDriverWait(driver,40);
			wait.pollingEvery(30, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.presenceOfElementLocated(itemMainNavMenu));
			
			if(driver.findElement(itemMainNavMenu).isDisplayed()){
				bool1=true;
				
				WebElement ClickIt = driver.findElement(itemMainNavMenu);
				Actions action = new Actions(driver);
				action.click(ClickIt);
				action.build().perform();
				
				Reporter.log("Main Navigation Menu Available and clicked on the Main Navigation Menu ");
			}
			else{
			soAssertion.assertTrue(bool1);
			Reporter.log("<fnt color='red'>Main Navigation menu not available</font>");
			soAssertion.assertAll();
			}
			
	}
			
			
		
		
	public void salesAndMketMenuFunc(){
		boolean bool1 = false;
		SoftAssert soAssertion = new SoftAssert();
			//try{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			WebDriverWait wait = new WebDriverWait(driver,40);
			wait.pollingEvery(30, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.presenceOfElementLocated(itemSalesAndMktMenu));
			
			if(driver.findElement(itemSalesAndMktMenu).isDisplayed()){
				bool1 = true;
				
				WebElement ClickIt = driver.findElement(itemSalesAndMktMenu);
				Actions action = new Actions(driver);
				action.click(ClickIt);
				action.build().perform();
				
				Reporter.log("Sales and Marketing navigation menu available and clicked on the Sales and Marketing Navigation Menu");
			}
			else{
				soAssertion.assertFalse(bool1);
				Reporter.log("<font color='red'>Sales And Marketing menu not available</font>");
				soAssertion.assertAll();
			}
		
	}
	public void chkItems(){
		//boolean bool1 = false;
		//SoftAssert soAssertion = new SoftAssert();
		//try{
			WebDriverWait wait = new WebDriverWait(driver,40);
			wait.pollingEvery(30, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div[3]/div/ul/ul")));
			
			Assert.assertEquals("Master", driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/ul/ul/li[1]/a")).getText());
			//soAssertion.assertEquals("Label cannot find","Masterrrrr",driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/ul/ul/li[1]/a")).getText());
			Reporter.log("ChkItems");
			
		/*	if(driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/ul/ul/li[1]/a")).isDisplayed()){
				bool1 =true;
				Reporter.log("MAster Master Master");
			}
			else{
				soAssertion.assertFalse(bool1);
				Reporter.log("<font color='red'>Assertion fired</font>");
				soAssertion.assertAll();	
			}*/
		/*}catch(Exception e){	
				Reporter.log("<font color='red'>Catch block</font>");	
		}finally{}*/
	}
}

