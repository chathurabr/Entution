package SalesAndMarketing._12_SalesAndMarketingModule_SalesOrder;

import SalesAndMarketing.dataProvider.CommonClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by chathura on 6/15/2017.
 */
public class _12_01_NavigatesToSalesOrderScreen {
    WebDriver driver;

    @FindBy(linkText = "Sales Order")
    private WebElement btnSalesOrder ;
    private By lblPageHeadingSalesOrder = By.xpath( "//*[@id='spPageName']");

    public _12_01_NavigatesToSalesOrderScreen(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Navigates to Sales Order screen
    public void clickOnSalesOrder(){
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(btnSalesOrder));
        btnSalesOrder.click();   // Click on Sales Order button
        wait.until(ExpectedConditions.visibilityOfElementLocated(lblPageHeadingSalesOrder)); // Verify Page Header Of Sales Order Page
        Assert.assertEquals(driver.findElement(lblPageHeadingSalesOrder).getText(),"Sales Order");
        System.out.println("Page Header Of Sales Order Page verified");
    }



}
