package practice_POM;

import org.openqa.selenium.WebDriver;

import com.crm.comcast.POMRepo.CreatedOrgPage;
import com.crm.comcast.POMRepo.HomePage;
import com.crm.comcast.POMRepo.LoginPage;
import com.crm.comcast.POMRepo.OrgInfoPage;
import com.crm.comcast.POMRepo.OrganizationPage;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.PropertyFile_Utility;
import Generic_Utilities.WebDriver_Utility;

public class CreateOrgTest {
public static void main(String[] args) throws Throwable {
	
		Excel_Utility exl = new Excel_Utility();
		PropertyFile_Utility pro = new PropertyFile_Utility();
		Java_Utility jav = new Java_Utility();
		WebDriver_Utility wd = new WebDriver_Utility();
		
		String orgName =exl.getStringDataFromExcel("Sheet1", 4, 7)+jav.getRandomNum();
		
		String browser = pro.getDataFromProperty("browser");
		WebDriver driver=wd.getRemoteDriver(browser);
		wd.maximizeAndApplyImplicityWait(driver, 10);
		
		LoginPage loginP = new LoginPage(driver);
		driver.get(pro.getDataFromProperty("url"));
		loginP.loginToApp(pro.getDataFromProperty("username"), pro.getDataFromProperty("password"));
		
		HomePage homeP = new HomePage(driver);
		homeP.getOrganizationLink().click();
		
		OrganizationPage orgP = new OrganizationPage(driver);
		orgP.getOrganizationPlusLink().click();
		
		OrgInfoPage orgInfoP = new OrgInfoPage(driver);
		orgInfoP.getOrgNameTF().sendKeys(orgName);
		orgInfoP.getSaveButton().click();
		
		CreatedOrgPage createdOP = new CreatedOrgPage(driver);
		wd.pageCreateConfirmationMsg(createdOP.getCreatedPageName().getText(), orgName);

		wd.mouseOverOnElement(driver, homeP.getAdministratorSignout());
		homeP.getSignoutButton().click();
	
		driver.quit();
	}
}
