package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.BDHomePage;
import pages.Facility;
import pages.Pharmacy;
import utilities.TestBase;
import validationPackage.Validations;

public class ValidateCreateNewPF extends TestBase
{

	/****************************************************************************************************
     *                               Declaration of classes Objects                                     *
     ****************************************************************************************************/
    Facility facility_1;
    Pharmacy pharm_1;
    BDHomePage homePage;
    Validations validStrings = new Validations();
    /****************************************************************************************************
     *                                                                                                  *
     *   Test Method Name : BD_ValidateCreationOfNewPharmacyFormualry()                                 *
     *   Inputs           : String browser                                                          	*
     *   Objective        : This Test validates creation of New Pharmacy Formualry within the           *
     *                    : created Health System                                                       *
     *                                                                                                  *
     * @throws Throwable 																				*
     ****************************************************************************************************/
    @Test 
    @Parameters("browser")
    public void BD_ValidateCreationOfNewPharmacyFormualry(String browser) throws Throwable
    {
        setup(browser);
        logger = extent.startTest(validStrings.getCreatePharmacyStart());
        BDHomePage home = new BDHomePage(driver);
        pharm_1 = new Pharmacy(driver);
        facility_1 = new Facility(driver);
        home.LaunchingBDWebsite(dataDriven.getUserName(), dataDriven.getUserPassword());
        logger.log(LogStatus.INFO, validStrings.getLaunching());
        facility_1.ImpersonateIDN(dataDriven.getIDNName());
        logger.log(LogStatus.INFO, validStrings.getImpersonate());
        pharm_1.NavigateToPharmacyFormualries();
        logger.log(LogStatus.INFO, validStrings.getpharmacyNavigation());
        pharm_1.CreateNewPharmacyFormualry(dataDriven.getPharmacyFormularyName(), dataDriven.getPharmacyFormularyID(), dataDriven.getPFvendor(), dataDriven.getFacilityName());
        logger.log(LogStatus.INFO, validStrings.getpharmacycreationStatus());
    }

}
