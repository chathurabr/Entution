package SalesAndMarketing.testCases;

import SalesAndMarketing._01_Common._01_02_SalesAndMarketingMenu;
import SalesAndMarketing._02_salesUnits.*;
import SalesAndMarketing.dataProvider.CommonClass;
import SalesAndMarketing.dataProvider.CommonClassMainButtons;
import SalesAndMarketing.dataProvider.CommonScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;


public class TestCase_02 extends CommonClass {
	public WebDriver driver;
	
	_01_02_SalesAndMarketingMenu objSalesAndMktMenu;
	_02_01_SalesUnits objSalesUnits;
	_02_02_NewSalesUnit objNewSalesUnit;
	_02_03_UnitLeaderAndEmpCode objUnitLeaderAndEmpCode;
	_02_04_SalesUnitCreate objSalesUnitCrate;
	_02_05_NewSalesUnitCreate objNewSalesUnitCreate;
	RegressionTesting objRegressionTesting;
	
	@BeforeTest
	public void beforeTest(){
		driver = CommonClass.driverInstance();
		driver = CommonClass.loginMeth();
	}
	
	@AfterMethod
	public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
		driver = CommonScreenshot.takeSnapshot(testResult);
	}
	
	@Test (priority = 1)
	public void TestCase_2_1 (){
		//objSalesAndMktMenu = new _01_02_SalesAndMarketingMenu (driver);
		objSalesUnits 	= new _02_01_SalesUnits (driver);
		driver = CommonClass.MainMenuNav();
		//objSalesAndMktMenu.mainMenuFunc();
		driver = CommonClass.salesAndMketMenuNav();
		//objSalesAndMktMenu.salesAndMketMenuFunc();
		objSalesUnits.navTOsalesUnitTab();
		objSalesUnits.verifyHeader();
		//objSalesAndMktMenu.chkItems();
		}
	
	@Test (priority = 2)
	public void TestCase_2_2(){
	objNewSalesUnit = new _02_02_NewSalesUnit(driver);
	objNewSalesUnit.newSalesUnitClk();
	objNewSalesUnit.chkMandatoryFields();
	}
	
	@Test (priority = 3)
	public void TestCase_2_3(){
		objUnitLeaderAndEmpCode = new _02_03_UnitLeaderAndEmpCode(driver);
		objUnitLeaderAndEmpCode.insertOtherInfo("AutoCode0110","AutoName0009","10");		//Change Code+
		objUnitLeaderAndEmpCode.insertUnitLeadName("000003 [P.Perera]");
		objUnitLeaderAndEmpCode.veryfyUnitLead();
		objUnitLeaderAndEmpCode.insertUnitLead();
		objUnitLeaderAndEmpCode.clkOnEmpCodeIcon();
		objUnitLeaderAndEmpCode.enterEmpCode("000003 [P.Perera]");
		objUnitLeaderAndEmpCode.verifyEmpCode();
	}
	
	@Test (priority = 4)
	public void TestCase_2_4(){
		objSalesUnitCrate = new _02_04_SalesUnitCreate(driver);
		objSalesUnitCrate.draftSalesUnit("100");
	}

	@Test (priority = 5)
	public void TestCase_2_5(){
		
	// delete later	driver.navigate().refresh();
		driver = CommonClass.homeScreen();
	//objSalesAndMktMenu = new _01_02_SalesAndMarketingMenu (driver);
		driver = CommonClass.MainMenuNav();
		driver = CommonClass.salesAndMketMenuNav();
		
		objSalesUnits = new _02_01_SalesUnits (driver);
		objSalesUnits.navTOsalesUnitTab();
		
		//delete later objNewSalesUnit = new _02_02_NewSalesUnit(driver);	
		//delete later objNewSalesUnit.newSalesUnitClk();
		driver = CommonClassMainButtons.createNewItem();
			
//--------------Enter Sales unit details------------------------------------------------------------------
			objUnitLeaderAndEmpCode = new _02_03_UnitLeaderAndEmpCode(driver);
			objUnitLeaderAndEmpCode.insertOtherInfo("AutCodSalsUni100","Test Sales Unit","5");		//Change Code+
//------Collection unit search--------------------------------------------------------------------
//-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_HERE-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_
				objNewSalesUnitCreate = new _02_05_NewSalesUnitCreate(driver);
				objNewSalesUnitCreate.CollectionUnitNav();
//New col unit btn click
					objNewSalesUnitCreate.newCollectionUnitBtnCLk();
//Check validations
					driver = CommonClassMainButtons.draftBtnClick();
					objNewSalesUnitCreate.collectionUniValidations();
//Refresh page
					driver.navigate().refresh();
//Enter Collection unit data
					objNewSalesUnitCreate.insertNewColUnitInfo("collectionUnitCode", "Nokia", "5");
//New emp details
//					objNewSalesUnitCreate.enterNewEmployeeColUnitInfo("AutCodEmpColUnit072", "Mr.", "Mike Fernando", "M. Fernando", "CEO");			
		//employee code search
//					objNewSalesUnitCreate.searchEmpForNewColUnitInfo();
		//New employee btn click (open in new tab/window)
//					objNewSalesUnitCreate.NewEmpForNewColUnitInfo();
	/*del later*///	objNewSalesUnitCreate.shiftWindows(2);
	
		//draft
//					driver = CommonClassMainButtons.draftBtnClick();
		//Release
//					driver = CommonClassMainButtons.releaseBtnClick();
		//Close the current tab(Window) and driver move back
//					driver.close();
//					objNewSalesUnitCreate.shiftWindows();
		//search for created employee
//					objNewSalesUnitCreate.searchCreatedEmp("a.aruni"); //employeeFullName
		//Select searched employee
//					objNewSalesUnitCreate.selectSearchedEmployee("Mr. 000001 [A.Aruni]"); 
		//Draft
//					driver = CommonClassMainButtons.draftBtnClick();
		//Release
//					driver = CommonClassMainButtons.releaseBtnClick();
		//Close collection unit
		//			driver.close();
		//Search for the created colection unit //objNewSalesUnitCreate.insertNewColUnitInfo(collectionUnitCode, collectionUnitName, collectionUnitComRate);
		//			objNewSalesUnitCreate.searchCreatedCollectionUnit(createdColUnitName);
		//Select searched collection unit
		//			objNewSalesUnitCreate.selectSearchedCreatedCollectionUnit(searchCollectionUnitColumnName);
		//Enter value for Sales Organization (Selector)
		//			objNewSalesUnitCreate.selectSalesOrganization();
		//Unit leader Search Btn
		//			objNewSalesUnitCreate.clkUniLeaderSrchIcon();
		//New Unit leader btn
		//			objNewSalesUnitCreate.newUniLeader();				//try to change window handle
		//Unit leader info
		//			objNewSalesUnitCreate.UniLeaderCreate(employeeCode, nameTitleSelectBy, employeeFullName, empInitials, employeeGroupSelectBy);
		//Draft
		//Release
		//Select created unit leader employee
					
		//Close
		//			driver.close();
		//			objNewSalesUnitCreate.shiftWindows(0);
		//refresh and search created unit leader
		//			objNewSalesUnitCreate.refreshAndFindCreatedUnitLeader(unitLeaderName);
		//Select searched unit leader
		//			objNewSalesUnitCreate.selectSearchedEmployee(unitLeaderName); // copy above name
		//Select employee code search icon
		//			objNewSalesUnitCreate.empCodeSearchIcon();
		//New employee
		//			objNewSalesUnitCreate.NewEmpForNewColUnitInfo();
		//			objNewSalesUnitCreate.shiftWindows(1);
		//Fill new employee details
		//			objNewSalesUnitCreate.enterNewEmployeeColUnitInfo("employeeCode", nameTitleSelectBy, employeeFullName, empInitials, employeeGroupSelectBy);
		//draft
		//Release
		//refresh employeee pop up
		//			objNewSalesUnitCreate.refreshAndFindCreatedUnitLeader(unitLeaderName);
		//11. Enter value for  Sharing Code
		//			objNewSalesUnitCreate.employeeCodeSharingRate(employeeCodSharingRate);
		//12. Click on draft button
		//13. Click on release button
	}				
/*	//Regression on fixed bugs
	@Test (priority = 6)
	public void TestCase_2_Regression(){
		objRegressionTesting = new RegressionTesting(driver);
		objRegressionTesting.newCollectionUnitCannotDraftedWithoutACommissionRate("code0001", "name");
		objRegressionTesting.insertUnitLeadName("aruni");
		objRegressionTesting.insertUnitLead();
		objRegressionTesting.clkOnEmpCodeIcon();
		objRegressionTesting.enterEmpCode("perera");
		objRegressionTesting.enterSharingRate("20");
		driver = CommonClass.draftBtnClick();
		objRegressionTesting.verifyCommissionRateErrMsg();
	}*/
	
	/*@AfterSuite
	public void tearDown(){
		driver.quit();
	}*/
	
	}
