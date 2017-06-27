package Procurement._01_PurchaseOrder.TestCases;

import Procurement._01_PurchaseOrder.InitiatePurchaseOrderSubMod;
import dataProvider.CommonClass;
import dataProvider.CommonClassMainButtons;
import dataProvider.CommonScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by Ramitha on 6/26/2017.
 */
public class TestCase_13_Procurement {
    public WebDriver driver;
    InitiatePurchaseOrderSubMod objSelectPurchaseOrderSubModule;


    @BeforeClass
    public void beforeTest() {
        driver = CommonClass.driverInstance();
        driver = CommonClassMainButtons.loginMeth();

    }
    @BeforeClass
    public void calculations(){

    }
    @AfterMethod
    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
        driver = CommonScreenshot.takeSnapshot(testResult);
    }
    @Test(priority = 1)
    public void mainMenu(){
        driver = CommonClassMainButtons.MainMenuNav();
    }
    @Test(priority = 2)
    public void navToPurchaseOrder(){
        driver = CommonClass.moduleNavigation("PROCUREMENT");
    }
    @Test(priority = 3)
    public void purchaseOrderModuleNav(){
        objSelectPurchaseOrderSubModule = new InitiatePurchaseOrderSubMod(driver);
        objSelectPurchaseOrderSubModule.selectPurchaseOrderSubModule();
    }
    @Test(priority = 4)
    public void pageHeaderVerify(){
        driver = CommonClass.pageNameVerify("Purchase Order");
    }
    @Test(priority = 5)
    public void newPurchaseOrder(){
        driver = CommonClassMainButtons.createNewItem("New Purchase Order");
    }
    @Test(priority = 6)
    public void selectJourneyOne(){
        objSelectPurchaseOrderSubModule = new InitiatePurchaseOrderSubMod(driver);
        objSelectPurchaseOrderSubModule.selectJourney();
    }
    @Test(priority = 7)
    public void confirmPageStatusLabel(){

        objSelectPurchaseOrderSubModule = new InitiatePurchaseOrderSubMod(driver);
        objSelectPurchaseOrderSubModule.isPurchaseOrderLblDisplays();
        driver = CommonClass.docStatusLblChk("New");
    }

}
