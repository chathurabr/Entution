package SalesAndMarketing._05_SalesInquiry;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class _05_03_TagDetails {
	WebDriver driver;
	By tagDropDownIcon = By.xpath("//*[@id='ActBtn']/span[2]/span");
	By tagDropDwnItemPrdct = By.xpath("//*[@id='divGeneral']/div[3]/div[1]/div/a[1]");
	By tagDropDwnItemCities = By.xpath("//*[@id='divGeneral']/div[3]/div[1]/div/a[2]");
	//Cities
	By searchTxtBx = By.id("txtg1117");
	By colOne = By.xpath("//*[@id='g1117-t']/table/tbody/tr[1]");
	//Cities Error msg
	By msgBox = By.xpath("/html/body/div[1]/div[5]/p");
	By msgBoxCloseBtn = By.xpath("/html/body/div[1]/div[5]/p/a/i");
	
	public _05_03_TagDetails(WebDriver driver){
		this.driver=driver;
	}
	
	public void TagDetails(String cityName){
		this.goToTagProduct();
		this.srchAndSelectCity(cityName);
		this.closeErrMsgBox();
		this.dblClickCity();
	}
	
	public void goToTagProduct(){
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Scroll down
		jse.executeScript("window.scrollBy(0,250)", "");
		
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(2, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.elementToBeClickable(tagDropDownIcon));
		WebElement clickIt = driver.findElement(tagDropDownIcon);
		action.moveToElement(clickIt).click().build().perform();
			Reporter.log(" clicked on tag dropdown");
		
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		wait.until(ExpectedConditions.elementToBeClickable(tagDropDwnItemCities));
		driver.findElement(tagDropDwnItemCities).click();
	
	}
	
	public void srchAndSelectCity(String cityName){
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		Actions action = new Actions(driver);
		SoftAssert soAssert = new SoftAssert();
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(2, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.elementToBeClickable(searchTxtBx));
		WebElement elementOne = driver.findElement(searchTxtBx);
		action.moveToElement(elementOne).sendKeys(cityName).build().perform();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		action.moveToElement(elementOne).sendKeys(Keys.ENTER).build().perform();
		
		soAssert.assertFalse(driver.findElement(msgBox).isDisplayed());
		
		if(driver.findElement(msgBox).isDisplayed()){	
			wait.until(ExpectedConditions.elementToBeClickable(msgBoxCloseBtn));
			WebElement closeBtn = driver.findElement(msgBoxCloseBtn);
			action.moveToElement(closeBtn).click().build().perform();
			}
		
		wait.until(ExpectedConditions.elementToBeClickable(colOne));
		WebElement dblClk = driver.findElement(colOne);
		action.moveToElement(dblClk).doubleClick().build().perform();
		
		//Scroll up
				jse.executeScript("window.scrollBy(250,0)", "");
		soAssert.assertAll();
		
	}
	
	public void closeErrMsgBox(){
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(2, TimeUnit.SECONDS);
		
		if(driver.findElement(msgBox).isDisplayed()){	
		wait.until(ExpectedConditions.elementToBeClickable(msgBoxCloseBtn));
		WebElement closeBtn = driver.findElement(msgBoxCloseBtn);
		action.moveToElement(closeBtn).click().build().perform();
		}
	}
	
	public void dblClickCity(){
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(2, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.elementToBeClickable(colOne));
		WebElement dblClk = driver.findElement(colOne);
		action.moveToElement(dblClk).doubleClick().build().perform();
	}
}
