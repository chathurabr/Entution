package SalesAndMarketing.testCases;

import SalesAndMarketing._03_CollectionUnits.*;
import SalesAndMarketing.dataProvider.CommonClass;
import SalesAndMarketing.dataProvider.CommonScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestCase_03 extends CommonClass {
	public WebDriver driver;
	_03_01_CollectionUnits objCollectionUnit;
	_03_02_CreateNewCollectionUnit objCreateNewCollectionUnit;
	_03_03_ColUniDraftAndNew objColUniDraftAndNew;
	_03_04_ColUnitCopyFrom objColUnitCopyFrom;
	_03_05_ModifyCopyFromDate objModifyCopyFromDate;
	_03_06_DuplicateColUnitData objDuplicateColUnitData;
	_03_07_ActionDropdown objActionDropdown;
	
	//@DataProvider
	/*public Object[] testcred(){ 
		Object[] details = new Object[1];
		
		details[0][0][0][0][0] = "ColCode0001";//Collection Unit Code
		details[0][1][0][0][0] = "Phones";//Collection Unit Name
		details[0][1][1][0][0] = "50";//Collection Unit Com Rate
		details[0][1][1][1][0] = "P.Perera";//Employee Name
		details[0][1][1][1][1] = "50";//Employee Sharing Rate
		
		return details;
		}*/
	
	@BeforeTest
	public void beforeTest(){
		driver = CommonClass.driverInstance();
		driver = CommonClass.loginMeth();
		driver = CommonClass.MainMenuNav();
		driver = CommonClass.salesAndMketMenuNav();
	}
	
	@AfterMethod
	public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
		driver = CommonScreenshot.takeSnapshot(testResult);
	}
	
	@Test (priority = 1)
	public void TestCase_3_1(){
		objCollectionUnit = new _03_01_CollectionUnits(driver);
		objCollectionUnit.navToCollUnit();
		objCollectionUnit.newColUnit();
		objCollectionUnit.verifyHeader();
		
	}
	
	@Test(priority = 2) 
	public void TestCase_3_2(){
		objCreateNewCollectionUnit = new _03_02_CreateNewCollectionUnit(driver);
		objCreateNewCollectionUnit.createNewColUnit("ColCode0083", "Phones", "50");			// Change code +++ x4
		objCreateNewCollectionUnit.searchEmp("P.Perera", "50");
		objCreateNewCollectionUnit.draftReleaseColUnit();
		objCreateNewCollectionUnit.verifyHeader();
		driver.quit();
		
	}
	
	@Test(priority = 3) 
	public void TestCase_3_3(){
		driver = CommonClass.driverInstance();
		driver = CommonClass.loginMeth();
		driver = CommonClass.MainMenuNav();
		driver = CommonClass.salesAndMketMenuNav();
		//Reuse test case 3.1 functions
		objCollectionUnit = new _03_01_CollectionUnits(driver);
		objCollectionUnit.navToCollUnit();
		objCollectionUnit.newColUnit();
		objCollectionUnit.verifyHeader();
			
		//Reuse test case 3.2 functions
		objCreateNewCollectionUnit = new _03_02_CreateNewCollectionUnit(driver);
		objCreateNewCollectionUnit.createNewColUnit("ColCode0084", "Phones", "50");			// Change code +++ X4
		objCreateNewCollectionUnit.searchEmp("P.Perera", "50");;
		//Click on draft and new button
		objColUniDraftAndNew = new _03_03_ColUniDraftAndNew(driver);
		objColUniDraftAndNew.draftAndNew();
		objColUniDraftAndNew.verifyColUnitExsistingData();
		driver.quit();
	}
	
	@Test(priority = 4) 
	public void TestCase_3_4(){
		driver = CommonClass.driverInstance();
		driver = CommonClass.loginMeth();
		driver = CommonClass.MainMenuNav();
		driver = CommonClass.salesAndMketMenuNav();
		//Reuse test case 3.1 functions
				objCollectionUnit = new _03_01_CollectionUnits(driver);
				objCollectionUnit.navToCollUnit();
				objCollectionUnit.newColUnit();
				objCollectionUnit.verifyHeader();
		//Click on the Copy From (Test case 03_04)
			objColUnitCopyFrom	= new _03_04_ColUnitCopyFrom (driver);
			objColUnitCopyFrom.colunitCopyFromBtnfunc();
				
			objColUnitCopyFrom.selectColUnit("0010");	// use 0010
				
			objColUnitCopyFrom.verifyColUnit();
			objColUnitCopyFrom.enterColUnitCode("ColCode0085"); 					// enter new code++++ X4
				
	}	
	
	@Test(priority = 5) 
	public void TestCase_3_5(){
		objModifyCopyFromDate = new _03_05_ModifyCopyFromDate (driver);
		objModifyCopyFromDate.ModifyCopyFromDateFunc("PhonesNew", "75","25");
			
		//
		objCreateNewCollectionUnit = new _03_02_CreateNewCollectionUnit(driver);
		objCreateNewCollectionUnit.draftReleaseColUnit();
		objCreateNewCollectionUnit.verifyHeader();
	}
	
	@Test(priority = 6) 
	public void TestCase_3_6(){
		objDuplicateColUnitData = new _03_06_DuplicateColUnitData(driver);
		objDuplicateColUnitData.clkOnDuplicate();
		objDuplicateColUnitData.fillMandatoryFields("ColCode0086");				// enter new code++++ X4
		//
		objCreateNewCollectionUnit = new _03_02_CreateNewCollectionUnit(driver);
		objCreateNewCollectionUnit.draftReleaseColUnit();
		objCreateNewCollectionUnit.verifyHeader();
	}
	
	@Test(priority = 7) 
	public void TestCase_3_7(){
		objActionDropdown = new _03_07_ActionDropdown (driver);
		objActionDropdown.actionDropDownFunc();
		objActionDropdown.verifyHistory();
			
	}
	
	/*@AfterSuite
	public void tearDown(){
		driver.quit();
	}*/
	
}
