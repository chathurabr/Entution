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

import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.testng.Assert;
//import org.testng.AssertJUnit;

public class _01_04_NewEmployeeCreate {
	WebDriver driver;
	By modOrganizationMng = By.xpath("/html/body/div[1]/div[3]/div/ul/li[2]/a/label");
	By modEmpInfo = By.linkText("Employee Information");//("//*[@id='header0']/li[2]/a[1]");
	By headPageName = By.id("spPageName");////*[@id='spPageName'] - id - spPageName
	By btnNewEmployee = By.id("btnUpdate");//("button pull-right margin-0");//("//*[@id='btnUpdate0']]");		//Identification issue				//("btnUpdate");
	By lblHeader = By.id("lblTemplateFormHeader");								//Employee information - New
	
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
	By formNameUser = By.xpath("/html/body/div[7]/div[1]/span[1]");//D
	//By filterListId = By.id("filterListId");//D
	//By filterList1	= By.xpath("//*[@id='filterListId']/option[1]");
	//By SearchUser = By.id("A17");
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
	By btnDraft = By.xpath("//*[@id='permissionBar']/a[1]");
	By lbldocstatus	= By.id("lbldocstatus");
	By btnEdit = By.xpath("//*[@id='permissionBar']/a[1]");
	By btnUpdate = By.xpath("//*[@id='permissionBar']/a[1]");
	By btnRelease= By.xpath("//*[@id='permissionBar']/a[2]");
	By lblDocSatusReleased = By.id("lbldocstatus"); //(Released)
	By statusDropDown = By.xpath("//*[@id='lnkTeplateStatus']/span");
	By cboxStatus = By.id("cboxselect"); //
	
	public _01_04_NewEmployeeCreate(WebDriver driver){
		this.driver = driver;
	}
	
	public void NewEmployeeCreate(String uNumber,String fullName, String nameInitials, String houseNo, String houseCity, String oficeNo, String officeCity ){
		this.openOrgMamagamentModule();
		this.openEmpInfoModule();
		//this.chkEmpInfoPage();
		this.newEmployeeWindow();
		this.enterEmpDetails(uNumber,fullName,nameInitials);
		this.searchUserCode();
		this.selectUserCode();
		this.instHomeAddress(houseNo, houseCity);
		this.instOfficeAddress(oficeNo, officeCity);
		
		//this.editEmployee(fullName, nameInitials, uNumber);
		
		this.checkEmpStatus();
	}
	
	public void openOrgMamagamentModule(){
		try{
			WebDriverWait wait = new WebDriverWait(driver,40);
			wait.pollingEvery(30, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.presenceOfElementLocated(modOrganizationMng));
			driver.findElement(modOrganizationMng).click();
				Reporter.log("Oranization Management module tab opened");
				
				String modName = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/ul/li[2]/a/label")).getText();
				/*if(modName == "ORGANIZATION MANAGEMENT"){
					Reporter.log("Correct module name");
				}
				else{*/
				//soft
				/*SoftAssert softAst = new SoftAssert();
				
				softAst.assertEquals(modName,"ORGANIZATION MANAGEMENT","<font color ='red'>Organization Management module tab cannot open</font>");
				String allertText = driver.switchTo().alert().getText();
				
				driver.switchTo().alert().accept();
				softAst.assertEquals(allertText,"ORGANIZATION MANAGEMENT","<font color ='red'>Organization Management module tab cannot open Allert text</font>");
				Reporter.log("Test"+ allertText + modName);
				softAst.fail();
				softAst.assertAll();*/
				//Hard
				AssertJUnit.assertEquals("ORGANIZATION MANAGEMENT", modName);
				/*another way
				//Assert.assertEquals("Wrong error message shown", "Please Enter Valid Email", driver.findElement(By.xpath("Your path of element")).getText());*/
				
			}
				catch(AssertionError e){
				Reporter.log("<font color ='red'>Organization Management module Element Incorrect spelings</font>");
				}
				catch(TimeoutException tE){
				Reporter.log("<font color ='red'>Organization Management module tab cannot open -Timeout exception</font>");
			}
			
		finally{}
	}
	
	public void openEmpInfoModule(){
		try{
			WebDriverWait wait = new WebDriverWait(driver,40);
			wait.pollingEvery(30, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.presenceOfElementLocated(modEmpInfo));
			//driver.manage()wait.withTimeout(duration, unit);
			driver.findElement(modEmpInfo).click();
				Reporter.log("Clicked on Employee Information tab and Employee Information loaded");
			
		}catch(TimeoutException e){
				Reporter.log("<font color='red'>Organization Management module not loaded - exception</font>");
			}finally{}
	}
	
	/*public void chkEmpInfoPage(){
		try{
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			
			WebDriverWait wait = new WebDriverWait(driver,40);
			wait.until(ExpectedConditions.elementToBeClickable(headPageName));
			
			String pageName = driver.findElement(By.id("spPageName")).getText();
			//String pageURL = driver.getCurrentUrl();
			
			if(pageName == "Employee Information"){
				Reporter.log("Employee Information page loaded");
				}
			else{
				Reporter.log("<font color ='red'>Employee Information page label not found</font>");
			}
			}
			catch(Exception e){
				Reporter.log("<font color ='red'>Employee Information page label not found - Exception</font>");
			}finally{}
			}*/
			
			
			/*String btnName =driver.findElement(btnNewEmployee).getText();
			AssertJUnit.assertEquals("New Employee", btnName);
			
			if(btnName == "New Employee"){
				Reporter.log("Employee Information page loaded");
			}
			else{
				AssertJUnit.assertEquals("http://192.168.80.26/Web/common/search/default.aspx?id=1002", pageURL);
				System.out.println("URLLLL"+btnName);
				Reporter.log("<font color = 'blue'>elese etatement executed</font>");
			}
			
			}catch(NoSuchElementException e){
				Reporter.log("<font color = 'red'>Employee Information page cannot load Exception handling error</font>");
			}*/
			
	
	public void newEmployeeWindow() {
		try{
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(btnNewEmployee));
		driver.findElement(btnNewEmployee).click();
		
		Reporter.log("New Employee button clicked");
		Reporter.log("New Employee window loaded");
		//wait.pollingEvery(30, TimeUnit.SECONDS);
		//wait.until(ExpectedConditions.elementToBeClickable(headPageName));
		}catch(Exception e){
			Reporter.log("New Employee window not loaded - exception");
		}
		finally{}
	}
	
	public void enterEmpDetails (String uNumber, String fullName, String nameInitials){
		//EMp Number
		try{
			WebDriverWait wait = new WebDriverWait(driver,40);
			wait.pollingEvery(30, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.elementToBeClickable(txtBoxEmpNo));
			driver.findElement(txtBoxEmpNo).click();
			driver.findElement(txtBoxEmpNo).sendKeys(uNumber);
			
			Reporter.log("Employee Number Entered");
			
		}catch(Exception e){
			Reporter.log("<font color='red'>Employee number cannot enter</font>");
		}
		//EMp Name Title
		try{
			WebDriverWait wait = new WebDriverWait(driver,40);
			wait.pollingEvery(30, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.elementToBeClickable(listName));
			driver.findElement(listName).click();
			wait.until(ExpectedConditions.presenceOfElementLocated(listNameMs));
			driver.findElement(listNameMs).click();
			Reporter.log("Employee titl selected");
		}catch(Exception e){
			Reporter.log("<font color='red'>Employee title cannot select</font>");
		}
		//Emp Name
		try{
			WebDriverWait wait= new WebDriverWait(driver,40);
			wait.pollingEvery(30, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.presenceOfElementLocated(txtBoxFullName));
			driver.findElement(txtBoxFullName).click();
			driver.findElement(txtBoxFullName).sendKeys(fullName);
			Reporter.log("Employee full name entered");
		}catch(Exception e){
			Reporter.log("<font color='red'>Employee full name cannot enter</font>");
		}
		//Emp Name With Initials
		try{
			WebDriverWait wait = new WebDriverWait(driver,40);
			wait.pollingEvery(30, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.presenceOfElementLocated(txtBoxInitials));
			driver.findElement(txtBoxInitials).click();
			driver.findElement(txtBoxInitials).sendKeys(nameInitials);
			Reporter.log("Name with initials entered");
		}catch(Exception e){
			Reporter.log("<font color='red'>NAme wth nitials cannot enter</font>");
		}
		//cboxEmpCategory
		try{
			WebDriverWait wait = new WebDriverWait(driver,40);
			wait.pollingEvery(30, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.presenceOfElementLocated(cboxEmpCategory));
			driver.findElement(cboxEmpCategory).click();
			wait.until(ExpectedConditions.presenceOfElementLocated(cboxEmpCatOption1));
			driver.findElement(cboxEmpCatOption1).click();
			Reporter.log("Employee Category Selected");
			
		}catch(Exception e){
			Reporter.log("<font color='red'>Employee category cannot select</font>");
		}
		//Designations cboxDesig
		try{
			WebDriverWait wait = new WebDriverWait(driver,40);
			wait.pollingEvery(30, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.presenceOfElementLocated(cboxDesig));
			driver.findElement(cboxDesig).click();
			wait.until(ExpectedConditions.presenceOfElementLocated(cBocDesigQAManager));
			driver.findElement(cBocDesigQAManager).click();
			Reporter.log("Designation Selected");
			
		}catch(Exception e){
			Reporter.log("<font color='red'>Designation cannot select</font>");
		}
		finally{}
		
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
			
		
	/*	try{
			WebDriverWait wait = new WebDriverWait(driver,40);
			wait.pollingEvery(30, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.presenceOfElementLocated(formNameUser));
			Reporter.log("User form loaded");
		}catch(Exception e){
			Reporter.log("<font color='red'>User form cannot load</font>");
		}*/
		
		/*try{
			WebDriverWait wait = new WebDriverWait(driver,40);
			wait.pollingEvery(30, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.presenceOfElementLocated(filterListId));
			driver.findElement(filterListId).click();
			wait.until(ExpectedConditions.presenceOfElementLocated(filterList1));
			driver.findElement(filterList1).click();
			Reporter.log("Template (All) Selected");
		}catch(Exception e){
			Reporter.log("<font color='red'>Template (All) canot select</font>");
		}
		try{
			WebDriverWait wait = new WebDriverWait(driver,40);
			wait.pollingEvery(30, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.elementToBeClickable(SearchUser));
			driver.findElement(SearchUser).click();
			Reporter.log("Clicked on search user button");
			wait.until(ExpectedConditions.presenceOfElementLocated(userTable));
			
		}catch(Exception e){
			Reporter.log("<font color='red'>Search user btton cannot visible</font>");
		}*/
		
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
	//---------------------------------------------------------------------------------------------------
	/*public boolean retryingFindClick(By by) {
        boolean result = false;
        int attempts = 0;

        while(attempts < 2) {
            try {
                driver.findElement(by).click();
                result = true;
                break;
            } catch(StaleElementReferenceException e) {
            }
            attempts++;
        }
        return result;
}*/
//-------------------------------------------------------------------------------------------------------

	
	public void checkEmpStatus(){
		SoftAssert soAssertion = new SoftAssert();
		
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(lblDocSatusReleased));
		
		soAssertion.assertEquals("(Released)", driver.findElement(lblDocSatusReleased).getText());
		Reporter.log("Header marked as released");
		
		//wait.until(ExpectedConditions.elementToBeClickable(statusDropDown));
		//driver.findElement(statusDropDown).click();
		//Assert.assertEquals("", driver.findElement(cboxStatus).getText());
		//Reporter.log("Status marked as Active");
	}
	
	/*public void clearEmployeeDetails(){
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.elementToBeClickable(txtBoxEmpNo));
		driver.findElement(txtBoxEmpNo).clear();
		
		wait.until(ExpectedConditions.elementToBeClickable(listName));
		driver.findElement(listName).clear();
		
		wait.until(ExpectedConditions.elementToBeClickable(listNameMs));
		driver.findElement(listNameMs).clear();
		
		wait.until(ExpectedConditions.elementToBeClickable(txtBoxFullName));
		driver.findElement(txtBoxFullName).clear();
		
		wait.until(ExpectedConditions.elementToBeClickable(txtBoxInitials));
		driver.findElement(txtBoxInitials).clear();
		
		wait.until(ExpectedConditions.elementToBeClickable(cboxEmpCategory));
		driver.findElement(cboxEmpCategory).clear();
		
		wait.until(ExpectedConditions.elementToBeClickable(cboxDesig));
		driver.findElement(cboxDesig).clear();
	
	}*/
	
	/*public void editEmployee(){
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(lbldocstatus));
		wait.until(ExpectedConditions.elementToBeClickable(btnEdit));
		driver.findElement(btnEdit).click();
		//Reporter.log("New Employee details drafted");
		//this.clearEmployeeDetails();
		//this.enterEmpDetails(uNumber, fullName, nameInitials);
		
		
	}*/
	
	
		/*try{
		WebDriverWait wait2 = new WebDriverWait(driver,40);
		wait2.pollingEvery(30, TimeUnit.SECONDS);
		wait2.until(ExpectedConditions.presenceOfElementLocated(lblHeader));
		String lblHeaderTxt = driver.findElement(lblHeader).getText();
		
		if(lblHeaderTxt=="New")
		Reporter.log("New Employee registration window opened");
		else{
			Reporter.log("<font color='red'>New Employee label not fond</font>");	
		}
		}catch(Exception e){
			Reporter.log("<font color='red'>New Employee label not fond - exception</font>");
			
		}finally{}*/
		
		
}
