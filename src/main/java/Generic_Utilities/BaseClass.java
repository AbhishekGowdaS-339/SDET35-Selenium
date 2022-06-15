 package Generic_Utilities;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Parameters;

import com.crm.comcast.POMRepo.HomePage;
import com.crm.comcast.POMRepo.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public PropertyFile_Utility proLib=new PropertyFile_Utility();
	public WebDriver_Utility wdLib=new WebDriver_Utility();

	public WebDriver driver=null;
	
	@BeforeSuite(groups= {"smokeTest","regressionTest","sanityTest"})
	public void bSuite(){
		System.out.println("database connection");
	}
	
	@BeforeTest(groups= {"smokeTest","regressionTest","sanityTest"})
	public void bTest() {
		System.out.println("Execute script in parallel mode");
	}
	
	//@Parameters("Browser")
	@BeforeClass(groups= {"smokeTest","regressionTest","sanityTest"})
	//@BeforeClass()
	//public void bClass(String browser) throws Throwable {
	public void bClass() throws Throwable {
		String Browser = proLib.getDataFromProperty("browser");
		//Reporter.log(Browser, true);
		if(Browser.equalsIgnoreCase("ie")){
			WebDriverManager.chromedriver().setup();
			driver = new InternetExplorerDriver();
		}
		else if(Browser.equalsIgnoreCase("fireFox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();		
		}
		else {
			driver = new ChromeDriver();	
		}
		
		driver.manage().window().maximize();
		wdLib.waitForPageToLoad(driver);
		driver.get(proLib.getDataFromProperty("url"));
	}
	
	@BeforeMethod(groups= {"smokeTest","regressionTest","sanityTest"})
	public void bMethod() throws Throwable {
		LoginPage loginP = new LoginPage(driver);
		loginP.loginToApp(proLib.getDataFromProperty("username"), proLib.getDataFromProperty("password"));
	}
	
	@AfterMethod(groups= {"smokeTest","regressionTest","sanityTest"})
	public void aMethod() {
		HomePage homeP = new HomePage(driver);
		homeP.logout(driver);
	}
	
	@AfterClass(groups= {"smokeTest","regressionTest","sanityTest"})
	public void aclass() {
		driver.quit();	
	}
	
	@AfterTest(groups= {"smokeTest","regressionTest","sanityTest"})
	
	public void aTest() {
		System.out.println("Parallel Execution is compalete");
	}
	
	@AfterSuite(groups= {"smokeTest","regressionTest","sanityTest"})
	public void aSuite() {
		System.out.println("Close Database Connection");
	}
	
}
