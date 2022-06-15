package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel2_Row_Test {
	//Write the Program to read the 1st and 2nd Colum data from all the Rows 

	public static void main(String[] args) throws Throwable {
		String path = "./data/testcasespecificdata.xlsx";
		FileInputStream fin = new FileInputStream(path);
		Workbook workbook = new WorkbookFactory().create(fin);
		//int n=10;
		int n = workbook.getSheet("Sheet2").getLastRowNum();
		for(int i=0; i<n; i++) {
		String Col1 = workbook.getSheet("Sheet2").getRow(i).getCell(0).getStringCellValue();
		String Col2 = workbook.getSheet("Sheet2").getRow(i).getCell(1).getStringCellValue();
		
		System.out.println("Col1: "+Col1+":: col2: "+Col2);
		}
	}
		
}
