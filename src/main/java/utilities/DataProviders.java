package utilities;
import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "dp1")
	public Object[][] dataProvider1() throws IOException{
		String path = "src\\test\\resources\\testdata\\data.xlsx";
		String sheetName = "Sheet2";
		ExcelUtility eu= new ExcelUtility(path,sheetName);
		int rowCount = eu.getRowCount();		
		int colCount = eu.getColCount();
		//System.out.println(rowCount+" "+colCount);
		Object[][] data = new Object[rowCount-1][colCount];
		
		for(int i= 1; i<rowCount; i++) {
			for(int j= 0; j<colCount; j++) {
				data[i-1][j]=ExcelUtility.getCellData(i,j);
			}
		}
		return data;
		
	}
}
