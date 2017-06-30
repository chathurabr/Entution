package Procurement._01_PurchaseOrder.TestCases;

import Procurement._01_PurchaseOrder.InboundShipment;
import dataProvider.CommonClass;
import dataProvider.CommonClassMainButtons;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

/**
 * Created by Ramitha on 6/29/2017.
 */
public class TestCase_13_Procurement_InboundShipment {
    public WebDriver driver;
    InboundShipment objInboundShipment;



//1. Move to the Home page of the system.
//2. Click on Task/Event Tile.
//3. Verify the Page header.
//4. Click on the "Inbound Shipment" Tile. - already selected, so check the "right" sign is appeared or not
    @Test(priority = 1)
    public void getInboundShipmentInterface(){
        driver = CommonClass.homeScreen();
        driver = CommonClassMainButtons.taskEventTileClick();
        //4.
        objInboundShipment = new InboundShipment (driver);
        objInboundShipment.IsTileSelected();
    }
}
