package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utilities.TestBase;

public class AlignmentProjects extends TestBase
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

    By Infusion = By.xpath("//a[contains(text(),'Infusion')]");
    By alignmentProject = By.xpath("//span[contains(text(),'Alignment Projects')]");
    By NewalignmentProjectBtn = By.xpath("//button[@id='AddAlignmentProject']");
    By AlignmentProjectName = By.xpath("//input[@id='Name']");
    By EMRFormualry = By.xpath("//div[@class='col-md-5']//bddropdown[@name='autoCompleteControls[0].Name']//input[1]");
    By Facility = By.xpath("//div[@class= 'checkbox']/label");
    By UploadGRE = By.xpath("//label[@class='btn btn-default']");
    By EMRItems = By.xpath("//div[@class='col-md-4 IvLabel']//input[1]");
    By EMRItemsSelect = By.xpath("//a[@id='listItemIVTypesList2']");
    By UploadEMR = By.xpath("//file-uploader[@id='IvFiles Uploader']//label[@class='btn btn-default'][contains(text(),'Browse')]");
    By SaveAlignmentProject = By.xpath("//div[@class='col-sm-12 tab-container-header']//span[1]");
    By AlignmentSearch = By.xpath("//input[@id='SearchItem']");
    By AlignmentProjectValidation = By.xpath("//td[1]//ng2-smart-table-cell[1]//table-cell-view-mode[1]//div[1]//div[1]");
    By UploadSucessfully = By.xpath("//span[contains(text(),'File Uploaded.')]");




    /****************************************************************************************************
     *                                                                                                  *
     *                                           Methods                                                *
     *                                                                                                  *
     ****************************************************************************************************/


    /****************************************************************************************************
     *                                                                                                  *
     *   Method Name : AlignmentProject()                                                               *
     *   Inputs      : IWebDriver driver                                                                *
     *   Outputs     : Null                                                                             *
     *   Description : This Method is to initialize driver                                              *
     *                                                                                                  *
     ****************************************************************************************************/
    public AlignmentProjects(WebDriver driver)
    {
        this.driver = driver;
    }


    /****************************************************************************************************
     *                                                                                                  *
     *   Method Name : NavigateToAlignmentProject()                                                     *
     *   Inputs      : void                                                                             *
     *   Outputs     : Void                                                                             *
     *   Description : This Method is to hover Over "Infusion" tab then navigate to "Alignment Project" *
     *                                                                                                  *
     * @throws Throwable 
     ****************************************************************************************************/

    public void NavigateToAlignmentProject() throws Throwable
    {
    	waitUntilPageLoad();
        Actions act = new Actions(driver);
        act.moveToElement(driver.findElement(Infusion)).perform();
        driver.findElement(alignmentProject).click();
    }


    /****************************************************************************************************
     *                                                                                                  *
     *   Method Name : CreateNewPharmacyAlignmentProject()                                              *
     *   Inputs      : String Alignment Project Name                                                    *
     *               : String Pharmacy Foprmualry Name                                                  *
     *   Outputs     : Void                                                                             *
     *   Description : This Method is to Fill all required fields in order to create Alignment Project  *
     *               : and upload GRE file and EMR Items                                                *
     *                                                                                                  *
     * @throws Throwable 
     ****************************************************************************************************/

    public void CreateNewPharmacyAlignmentProject(String AlignmentprojectName, String EMRformualry) throws Throwable
    {
    	waitUntilPageLoad();
        driver.findElement(NewalignmentProjectBtn).click();
        driver.findElement(AlignmentProjectName).sendKeys(AlignmentprojectName);
        driver.findElement(EMRFormualry).click();
        driver.findElement(EMRFormualry).sendKeys(EMRformualry);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(Facility));
        driver.findElement(Facility).click();
        driver.findElement(UploadGRE).click();
        /* Ulpoad GRE File */
        Runtime.getRuntime().exec(".\\Needed Files\\GRE.exe");
        waituntillfinishUpload(UploadSucessfully);
        driver.findElement(EMRItems).click();
        driver.findElement(EMRItemsSelect).click();
        driver.findElement(UploadEMR).click();
        /* Upload EMR Items */
        Runtime.getRuntime().exec(".\\Needed Files\\IVFile.exe");
        waituntillfinishUpload(UploadSucessfully);
        driver.findElement(SaveAlignmentProject).click();
    	waitUntilPageLoad();
        driver.findElement(AlignmentSearch).sendKeys(AlignmentprojectName);
        //Thread.sleep(2000);
        waitUntilPageLoad();
        Assert.assertEquals(driver.findElement(AlignmentProjectValidation).getText(), AlignmentprojectName);
    }	
}
