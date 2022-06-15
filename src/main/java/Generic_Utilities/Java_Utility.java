package Generic_Utilities;

import java.util.Random;

/*
 * It Contains java specific libraries
 * @author Abhishek Gowda 
 */

public class Java_Utility {
	
	/*
	 * This Method is used to get the random number using Random()
	 * @No Argument
	 * @return int
	 */
	
	
	public int getRandomNum() {
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);
		return ranNum;
	}
	
}
