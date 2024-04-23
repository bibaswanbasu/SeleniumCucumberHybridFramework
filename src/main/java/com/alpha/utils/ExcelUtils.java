package com.alpha.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	FileInputStream excelFile = null;
	XSSFWorkbook workBook = null;
	XSSFSheet sheet = null;
	XSSFRow headerRow = null;
	XSSFRow row = null;

	int rowCount = 0;
	int colNum = 0;
	String cellValue = null;

	List<String> columnData = new ArrayList<>();

	private static final String FILE_NAME = new File(System.getProperty("user.dir"))
			+ "/TestData/E2E_Automation_TestData.xlsx";

	public ExcelUtils(String filePath) {

		try {
			excelFile = new FileInputStream(filePath);
			workBook = new XSSFWorkbook(excelFile);

			excelFile.close();
//			workBook.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Gets All the Column value based on the User Input Sheet Name and column name
	 *
	 * @return The list of the column value of the sheet
	 */
	public List<String> readExcelData(String SheetName, String columnName) {

		sheet = workBook.getSheet(SheetName);
		headerRow = sheet.getRow(0);
		rowCount = sheet.getPhysicalNumberOfRows();

		System.out.println("TOTAL NULBER OF ROW >> " + rowCount);

		for (int r = 1; r < rowCount; r++) {
			row = sheet.getRow(r);
			for (int c = 0; c < row.getLastCellNum(); c++) {
//				System.out.println(headerRow.getCell(c).getStringCellValue().trim());
				if (headerRow.getCell(c).getStringCellValue().trim().equalsIgnoreCase(columnName)) {
					colNum = c;
					break;
				}
			}
			cellValue = row.getCell(colNum).getStringCellValue();
			System.out.println(headerRow.getCell(colNum).getStringCellValue() + " : " + cellValue);

			columnData.add(cellValue);
		}
		return columnData;

	}

	public static String[] readTestData(String environment) throws Exception {

		String[] credentials = new String[2];

		FileInputStream excelFile = new FileInputStream(FILE_NAME);
		XSSFWorkbook workBook = new XSSFWorkbook(excelFile);

		Sheet sheet = workBook.getSheet(FILE_NAME);
//		Row row = sheet.getRow(rowNumber);

		for (int rowNum = 0; rowNum <= sheet.getLastRowNum(); rowNum++) {
			Row row = sheet.getRow(rowNum);
			if (row != null && row.getCell(0) != null
					&& row.getCell(0).getStringCellValue().equalsIgnoreCase(environment)) {
				credentials[0] = row.getCell(rowNum).getStringCellValue();
				credentials[1] = row.getCell(rowNum).getStringCellValue();
				break; // Exit the loop once credentials are found
			}

//		for (int i = 0; i < row.getLastCellNum(); i++) {
//
//			Cell cell = row.getCell(i);
//			
//			String key = cell.getStringCellValue();
////			System.out.println(key);
//			String value = cell.getStringCellValue();
////			System.out.println(value);
//		}
//
//		workBook.close();
//		excelFile.close();

			return credentials;
		}
		return credentials;

	}

	public static void main(String[] args) throws Exception {
		ExcelUtils excel = new ExcelUtils(FILE_NAME);
		excel.readExcelData("Sheet1", "Gender");

	}

}
