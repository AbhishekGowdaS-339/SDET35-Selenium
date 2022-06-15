package practice;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assert_soft {
	
	@Test()
	public void Tester1() {
		
		SoftAssert sa = new SoftAssert();
		System.out.println("Hii this script is going to pass by printing this statement");
		sa.fail();
		System.out.println("Though this is fail the script is going to pass till we use AssertAll Method");
		System.out.println("=====================================");
		sa.assertAll();
	}
	
	@Test()
	public void Tester2() {
		
		System.out.println("Hii this script is going to Pass");
		System.out.println("By printing this statement that is proved");
	
	}

}
