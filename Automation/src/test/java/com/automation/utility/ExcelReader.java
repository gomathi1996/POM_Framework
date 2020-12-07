package com.automation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	XSSFWorkbook wb;

	public ExcelReader() {
		File src = new File("./Excel/Testdata.xlsx");
		try {
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		} catch (IOException e) {
			System.out.println("Not able to find the values " + e.getMessage());
		}

	}

	public String getdata(String SheetName, int row, int col) {

		return wb.getSheet(SheetName).getRow(row).getCell(col).getStringCellValue();

	}
}
