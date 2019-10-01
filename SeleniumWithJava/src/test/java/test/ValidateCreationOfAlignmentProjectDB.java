package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import utilities.TestBase;
import validationPackage.Validations;

public class ValidateCreationOfAlignmentProjectDB extends TestBase 
{
    /****************************************************************************************************
     *                               Declaration of classes Objects                                     *
     ****************************************************************************************************/
    Validations validStrings = new Validations();	
    
    
    /****************************************************************************************************
     *                                                                                                  *
     *   Test Method Name : BD_ValidateCreationOfNewAlignmentProjectDB()                                *
     *   Inputs           : String PName                                                             	*
     *   Objective        : This Test validates creation of New Alignment PRoject within the            *
     *                    : created Health System in the BackEnd [DataBase]                             *
     *                                                                                                  *
     * @throws Throwable 																				*
     ****************************************************************************************************/
    @Test 
    @Parameters("ProjectName")
    public void BD_ValidateCreationOfNewAlignmentProjectDB(String PName) throws Throwable
    {
        logger = extent.startTest(validStrings.GetStartDBValidation());
        logger = extent.startTest(validStrings.getconnectDB());
        
        try 
        {
        	logger.log(LogStatus.INFO,validStrings.getconnecting());
            try (Connection connection = DriverManager.getConnection(connectionUrl)) 
            {
            	logger.log(LogStatus.INFO,validStrings.getConnectDone());
            	logger.log(LogStatus.INFO,validStrings.getReadData());
            	String sql = "declare @name as nvarchar(255)\r\n" + 
            			"set @name = 'Project3333'\r\n" + 
            			"\r\n" + 
            			"SELECT *\r\n" + 
            			"  FROM [EF].[SmartPumpAlignmentProject]\r\n" + 
            			"  where ProjectName = @name";
                try (Statement statement = connection.createStatement();
                        ResultSet resultSet = statement.executeQuery(sql)) 
                {
                    while (resultSet.next()) 
                    {
                        System.out.println(resultSet.getString(2));
                        Assert.assertEquals(resultSet.getString(2),PName);
                    }
                }
                connection.close();
                logger.log(LogStatus.INFO,validStrings.getCloseDataBase());
            }
        } catch (Exception e) 
        {
            System.out.println();
            e.printStackTrace();
        }

    }    
}
