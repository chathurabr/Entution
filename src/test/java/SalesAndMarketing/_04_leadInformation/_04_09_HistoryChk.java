package SalesAndMarketing._04_leadInformation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class _04_09_HistoryChk {
	WebDriver driver;
	By historyTableCol1 = By.xpath("//*[@id='ctrlActionHistory-t']/table/tbody/tr[1]");
	By historyTableCol2 = By.xpath("//*[@id='ctrlActionHistory-t']/table/tbody/tr[2]");
	
	public _04_09_HistoryChk(WebDriver driver){
		this.driver=driver;
	}
	
	public void HistoryChk(){
		this.checkHistory();
	}
	
	public void checkHistory(){
		WebDriverWait wait = new WebDriverWait(driver,50);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		//Name Title
		wait.until(ExpectedConditions.presenceOfElementLocated(historyTableCol1));
		
		wait.until(ExpectedConditions.presenceOfElementLocated(historyTableCol2));
		
	}
}
