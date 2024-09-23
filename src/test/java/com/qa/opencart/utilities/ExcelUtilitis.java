package com.qa.opencart.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilitis {

	FileInputStream fis;
	FileOutputStream fos;
	XSSFWorkbook workBook;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	XSSFCellStyle cellStyle;
	String path;

	public ExcelUtilitis(String pathName) {
		this.path = pathName;
	}

	public int getRowCount(String sheetName) throws IOException {
		fis = new FileInputStream(path);
		workBook = new XSSFWorkbook(fis);
		sheet = workBook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		workBook.close();
		fis.close();
		return rowCount;
	}

	public int getCellCount(String sheetName, int rowNum) throws IOException {
		fis = new FileInputStream(path);
		workBook = new XSSFWorkbook(fis);
		sheet = workBook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		int cellCount = row.getLastCellNum();
		workBook.close();
		fis.close();
		return cellCount;
	}

	public String getCellData(String sheetName, int rowNum, int cellNum) throws IOException {
		fis = new FileInputStream(path);
		workBook = new XSSFWorkbook(fis);
		sheet = workBook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.getCell(cellNum);
		DataFormatter formatter = new DataFormatter();
		String data;
		try {
			data = formatter.formatCellValue(cell);
		} catch (Exception e) {
			data = "";
		}
		workBook.close();
		fis.close();
		return data;
	}

	public void setCellData(String sheetName, int rownum, int colnum, String data) throws IOException {
		File xlfile = new File(path);
		if (!xlfile.exists()) // If file not exists then create new file
		{
			workBook = new XSSFWorkbook();
			fos = new FileOutputStream(path);
			workBook.write(fos);
		}

		fis = new FileInputStream(path);
		workBook = new XSSFWorkbook(fis);

		if (workBook.getSheetIndex(sheetName) == -1) // If sheet not exists then create new Sheet
			workBook.createSheet(sheetName);
		sheet = workBook.getSheet(sheetName);

		if (sheet.getRow(rownum) == null) // If row not exists then create new Row
			sheet.createRow(rownum);
		row = sheet.getRow(rownum);

		cell = row.createCell(colnum);
		cell.setCellValue(data);
		fos = new FileOutputStream(path);
		workBook.write(fos);
		workBook.close();
		fis.close();
		fos.close();
	}

	public void fillGreenColor(String sheetName, int rownum, int colnum) throws IOException {
		fis = new FileInputStream(path);
		workBook = new XSSFWorkbook(fis);
		sheet = workBook.getSheet(sheetName);

		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);

		cellStyle = workBook.createCellStyle();

		cellStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		cell.setCellStyle(cellStyle);
		workBook.write(fos);
		workBook.close();
		fis.close();
		fos.close();
	}

	public void fillRedColor(String sheetName, int rownum, int colnum) throws IOException {
		fis = new FileInputStream(path);
		workBook = new XSSFWorkbook(fis);
		sheet = workBook.getSheet(sheetName);
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);

		cellStyle = workBook.createCellStyle();

		cellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
		cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		cell.setCellStyle(cellStyle);
		workBook.write(fos);
		workBook.close();
		fis.close();
		fos.close();
	}

}
