package SalesAndMarketing._01_Common;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class _01_05_CreateVendorThroughAccLookup {
	WebDriver driver; 
	By itemMainNavMenu = By.xpath("/html/body/div[1]/div[1]/div[1]/span[1]/img");	
	By itemProcMenu = By.xpath("/html/body/div[1]/div[3]/div/ul/li[5]/a/span");
	By itemPurchaseOrder = By.xpath("//*[@id='header4']/li[3]/a[1]");
	By newPurchaseOrder = By.id("btnUpdate");
	By secondJourny = By.id("sp-processItem-17");
	By searchVendor = By.xpath("//*[@id='divPO']/div[1]/table/tbody/tr[1]/td[2]/div/span[2]");
	By newVendor = By.id("btnUpdate");
	//Vendor Information
	By vendorType = By.id("cboxVendorType");
	By selectVenType = By.xpath("//*[@id='cboxVendorType']/option[1]");
	By vendorName = By.id("txtVendorNameQck");
	By vendorGroup = By.id("cobxQuickVendorGroup");
	By vendorGroupLocal = By.xpath("//*[@id='cobxQuickVendorGroup']/option[2]");
	By vendorCode = By.id("txtVendorCodeQck");
	By btnUpdate = By.xpath("/html/body/div[10]/div[3]/a[1]");
	//Validate message after update
	By validatorPop = By.id("validator-QuickVendor");
	By msgPopup = By.id("validator-QuickVendor");
	//Search vendor
	By searchTxtBox = By.xpath("//*[@id='txtg1008']");
	//Add searched vendor
	By vendorTable = By.id("g1008-t");
	By firstColTable = By.xpath("//*[@id='g1008-t']/table/tbody/tr/td[6]");
	By txtBoxVendor = By.id("txtVendor");
	
	String stringValue="";
	
	public _01_05_CreateVendorThroughAccLookup(WebDriver driver){
		this.driver=driver;
	}
	
	public void CreateVendorThroughAccLookup(String venName,String venCode, String venSearchName){
		//this.openMenu();
		this.openPurchaseOrder();
		this.newPurchaseOrder();
		this.newVendor(venName, venCode);
		this.searchNSelectVedor(venSearchName);
		//
		this.choseSearchedVendor();
		this.compareVendor();
		
	}
	
	/*public void openMenu(){
		_01_02_SalesAndMarketingMenu openMainMenu = new _01_02_SalesAndMarketingMenu(driver);
		openMainMenu.salesAndMketMenuFunc();
	}*/
	
	public void safeJavaScriptClick(WebElement element){
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}
	
	public void openPurchaseOrder() {
		
			WebDriverWait wait = new WebDriverWait(driver,60);
			wait.pollingEvery(30, TimeUnit.SECONDS);
			
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	
			wait.until(ExpectedConditions.elementToBeClickable(itemMainNavMenu));
			WebElement manNavMenu = driver.findElement(itemMainNavMenu);
			
			safeJavaScriptClick(manNavMenu);
			/*Actions itemMinNavMenuClick = new Actions(driver);
			itemMinNavMenuClick.moveToElement(manNavMenu).click().perform();*/
			
			//driver.findElement(itemMainNavMenu).click();
			/////////////////////////////////////////////////////////////////////////////////
			
			
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[3]/div/ul/li[7]")));
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/ul/li[7]")).click();
			
			wait.until(ExpectedConditions.elementToBeClickable(itemProcMenu));
			driver.findElement(itemProcMenu).click();
				
			/*WebElement procMenuClick = driver.findElement(itemProcMenu);
			safeJavaScriptClick(procMenuClick);*/
			
			/*Actions procMenuClickAction = new Actions(driver);
			procMenuClickAction.moveToElement(procMenuClick).click().perform();*/
			
			/*JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript(document.id);*/
			
			////////////////////////////////////////////////////////////////////////////////////////////////////
			wait.until(ExpectedConditions.elementToBeClickable(itemPurchaseOrder));
			//driver.findElement(itemPurchaseOrder).click();
			WebElement purchaseOrderTab = driver.findElement(itemPurchaseOrder);
			Actions purchaseOrderTabClick = new Actions(driver);
			purchaseOrderTabClick.moveToElement(purchaseOrderTab).click().perform();
	
	}
	
	public void newPurchaseOrder(){
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.elementToBeClickable(newPurchaseOrder));
		driver.findElement(newPurchaseOrder).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(secondJourny));
		//driver.findElement(secondJourny).click();
		
		WebElement secondJournyButton = driver.findElement(secondJourny);
		Actions actionClickbtn = new Actions(driver);
		actionClickbtn.moveToElement(secondJournyButton).click().perform();
		
		
	}
	
	public void newVendor(String venName, String venCode){
		SoftAssert soAssertion = new SoftAssert();
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.elementToBeClickable(searchVendor));
		driver.findElement(searchVendor).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(newVendor));
		//driver.findElement(newVendor).click();
		//WebElement newVendorbtn = driver.findElement(newVendor);
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("document.getElementById('btnUpdate').click();");
		
		/*Actions newVendorBtnClick = new Actions(driver);
		newVendorBtnClick.moveToElement(newVendorbtn).click().perform();
		driver.findElement(newVendor).click();*/
		
		////Vendor Information
		wait.until(ExpectedConditions.elementToBeClickable(vendorType));
		driver.findElement(vendorType).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(selectVenType));
		driver.findElement(selectVenType).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(vendorName));
		driver.findElement(vendorName).click();
		driver.findElement(vendorName).sendKeys(venName);
		
		wait.until(ExpectedConditions.elementToBeClickable(vendorGroup));
		driver.findElement(vendorGroup).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(vendorGroupLocal));
		driver.findElement(vendorGroupLocal).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(vendorCode));
		driver.findElement(vendorCode).click();
		driver.findElement(vendorCode).sendKeys(venCode);
		
		wait.until(ExpectedConditions.elementToBeClickable(btnUpdate));
		driver.findElement(btnUpdate).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(validatorPop));
		soAssertion.assertEquals("Successfully Saved & Releaseddd.",((WebElement) driver.findElement(validatorPop)).getText());
		
		wait.until(ExpectedConditions.presenceOfElementLocated(msgPopup));
		driver.findElement(By.xpath("//*[@id='validator-QuickVendor']/a"));
		
		
	}
	
	public void searchNSelectVedor(String venSearchName){
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(searchTxtBox));
		//driver.findElement(searchTxtBox).click();
		driver.findElement(searchTxtBox).sendKeys(venSearchName);
		driver.findElement(searchTxtBox).sendKeys(Keys.ENTER);
		
	}
	
	public void choseSearchedVendor(){
		
		try {
			
			WebDriverWait wait = new WebDriverWait(driver,40);
			wait.pollingEvery(30, TimeUnit.SECONDS);
			
			Thread.sleep(10000);
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(vendorTable));
			
			wait.until(ExpectedConditions.elementToBeClickable(firstColTable));
			driver.findElement(firstColTable).click();
			WebElement firstCol = driver.findElement(firstColTable);
			Actions actionDblClkFirstCol = new Actions(driver);
			actionDblClkFirstCol.moveToElement(firstCol).doubleClick().perform();
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void compareVendor(){
		System.out.println("--------------------------------------------compareVendor executed");
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(txtBoxVendor));
		
		 SoftAssert soAssertion = new SoftAssert(); 
		 soAssertion.assertEquals(stringValue,driver.findElement(txtBoxVendor).getText());
		 System.out.println("--------------------------------------------compareVendor End");
		 
		 //driver.close();
	}
	
	
}
