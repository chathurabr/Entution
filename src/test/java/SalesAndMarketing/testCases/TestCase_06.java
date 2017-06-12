package SalesAndMarketing.testCases;

import SalesAndMarketing._06_Campaigns._06_01_NavToCampaign;
import SalesAndMarketing._06_Campaigns._06_02_VerifyFields;
import SalesAndMarketing._06_Campaigns._06_03_CreateNewCampaign;
import SalesAndMarketing.dataProvider.CommonClass;
import SalesAndMarketing.dataProvider.CommonClassMainButtons;
import SalesAndMarketing.dataProvider.CommonScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestCase_06 {
	public WebDriver driver;


	_06_01_NavToCampaign objNavToCampaign;
	_06_02_VerifyFields objVerifyFields;
	_06_03_CreateNewCampaign objCreateNewCampaign;

	@BeforeTest
	public void beforeTest(){
		driver = CommonClass.driverInstance();
		driver = CommonClassMainButtons.loginMeth();
		driver = CommonClassMainButtons.MainMenuNav();
		driver = CommonClass.salesAndMketMenuNav();
	}
	
	@AfterMethod
	public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
		driver = CommonScreenshot.takeSnapshot(testResult);
	}
	
	@Test(priority = 1)
	public void TestCase_6_1(){
		objNavToCampaign = new _06_01_NavToCampaign(driver);
		objNavToCampaign.navigationToCampaign();
		objNavToCampaign.verifyPageHeading();
		objNavToCampaign.verifyButton();
		driver = CommonClassMainButtons.createNewItem();
	}
	
	@Test(priority = 2)
	public void TestCase_6_2(){
		objVerifyFields = new _06_02_VerifyFields(driver);
		objVerifyFields.verifyAllFields();
	}
	@Test(priority = 3)
	public void TestCase_6_3(){
		objCreateNewCampaign = new _06_03_CreateNewCampaign(driver);
		objCreateNewCampaign.campaignCodeEnter("campaignCode0001");							//campaign code+
		objCreateNewCampaign.campaignNameEnter("AutoCampaignName");
		objCreateNewCampaign.selectStartDate("01", "12", "2017");
		objCreateNewCampaign.EnterNewCampaignDetails("50", "100000", "50000", "45612");
		objCreateNewCampaign.enterParentCampaign("New product launch");
		objCreateNewCampaign.selectEndDate("25", "12", "2017");
		/*	driver = CommonClassMainButtons.draftBtnClick();
			driver = CommonClassMainButtons.releaseBtnClick();
			driver = CommonClassMainButtons.chkLblStatusReleased();*/
		
	}
	

}
