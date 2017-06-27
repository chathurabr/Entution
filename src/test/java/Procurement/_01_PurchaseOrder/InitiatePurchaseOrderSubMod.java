package Procurement._01_PurchaseOrder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.util.concurrent.TimeUnit;

/**
 * Created by Ramitha on 6/26/2017.
 */
public class InitiatePurchaseOrderSubMod {
    WebDriver driver;
    By purchaseOrderSubModule = By.xpath("//*[@id=\"header4\"]/li[3]/a[1]");

    By purchaseOrderLabel = By.id("spPageName");

    //Journey
    By journeyPannel = By.xpath("/html/body/div[6]");
    By journeyOne = By.id("sp-processItem-6");

public InitiatePurchaseOrderSubMod(WebDriver driver){
    this.driver=driver;
}

public void initiatePOModule(){

    this.selectPurchaseOrderSubModule();
    this.selectJourney();
}

public void selectPurchaseOrderSubModule(){

    WebDriverWait wait = new WebDriverWait(driver, 40);
    wait.pollingEvery(2, TimeUnit.SECONDS);

    wait.until(ExpectedConditions.presenceOfElementLocated(purchaseOrderSubModule));

    WebElement subModule = driver.findElement(purchaseOrderSubModule);
    subModule.click();

    Reporter.log("Clicked on the Purchase Order sub Module");
}

public void isPurchaseOrderLblDisplays(){
    WebDriverWait wait = new WebDriverWait(driver, 40);
    wait.pollingEvery(2, TimeUnit.SECONDS);

    wait.until(ExpectedConditions.presenceOfElementLocated(purchaseOrderLabel));

}

public void selectJourney(){
    Actions action = new Actions(driver);
    WebDriverWait wait = new WebDriverWait(driver, 40);
    wait.pollingEvery(2, TimeUnit.SECONDS);

   wait.until(ExpectedConditions.presenceOfElementLocated(journeyOne));
    WebElement journyOneEle = driver.findElement(journeyOne);
    action.moveToElement(journyOneEle).click().build().perform();
    Reporter.log("Clicked on Journey one");
}

}
