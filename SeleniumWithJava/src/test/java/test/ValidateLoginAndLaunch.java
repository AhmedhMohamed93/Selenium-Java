package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.BDHomePage;
import utilities.TestBase;
import validationPackage.Validations;

public class ValidateLoginAndLaunch extends TestBase
{
	/****************************************************************************************************
     *                               Declaration of classes Objects                                     *
     ****************************************************************************************************/
    BDHomePage homePage;
    Validations validStrings = new Validations();
    
    /****************************************************************************************************
     *                                                                                                  *
     *   Test Method Name : BD_ValidateLaunchWebsite()                                                  *
     *   Inputs           : String browser                                                              *
     *   Objective        : This Test is validating successful navigation to the BD Website             *
     *                                                                                                  *
     * @throws Throwable 																				*
     ****************************************************************************************************/

    @Test 
    @Parameters("browser")
    public void BD_ValidateLaunchWebsite(String browser) throws Throwable
    {
        setup(browser);
        logger = extent.startTest(validStrings.getlaunchStart());
        homePage = new BDHomePage(driver);
        homePage.Navigate();
        logger.log(LogStatus.INFO, validStrings.getnavigationString());
        homePage.ValidateLaunchingPageSucessfully();
        logger.log(LogStatus.INFO, validStrings.getlaunchStatus());
    }
    
    
    /****************************************************************************************************
     *                                                                                                  *
     *   Test Method Name : BD_LoginSuccessfully()                                                      *
     *   Inputs           : String browser                                                        	    *
     *   Objective        : This Test is validating successful Login to the BD Website                  *
     *                                                                                                  *
     * @throws Throwable 																				*
     ****************************************************************************************************/
    @Test 
    @Parameters("browser")
    public void BD_LoginSuccessfully(String browser) throws Throwable
    {
        setup(browser);
        logger = extent.startTest(validStrings.getloginStart());
        homePage = new BDHomePage(driver);
        homePage.Navigate();
        logger.log(LogStatus.INFO,validStrings.getnavigationString());
        homePage.Login(dataDriven.getUserName(), dataDriven.getUserPassword());
        logger.log(LogStatus.INFO, validStrings.getlogging());
        homePage.ValidateLoginPageNavigation();
        logger.log(LogStatus.INFO,validStrings.getloginStatus());

    }    
    

}