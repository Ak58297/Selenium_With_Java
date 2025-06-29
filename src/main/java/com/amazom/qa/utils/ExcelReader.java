package com.amazom.qa.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelReader {
	
	
	
	public static Object[][] getDataFromExcel() throws IOException 
	{
		DataFormatter format=new DataFormatter();	
		
	FileInputStream fis=new FileInputStream("D:\\WORK\\TestData\\TestDataQA.xlsx");
	XSSFWorkbook workbook=new XSSFWorkbook(fis);
	XSSFSheet sheet=workbook.getSheetAt(0);
	
	int rowCount=sheet.getPhysicalNumberOfRows();
	XSSFRow rowfirst=sheet.getRow(0);
	int coloumnCount=rowfirst.getLastCellNum();
	
	Object data[][]=new Object[rowCount-1][coloumnCount];
	
	for(int i=0;i<rowCount-1;i++)
	{
		rowfirst=sheet.getRow(i+1);
		for(int j=0;j<coloumnCount;j++)
		{
			XSSFCell cell=rowfirst.getCell(j);			
			data[i][j]=format.formatCellValue(cell);
		}
	}
	return data ;
	
	}

}
