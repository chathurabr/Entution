package SalesAndMarketing.entutionUtensils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;


public class ImageCapture {
//	WebDriver driver;
	//public WebDriver driver;
	
//	public ImageCapture(WebDriver driver){
//		this.driver=driver;
//	}
	
//	public void imageCaptureFunc(){
//		this.imageCapture();
//	}
	
	public static void imageCapture(WebDriver driver) throws Exception {
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(scrFile, new File("D:\\screenshot.png"));
	
}
}
