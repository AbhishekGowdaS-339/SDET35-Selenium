package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel3_read_Test {
	
	// Write a program to find the specific data from 1st column, if data is available then read and display the next cell data??
	public static void main(String[] args) throws Throwable {
		
		String path = "./data/testcasespecificdata.xlsx";
		FileInputStream fin = new FileInputStream(path);
		Workbook workbook = new WorkbookFactory().create(fin);
		
		String findData = "admin 8";
		
		int n = workbook.getSheet("Sheet2").getLastRowNum();
		for (int i=0; i<n; i++) {
			String colCellValue = workbook.getSheet("Sheet2").getRow(i).getCell(0).getStringCellValue();
			//System.out.println(colCellValue);
			
			if (colCellValue.equals(findData))
			{
				String nextCellValue = workbook.getSheet("Sheet2").getRow(i+1).getCell(1).getStringCellValue();
				System.out.println("Next Cell Value: "+nextCellValue);
				break;
			}
			
		}
	}

}
