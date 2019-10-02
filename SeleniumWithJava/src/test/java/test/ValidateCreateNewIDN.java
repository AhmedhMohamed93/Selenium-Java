package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.BDHomePage;
import pages.Facility;
import utilities.TestBase;
import validationPackage.Validations;

public class ValidateCreateNewIDN extends TestBase
{
	
	/****************************************************************************************************
     *                               Declaration of classes Objects                                     *
     ****************************************************************************************************/
    Facility facility_1;
    BDHomePage homePage;
    Validations validStrings = new Validations();
    
    /****************************************************************************************************
     *                                                                                                  *
     *   Test Method Name : BD_ValidateCreationOfNewHealthSystem()                                      *
     *   Inputs           : String browser                                                         	    *
     *   Objective        : This Test validates creation of New Health System then impersonate it       *
     *                                                                                                  *
     * @throws Throwable 																				*
     ****************************************************************************************************/
    @Test 
    @Parameters("browser")
    public void BD_ValidateCreationOfNewHealthSystem(String browser) throws Throwable
    {
        setup(browser);
        logger = extent.startTest(validStrings.getCreateIDNStart());
        homePage = new BDHomePage(driver);
        facility_1 = new Facility(driver);
        homePage.LaunchingBDWebsite(dataDriven.getUserName(), dataDriven.getUserPassword());
        logger.log(LogStatus.INFO, validStrings.getLaunching());
        facility_1.NavigateToHealthSystems();
        logger.log(LogStatus.INFO, validStrings.getIDNNavigation());
        facility_1.CreateNewIDN(dataDriven.getIDNName(), dataDriven.getiDNID());
        logger.log(LogStatus.INFO, validStrings.getsuccessfulCreationOfIDN());
        facility_1.ImpersonateIDN(dataDriven.getIDNName());
        logger.log(LogStatus.INFO, validStrings.getCreationStatus());
        captureScreenshot(driver,validStrings.getIDNscreenshotName() , new Throwable().getStackTrace()[0].getMethodName());
        logger.log(LogStatus.INFO, validStrings.getconfirmScreenshot());

    }
    

}
