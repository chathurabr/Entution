package SalesAndMarketing._05_SalesInquiry;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.util.concurrent.TimeUnit;

public class _05_07_TagSalesInquiryToAccount {
	WebDriver driver;
	By leadAccDropdown = By.id("cboxAgainst");
	By leadAcSearchIcon = By.xpath("//*[@id='divGeneral']/div[1]/div[1]/table/tbody/tr[1]/td[2]/div/span[2]/span");
	//PopUp							
	By leadAcSearchPop = By.id("d1011");
	By popUpTxtBx = By.id("txtg1012");
	By colOne = By.xpath("//*[@id='g1012-t']/table/tbody/tr[1]");
	
	By inquiryAbout = By.id("txtOppName");
	By inqCategoryDD = By.id("cboxCategory");
	By inquiryOrigin = By.id("cboxOrigin");
	By budgetDropDown = By.id("cboxAmount");
	By budgetTxtBx = By.id("txtAmount");
	By salesInqDesc = By.id("txtDesc");
	
	By sendNotifiChkBox = By.id("chkEmail");
	By responEmpSrchBtn = By.xpath("//*[@id='divGeneral']/div[1]/div[2]/table/tbody/tr[3]/td[2]/div/span[1]/span");
	//Employee popup
	By empSrchTextBox = By.id("txtg1002");
	By EmpcolOne = By.xpath("//*[@id='g1002-t']/table/tbody/tr");
	
	public _05_07_TagSalesInquiryToAccount(WebDriver driver){
		this.driver=driver;
	}
	
	public void TagSalesInquiryToAccount(String inqAboutText,String budgetamount,String description,String employeeName){
		this.selectAccount(inqAboutText, budgetamount, description, employeeName);
	}
	
	public void selectAccount(String inqAboutText, String budgetamount, String description, String employeeName){
		Actions action = new Actions(driver);
		
        WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(2, TimeUnit.SECONDS);
		
		Select Leaddropdown = new Select(driver.findElement(leadAccDropdown));
		Leaddropdown.selectByVisibleText("Account");
		Reporter.log("Account option selected successfully");
		///
		wait.until(ExpectedConditions.elementToBeClickable(leadAcSearchIcon));
		WebElement leadSrchicn = driver.findElement(leadAcSearchIcon);
		action.moveToElement(leadSrchicn).click().build().perform();
		
			wait.until(ExpectedConditions.presenceOfElementLocated(leadAcSearchPop));
		
			wait.until(ExpectedConditions.elementToBeClickable(popUpTxtBx));
			WebElement srchTxtBx = driver.findElement(popUpTxtBx);
			action.moveToElement(srchTxtBx).click().build().perform();
			action.moveToElement(srchTxtBx).sendKeys(Keys.ENTER).build().perform();
		
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			wait.until(ExpectedConditions.elementToBeClickable(colOne));
			WebElement coOnedblclk = driver.findElement(colOne);
			action.moveToElement(coOnedblclk).doubleClick().build().perform();
		
		wait.until(ExpectedConditions.elementToBeClickable(inquiryAbout));
		WebElement inqAbt = driver.findElement(inquiryAbout);
		action.moveToElement(inqAbt).click().build().perform();
		action.moveToElement(inqAbt).sendKeys(inqAboutText).build().perform();
		
		wait.until(ExpectedConditions.elementToBeClickable(inqCategoryDD));
		Select categorydropdown = new Select(driver.findElement(inqCategoryDD));
		categorydropdown.selectByVisibleText("Samsung");
		
		Select origindropdown = new Select(driver.findElement(inquiryOrigin));
		origindropdown.selectByVisibleText("Newspaper");
		
		Select budgetdrpdwn = new Select(driver.findElement(budgetDropDown));
		budgetdrpdwn.selectByVisibleText("LKR");
		
		wait.until(ExpectedConditions.elementToBeClickable(budgetTxtBx));
		WebElement budjTxtBx = driver.findElement(budgetTxtBx);
		action.moveToElement(budjTxtBx).click().build().perform();
		action.moveToElement(budjTxtBx).sendKeys(budgetamount).build().perform();
		
		wait.until(ExpectedConditions.elementToBeClickable(salesInqDesc));
		WebElement desc = driver.findElement(salesInqDesc);		
		action.moveToElement(desc).click().build().perform();
		action.moveToElement(desc).sendKeys(description).build().perform();
		
		wait.until(ExpectedConditions.elementToBeClickable(sendNotifiChkBox));
		WebElement chkBox = driver.findElement(sendNotifiChkBox);
		action.moveToElement(chkBox).click().build().perform();
			Reporter.log("Clicked on the checkbox successfully");
		
		wait.until(ExpectedConditions.elementToBeClickable(responEmpSrchBtn));
		WebElement empSrchBtn = driver.findElement(responEmpSrchBtn);
		action.moveToElement(empSrchBtn).click().build().perform();
		
			wait.until(ExpectedConditions.elementToBeClickable(empSrchTextBox));
			WebElement empSrchTxt = driver.findElement(empSrchTextBox);
			action.moveToElement(empSrchTxt).click().build().perform();
			action.moveToElement(empSrchTxt).sendKeys(employeeName).build().perform();
			action.moveToElement(empSrchTxt).sendKeys(Keys.ENTER).build().perform();
			
			wait.until(ExpectedConditions.elementToBeClickable(EmpcolOne));
			WebElement colOneDblClk = driver.findElement(EmpcolOne);
			action.moveToElement(colOneDblClk).doubleClick().build().perform();
	}
}
