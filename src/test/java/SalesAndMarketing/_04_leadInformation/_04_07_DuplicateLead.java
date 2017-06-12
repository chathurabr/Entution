package SalesAndMarketing._04_leadInformation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class _04_07_DuplicateLead {
	WebDriver driver;
	
	//Mandatory
		By nameTitledropdown = By.id("cboxTitle");
		By nameTxtBx = By.id("txtName");
		By mobiletxtBx = By.id("txtMobileHeader");
		By cboxAccountOwner = By.id("cboxAccountOwner");
		By salesUnitDropDown = By.id("cboxSalesUnitPerson");
			By selectSalesUni = By.xpath("//*[@id='cboxSalesUnitPerson']/option[25]");//Test01
		//Relevant fields
		By companyTxtBx = By.id("txtCompany1");
		By nicTxtBx = By.id("txtNIC");
		By designationTxtBx = By.id("txtDesignation");
		By emailTxtBx = By.id("txtEmailHeader");
		By mobileTxtBxTwo = By.id("txtphone2Header");
		//
		
	
	public _04_07_DuplicateLead(WebDriver driver){
		this.driver=driver;
	}
	
	public void DuplicateLead(){
		this.duplicatebrnClick();
		this.verifyDuplicateInfo();
	}
	
	public void verifyDuplicateInfo(){
		String vals ;
		SoftAssert soAssert = new SoftAssert();
		
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		//Name Title
		wait.until(ExpectedConditions.elementToBeClickable(nameTitledropdown));
		soAssert.assertEquals(vals = driver.findElement(nameTitledropdown).getAttribute("value"),"Mr");

		//Name
		wait.until(ExpectedConditions.elementToBeClickable(nameTxtBx));
		soAssert.assertEquals(vals = driver.findElement(nameTxtBx).getAttribute("value"),"Fernando");
		System.out.println("++++++++++++++++++++++++++++++"+vals);
		
		wait.until(ExpectedConditions.elementToBeClickable(mobiletxtBx));
		soAssert.assertEquals(vals = driver.findElement(mobiletxtBx).getAttribute("value"),"0123654785");
		
		
		/*wait.until(ExpectedConditions.elementToBeClickable(salesUnitDropDown));
		soAssert.assertEquals(vals = driver.findElement(salesUnitDropDown).getText(),"16974760868091");
		System.out.println("++++++++++++++++++++++++++++++"+vals);*/
		
		wait.until(ExpectedConditions.elementToBeClickable(companyTxtBx));
		soAssert.assertEquals(vals = driver.findElement(companyTxtBx).getAttribute("value"),"MyCompany");
		
		
		wait.until(ExpectedConditions.elementToBeClickable(nicTxtBx));
		soAssert.assertEquals(vals = driver.findElement(nicTxtBx).getAttribute("value"),"956400251v");
		
		
		wait.until(ExpectedConditions.elementToBeClickable(designationTxtBx));
		soAssert.assertEquals(vals = driver.findElement(designationTxtBx).getAttribute("value"),"Team Leader");
		
		
		wait.until(ExpectedConditions.elementToBeClickable(emailTxtBx));
		soAssert.assertEquals(vals = driver.findElement(emailTxtBx).getAttribute("value"),"teamleader@slt.lk");
		
		wait.until(ExpectedConditions.elementToBeClickable(mobileTxtBxTwo));
		soAssert.assertEquals(vals = driver.findElement(mobileTxtBxTwo).getAttribute("value"),"0112147147");
		
		wait.until(ExpectedConditions.elementToBeClickable(salesUnitDropDown));
		soAssert.assertEquals(driver.findElement(salesUnitDropDown).getAttribute("value"),"Test01");
		/*driver.findElement(salesUnitDropDown).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(selectSalesUni));
		soAssert.assertEquals(vals = driver.findElement(selectSalesUni).getText(),"Test01");*/
		
			Reporter.log("Duplicated values displayed");
		soAssert.assertAll();
	}
	
	public void duplicatebrnClick(){
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
	}
	
	
}
