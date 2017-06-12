package SalesAndMarketing._01_Common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.util.concurrent.TimeUnit;

public class _01_03_SalesAndMarketingModules {
	WebDriver driver;
	By itemMainNavMenu 		= By.xpath("html/body/div[1]/div[1]/div[1]/span[1]/img");
	By itemSalesAndMktMenu 	= By.xpath("/html/body/div[1]/div[3]/div/ul/li[4]/a");
	//Master
	By itemMaster 			= By.xpath("/html/body/div[1]/div[3]/div/ul/ul/li[1]/a");
	By ItemAccGroupConfig 	= By.xpath("//*[@id='header0']/li[1]/a[1]");
	By itemAccInfo 			= By.xpath("//*[@id='header0']/li[2]/a[1]");
	By itemCollUnit 		= By.xpath("//*[@id=,header0,]/li[3]/a[1]");
	By itemContInfo 		= By.xpath("//*[@id='header0']/li[4]/a[1]");
	By itemLeadInfo			= By.xpath("//*[@id='header0']/li[5]/a[1]");
	By itemSalesInq		 	= By.xpath("//*[@id='header0']/li[6]/a[1]");
	By itmSalesUnit 		= By.xpath("//*[@id='header0']/li[7]/a[1]");
	//SetUp
	By itemSetup 			= By.xpath("/html/body/div[1]/div[3]/div/ul/ul/li[2]/a");
	By itemCallLog 			= By.xpath("//*[@id='header1']/li[1]/a[1]");
	By itemComRules 		= By.xpath("//*[@id='header1']/li[3]/a[1]");
	By itemPricigModle 		= By.xpath("//*[@id='header1']/li[5]/a[1]");
	By itemSalesOrg 		= By.xpath("//*[@id='header1']/li[7]/a[1]");
	By itemVehicleInfo 		= By.xpath("//*[@id='header1']/li[9]/a[1]");
	By itemCRM 				= By.xpath("/html/body/div[1]/div[3]/div/ul/ul/li[3]/a");
	By itemCampaing 		= By.xpath("//*[@id='header']/li/a[1]");
	By itemSales 			= By.xpath("/html/body/div[1]/div[3]/div/ul/ul/li[4]/a");
	By itemCharts 			= By.xpath("//*[@id='header3']/li[1]/a[1]");
	By itemInvoiceProp 		= By.xpath("//*[@id='header3']/li[3]/a[1]");
	By itemReports 			= By.xpath("//*[@id='header3']/li[5]/a[1]");
	By itemSalesInvo 		= By.xpath("//*[@id='header3']/li[7]/a[1]");
	By itemSalesOrd 		= By.xpath("//*[@id='header3']/li[9]/a[1]");
	By itemSalesRetuInvo 	= By.xpath("//*[@id='header3']/li[11]/a[1]");
	By itemSalesTarget 		= By.xpath("//*[@id='header3']/li[13]/a[1]");
	//Tab2
	By itemCommAgrmnt 		= By.xpath("//*[@id='header1']/li[2]/a[1]");
	By itemCustAgree 		= By.xpath("//*[@id='header1']/li[4]/a[1]");
	By itemPriceRul			= By.xpath("//*[@id='header1']/li[4]/a[1]");
	By itemSalesParam 		= By.xpath("//*[@id='header1']/li[8]/a[1]");
	By itemWarrProf 		= By.xpath("//*[@id='header1']/li[10]/a[1]");
	By itemFreeTxtInvo 		= By.xpath("//*[@id='header3']/li[2]/a[1]");
	By itemPos 				= By.xpath("//*[@id='header3']/li[4]/a[1]");
	By itemSalesComSlip 	= By.xpath("//*[@id='header3']/li[6]/a[1]");
	By itemSalesIten 		= By.xpath("//*[@id='header3']/li[8]/a[1]");
	By itemSalesQuota 		= By.xpath("//*[@id='header3']/li[10]/a[1]");
	By itemSalesRetOrd 		= By.xpath("//*[@id='header3']/li[12]/a[1]");
	
	public _01_03_SalesAndMarketingModules(WebDriver driver){
		this.driver=driver;
	}
	
	public void SalesAndMktModuleVerifi(){
		this.salesAndMktVerifiFunc();
	}
	

	public void salesAndMktVerifiFunc(){
		
		try{
			WebDriverWait wait = new WebDriverWait(driver,40);
			wait.pollingEvery(30, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.presenceOfElementLocated(itemMainNavMenu));
			Reporter.log("Navigation Menu Available");
			}catch(Exception e){
				Reporter.log("<font color='red'>Navigation menu not available</font>");
			}
			finally{}
		
		try{
			WebDriverWait wait = new WebDriverWait(driver,40);
			wait.pollingEvery(30, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.presenceOfElementLocated(itemSalesAndMktMenu));
			Reporter.log("Sales and Marketing navigation menu available ");
			}catch(Exception e){
				Reporter.log("<font color='red'>Navigation menu not available</font>");
			}
			finally{}
		
			try{
			WebDriverWait wait = new WebDriverWait(driver,40);
				wait.pollingEvery(30, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.presenceOfElementLocated(itemMaster));
		Reporter.log("Master label available---------- ");
		}catch(Exception e){
			Reporter.log("<font color='red'>Master label not available</font>");
		}
		finally{}
		
			try{
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.presenceOfElementLocated(ItemAccGroupConfig));
		Reporter.log("Account Group Configuration module available ");
		}catch(Exception e){
			Reporter.log("<font color='red'>Account Group Configuration Module not available</font>");
		}
		finally{}
		
		try{
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.presenceOfElementLocated(itemAccInfo));
		Reporter.log("Account Information module available ");
		}catch(Exception e){
			Reporter.log("<font color='red'>Account information module not available</font>");
		}
		finally{}
		
		try{
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.presenceOfElementLocated(itemCollUnit));
		Reporter.log("Collection Unit module available ");
		}catch(Exception e){
			Reporter.log("<font color='red'>Collection Unit module not available</font>");
		}
		finally{}
		
		try{
			WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.presenceOfElementLocated(itemContInfo));
		Reporter.log("Contact Information module available ");
			}catch(Exception e){
				Reporter.log("<font color='red'>Contact Information module not available</font>");
		}
		finally{}
	
		try{
			WebDriverWait wait = new WebDriverWait(driver,40);
			wait.pollingEvery(30, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.presenceOfElementLocated(itemLeadInfo));
			Reporter.log("Lead Information module available ");
			}catch(Exception e){
				Reporter.log("<font color='red'>Lead Information module not available</font>");
			}
			finally{}
		
			try{
			WebDriverWait wait = new WebDriverWait(driver,40);
			wait.pollingEvery(30, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.presenceOfElementLocated(itemSalesInq));
			Reporter.log("Sales Inquiry module available ");
			}catch(Exception e){
				Reporter.log("<font color='red'>Sales Inquiry module not available</font>");
			}
			finally{}
		
		try{
			WebDriverWait wait = new WebDriverWait(driver,40);
			wait.pollingEvery(30, TimeUnit.SECONDS);
				wait.until(ExpectedConditions.presenceOfElementLocated(itmSalesUnit));
			Reporter.log("Sales Unit module available ");
			}catch(Exception e){
				Reporter.log("<font color='red'>Sales Unit module not available</font>");
			}
			finally{}
		
			try{
				WebDriverWait wait = new WebDriverWait(driver,40);
				wait.pollingEvery(30, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.presenceOfElementLocated(itemSetup));
			Reporter.log("Setup Label available---------- ");
				}catch(Exception e){
					Reporter.log("<font color='red'>Setup Label module not available</font>");
		}
	finally{}
		
		try{
				WebDriverWait wait = new WebDriverWait(driver,40);
				wait.pollingEvery(30, TimeUnit.SECONDS);
				wait.until(ExpectedConditions.presenceOfElementLocated(itemCallLog));
					Reporter.log("Call Log module available ");
				}catch(Exception e){
							Reporter.log("<font color='red'>Call Log module not available</font>");
			}
			finally{}
		
			try{
				WebDriverWait wait = new WebDriverWait(driver,40);
				wait.pollingEvery(30, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.presenceOfElementLocated(itemComRules));
				Reporter.log("Commission Rules module available ");
			}catch(Exception e){
							Reporter.log("<font color='red'>Commission Rules module not available</font>");
				}
		finally{}
		
			try{
				WebDriverWait wait = new WebDriverWait(driver,40);
					wait.pollingEvery(30, TimeUnit.SECONDS);
				wait.until(ExpectedConditions.presenceOfElementLocated(itemPricigModle));
				Reporter.log("Pricing Model module available ");
							}catch(Exception e){
				Reporter.log("<font color='red'>Pricing Model module not available</font>");
				}
				finally{}
		
			try{
				WebDriverWait wait = new WebDriverWait(driver,40);
				wait.pollingEvery(30, TimeUnit.SECONDS);
				wait.until(ExpectedConditions.presenceOfElementLocated(itemSalesOrg));
				Reporter.log("Sales Organization module available ");
				}catch(Exception e){
				Reporter.log("<font color='red'>Sales Organization module not available</font>");
			}
			finally{}
		
			try{
				WebDriverWait wait = new WebDriverWait(driver,40);
					wait.pollingEvery(30, TimeUnit.SECONDS);
				wait.until(ExpectedConditions.presenceOfElementLocated(itemVehicleInfo));
					Reporter.log("Vehicle Information module available ");
				}catch(Exception e){
					Reporter.log("<font color='red'>Vehicle Information module not available</font>");
				}
			finally{}
	
			try{
				WebDriverWait wait = new WebDriverWait(driver,40);
					wait.pollingEvery(30, TimeUnit.SECONDS);
				wait.until(ExpectedConditions.presenceOfElementLocated(itemCRM));
				Reporter.log("CRM label available---------- ");
				}catch(Exception e){
					Reporter.log("<font color='red'>CRM label not available</font>");
				}
		finally{}
		
			try{
				WebDriverWait wait = new WebDriverWait(driver,40);
				wait.pollingEvery(30, TimeUnit.SECONDS);
				wait.until(ExpectedConditions.presenceOfElementLocated(itemCampaing));
				Reporter.log("Campaing module available ");
			}catch(Exception e){
				Reporter.log("<font color='red'>Campaing module not available</font>");
				}
			finally{}
		
		try{
			WebDriverWait wait = new WebDriverWait(driver,40);
			wait.pollingEvery(30, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.presenceOfElementLocated(itemSales));
			Reporter.log("Sales label available---------- ");
					}catch(Exception e){
				Reporter.log("<font color='red'>Sales label not available</font>");
			}
			finally{}
		
		try{
			WebDriverWait wait = new WebDriverWait(driver,40);
			wait.pollingEvery(30, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.presenceOfElementLocated(itemCharts));
			Reporter.log("Charts module available ");
			}catch(Exception e){
							Reporter.log("<font color='red'>Charts module not available</font>");
			}
		finally{}

		try{
		WebDriverWait wait = new WebDriverWait(driver,40);
					wait.pollingEvery(30, TimeUnit.SECONDS);
					wait.until(ExpectedConditions.presenceOfElementLocated(itemInvoiceProp));
							Reporter.log("Invoice Proposal module available ");
					}catch(Exception e){
						Reporter.log("<font color='red'>Invoice Proposal module not available</font>");
					}
					finally{}
		
		try{
			WebDriverWait wait = new WebDriverWait(driver,40);
					wait.pollingEvery(30, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.presenceOfElementLocated(itemReports));
		Reporter.log("Reports module available ");
			}catch(Exception e){
				Reporter.log("<font color='red'>Reports module not available</font>");
			}
			finally{}
		
		try{
			WebDriverWait wait = new WebDriverWait(driver,40);
					wait.pollingEvery(30, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.presenceOfElementLocated(itemSalesInvo));
			Reporter.log("Sales Invoice module available ");
			}catch(Exception e){
				Reporter.log("<font color='red'>Sales Invoice module not available</font>");
			}
			finally{}
		
		try{
			WebDriverWait wait = new WebDriverWait(driver,40);
			wait.pollingEvery(30, TimeUnit.SECONDS);
						wait.until(ExpectedConditions.presenceOfElementLocated(itemSalesOrd));
			Reporter.log("Sales Order module available ");
			}catch(Exception e){
			Reporter.log("<font color='red'>Sales Order module not available</font>");
					}
			finally{}
		
		try{
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.presenceOfElementLocated(itemSalesRetuInvo));
				Reporter.log("Sales Return Invoice module available ");
				}catch(Exception e){
			Reporter.log("<font color='red'>Sales Return Invoice module not available</font>");
			}
			finally{}
		
		try{
		WebDriverWait wait = new WebDriverWait(driver,40);
				wait.pollingEvery(30, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.presenceOfElementLocated(itemSalesTarget));
		Reporter.log("Sales Target module available ");
			}catch(Exception e){
			Reporter.log("<font color='red'>Sales Target module not available</font>");
			}
			finally{}
		//Tab2
		try{
			WebDriverWait wait = new WebDriverWait(driver,40);
				wait.pollingEvery(30, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.presenceOfElementLocated(itemCommAgrmnt));
			Reporter.log("Second Tab Modules---------- ");
			Reporter.log("Commission Agreement module available ");
			}catch(Exception e){
				Reporter.log("<font color='red'>Commission Agreement module not available</font>");
			}
		finally{}
		
		try{
			WebDriverWait wait = new WebDriverWait(driver,40);
			wait.pollingEvery(30, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.presenceOfElementLocated(itemCustAgree));
			Reporter.log("Customer Agreement module available ");
			}catch(Exception e){
				Reporter.log("<font color='red'>Customer Agreement module not available</font>");
			}
		finally{}		
	try{
			WebDriverWait wait = new WebDriverWait(driver,40);
			wait.pollingEvery(30, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.presenceOfElementLocated(itemPriceRul));
			Reporter.log("Pricing Rule module available ");
			}catch(Exception e){
				Reporter.log("<font color='red'>Pricing Rule module not available</font>");
					}
			finally{}
		
		try{
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.pollingEvery(30, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.presenceOfElementLocated(itemSalesParam));
		Reporter.log("Sales Parameters module available ");
		}catch(Exception e){
			Reporter.log("<font color='red'>Sales Parameters module not available</font>");
			}
			finally{}
		
		try{
			WebDriverWait wait = new WebDriverWait(driver,40);
			wait.pollingEvery(30, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.presenceOfElementLocated(itemWarrProf));
				Reporter.log("Warrenty Profile module available ");
			}catch(Exception e){
				Reporter.log("<font color='red'>Warrenty Profile module not available</font>");
			}
		finally{}
		
		try{
			WebDriverWait wait = new WebDriverWait(driver,40);
			wait.pollingEvery(30, TimeUnit.SECONDS);
					wait.until(ExpectedConditions.presenceOfElementLocated(itemPos));
					Reporter.log("POS module available ");
			}catch(Exception e){
				Reporter.log("<font color='red'>POS module not available</font>");
			}
			finally{}
		//itemPos
		try{
					WebDriverWait wait = new WebDriverWait(driver,40);
			wait.pollingEvery(30, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.presenceOfElementLocated(itemFreeTxtInvo));
			Reporter.log("Free Text Invoice module available ");
			}catch(Exception e){
				Reporter.log("<font color='red'>Free Text Invoice module not available</font>");
			}
			finally{}
		
		//itemSalesComSlip
		try{
			WebDriverWait wait = new WebDriverWait(driver,40);
			wait.pollingEvery(30, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.presenceOfElementLocated(itemSalesComSlip));
			Reporter.log("Sales Commision Slip module available ");
			}catch(Exception e){
				Reporter.log("<font color='red'>Sales Commision Slip module not available</font>");
			}
			finally{}
		//itemSalesIten
	try{		WebDriverWait wait = new WebDriverWait(driver,40);
				wait.pollingEvery(30, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.presenceOfElementLocated(itemSalesIten));
		Reporter.log("Sales Itinerary module available ");
		}catch(Exception e){
			Reporter.log("<font color='red'>Sales Itinerary module not available</font>");
		}
		finally{
		}
		
			try{
					WebDriverWait wait = new WebDriverWait(driver,40);
				wait.pollingEvery(30, TimeUnit.SECONDS);
				wait.until(ExpectedConditions.presenceOfElementLocated(itemSalesQuota));
				Reporter.log("Sales Quotation module available ");
				}catch(Exception e){
					Reporter.log("<font color='red'>Sales Quotation module not available</font>");
				}
				finally{}
		
			try{
				WebDriverWait wait = new WebDriverWait(driver,40);
				wait.pollingEvery(30, TimeUnit.SECONDS);
				wait.until(ExpectedConditions.presenceOfElementLocated(itemSalesRetOrd));
				Reporter.log("Sales Return Order module available ");
				}catch(Exception e){
					Reporter.log("<font color='red'>Sales Return Order module not available</font>");
				}
				finally{}
		}
}
