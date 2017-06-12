package SalesAndMarketing._04_leadInformation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class _04_01_LeadInfoModule {
	WebDriver driver;
	
	By leadInfoMod = By.xpath("//*[@id='header0']/li[5]");
	By newLeadInfoBtn = By.id("btnUpdate");
	
	
	public _04_01_LeadInfoModule(WebDriver driver){
		this.driver=driver;
	}
	
	public void LeadInfoModule(){
		this.navToLeadInforModule();
		this.newLeadInfo();
	}
	
	public void navToLeadInforModule(){
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.pollingEvery(40, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.elementToBeClickable(leadInfoMod));
		WebElement clickIt = driver.findElement(leadInfoMod);
		action.moveToElement(clickIt).click().build().perform();
	
	}
	
	public void newLeadInfo(){
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.elementToBeClickable(newLeadInfoBtn));
		WebElement clickIt = driver.findElement(newLeadInfoBtn);
		action.moveToElement(clickIt).click().build().perform();
	
	}

}
