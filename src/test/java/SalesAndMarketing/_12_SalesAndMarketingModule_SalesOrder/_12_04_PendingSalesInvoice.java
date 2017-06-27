package SalesAndMarketing._12_SalesAndMarketingModule_SalesOrder;

import dataProvider.CommonClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

// Search for a pending Sales invoice from Tast List.

public class _12_04_PendingSalesInvoice {
    WebDriver driver;


    @FindBy(xpath = "//p[@class='tiles-header-st'][text()='Sales Invoice']")
    private WebElement btnSalesInvoice;
    @FindBy(id = "txtComTran")
    private WebElement txtSearch;
    @FindBy(xpath = "//div[@id='txtComTranac']")
    private WebElement ddAutosearch;
    @FindBy(xpath = "//i[@class='fa fa-sign-in fa-2x']")
    private WebElement btnErrorSign;
    @FindBy(xpath = "//*[@id='trnpageheader']/a")
    private WebElement lblPageHeadeSalesInvoice;
    @FindBy(xpath = "//label[@id='lblTemplateFormHeader']")
    private WebElement lblStatus;
    @FindBy(xpath = "//*[@id='tblSalesInv']/tbody/tr/td[10]/div")  //*[@id='tblSalesInv']/tbody/tr/td[9]/div
    private WebElement txtRefDocNo;  //*[@id='tblSalesInv']/tbody/tr/td[10]/div
    @FindBy(xpath = "//span[@class='pic16 pic16-checkout']")
    private WebElement btnCheckout;

    @FindBy(xpath = "//input[@class='el-resize21 gcd']")
    private WebElement  txtlineTotal;
    @FindBy(xpath = "//input[@class='el-resize22 gcd']")
    private WebElement  txtlineTotal_SSO;
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
    @FindBy(xpath = "//input[@id='txtDiscountTot']")
    private WebElement txtDisountTotalValue;
    @FindBy(xpath = "//*[@id='bannerTotQty']")
    private WebElement lblBannerNumberOfUnits;
    @FindBy(id = "txtTaxTot")
    private WebElement txtTaxTot;

    public _12_04_PendingSalesInvoice(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectSalesInvoice(){
        CommonClass.sleepTime(2000);
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(btnSalesInvoice));
        btnSalesInvoice.click();
        System.out.println("clicked on \"Salese Invoice\".");
    }

    public void searchOrderNumber(String orderNumber){
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(txtSearch));
        txtSearch.clear();
        txtSearch.sendKeys(orderNumber);
       // System.out.println(orderNumber);
        String lastChar = orderNumber.substring(orderNumber.length() - 1);
        //System.out.println(lastChar+": lastnumber");
        txtSearch.sendKeys(Keys.BACK_SPACE);
        txtSearch.sendKeys(lastChar);
        CommonClass.sleepTime(2000);
        wait.until(ExpectedConditions.elementToBeClickable(ddAutosearch));
        ddAutosearch.click();
        // Store the current window handle
        String winHandleBefore = driver.getWindowHandle();
        CommonClass.sleepTime(3000);
        wait.until(ExpectedConditions.elementToBeClickable(btnErrorSign));
        btnErrorSign.click();
        // Switch to new window opened
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

    }
    public void sales_Invoice(String orderNumber){
        // Perform the actions on new window
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOf(lblPageHeadeSalesInvoice));
        Assert.assertEquals(lblPageHeadeSalesInvoice.getText(), "Sales Invoice");  // Verify the by page header.
        System.out.println("Verified the by page header - \"Sales Invoice\"");
        Assert.assertEquals(lblStatus.getText(), "New"); //  Verify the Sales Invoice's status.
        System.out.println("Verify the Sales Invoice's status. - 'New'");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='tblSalesInv']/tbody/tr/td/div[contains(text(),'"+orderNumber+"')]"))));
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='tblSalesInv']/tbody/tr/td/div[contains(text(),'"+orderNumber+"')]")).getText(), orderNumber);  // Verify the Ref Doc No in the product line.
        System.out.println("Ref Doc No is equal to Outbound shipment Number.");
        CommonClass.sleepTime(4000);
        wait.until(ExpectedConditions.elementToBeClickable(btnCheckout));
        btnCheckout.click();  // Click on Check-out button.
    }


    /*Verify that total display correctly. Sales to Invoice*/
    public void checkTotal(String lineTotal,String subTotal,String bannerTotal, String discountTotal,String quantity,String taxValue){
        CommonClass.sleepTime(2000);
        Assert.assertEquals(txtlineTotal.getAttribute("value"),lineTotal);
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
        Assert.assertEquals(txtTaxTot.getAttribute("value"),taxValue);
        System.out.println("taxValue - Verified");
    }

    /*Verify that total display correctly.  Sales To Outbound*/
    public void checkTotal_SSO(String total){
        CommonClass.sleepTime(2000);
        Assert.assertEquals(txtlineTotal_SSO.getAttribute("value"),total+".00");
        Assert.assertEquals(txtUnitTotal.getAttribute("value"),total+".00");
        Assert.assertEquals(txtSubTotal.getAttribute("value"),total+".00");
        Assert.assertEquals(txtTotal.getAttribute("value"),total+".00");  // right bottom corner
        Assert.assertEquals(txtBannerTotal.getText(),total+".00");  // Total in the right upper cornner
    }


}
