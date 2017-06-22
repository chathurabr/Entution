package SalesAndMarketing._02_salesUnits;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class _02_05_NewSalesUnitCreate {
	WebDriver driver;
	By colUnitSearchIcon = By.xpath("//*[@id='divGen']/div[2]/table/tbody/tr[4]/td[2]/div/span[1]/span");
	By colUnitNew = By.id("btnUpdate");
	By collectionUnitSearchResultColumn = By.xpath("//*[@id='g1029-t']/table/tbody/tr[1]");

	By colUnitDraft = By.xpath("//*[@id='permissionBar']/a[1]/span");
	By colUnitRelease = By.xpath("//*[@id='permissionBar']/a[2]");
	//valMsg
	By valMsgBoxCloseBtn = By.xpath("//*[@id='validator']/a/i");
	By colUniCodeValMsg = By.xpath("//*[@id='divGen']/div[1]/table/tbody/tr[1]/td[2]/div");
	By colUniNameValMsg = By.xpath("//*[@id='divGen']/div[1]/table/tbody/tr[2]/td[2]/div");
	By colUniComRateValMsg = By.xpath("//*[@id='divGen']/div[1]/table/tbody/tr[3]/td[2]/div");
	By colUniEmpCodValImg = By.xpath("//*[@id='tblEmpdata']/tbody/tr/td[1]/span");
	//
	By colUniCodeTxtBx = By.id("txtCUCode");
	By colUniNameTxtBx = By.id("txtCUName");
	By colUniComRateTxtBx = By.id("txtComRate");

	By empCodeSearchIcn = By.xpath("//*[@id='tblEmpdata']/tbody/tr/td[4]/span");
	
	By empNew = By.id("btnUpdate");
	
	By empCode = By.id("txtEmpCode"); /*Code generate automatically*/
	By empTitleSelector = By.id("cboxTitle");
	By empFullName = By.id("txtFullName");
	By empNameWithIni = By.id("txtInitials");
	By empGroupSelector = By.id("cboxEmpCategory");
	
	By empCodeSearchTxtBox = By.xpath("//*[@id='txtg1002']");
	By empColSelect = By.xpath("//*[@id='g1002-t']/table/tbody/tr[1]");
	By empDraftBtn = By.xpath("//*[@id='permissionBar']/a[1]");
	
	By empSharingRate = By.xpath("//*[@id='tblEmpdata']/tbody/tr/td[7]/input");

	//By empNumber = By.id("txtEmpNo");
	By colUnitSearchtxtBox = By.id("txtg1029");
	By colUnitColumn = By.xpath("//*[@id='g1029-t']/table/tbody/tr[1]");
	
	By salesOrganization = By.id("cboxSalesOrg");
	
	By unitLeaderSearchIcon = By.xpath("//*[@id='divGen']/div[2]/table/tbody/tr[6]/td[2]/div/span[2]/span");
	By unitLeaderSearchRefresh = By.xpath("//*[@id='g1002']/div[1]/span[1]/span[2]");
	By unitLeaderSearchTxtBx = By.id("txtg1002");
	
	By nameTitle = By.id("cboxTitle");
	By name = By.id("txtFullName");
	By nameWithInitials = By.id("txtInitials");
	By employeeGroupSelector = By.id("cboxEmpCategory");
	
	By employeeCodeSrchIcon = By.xpath("//*[@id='tblEmpdata']/tbody/tr/td[4]/span");
	By employeeCodeSharingRate = By.xpath("	//*[@id='tblEmpdata']/tbody/tr/td[8]/input");
	
	public String employeeFullNamePublic;
	
	public _02_05_NewSalesUnitCreate(WebDriver driver){
		this.driver=driver;
		
	}
	
	public void NewSalesUnitCreate(String collectionUnitCode,String collectionUnitName, String collectionUnitComRate,String employeeCode,String nameTitleSelectBy,String employeeFullName,String empInitials,String employeeGroupSelectBy, String searchColumnName,String createdColUnitName,String searchCollectionUnitColumnName, String unitLeaderName, String employeeCodSharingRate){
		employeeFullNamePublic = employeeFullName;	
		this.CollectionUnitNav();
/*del later*///this.newColUni(collectionUnitCode, collectionUnitName, collectionUnitComRate,empName,empShRate,EmpSearchName,colUnitName);
		this.collectionUniValidations();
		this.newCollectionUnitBtnCLk();
		this.insertNewColUnitInfo(collectionUnitCode, collectionUnitName, collectionUnitComRate);
		this.searchEmpForNewColUnitInfo();
		this.NewEmpForNewColUnitInfo();
		this.enterNewEmployeeColUnitInfo(employeeCode, nameTitleSelectBy, employeeFullName, empInitials, employeeGroupSelectBy);
		this.shiftWindows();
		this.searchCreatedEmp(employeeFullNamePublic);
		this.selectSearchedEmployee(searchColumnName);
		this.searchCreatedCollectionUnit(createdColUnitName);
		this.selectSearchedCreatedCollectionUnit(searchCollectionUnitColumnName);
		this.selectSalesOrganization();
		this.clkUniLeaderSrchIcon();
		this.newUniLeader();
		this.UniLeaderCreate(employeeCode, nameTitleSelectBy, employeeFullName, empInitials, employeeGroupSelectBy);
		this.refreshAndFindCreatedUnitLeader(unitLeaderName);
		this.empCodeSearchIcon();
		this.employeeCodeSharingRate(employeeCodSharingRate);
		
	}
	
	public void CollectionUnitNav(){
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(4, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.elementToBeClickable(colUnitSearchIcon));
		WebElement colUSrchIcn = driver.findElement(colUnitSearchIcon);
		action.moveToElement(colUSrchIcn).click().build().perform();

	}
	
	
	public void newCollectionUnitBtnCLk(){
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(4, TimeUnit.SECONDS);
		
		// New collection unit window opens
				wait.until(ExpectedConditions.elementToBeClickable(colUnitNew));
				WebElement element = driver.findElement(colUnitNew);
				//action.moveToElement(element).click().build().perform();
				action.moveToElement(element)
		        			.keyDown(Keys.COMMAND).keyDown(Keys.SHIFT).click(element)
		        			.keyUp(Keys.COMMAND).keyDown(Keys.SHIFT).perform();
		
		for(String handle:driver.getWindowHandles()){
			driver.switchTo().window(handle);
		}
	}
	
	public void collectionUniValidations(){
	String err;
		Actions action = new Actions(driver);
		SoftAssert soAssert = new SoftAssert();
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(10, TimeUnit.SECONDS);
		WebElement closeB = driver.findElement(valMsgBoxCloseBtn);

		if(driver.findElement(valMsgBoxCloseBtn).isDisplayed()) {
			wait.until(ExpectedConditions.presenceOfElementLocated(valMsgBoxCloseBtn));
			action.moveToElement(closeB).click().build().perform();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(valMsgBoxCloseBtn));
		}

		wait.until(ExpectedConditions.presenceOfElementLocated(colUniCodeValMsg));
		err = driver.findElement(colUniCodeValMsg).getText();
		soAssert.assertEquals("You must enter a value.",  driver.findElement(colUniCodeValMsg).getText());
		
		wait.until(ExpectedConditions.presenceOfElementLocated(colUniNameValMsg));
		err = driver.findElement(colUniNameValMsg).getText();
		soAssert.assertEquals("You must enter a value. | You must enter a Name.",driver.findElement(colUniNameValMsg).getText());
		
		/*wait.until(ExpectedConditions.presenceOfElementLocated(colUniComRateValMsg));
		err = driver.findElement(colUniComRateValMsg).getText();
		System.out.println("Rate err-------------------------------------------------------"+err);*/
		
		wait.until(ExpectedConditions.presenceOfElementLocated(colUniEmpCodValImg));
		
	}
	
	public void insertNewColUnitInfo(String collectionUnitCode, String collectionUnitName,String collectionUnitComRate){
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(5, TimeUnit.SECONDS);
		
		 wait.until(ExpectedConditions.elementToBeClickable(colUniCodeTxtBx));
	        WebElement codeTxtBx = driver.findElement(colUniCodeTxtBx);
	        action.moveToElement(codeTxtBx).click().build().perform();
	        action.moveToElement(codeTxtBx).sendKeys(collectionUnitCode).build().perform();
	        
	    	wait.until(ExpectedConditions.elementToBeClickable(colUniNameTxtBx));
			WebElement nameTxtBx = driver.findElement(colUniNameTxtBx);
			action.moveToElement(nameTxtBx).click().build().perform();
			action.moveToElement(nameTxtBx).sendKeys(collectionUnitName).build().perform();
			
			wait.until(ExpectedConditions.elementToBeClickable(colUniComRateTxtBx));
			WebElement rateTxtBx = driver.findElement(colUniComRateTxtBx);
			action.moveToElement(rateTxtBx).click().build().perform();
			driver.findElement(colUniComRateTxtBx).clear();
			action.moveToElement(rateTxtBx).sendKeys(collectionUnitComRate).build().perform();
	}
	
	public void searchEmpForNewColUnitInfo(){
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(10, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(empCodeSearchIcn));
		WebElement codeSrch = driver.findElement(empCodeSearchIcn);
		action.moveToElement(codeSrch).click().build().perform();
		
	}
	public void NewEmpForNewColUnitInfo(){
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(10, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(empNew));
		WebElement btnClk = driver.findElement(empNew);
		
		action.moveToElement(btnClk)
		.keyDown(Keys.COMMAND).keyDown(Keys.SHIFT).click(btnClk)
		.keyUp(Keys.COMMAND).keyDown(Keys.SHIFT).build().perform();
		
	/*	ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(2));*/
		
		for(String handle:driver.getWindowHandles()){
			driver.switchTo().window(handle);
		}
	}
	
	public void enterNewEmployeeColUnitInfo(String employeeCode,String nameTitleSelectBy,String employeeFullName, String empInitials, String employeeGroupSelectBy){
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(10, TimeUnit.SECONDS);
		
		//empCode
		if(driver.findElement(empCode).isEnabled()){
			wait.until(ExpectedConditions.elementToBeClickable(empCode));
			WebElement emCode = driver.findElement(empCode);
			action.moveToElement(emCode).click().build().perform();
			emCode.clear();
			action.moveToElement(emCode).sendKeys(employeeCode).build().perform();
		}else{
			Reporter.log("Employee code generate automatically");
		}
		
		wait.until(ExpectedConditions.elementToBeClickable(empTitleSelector));
			Select nameTitle = new Select(driver.findElement(empTitleSelector));
				nameTitle.selectByVisibleText(nameTitleSelectBy);
			
		wait.until(ExpectedConditions.elementToBeClickable(empFullName));
			WebElement fullName = driver.findElement(empFullName);
			action.moveToElement(fullName).click().build().perform();
			action.moveToElement(fullName).sendKeys(employeeFullName).build().perform();
			action.moveToElement(fullName).sendKeys(Keys.ENTER).build().perform();
		
		wait.until(ExpectedConditions.elementToBeClickable(empNameWithIni));
			WebElement nameWithInitials = driver.findElement(empNameWithIni);
			action.moveToElement(nameWithInitials).click().build().perform();
			action.moveToElement(nameWithInitials).sendKeys(empInitials).build().perform();
			action.moveToElement(nameWithInitials).sendKeys(Keys.ENTER).build().perform();
			
		wait.until(ExpectedConditions.elementToBeClickable(empGroupSelector));
			Select group = new Select (driver.findElement(empGroupSelector));
			group.selectByVisibleText(employeeGroupSelectBy);
		
	}
	
	public void shiftWindows(){
		for(String handle:driver.getWindowHandles()){
			driver.switchTo().window(handle); //Shift to window
		}
	}
	
	public void searchCreatedEmp(String employeeFullNamePublic){
		
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(10, TimeUnit.SECONDS);
		//empCodeSearchTxtBox
		wait.until(ExpectedConditions.elementToBeClickable(empCodeSearchTxtBox));
		WebElement empsrch = driver.findElement(empCodeSearchTxtBox);
		action.moveToElement(empsrch).click().build().perform();
		action.moveToElement(empsrch).sendKeys(employeeFullNamePublic).build().perform();
		action.moveToElement(empsrch).sendKeys(Keys.ENTER).build().perform();
		
	}
	
	public void selectSearchedEmployee(String searchColumnName){
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Actions action = new Actions(driver);
		SoftAssert soAssert = new SoftAssert();
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(10, TimeUnit.SECONDS);
		
		List<WebElement> trEle = driver.findElements(By.tagName("tr"));
		
		for(int i=0;i < trEle.size();i++){
			
			String trElement = trEle.get(i).getText();
			System.out.println("-|-|-|-|-|-|-|-|-|-|-|-|-|----------------------------------"+trElement );
			if(trEle.get(i).getText().startsWith(searchColumnName)){
				action.moveToElement(trEle.get(i)).doubleClick().build().perform();
				
			}else{
				soAssert.assertEquals(searchColumnName, trEle.get(i).getText());
				
			}
		}
	}
	
	public void searchCreatedCollectionUnit(String createdColUnitName){
		//colUnitSearchtxtBox
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(10, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.elementToBeClickable(colUnitSearchtxtBox));
		WebElement colSrch = driver.findElement(colUnitSearchtxtBox);
		action.moveToElement(colSrch).click().build().perform();
		action.moveToElement(colSrch).sendKeys(createdColUnitName).build().perform();
		action.moveToElement(colSrch).sendKeys(Keys.ENTER).build().perform();
	}
	
	public void selectSearchedCreatedCollectionUnit(String searchCollectionUnitColumnName){
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(10, TimeUnit.SECONDS);

		try{
			wait.until(ExpectedConditions.presenceOfElementLocated(collectionUnitSearchResultColumn));
		}catch (NoSuchElementException e){
		}

		WebElement columnOne = driver.findElement(collectionUnitSearchResultColumn);

		action.moveToElement(columnOne).doubleClick().build().perform();

		/*List<WebElement> trEle = driver.findElements(By.tagName("td"));
		
		for(int i=0;i < trEle.size();i++){
			String trElement = trEle.get(i).getAttribute("desc");
			System.out.println("/////////////--------------------"+trElement);
			if(trElement.startsWith(searchCollectionUnitColumnName)){
				action.moveToElement(trEle.get(i)).doubleClick().build().perform();
				
				break;
			}
		}		*/
	}
	
	public void selectSalesOrganization(){
		//salesOrganization
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(10, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.elementToBeClickable(salesOrganization));
		Select salesOrgSel = new Select(driver.findElement(salesOrganization));
		salesOrgSel.selectByVisibleText("MobilePhones");
		
	}
	
	public void clkUniLeaderSrchIcon(){
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(10, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.elementToBeClickable(unitLeaderSearchIcon));
		WebElement uniLdrSrchBtn = driver.findElement(unitLeaderSearchIcon);
		action.moveToElement(uniLdrSrchBtn).click().build().perform();
		
		action.moveToElement(uniLdrSrchBtn)
		.keyDown(Keys.COMMAND).keyDown(Keys.SHIFT).click(uniLdrSrchBtn)
		.keyUp(Keys.COMMAND).keyDown(Keys.SHIFT).build().perform();
		
	/*	ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));*/
	}
	
	public void newUniLeader(){
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.pollingEvery(10, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(empNew));
		WebElement btnClk = driver.findElement(empNew);

		action.moveToElement(btnClk).click().build().perform();
		
		/*action.moveToElement(btnClk)
		.keyDown(Keys.COMMAND).keyDown(Keys.SHIFT).click(btnClk)
		.keyUp(Keys.COMMAND).keyDown(Keys.SHIFT).build().perform();*/
		
		/*ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));*/

		for(String handle:driver.getWindowHandles()){
			driver.switchTo().window(handle); //Shift to next window
		}

	}
	
	
	
		public void UniLeaderCreate(String employeeCode,String nameTitleSelectBy,String employeeFullName, String empInitials, String employeeGroupSelectBy){
			Actions action = new Actions(driver);
			WebDriverWait wait = new WebDriverWait(driver, 40);
			wait.pollingEvery(10, TimeUnit.SECONDS);
			
			//empCode
			if(driver.findElement(empCode).isEnabled()){
				wait.until(ExpectedConditions.elementToBeClickable(empCode));
				WebElement emCode = driver.findElement(empCode);
				action.moveToElement(emCode).click().build().perform();
				emCode.clear();
				action.moveToElement(emCode).sendKeys(employeeCode).build().perform();
			}else{
				Reporter.log("Employee code generate automatically");
			}
			
			wait.until(ExpectedConditions.elementToBeClickable(empTitleSelector));
				Select nameTitle = new Select(driver.findElement(empTitleSelector));
					nameTitle.selectByVisibleText(nameTitleSelectBy);
				
			wait.until(ExpectedConditions.elementToBeClickable(empFullName));
				WebElement fullName = driver.findElement(empFullName);
				action.moveToElement(fullName).click().build().perform();
				action.moveToElement(fullName).sendKeys(employeeFullName).build().perform();
				action.moveToElement(fullName).sendKeys(Keys.ENTER).build().perform();
			
			wait.until(ExpectedConditions.elementToBeClickable(empNameWithIni));
				WebElement nameWithInitials = driver.findElement(empNameWithIni);
				action.moveToElement(nameWithInitials).click().build().perform();
				action.moveToElement(nameWithInitials).sendKeys(empInitials).build().perform();
				action.moveToElement(nameWithInitials).sendKeys(Keys.ENTER).build().perform();
				
			wait.until(ExpectedConditions.elementToBeClickable(empGroupSelector));
				Select group = new Select (driver.findElement(empGroupSelector));
				group.selectByVisibleText(employeeGroupSelectBy);
			
		}
		
		public void refreshAndFindCreatedUnitLeader(String unitLeaderName){
			//unitLeaderSearchRefresh  unitLeaderSearchTxtBx
			Actions action = new Actions(driver);
			WebDriverWait wait = new WebDriverWait(driver, 40);
			wait.pollingEvery(10, TimeUnit.SECONDS);
			
			wait.until(ExpectedConditions.elementToBeClickable(unitLeaderSearchRefresh));
			WebElement refresh = driver.findElement(unitLeaderSearchRefresh);
			action.moveToElement(refresh).click().build().perform();
			
			wait.until(ExpectedConditions.elementToBeClickable(unitLeaderSearchTxtBx));
			WebElement srch = driver.findElement(unitLeaderSearchTxtBx);
			action.moveToElement(srch).click().build().perform();
			action.moveToElement(srch).sendKeys(unitLeaderName).build().perform();
			action.moveToElement(srch).sendKeys(Keys.ENTER).build().perform();
			
		}
		//10. Create new Employee code
		public void empCodeSearchIcon(){
			
			Actions action = new Actions(driver);
			WebDriverWait wait = new WebDriverWait(driver, 40);
			wait.pollingEvery(10, TimeUnit.SECONDS);
			
			wait.until(ExpectedConditions.presenceOfElementLocated(employeeCodeSrchIcon));
			WebElement empCodSrch = driver.findElement(employeeCodeSrchIcon);
			action.moveToElement(empCodSrch).click().build().perform();
		}
		
		public void employeeCodeSharingRate(String employeeCodSharingRate){
			
			Actions action = new Actions(driver);
			WebDriverWait wait = new WebDriverWait(driver, 40);
			wait.pollingEvery(10, TimeUnit.SECONDS);
			
			wait.until(ExpectedConditions.elementToBeClickable(employeeCodeSharingRate));
			WebElement empCodSharingRate = driver.findElement(employeeCodeSharingRate);
			action.moveToElement(empCodSharingRate).click().build().perform();
			empCodSharingRate.clear();
			action.moveToElement(empCodSharingRate).sendKeys(employeeCodSharingRate).build().perform();
		}
	public void switchBack(){
		
	}
}
