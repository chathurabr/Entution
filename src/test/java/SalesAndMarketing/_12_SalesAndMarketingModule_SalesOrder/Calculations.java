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
    //Tax
    public static double taxPrecentage = 15;
    public static double taxAmount;
    //SubTotal
    public static double subTotal;
    public static double taxValue;
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

    public static double subTotalCalculationDouble(){
        double subTotalValueDouble = 0;
        //double subT;

        if(discountAmount>0) {

           // lineTot = price*quantity;
            subTotalValueDouble = lineTotal - discountAmount;


            return subTotalValueDouble;

        }else if (discountPrecentage >0 && discountAmount<=0){

            lineTotal = price*quantity;
            double discAmtByPrecentage =(discountPrecentage/100)*lineTotal;
            subTotalValueDouble = lineTotal - discAmtByPrecentage;

            return subTotalValueDouble;

        }else if(discountAmount>0 && discountPrecentage >0){
            System.out.println("Else");
            return subTotalValueDouble;
        }else {
            return subTotalValueDouble;
        }
    }

    public static double taxCalculation(){
        double taxVal = 0.0;
        //double tV;
        double subTot =Calculations.subTotalCalculationDouble();
        System.out.println("}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}"+subTot);

        if(taxPrecentage > 0){
            taxVal = (subTot*taxPrecentage)/100;
            System.out.println("}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}"+taxVal);

            return taxVal;
        }else if (taxPrecentage<=0){
            taxVal = subTot;
            return taxVal;
        }else {
            return taxVal;
        }
    }

    public static String bannerTotalCalculation(){
        String bannerTotCal = null;

        if(taxValue>0){
            bannerTotal = taxValue+lineTotal;
            return bannerTotCal;
        }else{
            bannerTotal = lineTotal;
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
        double taxValue = Calculations.taxCalculation();
        double doubleSubTotal = Calculations.subTotalCalculationDouble();
        System.out.println("Tax amount is "+taxValue);
        System.out.println("Double subtotal amount is "+doubleSubTotal);
        String bannerTot = Calculations.bannerTotalCalculation();
        System.out.println("Banner total amount is "+bannerTot);

    }
}
