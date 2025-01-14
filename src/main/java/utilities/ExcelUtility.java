package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	private static FileInputStream fis;
	private static XSSFWorkbook wb;
	private static XSSFSheet sheet;
	private static Row row;
	private static Cell cell;
	private static String path;
	private static String sheetName;
	
	public ExcelUtility (String path, String sheetName)
	{
		this.path=path;
		this.sheetName=sheetName;
	}
	
	public int getRowCount() throws IOException {
		fis = new FileInputStream(path);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(sheetName);
		
		return sheet.getPhysicalNumberOfRows();
		
	}
	public int getColCount() throws IOException {
		fis = new FileInputStream(path);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(sheetName);
		row = sheet.getRow(0);
		
		return row.getPhysicalNumberOfCells();
		
	}
	
	public static String getCellData(int rowIndex, int colIndex) throws IOException {
		fis = new FileInputStream(path);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(sheetName);
		row = sheet.getRow(rowIndex);
		//System.out.println("from row " + rowIndex + " returning " +row.getCell(colIndex).getStringCellValue());
		return row.getCell(colIndex).getStringCellValue();
	}

}
