package SalesAndMarketing.testCases;

import SalesAndMarketing._12_SalesAndMarketingModule_SalesOrder._12_01_NavigatesToSalesOrderScreen;
import SalesAndMarketing._12_SalesAndMarketingModule_SalesOrder._12_02_CreateSalesOrder;
import SalesAndMarketing.dataProvider.CommonClass;
import SalesAndMarketing.dataProvider.CommonClassMainButtons;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by chathura on 6/15/2017.
 */
public class TestCase_12 {
    public WebDriver driver;

    private _12_01_NavigatesToSalesOrderScreen salesOrderScreen;
    _12_02_CreateSalesOrder createSalesOrder;

    @BeforeTest
    public void beforeTest(){
        driver = CommonClass.driverInstance();
        driver = CommonClassMainButtons.loginMeth();
        driver = CommonClassMainButtons.MainMenuNav();
        driver = CommonClass.salesAndMketMenuNav();
    }

    @Test (priority = 1)   // Navigates to Sales Order screen
    public void testCase_12_1(){
        salesOrderScreen = new _12_01_NavigatesToSalesOrderScreen(driver);
        salesOrderScreen.clickOnSalesOrder();

    }

    @Test(priority = 2) //Create sales order (Sales order to Sales invoice)
    public void testCase_12_02(){
        createSalesOrder = new _12_02_CreateSalesOrder(driver);
        createSalesOrder.CreateSalesOrder();   /*New Sales Order - Select Sales Order to Sales Invoice */
        createSalesOrder.selectCustomerAccount();  /* Select Customer Account*/
        createSalesOrder.selectCurruncy(); /*select Curuncy Unit from Dropdown*/
        createSalesOrder.selectSalesUnit(); /*select Sales Unit from Dropdown */
        Assert.assertEquals(createSalesOrder.getAccountOwnerName(),"PereraTest\n" + "Perera"); //Verify that Account owner is autofilled
        createSalesOrder.addProduct();  /*Click on Product Search icon and add a Lot product*/
        createSalesOrder.selectWareHouse(); /* Select a warehouse from the warehouse dropdown.*/
        createSalesOrder.enterQtyAndPrice(); /*Enter Qty & Unit Price*/
        createSalesOrder.checkTotal("2,000.00");
        Assert.assertEquals(createSalesOrder.draftAndCheckStatus(),"(Draft)");
        Assert.assertEquals(createSalesOrder.releaseAndCheckStatus(),"(Draft)kkk");

    }

}
