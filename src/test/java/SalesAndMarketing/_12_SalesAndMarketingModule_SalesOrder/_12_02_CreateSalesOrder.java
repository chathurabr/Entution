package SalesAndMarketing._12_SalesAndMarketingModule_SalesOrder;

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

/**
 * Created by chathura on 6/15/2017.
 */
public class _12_02_CreateSalesOrder {
    WebDriver driver;

    @FindBy(xpath = "//*[@id='btnUpdate']/b[text()='New Sales Order']")
    private WebElement btnNewSalesOrser;
    @FindBy(xpath = "//span[text()='Sales Order to Sales Invoice']")
    private WebElement btnSalesOrderToSalesInvoice;
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




   // private By cboxCurrency = By.id( "cboxCurrency]");



    public _12_02_CreateSalesOrder(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /*New Sales Order - Select Sales Order to Sales Invoice */
    public void CreateSalesOrder(){
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(btnNewSalesOrser));
        btnNewSalesOrser.click();   // Click on New Sales Order button
        wait.until(ExpectedConditions.elementToBeClickable(btnSalesOrderToSalesInvoice));
        btnSalesOrderToSalesInvoice.click();   //Select Sales Order to Sales Invoice (Option One)
    }

    /* Select Customer Account*/
    public void selectCustomerAccount() {
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(lblPageHeaderNewSalesOrder));
        Assert.assertEquals(lblPageHeaderNewSalesOrder.getText(),"New");
        searchIconSelectCustomer.click();
        Assert.assertEquals(lblHeaderAccounts_info_popup.getText(), "Account"); // verify Accounts info new pop-up header
        wait.until(ExpectedConditions.elementToBeClickable(buttonRefresh));
        driver.findElement(buttonRefresh).click();
        wait.until(ExpectedConditions.elementToBeClickable(firstAccountCodeInTheTable));
        Actions action = new Actions(driver);
        action.doubleClick(firstAccountCodeInTheTable).perform(); //Double click the first Account
    }

    /*select Curuncy Unit from Dropdown*/
    public void selectCurruncy(){
        Select selectCurruncy = new Select(cboxCurrency);
        List<WebElement> allCurruncies = selectCurruncy.getOptions();
   /*     for (int j = 0; j < allCurruncies.size(); j++) {
            System.out.println(allCurruncies.get(j).getText());}*/
        String getLKRunit = allCurruncies.get(5).getText().trim();
        Assert.assertEquals(getLKRunit,"LKR");
        selectCurruncy.selectByVisibleText(getLKRunit);
    }

    /*Sales Unit from Dropdown */
    public void selectSalesUnit(){
        Select selectSalesUnit = new Select(driver.findElement(By.id("cboxSalesUnitPerson")));
        List<WebElement> e = selectSalesUnit.getOptions();
        String unit = e.get(2).getText().trim();
        selectSalesUnit.selectByVisibleText(unit);

    }

    /*Get autofill Account Owner name*/
    public String getAccountOwnerName(){
        return txtAccountOwner.getText();
    }

    /*Click on Product Search icon and add a Lot product*/
    public void addProduct(){
        Actions action = new Actions (driver);
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(iconProductSearch));
        iconProductSearch.click();
        wait.until(ExpectedConditions.elementToBeClickable(lblHeaderProduct_info_popup));
        System.out.println(lblHeaderProduct_info_popup.getText());
        action.moveToElement(txtSearchProduct2).sendKeys("Lot-Pro-1310").sendKeys(Keys.ENTER).build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(firstSearchedProduct));
        action.doubleClick(firstSearchedProduct).perform();
    }

    /* Select a warehouse from the warehouse dropdown.*/
    public void selectWareHouse(){
        Select selectSalesUnit = new Select(ddWareHouse);
        selectSalesUnit.selectByVisibleText("1310-1 [1310-ProductIn]");
    }


}
