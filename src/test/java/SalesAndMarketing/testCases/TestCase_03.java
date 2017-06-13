package SalesAndMarketing.testCases;

import SalesAndMarketing._03_CollectionUnits.*;
import SalesAndMarketing.dataProvider.CommonClass;
import SalesAndMarketing.dataProvider.CommonClassMainButtons;
import SalesAndMarketing.dataProvider.CommonScreenshot;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestCase_03 extends CommonClass {
	public WebDriver driver;
	_03_01_CollectionUnits objCollectionUnit;
	_03_02_CreateNewCollectionUnit objCreateNewCollectionUnit;
	_03_03_ColUniDraftAndNew objColUniDraftAndNew;
	_03_04_ColUnitCopyFrom objColUnitCopyFrom;
	_03_05_ModifyCopyFromDate objModifyCopyFromDate;
	_03_06_DuplicateColUnitData objDuplicateColUnitData;
	_03_07_ActionDropdown objActionDropdown;

	private int CollectionUnitCode;
	
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

	public void saveNewEmpID() throws ConfigurationException {
		String filePath = System.getProperty("user.dir");
		PropertiesConfiguration config = new PropertiesConfiguration(filePath+"\\util\\Test.properties");
		config.setProperty("CUCode",CollectionUnitCode);
		config.save();
	}

	@BeforeMethod
	public void getEmpID() throws org.apache.commons.configuration.ConfigurationException {

		Properties properties =new Properties();
		try {
			String filePath = System.getProperty("user.dir");
			properties.load(new FileInputStream(filePath+"\\util\\Test.properties"));
			int CUCode = Integer.parseInt(properties.getProperty("CUCode"));
			//int get = Integer.parseInt(getEmpID);
			CollectionUnitCode= CUCode + 1;

		} catch (IOException e) {
			e.printStackTrace();
		}
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
		objCreateNewCollectionUnit.createNewColUnit(Integer.toString(CollectionUnitCode), "Phones", "50");			// Change code +++ x4
		objCreateNewCollectionUnit.searchEmp("P.Perera", "50");
		driver = CommonClassMainButtons.draftBtnClick();
		driver = CommonClassMainButtons.releaseBtnClick();
		driver = CommonClassMainButtons.chkLblStatusReleased();
		objCreateNewCollectionUnit.verifyHeader();

		
	}
	
	@Test(priority = 3) 
	public void TestCase_3_3(){
		driver.navigate().refresh();
		driver = CommonClass.homeScreen();
		driver = CommonClass.MainMenuNav();
		driver = CommonClass.salesAndMketMenuNav();
		//Reuse test case 3.1 functions
		objCollectionUnit = new _03_01_CollectionUnits(driver);
		objCollectionUnit.navToCollUnit();
		objCollectionUnit.newColUnit();
		objCollectionUnit.verifyHeader();
			
		//Reuse test case 3.2 functions
		objCreateNewCollectionUnit = new _03_02_CreateNewCollectionUnit(driver);
		objCreateNewCollectionUnit.createNewColUnit(Integer.toString(CollectionUnitCode), "Phones", "50");			// Change code +++ X4
		objCreateNewCollectionUnit.searchEmp("P.Perera", "50");;
		//Click on draft and new button
		driver = CommonClassMainButtons.draftAndNewBtnClick();
		//objColUniDraftAndNew.draftAndNew();
	//	objColUniDraftAndNew.verifyColUnitExsistingData();

	}
	
/*	@Test(priority = 4)
	public void TestCase_3_4(){
		driver = CommonClass.MainMenuNav();
		driver = CommonClass.salesAndMketMenuNav();
		//Reuse test case 3.1 functions
				objCollectionUnit = new _03_01_CollectionUnits(driver);
				objCollectionUnit.navToCollUnit();
				objCollectionUnit.newColUnit();
	//			objCollectionUnit.verifyHeader();
		//Click on the Copy From (Test case 03_04)
	//		driver = CommonClassMainButtons.copyFromBtnClick();
		//	objColUnitCopyFrom.colunitCopyFromBtnfunc();
	//		objColUnitCopyFrom.selectColUnit("0010");	// use 0010
	//		objColUnitCopyFrom.verifyColUnit();
	//		objColUnitCopyFrom.enterColUnitCode(Integer.toString(CollectionUnitCode)); 					// enter new code++++ X4
				
	}	
	
/*	@Test(priority = 5)
	public void TestCase_3_5(){
		objModifyCopyFromDate = new _03_05_ModifyCopyFromDate (driver);
		objModifyCopyFromDate.ModifyCopyFromDateFunc("PhonesNew", "75","25");
			
		//
		objCreateNewCollectionUnit = new _03_02_CreateNewCollectionUnit(driver);
		driver = CommonClassMainButtons.draftBtnClick();
		driver = CommonClassMainButtons.releaseBtnClick();
		objCreateNewCollectionUnit.verifyHeader();
	}
	
	@Test(priority = 6) 
	public void TestCase_3_6(){
		objDuplicateColUnitData = new _03_06_DuplicateColUnitData(driver);
		objDuplicateColUnitData.clkOnDuplicate();
		objDuplicateColUnitData.fillMandatoryFields(Integer.toString(CollectionUnitCode));				// enter new code++++ X4
		//
		objCreateNewCollectionUnit = new _03_02_CreateNewCollectionUnit(driver);
		driver = CommonClassMainButtons.draftBtnClick();
		driver = CommonClassMainButtons.releaseBtnClick();
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
