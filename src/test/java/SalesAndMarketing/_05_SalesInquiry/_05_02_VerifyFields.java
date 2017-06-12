package SalesAndMarketing._05_SalesInquiry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.util.concurrent.TimeUnit;

public class _05_02_VerifyFields {
	WebDriver driver;
	By leadAccDropdown = By.id("cboxAgainst");
	By leadLiItem = By.xpath("//*[@id='cboxAgainst']/option[1]");
	By accLiItem =  By.xpath("//*[@id='cboxAgainst']/option[2]");
	By leadAcSearchIcon = By.xpath("//*[@id='divGeneral']/div[1]/div[1]/table/tbody/tr[1]/td[2]/div/span[2]/span");
	By inquiryAbout = By.id("txtOppName");
	By inquiryOrigin = By.id("cboxOrigin");
	By salesUnit = By.id("cboxSalesUnitPerson");
	By AccountOwner = By.id("cboxAccountOwner");
	By priority = By.id("cboxPriority");
	
	public _05_02_VerifyFields(WebDriver driver){
		this.driver=driver;
		this.VerifyFields();
	}
	
	public void VerifyFields(){
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(2, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(leadAccDropdown));
		wait.until(ExpectedConditions.presenceOfElementLocated(leadLiItem));
		wait.until(ExpectedConditions.presenceOfElementLocated(accLiItem));
		wait.until(ExpectedConditions.presenceOfElementLocated(inquiryAbout));
		wait.until(ExpectedConditions.presenceOfElementLocated(inquiryOrigin));
		wait.until(ExpectedConditions.presenceOfElementLocated(salesUnit));
		wait.until(ExpectedConditions.presenceOfElementLocated(AccountOwner));
		wait.until(ExpectedConditions.presenceOfElementLocated(priority));
		
			Reporter.log("All the fields displayed under sales inquiry page");
	}

}
