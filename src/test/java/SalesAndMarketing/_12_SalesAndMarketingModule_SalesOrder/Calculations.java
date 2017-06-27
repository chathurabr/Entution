package SalesAndMarketing._12_SalesAndMarketingModule_SalesOrder;

import org.openqa.selenium.WebDriver;

import java.text.DecimalFormat;

/**
 * Created by Ramitha on 6/22/2017.
 */
public class Calculations {
    public static WebDriver driver;

    public static double price = 10000;
    public static double quantity =100;

    //Discount
    public static double discountAmount ;
    public static double discountPercentage;

    //Tax
    public static double taxPercentage = 15;   // give tax percentage here
    public static double taxValue;  // auto calculate only

    //Total
    public static double subTotal;
    public static double lineTotal; //Unit total = Line Total
    public static double bannerTotal;


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
        String discountP = "0.00";

        if (discountAmount > 0 && discountPercentage <= 0) {
            discountPercentage = (discountAmount / lineTotal) * 100;
            DecimalFormat formatter = new DecimalFormat("#,##0.00");
            discountP = formatter.format(discountPercentage);
            return discountP;

        }
        else if (discountPercentage > 0){
            DecimalFormat formatter = new DecimalFormat("#,##0.00");
            return formatter.format(discountPercentage);

        } else {
            return discountP;

        }

    }

    public static String discountAmountCalculation(){
        String discountA = "0.00";
        if (discountPercentage >0 && discountAmount<=0){
            discountAmount = (discountPercentage/100)*lineTotal;
            DecimalFormat formatter = new DecimalFormat("#,###.00");
            discountA = formatter.format(discountAmount);
            return discountA;
        }
        else if (discountAmount > 0){
            DecimalFormat formatter = new DecimalFormat("#,###.00");
            return formatter.format(discountAmount);
        }
        else {
            return discountA;
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

        if(discountAmount>0) {
            subTotal = lineTotal - discountAmount;
            DecimalFormat formatter = new DecimalFormat("#,###.00");
            subTotalValue =  formatter.format(subTotal);
            return subTotalValue;

        }else if (discountPercentage >0 && discountAmount<=0){
            double discAmtByPrecentage =(discountPercentage/100)*lineTotal;
            subTotal = lineTotal - discAmtByPrecentage;
            DecimalFormat formatter = new DecimalFormat("#,###.00");
            subTotalValue =  formatter.format(subTotal);
            return subTotalValue;

        }else if(discountAmount>0 && discountPercentage >0){
            System.out.println("Pala pala");
            return subTotalValue;
        }

        else {
            subTotal = lineTotal;
            DecimalFormat formatter = new DecimalFormat("#,###.00");
            subTotalValue =  formatter.format(subTotal);
            return subTotalValue;
        }

    }

    public static double subTotalCalculationDouble(){
        double subTotalValueDouble = 0;
        //double subT;

        if(discountAmount>0) {

           // lineTot = price*quantity;
            subTotalValueDouble = lineTotal - discountAmount;


            return subTotalValueDouble;

        }else if (discountPercentage >0 && discountAmount<=0){

            lineTotal = price*quantity;
            double discAmtByPrecentage =(discountPercentage/100)*lineTotal;
            subTotalValueDouble = lineTotal - discAmtByPrecentage;

            return subTotalValueDouble;

        }else if(discountAmount>0 && discountPercentage >0){
            System.out.println("Else");
            return subTotalValueDouble;
        }else {
            return subTotalValueDouble;
        }
    }

    public static String taxCalculation(){
        String taxVal = "0.00";

        if(taxPercentage > 0) {
            taxValue = subTotal * (taxPercentage / 100);

            DecimalFormat formatter = new DecimalFormat("#,##0.00");
            taxVal = formatter.format(taxValue);
            return taxVal;

        }else
            return taxVal;
    }

    public static String bannerTotalCalculation(){
        String bannerTotCal = null;

        if(taxValue>0){
            bannerTotal = taxValue+subTotal;
            DecimalFormat formatter = new DecimalFormat("#,###.00");
            bannerTotCal =  formatter.format(bannerTotal);
            return bannerTotCal;
        }else{
            bannerTotal = subTotal;
            DecimalFormat formatter = new DecimalFormat("#,###.00");
            bannerTotCal =  formatter.format(bannerTotal);
            return bannerTotCal;
        }
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
        System.out.println("*******************");
       // double taxValue = Calculations.taxCalculation();
        double doubleSubTotal = Calculations.subTotalCalculationDouble();
        System.out.println("Tax amount is "+taxValue);
        System.out.println("Double subtotal amount is "+doubleSubTotal);
        String bannerTot = Calculations.bannerTotalCalculation();
        System.out.println("Banner total amount is "+bannerTot);

    }
}
