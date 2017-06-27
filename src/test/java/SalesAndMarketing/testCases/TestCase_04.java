package SalesAndMarketing.testCases;

import SalesAndMarketing._04_leadInformation.*;
import dataProvider.CommonClass;
import dataProvider.CommonClassMainButtons;
import dataProvider.CommonScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestCase_04 {
	public WebDriver driver;
	_04_01_LeadInfoModule objLeadInfoModule;
	_04_02_VerifyMandatoryFields objVerifyMandatoryFields;
	_04_03_NewLeadCreation objNewLeadCreation;
	_04_05_CopyFrom objCopyFrom;
	_04_06_CopyFromModify objCopyFromModify;
	_04_07_DuplicateLead objDuplicateLead;
	_04_09_HistoryChk objHistoryChk;
	_04_10_ConvertLeadAsAccount objConvertLeadAsAccount;
	_04_11_NewLeadByPlusSign objNewLeadByPlusSign;
	 
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
	public void TestCase_4_1(){
			driver = CommonClass.MainMenuNav();
		driver = CommonClass.moduleNavigation("SALES & MARKETING");
		objLeadInfoModule = new _04_01_LeadInfoModule(driver);
		objLeadInfoModule.navToLeadInforModule();
				Reporter.log(" User able to click on Lead Information");
		objLeadInfoModule.newLeadInfo();
				Reporter.log("navigated to Lead information page");
	}
	@Test (priority = 2)
	public void TestCase_4_2(){
		objVerifyMandatoryFields = new _04_02_VerifyMandatoryFields(driver);
			driver = CommonClassMainButtons.draftBtnClick();
		objVerifyMandatoryFields.validatorMsgBx();
		objVerifyMandatoryFields.checkAstrix();
		objVerifyMandatoryFields.chkMandatoryMsgs();		
		driver.navigate().refresh();
	}
	
	@Test (priority = 3)
	public void TestCase_4_3(){
		objNewLeadCreation = new _04_03_NewLeadCreation (driver);
		objNewLeadCreation.enterLeadInfo("Fernando","075265479", "MyCompany", "12322458V", "Team Leader");	
			driver = CommonClassMainButtons.draftBtnClick();
			driver = CommonClassMainButtons.editBtnClick();
		objNewLeadCreation.enterContactDetails( "teamleader@slt.lk", "0112147147");
		//objNewLeadCreation.deleteContact();
		objNewLeadCreation.addNewContactDetails("Contact Person Name", "0766666666", "contactPerson@gmail.com");
		
			driver = CommonClassMainButtons.updateBtnClick();
			driver = CommonClassMainButtons.releaseBtnClick();
			driver = CommonClass.chkLblStatusReleased();
			
		objNewLeadCreation.insertInqury("Inquery about something special", "Inquery description entered successfully in this dialog box");
		objNewLeadCreation.confirmInquery();
			driver = CommonClassMainButtons.editBtnClick();
			driver = CommonClassMainButtons.updateBtnClick();
			//driver = CommonClassMainButtons.releaseBtnClick(); 	//Release button not available
	}
	@Test (priority = 4)
	public void TestCase_4_4(){
			driver = CommonClassMainButtons.homeScreen();
			driver = CommonClassMainButtons.MainMenuNav();
			driver = CommonClass.moduleNavigation("SALES & MARKETING");
			
		objLeadInfoModule = new _04_01_LeadInfoModule(driver);
		objLeadInfoModule.navToLeadInforModule();
		objLeadInfoModule.newLeadInfo();
		
		objNewLeadCreation = new _04_03_NewLeadCreation (driver);
		objNewLeadCreation.enterLeadInfo("Fernando","075265479", "MyCompany", "12322458V", "Team Leader");	
			driver = CommonClassMainButtons.draftAndNewBtnClick();
	}
	
	@Test (priority = 5)
	public void TestCase_4_5(){
		objCopyFrom = new _04_05_CopyFrom(driver);
			driver = CommonClassMainButtons.copyFromBtnClick();
			objCopyFrom.searchTxtBoxSendText("Fernando");
			objCopyFrom.searchNSelectColumn("Fernando MyCompany 12322458V 075265479");
		objCopyFrom.chkCopiedValues();
	}
	@Test (priority = 6)
	public void TestCase_4_6(){
		objCopyFromModify = new _04_06_CopyFromModify(driver);
		objCopyFromModify.modifyVals("0123654785", "Test01", "956400251v");
			driver = CommonClassMainButtons.draftBtnClick();
			driver = CommonClassMainButtons.releaseBtnClick();
			driver = CommonClassMainButtons.chkLblStatusReleased();
	}
	@Test (priority = 7)
	public void TestCase_4_7(){
		objDuplicateLead = new _04_07_DuplicateLead(driver);
		//objDuplicateLead.duplicatebrnClick();
			driver = CommonClassMainButtons.duplicateBtnClick();
		objDuplicateLead.verifyDuplicateInfo();
			
	}
	@Test (priority = 8)
	public void TestCase_4_8(){
		objCopyFromModify = new _04_06_CopyFromModify(driver);
		objCopyFromModify.modifyVals("0123654896", "Test02","926532154v");
			driver = CommonClassMainButtons.draftBtnClick();
			driver = CommonClassMainButtons.releaseBtnClick();
			driver = CommonClassMainButtons.chkLblStatusReleased();
	}
	@Test (priority = 9)
	public void TestCase_4_9(){
		objHistoryChk = new _04_09_HistoryChk (driver);
			driver = CommonClass.HistoryGoto();
		objHistoryChk.checkHistory();
	}
	@Test (priority = 10)
	public void TestCase_4_10(){												//Assertion error 
		objConvertLeadAsAccount = new _04_10_ConvertLeadAsAccount(driver); 
			driver = CommonClassMainButtons.convertToAccount();
		objConvertLeadAsAccount.fillAccountInfo("AccCod0034","New_ACC");				//Account number +	
			driver = CommonClassMainButtons.draftBtnClick();
			driver = CommonClassMainButtons.releaseBtnClick();
			driver = CommonClassMainButtons.chkLblStatusReleased();
		objConvertLeadAsAccount.chkAccountInfo(); 										//Automatically get the Acc number
		driver.close();
		
	}
	@Test (priority = 11)
	public void TestCase_4_11(){
		
			driver = CommonClass.driverInstance();
			driver = CommonClass.loginMeth();
			driver = CommonClass.MainMenuNav();
			driver = CommonClass.moduleNavigation("SALES & MARKETING");
			
		objLeadInfoModule = new _04_01_LeadInfoModule(driver);
			objLeadInfoModule.navToLeadInforModule();
			objLeadInfoModule.newLeadInfo();
			
		objNewLeadByPlusSign = new _04_11_NewLeadByPlusSign(driver);	
		
			objNewLeadByPlusSign.addNewRaing();
			objNewLeadByPlusSign.newRatingInfo("AutoRatingInfoParaVal001");
			
			objNewLeadByPlusSign.leadSource("AutoLeadSourceParaVal001");
			
			objNewLeadByPlusSign.newLeadStatus("AutoLeadStatParaVal001");
			
			objNewLeadCreation = new _04_03_NewLeadCreation (driver);
			objNewLeadCreation.enterLeadInfo("Fernando","075265479", "MyCompany", "12322458V", "Team Leader");	

			driver = CommonClassMainButtons.draftBtnClick();
			objNewLeadByPlusSign.contactInfo("Contact Name");
				driver = CommonClassMainButtons.releaseBtnClick();
			objNewLeadByPlusSign.salesInqueryInfo("Sales Inquery about comes here...");
	}
}

