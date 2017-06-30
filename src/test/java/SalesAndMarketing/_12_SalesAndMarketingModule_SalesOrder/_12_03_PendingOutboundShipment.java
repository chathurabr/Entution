package SalesAndMarketing._12_SalesAndMarketingModule_SalesOrder;

import dataProvider.CommonClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class _12_03_PendingOutboundShipment {
    WebDriver driver;

    @FindBy(xpath = "//p[@class='tiles-header-st'][text()='Outbound Shipment']")
    private WebElement btnOutboundShipment;
    @FindBy(id = "txtComTran")
    private WebElement txtSearch;
    @FindBy(xpath = "//div[@id='txtComTranac']")
    private WebElement ddAutosearch;

    @FindBy(xpath = "//label[@id='lblTemplateFormHeader']")
    private WebElement lblStatus;
    @FindBy(xpath = "//*[@id='dlgAutoGenNotifications']/a")
    private WebElement linkGoToPageInformationBox;
    @FindBy(xpath = "//*[@id='trnpageheader']/a")
    private WebElement lblPageHeaderOutboundShipment;
    @FindBy(xpath = "//*[@id='tblShipDetails']/tbody/tr/td[12]")
    private WebElement txtRefDocNo;

    @FindBy(xpath = "//*[@id='permissionBar']/a[text()='Draft']")
    private WebElement btnDraft;
    @FindBy(xpath = "//*[@id='permissionBar']/a[text()='Release'] ")
    private WebElement btnRelease;
    @FindBy(xpath = "//*[@id='bannerTotQty']")
    private WebElement lblNumberOfUnits;
    @FindBy(xpath = "//span[@class='pic16 pic16-checkout']")
    private WebElement btnCheckout;
    @FindBy(xpath = "//i[@class='fa fa-sign-in fa-2x']")
    private WebElement btnErrorSign;
    @FindBy(xpath = "//*[@id='divTaskTiles']/div/div[1]/a[5]/div/div[@class='begin-selected-tile-arrow color-selectedborder']")
    private WebElement selectedOutboundTile;



    public _12_03_PendingOutboundShipment(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    /*Search for a pending Outbound shipment from Tast List.*/
    public void selectOutboundShipment() {
        CommonClass.sleepTime(1000);
        WebDriverWait wait = new WebDriverWait(driver, 40);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btnOutboundShipment);
        wait.until(ExpectedConditions.elementToBeClickable(btnOutboundShipment));
        btnOutboundShipment.click();  //  Click on the "Outbound Shipment" tile.
        System.out.println("opened the outbound shipment window.");

    }


    //Enter the already created Sales order number in the search bar and search.
    public void searchSalesOrderNumber(String orderNumber){
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(txtSearch));
        wait.until(ExpectedConditions.elementToBeClickable(txtSearch));
        txtSearch.clear();
        txtSearch.sendKeys(orderNumber);
       // System.out.println(orderNumber);
        String lastChar = orderNumber.substring(orderNumber.length() - 1);
       // System.out.println(lastChar+": lastnumber");
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

    public void releaseAndGoToPage() {
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(btnRelease));
        btnRelease.click(); // click on draft button
        // Store the current window handle
        String winHandleBefore = driver.getWindowHandle();
        wait.until(ExpectedConditions.elementToBeClickable(linkGoToPageInformationBox));
        linkGoToPageInformationBox.click(); // click Go to page on information dialog box
        // Switch to new window opened
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
    }

    public void outBoundShipment(String orderNumber,String quantity) {
        // Perform the actions on new window
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOf(lblPageHeaderOutboundShipment));
        Assert.assertEquals(lblPageHeaderOutboundShipment.getText(), "Outbound Shipment");  // Verify the by page header.
        System.out.println(" Header \"Outbound Shipment\" - verified");
        Assert.assertEquals(lblStatus.getText(), "New"); //  Verify the outbound shipment's status.
        System.out.println("erify the outbound shipment's status as 'New'");
        wait.until(ExpectedConditions.visibilityOf(txtRefDocNo));
        Assert.assertEquals(txtRefDocNo.getText(), orderNumber);
        System.out.println("Ref Doc No is equal to Sales Order Number - verified");
        CommonClass.sleepTime(4000);
        Assert.assertEquals(lblNumberOfUnits.getText(), quantity);
        System.out.println("No of unit equels to the sales orders Qty - verified");
        wait.until(ExpectedConditions.elementToBeClickable(btnCheckout));
        btnCheckout.click();
        CommonClass.sleepTime(4000);
        // Close the new window, if that window no more required
        //       driver.close();
        // Switch back to original browser (first window)
        //       driver.switchTo().window(winHandleBefore);

    }

    public String getOutboundShipmentNumber(){   // Get Outbound Shipment Number
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOf(lblStatus));
        return lblStatus.getText();

    }





}
