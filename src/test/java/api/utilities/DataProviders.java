package api.utilities;

import java.io.File;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	File currDir = new File(".");
	String path = currDir.getAbsolutePath();
	String fileLocation = path.substring(0, path.length() - 1) + "testData\\mytestdata.xlsx";

	
	
	//String path = System.getProperty("C:\\Users\\Dell\\eclipse-workspace\\myRestAssure\\testData\\mytestdata.xlsx");
	
	
	@DataProvider(name = "Data")
	public String[][] getAlldata() throws Exception {
		/*
		 * System.out.println("TTTTTTT"+System.getProperty("user.dir")); String path =
		 * System.getProperty("user.dir" + "\\testData\\mytestdata.xlsx");
		 * System.out.println("=============Path"+path);
		 */
		System.out.println("KKKKKKKKKK"+fileLocation);
		XLUtilites xl = new XLUtilites(fileLocation);
		int rowvCount = xl.getRowCount("userdata");
		System.out.println("rowvCount "+rowvCount);

		int colCount = xl.getCellCount("userdata", 1);
		System.out.println("colCount "+colCount);
		String apidata[][] = new String[rowvCount][colCount];

		for (int i = 1; i <=rowvCount; i++) {

			for (int j = 0; j < colCount; j++) {
				apidata[i - 1][j] = xl.getCellvalue("userdata", i, j);
				System.out.println(apidata[i - 1][j]);

			}

		}
		return apidata;
	}

	@DataProvider(name = "Userdata")
	public String[] getUserName() throws Exception {

		XLUtilites xl = new XLUtilites(path);
		int rowvCount = xl.getRowCount("userdata");

		String apidata[] = new String[rowvCount];
		for (int i = 0; i <= rowvCount; i++) {

			apidata[i - 1] = xl.getCellvalue("userdata", i, 1);

		}
		return apidata;
	}

}
