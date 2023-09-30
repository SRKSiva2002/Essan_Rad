package com.Essan_Rad.GenericUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists methods to handle excel sheets
 * @author Sivabalan Selvaraj
 *
 */
public class ExcelUtitlity {

	/**
	 * This method is used to fetch the data from excel sheet
	 * @param sheet
	 * @param rowNum
	 * @param colNum
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromExcelFile(String sheet, int rowNum, int colNum) throws Throwable {
		FileInputStream fis = new FileInputStream(PathConstant.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		 Sheet sh = wb.getSheet(sheet);
		Row row = sh.getRow(rowNum);
		Cell col = row.getCell(colNum);
		String value = col.getStringCellValue();
		return value;
	}
	/**
	 * This method is used to read the multiple data from excel file
	 * @param sheet
	 * @param keyCol
	 * @param valCol
	 * @param driver
	 * @param lib
	 * @return
	 * @throws Throwable
	 */
	public HashMap<String, String> readMultipleDataFromExcel(String sheet, int keyCol, int valCol) throws Throwable {
		//fetching data from excel
		FileInputStream fis = new FileInputStream(PathConstant.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheet);
		int count = sh.getLastRowNum();
		
		HashMap<String, String> map = new HashMap<String, String>();//empty map
		
		for (int i = 1; i <= count; i++) {
			String key = sh.getRow(i).getCell(keyCol).getStringCellValue();
			String value = sh.getRow(i).getCell(valCol).getStringCellValue();
			map.put(key, value);
		}
		return map;
	}
	/**
	 * This method is used to write data into excel sheet
	 * @param sheet
	 * @param rowNum
	 * @param colNum
	 * @param value
	 * @throws Throwable
	 */
	public void writeDataIntoExcelFile(String sheet, int rowNum, int colNum, String value) throws Throwable {
		FileInputStream fis = new FileInputStream(PathConstant.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		 Sheet sh = wb.getSheet(sheet);
		Row row = sh.createRow(rowNum);
		Cell col = row.createCell(colNum);
		col.setCellValue(value);
		
		FileOutputStream fout = new FileOutputStream(PathConstant.ExcelFilePath);
		wb.write(fout);
		wb.close();
	}
	/**
	 * This method is used to get the last row number of particular sheet
	 * @param sheet
	 * @return
	 * @throws Throwable
	 */
	public int getLastRowNumber(String sheet) throws Throwable {
		FileInputStream fis= new FileInputStream(PathConstant.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		int row = sh.getLastRowNum();
		return row;
	}
	/**
	 * This method is used to get the last cell number of particular sheet
	 * @param sheet
	 * @return
	 * @throws Throwable
	 */
	public int getLastCellNumber(String sheet) throws Throwable {
		FileInputStream fis= new FileInputStream(PathConstant.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		Row row = sh.getRow(0);
		int col = row.getLastCellNum();
		return col;
	}
	
	public Object[][] readMultipleDataForDataProvider(String sheetName) throws Throwable {
		FileInputStream fis = new FileInputStream(PathConstant.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int lastRow = sh.getLastRowNum()+1;
		int lastCell = sh.getRow(0).getLastCellNum();
		
		Object [][]obj= new Object [lastRow][lastCell];
		
		for (int i = 0; i < lastRow; i++) {
			for (int j = 0; j < lastCell; j++) {
				obj [i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
	}
}
