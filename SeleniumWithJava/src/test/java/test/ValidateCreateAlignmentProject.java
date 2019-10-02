package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.AlignmentProjects;
import pages.BDHomePage;
import pages.Facility;
import utilities.TestBase;
import validationPackage.Validations;

public class ValidateCreateAlignmentProject extends TestBase 
{
	
    /****************************************************************************************************
     *                               Declaration of classes Objects                                     *
     ****************************************************************************************************/
    Facility facility_1;
    AlignmentProjects project_1;
    BDHomePage homePage;
    Validations validStrings = new Validations();	
    /****************************************************************************************************
     *                                                                                                  *
     *   Test Method Name : BD_ValidateCreationOfNewAlignmentProject()                                  *
     *   Inputs           : String browser                                                          	*
     *   Objective        : This Test validates creation of New Alignment PRoject  within the           *
     *                    : created Health System                                                       *
     *                                                                                                  *
     * @throws Throwable 																				*
     ****************************************************************************************************/
    @Test 
    @Parameters("browser")
    public void BD_ValidateCreationOfNewAlignmentProject(String browserName) throws Throwable
    {
        setup(browserName);
        logger = extent.startTest(validStrings.getCreateProjectStart());
        BDHomePage home = new BDHomePage(driver);
        facility_1 = new Facility(driver);
        project_1 = new AlignmentProjects(driver);
        home.LaunchingBDWebsite(dataDriven.getUserName(), dataDriven.getUserPassword());
        logger.log(LogStatus.INFO, validStrings.getLaunching());
        facility_1.ImpersonateIDN(dataDriven.getIDNName());
        logger.log(LogStatus.INFO, validStrings.getImpersonate());
        project_1.NavigateToAlignmentProject();
        logger.log(LogStatus.INFO, validStrings.getAlignmentNavigation());
        project_1.CreateNewPharmacyAlignmentProject(dataDriven.getAlignmentProjectName(), dataDriven.getPharmacyFormularyName());
        logger.log(LogStatus.INFO, validStrings.getAlignmentcreationStatus());
        captureScreenshot(driver,validStrings.getAlignmentscreenshotName() , new Throwable().getStackTrace()[0].getMethodName());
        logger.log(LogStatus.INFO, validStrings.getconfirmScreenshot());
    }    
	

}
