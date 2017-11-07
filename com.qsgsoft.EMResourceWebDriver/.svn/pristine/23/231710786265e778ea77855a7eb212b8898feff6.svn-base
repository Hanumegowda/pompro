package requirementGroup.Reports;

import java.util.Iterator;
import java.util.Set;

import lib.dataObject.Login_data;
import lib.dataObject.User_data;
import lib.module.LinksAtTopRightCorners;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.SelectRegion;
import lib.page.SolutionsForHealthCareEnterprises;
import lib.page.UsersList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class HappyDaySolutionsLink extends TestNG_UI_EXTENSIONS {

	public HappyDaySolutionsLink() throws Exception {
		super();
		// TODO Auto-generated constructor stub
		}

	/***************************************************************************************************************
	 * Description : Verify that admin and users are able to access 'Solution'
	 * link. 'Date : 23-06-2015 'Author : Sangappa.k
	 ***************************************************************************************************************/

	@Test(description = "Verify that admin and users are able to access 'Solution' link.")
	public void testHappyDay162931() throws Exception {
		gstrTCID = "162931";
		gstrTO = "Verify that admin and users are able to access 'Solution' link.";

		// Objects for data
		Login_data objTest_data = new Login_data();
		UsersList objUsersList_page = new UsersList(this.driver1);
		User_data objUserdata = new User_data();
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		SolutionsForHealthCareEnterprises objSolutionsForHealthCareEnterprises = new SolutionsForHealthCareEnterprises(
				driver);
		LinksAtTopRightCorners objLinkAtTopRightCorners = new LinksAtTopRightCorners(
				driver);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		LinksAtTopRightCorners objLinkAtTopRightCorners1 = new LinksAtTopRightCorners(
				driver1);
		SolutionsForHealthCareEnterprises objSolutionsForHealthCareEnterprises1 = new SolutionsForHealthCareEnterprises(
				driver1);

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objUsersList_page
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickSaveButton();

		objLinkAtTopRightCorners.clickOnSolutions();

		Thread.sleep(2000);

		String mainWindow = driver.getWindowHandle();

		Set<String> newWindow = driver.getWindowHandles();

		Iterator<String> currentWindow = newWindow.iterator();
		while (currentWindow.hasNext()) {
			String newWindow1 = currentWindow.next();
			if (!newWindow1.equalsIgnoreCase(mainWindow)) {
				driver.switchTo().window(newWindow1).manage().window()
						.maximize();

			}
		}

		objSolutionsForHealthCareEnterprises
				.verSolutionsForHealthCareEnteprisesPage().verInterMedixLogo()
				.verContactUsOption().verClientLoginOption()
				.verSolutionsOption();

		driver.close();
		driver.switchTo().window(mainWindow);
		objRegionDefault.selectFrame();
		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objLinkAtTopRightCorners1.clickOnSolutions();
		Thread.sleep(2000);

		String mainWindow1 = driver1.getWindowHandle();
		Set<String> newWindow2 = driver1.getWindowHandles();

		Iterator<String> currentWindow1 = newWindow2.iterator();

		while (currentWindow1.hasNext()) {
			String newWindow1 = currentWindow1.next();
			if (!newWindow1.equalsIgnoreCase(mainWindow1)) {
				driver1.switchTo().window(newWindow1).manage().window().maximize();
				

			}
		}
		Thread.sleep(2000);
		objSolutionsForHealthCareEnterprises1
				.verSolutionsForHealthCareEnteprisesPage().verInterMedixLogo()
				.verSolutionsOption().verContactUsOption()
				.verClientLoginOption();

		driver1.close();
		driver1.switchTo().window(mainWindow1);
		objRegionDefault1.switchToDefaultFrame().selectFrame();
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";

	}
}
