package SalesAndMarketing.testCases;

import SalesAndMarketing._12_SalesAndMarketingModule_SalesOrder.*;
import dataProvider.CommonClass;
import dataProvider.CommonClassMainButtons;
import dataProvider.CommonScreenshot;
import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by chathura on 6/27/2017.
 */
public class TestCase_2_SalesOrderToSalesInvoice_Service {
    public WebDriver driver;
    Robot rb;

    private String salesOrderNumber;
    private String price;
    private String quantity;
    private String discountPercentage;
    private String discountValue;
    private String lineTotal;;
    private String SubTotal;
    private String bannerTotal;
    private String taxValue;

    private String lineTotal_SI;
    private String SubTotal_SI;
    private String bannerTotal_SI;
    private String discountValue_SI;
    private String taxValue_SI;
    private String invoicePercentage;
    private String salesInvoiceNumber;

    private int setInvoicePercentage;

    private _12_01_NavigatesToSalesOrderScreen salesOrderScreen;
    private _12_02_CreateSalesOrder createSalesOrder;
    private _12_04_PendingSalesInvoice pendingSalesInvoice;

    @BeforeTest
    public void beforeTest() throws ConfigurationException {
        Calculations.getValues();
        driver = CommonClass.driverInstance();
        driver = CommonClassMainButtons.loginMeth();
        driver = CommonClassMainButtons.MainMenuNav();
        driver = CommonClass.moduleNavigation("SALES & MARKETING");
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

        invoicePercentage = Calculations.getInvoicePercentage();
        lineTotal_SI =Calculations.lineTotalCalculationWithInvoicePercentage();
        SubTotal_SI = Calculations.subTotalCalculationWithInvoicePercentage();
        bannerTotal_SI = Calculations.bannerTotalCalculationWithInvoicePercentage();
        discountValue_SI = Calculations.discountValueCalculationWithInvoicePercentage();
        taxValue_SI = Calculations.taxValueCalculationWithInvoicePercentage();

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

    @Test(priority = 2) //Create sales order (Sales order to Sales invoice - Services)
    public void sales_Order(){
        createSalesOrder = new _12_02_CreateSalesOrder(driver);
        createSalesOrder.CreateSalesOrder_SalesOrderToSalesInvoice_Service();   /*New Sales Order - Select Sales Order to Sales Invoice */
        createSalesOrder.selectCustomerAccount();  /* Select Customer Account*/
        createSalesOrder.selectCurruncy("LKR",5); /*select Curuncy Unit from Dropdown*/
        createSalesOrder.selectSalesUnit(); /*select Sales Unit from Dropdown */
        Assert.assertEquals(createSalesOrder.getAccountOwnerName(),"PereraTest\n" + "Perera"); //Verify that Account owner is autofilled
        createSalesOrder.addProduct("Service-Pro-1310");  /*Click on Product Search icon and add a product*/
        createSalesOrder.enterQtyAndPrice(quantity,price); /*Enter Qty & Unit Price*/
        createSalesOrder.clickButtonCheckout(); /*click ckheckout button*/
//        createSalesOrder.checkTotalBeforeDiscount(lineTotal,quantity);
        createSalesOrder.selectTaxGroup("VAT15%");    //  Add tax Group   /* comment this line for remove selecting tax group */
        createSalesOrder.clickButtonCheckout(); /*click ckheckout button*/
        createSalesOrder.enterDiscountValueAndVerifyPercentage(discountPercentage,discountValue); /*Enter Discount value and Verify the Discount Percentage is correct*/
        createSalesOrder.enterDiscountPercentageAndVerifyValue(discountPercentage,discountValue);  /*Enter Discont Percentage and Verify the Discount value is correct*/
        createSalesOrder.clickButtonCheckout(); /*click ckheckout button*/
        createSalesOrder.checkTotalBeforeDraftWithTax(lineTotal,SubTotal,bannerTotal, discountValue,quantity,taxValue);  // verify total balace of the available fields
        Assert.assertEquals(CommonClass.draftAndCheckStatus(),"(Draft)");
        Assert.assertEquals(CommonClass.release_Ok_AndCheckStatus(),"(Released)");
        CommonClass.sleepTime(2000);
        createSalesOrder.checkTotalAfterRelesedWithTax(lineTotal,SubTotal,bannerTotal,discountValue,quantity,taxValue); // verify total balace of the available fields after Released
        salesOrderNumber = createSalesOrder.getSalesOrderNumber();  // Get sales Order Number
        System.out.println("salesOrderNumber: "+salesOrderNumber);

    }

    @Test(priority = 3,enabled = true) // Search for a pending Sales invoice from Tast List.
    public void sales_Invoice(){
        pendingSalesInvoice = new _12_04_PendingSalesInvoice(driver);
        driver = CommonClass.homeScreen();  // Go to home Screen
        driver = CommonClass.HomePgeTiles_TaskEvent();  // Click on Task/Event tile And Verify the page header.
        pendingSalesInvoice.selectSalesInvoice(); //  Click on the "Sales Invoice" tile.
        pendingSalesInvoice.searchOrderNumber(salesOrderNumber); // search using sales Order Number
        pendingSalesInvoice.sales_Invoice(salesOrderNumber);
        pendingSalesInvoice.addInvoicePercentage(invoicePercentage);
        Assert.assertEquals(pendingSalesInvoice.getInvoicePercentage(),invoicePercentage);
        System.out.println("Set InvoicePercentage :"+invoicePercentage);
        pendingSalesInvoice.checkTotal(lineTotal_SI,SubTotal_SI,bannerTotal_SI,discountValue_SI,quantity,taxValue_SI);  // verify total balace of the available fields
        Assert.assertEquals(CommonClass.draftAndCheckStatus(),"(Draft)"); /*Draft and verify order status*/
        Assert.assertEquals(CommonClass.releaseAndCheckStatus(),"(Released)");/*Release and Sales invoice status*/
        salesInvoiceNumber = pendingSalesInvoice.getSalesInvoiceNumber();  // Get sales Order Number
        System.out.println("salesInvoiceNumber: "+salesInvoiceNumber);
        driver.close();
        CommonClass.backToOldBrowserTab();


    }


    @Test(priority = 4,enabled = true) // Search for a pending Sales invoice from Tast List.
    public void sales_Invoice2(){

        Properties properties =new Properties();
        try {
            String filePath = System.getProperty("user.dir");
            properties.load(new FileInputStream(filePath+"\\util\\Sales.properties"));
            setInvoicePercentage = Integer.parseInt(properties.getProperty("InvoicePercentage2"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        pendingSalesInvoice = new _12_04_PendingSalesInvoice(driver);
        Calculations.setInvoicePercentage(setInvoicePercentage);
        invoicePercentage = Calculations.getInvoicePercentage();
        lineTotal_SI =Calculations.lineTotalCalculationWithInvoicePercentage();
        SubTotal_SI = Calculations.subTotalCalculationWithInvoicePercentage();
        bannerTotal_SI = Calculations.bannerTotalCalculationWithInvoicePercentage();
        discountValue_SI = Calculations.discountValueCalculationWithInvoicePercentage();
        taxValue_SI = Calculations.taxValueCalculationWithInvoicePercentage();

        if (setInvoicePercentage>0){
            driver = CommonClass.homeScreen();  // Go to home Screen
            driver = CommonClass.HomePgeTiles_TaskEvent();  // Click on Task/Event tile And Verify the page header.
            pendingSalesInvoice.selectSalesInvoice(); //  Click on the "Sales Invoice" tile.
            pendingSalesInvoice.searchOrderNumber(salesOrderNumber); // search using sales Order Number
            pendingSalesInvoice.sales_Invoice(salesOrderNumber);
            System.out.println("Remaining invoice Percentage :"+pendingSalesInvoice.getInvoicePercentage());
            pendingSalesInvoice.addInvoicePercentage(invoicePercentage);
            Assert.assertEquals(pendingSalesInvoice.getInvoicePercentage(),invoicePercentage);
            System.out.println("Set InvoicePercentage :"+invoicePercentage);
            pendingSalesInvoice.checkTotal(lineTotal_SI,SubTotal_SI,bannerTotal_SI,discountValue_SI,quantity,taxValue_SI);  // verify total balace of the available fields
            Assert.assertEquals(CommonClass.draftAndCheckStatus(),"(Draft)"); /*Draft and verify order status*/
            Assert.assertEquals(CommonClass.releaseAndCheckStatus(),"(Released)");/*Release and Sales invoice status*/
            salesInvoiceNumber = pendingSalesInvoice.getSalesInvoiceNumber();  // Get sales Order Number
            System.out.println("salesInvoiceNumber: "+salesInvoiceNumber);
            driver.close();
            CommonClass.backToOldBrowserTab();
        }
        else {
            CommonClass.backToSalesOrderTab();
            createSalesOrder = new _12_02_CreateSalesOrder(driver);
            Assert.assertEquals(createSalesOrder.verifySalesInvoiceCompletion(),"16");
            System.out.println("Invoice completed : "+Calculations.verifyCompletionOfSalesInvoice() +"%");

        }



    }

    @Test(priority = 5,enabled = true) // Search for a pending Sales invoice from Tast List.
    public void sales_Invoice3(){
        pendingSalesInvoice = new _12_04_PendingSalesInvoice(driver);

        Properties properties =new Properties();
        try {
            String filePath = System.getProperty("user.dir");
            properties.load(new FileInputStream(filePath+"\\util\\Sales.properties"));
            setInvoicePercentage = Integer.parseInt(properties.getProperty("InvoicePercentage3"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Calculations.setInvoicePercentage(setInvoicePercentage);
        invoicePercentage = Calculations.getInvoicePercentage();
        lineTotal_SI =Calculations.lineTotalCalculationWithInvoicePercentage();
        SubTotal_SI = Calculations.subTotalCalculationWithInvoicePercentage();
        bannerTotal_SI = Calculations.bannerTotalCalculationWithInvoicePercentage();
        discountValue_SI = Calculations.discountValueCalculationWithInvoicePercentage();
        taxValue_SI = Calculations.taxValueCalculationWithInvoicePercentage();

        if (setInvoicePercentage>0){
            driver = CommonClass.homeScreen();  // Go to home Screen
            driver = CommonClass.HomePgeTiles_TaskEvent();  // Click on Task/Event tile And Verify the page header.
            pendingSalesInvoice.selectSalesInvoice(); //  Click on the "Sales Invoice" tile.
            pendingSalesInvoice.searchOrderNumber(salesOrderNumber); // search using sales Order Number
            pendingSalesInvoice.sales_Invoice(salesOrderNumber);
            System.out.println("Remaining invoice Percentage :"+pendingSalesInvoice.getInvoicePercentage());
            pendingSalesInvoice.addInvoicePercentage(invoicePercentage);
            Assert.assertEquals(pendingSalesInvoice.getInvoicePercentage(),invoicePercentage);
            System.out.println("Set InvoicePercentage :"+invoicePercentage);
            pendingSalesInvoice.checkTotal(lineTotal_SI,SubTotal_SI,bannerTotal_SI,discountValue_SI,quantity,taxValue_SI);  // verify total balace of the available fields
            Assert.assertEquals(CommonClass.draftAndCheckStatus(),"(Draft)"); /*Draft and verify order status*/
            Assert.assertEquals(CommonClass.releaseAndCheckStatus(),"(Released)");/*Release and Sales invoice status*/
            salesInvoiceNumber = pendingSalesInvoice.getSalesInvoiceNumber();  // Get sales Order Number
            System.out.println("salesInvoiceNumber: "+salesInvoiceNumber);
            driver.close();
            CommonClass.backToOldBrowserTab();
        }
        else {
            CommonClass.backToSalesOrderTab();
            createSalesOrder = new _12_02_CreateSalesOrder(driver);
            Assert.assertEquals(createSalesOrder.verifySalesInvoiceCompletion(),"16");
            System.out.println("Invoice completed : "+Calculations.verifyCompletionOfSalesInvoice() +"%");

        }
    }

    @Test(priority = 6,enabled = true) // Search for a pending Sales invoice from Tast List.
    public void sales_Invoice4(){
        pendingSalesInvoice = new _12_04_PendingSalesInvoice(driver);

        Properties properties =new Properties();
        try {
            String filePath = System.getProperty("user.dir");
            properties.load(new FileInputStream(filePath+"\\util\\Sales.properties"));
            setInvoicePercentage = Integer.parseInt(properties.getProperty("InvoicePercentage4"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Calculations.setInvoicePercentage(setInvoicePercentage);
        invoicePercentage = Calculations.getInvoicePercentage();
        lineTotal_SI =Calculations.lineTotalCalculationWithInvoicePercentage();
        SubTotal_SI = Calculations.subTotalCalculationWithInvoicePercentage();
        bannerTotal_SI = Calculations.bannerTotalCalculationWithInvoicePercentage();
        discountValue_SI = Calculations.discountValueCalculationWithInvoicePercentage();
        taxValue_SI = Calculations.taxValueCalculationWithInvoicePercentage();

        if (setInvoicePercentage>0){
            driver = CommonClass.homeScreen();  // Go to home Screen
            driver = CommonClass.HomePgeTiles_TaskEvent();  // Click on Task/Event tile And Verify the page header.
            pendingSalesInvoice.selectSalesInvoice(); //  Click on the "Sales Invoice" tile.
            pendingSalesInvoice.searchOrderNumber(salesOrderNumber); // search using sales Order Number
            pendingSalesInvoice.sales_Invoice(salesOrderNumber);
            System.out.println("Remaining invoice Percentage :"+pendingSalesInvoice.getInvoicePercentage());
            pendingSalesInvoice.addInvoicePercentage(invoicePercentage);
            /*invoicePercentage = Double.parseDouble(pendingSalesInvoice.getInvoicePercentage());*/
            System.out.println("Set InvoicePercentage :"+invoicePercentage);
            pendingSalesInvoice.checkTotal(lineTotal_SI,SubTotal_SI,bannerTotal_SI,discountValue_SI,quantity,taxValue_SI);  // verify total balace of the available fields
            Assert.assertEquals(CommonClass.draftAndCheckStatus(),"(Draft)"); /*Draft and verify order status*/
            Assert.assertEquals(CommonClass.releaseAndCheckStatus(),"(Released)");/*Release and Sales invoice status*/
            salesInvoiceNumber = pendingSalesInvoice.getSalesInvoiceNumber();  // Get sales Order Number
            System.out.println("salesInvoiceNumber: "+salesInvoiceNumber);
            CommonClass.backToOldBrowserTab();
            CommonClass.backToSalesOrderTab();
            createSalesOrder = new _12_02_CreateSalesOrder(driver);
            Assert.assertEquals(createSalesOrder.verifySalesInvoiceCompletion(),"16");
            System.out.println("Invoice completed : "+Calculations.verifyCompletionOfSalesInvoice() +"%");
        }
        else {
            CommonClass.backToSalesOrderTab();
            createSalesOrder = new _12_02_CreateSalesOrder(driver);
            Assert.assertEquals(createSalesOrder.verifySalesInvoiceCompletion(),"16");
            System.out.println("Invoice completed : "+Calculations.verifyCompletionOfSalesInvoice() +"%");

        }

    }







   /* @Test(priority = 5,enabled = false) // Search for a pending Sales invoice from Tast List.
    public void sales_Invoice_Second(){
        pendingSalesInvoice = new _12_04_PendingSalesInvoice(driver);

        invoicePercentage = Calculations.restOfInvoicePercentageCalculation();
        lineTotal_SI =Calculations.lineTotalCalculationRestOfInvoicePercentage();
        SubTotal_SI = Calculations.subTotalCalculationRestOfInvoicePercentage();
        bannerTotal_SI = Calculations.bannerTotalCalculationRestOfInvoicePercentage();
        discountValue_SI = Calculations.discountValCalculationRestOfInvoicePercentage();
        taxValue_SI = Calculations.taxValueCalculationRestOfInvoicePercentage();

        driver = CommonClass.homeScreen();  // Go to home Screen
        driver = CommonClass.HomePgeTiles_TaskEvent();  // Click on Task/Event tile And Verify the page header.
        pendingSalesInvoice.selectSalesInvoice(); //  Click on the "Sales Invoice" tile.
        pendingSalesInvoice.searchOrderNumber(salesOrderNumber); // search using salesOrderNumber
        pendingSalesInvoice.sales_Invoice(salesOrderNumber);
        System.out.println("invoicePercentage :"+invoicePercentage);
     //   Assert.assertEquals(pendingSalesInvoice.getInvoicePercentage(),invoicePercentage);
        pendingSalesInvoice.checkTotal(lineTotal_SI,SubTotal_SI,bannerTotal_SI,discountValue_SI,quantity,taxValue_SI);  // verify total balace of the available fields
        Assert.assertEquals(CommonClass.draftAndCheckStatus(),"(Draft)"); *//*Draft and verify order status*//*
        Assert.assertEquals(CommonClass.releaseAndCheckStatus(),"(Released)");*//*Release and Sales invoice status*//*
        salesInvoiceNumber = pendingSalesInvoice.getSalesInvoiceNumber();  // Get sales Order Number
        System.out.println("salesInvoiceNumber: "+salesInvoiceNumber);

    }
*/




}
