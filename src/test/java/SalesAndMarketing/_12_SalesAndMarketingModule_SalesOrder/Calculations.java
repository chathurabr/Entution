package SalesAndMarketing._12_SalesAndMarketingModule_SalesOrder;

import org.openqa.selenium.WebDriver;

import java.text.DecimalFormat;

/**
 * Created by Ramitha on 6/22/2017.
 */
public class Calculations {
    private static WebDriver driver;
    //LineTotal
    private static double price = 1000;
    private static double quantity =10;
    private static double lineTotal; //Unit total = Line Total
    //Discount - Amount to precentage
    private static double discountAmount = 250;
    private static double discountPrecentage;
    //Discount - precentage to amount
    private static double discountAmount2;
    private static double discountPrecentage2 = 15;
    //SubTotal
    private static double subTotal;

    public Calculations(){
        this.driver = driver;

    }

    public static String lineTotalCalculation(){
        String SlineTotal;

        lineTotal = price*quantity;

        DecimalFormat formatter = new DecimalFormat("#,###.00");
        SlineTotal =  formatter.format(lineTotal);
        //String.valueOf(lineTotal);
        return SlineTotal;
    }

    public static String discountPrecentageCalculation(){
        String discPrecent;

        discountPrecentage = (discountAmount/lineTotal)*100;

        DecimalFormat formatter = new DecimalFormat("#,###.00");
        discPrecent = formatter.format(discountPrecentage);
        return discPrecent;
    }

    public static String discountAmountCalculation(){
        String discAmou;

        discountAmount2 = (discountPrecentage2/100)*lineTotal;

        DecimalFormat formatter = new DecimalFormat("#,###.00");
        discAmou = formatter.format(discountAmount2);
        return discAmou;
    }

    public static String subTotalCalculationByDiscountPrecentage(){
        String subT;

        return null;
    }


    public static void main(String args[]){
        String lineTotal = Calculations.lineTotalCalculation();
        System.out.println("Price is     "+price);
        System.out.println("QTY is       "+quantity);
        System.out.println("------------------");
        System.out.println("LineTotal is "+lineTotal);

        String dicPrecentage = Calculations.discountPrecentageCalculation();
        System.out.println("Discount precentage Is "+dicPrecentage+"%");

        String dicAmount = Calculations.discountAmountCalculation();
        System.out.println("Discount amount is"+dicAmount);
    }
}
