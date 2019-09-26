package pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utilities.TestBase;

public class BDHomePage extends TestBase
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

	private By SigninBtn = By.xpath("//a[@id='anchorSignIn']");
	private By UserName = By.xpath("//input[@id='username']");
	private By UserPass = By.xpath("//input[@id='password']");
	private By LoginBtn = By.xpath("//button[@id='sign-in']");
	private By LaunchingValidation = By.xpath("//div[@class='item active']//img");
	private By loginNavigation = By.xpath("//a[@class='bdshell--user-info-widget--toggle px-3 bdshell--user-info-widget--username text-light dropdown-toggle text-truncate d-none d-lg-inline']");




    /****************************************************************************************************
     *                                                                                                  *
     *                                           Methods                                                *
     *                                                                                                  *
     ****************************************************************************************************/


    /****************************************************************************************************
     *                                                                                                  *
     *   Method Name : BDHomePage()                                                                     *
     *   Inputs      : IWebDriver driver                                                                *
     *   Outputs     : Null                                                                             *
     *   Description : This Method is to initialize driver                                              *
     *                                                                                                  *
     ****************************************************************************************************/

    public BDHomePage(WebDriver driver)
    {
        this.driver = driver;
    }



    /****************************************************************************************************
     *                                                                                                  *
     *   Method Name : Navigate()                                                                       *
     *   Inputs      : void                                                                             *
     *   Outputs     : void                                                                             *
     *   Description : This Method is to Navigate to BD website                                         *
     *                                                                                                  *
     ****************************************************************************************************/
    public void Navigate()
    {
        driver.get(URL);
    }


    /****************************************************************************************************
     *                                                                                                  *
     *   Method Name : Login()                                                                          *
     *   Inputs      : String User name                                                                 *
     *               : String Password                                                                  *
     *   Outputs     : void                                                                             *
     *   Description : This Method is to Enter valid login credentials and login successfully           *
     *                                                                                                  *
     ****************************************************************************************************/
    public void Login(String Uname, String Password)
    {
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(SigninBtn).click();
        driver.findElement(UserName).sendKeys(Uname);
        driver.findElement(UserPass).sendKeys(Password);
        driver.findElement(LoginBtn).click();
    }


    /****************************************************************************************************
     *                                                                                                  *
     *   Method Name : LaunchingBDWebsite()                                                             *
     *   Inputs      : String User name                                                                 *
     *               : String Password                                                                  *
     *   Outputs     : void                                                                             *
     *   Description : This Method is to Direct launch to the BD website and successfully login         *
     *                                                                                                  *
     ****************************************************************************************************/

    public void LaunchingBDWebsite(String Uname, String Password)
    {
        driver.get(URL);
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(SigninBtn).click();
        driver.findElement(UserName).sendKeys(Uname);
        driver.findElement(UserPass).sendKeys(Password);
        driver.findElement(LoginBtn).click();
    }


    /****************************************************************************************************
     *                                                                                                  *
     *   Method Name : ValidateLaunchingPageSucessfully()                                               *
     *   Inputs      : void                                                                             *
     *   Outputs     : void                                                                             *
     *   Description : This Method is to Validate successful Navigation to BD website                   *
     *                                                                                                  *
     ****************************************************************************************************/

    public void ValidateLaunchingPageSucessfully()
    {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(LaunchingValidation));
        Assert.assertTrue(driver.findElement(LaunchingValidation).isDisplayed());;
    }


    /****************************************************************************************************
     *                                                                                                  *
     *   Method Name : ValidateLoginPageNavigation()                                                    *
     *   Inputs      : void                                                                             *
     *   Outputs     : void                                                                             *
     *   Description : This Method is to Validate successful Login to BD website                        *
     *                                                                                                  *
     ****************************************************************************************************/

    public void ValidateLoginPageNavigation()
    {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginNavigation));
        Assert.assertTrue(driver.findElement(loginNavigation).isDisplayed());
    }	

}
