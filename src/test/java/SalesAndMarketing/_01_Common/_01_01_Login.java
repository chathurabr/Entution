package SalesAndMarketing._01_Common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.util.concurrent.TimeUnit;

//Test case 01.01
public class _01_01_Login {

	WebDriver driver;
	By txtBoxUsername = By.id("txtUserName");
	By txtBoxPassword = By.id("txtPassword");
	By btnLogin = By.id("btnLogin");
	By logoEntution = By.id("homelink");
	
		
	public _01_01_Login(WebDriver driver){
		this.driver=driver;
		
	}
	
	public void EntutionLogin(String uname, String passwd){
		
		this.enterUsername(uname);
		this.enterPassword(passwd);
		this.clkOnLogin();
		this.loginConfirmation();
		
	}
	
	public void enterUsername(String uname) {
		
		
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.presenceOfElementLocated(txtBoxUsername));
		
		
		//Assert.assertEquals("UserName", driver.findElement(txtBoxUsername).getText());
		
		driver.findElement(txtBoxUsername).sendKeys(uname);
		Reporter.log("Username Entered successfully");
		
	}
	
	
	public void enterPassword(String passwd){
		
		
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.presenceOfElementLocated(txtBoxPassword));
		driver.findElement(txtBoxPassword).sendKeys(passwd);
		Reporter.log("Password Entered Successfully");
		
	}
	
	public void clkOnLogin() {
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.presenceOfElementLocated(btnLogin));
		driver.findElement(btnLogin).click();
		Reporter.log("Login button clicked");
		
	}
	
	public void loginConfirmation(){
		try{
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.presenceOfElementLocated(logoEntution));
		//driver.findElement(logoEntution).getText();
		Reporter.log("Entution logo appeared");
		}catch(Exception e){
			Reporter.log("Entution logo not found");
		}
		finally{
			System.out.println("Entution logo confirmation function");
		}
	}
}
