package SalesAndMarketing.testCases;

import SalesAndMarketing._01_Common.*;
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

public class TestCase_01 extends CommonClass {
	public WebDriver driver;
	_01_01_Login objEntutionLogin;
	_01_02_SalesAndMarketingMenu objSalesAndMktMenu;
	_01_03_SalesAndMarketingModules objSaleAndMktModu;
	_01_04_NewEmployeeCreate objNewEmployee;
	_01_05_CreateVendorThroughAccLookup objCreateVendor;

	private int EMP_ID;

	
	@BeforeTest
	public void beforeTest(){
		driver = CommonClass.driverInstance();
	}
	
	@AfterMethod
	public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
		driver = CommonScreenshot.takeSnapshot(testResult);
	}

	@BeforeTest
	public void getEmpID() throws org.apache.commons.configuration.ConfigurationException {

		Properties properties =new Properties();
		try {
			String filePath = System.getProperty("user.dir");
			properties.load(new FileInputStream(filePath+"\\util\\Test.properties"));
			int getEmpID = Integer.parseInt(properties.getProperty("EMP_ID"));
			//int get = Integer.parseInt(getEmpID);
			EMP_ID= getEmpID + 1;

		//	System.out.println(EMP_ID);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@AfterTest
	public void saveNewEmpID() throws ConfigurationException {
		String filePath = System.getProperty("user.dir");
		PropertiesConfiguration config = new PropertiesConfiguration(filePath+"\\util\\Test.properties");
		config.setProperty("EMP_ID",EMP_ID);
		config.save();
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
		String empID = Integer.toString(EMP_ID);
		objNewEmployee.enterEmpDetails(empID, "Fernando", "A.H.Fernando");					// Employee	Code +
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
		driver = CommonClassMainButtons.createNewItem();
		objCreateVendor.newPurchaseOrder();
		objCreateVendor.newVendor("Auto Ven Na R"+EMP_ID,"Auto Ven Na R"+EMP_ID); 	//Change +  AutoVenCo +
		objCreateVendor.searchNSelectVedor("Auto Ven Na R"+EMP_ID);			//get the above number
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
