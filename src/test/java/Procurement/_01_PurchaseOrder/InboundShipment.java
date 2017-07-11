package Procurement._01_PurchaseOrder;

import Procurement._01_PurchaseOrder.Calculations.ProcurementCalculationClass;
import Procurement._01_PurchaseOrder.TestCases.TestCase_13_Procurement;
import dataProvider.CommonClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import java.security.Key;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ramitha on 6/26/2017.
 */
public class InboundShipment {
    public WebDriver driver;
    By inboundShipmentSelectedTile = By.xpath("//*[@id='divTaskTiles']/a"); // Xpath is incorrect
    By taskScheduleSearchBox = By.id("txtComTran");
    By searchBoxDropDown = By.id("txtComTranac");
    //Arrow sign on the searched and selected purchase order
    By arrowIcon = By.xpath("//i[@class='fa fa-sign-in fa-2x']");
    //Product line ref doc number
    By productLineRefDocNo = By.xpath("//*[@id='tblShipmentDetails']/tbody/tr/td[11]");
    //Banner total
    By bannerTotQty = By.id("bannerTotQty");

    public String poNumb;

    public  InboundShipment(WebDriver driver){
        this.driver=driver;
    }

    public void inboundship(String poNumb){

        this.IsTileSelected();
        this.enterSearchPONumber(poNumb);
        this.dropdownSelect();
        this.arrowSignClick();
        this.refDocNoInProductLine();
        this.verifyNoOfUnitsInBanner();
        this.productListScan();
    }

    public void IsTileSelected(){
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.pollingEvery(2, TimeUnit.SECONDS);
        Reporter.log("Inbound Shipment tile has been selected");

       // wait.until(ExpectedConditions.presenceOfElementLocated(inboundShipmentSelectedTile));
    }

    public void enterSearchPONumber(String poNumb){
        Actions action = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.pollingEvery(2, TimeUnit.SECONDS);
        WebElement srchBx = driver.findElement(taskScheduleSearchBox);
        wait.until(ExpectedConditions.elementToBeClickable(taskScheduleSearchBox));
        action.moveToElement(srchBx).click().build().perform();
        srchBx.sendKeys(poNumb);
        Reporter.log("Purchase Order Number entered to the search field");
       // action.moveToElement(srchBx).doubleClick().sendKeys(poNumb).build().perform();
        //action.click().sendKeys(poNumb).sendKeys(Keys.ENTER).build().perform();

    }

    public void dropdownSelect(){
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.pollingEvery(2, TimeUnit.SECONDS);

        WebElement dropDwn = driver.findElement(searchBoxDropDown);
        wait.until(ExpectedConditions.elementToBeClickable(dropDwn));
        dropDwn.click();
        Reporter.log("Purchase order selected");


    }

    public void arrowSignClick(){
        CommonClass.sleepTime(3000);
        Actions action = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.pollingEvery(2, TimeUnit.SECONDS);
        WebElement arrIcn = driver.findElement(arrowIcon);

        wait.until(ExpectedConditions.presenceOfElementLocated(arrowIcon));
        action.moveToElement(arrIcn).click().build().perform();
    }

    public void refDocNoInProductLine(){
        Actions action = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.pollingEvery(2, TimeUnit.SECONDS);

        wait.until(ExpectedConditions.presenceOfElementLocated(productLineRefDocNo));
        WebElement docNo = driver.findElement(productLineRefDocNo);

        poNumb = TestCase_13_Procurement.poNumber;
        //System.out.println("poNumb" +poNumb +" attribute"+docNo.getText());
        Assert.assertEquals(poNumb,docNo.getText());

            Reporter.log("Ref Doc No compared with Purchase Order Number");
            System.out.println("Ref Doc No compared with Purchase Order Number");

    }

    public String verifyNoOfUnitsInBanner(){
        Actions action = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.pollingEvery(2, TimeUnit.SECONDS);
        CommonClass.sleepTime(4000);
        WebElement bannerTot = driver.findElement(bannerTotQty);
        wait.until(ExpectedConditions.presenceOfElementLocated(bannerTotQty));
        return bannerTot.getText();

    }

    public void productListScan(){
        CommonClass.sleepTime(3000);
        try {
            List<WebElement> lis = driver.findElements(By.tagName("li"));
            for (int i = 0; i < lis.size(); i++) {
                String str = lis.get(i).getText();
                System.out.println("li element get text value is : " +str );
                // System.out.println("li element attribute val value is : "+li.get(i).getAttribute("value"));

            }
        }catch (Exception e){
            System.out.println(e);
        }
    }




}
