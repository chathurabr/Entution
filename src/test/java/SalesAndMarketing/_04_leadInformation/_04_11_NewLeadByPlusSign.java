package SalesAndMarketing._04_leadInformation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.util.concurrent.TimeUnit;

public class _04_11_NewLeadByPlusSign {
	WebDriver driver;
	By refreshBtn = By.xpath("//*[@id='g1011']/div[1]/span[1]/span[2]");
	By colOne = By.xpath("//*[@id='g1011-t']/table/tbody/tr[1]/td[6]/a");
	//
	By plusSign = By.id("btnUpdate");
	//Common					
	By validatorCloseBtn = By.xpath("//*[@id='validator-Paramerters']/a");
	By closeBtn = By.xpath("/html/body/div[7]/div[1]/span[2]");
	//Rating
	By newRating = By.xpath("//*[@id='divSecGenereal']/div[2]/table/tbody/tr[3]/td[2]/div/span");
	By parameterTbl = By.id("tblGradeThreeMaster");
	By paraMeterTbNewRow = By.xpath("//*[@id='tblGradeThreeMaster']/tbody/tr[4]/td[4]/input");
	By updateBtn = By.xpath("/html/body/div[7]/div[3]/a");
	
	//Lead Status
	By newLeadStatusPlusSign = By.xpath("//*[@id='divSecGenereal']/div[2]/table/tbody/tr[5]/td[2]/div/span");
	By newLeadStatusParameterTbl = By.xpath("/html/body/div[7]");
	By newLeadStatusParameterTbNewRow = By.xpath("//*[@id='tblGradeThreeMaster']/tbody/tr[5]/td[4]/input");
	//Lead Source
	By newLeadSourcePlusSign = By.xpath("//*[@id='divSecGenereal']/div[2]/table/tbody/tr[4]/td[2]/div/span");
	By newLeadSourceParaTbl = By.xpath("/html/body/div[7]");
	By newLeadSourceParameterTbNewRow =By.xpath("//*[@id='tblGradeThreeMaster']/tbody/tr[11]/td[4]/input");
	//Contact Information
	By newContactInfoPlusSign = By.xpath("//*[@id='hlNewContact']");
	By contactInfoPanel = By.xpath("/html/body/div[7]");
	//
	By nameTitleSelector = By.id("cboxContTitle");
	By contactName = By.id("txtContName");
	By contactUpdateBtn = By.xpath("/html/body/div[7]/div[3]/a[1]");
	//Contact Information
	
	//sales Inquery Info
	By salesInquery = By.id("hlInquiries");
	By inquiryAboutTxtBx = By.id("txtOppName");
	By salesInqueryUpdaeBtn = By.xpath("/html/body/div[7]/div[3]/a[1]");
	
	public _04_11_NewLeadByPlusSign(WebDriver driver){
		this.driver=driver;
	}
	
	public void NewLeadByPlusSign(String ratingInfoParameterName, String leadStatusPameterName, String leadSourceParameterName, String contactNameString, String salesInqueryAbout){
		this.navToPlusSignAndClick();
		this.addNewRaing();
		this.newRatingInfo(ratingInfoParameterName);
		this.newLeadStatus(leadStatusPameterName);
		this.leadSource(leadSourceParameterName);
		this.contactInfo(contactNameString);
		this.salesInqueryInfo(salesInqueryAbout);
	}
	
	public void navToPlusSignAndClick(){
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
	
		wait.until(ExpectedConditions.elementToBeClickable(refreshBtn));
		WebElement elementOne = driver.findElement(refreshBtn);
			action.moveToElement(elementOne).click().build().perform();
		
		wait.until(ExpectedConditions.elementToBeClickable(refreshBtn));
		WebElement elementCol = driver.findElement(colOne);
			action.moveToElement(elementCol).click().build().perform();
		
		wait.until(ExpectedConditions.elementToBeClickable(plusSign));
			Reporter.log("Clicked on plus sign");
	}
	
	//Fill mandatory fields using testCase 04_03
	
	public void addNewRaing(){
		Actions action = new Actions(driver);
		
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.elementToBeClickable(newRating));
		WebElement elementNewRating = driver.findElement(newRating);
			action.moveToElement(elementNewRating).click().build().perform();
	}
	
	public void newRatingInfo(String ratingInfoParameterName){
		Actions action = new Actions(driver);
		
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		
		WebDriverWait wait2 = new WebDriverWait(driver,40);
		wait2.pollingEvery(500, TimeUnit.MILLISECONDS);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(parameterTbl));
		
		wait.until(ExpectedConditions.elementToBeClickable(paraMeterTbNewRow));
		WebElement tbNewRow = driver.findElement(paraMeterTbNewRow);
			action.moveToElement(tbNewRow).click().build().perform();
			driver.findElement(paraMeterTbNewRow).clear();
			action.moveToElement(tbNewRow).sendKeys(ratingInfoParameterName).build().perform();
			
			wait.until(ExpectedConditions.elementToBeClickable(updateBtn));
			WebElement updateB = driver.findElement(updateBtn);
				action.moveToElement(updateB).click().build().perform();
				
			
			wait2.until(ExpectedConditions.presenceOfElementLocated(validatorCloseBtn));
			WebElement closeB = driver.findElement(validatorCloseBtn);
				action.moveToElement(closeB).click().build().perform();
			
			
				
			wait.until(ExpectedConditions.elementToBeClickable(closeBtn));
			WebElement closeB2 = driver.findElement(closeBtn);
				action.moveToElement(closeB2).click().build().perform();
			
			
		}
	
	public void newLeadStatus(String leadStatusPameterName){
		Actions action = new Actions(driver);
		
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		
		WebDriverWait wait2 = new WebDriverWait(driver,40);
		wait2.pollingEvery(500, TimeUnit.MILLISECONDS);
	
		wait.until(ExpectedConditions.elementToBeClickable(newLeadStatusPlusSign));
		WebElement addNewLeadStatus = driver.findElement(newLeadStatusPlusSign);
			action.moveToElement(addNewLeadStatus).click().build().perform();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(newLeadStatusParameterTbl));
		
		wait.until(ExpectedConditions.presenceOfElementLocated(newLeadStatusParameterTbNewRow));
		WebElement tblRow = driver.findElement(newLeadStatusParameterTbNewRow);
			action.moveToElement(tblRow).click().build().perform();
		driver.findElement(newLeadStatusParameterTbNewRow).clear();
			action.moveToElement(tblRow).sendKeys(leadStatusPameterName).build().perform();
		
		wait.until(ExpectedConditions.elementToBeClickable(updateBtn));
		WebElement updateB = driver.findElement(updateBtn);
		action.moveToElement(updateB).click().build().perform();
		
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".validator")));
		//driver.findElement(By.cssSelector(".validator")).click();
		
							//validatorCloseBtn
		
		wait2.until(ExpectedConditions.presenceOfElementLocated(validatorCloseBtn));
		WebElement closeB = driver.findElement(validatorCloseBtn);
		action.moveToElement(closeB).click().build().perform();	
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(validatorCloseBtn));
			
//		--------------------------------------------------------------------																				
		wait2.until(ExpectedConditions.presenceOfElementLocated(closeBtn));
		WebElement closeB2 = driver.findElement(closeBtn);
		action.moveToElement(closeB2).click().build().perform();
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(closeBtn));
		
		}
		
	public void leadSource(String leadSourceParameterName){
		Actions action = new Actions(driver);
		//JavascriptExecutor jse = (JavascriptExecutor)driver;
			
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		
		WebDriverWait wait2 = new WebDriverWait(driver,40);
		wait2.pollingEvery(700, TimeUnit.MILLISECONDS);
		
		wait.until(ExpectedConditions.elementToBeClickable(newLeadSourcePlusSign));
		WebElement plusSign = driver.findElement(newLeadSourcePlusSign);
			action.moveToElement(plusSign).click().build().perform();
			
		wait.until(ExpectedConditions.presenceOfElementLocated(newLeadSourceParaTbl));
		//Scroll down
		//jse.executeScript("//*[@id='divPara']/div/div/div[2].scrollBy(0,250)", "");
		
		wait.until(ExpectedConditions.elementToBeClickable(newLeadSourceParameterTbNewRow));
		WebElement LeadSourceTblRow = driver.findElement(newLeadSourceParameterTbNewRow);
			action.moveToElement(LeadSourceTblRow).click().build().perform();
			driver.findElement(newLeadSourceParameterTbNewRow).clear();
			action.moveToElement(LeadSourceTblRow).sendKeys(leadSourceParameterName).build().perform();
		
		wait.until(ExpectedConditions.elementToBeClickable(updateBtn));
		WebElement updateB = driver.findElement(updateBtn);
			action.moveToElement(updateB).click().build().perform();
			
	/*		try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			
		
		wait2.until(ExpectedConditions.presenceOfElementLocated(validatorCloseBtn));
		WebElement closeB = driver.findElement(validatorCloseBtn);
	   action.moveToElement(closeB).click().build().perform();
			
		wait.until(ExpectedConditions.elementToBeClickable(closeBtn));
		WebElement closeB2 = driver.findElement(closeBtn);
			action.moveToElement(closeB2).click().build().perform();
			
		}
		
	public void contactInfo(String contactNameString){
		
		try{
		Actions action = new Actions(driver);
		
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.elementToBeClickable(newContactInfoPlusSign));
		WebElement contactInfoPlusSign = driver.findElement(newContactInfoPlusSign);
			action.moveToElement(contactInfoPlusSign).click().build().perform();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(contactInfoPanel));
		
		wait.until(ExpectedConditions.elementToBeClickable(nameTitleSelector));
		Select dropdown = new Select(driver.findElement(By.id("nameTitleSelector")));
		dropdown.selectByVisibleText("Mr");
		
		wait.until(ExpectedConditions.elementToBeClickable(contactName));
		WebElement contactNameTxtBx = driver.findElement(contactName);
			action.moveToElement(contactNameTxtBx).click().build().perform();
			driver.findElement(contactName).clear();
			action.moveToElement(contactNameTxtBx).sendKeys(contactNameString).build().perform();
			
		wait.until(ExpectedConditions.elementToBeClickable(contactUpdateBtn));
		WebElement contactUpdtBtn = driver.findElement(contactUpdateBtn);
			action.moveToElement(contactUpdtBtn).click().build().perform();
			
		}catch(Exception e){
			System.out.println(e);
			Reporter.log("<font color='red'>Exception Error</font> "+e);
		}
	}
	
	public void salesInqueryInfo(String salesInqueryAbout){
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Actions action = new Actions(driver);
		
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.elementToBeClickable(salesInquery));
		WebElement clickPlusbtn = driver.findElement(salesInquery);
		action.moveToElement(clickPlusbtn).click().build().perform();
		
		wait.until(ExpectedConditions.elementToBeClickable(inquiryAboutTxtBx));
		WebElement clickinqAbtTxtBx = driver.findElement(inquiryAboutTxtBx);
		action.moveToElement(clickinqAbtTxtBx).click().build().perform();
			driver.findElement(inquiryAboutTxtBx).clear();
		action.moveToElement(clickinqAbtTxtBx).sendKeys(salesInqueryAbout).build().perform();
		
		wait.until(ExpectedConditions.elementToBeClickable(salesInqueryUpdaeBtn));
		WebElement clickUpdateBtn = driver.findElement(salesInqueryUpdaeBtn);
		action.moveToElement(clickUpdateBtn).click().build().perform();
		
	}
				
	 }

