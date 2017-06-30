package Procurement._01_PurchaseOrder.Calculations;

import org.apache.xpath.SourceTree;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ramitha on 6/28/2017.
 */
public class ProcurementCalculationClass {

    public static WebDriver driver;
    /*public static double qty;
    public static double unitPrice;*/
    public static double lineTotalDouble;
    private static String lineTotalString;

    //Qty textBox




    //GetQty
/*    public static String getQty(){
        Actions action = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.pollingEvery(2, TimeUnit.SECONDS);
    }*/

    public static String lineTotal (String qty,String unitPrice){
        double qtyD = Double.parseDouble(qty);
        double unitPriceD = Double.parseDouble(unitPrice);

        lineTotalString = null;
        lineTotalDouble = qtyD*unitPriceD;

        DecimalFormat formatter = new DecimalFormat("#,###.00");
        lineTotalString  =  formatter.format(lineTotalDouble);
        return lineTotalString;
    }

   /* public static void main(String args[]){

        System.out.println(ProcurementCalculationClass.lineTotal(10,100));
        System.out.println(lineTotalDouble);
        System.out.println(lineTotalString);
    }*/
}
