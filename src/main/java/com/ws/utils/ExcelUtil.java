package com.ws.utils;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	XSSFWorkbook wb;
	public ExcelUtil(String excelPath)
	{
		try 
		{
			File file = new File(excelPath);
			FileInputStream fis = new FileInputStream(file);
			wb = new XSSFWorkbook(fis);
		}
		catch(Exception e)
		{
			System.out.println("Unable to load the file!");
			e.printStackTrace();
		}
	}
	
	public int getRowCount(int sheetNo)
	{
		 return wb.getSheetAt(sheetNo).getLastRowNum()+1;
	}

	public String getCellData(int sheetnum, int row,int cell)
	{
		 return wb.getSheetAt(sheetnum).getRow(row).getCell(cell).toString();
	}
}











