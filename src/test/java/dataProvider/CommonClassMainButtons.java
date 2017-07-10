package dataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.concurrent.TimeUnit;

/***************************************************************************************
 * 										This class contains
 * 					New Item 
 *					Draft, Release, Edit, Update, Draft & New, Copy From, Duplicate
 *					Release Status Label
 *					checkoutButtonClick
 *											Buttons			
 *****************************************************************************************/
public class CommonClassMainButtons extends CommonClass {
	//public static WebDriver driver;
	static WebDriver wdd = CommonClass.driver;

	public static WebDriver createNewItem(String buttonName){
		By ButtonUpD = By.id("btnUpdate");
		Actions action = new Actions(wdd);
		 WebDriverWait wait = new WebDriverWait(wdd,60);
			wait.pollingEvery(30, TimeUnit.SECONDS);

			wait.until(ExpectedConditions.elementToBeClickable(ButtonUpD));
			WebElement clickUpDButton = wdd.findElement(ButtonUpD);

				for (int i = 0; i < 1000; i++) {
					if(clickUpDButton.isDisplayed()) {
					action.moveToElement(clickUpDButton).click().build().perform();
					Reporter.log("Clicked on the "+buttonName+" button");
					break;
				}
					}

			
		return wdd;
	}
	 
	 public static WebDriver draftBtnClick(){
		CommonClass.sleepTime(3000);
		 SoftAssert soAssert = new SoftAssert();
		 Actions action = new Actions(wdd);
		 WebDriverWait wait = new WebDriverWait(wdd,60);
			wait.pollingEvery(30, TimeUnit.SECONDS);
			//Draft Button
			WebElement draftb = wdd.findElement(By.xpath("//*[@id='permissionBar']/a[1]"));
			wait.until(ExpectedConditions.elementToBeClickable(draftb));
			
			if(draftb.getText().equals("Draft")){
			action.moveToElement(draftb).click().build().perform();
				Reporter.log("Draft button clicked successfully");
			}else{
				soAssert.assertEquals(draftb.getText(), "Draft");
			}
		 return wdd;
	 }
	 
	 public static WebDriver releaseBtnClick(){

		 CommonClass.sleepTime(5000);
		 SoftAssert soAssert = new SoftAssert();
		 Actions action = new Actions(wdd);
		 WebDriverWait wait = new WebDriverWait(wdd,60);
		 wait.pollingEvery(30, TimeUnit.SECONDS);
			//release Button
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='permissionBar']/a[2]")));

		 List <WebElement> releaseButton = driver.findElements(By.xpath("//*[@id='permissionBar']/a[2]"));
			for(int i=0;i<releaseButton.size();i++){

				if(releaseButton.get(i).getText().equals("Release")){

					action.moveToElement(releaseButton.get(i)).click().build().perform();
					Reporter.log("Release button clicked successfully");
				}else{

					action.moveToElement(releaseButton.get(i)).click().build().perform();
				}

			}

		 return wdd;
	 }

	public static WebDriver serialBatchButtonClick(){

		CommonClass.sleepTime(5000);
		SoftAssert soAssert = new SoftAssert();
		Actions action = new Actions(wdd);
		WebDriverWait wait = new WebDriverWait(wdd,60);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		//release Button
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='pic16 pic16-retweet']")));

		List <WebElement> serialBatchButton = driver.findElements(By.xpath("//span[@class='pic16 pic16-retweet']"));
		for(int i=0;i<serialBatchButton.size();i++){

			if(serialBatchButton.get(i).getText().equals("Serial Batch")){

				action.moveToElement(serialBatchButton.get(i)).click().build().perform();
				Reporter.log("Serial Batch button clicked successfully");
			}else{

				action.moveToElement(serialBatchButton.get(i)).click().build().perform();
			}

		}

		return wdd;
	}
	 
	 public static WebDriver editBtnClick(){
		 
		 try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		 SoftAssert soAssert = new SoftAssert();
		 Actions action = new Actions(wdd);
		 WebDriverWait wait = new WebDriverWait(wdd,60);
			wait.pollingEvery(5, TimeUnit.SECONDS);
															
			WebElement editB = wdd.findElement(By.xpath("//*[@id='permissionBar']/a[1]"));
			WebElement editBIcon = wdd.findElement(By.xpath("//*[@id='permissionBar']/a[1]/span"));
			wait.until(ExpectedConditions.elementToBeClickable(editB));
			
			if(editB.getText().equals("Edit")){
			//Draft Button
			//action.moveToElement(editB).click().build().perform();
			action.moveToElement(editBIcon).click().build().perform();
				Reporter.log("Edit button clicked successfully");
			}else{
				soAssert.assertEquals(editB.getText(), "Edit");
				soAssert.assertAll();
			}
		 return wdd;
	 }
	 public static WebDriver updateBtnClick(){
		 
		 SoftAssert soAssert = new SoftAssert();
		 Actions action = new Actions(wdd);
		 WebDriverWait wait = new WebDriverWait(wdd,60);
			wait.pollingEvery(30, TimeUnit.SECONDS);
															
			WebElement updateB = wdd.findElement(By.xpath("//*[@id='permissionBar']/a[1]"));
			WebElement updateBIcon = wdd.findElement(By.xpath("//*[@id='permissionBar']/a[1]/span"));
			wait.until(ExpectedConditions.elementToBeClickable(updateB));
			wait.until(ExpectedConditions.elementToBeClickable(updateBIcon));
				
			if(updateB.getText().equals("Update")){
				//Draft Button	
				action.moveToElement(updateBIcon).click().build().perform();
				Reporter.log("Update button clicked successfully");
			}
			else{
				soAssert.assertEquals(updateB.getText(), "Update");
				soAssert.assertAll();
			}
		 return wdd;
	 }
	 
	 public static WebDriver draftAndNewBtnClick(){
		 
		 try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		 
		 SoftAssert soAssert = new SoftAssert();
		 Actions action = new Actions(wdd);
		 WebDriverWait wait = new WebDriverWait(wdd,60);
			wait.pollingEvery(30, TimeUnit.SECONDS);
		 CommonClass.sleepTime(4000);
		 WebElement drftNew = driver.findElement(By.xpath("//*[@id='permissionBar']/a[contains(text(),'Draft & New')]"));
			wait.until(ExpectedConditions.elementToBeClickable(drftNew));
			
			if(drftNew.getText().equals("Draft & New")){
			//Draft Button
				drftNew.click();
				//action.moveToElement(drftNew).click().build().perform();
				System.out.println("Draft and new button clicked ");
				Reporter.log("Draft and New button clicked successfully");
			}else{
				//soAssert.assertEquals(drftNew.getText(), "Draft & New");
				Assert.assertEquals(drftNew.getText(),"Draft & New");
				//soAssert.assertAll();
			}
		 return wdd;
	 }
	 
 public static WebDriver copyFromBtnClick(){
		 
		 CommonClass.sleepTime(5000);
		 SoftAssert soAssert = new SoftAssert();
		 Actions action = new Actions(wdd);
		 WebDriverWait wait = new WebDriverWait(wdd,60);
			wait.pollingEvery(30, TimeUnit.SECONDS);
			
			WebElement cpyFrm = wdd.findElement(By.xpath("//*[@id='permissionBar']/a[contains(text(),'Copy From')]"));
			wait.until(ExpectedConditions.elementToBeClickable(cpyFrm));
			if(cpyFrm.getText().equals("Copy From")){
			//Draft Button
				cpyFrm.click();
			//action.moveToElement(cpyFrm).click().build().perform();
			Reporter.log("Copy From button clicked successfully");
			}else{
				soAssert.assertEquals(cpyFrm.getText(), "Copy From");
			}
		 return wdd;
 }
 
 public static WebDriver duplicateBtnClick(){ 
	 CommonClass.sleepTime(5000);
	 SoftAssert soAssert = new SoftAssert();
	 Actions action = new Actions(wdd);
	 WebDriverWait wait = new WebDriverWait(wdd,60);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		
		WebElement dupli = wdd.findElement(By.xpath("//*[@id='permissionBar']/a[2]"));
		wait.until(ExpectedConditions.elementToBeClickable(dupli));
		
		if(dupli.getText().equals("Duplicate")){
		//Draft Button
		action.moveToElement(dupli).click().build().perform();
			Reporter.log("Duplicate button clicked successfully");
		}else{
			soAssert.assertEquals(dupli.getText(), "Duplicate");
			soAssert.assertAll();
		}
	 return wdd;
}
		public static WebDriver chkLblStatusReleased(){
			CommonClass.sleepTime(5000);

			By checkLabelStatus = By.xpath("//label[@id='lbldocstatus']");
			By loadingScreen = By.xpath("//div[@class='waitbox-container']");


			SoftAssert soAssert = new SoftAssert();
			WebDriverWait wait = new WebDriverWait(wdd, 60);
			wait.pollingEvery(30, TimeUnit.SECONDS);

			try {

				WebElement loadingScr = driver.findElement(loadingScreen);
				if (loadingScr.isDisplayed() || loadingScr.isEnabled()) {
					wait.until(ExpectedConditions.invisibilityOf(loadingScr));
				} else {
					System.out.println("Loading screen not displayed :3");
				}
			}catch(Exception e){
				System.out.println("Exception occurred: "+e);
			}
			String lbl = wait.until(ExpectedConditions.presenceOfElementLocated(checkLabelStatus)).getText();

				Assert.assertEquals(lbl,"(Released)");
			return wdd;
			
		}

	public static WebDriver chkLblStatusDrafted(){
		CommonClass.sleepTime(5000);

		By checkLabelStatus = By.xpath("//label[@id='lbldocstatus']");
		By loadingScreen = By.xpath("//div[@class='waitbox-container']");


		SoftAssert soAssert = new SoftAssert();
		WebDriverWait wait = new WebDriverWait(wdd, 60);
		wait.pollingEvery(30, TimeUnit.SECONDS);

		try {

			WebElement loadingScr = driver.findElement(loadingScreen);
			if (loadingScr.isDisplayed() || loadingScr.isEnabled()) {
				wait.until(ExpectedConditions.invisibilityOf(loadingScr));
			} else {
				System.out.println("Loading screen not displayed :3");
			}
		}catch(Exception e){
			System.out.println("Exception occurred: "+e);
		}
		String lbl = wait.until(ExpectedConditions.presenceOfElementLocated(checkLabelStatus)).getText();

		Assert.assertEquals(lbl,"(Draft)");
		return wdd;

	}



	public static WebDriver taskEventTileClick(){
		CommonClass.sleepTime(3000);
		By heading = By.xpath("//div[@class='col-sm-12']/h2");
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(2, TimeUnit.SECONDS);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='tiles-header'][text()='Task/Event']")));
		WebElement taskTile = driver.findElement(By.xpath("//p[@class='tiles-header'][text()='Task/Event']"));
		taskTile.click();

		System.out.println("Task/Event Tile clicked");
		Reporter.log("Task/Event Tile clicked");

		wait.until(ExpectedConditions.presenceOfElementLocated(heading));
		WebElement head = driver.findElement(heading);
		Assert.assertEquals(head.getText(),"Task Schedule");

		System.out.println("System moved to the Task Schedule Page");
		Reporter.log("System moved to the Task Schedule Page");

		return driver;
	}

	//20. Click on Check-out button.
	public static WebDriver checkoutButtonClick(){
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(2, TimeUnit.SECONDS);

		WebElement chkOutBtn = driver.findElement(By.id("btnCalc2"));
		wait.until(ExpectedConditions.elementToBeClickable(chkOutBtn));
		action.moveToElement(chkOutBtn).click().build().perform();

		return driver;
	}
}
