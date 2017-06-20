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

import java.util.concurrent.TimeUnit;

/**
 * Created by chathura on 6/19/2017.
 */
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



    public _12_03_PendingOutboundShipment(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /*Search for a pending Outbound shipment from Tast List.*/
    public void OutboundShipment(String orderNumber){
        Actions action = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 40);
       // Actions action = new Actions (driver);
        wait.until(ExpectedConditions.elementToBeClickable(btnOutboundShipment));
        btnOutboundShipment.click();  //  Click on the "Outbound Shipment" tile.
        wait.until(ExpectedConditions.elementToBeClickable(txtSearch));
        txtSearch.clear();
        txtSearch.sendKeys(orderNumber);
        System.out.println(orderNumber);
        txtSearch.sendKeys(Keys.ENTER);
//        System.out.println(driver.findElement(By.xpath("//*[@id='lblToday']/div[2]/div[2]/div/div/div[3]/a")).getText());
       /* Select dd = new Select(ddAutosearch);
        dd.selectByVisibleText("NTU/124 - 00001 [Vendor Name]");*/

        driver.findElement(By.xpath("//*[@id='lblToday']/div[2]/div[2]/div[1]/div/div[7]/a/i")).click();
//        wait.until(ExpectedConditions.elementToBeClickable(ddAutosearch));
  //      ddAutosearch.click();
        CommonClass.sleepTime(5000);
        System.out.println(driver.findElement(By.xpath("//*[@id='trnpageheader']/a[text()='Outbound Shipment']")).getText());

    }

    public void releaseAndGoToPage(String orderNumber,String quantity){
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(btnRelease));
        btnRelease.click(); // click on draft button
        // Store the current window handle
        String winHandleBefore = driver.getWindowHandle();
        wait.until(ExpectedConditions.elementToBeClickable(linkGoToPageInformationBox));
        linkGoToPageInformationBox.click(); // click Go to page on information dialog box
        // Switch to new window opened
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        // Perform the actions on new window
        Assert.assertEquals(lblPageHeaderOutboundShipment.getText(),"Outbound Shipment");  // Verify the by page header.
        wait.until(ExpectedConditions.visibilityOf(lblPageHeaderOutboundShipment));
        Assert.assertEquals(lblStatus.getText(),"New"); //  Verify the outbound shipment's status.
        wait.until(ExpectedConditions.visibilityOf(txtRefDocNo));
        Assert.assertEquals(txtRefDocNo.getText(),orderNumber);
        CommonClass.sleepTime(4000);
        Assert.assertEquals(lblNumberOfUnits.getText(),quantity);
        wait.until(ExpectedConditions.elementToBeClickable(btnCheckout));
        btnCheckout.click();
        Assert.assertEquals(CommonClass.draftAndCheckStatus(),"(Draft)");
        Assert.assertEquals(CommonClass.releaseOkAndCheckStatus(),"(Releasedd)");



        // Close the new window, if that window no more required
 //       driver.close();
        // Switch back to original browser (first window)
 //       driver.switchTo().window(winHandleBefore);



    }





}
