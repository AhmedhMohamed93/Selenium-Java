package pages;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

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

    private By Infusion = By.xpath("//a[contains(text(),'Infusion')]");
    private By alignmentProject = By.xpath("//span[contains(text(),'Alignment Projects')]");
    private By NewalignmentProjectBtn = By.xpath("//button[@id='AddAlignmentProject']");
    private By AlignmentProjectName = By.xpath("//input[@id='Name']");
    private By EMRFormualry = By.xpath("//div[@class='col-md-5']//bddropdown[@name='autoCompleteControls[0].Name']//input[1]");
    private By Facility = By.xpath("//div[@class= 'checkbox']/label");
    private By UploadGRE = By.xpath("//label[@class='btn btn-default']");
    private By EMRItems = By.xpath("//div[@class='col-md-4 IvLabel']//input[1]");
    private By EMRItemsSelect = By.xpath("//a[@id='listItemIVTypesList2']");
    private By UploadEMR = By.xpath("//file-uploader[@id='IvFiles Uploader']//label[@class='btn btn-default'][contains(text(),'Browse')]");
    private By SaveAlignmentProject = By.xpath("//div[@class='col-sm-12 tab-container-header']//span[1]");
    private By AlignmentSearch = By.xpath("//input[@id='SearchItem']");
    private By AlignmentProjectValidation = By.xpath("//td[1]//ng2-smart-table-cell[1]//table-cell-view-mode[1]//div[1]//div[1]");
    private By UploadSucessfully = By.xpath("//span[contains(text(),'File Uploaded.')]");




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
     * @throws Throwable 																				*
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
     *               : String Pharmacy Formulary Name                                                   *
     *   Outputs     : Void                                                                             *
     *   Description : This Method is to Fill all required fields in order to create Alignment Project  *
     *               : and upload GRE file and EMR Items                                                *
     *                                                                                                  *
     * @throws Throwable 																				*
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
        
        /****************************************************************************************************
         *                						Upload GRE File                                             *
         *   						Using Robot Class method to upload files                                *
         ****************************************************************************************************/
        Thread.sleep(2000);
        StringSelection strSel = new StringSelection("C:\\Users\\ahmed.mohamed\\Documents\\GitHub\\Selenium-Java\\SeleniumWithJava\\Needed Files\\Infusion_Demo.gre");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strSel, null);
        Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
	    /****************************************************************************************************
	     *                						Upload GRE File                                             *
	     *           In order to use AutoIt method to upload files just uncomment the following line 		*
	     *   		                    and comment the previous block                                      *
	     ****************************************************************************************************/
		
        //Runtime.getRuntime().exec(".\\Needed Files\\GRE.exe");
		
        waituntillfinishUpload(UploadSucessfully);
        driver.findElement(EMRItems).click();
        driver.findElement(EMRItemsSelect).click();
        driver.findElement(UploadEMR).click();
        
        /****************************************************************************************************
         *                						Upload IV File                                              *
         *   						Using Robot Class method to upload files                                *
         ****************************************************************************************************/
        Thread.sleep(2000);
        StringSelection strSel1 = new StringSelection("C:\\Users\\ahmed.mohamed\\Documents\\GitHub\\Selenium-Java\\SeleniumWithJava\\Needed Files\\SC IV SET-Original.xls");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strSel1, null);
        Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_CONTROL);
		robot1.keyPress(KeyEvent.VK_V);
		robot1.keyRelease(KeyEvent.VK_CONTROL);
		robot1.keyRelease(KeyEvent.VK_V);
		Thread.sleep(2000);
		robot1.keyPress(KeyEvent.VK_ENTER);
		robot1.keyRelease(KeyEvent.VK_ENTER);
		
	    /****************************************************************************************************
	     *                						Upload GRE File                                             *
	     *           In order to use AutoIt method to upload files just uncomment the following line 		*
	     *   		                    and comment the previous block                                      *
	     ****************************************************************************************************/
		
        //Runtime.getRuntime().exec(".\\Needed Files\\IVFile.exe");
		
        waituntillfinishUpload(UploadSucessfully);
        driver.findElement(SaveAlignmentProject).click();
    	waitUntilPageLoad();
        driver.findElement(AlignmentSearch).sendKeys(AlignmentprojectName);
        waitUntilPageLoad();
        Assert.assertEquals(driver.findElement(AlignmentProjectValidation).getText(), AlignmentprojectName);
    }	
}
