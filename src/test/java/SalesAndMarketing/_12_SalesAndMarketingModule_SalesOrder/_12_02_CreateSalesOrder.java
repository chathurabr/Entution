package SalesAndMarketing._12_SalesAndMarketingModule_SalesOrder;

import SalesAndMarketing.dataProvider.CommonClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;


public class _12_02_CreateSalesOrder {
    WebDriver driver;

    @FindBy(xpath = "//*[@id='btnUpdate']/b[text()='New Sales Order']")
    private WebElement btnNewSalesOrser;
    @FindBy(xpath = "//span[text()='Sales Order to Sales Invoice']")
    private WebElement btnSalesOrderToSalesInvoice;
    @FindBy(xpath = "//span[text()='Sales Order to Outbound Shipment']")
    private WebElement btnSalesOrderToOutboundShipment;
    @FindBy(xpath = "//*[@id='lbldocstatus'][text()='New']")
    private WebElement lblPageHeaderNewSalesOrder;
    @FindBy(id = "cboxCurrency")
    private WebElement cboxCurrency;
    @FindBy(xpath = "//*[@id='divSO']/div[1]/table/tbody/tr[1]/td[2]/div/span[2]/span")
    private WebElement searchIconSelectCustomer;
    private By buttonRefresh = By.xpath( "//i[@class='fa fa-rotate-right']");
    @FindBy (xpath = "//*[@id='g1012-t']/table/tbody/tr[1]/td[6]")
    private WebElement firstAccountCodeInTheTable;
    @FindBy(xpath = "//span[@class='headertext'][contains(text(),'Account')]")
    private WebElement lblHeaderAccounts_info_popup;
    @FindBy(id = "cboxAccOwner")
    private WebElement txtAccountOwner;
    @FindBy(xpath = "//span[@class='pic16 pic16-search picalign'][@title='Product Lookup']")
    private WebElement iconProductSearch;
    @FindBy(xpath = "//input[@class='filterPhrase bypage-search']")
    private WebElement txtSearchProduct2;
    private By txtSearchProduct = By.xpath( "//input[@class='filterPhrase bypage-search']");
    @FindBy(xpath = "//span[@class='headertext'][contains(text(),'Product')]")
    private WebElement lblHeaderProduct_info_popup;
    @FindBy(xpath = "//*[@id='g1010-t']/table/tbody/tr/td[6]")
    private WebElement firstSearchedProduct;
    @FindBy(xpath = "//*[@id='tblSalesOrder']/tbody/tr/td[10]/select")
    private WebElement ddWareHouse;
    @FindBy(xpath = "//*[@id='tblSalesOrder']/tbody/tr/td[17]/input[@coltype='Q']")
    private WebElement txtQuantity;
    @FindBy(xpath = "//*[@id='tblSalesOrder']/tbody/tr/td[18]/input[@coltype='UP']")
    private WebElement txtUnitPrice;
    @FindBy(xpath = "//*[@id='tblSalesOrder']/tbody/tr/td/input[@coltype='DP']")
    private WebElement txtDiscountPercentage;
    @FindBy(xpath = "//*[@id='tblSalesOrder']/tbody/tr/td/input[@coltype='D']")
    private WebElement txtDiscountValue;

    @FindBy(xpath = "//span[@class='pic16 pic16-checkout']")
    private WebElement btnCheckout;
    @FindBy(xpath = "//input[@class='el-resize21 gcd']")
    private WebElement  txtlineTotal;
    @FindBy(xpath = "//div[@class='el-resize19']")
    private WebElement txtlineTotalRelesed;
    @FindBy(xpath = "//input[@id='txtUnitTot']")
    private WebElement txtUnitTotal;
    @FindBy(xpath = "//input[@id='txtSubTot']")
    private WebElement txtSubTotal;
    @FindBy(xpath = "//input[@id='txtNetAmt']")
    private WebElement txtTotal;
    @FindBy(xpath = "//h1[@id='bannerTotal']")
    private WebElement txtBannerTotal;
    @FindBy(xpath = "//*[@id='permissionBar']/a[text()='Draft']")
    private WebElement btnDraft;
    @FindBy(xpath = "//*[@id='permissionBar']/a[text()='Release'] ")
    private WebElement btnRelease;
    @FindBy(xpath = "//label[@id='lbldocstatus']")
    private WebElement lblSalesOrderStatus;
    @FindBy(xpath = "//label[@id='lbldocstatus'][text()='(Draft)']")
    private WebElement lblSalesOrderStatusDraft;
    @FindBy(xpath = "/html/body/div[6]/div[3]/a")
    private WebElement okButtonInformationBox;
    @FindBy(id = "cboxSalesUnitPerson")
    private WebElement ddSalesUnit;
    @FindBy(xpath = "//label[@id='lblTemplateFormHeader']")
    private WebElement lblStatus;
    @FindBy(xpath = "//input[@id='txtDiscountTot']")
    private WebElement txtDisountTotalValue;
    @FindBy(xpath = "//*[@id='bannerTotQty']")
    private WebElement lblBannerNumberOfUnits;



    public _12_02_CreateSalesOrder(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /*New Sales Order - Select Sales Order to Sales Invoice */
    public void CreateSalesOrder_SalesOrderToSalesInvoice(){
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.pollingEvery(2,SECONDS);

        wait.until(ExpectedConditions.elementToBeClickable(btnSalesOrderToSalesInvoice));
        btnSalesOrderToSalesInvoice.click();   //Select Sales Order to Sales Invoice (Option One)
    }

    /*New Sales Order - Select Sales Order to Outbound Shipment*/
    public void CreateSalesOrder_SalesOrderToOutboundShipment(){
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(btnNewSalesOrser));
        btnNewSalesOrser.click();   // Click on New Sales Order button
        wait.until(ExpectedConditions.elementToBeClickable(btnSalesOrderToOutboundShipment));
        btnSalesOrderToOutboundShipment.click();   //Select Sales Order to Sales Invoice (Option One)
    }

    /* Select Customer Account*/
    public void selectCustomerAccount() {
        WebDriverWait wait = new WebDriverWait(driver, 40);
        Actions action = new Actions(driver);

        wait.until(ExpectedConditions.elementToBeClickable(lblPageHeaderNewSalesOrder));
        Assert.assertEquals(lblPageHeaderNewSalesOrder.getText(),"New"); // verify Accounts new Sales Order header
        searchIconSelectCustomer.click();

        Assert.assertEquals(lblHeaderAccounts_info_popup.getText(), "Account"); // verify Accounts info new pop-up header
        CommonClass.sleepTime(2000);
        wait.until(ExpectedConditions.elementToBeClickable(buttonRefresh));
        driver.findElement(buttonRefresh).click();
        wait.until(ExpectedConditions.elementToBeClickable(firstAccountCodeInTheTable));
        action.doubleClick(firstAccountCodeInTheTable).perform(); //Double click the first Account
        if (lblHeaderAccounts_info_popup.isDisplayed()) {
            wait.until(ExpectedConditions.elementToBeClickable(firstAccountCodeInTheTable));
            action.doubleClick(firstAccountCodeInTheTable).perform();
        }

    }

    /*select Curuncy Unit from Dropdown*/
    public void selectCurruncy(String currency,int currencyNumber){
        Select selectCurruncy = new Select(cboxCurrency);
        List<WebElement> allCurruncies = selectCurruncy.getOptions();
   /*     for (int j = 0; j < allCurruncies.size(); j++) {
            System.out.println(allCurruncies.get(j).getText());}*/
        String getLKRunit = allCurruncies.get(currencyNumber).getText().trim();
        Assert.assertEquals(getLKRunit,currency);
        selectCurruncy.selectByVisibleText(getLKRunit);
    }

    /*Sales Unit from Dropdown */
    public void selectSalesUnit(){
        Select selectSalesUnit = new Select(ddSalesUnit);
        List<WebElement> e = selectSalesUnit.getOptions();
        String unit = e.get(2).getText().trim();
        selectSalesUnit.selectByVisibleText(unit);

    }

    /*Get autofill Account Owner name*/
    public String getAccountOwnerName(){
        return txtAccountOwner.getText();
    }

    /*Click on Product Search icon and add a Lot product*/
    public void addProduct(String productName){
        Actions action = new Actions (driver);
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(iconProductSearch));
        iconProductSearch.click();
        wait.until(ExpectedConditions.elementToBeClickable(lblHeaderProduct_info_popup));
        //System.out.println(lblHeaderProduct_info_popup.getText());
        action.moveToElement(txtSearchProduct2).sendKeys(productName).sendKeys(Keys.ENTER).build().perform();
        CommonClass.sleepTime(2000);
        wait.until(ExpectedConditions.elementToBeClickable(firstSearchedProduct));
        action.doubleClick(firstSearchedProduct).perform();
        if (lblHeaderProduct_info_popup.isDisplayed()) {
            wait.until(ExpectedConditions.elementToBeClickable(firstSearchedProduct));
            action.doubleClick(firstSearchedProduct).perform();
        }
    }

    /* Select a warehouse from the warehouse dropdown.*/
    public void selectWareHouse(String wareHouseName){
        Select selectSalesUnit = new Select(ddWareHouse);
        selectSalesUnit.selectByVisibleText(wareHouseName);
    }

    /*Enter Qty & Unit Price*/
    public void enterQtyAndPrice(String quantity, String price){
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(txtQuantity));
        txtQuantity.clear();
        actions.moveToElement(txtQuantity).sendKeys(quantity).build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(txtUnitPrice));
        txtUnitPrice.clear();
        actions.moveToElement(txtUnitPrice).sendKeys(price).build().perform();
    }

    /*click checkout button*/
    public void clickButtonCheckout(){
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(btnCheckout));
        btnCheckout.click();
        CommonClass.sleepTime(2000);
    }

    /*Enter Discont Percentage and Verify the Discount value is correct*/
    public void enterDiscountPercentageAndVerifyValue(String percentage, String discountValue ){
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(txtDiscountPercentage));
        actions.moveToElement(txtDiscountPercentage).click();
        txtDiscountPercentage.clear();
        actions.moveToElement(txtDiscountPercentage).sendKeys(percentage).build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(txtDiscountValue));
        txtDiscountValue.click();
        CommonClass.sleepTime(1000);
        Assert.assertEquals(txtDiscountValue.getAttribute("value"),discountValue+".00");
    }

    /*Enter Discount value and Verify the Discount Percentage is correct*/
    public void enterDiscountValueAndVerifyPercentage(String percentage, String discountValue ){
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(txtDiscountValue));
        actions.moveToElement(txtDiscountValue).click();
        txtDiscountValue.clear();
        actions.moveToElement(txtDiscountValue).sendKeys(discountValue).build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(txtDiscountValue));
        txtDiscountPercentage.click();
        CommonClass.sleepTime(1000);
        Assert.assertEquals(txtDiscountPercentage.getAttribute("value"),percentage+".00");
    }



    /*Release and verify sales order status*/
    public String releaseAndCheckStatus(){
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(btnRelease));
        btnRelease.click(); // click on draft button
        wait.until(ExpectedConditions.elementToBeClickable(okButtonInformationBox));
        okButtonInformationBox.click();  // click ok on information dialog box
        wait.until(ExpectedConditions.elementToBeClickable(lblSalesOrderStatus));
        return lblSalesOrderStatus.getText(); // verify Relesed order status

    }


    public String getSalesOrderNumber(){   // Get sales Order Number
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOf(lblStatus));
        return lblStatus.getText();

    }


    /*Verify that total display correctly.*/
    public void checkTotalBeforeDraft(String total,String totalAfterDiscount,String discountTotal,String quantity){
        CommonClass.sleepTime(2000);
        Assert.assertEquals(txtlineTotal.getAttribute("value"),total+".00");
        Assert.assertEquals(txtUnitTotal.getAttribute("value"),total+".00");
        Assert.assertEquals(txtSubTotal.getAttribute("value"),totalAfterDiscount+".00");
        Assert.assertEquals(txtTotal.getAttribute("value"),totalAfterDiscount+".00");  // right bottom corner
        Assert.assertEquals(txtBannerTotal.getText(),totalAfterDiscount+".00");  // Total in the right upper cornner
        Assert.assertEquals(txtDisountTotalValue.getAttribute("value"),discountTotal+".00");  // bottom layer
        Assert.assertEquals(lblBannerNumberOfUnits.getText(),quantity+".00");  // UNITS Total in the right upper cornner


    }


    public void checkTotalBeforeDiscount(String total,String quantity){
        CommonClass.sleepTime(2000);
        Assert.assertEquals(txtlineTotal.getAttribute("value"),total+".00");
        Assert.assertEquals(txtUnitTotal.getAttribute("value"),total+".00");
        Assert.assertEquals(txtSubTotal.getAttribute("value"),total+".00");
        Assert.assertEquals(txtTotal.getAttribute("value"),total+".00");  // right bottom corner
        Assert.assertEquals(txtBannerTotal.getText(),total+".00");  // Total in the right upper cornner
        Assert.assertEquals(lblBannerNumberOfUnits.getText(),quantity+".00");  // UNITS Total in the right upper cornner

    }

    public void checkTotalAfterRelesed(String total,String totalAfterDiscount,String discountTotal, String quantity){
        Assert.assertEquals(txtlineTotalRelesed.getText(),total+".00");
        Assert.assertEquals(txtUnitTotal.getAttribute("value"),total+".00");
        Assert.assertEquals(txtSubTotal.getAttribute("value"),totalAfterDiscount+".00");
        Assert.assertEquals(txtTotal.getAttribute("value"),totalAfterDiscount+".00");  // right bottom corner
        Assert.assertEquals(txtBannerTotal.getText(),totalAfterDiscount+".00");  // Total in the right upper cornner
        Assert.assertEquals(txtDisountTotalValue.getAttribute("value"),discountTotal+".00");  // bottom layer
        Assert.assertEquals(lblBannerNumberOfUnits.getText(),quantity+".00");  // UNITS Total in the right upper cornner
    }
}
