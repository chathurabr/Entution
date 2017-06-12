package SalesAndMarketing.dataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/***************************************************************************************
 * 										This class contains 
 *					Action Dropdown, History
 *					Convert to Account
 *														
 *****************************************************************************************/
public class CommonClassDatePicker extends CommonClass {
	//public static WebDriver driver;
	static WebDriver wdd = CommonClass.driver;
	
			
		public static WebDriver DatePicker(String yearComesHere,String monthComesHere,String dayNumber){

			Actions action = new Actions(driver);
			WebDriverWait wait = new WebDriverWait(driver,40);
			wait.pollingEvery(30, TimeUnit.SECONDS);
			
			//Calender pop up
			wait.until(ExpectedConditions.elementToBeClickable(By.id("ui-datepicker-div")));
			
			//Select Year
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ui-datepicker-div']/div/div/select[2]")));	
			Select yearPicker = new Select(driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div/select[2]")));
			yearPicker.selectByVisibleText(yearComesHere);
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//Select Month
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ui-datepicker-div']/div/div/select[1]")));	
			Select monthPicker = new Select(driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div/select[1]")));
			monthPicker.selectByVisibleText(monthComesHere);
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//Select Day
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ui-datepicker-div']/table/tbody")));
				
				List <WebElement> trList = driver.findElements(By.xpath("//*[@id='ui-datepicker-div']/table/tbody"));
							
					for(int i=0;i<trList.size();i++){
						String tdLi = trList.get(i).getText();
							System.out.println("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD----"+tdLi);
							
							if(tdLi.equals(dayNumber)){
								trList.get(i).click();
								//action.moveToElement(trList.get(i)).doubleClick().build().perform();
							}	
					}
			
			return wdd;
		}
		

}
