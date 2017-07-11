package Procurement._01_PurchaseOrder.TestCases;

import Procurement._01_PurchaseOrder.Calculations.ProcurementCalculationClass;
import Procurement._01_PurchaseOrder.InboundShipment;
import Procurement._01_PurchaseOrder.InitiatePurchaseOrderSubMod;
import Procurement._01_PurchaseOrder.PurchaseOrderForm;
import dataProvider.CommonClass;
import dataProvider.CommonClassMainButtons;
import dataProvider.CommonScreenshot;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;

/**
 * Created by Ramitha on 6/26/2017.
 */
public class TestCase_13_Procurement {
    public WebDriver driver;
    InitiatePurchaseOrderSubMod objSelectPurchaseOrderSubModule;
    PurchaseOrderForm objPurchaseOrderForm;
    InboundShipment objInboundShipment;
    public String qty = "100.00";
    public String unitPrice ="150.00";
    public static String poNumber;
    public static String poBannerUnitValue;

/*
    public TestCase_13_Procurement(WebDriver driver) {
        this.poNumber=poNumber;
    }
*/

    // private int venReferanceNumb;

    @BeforeClass
    public void beforeTest() {
       CommonClass.driverInstance();
       CommonClassMainButtons.loginMeth();

    }
    @BeforeClass
    public void calculations(){

    }
    @AfterMethod
    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
        driver = CommonScreenshot.takeSnapshot(testResult);
    }
    /*@BeforeTest
    public void VenRefNumbGeneration() throws org.apache.commons.configuration.ConfigurationException {

        Properties properties =new Properties();
        try {
            String filePath = System.getProperty("user.dir");
            properties.load(new FileInputStream(filePath+"\\util\\Procurement.properties"));
            int getVenRefNumb = Integer.parseInt(properties.getProperty("VenRefNumb"));
            //int get = Integer.parseInt(getEmpID);
            venReferanceNumb= getVenRefNumb + 1;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @AfterTest
    public void saveNewEmpID() throws ConfigurationException {
        String filePath = System.getProperty("user.dir");
        PropertiesConfiguration config = new PropertiesConfiguration(filePath+"\\util\\Procurement.properties");
        config.setProperty("VenRefNumb",venReferanceNumb);
        config.save();
    }*/
    //1. Click on Navegation Menu
    @Test(priority = 1)
    public void mainMenu(){
        CommonClassMainButtons.MainMenuNav();
    }
    //2. Click on Procurement
    @Test(priority = 2)
    public void navToPurchaseOrder(){
        driver = CommonClass.moduleNavigation("PROCUREMENT");
    }
    //3. Click on Purchase Order
    @Test(priority = 3)
    public void purchaseOrderModuleNav(){
        objSelectPurchaseOrderSubModule = new InitiatePurchaseOrderSubMod(driver);
        objSelectPurchaseOrderSubModule.selectPurchaseOrderSubModule();
    }
    //4. Verify the By page "Purchase Order"
    @Test(priority = 4)
    public void pageHeaderVerify(){
        objSelectPurchaseOrderSubModule = new InitiatePurchaseOrderSubMod(driver);
        objSelectPurchaseOrderSubModule.isPurchaseOrderLblDisplays();
        driver = CommonClass.pageNameVerifyChk("Purchase Order");
    }
    //5. Click on Purchase Order.
    @Test(priority = 5)
    public void newPurchaseOrder(){
        driver = CommonClassMainButtons.createNewItem("New Purchase Order");
    }

    //6. Click on the "Purchase Order to Shipment Costing jurney".
    @Test(priority = 6)
    public void selectJourneyOne(){
        objSelectPurchaseOrderSubModule = new InitiatePurchaseOrderSubMod(driver);
        objSelectPurchaseOrderSubModule.selectJourney();
    }
    //7. Verify the Purchase Order status.
    @Test(priority = 7)
    public void confirmPageStatusLabel(){
        driver = CommonClass.docStatusLblChk("New");
    }

    //8. Select a Vendor (Select through Look up or search through textbox)
    //9. Enter a Vendor Reference No.
    //9.1 Enter vendor billing address
    @Test(priority = 8)
    public void vendor(){
        objPurchaseOrderForm = new PurchaseOrderForm(driver);
       // vendorLookUp Button click
        objPurchaseOrderForm.vendorLookUpButton();
        //Select a vendor
        objPurchaseOrderForm.selectVendor();
        //Vendor reference number
       // String venRef = Integer.toString(venReferanceNumb); - active if vendorRefNumber has to be unique
        objPurchaseOrderForm.vendorReferanceNumber("VnRef0001");
        //Enter new billing address for a selected vendor
        objPurchaseOrderForm.vendorBillingAdd("No420.Vendor Road, Vendor City");
    }
    //10. Select a Order group from the drop down.
    @Test(priority = 9)
    public void selectOrderGroup(){
        objPurchaseOrderForm = new PurchaseOrderForm(driver);
        objPurchaseOrderForm.orderGroup("T-shirts");
    }
    //11. Select a Warehouse from the drop down.
    @Test(priority = 10)
    public void selectWarehouse(){
        objPurchaseOrderForm = new PurchaseOrderForm(driver);
        objPurchaseOrderForm.warehouse("MilkWarehouse_2_119 [Milk Warehouse 2]");
    }
    //12. Verify the warehouse address is Available in the shipping address.
    @Test(priority = 11)
    public void warehouseAddress(){
        objPurchaseOrderForm = new PurchaseOrderForm(driver);
        Assert.assertEquals(objPurchaseOrderForm.warehouseAddress(),"Tester address");
    }
    //13. Eneter a Shipping Address ( If shipping address is not Available after clicking a Warehouse ).
        /* Shipping Address is available on above mentioned warehouse*/

    //14. Click on Product Lookup icon.
    //15. Select a warehouse from the warehouse dropdown ( Near the Product).
    @Test(priority = 14)
    public void product(){
        objPurchaseOrderForm = new PurchaseOrderForm(driver);
        objPurchaseOrderForm.productLookup("Lot-Pro-1310");
        objPurchaseOrderForm.selectWarehouse("1310-1 [1310-ProductIn]");
    }
    //16. Enter Qty
    //17. Enter a Unit Price
    @Test(priority = 15)
    public void qtyAndUnitPrice(){
        objPurchaseOrderForm = new PurchaseOrderForm(driver);
        objPurchaseOrderForm.qtyAndUnitPrice(qty,unitPrice);
    }
    //20. Click on Check-out button.
    @Test(priority = 16)
    public void checkout(){
        CommonClassMainButtons.checkoutButtonClick();
    }
    //21. Verify that line total displayed  correctly.
    //29. Verify the Total in the right upper cornner of the page(Banner total)
    //30. Verify the Units  in the right upper cornner of the page.
    @Test(priority = 17)
    public void validateLineTotal(){
        Assert.assertEquals(ProcurementCalculationClass.lineTotal(qty,unitPrice),objPurchaseOrderForm.getLineTotal());

        Assert.assertEquals(ProcurementCalculationClass.lineTotal(qty,unitPrice),objPurchaseOrderForm.getTotalBannerValue());

        Assert.assertEquals(poBannerUnitValue = qty,objPurchaseOrderForm.getUnitsInBanner());
    }
    @Test(priority = 18)
    public void draftIt(){
        CommonClassMainButtons.draftBtnClick();
        CommonClassMainButtons.releaseBtnClick();
        objPurchaseOrderForm = new PurchaseOrderForm(driver);
        objPurchaseOrderForm.okbtnAction();

    }
    @Test(priority = 19)
    public void getPONumber(){
        objPurchaseOrderForm = new PurchaseOrderForm(driver);
        poNumber = objPurchaseOrderForm.purchaseOrderNumberExtract();
    }

    @Test(priority = 20)
    public void draftAndRelease() {

        System.out.println("Purchase Order number is : "+poNumber);
//        CommonClass.docStatusLblChk("(Draft)");
    }


    /*@Test(priority = 18)
    public void draftAndRelease() {

        CommonClassMainButtons.draftBtnClick();
        objPurchaseOrderForm = new PurchaseOrderForm(driver);
        objPurchaseOrderForm.purchaseOrderNumberExtract();
        poNumber = objPurchaseOrderForm.purchaseOrderNumberExtract();
        System.out.println("Purchase Order number is : "+poNumber);
        CommonClass.docStatusLblChk("(Draft)");
    }*/
      /*  CommonClassMainButtons.releaseBtnClick();
        CommonClass.docStatusLblChk("Release");
    }
    @Test(priority = 19)
    public void okbtnclick(){
        objPurchaseOrderForm = new PurchaseOrderForm(driver);
        objPurchaseOrderForm.okbtnAction();
    }*/

}
