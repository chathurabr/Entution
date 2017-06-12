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

public class _04_02_VerifyMandatoryFields {
	WebDriver driver;

	//Asterisk
	By nameAstrx = By.xpath("//*[@id='divSecGenereal']/div[1]/table/tbody/tr[1]/td[1]/label");
	By mobileAstrx = By.xpath("//*[@id='divSecGenereal']/div[1]/table/tbody/tr[2]/td[1]/label");
	By saleUnitAstrx = By.xpath("//*[@id='divSecGenereal']/div[2]/table/tbody/tr[1]/td[1]/label");
	//Mandatory MsgBx
	By validatorMsgBoxText = By.xpath("//*[@id='validator']");
	By validatorMsgBoxCloseBtn = By.xpath("//*[@id='validator']/a/i");
	//Mandatory messages
	By nameTitleErrMsg = By.xpath("//*[@id='divSecGenereal']/div[1]/table/tbody/tr[1]/td[2]/div/label");
	By nameErrMsgOne = By.xpath("//*[@id='divSecGenereal']/div[1]/table/tbody/tr[1]/td[3]/div/label[1]");
	By nameErrMsgTwo = By.xpath("//*[@id='divSecGenereal']/div[1]/table/tbody/tr[2]/td[2]/div/label");
	By salesUnitErrMsg = By.xpath("//*[@id='divSecGenereal']/div[2]/table/tbody/tr[1]/td[2]/div[2]/label");
	
	
public 	_04_02_VerifyMandatoryFields(WebDriver driver){
	this.driver=driver;
}

public void VerifyMandatoryFields(){
	this.validatorMsgBx();
	this.checkAstrix();
	this.chkMandatoryMsgs();
}

public void validatorMsgBx(){
	SoftAssert soAssert = new SoftAssert();
	Actions action = new Actions(driver);
	
	WebDriverWait wait = new WebDriverWait(driver,40);
	wait.pollingEvery(30, TimeUnit.SECONDS);
	
	//wait.until(ExpectedConditions.presenceOfElementLocated(draftBtn));
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(validatorMsgBoxText));
	soAssert.assertEquals(driver.findElement(validatorMsgBoxText).getText(),"ERROR : Review all error messages below to correct your data.");
	
	
	wait.until(ExpectedConditions.elementToBeClickable(validatorMsgBoxCloseBtn));
	WebElement clickIt = driver.findElement(validatorMsgBoxCloseBtn);
	action.moveToElement(clickIt).click().build().perform();
	
	soAssert.assertAll();
}

public void checkAstrix(){
	WebDriverWait wait = new WebDriverWait(driver,40);
	wait.pollingEvery(30, TimeUnit.SECONDS);
	
	wait.until(ExpectedConditions.presenceOfElementLocated(nameAstrx));
	driver.findElement(nameAstrx).isDisplayed();
	
	wait.until(ExpectedConditions.presenceOfElementLocated(mobileAstrx));
	driver.findElement(mobileAstrx).isDisplayed();
	
	wait.until(ExpectedConditions.presenceOfElementLocated(saleUnitAstrx));
	driver.findElement(saleUnitAstrx).isDisplayed();
}

public void chkMandatoryMsgs(){
	WebDriverWait wait = new WebDriverWait(driver,40);
	wait.pollingEvery(30, TimeUnit.SECONDS);
	
	wait.until(ExpectedConditions.presenceOfElementLocated(nameTitleErrMsg));
	driver.findElement(nameTitleErrMsg).isDisplayed();
	
	wait.until(ExpectedConditions.presenceOfElementLocated(nameErrMsgOne));
	driver.findElement(nameErrMsgOne).isDisplayed();
	
	wait.until(ExpectedConditions.presenceOfElementLocated(nameErrMsgTwo));
	driver.findElement(nameErrMsgTwo).isDisplayed();
	
	wait.until(ExpectedConditions.presenceOfElementLocated(salesUnitErrMsg));
	driver.findElement(salesUnitErrMsg).isDisplayed();
			Reporter.log("Mandatory field error messages poped up");
}

}
