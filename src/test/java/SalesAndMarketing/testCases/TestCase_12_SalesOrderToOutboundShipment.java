package SalesAndMarketing.testCases;

import SalesAndMarketing._12_SalesAndMarketingModule_SalesOrder._12_01_NavigatesToSalesOrderScreen;
import SalesAndMarketing._12_SalesAndMarketingModule_SalesOrder._12_02_CreateSalesOrder;
import SalesAndMarketing._12_SalesAndMarketingModule_SalesOrder._12_03_PendingOutboundShipment;
import SalesAndMarketing._12_SalesAndMarketingModule_SalesOrder._12_04_PendingSalesInvoice;
import dataProvider.CommonClass;
import dataProvider.CommonClassMainButtons;
import dataProvider.CommonScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by chathura on 6/15/2017.
 */
public class TestCase_12_SalesOrderToOutboundShipment {
    public WebDriver driver;

    private String salesOrderNumber;
    private String salesIncoiceNumber;

    private String price = "20";
    private String quantity= "100";
    private String total= "2,000";

    private _12_01_NavigatesToSalesOrderScreen salesOrderScreen;
    private _12_02_CreateSalesOrder createSalesOrder;
    private _12_03_PendingOutboundShipment outboundShipment;
    private _12_04_PendingSalesInvoice pendingSalesInvoice;

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

    @Test (priority = 1)   // Navigates to Sales Order screen
    public void testCase_12_1(){
        salesOrderScreen = new _12_01_NavigatesToSalesOrderScreen(driver);
        salesOrderScreen.clickOnSalesOrder();

    }

    @Test(priority = 2) //Create sales order (SSales Order to Outbound Shipment)
    public void testCase_12_02_SalesOrder(){
        createSalesOrder = new _12_02_CreateSalesOrder(driver);
        createSalesOrder.CreateSalesOrder_SalesOrderToOutboundShipment();   /*New Sales Order - Sales Order to Outbound Shipment */
        createSalesOrder.selectCustomerAccount();  /* Select Customer Account*/
        createSalesOrder.selectCurruncy("LKR",5); /*select Curuncy Unit from Dropdown*/
        createSalesOrder.selectSalesUnit(); /*select Sales Unit from Dropdown */
        Assert.assertEquals(createSalesOrder.getAccountOwnerName(),"PereraTest\n" + "Perera"); //Verify that Account owner is autofilled
        createSalesOrder.addProduct("Lot-Pro-1310");  /*Click on Product Search icon and add a product*/
        createSalesOrder.selectWareHouse("1310-1 [1310-ProductIn]"); /* Select a warehouse from the warehouse dropdown.*/
        createSalesOrder.enterQtyAndPrice(quantity,price); /*Enter Qty & Unit Price*/
      //  createSalesOrder.checkTotal(total);  // verify total balace of the available fields
        Assert.assertEquals(CommonClass.draftAndCheckStatus(),"(Draft)");
        Assert.assertEquals(CommonClass.release_Ok_AndCheckStatus(),"(Released)");
    //    createSalesOrder.checkTotalAfterRelesed(total); // verify total balace of the available fields after Released
        salesOrderNumber = createSalesOrder.getSalesOrderNumber();  // Get sales Order Number
        //System.out.println(salesOrderNumber);

    }

    @Test(priority = 3) // Search for a pending Sales invoice from Tast List.
    public void SOTC_003_SalesInvoice(){
        pendingSalesInvoice = new _12_04_PendingSalesInvoice(driver);
        driver = CommonClass.homeScreen();  // Go to home Screen
        driver = CommonClass.HomePgeTiles_TaskEvent();  // Click on Task/Event tile And Verify the page header.
        pendingSalesInvoice.selectSalesInvoice(); //  Click on the "Sales Invoice" tile.
        pendingSalesInvoice.searchOrderNumber(salesOrderNumber); // search using sales Order Number
        pendingSalesInvoice.sales_Invoice(salesOrderNumber);
        pendingSalesInvoice.checkTotal_SSO(total);  // verify total balace of the available fields
        Assert.assertEquals(CommonClass.draftAndCheckStatus(),"(Draft)"); /*Draft and verify order status*/
        Assert.assertEquals(CommonClass.release_Ok_AndCheckStatus(),"(Released)");/*Release and Sales invoice status*/
        salesIncoiceNumber = createSalesOrder.getSalesOrderNumber();  // Get sales Invoice Number
    }

    @Test(priority = 4,enabled = true)  //Search for a pending Outbound shipment from Tast List.
    public void SOTC_002_OutboundShipment(){
        outboundShipment = new _12_03_PendingOutboundShipment(driver);
        driver = CommonClass.homeScreen();  // Go to home Screen
        driver = CommonClass.HomePgeTiles_TaskEvent();  // Click on Task/Event tile And Verify the page header.
        outboundShipment.selectOutboundShipment();  //  Click on the "Outbound Shipment" tile.
        outboundShipment.searchSalesOrderNumber(salesIncoiceNumber); // search using Sales invoice Number
        // outboundShipment.releaseAndGoToPage();
        outboundShipment.outBoundShipment(salesIncoiceNumber,quantity+".00");
        Assert.assertEquals(CommonClass.draftAndCheckStatus(),"(Draft)");/*Draft and verify order status*/
        Assert.assertEquals(CommonClass.releaseAndCheckStatus(),"(Released)");/*Release and Outbound shipment status*/
    }
}
