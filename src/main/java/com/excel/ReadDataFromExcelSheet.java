package com.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcelSheet {

	public String[][] getExcelData(String excellocation , String sheetName){
		try{
			String dataSets[][] = null;
			FileInputStream file = new FileInputStream(new File(excellocation));
			
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			int totalRow = sheet.getLastRowNum();			
			int totalColumn = sheet.getRow(0).getLastCellNum();
			dataSets = new String[totalRow][totalColumn];
			
			Iterator<Row> rowIterator = sheet.iterator();
			int i=0;
			
			while(rowIterator.hasNext() ){
				i=i++;
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				int j=0;
				
				while(cellIterator.hasNext()){
					
					Cell cell= cellIterator.next();
					if(cell.getStringCellValue().contains("selectLanguage") ){
						break;
					}
					switch(cell.getCellType()){
					case Cell.CELL_TYPE_NUMERIC:
						dataSets[i][j++] = cell.getStringCellValue();
						System.out.println(cell.getNumericCellValue());
						break;
					case Cell.CELL_TYPE_STRING:
						dataSets[i][j++] = cell.getStringCellValue();
						System.out.println(cell.getStringCellValue());
						break;
					case Cell.CELL_TYPE_BOOLEAN:
						dataSets[i][j++] = cell.getStringCellValue();
						System.out.println(cell.getStringCellValue());
						break;
					case Cell.CELL_TYPE_FORMULA:
						dataSets[i][j++] = cell.getStringCellValue();
						System.out.println(cell.getStringCellValue());
						break;
					}
					
				}
				System.out.println("");
			}
			file.close();
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static void main(String[] args) {
		String excellocation = "C:\\Users\\samrat\\workspace\\nytt\\compilers.xlsx";
		String sheetName = "compilers";
		ReadDataFromExcelSheet excel = new ReadDataFromExcelSheet();
		String[][] data = excel.getExcelData(excellocation, sheetName);
		System.out.println(data);
	}
}
