package SalesAndMarketing.testCases;

import SalesAndMarketing._12_SalesAndMarketingModule_SalesOrder.*;
import SalesAndMarketing.dataProvider.CommonClass;
import SalesAndMarketing.dataProvider.CommonClassMainButtons;
import SalesAndMarketing.dataProvider.CommonScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by chathura on 6/26/2017.
 */
public class TestCase_12_SalesOrderToOutboundShipment_Discount_Tax {
    public WebDriver driver;

    private String salesOrderNumber;
    private String salesInvoiceNumber;

    private String price;
    private String quantity;
    private String discountPercentage;
    private String discountValue;
    private String lineTotal;;
    private String SubTotal;
    private String bannerTotal;
    private String taxValue;


    private _12_01_NavigatesToSalesOrderScreen salesOrderScreen;
    private _12_02_CreateSalesOrder createSalesOrder;
    private _12_03_PendingOutboundShipment outboundShipment;
    private _12_04_PendingSalesInvoice pendingSalesInvoice;

    @BeforeTest
    public void beforeTest(){
        driver = CommonClass.driverInstance();
        driver = CommonClassMainButtons.loginMeth();
        driver = CommonClassMainButtons.MainMenuNav();
        driver = CommonClass.salesAndMketMenuNav();
    }

    @BeforeClass
    public void getCalculations(){
        price = Calculations.getPrice();
        quantity = Calculations.getquantity();
        lineTotal = Calculations.lineTotalCalculation();
        discountPercentage = Calculations.discountPercentageCalculation();
        discountValue = Calculations.discountAmountCalculation();
        SubTotal = Calculations.subTotalCalculation();
        taxValue =Calculations.taxCalculation();
        bannerTotal = Calculations.bannerTotalCalculation();

        System.out.println("price: "+price);
        System.out.println("quantity: "+quantity);
        System.out.println("lineTotal: "+lineTotal);
        System.out.println("discountPercentage: "+discountPercentage);
        System.out.println("discountValue: "+discountValue);
        System.out.println("SubTotal: "+SubTotal);
        System.out.println("taxValue: "+taxValue);
        System.out.println("bannerTotal: "+bannerTotal);



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

    @Test(priority = 2) //Create sales order (Sales order to Sales invoice)
    public void testCase_12_02_SalesInvoice(){
        createSalesOrder = new _12_02_CreateSalesOrder(driver);
        createSalesOrder.CreateSalesOrder_SalesOrderToOutboundShipment();   /*New Sales Order - Sales Order to Outbound Shipment */
        createSalesOrder.selectCustomerAccount();  /* Select Customer Account*/
        createSalesOrder.selectCurruncy("LKR",5); /*select Curuncy Unit from Dropdown*/
        createSalesOrder.selectSalesUnit(); /*select Sales Unit from Dropdown */
        Assert.assertEquals(createSalesOrder.getAccountOwnerName(),"PereraTest\n" + "Perera"); //Verify that Account owner is autofilled
        createSalesOrder.addProduct("Lot-Pro-1310");  /*Click on Product Search icon and add a product*/
        createSalesOrder.selectWareHouse("1310-1 [1310-ProductIn]"); /* Select a warehouse from the warehouse dropdown.*/
        createSalesOrder.enterQtyAndPrice(quantity,price); /*Enter Qty & Unit Price*/
        createSalesOrder.clickButtonCheckout(); /*click ckheckout button*/
        createSalesOrder.checkTotalBeforeDiscount(lineTotal,quantity);
        createSalesOrder.selectTaxGroup("VAT15%");    //  Add tax Group   /* comment this line for remove selecting tax group */
        createSalesOrder.clickButtonCheckout(); /*click ckheckout button*/
        createSalesOrder.enterDiscountPercentageAndVerifyValue(discountPercentage,discountValue);  /*Enter Discont Percentage and Verify the Discount value is correct*/
        createSalesOrder.enterDiscountValueAndVerifyPercentage(discountPercentage,discountValue); /*Enter Discount value and Verify the Discount Percentage is correct*/
        createSalesOrder.clickButtonCheckout(); /*click ckheckout button*/
        createSalesOrder.checkTotalBeforeDraftWithTax(lineTotal,SubTotal,bannerTotal, discountValue,quantity,taxValue);  // verify total balace of the available fields
        Assert.assertEquals(CommonClass.draftAndCheckStatus(),"(Draft)");
        Assert.assertEquals(CommonClass.release_Ok_AndCheckStatus(),"(Released)");
        CommonClass.sleepTime(2000);
        createSalesOrder.checkTotalAfterRelesedWithTax(lineTotal,SubTotal,bannerTotal,discountValue,quantity,taxValue); // verify total balace of the available fields after Released
        salesOrderNumber = createSalesOrder.getSalesOrderNumber();  // Get sales Order Number
        System.out.println(salesOrderNumber+": salesOrderNumber");

    }

    @Test(priority = 3,enabled = true) // Search for a pending Sales invoice from Tast List.
    public void SOTC_003_SalesInvoice(){
        pendingSalesInvoice = new _12_04_PendingSalesInvoice(driver);
        driver = CommonClass.homeScreen();  // Go to home Screen
        driver = CommonClass.HomePgeTiles_TaskEvent();  // Click on Task/Event tile And Verify the page header.
        pendingSalesInvoice.selectSalesInvoice(); //  Click on the "Sales Invoice" tile.
        pendingSalesInvoice.searchOrderNumber(salesOrderNumber); // search using salesOrderNumber
        pendingSalesInvoice.sales_Invoice(salesOrderNumber);
        pendingSalesInvoice.checkTotal_SSO(lineTotal,SubTotal,bannerTotal,discountValue,quantity,taxValue);  // verify total balace of the available fields
        Assert.assertEquals(CommonClass.draftAndCheckStatus(),"(Draft)"); /*Draft and verify order status*/
        Assert.assertEquals(CommonClass.release_Ok_AndCheckStatus(),"(Released)");/*Release and Sales invoice status*/
        salesInvoiceNumber = pendingSalesInvoice.getSalesInvoiceNumber();
      //  System.out.println(salesInvoiceNumber+"salesInvoiceNumber");
    }


    @Test(priority = 4,enabled = true)  //Search for a pending Outbound shipment from Tast List.
    public void SOTC_002_OutboundShipment(){
        outboundShipment = new _12_03_PendingOutboundShipment(driver);
        driver = CommonClass.homeScreen();  // Go to home Screen
        driver = CommonClass.HomePgeTiles_TaskEvent();  // Click on Task/Event tile And Verify the page header.
        outboundShipment.selectOutboundShipment();  //  Click on the "Outbound Shipment" tile.
        outboundShipment.searchSalesOrderNumber(salesInvoiceNumber); // search using salesInvoiceNumber
        outboundShipment.outBoundShipment(salesInvoiceNumber,quantity);
        Assert.assertEquals(CommonClass.draftAndCheckStatus(),"(Draft)");/*Draft and verify order status*/
        Assert.assertEquals(CommonClass.releaseAndCheckStatus(),"(Released)");/*Release and Outbound shipment status*/
    }


}
