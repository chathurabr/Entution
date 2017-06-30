package Procurement._01_PurchaseOrder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Ramitha on 6/26/2017.
 */
public class InboundShipment {
    public WebDriver driver;
    By inboundShipmentSelectedTile = By.xpath("//*[@id='divTaskTiles']/a"); // Xpath is incorrect

    public  InboundShipment(WebDriver driver){
        this.driver=driver;
    }

    public void inboundship(){
        this.IsTileSelected();
    }

    public void IsTileSelected(){
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.pollingEvery(2, TimeUnit.SECONDS);

       // wait.until(ExpectedConditions.presenceOfElementLocated(inboundShipmentSelectedTile));

    }



}
