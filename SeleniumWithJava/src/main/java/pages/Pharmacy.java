package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import utilities.TestBase;

public class Pharmacy extends TestBase
{
	
    /****************************************************************************************************
     *                                                                                                  *
     *                                           Variables                                              *
     *                                                                                                  *
     ****************************************************************************************************/







    /****************************************************************************************************
     *                                                                                                  *
     *                                           Locators                                               *
     *                                                                                                  *
     ****************************************************************************************************/
    By Formularies = By.xpath("//a[contains(text(),'Formularies')]");
    By PharmacyFormualry = By.xpath("//span[contains(text(),'Pharmacy Formularies')]");
    By NewPF = By.xpath("//button[@id='AddPharmacy']");
    By PhFName = By.xpath("//input[@id='Name']");
    By PhFID = By.xpath("//input[@id='ID']");
    By Vendor = By.xpath("//div[@class='ng-star-inserted']//input[1]");
    By associatedFacility = By.xpath("//div[@class='pharmacy-formulary-form-association-control double-margin-top double-padding-top']//input[1]");
    By associatedFacilityAdd = By.xpath("//div[@class='pharmacy-formulary-form-association-control double-margin-top double-padding-top']//button[@id='bdassociationcontrol1-add']");
    By SavePF = By.xpath("//button[@id='SaveDetailPharmacyFormulary']");
    By PharmacySearch = By.xpath("//input[@id='SearchItem']");
    By PharmacyValidation = By.xpath("//td[1]//ng2-smart-table-cell[1]//table-cell-view-mode[1]//div[1]//div[1]");

    /****************************************************************************************************
     *                                                                                                  *
     *                                           Methods                                                *
     *                                                                                                  *
     ****************************************************************************************************/



    /****************************************************************************************************
     *                                                                                                  *
     *   Method Name : Pharmacy()                                                                       *
     *   Inputs      : IWebDriver driver                                                                *
     *   Outputs     : Null                                                                             *
     *   Description : This Method is to initialize driver                                              *
     *                                                                                                  *
     ****************************************************************************************************/
    public Pharmacy(WebDriver driver)
    {
        this.driver = driver;
    }


    /****************************************************************************************************
     *                                                                                                  *
     *   Method Name : NavigateToPharmacyFormualries()                                                  *
     *   Inputs      : void                                                                             *
     *   Outputs     : void                                                                             *
     *   Description : This Method is to hover Over "Admin" menu then select navigate to "HealthSyatem" *
     *                                                                                                  *
     ****************************************************************************************************/
    public void NavigateToPharmacyFormualries() throws Throwable
    {
    	waitUntilPageLoad();
        Actions act = new Actions(driver);
        act.moveToElement(driver.findElement(Formularies)).perform();
        driver.findElement(PharmacyFormualry).click();
    }


    /****************************************************************************************************
     *                                                                                                  *
     *   Method Name : CreateNewPharmacyFormualry()                                                     *
     *   Inputs      : String Pharmacy Formualry Name                                                   *
     *               : String Pharmacy Formaulry ID                                                     *
     *               : String Vendor                                                                    *
     *               : String Facility Name                                                             *
     *   Outputs     : Void                                                                             *
     *   Description : This Method is to Create new Pharmacy Formulary and fill all required fields     *
     *               :  in the displayed dialog                                                         *
     *                                                                                                  *
     * @throws Throwable 
     ****************************************************************************************************/
    
    public void CreateNewPharmacyFormualry(String PFName, String PFID, String PFVendor, String FacilityName) throws Throwable
    {
    	waitUntilPageLoad();
        driver.findElement(NewPF).click();
        driver.findElement(PhFName).sendKeys(PFName);
        driver.findElement(PhFID).sendKeys(PFID);
        driver.findElement(Vendor).click();
        driver.findElement(Vendor).sendKeys(PFVendor);
        driver.findElement(associatedFacility).click();
        driver.findElement(associatedFacility).sendKeys(FacilityName);
        driver.findElement(associatedFacilityAdd).click();
        driver.findElement(SavePF).click();
    	waitUntilPageLoad();
        driver.findElement(PharmacySearch).sendKeys(PFName);
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(PharmacyValidation).getText(), PFName);
    }	

}
