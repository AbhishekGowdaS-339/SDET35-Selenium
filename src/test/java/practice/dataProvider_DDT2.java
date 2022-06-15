package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_Utilities.Excel_Utility;

public class dataProvider_DDT2 {
	
	@Test(dataProvider="bookTicketsDataProvdier")
	public void bookATicket(String source, String destination, double tickets) {
		System.out.println("source is :: "+source+" Destination is ::"+destination+" Number of tickets is ::"+tickets);
	}
	
	//@DataProvider(name="excel")
	@DataProvider()
	
	public Object[][] bookTicketsDataProvdier() throws Throwable {
		Excel_Utility exl = new Excel_Utility();
		                                      
		Object[][] arr = new Object[3][3];
		
		arr[0][0]= exl.getStringDataFromExcel("Sheet2", 0, 0);
		arr[0][1]= exl.getStringDataFromExcel("Sheet2", 1, 0);
		arr[0][2]= exl.getNumDataFromExcel("Sheet2", 2, 0);
		
		arr[1][0]= exl.getStringDataFromExcel("Sheet2", 0, 1);
		arr[1][1]= exl.getStringDataFromExcel("Sheet2", 1, 1);
		arr[1][2]= exl.getNumDataFromExcel("Sheet2", 2, 1);
		
		arr[2][0]= exl.getStringDataFromExcel("Sheet2", 0, 2);
		arr[2][1]= exl.getStringDataFromExcel("Sheet2", 1, 2);
		arr[2][2]= exl.getNumDataFromExcel("Sheet2", 2, 2);
		
		return arr;
	}

}
