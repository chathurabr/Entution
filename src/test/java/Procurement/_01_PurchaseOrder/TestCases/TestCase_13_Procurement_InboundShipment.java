package Procurement._01_PurchaseOrder.TestCases;

import Procurement._01_PurchaseOrder.Calculations.serialBatchCapture;
import Procurement._01_PurchaseOrder.InboundShipment;
import Procurement._01_PurchaseOrder.PurchaseOrderForm;
import dataProvider.CommonClass;
import dataProvider.CommonClassMainButtons;
import dataProvider.CommonJourny;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


/**
 * Created by Ramitha on 6/29/2017.
 */
public class TestCase_13_Procurement_InboundShipment {
    public WebDriver driver;
    TestCase_13_Procurement objTestCase_13_Procurement;
    PurchaseOrderForm objPurchaseOrderForm;
    InboundShipment objInboundShipment;
    serialBatchCapture objserialBatchCapture;

    public String poNumb;
    public String refDocNo;
    public String poBannerVal;
    public String isBannerVal;

    private int LotNo;


//1. Move to the Home page of the system.
//2. Click on Task/Event Tile.
//3. Verify the Page header.
//4. Click on the "Inbound Shipment" Tile. - already selected, so check the "right" sign is appeared or not
@BeforeTest
public void getLotNo() throws org.apache.commons.configuration.ConfigurationException {

    Properties properties =new Properties();
    try {
        String filePath = System.getProperty("user.dir");
        properties.load(new FileInputStream(filePath+"\\util\\Procurement.properties"));
        int getEmpID = Integer.parseInt(properties.getProperty("LotNo"));
        //int get = Integer.parseInt(getEmpID);
        LotNo= getEmpID + 1;

        //	System.out.println(EMP_ID);

    } catch (IOException e) {
        e.printStackTrace();
    }
}

    @AfterTest
    public void saveNewEmpID() throws ConfigurationException {
        String filePath = System.getProperty("user.dir");
        PropertiesConfiguration config = new PropertiesConfiguration(filePath+"\\util\\Procurement.properties");
        config.setProperty("LotNo",LotNo);
        config.save();
    }


    @Test(priority = 1)
    public void getInboundShipmentInterface(){
        poNumb = TestCase_13_Procurement.poNumber;


        driver = CommonClass.homeScreen();
        driver = CommonClassMainButtons.taskEventTileClick();
        //4.
        objInboundShipment = new InboundShipment (driver);
        objInboundShipment.IsTileSelected();
        objInboundShipment.enterSearchPONumber(poNumb);
        CommonClass.sleepTime(4000);
        objInboundShipment.dropdownSelect();


    }
    @Test(priority = 2)
    public void arrowIcnClk(){
        objInboundShipment = new InboundShipment (driver);
        objInboundShipment.arrowSignClick();
    }
    @Test(priority = 3)
    public void moveDriverToInboundShipmentPage(){
        CommonClass.shiftWindows();
    }

    @Test(priority = 4)
    public void verifyHeader(){
        CommonClass.pageHeaderWithLinkChk("Inbound Shipment");
        CommonClass.lblTemplateFormHeader("New");
    }
    //9. Verify the Ref Doc No in the product line
    @Test(priority = 5)
    public void  refDocNoVerify(){
        objInboundShipment = new InboundShipment (driver);
        objInboundShipment.refDocNoInProductLine();
    }
    //10. Verify the no of units displays correctly.
    @Test(priority = 6)
    public void verifyNoOfUnits(){
        objPurchaseOrderForm = new PurchaseOrderForm(driver);
        poBannerVal = TestCase_13_Procurement.poBannerUnitValue;

        objInboundShipment = new InboundShipment (driver);
        isBannerVal = objInboundShipment.verifyNoOfUnitsInBanner();
       // Assert.assertEquals(poBannerVal,isBannerVal);
        System.out.println("objInboundShipment.verifyNoOfUnitsInBanner(); = "+isBannerVal+" / TestCase_13_Procurement.poNumber = " +poBannerVal);
        CommonClass.sleepTime(4000);
        Assert.assertEquals(poBannerVal,isBannerVal);
            Reporter.log("Number of unit displayed correctly,No of unit Equals to the Purchase Order Qty");
            System.out.println("Number of unit displayed correctly,No of unit Equals to the Purchase Order Qty");
    }
    //11. Click on Draft.
    //12. Click on Serial Batch Button.
    @Test(priority = 7)
    public void draftAndCheckStatus(){
        CommonClassMainButtons.checkoutButtonClick();
        CommonClassMainButtons.draftBtnClick();
        CommonClassMainButtons.chkLblStatusDrafted();
    }
    //12. Click on Serial Batch Button.
    @Test(priority = 8)
    public void serialBatchProcess(){
        CommonClassMainButtons.serialBatchButtonClick();
        CommonClass.sleepTime(4000);
        objserialBatchCapture = new serialBatchCapture(driver);
        objserialBatchCapture.productListScan();
        CommonClass.sleepTime(4000);
        objserialBatchCapture.checkProductType("LO"+LotNo,null,null);
        objserialBatchCapture.SerialBacthCaptureUpdateButton();
        objserialBatchCapture.verifyProductHasCaptured();
        objserialBatchCapture.serialCaptureBackButton();
        CommonClass.sleepTime(4000);
        CommonClassMainButtons.releaseBtnClick();
        CommonJourny.informationMsgBox();//close
    }


}
