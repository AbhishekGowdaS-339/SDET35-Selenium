package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Assert_Hard {
	
	@Test()
	public void Tester1() {
		
		System.out.println("Hii this script is going to fail by printing this statement");
		Assert.fail();
	
	}
	
	@Test()
	public void Tester2() {
		
		System.out.println("Hii this script is going to Pass");
		System.out.println("By printing this statement that is proved");
	
	}

}
