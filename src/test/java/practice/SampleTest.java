package practice;

import org.testng.annotations.Test;

public class SampleTest {
	
	@Test
	public void createContactTest()
	{
		System.out.println("Contact Created");
		int x =0/1;
		System.out.println(x);
	}
	
	@Test(dependsOnMethods = "createContactTest", invocationCount = 2)
	public void modifyContactTest() {
		System.out.println("Contact Modified");
	}
	
	@Test(dependsOnMethods = "createContactTest")
	public void deleteContactTest() {
		System.out.println("Contact Delete");
	}

}

