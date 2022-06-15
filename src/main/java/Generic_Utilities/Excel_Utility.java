package Generic_Utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

	/*
	 * It Contains External Files Specific Libraries 
	 * @author Abhishek Gowda 
	 */

public class Excel_Utility {
	
	/*
	 * This Method is used to get the Value from Excel sheet in String form
	 * @param SheetName
	 * @param rowNum
	 * @param CelNum
	 * @return String 
	 */
	
	public String getStringDataFromExcel(String SheetName, int rowNum, int CelNum) throws Throwable {
		
		String path = "./data/testcasespecificdata1.xlsx";
		FileInputStream fin = new FileInputStream(path);
		Workbook workbook = WorkbookFactory.create(fin);
		String stringCellValue =workbook.getSheet(SheetName).getRow(rowNum).getCell(CelNum).getStringCellValue();
		return stringCellValue;
	}
	
	/*
	 * This Method is used to get the Value from Excel sheet in String form which includes random number 
	 * @param SheetName
	 * @param rowNum
	 * @param CelNum
	 * @return String 
	 */
	
	public String getStringDataFromExcelAndRandomNum(String SheetName, int rowNum, int CelNum) throws Throwable {
		
		String path = "./data/testcasespecificdata1.xlsx";
		Java_Utility jav = new Java_Utility();
		FileInputStream fin = new FileInputStream(path);
		Workbook workbook = WorkbookFactory.create(fin);
		String stringCellValue =workbook.getSheet(SheetName).getRow(rowNum).getCell(CelNum).getStringCellValue()+jav.getRandomNum();
		return stringCellValue;
	}
		
	/*
	 * This Method is used to get the Value from Excel sheet in numeric form
	 * @param SheetName
	 * @param rowNum
	 * @param CelNum
	 * @return double
	 */
	
	public double getNumDataFromExcel(String SheetName, int rowNum, int CelNum) throws Throwable {
			
		String path = "./data/testcasespecificdata1.xlsx";
		FileInputStream fin = new FileInputStream(path);
		Workbook workbook = WorkbookFactory.create(fin);
		double CellValue = workbook.getSheet(SheetName).getRow(rowNum).getCell(CelNum).getNumericCellValue();
		return CellValue;
	}
	
	
	/*
	 * This Method is used to get the Value from Excel sheet in boolean form
	 * @param SheetName
	 * @param rowNum
	 * @param CelNum
	 * @return boolean
	 */
	
	public boolean getbooleanDataFromExcel(String SheetName, int rowNum, int CelNum) throws Throwable {
		
		String path = "./data/testcasespecificdata1.xlsx";
		FileInputStream fin = new FileInputStream(path);
		Workbook workbook = WorkbookFactory.create(fin);
		boolean stringCellValue = workbook.getSheet(SheetName).getRow(rowNum).getCell(CelNum).getBooleanCellValue();
		return stringCellValue;
	}
}
	