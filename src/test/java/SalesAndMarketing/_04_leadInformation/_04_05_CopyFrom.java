package SalesAndMarketing._04_leadInformation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class _04_05_CopyFrom {
	WebDriver driver;
	//Search
	By srchTxtBox = By.id("txtg1011");
	By tableBody = By.xpath("//*[@id='g1011-t']/table/tbody");
	
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
	
	public _04_05_CopyFrom(WebDriver driver){
		this.driver=driver;
		
	}
	
	public void CopyFrom(String srchKeyword,String SearchColumnName){
		this.searchTxtBoxSendText(srchKeyword);
		this.searchNSelectColumn(SearchColumnName);
		this.chkCopiedValues();
	}
	
	public void searchTxtBoxSendText(String srchKeyword){
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.elementToBeClickable(srchTxtBox));
		WebElement srchBx = driver.findElement(srchTxtBox);
		action.moveToElement(srchBx).click().build().perform();
		srchBx.clear();
		action.moveToElement(srchBx).sendKeys(srchKeyword).build().perform();
		action.moveToElement(srchBx).sendKeys(Keys.ENTER).build().perform();
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(tableBody));
	}
	
	public void searchNSelectColumn(String SearchColumnName){
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		
	
		List<WebElement> trEle = driver.findElements(By.tagName("tr"));
		
		for(int i=0;i<trEle.size();i++){
			Actions action = new Actions(driver);
			String treeEle = trEle.get(i).getText();
			//System.out.println("--- - - - - - - - - - - - - - - - - - - - - - - - - - - - - -"+treeEle);
			if(treeEle.startsWith(SearchColumnName)){
				System.out.println("+ + + + + +  + + + + + + + + + + + + +"+trEle.get(i).getText());
				action.moveToElement(trEle.get(i)).doubleClick().build().perform();
				break;
			}
		}
	}
	
	public void chkCopiedValues(){
		String vals ;
		SoftAssert soAssert = new SoftAssert();
		
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		//Name Title
		wait.until(ExpectedConditions.elementToBeClickable(titleMr));
		soAssert.assertEquals(vals = driver.findElement(titleMr).getAttribute("value"),"Mr");

		//Name
		wait.until(ExpectedConditions.elementToBeClickable(nameTxtBx));
		soAssert.assertEquals(vals = driver.findElement(nameTxtBx).getAttribute("value"),"Fernando");
		System.out.println("++++++++++++++++++++++++++++++"+vals);
		
		wait.until(ExpectedConditions.elementToBeClickable(mobiletxtBx));
		soAssert.assertEquals(vals = driver.findElement(mobiletxtBx).getAttribute("value"),"075265479");
		
		/*wait.until(ExpectedConditions.elementToBeClickable(salesUnitDropDown));
		soAssert.assertEquals(vals = driver.findElement(salesUnitDropDown).getText(),"16974760868091");
		System.out.println("++++++++++++++++++++++++++++++"+vals);*/
		
		wait.until(ExpectedConditions.elementToBeClickable(companyTxtBx));
		soAssert.assertEquals(vals = driver.findElement(companyTxtBx).getAttribute("value"),"MyCompany");
		
		
		wait.until(ExpectedConditions.elementToBeClickable(nicTxtBx));
		soAssert.assertEquals(vals = driver.findElement(nicTxtBx).getAttribute("value"),"12322458V");
		
		
		wait.until(ExpectedConditions.elementToBeClickable(designationTxtBx));
		soAssert.assertEquals(vals = driver.findElement(designationTxtBx).getAttribute("value"),"Team Leader");
		
		
		wait.until(ExpectedConditions.elementToBeClickable(emailTxtBx));
		soAssert.assertEquals(vals = driver.findElement(emailTxtBx).getAttribute("value"),"teamleader@slt.lk");
		
		
		wait.until(ExpectedConditions.elementToBeClickable(mobileTxtBxTwo));
		soAssert.assertEquals(vals = driver.findElement(mobileTxtBxTwo).getAttribute("value"),"0112147147");

		
			Reporter.log("values of selected lead appeared in the screen");
		soAssert.assertAll();
	}
}
