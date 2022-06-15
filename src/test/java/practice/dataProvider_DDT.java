package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvider_DDT {
	
	@Test(dataProvider="bookTicketsDataProvdier")
	public void bookATicket(String source, String destination, int tickets) {
		System.out.println("source is :: "+source+" Destination is ::"+destination+" Number of tickets is ::"+tickets);
	}
	
	@DataProvider
	public Object[][] bookTicketsDataProvdier() {
		
		Object[][] arr = new Object[3][3];
		arr[0][0]= "Bangalore";
		arr[0][1]= "Mysuru";
		arr[0][2]= 20;
		
		arr[1][0]= "Bangalore";
		arr[1][1]= "goa";
		arr[1][2]= 10;
		
		arr[2][0]= "Bangalore";
		arr[2][1]= "delhi";
		arr[2][2]= 6;
		
		return arr;
		
	}

}
