package validationPackage;

import utilities.TestBase;

public class Validations extends TestBase 
{
	
    /****************************************************************************************************
     *                                                                                                  *
     *                                           Variables                                              *
     *                                                                                                  *
     ****************************************************************************************************/
	
              /*************************************************************************************
               *                 BD_ValidateLaunchWebsite() Test Log Strings                       *
               *************************************************************************************/
				private String LaunchScreenshot = "Launching successfully the BD Website";
				private String launchStart = "Validation Of Launching BD Website";
				private String Navigation = "System Navigating now";
				private String LaunchStatus = "System Navigated successfully";
				private String screenshot = "ScreenShot Taken";
	
	
		     /*************************************************************************************
		      *                 BD_LoginSuccessfully() Test Log Strings                           *
		      *************************************************************************************/
				private String LoginScreenshot = "Login successfully to BD Website";
			    private String loginStart = "Validation Of Login successfully to BD Website";
			    private String Logging = "System is Logging in now";
			    private String loginstatus = "System logged in successfully";
				  
			 /*************************************************************************************
			  *             BD_ValidateCreationOfNewHealthSystem() Test Log Strings               *
		      *************************************************************************************/  
			    private String IDNScreenshot = "IDN Created successfully";
			    private String CreateIDNStart = "Validation Of Create New HealthSystem";
			    private String Launching = "System is navigated to BD website and logged in successfully";
			    private String IDNNavigation = "System is navigated Health Systems Page";
			    private String successfulCreationOfIDN = "New IDN is created successfully";
			    private String CreationStatus = "New IDN is impersonated successfully";
    
			 /*************************************************************************************
			  *             BD_ValidateCreationOfNewFacility() Test Log Strings               *
			  *************************************************************************************/    
			    private String FacilityScreenshot = "New Facility Created successfully";
			    private String CreateFacilityStart = "Validation Of Create New Facility";
			    private String facilityNavigation = "System is navigated to Regions and Facilities successfully";
			    private String facilitycreationStatus = "New Facility is created successfully";
			    private String Impersonate = "The created IDN is impersonated successfully";
			    
			 /*************************************************************************************
			  *             BD_ValidateCreationOfNewPharmacyFormualry() Test Log Strings          *
			  *************************************************************************************/  
			    private String PharmacyScreenshot = "New PF Created successfully";
			    private String CreatePharmacyStart = "Validation Of Create New Pharmacy Formulary";
			    private String pharmacyNavigation = "System is navigated to Pharmacy Formularies Page successfully";
			    private String pharmacycreationStatus = "New Pharmacy Formualry is created successfully";
			    
		     /*************************************************************************************
			  *              BD_ValidateCreationOfNewAlignmentProject() Test Log Strings          *
			  *************************************************************************************/
			    private String AlignmentScreenshot = "New AlignmentProject Created successfully";
			    private String CreateProjectStart = "Validation Of Create New Alignment Project";
			    private String AlignmentNavigation = "System is navigated to Alignment Projects Page successfully";
			    private String AlignmentcreationStatus = "New Alignment Project is created successfully";

			 /*************************************************************************************
			  *            BD_ValidateCreationOfNewAlignmentProjectDB() Test Log Strings          *
			  *************************************************************************************/
                private String DBvalidationStart = "Validation of Existance of the Created Alignment Project in the DB";
			    private String DBConnect = "Initiate the Connection to SQL Server";
			    private String connecting = "Connecting to SQL Server ... ";
			    private String connectComplete = "Done.";
			    private String ReadData = "Reading data from table";
			    private String closeDB = "All done.";
			    
		/****************************************************************************************************
		 *                                                                                                  *
		 *                                           Methods                                                *
		 *                                                                                                  *
		 ****************************************************************************************************/	
			    
             /******************************************************************************************
              *                BD_ValidateLaunchWebsite() Test Logs getters                            *
              ******************************************************************************************/

				    public String getlaunchStart()
				    {
				        return launchStart;
				    }
				
				    public String getnavigationString()
				    {
				        return Navigation;
				    }
				
				    public String getlaunchStatus()
				    {
				        return LaunchStatus;
				    }

				    public String getLaunchscreenshotName()
				    {
				        return LaunchScreenshot;
				    }
				    
				    
				    public String getconfirmScreenshot()
				    {
				        return screenshot;
				    }

	          /******************************************************************************************
	           *                BD_LoginSuccessfully() Test Logs getters                                *
	           ******************************************************************************************/

				    public String getloginStart()
				    {
				        return loginStart;
				    }
				
				    public String getlogging()
				    {
				        return Logging;
				    }
				
				    public String getloginStatus()
				    {
				        return loginstatus;
				    }

				    public String getLoginscreenshotName()
				    {
				        return LoginScreenshot;
				    }
				    
			  /******************************************************************************************
			   *                BD_CreateNewIDN() Test Logs getters                                     *
			   ******************************************************************************************/

				    public String getCreateIDNStart()
				    {
				        return CreateIDNStart;
				    }
				
				    public String getLaunching()
				    {
				        return Launching;
				    }
				
				    public String getIDNNavigation()
				    {
				        return IDNNavigation;
				    }
				
				    public String getsuccessfulCreationOfIDN()
				    {
				        return successfulCreationOfIDN;
				    }
				
				    public String getCreationStatus()
				    {
				        return CreationStatus;
				    }
				    
				    public String getIDNscreenshotName()
				    {
				        return IDNScreenshot;
				    }
				    
			  /******************************************************************************************
			   *                    BD_ValidateCreationOfNewFacility() Test Logs getters                *
			   ******************************************************************************************/
				    
				    public String getCreateFacilityStart()
				    {
				        return CreateFacilityStart;
				    }
				
				    public String getImpersonate()
				    {
				        return Impersonate;
				    }
				
				    public String getfacilityNavigation()
				    {
				        return facilityNavigation;
				    }
				
				    public String getfacilitycreationStatus()
				    {
				        return facilitycreationStatus;
				    }

				    public String getFacilityscreenshotName()
				    {
				        return FacilityScreenshot;
				    }

			  /******************************************************************************************
			   *                 BD_ValidateCreationOfNewPharmacyFormualry() Test Logs getters          *
			   ******************************************************************************************/

				    public String getCreatePharmacyStart()
				    {
				        return CreatePharmacyStart;
				    }
				
				    public String getpharmacycreationStatus()
				    {
				        return pharmacycreationStatus;
				    }
				
				    public String getpharmacyNavigation()
				    {
				        return pharmacyNavigation;
				    }
				    
				    public String getPFscreenshotName()
				    {
				        return PharmacyScreenshot;
				    }

 
				/******************************************************************************************
				 *                 BD_ValidateCreationOfNewAlignmentProject() Test Logs getters           *
				 ******************************************************************************************/

				    public String getCreateProjectStart()
				    {
				        return CreateProjectStart;
				    }
				
				    public String getAlignmentcreationStatus()
				    {
				        return AlignmentcreationStatus;
				    }
				
				    public String getAlignmentNavigation()
				    {
				        return AlignmentNavigation;
				    }	
				    
				    public String getAlignmentscreenshotName()
				    {
				        return AlignmentScreenshot;
				    }
				    
				/******************************************************************************************
				 *               BD_ValidateCreationOfNewAlignmentProjectDB() Test Logs getters           *
				 ******************************************************************************************/
				    
                    public String GetStartDBValidation()
                    {
                        return DBvalidationStart ;
                    }
                    
				    public String getconnectDB()
				    {
				        return DBConnect;
				    }
				    
				    public String getconnecting()
				    {
				        return connecting;
				    }
				    
				    public String getConnectDone()
				    {
				        return connectComplete;
				    }
				    
				    public String getReadData()
				    {
				        return ReadData;
				    }
				    
				    public String getCloseDataBase()
				    {
				        return closeDB;
				    }
}

