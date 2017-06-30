package SalesAndMarketing._12_SalesAndMarketingModule_SalesOrder;

import SalesAndMarketing.testCases.TestCase_2_SalesOrderToSalesInvoice_Service;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Properties;

/**
 * Created by Ramitha on 6/22/2017.
 */
public class Calculations {
    public static WebDriver driver;

    public static double price;
    public static double quantity;
    //Discount
    public static double discountAmount ;
    public static double discountPercentage;
    //Tax
    public static double taxPercentage;
    public static double taxValue;
    //Total
    public static double subTotal;
    public static double lineTotal;
    public static double bannerTotal;

    /*Invoice Percentage Calculation SalesOrderToSalesInvoice - Service */
    public static double InvoicePercentage;


    public Calculations(){
        this.driver = driver;
    }

    public static void getValues() throws org.apache.commons.configuration.ConfigurationException {

        Properties properties =new Properties();
        try {
            String filePath = System.getProperty("user.dir");
            properties.load(new FileInputStream(filePath+"\\util\\Test.properties"));
            price = Integer.parseInt(properties.getProperty("price"));
            quantity = Integer.parseInt(properties.getProperty("quantity"));
            discountPercentage = Integer.parseInt(properties.getProperty("discountPercentage"));
            discountAmount= Integer.parseInt(properties.getProperty("discountAmount"));
            taxPercentage = Integer.parseInt(properties.getProperty("taxPercentage"));
            InvoicePercentage = Integer.parseInt(properties.getProperty("InvoicePercentage"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String lineTotalCalculation(){
        String SlineTotal = null;
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


    public static String getPrice(){
        DecimalFormat formatter = new DecimalFormat("#,###.00");
        return  formatter.format(price);

    }

    public static String getInvoicePercentage(){
        DecimalFormat formatter = new DecimalFormat("#,###.00");
        return  formatter.format(InvoicePercentage);

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


    public static String lineTotalCalculationWithInvoicePercentage (){
        String SlineTotal = null;
        double lineTotalAfterInvoicePercentage;

        if (InvoicePercentage>0) {
            lineTotalAfterInvoicePercentage = lineTotal * (InvoicePercentage / 100);
            DecimalFormat formatter = new DecimalFormat("#,###.00");
            SlineTotal = formatter.format(lineTotalAfterInvoicePercentage);
            return SlineTotal;
        }else {
            lineTotalAfterInvoicePercentage = lineTotal;
            DecimalFormat formatter = new DecimalFormat("#,###.00");
            SlineTotal =  formatter.format(lineTotalAfterInvoicePercentage);
            return SlineTotal;

        }

    }

    public static String subTotalCalculationWithInvoicePercentage (){
        String SsubTotal = null;
        double subTotalAfterInvoicePercentage;
        if (InvoicePercentage>0) {
        subTotalAfterInvoicePercentage = subTotal*(InvoicePercentage/100);
        DecimalFormat formatter = new DecimalFormat("#,###.00");
        SsubTotal =  formatter.format(subTotalAfterInvoicePercentage);
        return SsubTotal;}
        else {
            subTotalAfterInvoicePercentage = subTotal;
            DecimalFormat formatter = new DecimalFormat("#,###.00");
            SsubTotal =  formatter.format(subTotalAfterInvoicePercentage);
            return SsubTotal;
        }

    }

    public static String bannerTotalCalculationWithInvoicePercentage (){
        String SbannerTotal = null;
        double bannerTotalAfterInvoicePercentage;
        if (InvoicePercentage>0) {
        bannerTotalAfterInvoicePercentage = bannerTotal*(InvoicePercentage/100);
        DecimalFormat formatter = new DecimalFormat("#,###.00");
        SbannerTotal =  formatter.format(bannerTotalAfterInvoicePercentage);
        return SbannerTotal;}
        else {
            bannerTotalAfterInvoicePercentage = bannerTotal;
            DecimalFormat formatter = new DecimalFormat("#,###.00");
            SbannerTotal =  formatter.format(bannerTotalAfterInvoicePercentage);
            return SbannerTotal;

        }

    }

    public static String discountValueCalculationWithInvoicePercentage (){
        String discountVal = null;
        double discountValAfterInvoicePercentage;

        if (InvoicePercentage>0){
        discountValAfterInvoicePercentage = discountAmount*(InvoicePercentage/100);
        DecimalFormat formatter = new DecimalFormat("#,###.00");
        discountVal =  formatter.format(discountValAfterInvoicePercentage);
        return discountVal;}

        else { discountValAfterInvoicePercentage = discountAmount;
            DecimalFormat formatter = new DecimalFormat("#,###.00");
            discountVal =  formatter.format(discountValAfterInvoicePercentage);
            return discountVal;

        }

    }

    public static String taxValueCalculationWithInvoicePercentage (){
        String taxVal = null;
        double taxValueAfterInvoicePercentage;
        if (InvoicePercentage>0) {
        taxValueAfterInvoicePercentage = taxValue*(InvoicePercentage/100);
        DecimalFormat formatter = new DecimalFormat("#,###.00");
        taxVal =  formatter.format(taxValueAfterInvoicePercentage);
        return taxVal;}
        else {
            taxValueAfterInvoicePercentage = taxValue;
            DecimalFormat formatter = new DecimalFormat("#,###.00");
            taxVal =  formatter.format(taxValueAfterInvoicePercentage);
            return taxVal;

        }

    }
}
