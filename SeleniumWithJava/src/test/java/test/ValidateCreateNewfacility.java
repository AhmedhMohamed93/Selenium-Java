package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.BDHomePage;
import pages.Facility;
import utilities.TestBase;
import validationPackage.Validations;

public class ValidateCreateNewfacility extends TestBase
{
	/****************************************************************************************************
     *                               Declaration of classes Objects                                     *
     ****************************************************************************************************/
    Facility facility_1;
    BDHomePage homePage;
    Validations validStrings = new Validations();
    
    /****************************************************************************************************
     *                                                                                                  *
     *   Test Method Name : BD_ValidateCreationOfNewFacility()                                          *
     *   Inputs           : String browser                                                         		*
     *   Objective        : This Test validates creation of New facility within the created Health      *
     *                    : System                                                                      *
     *                                                                                                  *
     * @throws Throwable 																				*
     ****************************************************************************************************/
    @Test 
    @Parameters("browser")
    public void BD_ValidateCreationOfNewFacility(String browser) throws Throwable
    {
        setup(browser);
        logger = extent.startTest(validStrings.getCreateFacilityStart());
        BDHomePage home = new BDHomePage(driver);
        facility_1 = new Facility(driver);
        home.LaunchingBDWebsite(dataDriven.getUserName(), dataDriven.getUserPassword());
        logger.log(LogStatus.INFO, validStrings.getLaunching());
        facility_1.ImpersonateIDN(dataDriven.getIDNName());
        logger.log(LogStatus.INFO, validStrings.getImpersonate());
        facility_1.NavigateToFacilityAndRegion();
        logger.log(LogStatus.INFO, validStrings.getfacilityNavigation());
        facility_1.CreateNewFacility(dataDriven.getFacilityName(), dataDriven.getFacilityID());
        logger.log(LogStatus.INFO, validStrings.getfacilitycreationStatus());
    }    

}

