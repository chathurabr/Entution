package SalesAndMarketing._04_leadInformation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class _04_03_NewLeadCreation {
	WebDriver driver;
	//Mandatory
	By nameTitledropdown = By.id("cboxTitle");
		By titleMr = By.xpath("//*[@id='cboxTitle']/option[2]");
	By nameTxtBx = By.id("txtName");
	By mobiletxtBx = By.id("txtMobileHeader");
	By cboxAccountOwner = By.id("cboxAccountOwner");
	By salesUnitDropDown = By.id("cboxSalesUnitPerson");
		By selectSalesUni = By.xpath("//*[@id='cboxSalesUnitPerson']/option[8]");//Apple
	//Relevant fields
	By companyTxtBx = By.id("txtCompany1");
	By nicTxtBx = By.id("txtNIC");
	By designationTxtBx = By.id("txtDesignation");
	By emailTxtBx = By.id("txtEmailHeader");
	By mobileTxtBxTwo = By.id("txtphone2Header");
	
	//Add Contact details
	By addContactPlusBtn = By.id("hlNewContact");
	By nameTitleSelector = By.id("cboxContTitle");
	By contactName = By.id("txtContName");
	By phoneNumber =By.id("txtPhone1");
	By email = By.id("txtEmail");
	By contactUpdateBtn = By.xpath("/html/body/div[7]/div[3]/a[1]");
	
	//Delete contact details
	By secondContactDeleteIcon = By.xpath("//*[@id='tblContact']/tbody/tr[2]/td[2]/span");
	By delMsgBox = By.xpath("/html/body/div[9]");
	By yesBtn = By.xpath("/html/body/div[9]/div[3]/a[1]");
								
	// Add Inquery
	By addInqueryBtn = By.id("hlInquiries");
	By salesInqueryDialogBox = By.xpath("/html/body/div[7]");
	By updateBtn = By.xpath("/html/body/div[7]/div[3]/a[1]");
		//Inquery mandatory fields check
		By inqueryAboutAstrx = By.xpath("//*[@id='divInqryCont']/table/tbody/tr[2]/td[1]/label");
		By inqueryAboutErrMsg = By.xpath("//*[@id='divInqryCont']/table/tbody/tr[2]/td[2]/div");
	By inqueryAboutTxtBx = By.id("txtOppName");
	By inqueryDescTxtBx = By.id("txtDesc");
	//Confirm inquery added successfully
	By confInq = By.xpath("//*[@id='tblSalesInquery']/tbody/tr");
	//Lbl ststus - (Released)
	By statusLbl = By.id("lbldocstatus");
	
	public _04_03_NewLeadCreation(WebDriver driver){
		this.driver=driver;
	}
	
	public void NewLeadCreation(String leadName,String leadMobileNumber,String companyName,String nicNumber,String designationTitle,String inqueryAbout,String inqDescription,String emailAddress,String mobileNumberSecond,String contactPersonName,String contactPersonPhoneNumber,String contactPersonEmailAddress){
		this.enterLeadInfo(leadName, leadMobileNumber,companyName, nicNumber, designationTitle);
		this.insertInqury(inqueryAbout, inqDescription);
		this.enterContactDetails( emailAddress, mobileNumberSecond);
		this.addNewContactDetails(contactPersonName, contactPersonPhoneNumber, contactPersonEmailAddress);
		this.deleteContact();
		this.confirmInquery();
	}
	
	public void enterLeadInfo(String leadName,String leadMobileNumber, String companyName, String nicNumber, String designationTitle){
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		//Title dropdown choose Mr
		wait.until(ExpectedConditions.elementToBeClickable(nameTitledropdown));
		Select titleDropDown = new Select(driver.findElement(nameTitledropdown));
		titleDropDown.selectByVisibleText("Mr.");
		//Enter Name
			wait.until(ExpectedConditions.elementToBeClickable(nameTxtBx));
			WebElement nameTxt = driver.findElement(nameTxtBx);
			action.moveToElement(nameTxt).click().build().perform();
			action.moveToElement(nameTxt).sendKeys(leadName).build().perform();
		//Mobile
			wait.until(ExpectedConditions.elementToBeClickable(mobiletxtBx));
			WebElement mobileTxt = driver.findElement(mobiletxtBx);
			action.moveToElement(mobileTxt).click().build().perform();
			action.moveToElement(mobileTxt).sendKeys(leadMobileNumber).build().perform();
			
			// Wait until cboxAccountOwner get Enable
			wait.until(ExpectedConditions.elementToBeClickable(cboxAccountOwner));
		
		//SalesUnit dropdown
			wait.until(ExpectedConditions.elementToBeClickable(salesUnitDropDown));
			Select salesUnitDropDownMenu = new Select(driver.findElement(salesUnitDropDown));
			salesUnitDropDownMenu.selectByVisibleText("Apple");
		//Company
			wait.until(ExpectedConditions.elementToBeClickable(companyTxtBx));
			WebElement company = driver.findElement(companyTxtBx);
			action.moveToElement(company).click().build().perform();
			action.moveToElement(company).sendKeys(companyName).build().perform();
		//NIC number
			wait.until(ExpectedConditions.elementToBeClickable(nicTxtBx));
			WebElement nic = driver.findElement(nicTxtBx);
			action.moveToElement(nic).click().build().perform();
			action.moveToElement(nic).sendKeys(nicNumber).build().perform();
		//Designation	
			wait.until(ExpectedConditions.elementToBeClickable(designationTxtBx));
			WebElement designation = driver.findElement(designationTxtBx);
			action.moveToElement(designation).click().build().perform();
			action.moveToElement(designation).sendKeys(designationTitle).build().perform();
					Reporter.log("Values entered");
			
	}
	public void enterContactDetails( String emailAddress, String mobileNumberSecond){
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		
		//Email address
		wait.until(ExpectedConditions.elementToBeClickable(emailTxtBx));
		WebElement emailAdd = driver.findElement(emailTxtBx);
		action.moveToElement(emailAdd).click().build().perform();
		action.moveToElement(emailAdd).sendKeys(emailAddress).build().perform();
	// Mobile number 2	
		wait.until(ExpectedConditions.elementToBeClickable(mobileTxtBxTwo));
		WebElement mobilenumberTwo = driver.findElement(mobileTxtBxTwo);
		action.moveToElement(mobilenumberTwo).click().build().perform();
		action.moveToElement(mobilenumberTwo).sendKeys(mobileNumberSecond).build().perform();
				Reporter.log("Contact details added in the edit mode");
	}
	
	/*seperate contact details*/
	public void addNewContactDetails(String contactPersonName, String contactPersonPhoneNumber, String contactPersonEmailAddress){
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.elementToBeClickable(addContactPlusBtn));
		WebElement contactPlusSign = driver.findElement(addContactPlusBtn);
		
		action.moveToElement(contactPlusSign).click().build().perform();
		//	Fill Contact Information
			//Title
		Select titleDropDown = new Select(driver.findElement(nameTitleSelector));
		titleDropDown.selectByVisibleText("Mr.");
			//Name contactName
		wait.until(ExpectedConditions.elementToBeClickable(contactName));
		WebElement contactNametxtBx = driver.findElement(contactName);
		
		action.moveToElement(contactNametxtBx).click().build().perform();
		action.moveToElement(contactNametxtBx).sendKeys(contactPersonName).build().perform();
			//Phone phoneNumber
		wait.until(ExpectedConditions.elementToBeClickable(phoneNumber));
		WebElement phoneNumberTxtBx = driver.findElement(phoneNumber);
		
		action.moveToElement(phoneNumberTxtBx).click().build().perform();
		action.moveToElement(phoneNumberTxtBx).sendKeys(contactPersonPhoneNumber).build().perform();
			//Email
		wait.until(ExpectedConditions.elementToBeClickable(email));
		WebElement emailTxtBx = driver.findElement(email);
		
		action.moveToElement(emailTxtBx).click().build().perform();
		action.moveToElement(emailTxtBx).sendKeys(contactPersonEmailAddress).build().perform();
			// contactUpdateBtn
		wait.until(ExpectedConditions.elementToBeClickable(contactUpdateBtn));
		WebElement contactUpdBtn = driver.findElement(contactUpdateBtn);
		
		action.moveToElement(contactUpdBtn).click().build().perform();
	}
	
	public void deleteContact(){
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, 250)"); 
		
		if(driver.findElement(secondContactDeleteIcon).isDisplayed() || driver.findElement(secondContactDeleteIcon).isEnabled()){
			WebElement delIcon = driver.findElement(secondContactDeleteIcon);
			action.moveToElement(delIcon).click().build().perform();
			//delMsgBox
			wait.until(ExpectedConditions.presenceOfElementLocated(delMsgBox));
			
			wait.until(ExpectedConditions.elementToBeClickable(yesBtn));
			WebElement okBtnEle = driver.findElement(yesBtn);
			action.moveToElement(okBtnEle).click().build().perform();
		}else{
			
		}
	}
	
	public void chkLblStatusReleased(){
		SoftAssert soAssert = new SoftAssert();
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.elementToBeClickable(statusLbl));
		soAssert.assertEquals("(Released)", driver.findElement(statusLbl).getText());
		Reporter.log("Header label changed as Released");
		
	}
	
	public void insertInqury(String inqueryAbout, String inqDescription){
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		
		//Click on add inquery Btn
			wait.until(ExpectedConditions.elementToBeClickable(addInqueryBtn));
			WebElement clickIt = driver.findElement(addInqueryBtn);
			action.moveToElement(clickIt).click().build().perform();
			
		//Wait
			wait.until(ExpectedConditions.presenceOfElementLocated(salesInqueryDialogBox));
		//Validation
			wait.until(ExpectedConditions.elementToBeClickable(updateBtn));
			WebElement updateButton = driver.findElement(updateBtn);
			action.moveToElement(updateButton).click().build().perform();
			
			wait.until(ExpectedConditions.presenceOfElementLocated(inqueryAboutAstrx));
			
			wait.until(ExpectedConditions.presenceOfElementLocated(inqueryAboutErrMsg));
		//Insert inquery
			wait.until(ExpectedConditions.elementToBeClickable(inqueryAboutTxtBx));
			WebElement inqAbtTxtBx = driver.findElement(inqueryAboutTxtBx);
			action.moveToElement(inqAbtTxtBx).click().build().perform();
			action.moveToElement(inqAbtTxtBx).sendKeys(inqueryAbout).build().perform();
			
			wait.until(ExpectedConditions.elementToBeClickable(inqueryDescTxtBx));
			WebElement inqDesc = driver.findElement(inqueryDescTxtBx);
			action.moveToElement(inqDesc).click().build().perform();
			action.moveToElement(inqDesc).sendKeys(inqDescription).build().perform();
		// Save inquery
			wait.until(ExpectedConditions.elementToBeClickable(updateBtn));
			action.moveToElement(updateButton).click().build().perform();
	}
	
	public void confirmInquery(){
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(confInq));
				Reporter.log("inquiry details added successfully");
	}
}
