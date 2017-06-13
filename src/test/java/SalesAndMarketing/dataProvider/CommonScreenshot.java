package SalesAndMarketing.dataProvider;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/***************************************************************************************
 * 										This class contains 
 *					Screenshot snap 
 *					
 *														
 *****************************************************************************************/
public class CommonScreenshot extends CommonClass {
	//public static WebDriver driver;
	static WebDriver wdd = CommonClass.driver;
		
		public static WebDriver takeSnapshot (ITestResult testResult) throws IOException{
			
		
			if (testResult.getStatus() == ITestResult.FAILURE) {
			//	System.out.println(testResult.getStatus());
				File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File("C://Screenshots//" + testResult.getName() + "-" + Arrays.toString(testResult.getParameters()) +  ".jpg"));
			  
			}
			return wdd;
		}
}
