package SalesAndMarketing._06_Campaigns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import java.util.concurrent.TimeUnit;

/**
 * Created by chathura on 6/14/2017.
 */
public class _06_04_AddMembersToCampaign {
    // Add members to campaign- Account
    WebDriver driver;

    @FindBy(xpath = "//*[@id='permissionBar']/a[text()='Draft']")
    private WebElement btnDraft;
    @FindBy(xpath = "//*[@id='permissionBar']/a[text()='Release'] ")
    private WebElement btnRelease;
    //@FindBy(xpath = "//*[@id='#divCamMemeber']")
    //private WebElement btnCampainMembers;
    private By btnCampainMembers = By.xpath("//*[@id='#divCamMemeber']");
    @FindBy(linkText = "Add Members")
    private WebElement linkBtnAddMembers;
    private By gridCampainMembers = By.xpath("//*[@id='dMembers']");
    @FindBy(xpath = "//span[@class='headertext']")
    private WebElement lblHeaderCampainMembersGrid;
    @FindBy(linkText = "Add customers")
    private WebElement linkBtnAddCustomers;
    @FindBy(xpath = "//span[@class='headertext'][contains(text(),'Accounts')]")
    private WebElement lblHeaderAccounts_info_popup;
    private By buttonRefresh = By.xpath( "//i[@class='fa fa-rotate-right']");
    private By tableContent = By.xpath("//*[@id='g1012-t']/table/tbody");
    @FindBy (xpath = "//*[@id='g1012-t']/table/tbody/tr[1]/td[6]")
    private WebElement firstAccountCodeInTheTable;
    @FindBy (xpath = "//a[@class='button'][text()='Update']")
    private WebElement btnUpdate;

    public _06_04_AddMembersToCampaign(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);}

  //  Click on Campaign members tab
    public void clickOnCampainMembers() {
        btnDraft.click(); // click on draft button
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(btnRelease));
        btnRelease.click(); // click on Release button
        wait.until(ExpectedConditions.elementToBeClickable(btnCampainMembers));
        driver.findElement(btnCampainMembers).click(); // click on campain members button
    }

    public void clickOnAddMembers() {
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(linkBtnAddMembers));
        linkBtnAddMembers.click();
    }

    // Click on add customer
    public void  clickOnAddCustomer() {
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(gridCampainMembers));
        Reporter.log("Add campaign members pop-up is open");
        Assert.assertEquals(lblHeaderCampainMembersGrid.getText(), "Add Campaign Members");
        linkBtnAddCustomers.click(); //click on Add customer and open Accounts info new pop-up
    }

    //Click on refresh and select an existing account
    public void selectAnExistingAccount(){
        WebDriverWait wait = new WebDriverWait(driver, 40);
        Assert.assertEquals(lblHeaderAccounts_info_popup.getText(),"Accounts"); // verify Accounts info new pop-up header
        wait.until(ExpectedConditions.elementToBeClickable(buttonRefresh));
        driver.findElement(buttonRefresh).click();
        wait.until(ExpectedConditions.elementToBeClickable(firstAccountCodeInTheTable));
       // System.out.println(driver.findElement(tableContent).getText());
        Actions action = new Actions(driver);
        action.doubleClick(firstAccountCodeInTheTable).perform(); //Double click the first Account
        wait.until(ExpectedConditions.elementToBeClickable(btnUpdate));
        btnUpdate.click(); // Click on update button
    }

}
