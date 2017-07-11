package Procurement._01_PurchaseOrder;

import dataProvider.CommonClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ramitha on 6/26/2017.
 */
public class PurchaseOrderForm {
    public static WebDriver driver;
    //Vendor
    By vendorLookUpIcon = By.xpath("//*[@id='divPO']/div[1]/table/tbody/tr[1]/td[2]/div/span[2]/span");
    By refreshButton = By.xpath("//i[@class='fa fa-rotate-right']");
    By txtBox = By.id("txtg1008");

    By firstVendorSearchedColumn = By.xpath("//*[@id='g1008-t']/table/tbody/tr[1]");
        //Vendor referance number
    By vendorReferanceNumberTextBox = By.id("txtRefNo");
        //Billing address
    By addressTypeSelector = By.id("cboxluBillingAdd");
    By vendorBillingAddressSerchBtn = By.xpath("//*[@id='divPO']/div[1]/table/tbody/tr[5]/td[2]/div/span/span");
    By billingAddressEnterBtn = By.xpath("//a[@class='button'][text()=\"Apply\"]");
    //Order Group
    By orderGroupDD = By.id("cboxOrderCatagory");
    //Warehouse
    By wareHouse = By.id("cboxLogWarehouse");
    By warehouseAddressTextBox = By.id("txtShipAddress");
    By addressTextBox = By.id("txtluBillingAdd");
    //Product
    By productLookUpBtn = By.xpath("//*[@id='tblPurchaseOrder']/tbody/tr/td[11]/span");
    By productWindow = By.xpath("//div[@class='dialogbox color-selectedborder ui-draggable first']");
    By productSearchTxtField = By.id("txtg1010");
    By productTblCOlumnOne = By.xpath("//*[@id='g1010-t']/table/tbody/tr");
        //Product warehouse
    By productWarehouseSelector = By.xpath("//*[@id='tblPurchaseOrder']/tbody/tr/td[10]/select");

    //Enter qty
    By qtyTextBox = By.xpath("//*[@id='tblPurchaseOrder']/tbody/tr/td[17]/input");
    By unitPriceTextBox = By.xpath("//*[@id='tblPurchaseOrder']/tbody/tr/td[19]/input");
    //Calculated values
    By lineTotal = By.xpath("//*[@id='tblPurchaseOrder']/tbody/tr/td[23]/input");
    //Banner values
    By bannerTotal = By.id("bannerTotal");
    By bannerTotQty = By.id("bannerTotQty");
    By qtyValueInLine = By.xpath("//*[@id='tblPurchaseOrder']/tbody/tr/td[17]/input");
    //Go to page window
    By gotoPageLnk = By.xpath("//div[@id='dlgAutoGenNotifications']/a");
    By okButton = By.xpath("//div[@class='dialogbox-buttonarea']/a");
    //Purchase order number
    By purchaseOrderNumb = By.id("lblTemplateFormHeader");

    public PurchaseOrderForm(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void purchaseOrderFO(String vendorRefN,String SelectGroup,String warehouseName,String vendorBillingAddress,String productName,String productWarehouseName,String qty,String UnitPrice ){
        this.vendorLookUpButton();
        this.selectVendor();
        this.vendorReferanceNumber(vendorRefN);
        this.orderGroup(SelectGroup);
        this.warehouse(warehouseName);
        this.warehouseAddress();
        this.vendorBillingAdd(vendorBillingAddress);
        this.productLookup(productName);
        this.selectWarehouse(productWarehouseName);
        this.qtyAndUnitPrice(qty,UnitPrice);
        this.getLineTotal();
        this.getUnitsInBanner();
        this.getUnitsFromLine();
        this.okbtnAction();
        this.purchaseOrderNumberExtract();

    }
    public void vendorLookUpButton(){
        Actions action = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.pollingEvery(2, TimeUnit.SECONDS);
        //Click on the vendor lookup button
        wait.until(ExpectedConditions.presenceOfElementLocated(vendorLookUpIcon));
        WebElement venLookup = driver.findElement(vendorLookUpIcon);
        action.moveToElement(venLookup).click().build().perform();
            System.out.println("<font color='red'>Vendor look-up window opened</font>");
        Reporter.log("Vendor look-up window opened");

    }

    public void selectVendor(){
        //Select vendor method
        Actions action = new Actions (driver);
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.pollingEvery(2, TimeUnit.SECONDS);
        //Refresh button click
        WebElement textBox = driver.findElement(txtBox);
        wait.until(ExpectedConditions.elementToBeClickable(textBox));
        action.moveToElement(textBox).sendKeys(Keys.ENTER).build().perform();
        //firstVendorSearchedColumn
        WebElement firstColumn = driver.findElement(firstVendorSearchedColumn);

        if(firstColumn.isDisplayed()) {
            action.moveToElement(firstColumn).doubleClick().build().perform();
        }else {
            action.moveToElement(textBox).sendKeys(Keys.ENTER).build().perform();
            wait.until(ExpectedConditions.elementToBeClickable(firstColumn));
            action.moveToElement(firstColumn).doubleClick().build().perform();
        }
    }

    public void vendorReferanceNumber(String vendorRefN){
        //Insert vendor referance number
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.pollingEvery(2, TimeUnit.SECONDS);

        WebElement vendorRefNumbTxtBx = driver.findElement(vendorReferanceNumberTextBox);
        vendorRefNumbTxtBx.click();
        vendorRefNumbTxtBx.clear();
        vendorRefNumbTxtBx.sendKeys(vendorRefN);
            System.out.println("Vendor reference number entered");
            Reporter.log("Vendor reference number entered");
    }

    public void vendorBillingAdd(String vendorBillingAddress){
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.pollingEvery(2, TimeUnit.SECONDS);
        // Click on the biing address search button
        WebElement venBillingSrchBtn = driver.findElement(vendorBillingAddressSerchBtn);
        wait.until(ExpectedConditions.presenceOfElementLocated(vendorBillingAddressSerchBtn));
        venBillingSrchBtn.click();
        // Select the address type
        WebElement addressSelector = driver.findElement(addressTypeSelector);
        wait.until(ExpectedConditions.presenceOfElementLocated(addressTypeSelector));
        Select dropDown = new Select(addressSelector);
        dropDown.selectByVisibleText("Billing Address");
        // Enter new billing address
        WebElement txtBox = driver.findElement(addressTextBox);
        wait.until(ExpectedConditions.elementToBeClickable(txtBox));
        txtBox.click();
        txtBox.clear();
        txtBox.sendKeys(vendorBillingAddress);
        //Click on the apply button
        WebElement billingAddressEnterBtton = driver.findElement(billingAddressEnterBtn);
        wait.until(ExpectedConditions.elementToBeClickable(billingAddressEnterBtton));
        billingAddressEnterBtton.click();
            System.out.println("Vendor billing address entered");
            Reporter.log("Vendor billing address entered");

    }

    //10. Select a Order group from the drop down.
    public void orderGroup(String SelectGroup){
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.pollingEvery(2, TimeUnit.SECONDS);

        WebElement OrderGroupDropDown = driver.findElement(orderGroupDD);
        wait.until(ExpectedConditions.elementToBeClickable(OrderGroupDropDown));

        Select dropdown = new Select(OrderGroupDropDown);
        dropdown.selectByVisibleText(SelectGroup);
            System.out.println("Order group "+SelectGroup+" Selected");
            Reporter.log("Order group "+SelectGroup+" Selected");
    }
    //11. Select a Warehouse from the drop down.
    public void warehouse(String warehouseName){
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.pollingEvery(2, TimeUnit.SECONDS);

        WebElement OrderGroupDropDown = driver.findElement(wareHouse);
        wait.until(ExpectedConditions.elementToBeClickable(OrderGroupDropDown));

        Select dropdown = new Select(OrderGroupDropDown);//
        dropdown.selectByVisibleText(warehouseName);
            System.out.println("Warehouse Name : "+warehouseName+" Selected");
    }
    //12. Verify the warehouse address is Available in the shipping address.
    public String warehouseAddress(){

        CommonClass.sleepTime(3000);
        String st = null;
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.pollingEvery(2, TimeUnit.SECONDS);

        WebElement wareHouseAddressTxtBx = driver.findElement(warehouseAddressTextBox);
        wait.until(ExpectedConditions.presenceOfElementLocated(warehouseAddressTextBox));

        return driver.findElement(warehouseAddressTextBox).getAttribute("value");
    }
    //13. Eneter a Shipping Address ( If shipping address is not Available after clicking a Warehouse ).

                            /*Shipping address is available*/

    //14. Click on Product Lookup icon - Search add lot product
    public void productLookup(String productName){
        Actions action = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.pollingEvery(2, TimeUnit.SECONDS);
        //Click on the product lookup button
        WebElement productLookUp = driver.findElement(productLookUpBtn);
        wait.until(ExpectedConditions.elementToBeClickable(productLookUp));
        productLookUp.click();
        //Wait until product window pops
        wait.until(ExpectedConditions.presenceOfElementLocated(productWindow));
            System.out.println("Product window opened");
            Reporter.log("Product window opened");
        //send product name to search text field productSearchTxtField
        WebElement srchTxtField = driver.findElement(productSearchTxtField);
        wait.until(ExpectedConditions.elementToBeClickable(srchTxtField));
        action.moveToElement(srchTxtField).click().sendKeys(productName).sendKeys(Keys.ENTER)
                                          .build().perform();
        CommonClass.sleepTime(3000);
        //Click on the 1st column
        WebElement colOne = driver.findElement(productTblCOlumnOne);
        wait.until(ExpectedConditions.presenceOfElementLocated(productTblCOlumnOne));
        action.moveToElement(colOne).doubleClick().build().perform();
    }
    //15. Select a warehouse from the warehouse dropdown ( Near the Product).
    public void selectWarehouse(String productWarehouseName){
        Actions action = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.pollingEvery(2, TimeUnit.SECONDS);

        WebElement warehouseSelector = driver.findElement(productWarehouseSelector);
        Select warehouseSelect = new Select(warehouseSelector);
        warehouseSelect.selectByVisibleText("1310-1 [1310-ProductIn]");

    }
    //16. Enter Qty
    //17. Enter a Unit Price.
    public void qtyAndUnitPrice(String qty,String UnitPrice){

        Actions action = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.pollingEvery(2, TimeUnit.SECONDS);

        WebElement qtyTxtBx = driver.findElement(qtyTextBox);
        WebElement unitPriceTxtBx = driver.findElement(unitPriceTextBox);
        //QTY
        wait.until(ExpectedConditions.elementToBeClickable(qtyTxtBx));
        qtyTxtBx.click();
        qtyTxtBx.clear();
        qtyTxtBx.sendKeys(qty);
        qtyTxtBx.sendKeys(Keys.ENTER);
        //UnitPrice
        wait.until(ExpectedConditions.elementToBeClickable(unitPriceTxtBx));
        unitPriceTxtBx.click();
        unitPriceTxtBx.clear();
        unitPriceTxtBx.sendKeys(UnitPrice);
        unitPriceTxtBx.sendKeys(Keys.ENTER);
    }

    //20. Click on Check-out button.


    //Get lineTotal amount
    public String getLineTotal(){
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.pollingEvery(2, TimeUnit.SECONDS);

        wait.until(ExpectedConditions.presenceOfElementLocated(lineTotal));
        WebElement ele = driver.findElement(lineTotal);

        return ele.getAttribute("value");
    }

    public String getTotalBannerValue(){
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.pollingEvery(2, TimeUnit.SECONDS);

        wait.until(ExpectedConditions.presenceOfElementLocated(bannerTotal));
        WebElement banner = driver.findElement(bannerTotal);

        return banner.getText();
    }

    public String getUnitsInBanner(){
        CommonClass.sleepTime(3000);
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.pollingEvery(2, TimeUnit.SECONDS);
        WebElement bannerTotaltQty = driver.findElement(bannerTotQty);

        return bannerTotaltQty.getText();
    }
    public  String getUnitsFromLine(){
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.pollingEvery(2, TimeUnit.SECONDS);
        CommonClass.sleepTime(3000);
        WebElement UnitsFromLine = driver.findElement(qtyValueInLine);

        return UnitsFromLine.getText();
    }

    public void okbtnAction(){
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.pollingEvery(2, TimeUnit.SECONDS);

        wait.until(ExpectedConditions.presenceOfElementLocated(okButton));
        WebElement okBtn = driver.findElement(okButton);

        okBtn.click();
    }

    public String purchaseOrderNumberExtract(){
        CommonClass.sleepTime(3000);
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.pollingEvery(2, TimeUnit.SECONDS);
        WebElement poNumbLbl = driver.findElement(purchaseOrderNumb);

        //wait.until(ExpectedConditions.presenceOfElementLocated(purchaseOrderNumb));
        wait.until(ExpectedConditions.visibilityOf(poNumbLbl));
        return poNumbLbl.getText();
    }




}
