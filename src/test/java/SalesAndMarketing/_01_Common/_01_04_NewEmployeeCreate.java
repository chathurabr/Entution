package SalesAndMarketing._01_Common;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.testng.Assert;
//import org.testng.AssertJUnit;

public class _01_04_NewEmployeeCreate {
	WebDriver driver;
	By modOrganizationMng = By.xpath("/html/body/div[1]/div[3]/div/ul/li[2]");
	By modEmpInfo = By.linkText("Employee Information");//("//*[@id='header0']/li[2]/a[1]");
	By headPageName = By.id("spPageName");////*[@id='spPageName'] - id - spPageName
	By btnNewEmployee = By.id("btnUpdate");//("button pull-right margin-0");//("//*[@id='btnUpdate0']]");		//Identification issue				//("btnUpdate");
	By lblHeader = By.id("lblTemplateFormHeader");								//Employee information - New

	By txtEmployeeCode = By.id("txtEmpCode");
	By txtBoxEmpNo = By.id("txtEmpNo");
	By listName = By.id("cboxTitle");
	By listNameMs = By.xpath("//*[@id='cboxTitle']/option[2]");
	By txtBoxFullName = By.id("txtFullName");
	By txtBoxInitials = By.id("txtInitials");
	By cboxEmpCategory = By.id("cboxEmpCategory");// done
	By cboxEmpCatOption1	= By.xpath("//*[@id='cboxEmpCategory']/option[4]");//D
	By cboxDesig = By.id("cboxDesig");//D
	By cBocDesigQAManager = By.xpath("//*[@id='cboxDesig']/option[16]");//D

	//<Search User Code>
	By SearchUserCOde = By.xpath("//*[@id='divgen']/div[1]/div[2]/table/tbody/tr[6]/td[2]/div/span[2]");//D

	By refreshButton = By.xpath("//*[@id='g1015']/div[1]/span[1]/span[2]");
	By userTable = By.id("g1015-t");
	// Select a user - SELECT COMMAND
	By SelectUser = By.xpath("//*[@id='g1015-t']/table/tbody/tr[1]"); 
	//</Search User Code>
	//<Address Info - Home>
		//Select country id -
	By SelectCountryHme = By.id("divAddressCont-16922535787993-1");
	//SriLanka
	By SelectCountryHome = By.xpath("//*[@id='divAddressCont-16922535787993-1']/option[206]");
		//Number
	By txtBoxAdrsNumbHme = By.id("divAddressCont-16922535787993-2");
		//City- 
	By txtBoxCityHme = By.id("divAddressCont-16922535787993-4");
	//<Address Info - Office
	By tabOfficeAdrs = By.id("#divAddressCont-16922635787993");
		//Select country dropdown
	By SelectCountryOfice = By.id("divAddressCont-16922635787993-1");
		//Select australia
	By SelectAustralia = By.xpath("//*[@id='divAddressCont-16922635787993-1']/option[15]");
		//Number
	By txtBoxAdrsNumbOfice = By.id("divAddressCont-16922635787993-2");
		//City
	By txtBoxCityOfice = By.id("divAddressCont-16922635787993-4") ;
	//</Address Info - Office>
	
	//Draft, Edit, Update
	By lblDocSatusReleased = By.id("lbldocstatus"); //(Released)
	
	public _01_04_NewEmployeeCreate(WebDriver driver){
		this.driver = driver;
	}
	
	public void NewEmployeeCreate(String EmpCode,String uNumber,String fullName, String nameInitials, String houseNo, String houseCity, String oficeNo, String officeCity ){
		this.openOrgMamagamentModule();
		this.openEmpInfoModule();
		this.newEmployeeWindow();
		this.enterEmpDetails(EmpCode,uNumber,fullName,nameInitials);
		this.searchUserCode();
		this.selectUserCode();
		this.instHomeAddress(houseNo, houseCity);
		this.instOfficeAddress(oficeNo, officeCity);
		
		this.checkEmpStatus();
	}
	
	public void openOrgMamagamentModule(){

			WebDriverWait wait = new WebDriverWait(driver,40);
			wait.pollingEvery(10, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.presenceOfElementLocated(modOrganizationMng));

			List<WebElement> li = driver.findElements(By.tagName("li"));

			for(int i=0;i<li.size();i++){

				String lala = li.get(i).getText();
					if(lala.equals("ORGANIZATION MANAGEMENT")){
						Actions action = new Actions(driver);
						action.moveToElement(li.get(i)).click().build().perform();
						Reporter.log("Organization Management module tab opened");
				}else{
			}

		}

	}
	
	public void openEmpInfoModule(){

			WebDriverWait wait = new WebDriverWait(driver,40);
			wait.pollingEvery(30, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.presenceOfElementLocated(modEmpInfo));
			//driver.manage()wait.withTimeout(duration, unit);
			driver.findElement(modEmpInfo).click();
				Reporter.log("Clicked on Employee Information tab and Employee Information loaded");
	}
	
	public void newEmployeeWindow() {
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(btnNewEmployee));
		driver.findElement(btnNewEmployee).click();
		
		Reporter.log("New Employee button clicked");
		Reporter.log("New Employee window loaded");
		//wait.pollingEvery(30, TimeUnit.SECONDS);
		//wait.until(ExpectedConditions.elementToBeClickable(headPageName));
	}
	
	public void enterEmpDetails (String EmpCode, String uNumber, String fullName, String nameInitials){
		//EMp Number
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(30, TimeUnit.SECONDS);

		WebElement empCode = driver.findElement(txtEmployeeCode);
		action.moveToElement(empCode).click().sendKeys(EmpCode).build().perform();

			wait.until(ExpectedConditions.elementToBeClickable(txtBoxEmpNo));
			driver.findElement(txtBoxEmpNo).click();
			driver.findElement(txtBoxEmpNo).sendKeys(uNumber);
			
			Reporter.log("Employee Number Entered");
		//EMp Name Title

			wait.until(ExpectedConditions.elementToBeClickable(listName));
			driver.findElement(listName).click();
			wait.until(ExpectedConditions.presenceOfElementLocated(listNameMs));
			driver.findElement(listNameMs).click();
			Reporter.log("Employee titl selected");

		//Emp Name

			wait.until(ExpectedConditions.presenceOfElementLocated(txtBoxFullName));
			driver.findElement(txtBoxFullName).click();
			driver.findElement(txtBoxFullName).sendKeys(fullName);
			Reporter.log("Employee full name entered");

		//Emp Name With Initials

			wait.until(ExpectedConditions.presenceOfElementLocated(txtBoxInitials));
			driver.findElement(txtBoxInitials).click();
			driver.findElement(txtBoxInitials).sendKeys(nameInitials);
			Reporter.log("Name with initials entered");
		//cboxEmpCategory

			wait.until(ExpectedConditions.presenceOfElementLocated(cboxEmpCategory));
			driver.findElement(cboxEmpCategory).click();
			wait.until(ExpectedConditions.presenceOfElementLocated(cboxEmpCatOption1));
			driver.findElement(cboxEmpCatOption1).click();
			Reporter.log("Employee Category Selected");

		//Designations cboxDesig

			wait.until(ExpectedConditions.presenceOfElementLocated(cboxDesig));
			driver.findElement(cboxDesig).click();
			wait.until(ExpectedConditions.presenceOfElementLocated(cBocDesigQAManager));
			driver.findElement(cBocDesigQAManager).click();
			Reporter.log("Designation Selected");
		
	}
	
	//User code - SearchUserCOde
	public void searchUserCode(){
		//Click on the b
			WebDriverWait wait = new WebDriverWait(driver,40);
			wait.pollingEvery(30, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.presenceOfElementLocated(SearchUserCOde));
			driver.findElement(SearchUserCOde).click();
			Reporter.log("Search Employee Code button clicked");
		
		
			wait.until(ExpectedConditions.elementToBeClickable(refreshButton));
			//driver.findElement(refreshButton).click();
			
			WebElement refreshBtnElement = driver.findElement(refreshButton);
			Actions actionClickbtn = new Actions(driver);
			actionClickbtn.moveToElement(refreshBtnElement).click().perform();


			//WebElement element = driver.findElement(By("element_path"));
			//Actions actions = new Actions(driver);
			//actions.moveToElement(refreshButton).click().perform();
			
			
			wait.until(ExpectedConditions.presenceOfElementLocated(userTable));
			

		
	}
	
	public void selectUserCode(){
		
			WebDriverWait wait = new WebDriverWait(driver,40);
			wait.pollingEvery(30, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.elementToBeClickable(SelectUser));
			//driver.findElement(SelectUser).click();


			
			WebElement dbClick = driver.findElement(By.xpath("//*[@id='g1015-t']/table/tbody/tr[1]"));
			Actions action = new Actions(driver);
			action.doubleClick(dbClick);
			action.perform();
			
			Reporter.log("User selected succesfully");
	
	}
	
	public void instHomeAddress(String houseNo, String houseCity){
		//country list
		
			WebDriverWait wait = new WebDriverWait(driver,40);
			wait.pollingEvery(30, TimeUnit.SECONDS);
			
			wait.until(ExpectedConditions.presenceOfElementLocated(SelectCountryHme));
			driver.findElement(SelectCountryHme).click();
			Reporter.log("County list expanded");
		//country select
			wait.until(ExpectedConditions.elementToBeClickable(SelectCountryHome));
			driver.findElement(SelectCountryHome).click();
			Reporter.log("County selected");
		//building No
			wait.until(ExpectedConditions.elementToBeClickable(txtBoxAdrsNumbHme));
			driver.findElement(txtBoxAdrsNumbHme).click();
			driver.findElement(txtBoxAdrsNumbHme).sendKeys(houseNo);
		//City Name
			wait.until(ExpectedConditions.elementToBeClickable(txtBoxCityHme));
			driver.findElement(txtBoxCityHme).click();
			driver.findElement(txtBoxCityHme).sendKeys(houseCity);
	}
	
	public void instOfficeAddress(String oficeNo, String officeCity){
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.elementToBeClickable(tabOfficeAdrs));
		driver.findElement(tabOfficeAdrs).click();
		//country select dropdown
		wait.until(ExpectedConditions.elementToBeClickable(SelectCountryOfice));
		driver.findElement(SelectCountryOfice).click();
		Reporter.log("County selected");
		//Select australia SelectAustralia
		wait.until(ExpectedConditions.elementToBeClickable(SelectAustralia));
		driver.findElement(SelectAustralia).click();
		//building No
		wait.until(ExpectedConditions.elementToBeClickable(txtBoxAdrsNumbOfice));
		driver.findElement(txtBoxAdrsNumbOfice).click();
		driver.findElement(txtBoxAdrsNumbOfice).sendKeys(oficeNo);
		//City Select
		wait.until(ExpectedConditions.elementToBeClickable(txtBoxCityOfice));
		driver.findElement(txtBoxCityOfice).click();
		driver.findElement(txtBoxCityOfice).sendKeys(officeCity);
		//driver.findElement(txtBoxCityOfice).sendKeys(Keys.RETURN);
		
	}

	public void checkEmpStatus(){
		SoftAssert soAssertion = new SoftAssert();
		
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(lblDocSatusReleased));
		
		soAssertion.assertEquals("(Released)", driver.findElement(lblDocSatusReleased).getText());
		Reporter.log("Header marked as released");

	}
}
