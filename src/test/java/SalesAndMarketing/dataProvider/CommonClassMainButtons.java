package SalesAndMarketing.dataProvider;

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
 *											Buttons			
 *****************************************************************************************/
public class CommonClassMainButtons extends CommonClass {
	//public static WebDriver driver;
	static WebDriver wdd = CommonClass.driver;
	
	public static WebDriver createNewItem(){
		Actions action = new Actions(wdd);
		 WebDriverWait wait = new WebDriverWait(wdd,60);
			wait.pollingEvery(30, TimeUnit.SECONDS);
			
			wait.until(ExpectedConditions.elementToBeClickable(By.id("btnUpdate")));
			WebElement clickIt = wdd.findElement(By.id("btnUpdate"));
			action.moveToElement(clickIt).click().build().perform();
			
		return wdd;
	}
	 
	 public static WebDriver draftBtnClick(){
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
		 
		 SoftAssert soAssert = new SoftAssert();
		 Actions action = new Actions(wdd);
		 WebDriverWait wait = new WebDriverWait(wdd,60);
			wait.pollingEvery(30, TimeUnit.SECONDS);
			//release Button
			WebElement releaseB = wdd.findElement(By.xpath("//*[@id='permissionBar']/a[text()='Release']"));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='permissionBar']/a[text()='Release']")));

		 List <WebElement> releaseButton = driver.findElements(By.xpath("//*[@id='permissionBar']/a[text()='Release']"));
			for(int i=0;i<releaseButton.size();i++){

				if(releaseButton.get(i).getText().equals("Release")){

					action.moveToElement(releaseButton.get(i)).click().build().perform();
					Reporter.log("Release button clicked successfully");
				}else{

					soAssert.assertEquals(releaseButton.get(i).getText(), "Release");
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
			
			WebElement drftNew = wdd.findElement(By.xpath("//*[@id='permissionBar']/a[2]"));
			wait.until(ExpectedConditions.elementToBeClickable(drftNew));
			
			if(drftNew.getText().equals("Draft & New")){
			//Draft Button
				action.moveToElement(drftNew).click().build().perform();
				Reporter.log("Draft and New button clicked successfully");
			}else{
				//soAssert.assertEquals(drftNew.getText(), "Draft & New");
				Assert.assertEquals("Draft & New",drftNew.getText());
				//soAssert.assertAll();
			}
		 return wdd;
	 }
	 
 public static WebDriver copyFromBtnClick(){
		 
		 try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		 SoftAssert soAssert = new SoftAssert();
		 Actions action = new Actions(wdd);
		 WebDriverWait wait = new WebDriverWait(wdd,60);
			wait.pollingEvery(30, TimeUnit.SECONDS);
			
			WebElement cpyFrm = wdd.findElement(By.xpath("//*[@id='permissionBar']/a[3]"));
			wait.until(ExpectedConditions.elementToBeClickable(cpyFrm));
			if(cpyFrm.getText().equals("Copy From")){
			//Draft Button
			action.moveToElement(cpyFrm).click().build().perform();
			Reporter.log("Copy From button clicked successfully");
			}else{
				soAssert.assertEquals(cpyFrm.getText(), "Copy From");
			}
		 return wdd;
 }
 
 public static WebDriver duplicateBtnClick(){ 
	 try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
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
			/*try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}*/
			By checkLabelStatus = By.xpath(".//label[@id='lbldocstatus']");
			SoftAssert soAssert = new SoftAssert();
			WebDriverWait wait = new WebDriverWait(wdd, 60);
			wait.pollingEvery(30, TimeUnit.SECONDS);

			wait.until(ExpectedConditions.presenceOfElementLocated(checkLabelStatus));
			WebElement lbl = driver.findElement(checkLabelStatus);

			if(lbl.isDisplayed()){
				Assert.assertEquals(lbl.getText(),"(Released)");
			}
			else{
				System.out.println("Release Label cannot find");
			}
			return wdd;
			
		}
		 
}
