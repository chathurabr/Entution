package SalesAndMarketing._01_Common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestTestNuwan {
	WebDriver driver;
	By invenAndWareHouse = By.xpath("/html/body/div[1]/div[3]/div/ul/li[6]");
	By productInfoModule = By.xpath("//*[@id='header0']/li[2]");
	
	public TestTestNuwan(WebDriver driver){
		this.driver=driver;
	}
	
	public void TestNuwan(){
		this.naviTo();
	}
	
	public void naviTo(){
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.elementToBeClickable(invenAndWareHouse));
		driver.findElement(invenAndWareHouse).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(productInfoModule));
		driver.findElement(productInfoModule).click();
	}

}
