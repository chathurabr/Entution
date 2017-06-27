package SalesAndMarketing._12_SalesAndMarketingModule_SalesOrder;

import dataProvider.CommonClass;
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
    @FindBy(id = "txtCusAcc")
    private WebElement txtCusAcc;
    @FindBy(id = "txtBillingAdd")
    private WebElement txtBillingAdd;
    @FindBy(id = "txtShipAddress")
    private WebElement txtShipAddress;
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
    @FindBy(id = "txtTaxTot")
    private WebElement txtTaxTot;
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

    @FindBy(xpath = "//select[@class='el-resize20'] ")
    private WebElement ddTax;



    public _12_02_CreateSalesOrder(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /*New Sales Order - Select Sales Order to Sales Invoice */
    public void CreateSalesOrder_SalesOrderToSalesInvoice(){
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(btnNewSalesOrser));
        btnNewSalesOrser.click();   // Click on New Sales Order button
        System.out.println("Clicked on New Sales Order");;
        wait.until(ExpectedConditions.elementToBeClickable(btnSalesOrderToSalesInvoice));
        btnSalesOrderToSalesInvoice.click();   //Select Sales Order to Sales Invoice (Option One)
        System.out.println("\"Start New Jurney\" window should  poped-up and Click on the \"Sales Order to Sales Invoice jurney\"");
    }

    /*New Sales Order - Select Sales Order to Outbound Shipment*/
    public void CreateSalesOrder_SalesOrderToOutboundShipment(){
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(btnNewSalesOrser));
        btnNewSalesOrser.click();   // Click on New Sales Order button
        System.out.println(" Clicked on New Sales Order");
        wait.until(ExpectedConditions.elementToBeClickable(btnSalesOrderToOutboundShipment));
        btnSalesOrderToOutboundShipment.click();   //Select Sales Order to Sales Invoice (Option One)
        System.out.println("\"Start New Jurney\" window should  poped-up and Click on the \"Sales Order to Sales Invoice jurney\"");
    }

    /* Select Customer Account*/
    public void selectCustomerAccount() {
        WebDriverWait wait = new WebDriverWait(driver, 40);
        Actions action = new Actions(driver);

        wait.until(ExpectedConditions.elementToBeClickable(lblPageHeaderNewSalesOrder));
        Assert.assertEquals(lblPageHeaderNewSalesOrder.getText(),"New"); // verify Accounts new Sales Order header
        System.out.println("Verified the sales order status. - 'New'");
        searchIconSelectCustomer.click();

        Assert.assertEquals(lblHeaderAccounts_info_popup.getText(), "Account"); // verify Accounts info new pop-up header
        System.out.println("\"Account\" window pop-up. - verified");
        CommonClass.sleepTime(2000);
        wait.until(ExpectedConditions.elementToBeClickable(buttonRefresh));
        driver.findElement(buttonRefresh).click();
        wait.until(ExpectedConditions.elementToBeClickable(firstAccountCodeInTheTable));
        action.doubleClick(firstAccountCodeInTheTable).perform(); //Double click the first Account
        if (lblHeaderAccounts_info_popup.isDisplayed()) {
            wait.until(ExpectedConditions.elementToBeClickable(firstAccountCodeInTheTable));
            action.doubleClick(firstAccountCodeInTheTable).perform();
        }
        CommonClass.sleepTime(2000);
        Assert.assertEquals(txtBillingAdd.getAttribute("value"),"21, colombo, Sri Lanka");
        System.out.println("Billing Address autofiled - Verified");
        Assert.assertEquals(txtShipAddress.getAttribute("value"),"5622, Argentina");
        System.out.println("Shipping Address autofiled - Verified");

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
        System.out.println("'Product\" window should pop-up. - Verified");
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
        CommonClass.sleepTime(1000);
        wait.until(ExpectedConditions.elementToBeClickable(txtCusAcc));
        txtCusAcc.click();
        CommonClass.sleepTime(1000);
        Assert.assertEquals(txtDiscountValue.getAttribute("value"),discountValue);
    }

    /*Enter Discount value and Verify the Discount Percentage is correct*/
    public void enterDiscountValueAndVerifyPercentage(String percentage, String discountValue ){
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(txtDiscountValue));
        actions.moveToElement(txtDiscountValue).click();
        txtDiscountValue.clear();
        actions.moveToElement(txtDiscountValue).sendKeys(discountValue).build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(txtCusAcc));
        txtCusAcc.click();
        CommonClass.sleepTime(1000);
        Assert.assertEquals(txtDiscountPercentage.getAttribute("value"),percentage);
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




    public void checkTotalBeforeDiscount(String lineTotal,String quantity){
        CommonClass.sleepTime(2000);
        Assert.assertEquals(txtlineTotal.getAttribute("value"),lineTotal);
        Assert.assertEquals(txtUnitTotal.getAttribute("value"),lineTotal);
        Assert.assertEquals(txtSubTotal.getAttribute("value"),lineTotal);
        Assert.assertEquals(txtTotal.getAttribute("value"),lineTotal);  // right bottom corner
        Assert.assertEquals(txtBannerTotal.getText(),lineTotal);  // Total in the right upper cornner
        Assert.assertEquals(lblBannerNumberOfUnits.getText(),quantity);  // UNITS Total in the right upper cornner

    }
    /*Verify that total display correctly.*/
    public void checkTotalBeforeDraft(String lineTotal,String subTotal,String discountTotal,String quantity){
        CommonClass.sleepTime(2000);
        Assert.assertEquals(txtlineTotal.getAttribute("value"),lineTotal);
        Assert.assertEquals(txtUnitTotal.getAttribute("value"),lineTotal);
        System.out.println("Unit total is equl to the line total.");
        Assert.assertEquals(txtSubTotal.getAttribute("value"),subTotal);
        System.out.println("Sub total is equl to (Line total - Discount amount).");
        Assert.assertEquals(txtTotal.getAttribute("value"),subTotal);  // right bottom corner
        System.out.println(" Total is equl to Sub total.");
        Assert.assertEquals(txtBannerTotal.getText(),subTotal);  // Total in the right upper cornner
        System.out.println("Total in the right upper cornner is equl to total.");
        Assert.assertEquals(txtDisountTotalValue.getAttribute("value"),discountTotal);  // bottom layer
        Assert.assertEquals(lblBannerNumberOfUnits.getText(),quantity);  // UNITS Total in the right upper cornner
    }

    /*Verify that total display correctly. With Discount And Tax*/
    public void checkTotalBeforeDraftWithTax(String lineTotal,String subTotal,String bannerTotal, String discountTotal,String quantity,String taxValue){
        CommonClass.sleepTime(2000);
        Assert.assertEquals(txtlineTotal.getAttribute("value"),lineTotal);
        Assert.assertEquals(txtUnitTotal.getAttribute("value"),lineTotal);
        Assert.assertEquals(txtSubTotal.getAttribute("value"),subTotal);
        Assert.assertEquals(txtTotal.getAttribute("value"),bannerTotal);  // right bottom corner
        Assert.assertEquals(txtBannerTotal.getText(),bannerTotal);  // Total in the right upper cornner
        Assert.assertEquals(txtDisountTotalValue.getAttribute("value"),discountTotal);  // bottom layer
        Assert.assertEquals(lblBannerNumberOfUnits.getText(),quantity);  // UNITS Total in the right upper cornner
        Assert.assertEquals(txtTaxTot.getAttribute("value"),taxValue);  // tax amout verification
    }

    /*Verify that total display correctly. After Relesed With Discount And Tax*/
    public void checkTotalAfterRelesedWithTax(String lineTotal,String subTotal,String bannerTotal, String discountTotal,String quantity,String taxValue){
        CommonClass.sleepTime(2000);
        Assert.assertEquals(txtlineTotalRelesed.getText(),lineTotal);
        Assert.assertEquals(txtUnitTotal.getAttribute("value"),lineTotal);
        System.out.println("Unit total is equl to the line total.");
        Assert.assertEquals(txtSubTotal.getAttribute("value"),subTotal);
        System.out.println("Sub total - verified (Line total - Discount amount).");
        Assert.assertEquals(txtTotal.getAttribute("value"),bannerTotal);  // right bottom corner
        Assert.assertEquals(txtBannerTotal.getText(),bannerTotal);  // Total in the right upper cornner
        System.out.println("Total in the right upper cornner is equl to total.");
        Assert.assertEquals(txtDisountTotalValue.getAttribute("value"),discountTotal);  // bottom layer
        System.out.println("discount value - verified");
        Assert.assertEquals(lblBannerNumberOfUnits.getText(),quantity);  // UNITS Total in the right upper cornner
        System.out.println("UNITS Total in the right upper cornner - verified");
        Assert.assertEquals(txtTaxTot.getAttribute("value"),taxValue);  // tax amout verification
        System.out.println("taxValue - Verified");
    }

    public String checkTaxValue(){
        return txtTaxTot.getAttribute("value");
    }


    /*Verify that total - withougt TAX*/
    public void checkTotalAfterRelesed(String lineTotal,String SubTotal,String discountTotal, String quantity){
        Assert.assertEquals(txtlineTotalRelesed.getText(),lineTotal);
        Assert.assertEquals(txtUnitTotal.getAttribute("value"),lineTotal);
        System.out.println("Unit total is equl to the line total.");
        Assert.assertEquals(txtSubTotal.getAttribute("value"),SubTotal);
        System.out.println("Sub total - verified (Line total - Discount amount).");
        Assert.assertEquals(txtTotal.getAttribute("value"),SubTotal);  // right bottom corner
        System.out.println(" Total is equl to Sub total.");
        Assert.assertEquals(txtBannerTotal.getText(),SubTotal);  // Total in the right upper cornner
        System.out.println("Total in the right upper cornner is equl to total.");
        Assert.assertEquals(txtDisountTotalValue.getAttribute("value"),discountTotal);  // bottom layer
        Assert.assertEquals(lblBannerNumberOfUnits.getText(),quantity);  // UNITS Total in the right upper cornner
    }

    /*add tax for the sales order (Tax = subTotal*taxPercentage)*/
    public void selectTaxGroup(String taxGroupName){
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(ddTax));
        Select taxGroup = new Select(ddTax);
       // List<WebElement> e = selectSalesUnit.getOptions();
       // String unit = e.get(2).getText().trim();
        taxGroup.selectByVisibleText(taxGroupName);
    }
}
