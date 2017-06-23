package SalesAndMarketing._12_SalesAndMarketingModule_SalesOrder;

import org.openqa.selenium.WebDriver;

import java.text.DecimalFormat;

/**
 * Created by Ramitha on 6/22/2017.
 */
public class Calculations {
    public static WebDriver driver;
    //LineTotal
    public static double price = 10000;
    public static double quantity =100;
    public static double lineTotal; //Unit total = Line Total
    //Discount
    public static double discountAmount= 50000 ;
    public static double discountPrecentage = 0 ;
    //SubTotal
    public static double subTotal;

    public Calculations(){
        this.driver = driver;
    }

    public static String lineTotalCalculation(){
        String SlineTotal;

        lineTotal = price*quantity;

        DecimalFormat formatter = new DecimalFormat("#,###.00");
        SlineTotal =  formatter.format(lineTotal);

        return SlineTotal;
    }

    public static String discountPercentageCalculation() {
        String discountP = null;

        if (discountAmount > 0 && discountPrecentage <= 0) {
            discountPrecentage = (discountAmount / lineTotal) * 100;
            DecimalFormat formatter = new DecimalFormat("#,###.00");
            discountP = formatter.format(discountPrecentage);
            return discountP;

        } else {
            DecimalFormat formatter = new DecimalFormat("#,###.00");
            return formatter.format(discountPrecentage);

        }

    }

    public static String discountAmountCalculation(){
        String discountA = null;
        if (discountPrecentage >0 && discountAmount<=0){
            discountAmount = (discountPrecentage/100)*lineTotal;
            DecimalFormat formatter = new DecimalFormat("#,###.00");
            discountA = formatter.format(discountAmount);
            return discountA;
        }
        else {
            DecimalFormat formatter = new DecimalFormat("#,###.00");
            return formatter.format(discountAmount);
        }

    }



/*    public static String discountCalculation(){
        String discount = null;


        if(discountAmount>0 && discountPrecentage <= 0) {
            discountPrecentage = (discountAmount / lineTotal) * 100;

            DecimalFormat formatter = new DecimalFormat("#,###.00");
            discount = formatter.format(discountPrecentage);
           // discount = discountPrecentage;
            return discount;

        }else if (discountPrecentage >0 && discountAmount<=0){
            discountAmount = (discountPrecentage/100)*lineTotal;

            DecimalFormat formatter = new DecimalFormat("#,###.00");
            discount = formatter.format(discountAmount);
            return discount;
        }else if(discountAmount>0 && discountPrecentage >0){
            System.out.println("Pala pala");
            return discount;
        }
        else {
            return discount;
        }

    }*/

    public static String getPrice(){
        DecimalFormat formatter = new DecimalFormat("#,###.00");
        return  formatter.format(price);

    }

    public static String getquantity(){
        DecimalFormat formatter = new DecimalFormat("#,###.00");
        return  formatter.format(quantity);

    }

    public static String subTotalCalculation(){
        String subTotalValue = null;

        double lineTot;
        double subT;

        if(discountAmount>0) {

            lineTot = price*quantity;
            subT = lineTot - discountAmount;

            DecimalFormat formatter = new DecimalFormat("#,###.00");
            subTotalValue =  formatter.format(subT);

            return subTotalValue;

        }else if (discountPrecentage >0 && discountAmount<=0){

            lineTot = price*quantity;
            double discAmtByPrecentage =(discountPrecentage/100)*lineTot;
            subT = lineTot - discAmtByPrecentage;

            DecimalFormat formatter = new DecimalFormat("#,###.00");
            subTotalValue =  formatter.format(subT);

            return subTotalValue;

        }else if(discountAmount>0 && discountPrecentage >0){
            System.out.println("Pala pala");
            return subTotalValue;
        }
        return subTotalValue;
    }


    public static void main(String args[]){
        String lineTotal = Calculations.lineTotalCalculation();
        System.out.println("Price is     "+price);
        System.out.println("QTY is       "+quantity);
        System.out.println("------------------");
        System.out.println("LineTotal is "+lineTotal);
        System.out.println("------------------");
      //  String dicPrecentage = Calculations.discountCalculation();
     //   System.out.println("Discount precentage Is "+dicPrecentage+"%");
        System.out.println("*******************");
        //Sub Total Calculation
        String subtott = Calculations.subTotalCalculation();
        System.out.println("SubTotal is "+subtott);


    }
}
