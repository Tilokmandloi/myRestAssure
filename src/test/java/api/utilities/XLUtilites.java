package api.utilities;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtilites {

	public FileInputStream fis;
	public XSSFWorkbook wb;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;

	String path;// "C:\\Users\\Dell\\eclipse-workspace\\myRestAssure\\testData\\mytestdata.xlsx"

	public XLUtilites(String path) {
		this.path = path;
	}

	public int getRowCount(String sheetName) throws Exception
	{
		System.out.println("path "+path);
		fis= new FileInputStream(path);
		wb=	 new XSSFWorkbook(fis);  
		sheet = wb.getSheet(sheetName);
	    int rowcount = sheet.getLastRowNum();
		wb.close();
		fis.close();
		return rowcount;
	}

	public int getCellCount(String sheetName, int rowcount) throws Exception
	{		System.out.println("path "+path);
		fis = new FileInputStream(path);
		wb =	 new XSSFWorkbook(fis);  
		sheet = wb.getSheet(sheetName);
		row = sheet.getRow(rowcount);
	int CellCount=	row.getLastCellNum();
		wb.close();
		fis.close();
		return CellCount;
	}

	public String getCellvalue(String sheetName, int rowcount ,int columcount) throws Exception
	{
		fis= new FileInputStream(path);
		wb=	 new XSSFWorkbook(fis);  
		sheet = wb.getSheet(sheetName);
		row = sheet.getRow(rowcount);
		cell = row.getCell(columcount);
		DataFormatter df = new DataFormatter();
		String data;
		try {
			data = df.formatCellValue(cell);
			
		} catch (Exception e) {
			data="";
		}
		
		wb.close();
		fis.close();
		return data;
	}



	
}
