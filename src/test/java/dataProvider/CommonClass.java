package dataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
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
 *							Module selection
 *							Page Name Verify
 *							docStatusLblChk
 *							goToPageLinkClick
 *****************************************************************************************/
public class CommonClass {
	 public static WebDriver driver;

	 public static String winHandleBefore;
	public static String winHandleHome;

	public static WebDriver driverInstance(){
		
		System.setProperty("webdriver.chrome.driver","C:/ChromeDriver/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		
		
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY,options); //  options.addArguments("--disable-save-password-bubble");
		
		
		driver = new ChromeDriver(capabilities);
		Reporter.log("Browser opened");
		System.out.println("Browser opened");
		driver.manage().window().maximize();
		Reporter.log("Browser Maximized");
		System.out.println("Browser Maximized");
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

	public static WebDriver shiftWindows(){
		for(String handle:driver.getWindowHandles()) {
			driver.switchTo().window(handle); //Shift to window
		}
			return driver;
		}
	 
	 public static WebDriver loginMeth(){
				
		 WebDriverWait wait = new WebDriverWait(driver, 40);
		 wait.pollingEvery(2, TimeUnit.SECONDS);
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("txtUserName")));
				
		 //Assert.assertEquals("UserName", driver.findElement(txtBoxUsername).getText());
				
		 driver.findElement(By.id("txtUserName")).sendKeys("aaa@123.com");
		 //driver.findElement(By.id("txtUserName")).sendKeys("ann@abs1.com");
		 Reporter.log("Username Entered successfully");
		 System.out.println("Username Entered successfully");
				
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("txtPassword")));
		 driver.findElement(By.id("txtPassword")).sendKeys("kQF5Es");
		 //driver.findElement(By.id("txtPassword")).sendKeys("ScbUL3");
		 Reporter.log("Password Entered Successfully");
		 System.out.println("Password Entered Successfully");
				
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnLogin")));
		 driver.findElement(By.id("btnLogin")).click();
		 Reporter.log("Login button clicked");
		 System.out.println("Login button clicked");
		 
		 return driver;
	 }
	 
	 public static WebDriver homeScreen(){
		 WebDriverWait wait = new WebDriverWait(driver, 40);
		 wait.pollingEvery(5, TimeUnit.SECONDS);
		 sleepTime(3000);
		 // Store the current window handle
		 winHandleBefore = driver.getWindowHandle();
		 WebElement homeLink = driver.findElement(By.id("homelink"));
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("homelink")));
		 Actions actions = new Actions(driver);
		 actions.keyDown(Keys.LEFT_CONTROL).click(homeLink).keyUp(Keys.LEFT_CONTROL).build().perform();
		 System.out.println("Home screen loaded");
		 // Switch to new window opened
		 for (String winHandle : driver.getWindowHandles()) {
			 driver.switchTo().window(winHandle);
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 winHandleHome = driver.getWindowHandle();
		 }
		 return driver;
	 }

	public static void backToOldBrowserTab(){
		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleHome);
		driver.close();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	}

	public static void backToSalesOrderTab(){
		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
		driver.navigate().refresh();
	}
	 
	 public static WebDriver MainMenuNav(){
		 Actions action = new Actions(driver);
		 WebDriverWait wait = new WebDriverWait(driver,40);
		 wait.pollingEvery(30, TimeUnit.SECONDS);
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[1]/div[1]/div[1]/span[1]/img")));

		 WebElement ClickIt = driver.findElement(By.xpath("html/body/div[1]/div[1]/div[1]/span[1]/img"));
		 action.click(ClickIt).build().perform();
		 Reporter.log("Clicked on the Main navigation button successfully");
		 System.out.println("Clicked on the Main navigation button successfully");

		 return driver;
		}
	 
		public static WebDriver moduleNavigation(String moduleName){
		SoftAssert soAssert = new SoftAssert();

		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(2, TimeUnit.SECONDS);

		wait.until(ExpectedConditions.elementToBeClickable(By.tagName("li")));
		List<WebElement> li = driver.findElements(By.tagName("li"));

		for(int i=0;i<li.size();i++){

			String lala = li.get(i).getText();
			//	System.out.print("-l-l-l-l-------------------------------"+lala);
			if(lala.equals(moduleName)){
				Actions action = new Actions(driver);
				action.moveToElement(li.get(i)).click().build().perform();
				Reporter.log("Successfully clicked and opened the "+ lala +" Module" );
				System.out.println("Successfully clicked and opened the "+ lala +" Module");
				//System.out.print("-----------------------------------"+lala);
			}else{

			}
		}
		return driver;
	}

	public static WebDriver pageNameVerifyChk(String pageName){
		Actions action = new Actions(driver);
		By pageNameLbl = By.id("spPageName");
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(3, TimeUnit.SECONDS);
		WebElement lbl = driver.findElement(pageNameLbl);

		Assert.assertEquals(pageName,lbl.getText());
		Reporter.log("Page name verified");
		System.out.println("Page name verified");
		return driver;
	}
	public static WebDriver pageHeaderWithLinkChk(String pageName){
		Actions action = new Actions(driver);
		By pageNameLbl = By.xpath("//*[@id='trnpageheader']/a");

		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(3, TimeUnit.SECONDS);
		WebElement lbl = driver.findElement(pageNameLbl);
		Assert.assertEquals(pageName,lbl.getText());
		Reporter.log("Page header verified");
		System.out.println("Page header verified");
		return driver;
	}

	public static WebDriver docStatusLblChk(String pageStatus){
		CommonClass.sleepTime(3000);
		Actions action = new Actions(driver);

		By DocumentStatus = By.id("lbldocstatus");

		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(3, TimeUnit.SECONDS);
		WebElement DocStatuslbl = driver.findElement(DocumentStatus);

			Assert.assertEquals(pageStatus,DocStatuslbl.getText());
		Reporter.log("Page Status verified");
		System.out.println("Page Status verified");

		return driver;
	}

	public static WebDriver lblTemplateFormHeader(String pageHeading){
		By HeadingLnk = By.id("lblTemplateFormHeader");

		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(2, TimeUnit.SECONDS);

		wait.until(ExpectedConditions.presenceOfElementLocated(HeadingLnk));
		WebElement HeadingLnkEle = driver.findElement(HeadingLnk);

		Assert.assertEquals(pageHeading,HeadingLnkEle.getText());
		Reporter.log("Header verified");
		System.out.println("Header verified");
		return driver;
	}

	public static WebDriver goToPageLinkClick(){
		Actions action = new Actions (driver);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(2, TimeUnit.SECONDS);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='dlgAutoGenNotifications']/a")));
		WebElement gotoL = driver.findElement(By.xpath("//div[@id='dlgAutoGenNotifications']/a"));
		action.moveToElement(gotoL).click().build().perform();

		return driver;
	}

	public static WebDriver taskEventTileClick(){
		CommonClass.sleepTime(3000);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(2, TimeUnit.SECONDS);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='tiles-header'][text()='Task/Event']")));
		WebElement taskTile = driver.findElement(By.xpath("//p[@class='tiles-header'][text()='Task/Event']"));
		taskTile.click();

		System.out.println("Task/Event Tile clicked");
		Reporter.log("Task/Event Tile clicked");
		System.out.println("Task/Event Tile clicked");
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
		 System.out.println("Draft button clicked successfully");
		return driver;
	 }
	 
	 public static WebDriver releaseBtnClick(){
		 CommonClass.sleepTime(5000);
		 Actions action = new Actions(driver);
		 WebDriverWait wait = new WebDriverWait(driver,40);
			wait.pollingEvery(30, TimeUnit.SECONDS);
			//Draft Button
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='permissionBar']/a[2]")));
			WebElement clickIt = driver.findElement(By.xpath("//*[@id='permissionBar']/a[2]"));
			action.moveToElement(clickIt).click().build().perform();
				Reporter.log("Release button clicked successfully");
		 		System.out.println("Release button clicked successfully");
		 return driver;
	 }
	 
	 public static WebDriver editBtnClick(){
		 CommonClass.sleepTime(5000);
		 Actions action = new Actions(driver);
		 WebDriverWait wait = new WebDriverWait(driver,40);
			wait.pollingEvery(30, TimeUnit.SECONDS);
			//Draft Button
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='permissionBar']/a[1]")));
			WebElement clickIt = driver.findElement(By.xpath("//*[@id='permissionBar']/a[1]"));
			action.moveToElement(clickIt).click().build().perform();
				Reporter.log("Edit button clicked successfully");
		 		System.out.println("Edit button clicked successfully");
			
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
		 System.out.println("Update button clicked successfully");
		 return driver;
	 }
	 
	 public static WebDriver draftAndNewBtnClick(){
		 CommonClass.sleepTime(5000);
		 Actions action = new Actions(driver);
		 WebDriverWait wait = new WebDriverWait(driver,40);
			wait.pollingEvery(30, TimeUnit.SECONDS);
			//Draft Button
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='permissionBar']/a[2]")));
			WebElement clickIt = driver.findElement(By.xpath("//*[@id='permissionBar']/a[2]"));
			action.moveToElement(clickIt).click().build().perform();
				Reporter.log("Draft and New button clicked successfully");
		 		System.out.println("Draft and New button clicked successfully");
		 return driver;
	 }
	 
 public static WebDriver copyFromBtnClick(){
		 
		 sleepTime(5000);
		 Actions action = new Actions(driver);
		 WebDriverWait wait = new WebDriverWait(driver,40);
			wait.pollingEvery(30, TimeUnit.SECONDS);
			//Draft Button
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='permissionBar']/a[3]")));
			WebElement clickIt = driver.findElement(By.xpath("//*[@id='permissionBar']/a[3]"));
			action.moveToElement(clickIt).click().build().perform();
			
			Reporter.log("Copy From button clicked successfully");
	 		System.out.println("Copy From button clicked successfully");
			
		 return driver;
 }
 
 public static WebDriver duplicateBtnClick(){ 
	 sleepTime(5000);
	 Actions action = new Actions(driver);
	 WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		//Draft Button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='permissionBar']/a[2]")));
		WebElement clickIt = driver.findElement(By.xpath("//*[@id='permissionBar']/a[2]"));
		action.moveToElement(clickIt).click().build().perform();
			Reporter.log("Duplicate button clicked successfully");
	 		System.out.println("Duplicate button clicked successfully");
		
	 return driver;
}
	 
	 
		public static WebDriver chkLblStatusReleased(){
			sleepTime(5000);
			SoftAssert soAssert = new SoftAssert();
			WebDriverWait wait = new WebDriverWait(driver, 40);
			wait.pollingEvery(30, TimeUnit.SECONDS);
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("lbldocstatus")));
			soAssert.assertEquals("(Released)", driver.findElement(By.id("lbldocstatus")).getText());
				Reporter.log("Header changed as Released");
				System.out.println("Header changed as Released");
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
					System.out.println("History option available");
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
			System.out.println("Convert to account option available");

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
			 sleepTime(3000);
			 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[@class='tiles-header'][text()='Task/Event']")));
			 driver.findElement(By.xpath("//p[@class='tiles-header'][text()='Task/Event']")).click();
			 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='col-sm-12']/h2[text()='Task Schedule']")));
			 Assert.assertEquals(driver.findElement(By.xpath("//div[@class='col-sm-12']/h2[text()='Task Schedule']")).getText(),"Task Schedule");
			 System.out.println("Header \"Task Schedule\" - verified");
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
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='permissionBar']/a[text()='Draft']")));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id='permissionBar']/a[text()='Draft']"))));
		driver.findElement(By.xpath("//*[@id='permissionBar']/a[text()='Draft']")).click(); // click on draft button
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@id='lbldocstatus'][text()='(Draft)']")));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//label[@id='lbldocstatus'][text()='(Draft)']"))));
		System.out.println("Status''Draft'' - verified");
		return driver.findElement(By.xpath("//label[@id='lbldocstatus']")).getText();  // return for verify dreaft order status


	}

	/*Release and verify sales status*/
	public static String release_Ok_AndCheckStatus(){
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='permissionBar']/a[text()='Release']")));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id='permissionBar']/a[text()='Release']"))));
		driver.findElement(By.xpath("//*[@id='permissionBar']/a[text()='Release'] ")).click(); // click on draft button
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[6]/div[3]/a")));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("/html/body/div[6]/div[3]/a"))));
		System.out.println("'Information' pop-up. - Verified");
		driver.findElement(By.xpath("/html/body/div[6]/div[3]/a")).click();  // click ok on information dialog box
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@id='lbldocstatus'][text()='(Released)']")));
		System.out.println("Status''Released'' - verified");
		return driver.findElement(By.xpath("//label[@id='lbldocstatus']")).getText(); // verify Relesed order status

	}

	/*Release and verify sales status*/
	public static String releaseAndCheckStatus(){
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='permissionBar']/a[text()='Release']")));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id='permissionBar']/a[text()='Release']"))));
		driver.findElement(By.xpath("//*[@id='permissionBar']/a[text()='Release'] ")).click(); // click on draft button
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@id='lbldocstatus'][text()='(Released)']")));
		System.out.println("Status''Released'' - verified");
		return driver.findElement(By.xpath("//label[@id='lbldocstatus']")).getText(); // verify Relesed order status

	}
}
