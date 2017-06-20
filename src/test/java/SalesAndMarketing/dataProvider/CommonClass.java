package SalesAndMarketing.dataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


/***************************************************************************************
 * 										This class contains 
 *							Driver, Move Driver, Login, HomeScreen, MainMenu
 *							Sales & Mket Menu		
 *****************************************************************************************/
public class CommonClass {
	 public static WebDriver driver;

	@FindBy(xpath = "//*[@id='permissionBar']/a[text()='Draft']")
	private WebElement btnDraft;
	@FindBy(xpath = "//label[@id='lbldocstatus'][text()='(Draft)']")
	private WebElement lblSalesOrderStatusDraft;
	@FindBy(xpath = "//label[@id='lbldocstatus']")
	private WebElement lblSalesOrderStatus;

	 public static WebDriver driverInstance(){
		
		System.setProperty("webdriver.chrome.driver","C:/ChromeDriver/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		
		
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY,options); //  options.addArguments("--disable-save-password-bubble");
		
		
		driver = new ChromeDriver(capabilities);
		Reporter.log("Browser opened");
		driver.manage().window().maximize();
		Reporter.log("Browser Maximized");
		//Wait
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		driver.get("http://192.168.80.26/Web/guest/login.aspx?returnUrl=http://192.168.80.26/Web/guest/home/default.aspx");
		//wait
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
		return driver;
	}
	 
	 public static WebDriver moveDriver(int moveToWinNumber){
			
		 	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			ArrayList tabs = new ArrayList (driver.getWindowHandles());
	        driver.switchTo().window((String) tabs.get(moveToWinNumber));
			
			return driver;
		}
	 
	 public static WebDriver loginMeth(){
				
				WebDriverWait wait = new WebDriverWait(driver, 40);
				wait.pollingEvery(30, TimeUnit.SECONDS);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.id("txtUserName")));
				
				//Assert.assertEquals("UserName", driver.findElement(txtBoxUsername).getText());
				
				driver.findElement(By.id("txtUserName")).sendKeys("aaa@123.com");
				Reporter.log("Username Entered successfully");
				
				wait.until(ExpectedConditions.presenceOfElementLocated(By.id("txtPassword")));
				driver.findElement(By.id("txtPassword")).sendKeys("kQF5Es");
				Reporter.log("Password Entered Successfully");
				
				wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnLogin")));
				driver.findElement(By.id("btnLogin")).click();
				Reporter.log("Login button clicked");
		 
		 return driver;
	 }
	 
	 public static WebDriver homeScreen(){
		 WebDriverWait wait = new WebDriverWait(driver, 40);
		 wait.pollingEvery(5, TimeUnit.SECONDS);
		 
		 try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		 
		 wait.until(ExpectedConditions.elementToBeClickable(By.id("homelink")));
		 driver.findElement(By.id("homelink")).click();
		 return driver;
	 }
	 
	 public static WebDriver MainMenuNav(){

				WebDriverWait wait = new WebDriverWait(driver,40);
				wait.pollingEvery(30, TimeUnit.SECONDS);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[1]/div[1]/div[1]/span[1]/img")));
				
					
					WebElement ClickIt = driver.findElement(By.xpath("html/body/div[1]/div[1]/div[1]/span[1]/img"));
					Actions action = new Actions(driver);
					action.click(ClickIt);
					action.build().perform();
				
					
					//Reporter.log("Main Navigation Menu Available and clicked on the Main Navigation Menu ");
			
			return driver;
		}
	 
	 public static WebDriver salesAndMketMenuNav(){
		 SoftAssert soAssert = new SoftAssert();
		//JavascriptExecutor executor = (JavascriptExecutor)driver;
				WebDriverWait wait = new WebDriverWait(driver,40);
				wait.pollingEvery(30, TimeUnit.SECONDS);
				
				wait.until(ExpectedConditions.elementToBeClickable(By.tagName("li")));
				List<WebElement> li = driver.findElements(By.tagName("li"));
				//li.get(3).click();
				
				for(int i=0;i<li.size();i++){
					
					String lala = li.get(i).getText();
				//	System.out.print("-----------------------------------"+lala);
						if(lala.equals("SALES & MARKETING")){
							Actions action = new Actions(driver);
							action.moveToElement(li.get(i)).click().build().perform();
					}else{

					}
						
				}	
			
			return driver;
		}
	 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	 public static WebDriver draftBtnClick(){
		 Actions action = new Actions(driver);
		 WebDriverWait wait = new WebDriverWait(driver,40);
			wait.pollingEvery(30, TimeUnit.SECONDS);
			//Draft Button
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='permissionBar']/a[1]")));
			WebElement clickIt = driver.findElement(By.xpath("//*[@id='permissionBar']/a[1]"));
			action.moveToElement(clickIt).click().build().perform();
				Reporter.log("Draft button clicked successfully");
			
		 return driver;
	 }
	 
	 public static WebDriver releaseBtnClick(){
		 try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 Actions action = new Actions(driver);
		 WebDriverWait wait = new WebDriverWait(driver,40);
			wait.pollingEvery(30, TimeUnit.SECONDS);
			//Draft Button
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='permissionBar']/a[2]")));
			WebElement clickIt = driver.findElement(By.xpath("//*[@id='permissionBar']/a[2]"));
			action.moveToElement(clickIt).click().build().perform();
				Reporter.log("Release button clicked successfully");
		 return driver;
	 }
	 
	 public static WebDriver editBtnClick(){
		 
		 try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 Actions action = new Actions(driver);
		 WebDriverWait wait = new WebDriverWait(driver,40);
			wait.pollingEvery(30, TimeUnit.SECONDS);
			//Draft Button
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='permissionBar']/a[1]")));
			WebElement clickIt = driver.findElement(By.xpath("//*[@id='permissionBar']/a[1]"));
			action.moveToElement(clickIt).click().build().perform();
				Reporter.log("Edit button clicked successfully");
			
		 return driver;
	 }
	 public static WebDriver updateBtnClick(){
		 Actions action = new Actions(driver);
		 WebDriverWait wait = new WebDriverWait(driver,40);
			wait.pollingEvery(30, TimeUnit.SECONDS);
			//Draft Button
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='permissionBar']/a[1]")));
			WebElement clickIt = driver.findElement(By.xpath("//*[@id='permissionBar']/a[1]"));
			action.moveToElement(clickIt).click().build().perform();
			Reporter.log("Update button clicked successfully");
		 return driver;
	 }
	 
	 public static WebDriver draftAndNewBtnClick(){
		 
		 try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 Actions action = new Actions(driver);
		 WebDriverWait wait = new WebDriverWait(driver,40);
			wait.pollingEvery(30, TimeUnit.SECONDS);
			//Draft Button
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='permissionBar']/a[2]")));
			WebElement clickIt = driver.findElement(By.xpath("//*[@id='permissionBar']/a[2]"));
			action.moveToElement(clickIt).click().build().perform();
				Reporter.log("Draft and New button clicked successfully");
		 return driver;
	 }
	 
 public static WebDriver copyFromBtnClick(){
		 
		 try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 Actions action = new Actions(driver);
		 WebDriverWait wait = new WebDriverWait(driver,40);
			wait.pollingEvery(30, TimeUnit.SECONDS);
			//Draft Button
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='permissionBar']/a[3]")));
			WebElement clickIt = driver.findElement(By.xpath("//*[@id='permissionBar']/a[3]"));
			action.moveToElement(clickIt).click().build().perform();
			
			Reporter.log("Copy From button clicked successfully");
			
		 return driver;
 }
 
 public static WebDriver duplicateBtnClick(){ 
	 try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 Actions action = new Actions(driver);
	 WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		//Draft Button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='permissionBar']/a[2]")));
		WebElement clickIt = driver.findElement(By.xpath("//*[@id='permissionBar']/a[2]"));
		action.moveToElement(clickIt).click().build().perform();
			Reporter.log("Duplicate button clicked successfully");
		
	 return driver;
}
	 
	 
		public static WebDriver chkLblStatusReleased(){
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			SoftAssert soAssert = new SoftAssert();
			WebDriverWait wait = new WebDriverWait(driver, 40);
			wait.pollingEvery(30, TimeUnit.SECONDS);
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("lbldocstatus")));
			soAssert.assertEquals("(Released)", driver.findElement(By.id("lbldocstatus")).getText());
				Reporter.log("Header changed as Released");
			return driver;
			
		}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		public static WebDriver HistoryGoto(){
			Actions action =new Actions(driver);
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.pollingEvery(50, TimeUnit.SECONDS);
			//Action DropDown 
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sys-actions']/span[2]/span")));
				WebElement clkOne = driver.findElement(By.xpath("//*[@id='sys-actions']/span[2]/span"));
				action.moveToElement(clkOne).click().build().perform();
			
			//History
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='permissionBar']/div/div/a[1]")));
				WebElement clkTwo = driver.findElement(By.xpath("//*[@id='permissionBar']/div/div/a[1]"));
				action.moveToElement(clkTwo).click().build().perform();
					Reporter.log("History option available");
			//activities
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='permissionBar']/div/div/a[2]")));
			return driver;
		}
		
		public static WebDriver convertToAccount(){
			WebDriverWait wait = new WebDriverWait(driver, 40);
			wait.pollingEvery(30, TimeUnit.SECONDS);
																		
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sys-actions']/span[2]/span")));
			driver.findElement(By.xpath("//*[@id='sys-actions']/span[2]/span")).click();
			
			wait.until(ExpectedConditions.elementToBeClickable(By.className("spltbtnitm")));
			driver.findElement(By.className("spltbtnitm")).click();
			Reporter.log("Convert to account option available");
			
			
				
			return driver;
		}
		
		
		//----------------------------------------------  Level 2 --------------------------------
		
		public static WebDriver searchTxtBoxSendText(){
			 
		 	WebDriverWait wait = new WebDriverWait(driver, 40);
			wait.pollingEvery(30, TimeUnit.SECONDS);
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='txtg1011']")));
			//driver.findElement(By.xpath("//*[@id='txtg1011']")).click();
			driver.findElement(By.id("txtg1011")).sendKeys("Fernando");
			
		 return driver;
	 }
		
		 public static WebDriver searchBtnClk(){
			 Actions action = new Actions(driver);
			 
			 	WebDriverWait wait = new WebDriverWait(driver, 40);
				wait.pollingEvery(30, TimeUnit.SECONDS);
				
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='g1011']/div[1]/span[2]")));
				WebElement clickEle = driver.findElement(By.xpath("//*[@id='g1011']/div[1]/span[2]"));
				action.moveToElement(clickEle).click().build().perform();
				
			 return driver;
		 }
		 
		 public static WebDriver firstColDblClk(){
			 
			 Actions action = new Actions(driver);
			 
			 	WebDriverWait wait = new WebDriverWait(driver, 40);
				wait.pollingEvery(30, TimeUnit.SECONDS);
				
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='g1011-t']/table/tbody/tr[1]")));
				WebElement clickEle = driver.findElement(By.xpath("//*[@id='g1011-t']/table/tbody/tr[1]"));
				action.moveToElement(clickEle).doubleClick().build().perform();
			 
			 return driver;
		 }


		 public static WebDriver HomePgeTiles_TaskEvent(){
			 WebDriverWait wait = new WebDriverWait(driver, 40);
			 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[@class='tiles-header'][text()='Task/Event']")));
			 driver.findElement(By.xpath("//p[@class='tiles-header'][text()='Task/Event']")).click();
			 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='col-sm-12']/h2[text()='Task Schedule']")));
			 Assert.assertEquals(driver.findElement(By.xpath("//div[@class='col-sm-12']/h2[text()='Task Schedule']")).getText(),"Task Schedule");
			 return driver;

		 }


	public static void sleepTime(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/*Draft and verify order status*/
	public static String draftAndCheckStatus(){
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id='permissionBar']/a[text()='Draft']"))));
		driver.findElement(By.xpath("//*[@id='permissionBar']/a[text()='Draft']")).click(); // click on draft button
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//label[@id='lbldocstatus'][text()='(Draft)']"))));
		return driver.findElement(By.xpath("//label[@id='lbldocstatus']")).getText();  // return for verify dreaft order status


	}

	/*Release and verify sales status*/
	public static String releaseOkAndCheckStatus(){
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id='permissionBar']/a[text()='Release'] "))));
		driver.findElement(By.xpath("//*[@id='permissionBar']/a[text()='Release'] ")).click(); // click on draft button
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("/html/body/div[6]/div[3]/a"))));
		driver.findElement(By.xpath("/html/body/div[6]/div[3]/a")).click();  // click ok on information dialog box
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//label[@id='lbldocstatus'][text()='(Draft)']"))));
		return driver.findElement(By.xpath("//label[@id='lbldocstatus']")).getText(); // verify Relesed order status

	}
}
