package utilities;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
 
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import dataDriven.Reader;

public class TestBase 
{

    /****************************************************************************************************
     *                                                                                                  *
     *                                           Variables                                              *
     *                                                                                                  *
     ****************************************************************************************************/	
	 protected WebDriver driver ;
	 protected Reader dataDriven = new Reader();
	 protected static ExtentReports extent;
	 protected ExtentTest logger;
	 protected String URL = "https://las-stage-a-2012.kp.cfnp.local/DataManager/#/Home";

	 
	 /****************************************************************************************************
	  *                                                                                                  *
      *                                           Locators                                               *
      *                                                                                                  *
	  ****************************************************************************************************/	

	 By WaitCondition = By.cssSelector("ajax-loader > div.loadingplaceholder");

	 
     /****************************************************************************************************
      *                                                                                                  *
      *                                           Methods                                                *
      *                                                                                                  *
      ****************************************************************************************************/
	 
	 
	 /****************************************************************************************************
      *                                                                                                  *
      *   Method Name : Setup()                                                                          *
      *   Inputs      : String browserName                                                               *
      *   Outputs     : void                                                                             *
      *   Description : This Method is to Handle Web Driver referencing and Extent Report configuration  *
      *                                                                                                  *
      ****************************************************************************************************/	 
	 
	 @BeforeTest
	 public void setupTest()throws Exception
	 {
	 
	 extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/STMExtentReport.html", true);
	 extent
	                .addSystemInfo("Environment", "Stage A Server")
	                .addSystemInfo("User Name", "Ahmed Hamdy");

	                extent.loadConfig(new File(System.getProperty("user.dir")+".\\Extent Configuration\\extent-config.xml"));

	 }
	 
	 @SuppressWarnings({ "deprecation", "static-access" })
	public void setup(String browser) throws Exception
	 {
 		// Call readData function from ReadExcel to import data from Excel sheet
 		dataDriven.readData();
 		getInstance();
 		//Check if parameter passed as 'chrome'
 		if(browser.equalsIgnoreCase("chrome"))
 		{
 			System.setProperty(dataDriven.getChromeDriver(),dataDriven.getChromeProperty());
 			driver = new ChromeDriver();
 			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
 			driver.manage().window().maximize();
 		}
 		
 		else if(browser.equalsIgnoreCase("Firefox"))
 		{
 			System.setProperty(dataDriven.getFirefoxDriver(),dataDriven.getFirefoxProperty());
 			driver = new FirefoxDriver();
 			driver.manage().window().maximize();
 		}
 		
 		else if(browser.equalsIgnoreCase("IE"))
 		{
 			DesiredCapabilities cap = new DesiredCapabilities().internetExplorer();
 			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
 			System.setProperty(dataDriven.getExplorerDriver(),dataDriven.getExplorerProperty());
 			driver = new InternetExplorerDriver(cap);
 			driver.manage().window().maximize();
 		}
 		else
 		{
 			//If no browser passed throw exception
 			throw new Exception(dataDriven.getError());
 		}
		 
	 }
	 
     /****************************************************************************************************
      *                                                                                                  *
      *   Method Name : waituntillPageUpload()                                                           *
      *   Inputs      : void                                                                             *
      *   Outputs     : void                                                                             *
      *   Description : This Method is to wait until ajax loader finish loading the page                 *
      *                                                                                                  *
      ****************************************************************************************************/
	 
	 public void waitUntilPageLoad() throws Throwable
	 {
		 WebDriverWait wait = new WebDriverWait(driver, 300);
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(WaitCondition));
	 }
	 

     /****************************************************************************************************
      *                                                                                                  *
      *   Method Name : waituntillfinshUpload()                                                          *
      *   Inputs      : By element                                                                       *
      *   Outputs     : void                                                                             *
      *   Description : This Method is to wait until finishing upload GRE file ans also IV File          *
      *                                                                                                  *
      ****************************************************************************************************/	 
	 
	 public void waituntillfinishUpload(By element)
	 {
		 WebDriverWait wait = new WebDriverWait(driver, 30000);
		 wait.until(ExpectedConditions.presenceOfElementLocated(element));
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
	 }
	 
	 
     /****************************************************************************************************
      *                                                                                                  *
      *   Method Name : getInstance()                                                                    *
      *   Inputs      : void                                                                             *
      *   Outputs     : ExtentReport Object                                                              *
      *   Description : This Method is to Handle multiple Extent Report objects                          *
      *                                                                                                  *
      ****************************************************************************************************/

     public static ExtentReports getInstance()
     {
         if (extent == null)
         {
             extent = new ExtentReports(System.getProperty("user.dir") +"/test-output/STMExtentReport.html", true);
             extent
             .addSystemInfo("Environment", "Stage Server DM Version 2.0")
             .addSystemInfo("User Name", "Ahmed Hamdy");

             extent.loadConfig(new File(System.getProperty("user.dir")+".\\Extent Configuration\\extent-config.xml"));

         }
         return extent;
     }
	 
	 @AfterMethod
	 public void getResult(ITestResult result)
	 {
		 if(result.getStatus() == ITestResult.FAILURE)
		 {
			 logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
			 logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
		 }
		 else if(result.getStatus() == ITestResult.SKIP)
		 {
			 logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
		 }

		 extent.endTest(logger);
	 }
	 
	 
	 @AfterTest
	 public void endReport()
	 {
	     extent.flush();
	     extent.close();
	 }


}
	 
 
