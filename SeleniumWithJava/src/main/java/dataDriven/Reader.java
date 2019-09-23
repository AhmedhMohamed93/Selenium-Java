package dataDriven;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Reader 
{
	//Delcare new instance from XSSFSheet to deal with sheets in excel
static XSSFSheet sh;
	//Delcare new instance from XSSFWorkbook to deal with wxcel workbook
static XSSFWorkbook wb;
	//Declare Array of strings to store configuration from excel sheet 
static String [] configuration;
static String [] Data;
static String [] Credentials;


	public void readData() throws Exception {
		//Create new instance from File class to store file path
		File src = new File (".\\TestData\\TestData1.xlsx");
		//Create new instance from FileInputStream to read from file
		FileInputStream fis = new FileInputStream(src);
		
		//initialize workbook instance wb with the file stream instance
		wb = new XSSFWorkbook(fis);
		//Initialize sheet object with the 1st sheet from the workbook object 
		 sh = wb.getSheetAt(0);
		 // Set array size = 13
		configuration = new String [7];
		Data = new String [8] ;
		Credentials = new String [2];
		
		//Crate new instance from DataFormatted to deal with different types of excel cells
		DataFormatter formatter = new DataFormatter();

		//Loop on configuration array
		for(int i = 0; i<configuration.length;i++)
		{
			//Fill objects in array with configuration from excel sheet
			configuration[i] = formatter.formatCellValue(sh.getRow(4).getCell(i));	
		}
		
		for (int j =0; j<Data.length ; j++)
		{
			//Fill objects in array with configuration from excel sheet
			Data[j] = formatter.formatCellValue(sh.getRow(7).getCell(j));
		}
		for (int p = 0; p<Credentials.length;p++)
		{
			Credentials[p] = formatter.formatCellValue(sh.getRow(p).getCell(1));
		}
		
	}
	
	// Functions to pass the configuration from excel sheet when called.

		
	public String getChromeProperty()
	{
		return configuration[0];		
	}
	
	public String getChromeDriver()
	{
		return configuration[1];	
	}

	public String getExplorerProperty()
	{
		return configuration[2];
	}
	
	public String getExplorerDriver()
	{
		return configuration[3];
	}
	//
	public String getFirefoxProperty()
	{
		return configuration[5];
	}
	
	public String getFirefoxDriver()
	{
		return configuration[6];
	}
	//
	public String getError()
	{
		return configuration[4];
	}
	
	// Functions to pass the Data from excel sheet when called.
	public String getUserName()
    {
        return Credentials[0];
    }

    public String getUserPassword()
    {
    	return Credentials[1];
    }

    public String getIDNName()
    {
    	return Data[0];
    }

    public String getiDNID()
    {
    	return Data[1];
    }

    public String getFacilityName()
    {
    	return Data[2];
    }

    public String getFacilityID()
    {
    	return Data[3];
    }

    public String getPharmacyFormularyName()
    {
    	return Data[4];
    }

    public String getPharmacyFormularyID()
    {
    	return Data[5];
    }

    public String getPFvendor()
    {
    	return Data[6];
    }

    public String getAlignmentProjectName()
    {
    	return Data[7];
    }
	
	
}



