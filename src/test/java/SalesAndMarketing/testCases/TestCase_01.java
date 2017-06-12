package SalesAndMarketing.testCases;

import SalesAndMarketing._01_Common.*;
import SalesAndMarketing.dataProvider.CommonClass;
import SalesAndMarketing.dataProvider.CommonClassMainButtons;
import SalesAndMarketing.dataProvider.CommonScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestCase_01 extends CommonClass {
	public WebDriver driver;
	_01_01_Login objEntutionLogin;
	_01_02_SalesAndMarketingMenu objSalesAndMktMenu;
	_01_03_SalesAndMarketingModules objSaleAndMktModu;
	_01_04_NewEmployeeCreate objNewEmployee;
	_01_05_CreateVendorThroughAccLookup objCreateVendor;

	
	@BeforeTest
	public void beforeTest(){
		driver = CommonClass.driverInstance();
	}
	
	@AfterMethod
	public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
		driver = CommonScreenshot.takeSnapshot(testResult);
	}
	
	@Test (priority = 1)
	public void TestCase_1_1 (){
		driver = CommonClass.loginMeth();
	}
	
	@Test (priority = 2)
	public void TestCase_1_2 (){
		objSalesAndMktMenu = new _01_02_SalesAndMarketingMenu(driver);
		driver = CommonClass.MainMenuNav();
		driver = CommonClass.salesAndMketMenuNav();
		objSalesAndMktMenu.salesAndMketMenuFunc();
		//objSalesAndMktMenu.chkItems();
	}
	
	/*@Test (priority = 3)
	public void TestCase_1_3 (){
		objSaleAndMktModu = new _01_03_SalesAndMarketingModules(driver);
		objSaleAndMktModu.SalesAndMktModuleVerifi();
	}*/
	
	@Test (priority = 4)
	public void TestCase_1_4(){
		driver.navigate().refresh();
		driver = CommonClass.MainMenuNav();
		objNewEmployee = new _01_04_NewEmployeeCreate(driver);
		objNewEmployee.openOrgMamagamentModule();
		objNewEmployee.openEmpInfoModule();
		//objNewEmployee.chkEmpInfoPage();
		objNewEmployee.newEmployeeWindow();
		objNewEmployee.enterEmpDetails("R238", "Fernando", "A.H.Fernando");					// Employee	Code +
		objNewEmployee.searchUserCode();
		objNewEmployee.selectUserCode();
		objNewEmployee.instHomeAddress("25","Nugegoda");
		objNewEmployee.instOfficeAddress("45", "Melbourne");
		driver = CommonClassMainButtons.draftBtnClick();
		//objNewEmployee.editEmployee();
		driver = CommonClassMainButtons.releaseBtnClick();
		//objNewEmployee.checkEmpStatus();
		driver = CommonClassMainButtons.chkLblStatusReleased();
		
	}
	
	@Test (priority = 5)
	public void TestCase_1_5(){
		objCreateVendor = new _01_05_CreateVendorThroughAccLookup(driver);
		//objSalesAndMktMenu = new _01_02_SalesAndMarketingMenu (driver);
		objCreateVendor.openPurchaseOrder();
		objCreateVendor.newPurchaseOrder();
		objCreateVendor.newVendor("Auto Ven Na R067","AutoVenCoR066"); 	//Change +  AutoVenCo +
		objCreateVendor.searchNSelectVedor("Auto Ven Na R067");			//get the above number
		objCreateVendor.choseSearchedVendor();
		objCreateVendor.compareVendor();
		driver.close();
		//objSalesAndMktMenu.mainMenuFunc();
	}
	
/*@AfterSuite
public void tearDown(){
	driver.quit();
}*/

		
}
