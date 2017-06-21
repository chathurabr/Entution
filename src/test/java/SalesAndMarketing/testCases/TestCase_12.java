package SalesAndMarketing.testCases;

import SalesAndMarketing._12_SalesAndMarketingModule_SalesOrder._12_01_NavigatesToSalesOrderScreen;
import SalesAndMarketing._12_SalesAndMarketingModule_SalesOrder._12_02_CreateSalesOrder;
import SalesAndMarketing._12_SalesAndMarketingModule_SalesOrder._12_03_PendingOutboundShipment;
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

    private String salesOrderNumber;
    private String price = "20";
    private String quantity= "100";

    private _12_01_NavigatesToSalesOrderScreen salesOrderScreen;
    private _12_02_CreateSalesOrder createSalesOrder;
    private _12_03_PendingOutboundShipment outboundShipment;

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
        driver = CommonClassMainButtons.createNewItem(); /*New Sales Order - Select Sales Order to Sales Invoice */
        createSalesOrder.selectCustomerAccount();  /* Select Customer Account*/
        createSalesOrder.selectCurruncy("LKR",5); /*select Curuncy Unit from Dropdown*/
        createSalesOrder.selectSalesUnit(); /*select Sales Unit from Dropdown */
        Assert.assertEquals(createSalesOrder.getAccountOwnerName(),"PereraTest\n" + "Perera"); //Verify that Account owner is autofilled
        createSalesOrder.addProduct("Lot-Pro-1310");  /*Click on Product Search icon and add a product*/
        createSalesOrder.selectWareHouse("1310-1 [1310-ProductIn]"); /* Select a warehouse from the warehouse dropdown.*/
        createSalesOrder.enterQtyAndPrice(quantity,price); /*Enter Qty & Unit Price*/
        createSalesOrder.checkTotal("2,000.00");  // verify total balace of the available fields
        Assert.assertEquals(CommonClass.draftAndCheckStatus(),"(Draft)");
     //   Assert.assertEquals(createSalesOrder.releaseAndCheckStatus(),"(Released)");
       // createSalesOrder.checkTotalAfterRelesed("2,000.00"); // verify total balace of the available fields after Released
        salesOrderNumber = createSalesOrder.getSalesOrderNumber();  // Get Order Number

    }
    @Test(priority = 3,enabled = true)  //Search for a pending Outbound shipment from Tast List.
    public void SOTC_002(){
        outboundShipment = new _12_03_PendingOutboundShipment(driver);
        driver = CommonClass.homeScreen();  // Go to home Screen
        driver = CommonClass.HomePgeTiles_TaskEvent();  // Click on Task/Event tile And Verify the page header.
        outboundShipment.OutboundShipment(salesOrderNumber);
 //       outboundShipment.releaseAndGoToPage(salesOrderNumber,quantity+".00");
    }




}
