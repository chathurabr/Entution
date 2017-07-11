package Procurement._01_PurchaseOrder.Calculations;

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

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ramitha on 6/26/2017.
 */
public class serialBatchCapture {
    public WebDriver driver;


    public serialBatchCapture(WebDriver driver){
        this.driver=driver;
    }

    public void inboundship(String poNumb){
        this.productListScan();
    }

    public void productListScan(){
        CommonClass.sleepTime(3000);
        try {
            List<WebElement> lis = driver.findElements(By.tagName("span"));
            for (int i = 0; i < lis.size(); i++) {

                String str = lis.get(i).getAttribute("id");

                //System.out.println("sout "+str);

                if(str.contains("ItemNumber")){
                    System.out.println("If statement executed successfully");
                    WebDriverWait wait = new WebDriverWait(driver, 40);
                    wait.pollingEvery(2, TimeUnit.SECONDS);

                    WebElement listItem = driver.findElement(By.xpath("//*[@id='"+str+"']"));
                    wait.until(ExpectedConditions.visibilityOf(listItem));
                    listItem.click();

                }else{
                    System.out.println("Else statement executed");
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void SerialBacthCaptureUpdateButton(){
        By updateIcon = By.xpath("//i[@class='fa fa-refresh']");
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.pollingEvery(2, TimeUnit.SECONDS);

        WebElement updateBtnEle = driver.findElement(updateIcon);
        wait.until(ExpectedConditions.elementToBeClickable(updateBtnEle));
        updateBtnEle.click();

    }
    public void checkProductType(String lotNumberValue, String batchNumberValue,String SerialNumberValue){
        Actions action = new Actions(driver);
        //lot product
        By lotNumberLbl = By.xpath("//td[@class='col-sm-3'][text()='Lot No']");
        WebElement lotNumbLbl = driver.findElement(lotNumberLbl);
            //lot product TextBox
        By lotNumberTxtBox = By.id("attrSlide-txtLotNBS");
        WebElement LotNumbtxtBox = driver.findElement(lotNumberTxtBox);
            //lot product TextBox in batch product
        By lotNumberTxtBoxInBatchProduct = By.id("attrSlide-txtLotNBS");
        WebElement LotBumbtxtBoxInBtchProd = driver.findElement(lotNumberTxtBoxInBatchProduct);

        //Batch product
        By batchNumberLbl = By.xpath("//td[@class='col-sm-3'][text()='Batch No']");
        WebElement batchNumbLbl = driver.findElement(batchNumberLbl);
            //Batch product TextBox
        By batchProductTxtBox = By.id("attrSlide-txtBatchNo");
        WebElement batchProTxtBox = driver.findElement(batchProductTxtBox);

        //Serial product
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.pollingEvery(2, TimeUnit.SECONDS);

        CommonClass.sleepTime(3000);
        //If Lot product
        if(lotNumbLbl.isEnabled()){
            System.out.println("Product is a Lot product");
            wait.until(ExpectedConditions.elementToBeClickable(LotNumbtxtBox));
            action.moveToElement(LotNumbtxtBox).click().build().perform();
            LotNumbtxtBox.clear();
            action.moveToElement(LotNumbtxtBox).sendKeys(lotNumberValue).sendKeys(Keys.ENTER).build().perform();


        }
        // If Batch product
        else if(lotNumbLbl.isEnabled() && batchNumbLbl.isEnabled()){
            System.out.println("Product is a Batch product");
            wait.until(ExpectedConditions.elementToBeClickable(batchProductTxtBox));
            action.moveToElement(batchProTxtBox).click().build().perform();
            batchProTxtBox.clear();
            action.moveToElement(batchProTxtBox).sendKeys(batchNumberValue).build().perform();

        }
        //Serial product
        //else if()
        else{
            System.out.println("Product type cannot determine");
            Reporter.log("Product type cannot determine");
        }
    }

    public void verifyProductHasCaptured(){
        By greenListNumberIcon = By.xpath("//span[@class='fli-number green-vackground-fli-number']");
        By plsWaitPop = By.xpath("//div[@class='waitbox color-default']");

        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.pollingEvery(2, TimeUnit.SECONDS);






        WebElement greenListNumberIconEle = driver.findElement(greenListNumberIcon);
        WebElement plsWaitPopEle = driver.findElement(plsWaitPop);

        wait.until(ExpectedConditions.invisibilityOf(plsWaitPopEle));
        wait.until(ExpectedConditions.visibilityOf(greenListNumberIconEle));
        System.out.println("Green batch captured");
    }

    public void serialCaptureBackButton(){
        By backButton = By.xpath("//i[@class='fa fa-arrow-left']");

        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.pollingEvery(2, TimeUnit.SECONDS);

        WebElement backButtonEle = driver.findElement(backButton);
        backButtonEle.click();
        System.out.println("Back button clicked");
    }
}
