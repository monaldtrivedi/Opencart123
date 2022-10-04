package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	//DataProvider 1
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path=".\\testData\\Opencart_LoginData.xlsx";	//taking xl file from testData
		
		ExcelUtility xlutil=new ExcelUtility(path);	//creating an object for XLUtility
		
		int totalrows=xlutil.getRowCount("Sheet1");
		System.out.println("Total Rows: " + totalrows);
		int totalcols=xlutil.getCellCount("Sheet1", 1);
		System.out.println("Total Cols: " + totalcols);
		
		String logindata[][]=new String[totalrows][totalcols];	//created for 2 dimension array which can store the data user and password
		
	/*	for(int i=0;i<totalrows;i++)	//1		//read the data from xl string in 2 dimension array
		{
			for(int j=0;j<totalcols;j++)	//0		i is rows and j is cols	
			{
				logindata[i][j]=xlutil.getCellData("Sheet1", i+1, j);  	//1,0
				System.out.println(logindata[i][j]);
			}
		} */
		
		
		for(int i=1;i<=totalrows;i++)	//1		//read the data from xl string in 2 dimension array
		{
			for(int j=0;j<totalcols;j++)	//0		i is rows and j is cols	
			{
				logindata[i-1][j]=xlutil.getCellData("Sheet1", i, j);  	//1,0
				System.out.println(logindata[i-1][j]);
			}
		} 
		
		
	return logindata;	//returning 2 dimension array
		
	}
	
	//DataProvider 2
	
	//DataProvider 3
	
	//DataProvider 4
	
}
