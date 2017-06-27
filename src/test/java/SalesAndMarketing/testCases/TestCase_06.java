package SalesAndMarketing.testCases;

import SalesAndMarketing._06_Campaigns._06_01_NavToCampaign;
import SalesAndMarketing._06_Campaigns._06_02_VerifyFields;
import SalesAndMarketing._06_Campaigns._06_03_CreateNewCampaign;
import SalesAndMarketing._06_Campaigns._06_04_AddMembersToCampaign;
import dataProvider.CommonClass;
import dataProvider.CommonClassMainButtons;
import dataProvider.CommonScreenshot;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestCase_06 {
	public WebDriver driver;


	_06_01_NavToCampaign objNavToCampaign;
	_06_02_VerifyFields objVerifyFields;
	_06_03_CreateNewCampaign objCreateNewCampaign;
	_06_04_AddMembersToCampaign objAddMembers;

	private int campaignCode;


	@BeforeTest
	public void beforeTest(){
		driver = CommonClass.driverInstance();
		driver = CommonClassMainButtons.loginMeth();
		driver = CommonClassMainButtons.MainMenuNav();
		driver = CommonClass.moduleNavigation("SALES & MARKETING");
	}
	
	@AfterMethod
	public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
		driver = CommonScreenshot.takeSnapshot(testResult);
	}

	@AfterTest
	public void saveNewEmpID() throws ConfigurationException {
		String filePath = System.getProperty("user.dir");
		PropertiesConfiguration config = new PropertiesConfiguration(filePath+"\\util\\Test.properties");
		config.setProperty("campaignCode",campaignCode);
		config.save();
	}

	@BeforeTest
	public void getEmpID() throws org.apache.commons.configuration.ConfigurationException {

		Properties properties =new Properties();
		try {
			String filePath = System.getProperty("user.dir");
			properties.load(new FileInputStream(filePath+"\\util\\Test.properties"));
			int CUCode = Integer.parseInt(properties.getProperty("campaignCode"));
			//int get = Integer.parseInt(getEmpID);
			campaignCode= CUCode + 1;

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 1)
	public void TestCase_6_1(){
		objNavToCampaign = new _06_01_NavToCampaign(driver);
		objNavToCampaign.navigationToCampaign();
		objNavToCampaign.verifyPageHeading();
		objNavToCampaign.verifyButton();
		driver = CommonClassMainButtons.createNewItem("New Campaign");
	}
	
	@Test(priority = 2)
	public void TestCase_6_2(){
		objVerifyFields = new _06_02_VerifyFields(driver);
		objVerifyFields.verifyAllFields();
	}
	@Test(priority = 3) //Create new Campaign
	public void TestCase_6_3(){
		objCreateNewCampaign = new _06_03_CreateNewCampaign(driver);
		objCreateNewCampaign.campaignCodeEnter("campaignCode"+campaignCode);							//campaign code+
		objCreateNewCampaign.campaignNameEnter("AutoCampaignName");
		objCreateNewCampaign.selectStartDate("01", "12", "2017");
		objCreateNewCampaign.EnterNewCampaignDetails("50", "100000", "50000", "45612");
		objCreateNewCampaign.enterParentCampaign("New product launch");
		objCreateNewCampaign.selectEndDate("25", "12", "2017");
		/*	driver = CommonClassMainButtons.draftBtnClick();
			driver = CommonClassMainButtons.releaseBtnClick();
			driver = CommonClassMainButtons.chkLblStatusReleased();*/
		
	}

	@Test(priority = 4) //Add members to campaign- Account
	public void TestCase_6_4(){
		objAddMembers = new _06_04_AddMembersToCampaign(driver);
		objAddMembers.clickOnCampainMembers();
		objAddMembers.clickOnAddMembers();
		objAddMembers.clickOnAddCustomer();
		objAddMembers.selectAnExistingAccount();

	}
	

}
