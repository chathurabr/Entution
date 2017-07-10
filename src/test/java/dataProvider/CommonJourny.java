package dataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


/***************************************************************************************
 * 										This class contains 
 *
 *****************************************************************************************/
public class CommonJourny {
	 public static WebDriver driver;

	public static void informationMsgBox(){
		By informationMsgBox = By.xpath("//div[@class='dialogbox color-selectedborder ui-draggable first']");
			WebElement informationMsgBoxEle = driver.findElement(informationMsgBox);
		By informationMsgBoxOkBtn = By.xpath("//div[@class='dialogbox-buttonarea']/a");
		By informationMsgBoxGoTo = By.xpath("//div[@id='dlgAutoGenNotifications']/a");
		By informationMsgBoxCloseBtn = By.xpath("//span[@class='headerclose']");
			WebElement informationMsgBoxCloseBtnEle = driver.findElement(informationMsgBoxCloseBtn);

		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.pollingEvery(2,TimeUnit.SECONDS);

		wait.until(ExpectedConditions.visibilityOf(informationMsgBoxEle));
		wait.until(ExpectedConditions.visibilityOf(informationMsgBoxCloseBtnEle));
		informationMsgBoxCloseBtnEle.click();
			System.out.println("Information box closed");
	}
}
