package com.qa.opencart.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	ExcelUtilitis utils;

	@DataProvider(name="LoginData")
	public String[][] getLoginData() throws IOException {
		utils = new ExcelUtilitis(System.getProperty("user.dir") + "\\testData\\Opencart_LoginData.xlsx");
		
		int totalRows = utils.getRowCount("Sheet1");
		int totalCells = utils.getCellCount("Sheet1", 1);
		String loginData[][] =new String[totalRows][totalCells];
		for(int i=1;i<=totalRows;i++)  //1   //read the data from xl storing in two deminsional array
		{		
			for(int j=0;j<totalCells;j++)  //0    i is rows j is col
			{
				loginData[i-1][j]= utils.getCellData("Sheet1",i, j);  //1,0
			}
		}
		return loginData;
	}

}
