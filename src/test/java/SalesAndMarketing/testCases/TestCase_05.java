package SalesAndMarketing.testCases;

import SalesAndMarketing._05_SalesInquiry.*;
import SalesAndMarketing.dataProvider.CommonClass;
import SalesAndMarketing.dataProvider.CommonClassMainButtons;
import SalesAndMarketing.dataProvider.CommonScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestCase_05 {
	public WebDriver driver;

	_05_01_SalesInquiryModule objSalesInquiryModule;
	_05_02_VerifyFields objVerifyFields;
	_05_03_TagDetails objTagDetails;
	_05_04_Campaing objCampaing;
	_05_05_TagExistingCamp objTagExistingCamp;
	_05_06_TagASalesInquiryToALead objTagASalesInquiryToALead;
	_05_07_TagSalesInquiryToAccount objTagSalesInquiryToAccount;
	//_05_08_
	_05_09_NewSalesInqUsingExsisting objNewSalesInqUsingExsisting;
	_05_10_NewSalesInqUsingCopyFrom objNewSalesInqUsingCopyFrom;
	_05_11_ChangeCopyFromDetails objChangeCopyFromDetails;
	
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
	public void TestCase_5_1(){
		objSalesInquiryModule = new _05_01_SalesInquiryModule(driver);
		objSalesInquiryModule.goToSSalesInquiryModule();
		objSalesInquiryModule.verifyPageHeading();
	}
	
	@Test(priority = 2)
	public void TestCase_5_2(){
		driver = CommonClassMainButtons.createNewItem();
		objVerifyFields = new _05_02_VerifyFields(driver);
		objVerifyFields.VerifyFields();
		
	}
	@Test(priority = 3)
	public void TestCase_5_3(){
		objTagDetails = new _05_03_TagDetails(driver);
		objTagDetails.goToTagProduct();
		objTagDetails.srchAndSelectCity("Colombo");
		/*objTagDetails.closeErrMsgBox();
		objTagDetails.dblClickCity();*/
	}
	
	@Test(priority = 4)
	public void TestCase_5_4(){
		objCampaing = new _05_04_Campaing(driver);
		objCampaing.clkSearchIcon();
		driver = CommonClassMainButtons.createNewItem();
		driver = CommonClass.moveDriver(1);
		objCampaing.campaingInfo("AutoCampName0059", "AutoCampName", "Advertisements"); //Code +// Dropdown List = --None--,Advertisements,Email, Telemarketing...
		//String campaingCodeStore = objCampaing.campaingCodeCommon;
		//Draft
		driver = CommonClassMainButtons.draftBtnClick();
		//Edit
		driver = CommonClassMainButtons.editBtnClick();
		objCampaing.editCampInfo("AutoCampName-Edited");
		//Update
		driver = CommonClassMainButtons.updateBtnClick();
		
		//Release
		driver = CommonClassMainButtons.releaseBtnClick();
		driver = CommonClassMainButtons.chkLblStatusReleased();
		//driver.close();														
		driver = CommonClass.moveDriver(0);	
			//Search created Campaing
		objCampaing.searchCreatedCampaing("AutoCampName0058"); // Copy above code
	}
	@Test(priority = 5)
	public void TestCase_5_5(){
	objTagExistingCamp = new _05_05_TagExistingCamp (driver);
	objTagExistingCamp.TagExistingCamp();
	}
	
	@Test(priority = 6)
	public void TestCase_5_6(){
	
	objTagASalesInquiryToALead	= new _05_06_TagASalesInquiryToALead(driver);
	objTagASalesInquiryToALead.selectLead("Inquery About - An Issue", "5000", "Inquery description comes here", "Ramitha");
		driver = CommonClassMainButtons.draftBtnClick();
		driver = CommonClassMainButtons.releaseBtnClick();
		driver = CommonClassMainButtons.chkLblStatusReleased();
	
	}
	@Test(priority = 7)
	public void TestCase_5_7(){
		driver = CommonClass.MainMenuNav();
		driver = CommonClass.salesAndMketMenuNav();
		
	objSalesInquiryModule = new _05_01_SalesInquiryModule(driver);
	objSalesInquiryModule.goToSSalesInquiryModule();
		driver = CommonClassMainButtons.createNewItem();
		
	objTagSalesInquiryToAccount = new _05_07_TagSalesInquiryToAccount(driver);
	objTagSalesInquiryToAccount.selectAccount("Inquery About - An Issue", "5000", "Inquery description comes here", "Ramitha");
	}
	
	@Test(priority = 8)
	public void TestCase_5_8(){
	objSalesInquiryModule = new _05_01_SalesInquiryModule(driver);
	objTagSalesInquiryToAccount = new _05_07_TagSalesInquiryToAccount(driver);
	
		driver = CommonClass.homeScreen();
		driver = CommonClass.MainMenuNav();
		driver = CommonClass.salesAndMketMenuNav();
	objSalesInquiryModule.goToSSalesInquiryModule();
	//Insert data
		driver = CommonClassMainButtons.createNewItem();
	objTagSalesInquiryToAccount.selectAccount("Inquery About - An Issue", "5000", "Inquery description comes here", "Ramitha");
		driver = CommonClass.draftAndNewBtnClick();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	}
	@Test(priority = 9)
	public void TestCase_5_9(){
	objNewSalesInqUsingExsisting = new _05_09_NewSalesInqUsingExsisting(driver);
	objSalesInquiryModule = new _05_01_SalesInquiryModule(driver);
		driver = CommonClass.homeScreen();
		driver = CommonClass.MainMenuNav();
		driver = CommonClass.salesAndMketMenuNav();
	objSalesInquiryModule.goToSSalesInquiryModule();
	objNewSalesInqUsingExsisting.searchForSalesInq("000142");
	objNewSalesInqUsingExsisting.clickOnTheColumnOne();
		driver = CommonClassMainButtons.duplicateBtnClick();
	objNewSalesInqUsingExsisting.verifyData();
		driver = CommonClassMainButtons.draftBtnClick();
		driver = CommonClassMainButtons.releaseBtnClick();
		driver = CommonClassMainButtons.chkLblStatusReleased();
	}
	@Test(priority = 10)
	public void TestCase_5_10(){
	objSalesInquiryModule = new _05_01_SalesInquiryModule(driver);
	objNewSalesInqUsingCopyFrom = new _05_10_NewSalesInqUsingCopyFrom(driver);
	
		driver = CommonClass.homeScreen();
		driver = CommonClass.MainMenuNav();
		driver = CommonClass.salesAndMketMenuNav();
	objSalesInquiryModule.goToSSalesInquiryModule();
		driver = CommonClassMainButtons.createNewItem();
		driver = CommonClassMainButtons.copyFromBtnClick();
	objNewSalesInqUsingCopyFrom.copyFromPopUp("000140");
	objNewSalesInqUsingCopyFrom.dblClkOnColOne();
	
	}
	@Test(priority = 11)
	public void TestCase_5_11(){
	objChangeCopyFromDetails = new _05_11_ChangeCopyFromDetails (driver);
	objChangeCopyFromDetails.changeData();
	objChangeCopyFromDetails.changeInquryAbout("Inquery About - An Issue(Copied from)");
	objChangeCopyFromDetails.changeCategory();
	objChangeCopyFromDetails.changeInqueryOrigin();
	objChangeCopyFromDetails.BudgetCurr("LKR");
	objChangeCopyFromDetails.BudgetCost("6000");
	objChangeCopyFromDetails.changeDescription(" .Inquery description comes here (Copied from)");
	objChangeCopyFromDetails.changeResponsibleEmployee("Ramitha");
	
		driver = CommonClassMainButtons.draftBtnClick();
		driver = CommonClassMainButtons.releaseBtnClick();
		driver = CommonClassMainButtons.chkLblStatusReleased();
	}
	
}
