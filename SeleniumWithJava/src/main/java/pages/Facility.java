package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utilities.TestBase;

public class Facility extends TestBase
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

	private By adminMenu = By.xpath("//a[@class='px-3'][contains(text(),'Admin')]");
	private By healthSystemDropDown = By.xpath("//span[contains(text(),'Health Systems')]");
	private By newHealthSystem = By.xpath("//button[@id='NewHealthSystemOrg']");
	private By HealthSysName = By.xpath("//input[@id='HealthSystemOrgName']");
	private By HealthSysID = By.xpath("//input[@id='HealthSystemOrgID']");
	private By AnchorProduct = By.xpath("//label[contains(text(),'Alaris')]");
	private By saveBtn = By.xpath("//button[@id='SaveHealthSystemOrg']");
	private By idnComplete = By.xpath("//body[@class='modal-open']/app/div[@id='main-wrapper']/ng-component[@class='ng-star-inserted']/modal/div[@class='modal fade in show']/div[@class='modal-dialog modal-lg']/div[@class='modal-content']/div[@class='modal-body']/form[@id='FormHealthSystemOrg']/div[@class='row']/div[2]");
	private By ActAs = By.xpath("//input[@id='ActingAsDropdown']");
	private By IdnValidation = By.xpath("(//div[@class='bd-title']/span)[1]");
	private By facility = By.xpath("//span[contains(text(),'Regions and Facilities')]");
	private By newFacility = By.xpath("//button[@id='NewRegionFacility']");
	private By facilityName = By.xpath("//input[@id='FacilityName']");
	private By facilityID = By.xpath("//input[@id='FacilityUniqueId']");
	private By SaveFacility = By.xpath("//button[@id='SaveFacilityRegion']");
	private By facilitySearch = By.xpath("//input[@id='SearchRegionFacility']");
	private By FacilityValidation = By.xpath("//td[2]//ng2-smart-table-cell[1]//table-cell-view-mode[1]//div[1]//div[1]");


    /****************************************************************************************************
     *                                                                                                  *
     *                                           Methods                                                *
     *                                                                                                  *
     ****************************************************************************************************/



    /****************************************************************************************************
     *                                                                                                  *
     *   Method Name : Facility()                                                                       *
     *   Inputs      : IWebDriver driver                                                                *
     *   Outputs     : Null                                                                             *
     *   Description : This Method is to initialize driver                                              *
     *                                                                                                  *
     ****************************************************************************************************/
    public Facility(WebDriver driver)
    {
        this.driver = driver;
    }


    /****************************************************************************************************
     *                                                                                                  *
     *   Method Name : NavigateToHealthSystems()                                                        *
     *   Inputs      : void                                                                             *
     *   Outputs     : Void                                                                             *
     *   Description : This Method is to hover Over "Admin" menu then select navigate to "HealthSyatem" *
     *                                                                                                  *
     ****************************************************************************************************/
    public void NavigateToHealthSystems()
    {
        Actions act = new Actions(driver);
        act.moveToElement(driver.findElement(adminMenu)).perform();
        driver.findElement(healthSystemDropDown).click();
    }


    /****************************************************************************************************
     *                                                                                                  *
     *   Method Name : CreateNewIDN()                                                                   *
     *   Inputs      : String IDN Name                                                                  *
     *               : String IDNID                                                                     *
     *   Outputs     : Void                                                                             *
     *   Description : This Method is to Create new Health system and fill all required fields in the   *
     *               : displayed dialog                                                                 *
     *                                                                                                  *
     * @throws Throwable 																				*
     ****************************************************************************************************/
    public void CreateNewIDN(String IDNName, String IDNID) throws Throwable 
    {
    	waitUntilPageLoad();
        driver.findElement(newHealthSystem).click();
        Thread.sleep(1000);
        driver.findElement(HealthSysName).sendKeys(IDNName);
        Thread.sleep(1000);
        driver.findElement(HealthSysID).sendKeys(IDNID);
        driver.findElement(AnchorProduct).click();
        driver.findElement(saveBtn).click();
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(idnComplete));
    }

    /****************************************************************************************************
     *                                                                                                  *
     *   Method Name : ImpersonateIDN()                                                                 *
     *   Inputs      : String IDN Name                                                                  *
     *   Outputs     : Void                                                                             *
     *   Description : This Method is to navigate to the created IDN from Act as dropdown list          *
     *                                                                                                  *
     * @throws Throwable 																				*
     ****************************************************************************************************/
    public void ImpersonateIDN(String IDNName) throws Throwable
    {
        waitUntilPageLoad();
        driver.findElement(ActAs).click();
        driver.findElement(ActAs).sendKeys(IDNName);
        Assert.assertEquals(driver.findElement(IdnValidation).getText(),  "to " + IDNName);
    }


    /****************************************************************************************************
     *                                                                                                  *
     *   Method Name : NavigateToFacilityAndRegion()                                                    *
     *   Inputs      : void                                                                             *
     *   Outputs     : Void                                                                             *
     *   Description : This Method is to navigate to "Facilities" ana Regions from "Admin" menu         *
     *                                                                                                  *
     * @throws Throwable 																				*
     ****************************************************************************************************/
    public void NavigateToFacilityAndRegion() throws Throwable
    {
        waitUntilPageLoad();
        Actions act = new Actions(driver);
        act.moveToElement(driver.findElement(adminMenu)).perform();
        driver.findElement(facility).click();
    }


    /****************************************************************************************************
     *                                                                                                  *
     *   Method Name : CreateNewFacility()                                                              *
     *   Inputs      : String Facility Name                                                             *
     *               : String Facility ID                                                               *
     *   Outputs     : Void                                                                             *
     *   Description : This Method is to Create new Facility and fill all required fields               *
     *                                                                                                  *
     * @throws Throwable 																				*
     ****************************************************************************************************/
    public void CreateNewFacility(String FacilityName, String FacilityID) throws Throwable
    {
    	waitUntilPageLoad();
        driver.findElement(newFacility).click();
        driver.findElement(facilityName).sendKeys(FacilityName);
        driver.findElement(facilityID).sendKeys(FacilityID);
        driver.findElement(SaveFacility).click();
    	waitUntilPageLoad();
        driver.findElement(facilitySearch).sendKeys(FacilityName);
        waitUntilPageLoad();
        Assert.assertEquals(driver.findElement(FacilityValidation).getText(), FacilityName);
    }	

}
