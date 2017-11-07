package EMR.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import static org.testng.Assert.*;
import qaFramework.WaitTimeConstants;
import qaFramework.UserDefinedFunctions.Date_Time_settings;
import qaFramework.UserDefinedFunctions.WaitForElement;
import qaFramework.pageObject.PageObject;
import EMR.Locators.OtherRegionList.Locators;

public class OtherRegionList extends PageObject {

	WebDriver driver;
	WaitForElement waitForElement ;
	Login login;
	Alert alert; 
	Date_Time_settings dts;
	Shared navigateTo;
	SelectRegion selectRegion;
	RegionDefault regionDefault;


	public OtherRegionList(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		waitForElement = new WaitForElement(this.driver);
		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		dts = new Date_Time_settings();
		selectRegion= new SelectRegion(this.driver);
		regionDefault= new RegionDefault(this.driver);

	}

	public OtherRegionList verifyCreatNewRelationButton() throws Exception {
		waitForElement.waitForElements(Locators.CREATNEWRELATION, "css");
		assertTrue(this.page.element(Locators.CREATNEWRELATION, "css").isElementPresent()
				, "Creat New Relation button is not exist in other region page");
		return this;
	}

	public OtherRegionList clickOnCreatNewRelation() throws Exception {
		waitForElement.waitForElements(Locators.CREATNEWRELATION, "css");
		Thread.sleep(1000);
		this.page.element(Locators.CREATNEWRELATION, "css").clickUsingJSE();
		return this;
	}

	public OtherRegionList verifyOtherRegionListPage() throws Exception {
		waitForElement.waitForElements(Locators.OTHERREGHEADER, "xpath");
		assertTrue(this.page.element(Locators.OTHERREGHEADER, "xpath").getOne()
				.isDisplayed(), "Other Region page is not displayed");
		return this;
	}

	public OtherRegionList verifyRegionCanViewOtherRegion(String region)
			throws Exception {
		String otherRegion = Locators.OTHERREGIONVIEWPART1 + region + Locators.CLOSINGBRACKETS;
		waitForElement.waitForElements(otherRegion, "xpath");
		assertTrue(this.page.element(otherRegion, "xpath").getOne().isDisplayed(),
				"Region name is not listed");
		return this;
	}

	public OtherRegionList verifyDeleteOptionExists(String region)
			throws Exception {
		String delete = Locators.TABLECELLWITHTEXT + region + Locators.DELETELINK;
		waitForElement.waitForElements(delete, "xpath");
		assertTrue(this.page.element(delete, "xpath").getOne().isDisplayed(),
				"No delete link associated with region ");
		return this;
	}

	public OtherRegionList verifyVerifyOptionExists(String region)
			throws Exception {
		String verify = Locators.TABLECELLWITHTEXT + region + Locators.VERIFYLINK;
		waitForElement.waitForElements(verify, "xpath");
		assertTrue(this.page.element(verify, "xpath").getOne().isDisplayed(),
				"No verify link associated with region ");
		return this;
	}

	public OtherRegionList verifyUnVerifyOptionExists(String region)
			throws Exception {
		String unverify = Locators.TABLECELLWITHTEXT + region + Locators.UNVERIFYLINK;
		waitForElement.waitForElements(unverify, "xpath");
		assertTrue(this.page.element(unverify, "xpath").getOne().isDisplayed(),
				"No verify link associated with region ");
		return this;
	}

	public OtherRegionList verifyDeActivateOptionExists(String region)
			throws Exception {
		String deactivate = Locators.TABLECELLWITHTEXT + region + Locators.DEACTIVATELINK;
		waitForElement.waitForElements(deactivate, "xpath");
		assertTrue(this.page.element(deactivate, "xpath").getOne().isDisplayed(),
				"No Deactivate link associated with region ");
		return this;
	}

	public OtherRegionList verifyActivateOptionExists(String region)
			throws Exception {
		String activate = Locators.TABLECELLWITHTEXT + region + Locators.ACTIVATELINK;
		waitForElement.waitForElements(activate, "xpath");
		assertTrue(this.page.element(activate, "xpath").getOne().isDisplayed(),
				"No Activate link associated with region");
		return this;
	}

	public OtherRegionList deleteMutualAidRelationship(String region)
			throws Exception {
		String delete = Locators.TABLECELLWITHTEXT + region + Locators.DELETELINK;
		waitForElement.waitForElements(delete, "xpath");
		this.page.element(delete, "xpath").getOne().click();
		alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		waitForElement.waitForElements(Locators.VERIFYACTIVATEDRELATIONSHIP, "css");
		return this;
	}

	public OtherRegionList clickOnVerify(String region)
			throws Exception {
		String verify = Locators.TABLECELLWITHTEXT + region + Locators.VERIFYLINK;
		waitForElement.waitForElements(verify, "xpath");
		this.page.element(verify, "xpath").getOne().click();
		alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		assertTrue(alert.getText().contains("You chose to verify the mutual aid relationship with " + region + ". Do you want to continue?"), "alert message has changed");
		alert.accept();
		waitForElement.waitForElements(Locators.VERIFYACTIVATEDRELATIONSHIP,"css");
		return this;
	}

	public OtherRegionList clickOnDeActivat(String region)
			throws Exception {
		String deactivate = Locators.TABLECELLWITHTEXT + region + Locators.DEACTIVATELINK;
		waitForElement.waitForElements(deactivate, "xpath");
		this.page.element(deactivate, "xpath").getOne().click();
		alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		//		assertTrue(alert.getText().equals("You chose to deactivate the mutual aid relationship with STest 3.30.2 Region. NSTestRegion region resources will no longer be visible in multi-region views of the STest 3.30.2 Region region. Do you want to continue?"), alert.getText() + " message has changed.");
		alert.accept();
		waitForElement.waitForElements(Locators.VERIFYACTIVATEDRELATIONSHIP, "css");
		return this;
	}

	public OtherRegionList activateMutualAgreementWithRegion(String region)
			throws Exception {
		String activate = Locators.TABLECELLWITHTEXT + region + Locators.ACTIVATELINK;
		waitForElement.waitForElements(activate, "xpath");
		this.page.element(activate, "xpath").getOne().click();
		alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		assertTrue(alert.getText().contains("You chose to activate the mutual aid relationship with " + region + ". Do you want to continue?"), "alert message has changed");
		alert.accept();
		waitForElement.waitForElements(Locators.VERIFYACTIVATEDRELATIONSHIP, "css");
		return this;
	}

	public OtherRegionList verifyRegionIsVerifiedUnderVerifiedColumn(String region)
			throws Exception {
		String verifiedRegion = Locators.TABLECELLWITHTEXT +region+ Locators.REGIONVERIFIED;
		waitForElement.waitForElements(verifiedRegion, "xpath");
		assertTrue(this.page.element(verifiedRegion, "xpath").getOne().isDisplayed(),
				"Verfief ");
		return this;
	}

	public OtherRegionList verifyRegionIsActivatededUnderActivateColumn(String region)
			throws Exception {
		String activeRegion = Locators.TABLECELLWITHTEXT +region+ Locators.REGIONACTIVATED;
		waitForElement.waitForElements(activeRegion, "xpath");
		assertTrue(this.page.element(activeRegion, "xpath").getOne().isDisplayed(),
				"No verify link associated with region ");
		return this;
	}

	public OtherRegionList verifyAndEnableMutualAidAgreement(String region)
			throws Exception {
		this.verifyVerifyOptionExists(region);
		this.verifyDeleteOptionExists(region);
		this.clickOnVerify(region);
		this.verifyMutualAidRelationVerifiedTextHeader(region);
		this.verifyUnVerifyOptionExists(region);
		this.verifyActivateOptionExists(region);
		this.activateMutualAgreementWithRegion(region);
		this.verifyMutualAidRelationActivatedTextHeader(region);
		this.verifyDeActivateOptionExists(region);
		return this;
	}

	public OtherRegionList verifyMutualAidRelationActivatedTextHeader(String region)
			throws Exception {
		String successMessage = Locators.AGRREMENT_SUCCESS_MESSAGE_PART1 + region + " was successfully activated." + Locators.CLOSINGBRACKETS;
		waitForElement.waitForElements(successMessage, "xpath");
		assertTrue(this.page.element(successMessage, "xpath").isElementPresent(), "Mutual aid relationship with "
				+ region + " was not activated.");
		return this;
	}


	public OtherRegionList verifyOtherRegionPage() throws Exception {
		this.verifyOtherRegionListPage();
		return this;
	}

	public OtherRegionList deactivateRegionAgreement(String region)
			throws Exception {
		String deactivate = Locators.TABLECELLWITHTEXT + region + Locators.DEACTIVATELINK;
		waitForElement.waitForElements(deactivate, "xpath");
		this.page.element(deactivate, "xpath").getOne().click();
		alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		return this;
	}

	public OtherRegionList unverifyRegionAgreements(String region)
			throws Exception {
		String unverify = Locators.TABLECELLWITHTEXT + region + Locators.UNVERIFYLINK;
		waitForElement.waitForElements(unverify, "xpath");
		this.page.element(unverify, "xpath").getOne().click();
		alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		assertTrue(alert.getText().equals("You chose to unverify the mutual aid relationship with " + region + ". Do you want to continue?"), alert.getText() + " message in the alert is not same as assertion");
		alert.accept();
		waitForElement.waitForElements(Locators.VERIFYACTIVATEDRELATIONSHIP, "css");
		return this;
	}

	public OtherRegionList deactivateMutualAgreement(String region) throws Exception {
		this.deactivateRegionAgreement(region);
		this.verifyMutualAidRelationDeactivateTextHeader(region);
		this.verifyUnVerifyOptionExists(region);
		this.verifyActivateOptionExists(region);
		this.unverifyRegionAgreements(region);
		this.verifyMutualAidRelationUnverifiedTextHeader(region);
		this.verifyVerifyOptionExists(region);
		this.verifyDeleteOptionExists(region);
		return this;
	}

	public OtherRegionList verifyManageUsersLink(String mutuallyAddedRegion)
			throws Exception {
		String verifiedRegion = Locators.TABLECELLWITHTEXT +mutuallyAddedRegion+ Locators.CLOSINGBRACKETS+Locators.MANAGE_USERS_LINK;
		waitForElement.waitForElements(verifiedRegion, "xpath");
		assertTrue(this.page.element(verifiedRegion, "xpath").isElementPresent());
		assertTrue(this.page.element(verifiedRegion, "xpath").getOne().isDisplayed(),
				"Manage Users link is not available corresponind to region");
		return this;
	}

	public OtherRegionList clickOnManageUsersLink(String mutuallyAddedRegion)
			throws Exception {
		String verifiedRegion = Locators.TABLECELLWITHTEXT +mutuallyAddedRegion+ Locators.CLOSINGBRACKETS+Locators.MANAGE_USERS_LINK;
		waitForElement.waitForElements(verifiedRegion, "xpath");
		this.page.element(verifiedRegion, "xpath").getOne().click();
		waitForElement.waitForElements(Locators.ASSIGNE_FOR_ALL_USERS, "id");
		return this;
	}

	public OtherRegionList verifyAssigneForAllUsersIsSelected()
			throws Exception {
		waitForElement.waitForElements(Locators.ASSIGNE_FOR_ALL_USERS, "id");
		assertTrue((this.page.element(Locators.ASSIGNE_FOR_ALL_USERS, "id").getOne().isSelected()), "Assigne for all users not selected");
		assertTrue((this.page.element(Locators.ASSIGNE_FOR_ALL_USERS_SELECTED, "css").getOne().isDisplayed()), "Assigne for all users not selected");
		return this;
	}

	public OtherRegionList verifyAssignUsersToViewRegionPage(String mutuallyAddedRegion)
			throws Exception {
		waitForElement.waitForElements(Locators.ASSIGNE_FOR_ALL_USERS, "id");
		assertTrue((this.page.element(Locators.ASSIGNE_USERS_TO_PAGE_PART1+mutuallyAddedRegion+Locators.REGIONTEXT, "xpath").isElementPresent()),"Assigne for all users page not displayed");
		assertTrue((this.page.element(Locators.ASSIGNE_USERS_TO_PAGE_PART1+mutuallyAddedRegion+Locators.REGIONTEXT, "xpath").getOne().isDisplayed()),"Assigne for all users page not displayed");
		return this;
	}

	public OtherRegionList verifyRegionThatCanViewRegionsSection(String region)
			throws Exception {
		String regionsCanViewRegions=Locators.REGIONS_THAT_CAN_VIEW_SECTION+region+Locators.REGIONTEXT;
		waitForElement.waitForElements(regionsCanViewRegions, "xpath");
		assertTrue((this.page.element(regionsCanViewRegions, "xpath").isElementPresent()),"Regions that can view is not available region page");
		assertTrue((this.page.element(regionsCanViewRegions, "xpath").getOne().isDisplayed()),"Regions that can view is not available under other region page");
		return this;
	}

	public OtherRegionList verifyActiveStatus(String region2,String status)
			throws Exception {
		String activeStatus = Locators.TABLECELLWITHTEXT +region2+ Locators.CLOSINGBRACKETS+Locators.ACTIVATE_STATUS+status+Locators.CLOSINGBRACKETS;
		waitForElement.waitForElements(activeStatus, "xpath");
		assertTrue(this.page.element(activeStatus, "xpath").isElementPresent());
		assertTrue(this.page.element(activeStatus, "xpath").getOne().isDisplayed(),
				"Verfief ");
		return this;
	}

	public OtherRegionList verifyVerifiedBy(String region2,String userName)
			throws Exception {
		String verifiedBy = Locators.TABLECELLWITHTEXT +region2+ Locators.CLOSINGBRACKETS+Locators.VERIFIED_BY+userName+Locators.CLOSINGBRACKETS;
		waitForElement.waitForElements(verifiedBy, "xpath");
		assertTrue(this.page.element(verifiedBy, "xpath").getOne().isDisplayed());
		return this;
	}

	public OtherRegionList verifyVerfiedOn(String region2,String verifiedDate)
			throws Exception {
		String verifiedOn = Locators.TABLECELLWITHTEXT +region2+ Locators.CLOSINGBRACKETS+Locators.VERIFIED_ON+verifiedDate+Locators.CLOSINGBRACKETS;
		waitForElement.waitForElements(verifiedOn, "xpath");
		assertTrue(this.page.element(verifiedOn, "xpath").isElementPresent());
		assertTrue(this.page.element(verifiedOn, "xpath").getOne().isDisplayed()); 
		return this;
	}

	public OtherRegionList verifyActivatedBy(String region2,String verifiedDate)
			throws Exception {
		String activatedBy = Locators.TABLECELLWITHTEXT +region2+ Locators.CLOSINGBRACKETS+Locators.ACTIVATED_BY+verifiedDate+Locators.CLOSINGBRACKETS;
		waitForElement.waitForElements(activatedBy, "xpath");
		assertTrue(this.page.element(activatedBy, "xpath").isElementPresent());
		assertTrue(this.page.element(activatedBy, "xpath").getOne().isDisplayed()); 
		return this;
	}

	public OtherRegionList verifyActivatedOn(String region2,String activatedDate)
			throws Exception {
		String activatedOn = Locators.TABLECELLWITHTEXT +region2+ Locators.CLOSINGBRACKETS+Locators.ACTIVATED_ON+activatedDate+Locators.CLOSINGBRACKETS;
		waitForElement.waitForElements(activatedOn, "xpath");
		assertTrue(this.page.element(activatedOn, "xpath").isElementPresent());
		assertTrue(this.page.element(activatedOn, "xpath").getOne().isDisplayed()); 
		return this;
	}

	public OtherRegionList verifyVerifiedStatus(String region2,String status)
			throws Exception {
		String verifiedRegion = Locators.TABLECELLWITHTEXT +region2+ Locators.CLOSINGBRACKETS+Locators.VERIFIED_STATUS+status+Locators.CLOSINGBRACKETS;
		waitForElement.waitForElements(verifiedRegion, "xpath");
		assertTrue(this.page.element(verifiedRegion, "xpath").isElementPresent());
		assertTrue(this.page.element(verifiedRegion, "xpath").getOne().isDisplayed(),
				"Verfief ");
		return this;
	}

	public OtherRegionList verifyRegionCanViewSection(String region)
			throws Exception {
		String regionsCanView=Locators.PAGE_HEADER+region+Locators.REGION_CAN_VIEW_SECTION;
		waitForElement.waitForElements(regionsCanView, "xpath");
		assertTrue((this.page.element(regionsCanView, "xpath").isElementPresent()),"Region Can View Section is not displayed");
		assertTrue((this.page.element(regionsCanView, "xpath").getOne().isDisplayed()),"Region Can View Section is not displayed");
		return this;
	}

	public OtherRegionList verifyRegionIsNotDispalyedUnderCanViewSection(String region)throws Exception {
		String regionsCanView=Locators.REGION_UNDER_CAN_VIEW_SECTION+region+Locators.CLOSINGBRACKETS;
		assertFalse(this.page.element(regionsCanView, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	} 

	public OtherRegionList verifyColumnNamesUnderRegionCanViewSection(String columnNames[])throws Exception {

		waitForElement.waitForElements(Locators.NAME_COLUMN_OF_REGIONS_CAN_VIEW_SECTION, "xpath");	
		for(int i =0;i<=columnNames.length-1;i++)	
		{	
			String regionsCanView=Locators.TABLE_HEADERS_OF_REGIONS_CAN_VIEW_SECTION+columnNames[i]+Locators.CLOSINGBRACKETS;
			assertTrue(this.page.element(regionsCanView, "xpath").isElementPresent());
			assertTrue(this.page.element(regionsCanView, "xpath").getOne().isDisplayed());
			assertTrue(this.page.element(Locators.NAME_COLUMN_OF_REGIONS_CAN_VIEW_SECTION, "xpath").isElementPresent());
			assertTrue(this.page.element(Locators.NAME_COLUMN_OF_REGIONS_CAN_VIEW_SECTION, "xpath").getOne().isDisplayed());
		}
		return this;
	} 

	public OtherRegionList verifyColumnNamesUnderCanViewSection(String columnNames[])throws Exception {
		for(int i =0;i<=columnNames.length-1;i++)
		{		
			String regionsCanView=Locators.TABLE_HEADER_OF_CAN_VIEW_SECTION+columnNames[i]+Locators.CLOSINGBRACKETS;
			assertTrue(this.page.element(regionsCanView, "xpath").isElementPresent());
			assertTrue(this.page.element(regionsCanView, "xpath").getOne().isDisplayed());
		}
		return this;
	}

	public OtherRegionList verifyingMutualAidAgreement(String region,String activeStatusNo,String verifiedStatusNo,String verifiedStatusYes,String userName,String verifiedDate) throws Exception {
		navigateTo.otherRegion();
		this.verifyVerifyOptionExists(region);
		this.verifyActiveStatus(region, activeStatusNo);
		this.verifyVerifiedStatus(region,verifiedStatusNo);
		this.clickOnVerify(region);
		this.verifyUnVerifyOptionExists(region);
		this.verifyActivateOptionExists(region);
		this.verifyVerifiedStatus(region, verifiedStatusYes);
		this.verifyVerifiedBy(region, userName);
		this.verifyVerfiedOn(region, verifiedDate);
		this.verifyActiveStatus(region, activeStatusNo);
		return this;
	}

	public OtherRegionList activateMutualAidAndVerifyActivationDetailes(String region2,String activeStatusYes,String activatedBy,String activtedOn) throws Exception {
		navigateTo.otherRegion();
		this.verifyOtherRegionPage();
		this.activateMutualAgreementWithRegion(region2);
		this.verifyMutualAidRelationActivatedTextHeader(region2);
		this.verifyDeActivateOptionExists(region2);
		this.verifyActiveStatus(region2, activeStatusYes);
		this.verifyActivatedBy(region2, activatedBy);
		this.verifyActivatedOn(region2, activtedOn);
		return this;
	}

	public OtherRegionList verifyRegionNotPresentInCanViewSection(String region) throws Exception {
		navigateTo.otherRegion();
		this.verifyOtherRegionPage();
		this.verifyRegionIsNotDispalyedUnderCanViewSection(region);
		return this;
	}

	public OtherRegionList verifyMutualAidRelationVerifiedTextHeader(String region)
			throws Exception {
		String successMessage = Locators.AGRREMENT_SUCCESS_MESSAGE_PART1 + region + " was successfully verified." + Locators.CLOSINGBRACKETS;
		waitForElement.waitForElements(successMessage, "xpath");
		assertTrue(this.page.element(successMessage, "xpath").isElementPresent());
		return this;
	}

	public OtherRegionList navigateToOtherRegionAndVerifyManageUserOption(String region)throws Exception {
		navigateTo.otherRegion();
		this.verifyManageUsersLink(region);
		return this;
	}

	public OtherRegionList verifySharedResourceAndStatusTypes(String region, String _resourceType,String _resource,String  _statusTypes[])throws Exception {
		navigateTo.regionUnderOtherRegion(region);
		regionDefault.verifyResourceAndCorrespondingStatusTypes(_resourceType, _resource, _statusTypes);
		return this;
	}

	public OtherRegionList verifyManageUsersOptionNotAvailable(String mutuallyAddedRegion)
			throws Exception {
		String verifiedRegion = Locators.TABLECELLWITHTEXT +mutuallyAddedRegion+ Locators.CLOSINGBRACKETS+Locators.MANAGE_USERS_LINK;
		waitForElement.waitForElements(verifiedRegion, "xpath");
		assertFalse(this.page.element(verifiedRegion, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}

	public String getRegionValueOfManageUsersOption(String mutuallyAddedRegion)
			throws Exception {
		String verifiedRegion = Locators.TABLECELLWITHTEXT +mutuallyAddedRegion+ Locators.CLOSINGBRACKETS+Locators.MANAGE_USERS_LINK;
		waitForElement.waitForElements(verifiedRegion, "xpath");
		String regionValue=this.page.element(verifiedRegion, "xpath").getOne().getAttribute("href");
		String[] regionId=regionValue.split("view_id=");
		return regionId[1];
	}

	public OtherRegionList verifyMan(String mutuallyAddedRegion)
			throws Exception {
		String verifiedRegion = Locators.TABLECELLWITHTEXT +mutuallyAddedRegion+ Locators.CLOSINGBRACKETS+Locators.MANAGE_USERS_LINK;
		waitForElement.waitForElements(verifiedRegion, "xpath");
		assertFalse(this.page.element(verifiedRegion, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}

	public String verifyAssigneForAllUsersIsChecked(String mutuallyAddedRegion)
			throws Exception {
		navigateTo.otherRegion();
		String regionValue=this.getRegionValueOfManageUsersOption(mutuallyAddedRegion);
		this.clickOnManageUsersLink(mutuallyAddedRegion);
		this.verifyAssigneForAllUsersIsSelected();
		return regionValue;
	}

	public OtherRegionList deselectAssigneForAllUsers() throws Exception {
		waitForElement.waitForElements(Locators.ASSIGNE_FOR_ALL_USERS, "id");

		if (this.page.element(Locators.ASSIGNE_FOR_ALL_USERS, "id").getOne().isSelected()) {
			this.page.element(Locators.ASSIGNE_FOR_ALL_USERS, "id").mouseOver();
			this.page.element(Locators.ASSIGNE_FOR_ALL_USERS, "id").getOne().click();
		}
		if (this.page.element(Locators.ASSIGNE_FOR_ALL_USERS, "id").getOne().isSelected()) {
			this.page.element(Locators.ASSIGNE_FOR_ALL_USERS, "id").mouseOver();
			this.page.element(Locators.ASSIGNE_FOR_ALL_USERS, "id").getOne().sendKeys(Keys.SPACE);
		}
		assertTrue((!this.page.element(Locators.ASSIGNE_FOR_ALL_USERS, "id").getOne().isSelected()), "Assigne for all users selected");
		return this;
	}

	public OtherRegionList selectAssigneForAllUsers() throws Exception {
		waitForElement.waitForElements(Locators.ASSIGNE_FOR_ALL_USERS, "id");

		if (!this.page.element(Locators.ASSIGNE_FOR_ALL_USERS, "id").getOne().isSelected()) {
			this.page.element(Locators.ASSIGNE_FOR_ALL_USERS, "id").mouseOver();
			this.page.element(Locators.ASSIGNE_FOR_ALL_USERS, "id").getOne().click();
		}
		if (!this.page.element(Locators.ASSIGNE_FOR_ALL_USERS, "id").getOne().isSelected()) {
			this.page.element(Locators.ASSIGNE_FOR_ALL_USERS, "id").mouseOver();
			this.page.element(Locators.ASSIGNE_FOR_ALL_USERS, "id").getOne().sendKeys(Keys.SPACE);
		}
		assertTrue((this.page.element(Locators.ASSIGNE_FOR_ALL_USERS, "id").getOne().isSelected()), "Assigne for all users selected");
		return this;
	}

	public OtherRegionList clickOnSave()throws Exception {
		waitForElement.waitForElements(Locators.SAVE, "css");
		this.page.element(Locators.SAVE, "css").getOne().click();	
		return this;

	}
	public String unCheckAssigneForAllUsers(String mutuallyAddedRegion)
			throws Exception {
		navigateTo.otherRegion();
		String regionValue=this.getRegionValueOfManageUsersOption(mutuallyAddedRegion);
		this.clickOnManageUsersLink(mutuallyAddedRegion);
		this.deselectAssigneForAllUsers();
		this.clickOnSave();
		return regionValue;
	}

	public OtherRegionList selectCheckForAllUsers(String mutuallyAddedRegion)
			throws Exception {
		navigateTo.otherRegion();
		this.clickOnManageUsersLink(mutuallyAddedRegion);
		this.selectAssigneForAllUsers();
		this.clickOnSave();
		return this;
	}

	public OtherRegionList verifyMutualAidRelationUnverifiedTextHeader(String region)
			throws Exception {
		String successMessage = Locators.AGRREMENT_SUCCESS_MESSAGE_PART1 + region + " was successfully unverified." + Locators.CLOSINGBRACKETS;
		waitForElement.waitForElements(successMessage, "xpath");
		assertTrue(this.page.element(successMessage, "xpath").isElementPresent(), successMessage + " message has not appeared");
		return this;
	}

	public OtherRegionList verifyMutualAidRelationDeletedTextHeader(String region) throws Exception {
		String successMessage = Locators.AGRREMENT_SUCCESS_MESSAGE_PART1 + region + " was successfully deleted." + Locators.CLOSINGBRACKETS;
		waitForElement.waitForElements(successMessage, "xpath");
		assertTrue(this.page.element(successMessage, "xpath").isElementPresent(), successMessage + " message has not appeared" );
		return this;
	}

	public OtherRegionList verifyMutualAidRelationDeactivateTextHeader(String region)
			throws Exception {
		String successMessage = Locators.AGRREMENT_SUCCESS_MESSAGE_PART1 + region + " was successfully deactivated." + Locators.CLOSINGBRACKETS;
		waitForElement.waitForElements(successMessage, "xpath");
		assertTrue(this.page.element(successMessage, "xpath").isElementPresent(), successMessage + " message has not appeared" );
		return this;
	}

	public OtherRegionList verifyRegionUnderThatCanViewSection(String region)throws Exception {
		String regionsCanView=Locators.REGION_UNDER_THAT_CAN_VIEW_SECTION+region+Locators.CLOSINGBRACKETS;
		waitForElement.waitForElements(regionsCanView, "xpath");
		assertTrue(this.page.element(regionsCanView, "xpath").isElementPresent());
		assertTrue(this.page.element(regionsCanView, "xpath").getOne().isDisplayed());
		return this;
	}

	public OtherRegionList verifyRegionIsNotUnderCanViewSection(String region)
			throws Exception {
		navigateTo.otherRegion();
		this.verifyRegionIsNotDispalyedUnderCanViewSection(region);
		return this;
	}

	public OtherRegionList deleteRelation(String mutuallyAddedRegion)
			throws Exception {
		navigateTo.otherRegion();
		this.deleteMutualAidRelationship(mutuallyAddedRegion);
		return this;
	}

	public OtherRegionList verifyRegionIsNotUnderThatCanViewSection(String region)throws Exception {
		String regionsCanView=Locators.REGION_UNDER_THAT_CAN_VIEW_SECTION+region+Locators.CLOSINGBRACKETS;
		waitForElement.waitForElements(regionsCanView, "xpath");
		assertFalse(this.page.element(regionsCanView, "xpath").isElementPresent());
		return this;
	}

	public OtherRegionList verifyActionLinksAreNotAvailable(String regionName) throws Exception {
		String previousLink = Locators.REGION_UNDER_THAT_CAN_VIEW_SECTION + regionName + EMR.Locators.ConfigureNewRelationship.Locators.PREVIOUSLINK_OF_REGION_UNDER_REGION_CAN_VIEW_SECTION;
		waitForElement.waitForElements(Locators.REGION_UNDER_THAT_CAN_VIEW_SECTION + regionName + Locators.CLOSINGBRACKETS, "xpath");
		assertTrue(this.page.element(Locators.REGION_UNDER_THAT_CAN_VIEW_SECTION + regionName + Locators.CLOSINGBRACKETS, "xpath").isElementPresent(), regionName + " region is not displayed under can view section.");
		assertFalse(this.page.element(previousLink, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE), "Action links are available for the region -"+ regionName);
		return this;
	}

	public OtherRegionList assignParticularUserToView(String username)throws Exception{
		waitForElement.waitForElements(Locators.TABLECELLWITHTEXT+ username +Locators.SELECTPARTICULARUSERPART2, "xpath");

		if (!(this.page.element(Locators.TABLECELLWITHTEXT+ username +Locators.SELECTPARTICULARUSERPART2, "xpath").getOne().isSelected())) {
			this.page.element(Locators.TABLECELLWITHTEXT+ username +Locators.SELECTPARTICULARUSERPART2, "xpath").mouseOver();
			this.page.element(Locators.TABLECELLWITHTEXT+ username +Locators.SELECTPARTICULARUSERPART2, "xpath").getOne().click();
		}
		if (!(this.page.element(Locators.TABLECELLWITHTEXT+ username +Locators.SELECTPARTICULARUSERPART2, "xpath").getOne().isSelected())) {
			this.page.element(Locators.TABLECELLWITHTEXT+ username +Locators.SELECTPARTICULARUSERPART2, "xpath").mouseOver();
			this.page.element(Locators.TABLECELLWITHTEXT+ username +Locators.SELECTPARTICULARUSERPART2, "xpath").getOne().sendKeys(Keys.SPACE);
		}
		assertTrue(this.page.element(Locators.TABLECELLWITHTEXT+ username +Locators.SELECTPARTICULARUSERPART2, "xpath").getOne().isSelected(), "User" + username + " not selected");
		return this;
	}

	public OtherRegionList deselectParticularUserToView(String username)throws Exception{
		waitForElement.waitForElements(Locators.TABLECELLWITHTEXT+ username +Locators.SELECTPARTICULARUSERPART2, "xpath");

		if (this.page.element(Locators.TABLECELLWITHTEXT+ username +Locators.SELECTPARTICULARUSERPART2, "xpath").getOne().isSelected()) {
			this.page.element(Locators.TABLECELLWITHTEXT+ username +Locators.SELECTPARTICULARUSERPART2, "xpath").mouseOver();
			this.page.element(Locators.TABLECELLWITHTEXT+ username +Locators.SELECTPARTICULARUSERPART2, "xpath").getOne().click();
		}
		if (this.page.element(Locators.TABLECELLWITHTEXT+ username +Locators.SELECTPARTICULARUSERPART2, "xpath").getOne().isSelected()) {
			this.page.element(Locators.TABLECELLWITHTEXT+ username +Locators.SELECTPARTICULARUSERPART2, "xpath").mouseOver();
			this.page.element(Locators.TABLECELLWITHTEXT+ username +Locators.SELECTPARTICULARUSERPART2, "xpath").getOne().sendKeys(Keys.SPACE);
		}
		assertTrue(!(this.page.element(Locators.TABLECELLWITHTEXT+ username +Locators.SELECTPARTICULARUSERPART2, "xpath").getOne().isSelected()), "User" + username + " not selected");
		return this;
	}

	public OtherRegionList verifyMutualAidRegionPageDisplayed(String mutuallyAidedRegion) throws Exception {
		waitForElement.waitForElements(Locators.MUTUALAIDEDREGIONPART1 + mutuallyAidedRegion +Locators.CLOSINGBRACKETS, "xpath");
		assertTrue(this.page.element(Locators.MUTUALAIDEDREGIONPART1 + mutuallyAidedRegion +Locators.CLOSINGBRACKETS, "xpath").getOne()
				.isDisplayed(), "" + mutuallyAidedRegion +" page is not displayed");
		return this;
	}

	public OtherRegionList verifyMutualAidedRegionNotAvailable(String mutuallyAidedRegion) throws Exception{
		waitForElement.waitForElements(Locators.OTHERG_REAGION_TAB, "linktext");
		if(this.page.element(Locators.OTHERG_REAGION_TAB, "linktext").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL)){
			navigateTo.clickOnOtherRegions();	
			waitForElement.waitForElements(Locators.PARTICULARVIEWPART1 + mutuallyAidedRegion + Locators.CLOSINGBRACKETS, "xpath");
			assertFalse(this.page.element(Locators.PARTICULARVIEWPART1 + mutuallyAidedRegion + Locators.CLOSINGBRACKETS,"xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL));
		} else {
			assertFalse(this.page.element(Locators.OTHERG_REAGION_TAB, "linktext").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL));
		}
		return this;
	}
	
    public OtherRegionList verifySharedStatusTypeOptionIsAvailable()throws Exception {
  		waitForElement.waitForElements(Locators.SHAREDSTATUSTYPEBUTTON, "xpath");
  		assertTrue(this.page.element(Locators.SHAREDSTATUSTYPEBUTTON, "xpath").isElementPresent(), "Shared Status Type Button is not available");
  		return this;
  	 }
    
    public OtherRegionList navigateToEditOtherRegionSecurityStatusTypes()throws Exception {
  		waitForElement.waitForElements(Locators.SHAREDSTATUSTYPEBUTTON, "xpath");
  		this.page.element(Locators.SHAREDSTATUSTYPEBUTTON, "xpath").clickUsingJSE();
  		return this;
  	 }
    
    public OtherRegionList verifySharedStatusTypeIsSelectedAndEnabled(String sharedStatusTypeValue) throws Exception{
		waitForElement.waitForElements(Locators.SELECTSTATUSTYPEPART1 + sharedStatusTypeValue + Locators.CLOSINGBRACKETS, "css");
		if(this.page.element(Locators.SELECTSTATUSTYPEPART1 + sharedStatusTypeValue + Locators.CLOSINGBRACKETS, "css").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL)){

			assertTrue(this.page.element(Locators.SELECTSTATUSTYPEPART1 + sharedStatusTypeValue + Locators.CLOSINGBRACKETS,"css").getOne().isEnabled(), "Shared Status Type is Disabled");
			assertTrue(this.page.element(Locators.SELECTSTATUSTYPEPART1 + sharedStatusTypeValue + Locators.CLOSINGBRACKETS,"css").getOne().isSelected(), "Shared Status Type is not Selected");
		} else {
			assertTrue(this.page.element(Locators.SELECTSTATUSTYPEPART1 + sharedStatusTypeValue + Locators.CLOSINGBRACKETS, "css").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL));
		}
		System.out.println("Verified Shared StatusType");
		return this;
	}

	public OtherRegionList verifyRoleBasedStatusTypeIsDeselectedAndEnabled(String roleBasedStatusTypeValue) throws Exception{
		waitForElement.waitForElements(Locators.SELECTSTATUSTYPEPART1 + roleBasedStatusTypeValue + Locators.CLOSINGBRACKETS, "css");
		if(this.page.element(Locators.SELECTSTATUSTYPEPART1 + roleBasedStatusTypeValue + Locators.CLOSINGBRACKETS, "css").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL)){

			assertTrue(this.page.element(Locators.SELECTSTATUSTYPEPART1 + roleBasedStatusTypeValue + Locators.CLOSINGBRACKETS,"css").getOne().isEnabled(), "Role Based Status Type is Disabled");
			assertFalse(this.page.element(Locators.SELECTSTATUSTYPEPART1 + roleBasedStatusTypeValue + Locators.CLOSINGBRACKETS,"css").getOne().isSelected(), "Role Based Status Type is Selected");
		} else {
			assertTrue(this.page.element(Locators.SELECTSTATUSTYPEPART1 + roleBasedStatusTypeValue + Locators.CLOSINGBRACKETS, "css").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL));
		}
		System.out.println("Verified Role based StatusType");
		return this;
	}

	public OtherRegionList verifyPrivateStatusTypeIsNotAvailable(String privateStatusTypeValue) throws Exception{
		assertFalse(this.page.element(Locators.SELECTSTATUSTYPEPART1 + privateStatusTypeValue + Locators.CLOSINGBRACKETS, "css").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE), "Private Status Type is Displayed");
		System.out.println("Verified Private StatusType");
		return this;
	}

	public OtherRegionList selectRoleBasedStatusType(String roleBasedStatusTypeValue) throws Exception{
		waitForElement.waitForElements(Locators.SELECTSTATUSTYPEPART1 + roleBasedStatusTypeValue +Locators.CLOSINGBRACKETS, "css");
			this.page.element(Locators.SELECTSTATUSTYPEPART1 + roleBasedStatusTypeValue +Locators.CLOSINGBRACKETS, "css").getOne().sendKeys(Keys.SPACE);
			if(this.page.element(Locators.SELECTSTATUSTYPEPART1 + roleBasedStatusTypeValue +Locators.CLOSINGBRACKETS, "css").getOne().isSelected() == false) {
				this.page.element(Locators.SELECTSTATUSTYPEPART1 + roleBasedStatusTypeValue +Locators.CLOSINGBRACKETS, "css").getOne().click();
			}
			if(this.page.element(Locators.SELECTSTATUSTYPEPART1 + roleBasedStatusTypeValue +Locators.CLOSINGBRACKETS, "css").getOne().isSelected() == false) {
				this.page.element(Locators.SELECTSTATUSTYPEPART1 + roleBasedStatusTypeValue +Locators.CLOSINGBRACKETS, "css").Click();
			}
			assertTrue(this.page.element(Locators.RESOURCECHECKBOX + roleBasedStatusTypeValue +Locators.CLOSINGBRACKETS, "css").getOne().isSelected());
			System.out.println(" role based StatusType selected");
		return this;
	}

	public OtherRegionList verifyRoleBasedStatusTypeIsSelectedAndEnabled(String roleBasedStatusTypeValue) throws Exception{
		waitForElement.waitForElements(Locators.SELECTSTATUSTYPEPART1 + roleBasedStatusTypeValue + Locators.CLOSINGBRACKETS, "css");
		if(this.page.element(Locators.SELECTSTATUSTYPEPART1 + roleBasedStatusTypeValue + Locators.CLOSINGBRACKETS, "css").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL)){

			assertTrue(this.page.element(Locators.SELECTSTATUSTYPEPART1 + roleBasedStatusTypeValue + Locators.CLOSINGBRACKETS,"css").getOne().isEnabled(), "Role Based Status Type is Disabled");
			assertTrue(this.page.element(Locators.SELECTSTATUSTYPEPART1 + roleBasedStatusTypeValue + Locators.CLOSINGBRACKETS,"css").getOne().isSelected(), "Role Based Status Type is not Selected");
		} else {
			assertTrue(this.page.element(Locators.SELECTSTATUSTYPEPART1 + roleBasedStatusTypeValue + Locators.CLOSINGBRACKETS, "css").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL));
		}
		System.out.println("Verified Role based StatusType");
		return this;
	} 

	public OtherRegionList verifySharedStatusTypeIsSelectedAndDisabled(String SharedStatusTypeValue) throws Exception{
		waitForElement.waitForElements(Locators.SELECTSTATUSTYPEPART1 + SharedStatusTypeValue + Locators.CLOSINGBRACKETS, "css");
		if(this.page.element(Locators.SELECTSTATUSTYPEPART1 + SharedStatusTypeValue + Locators.CLOSINGBRACKETS, "css").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL)){

			assertFalse(this.page.element(Locators.SELECTSTATUSTYPEPART1 + SharedStatusTypeValue + Locators.CLOSINGBRACKETS,"css").getOne().isEnabled(), "Shared Status Type is Enabled");
			assertTrue(this.page.element(Locators.SELECTSTATUSTYPEPART1 + SharedStatusTypeValue + Locators.CLOSINGBRACKETS,"css").getOne().isSelected(), "Shared Status Type is not Selected");
		} else {
			assertTrue(this.page.element(Locators.SELECTSTATUSTYPEPART1 + SharedStatusTypeValue + Locators.CLOSINGBRACKETS, "css").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL));
		}
		System.out.println("Verified Shared StatusType");
		return this;
	} 

	public OtherRegionList verifyRoleBasedStatusTypeIsSelectedAndDisabled(String roleBasedStatusTypeValue) throws Exception{
		waitForElement.waitForElements(Locators.SELECTSTATUSTYPEPART1 + roleBasedStatusTypeValue + Locators.CLOSINGBRACKETS, "css");
		if(this.page.element(Locators.SELECTSTATUSTYPEPART1 + roleBasedStatusTypeValue + Locators.CLOSINGBRACKETS, "css").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL)){

			assertFalse(this.page.element(Locators.SELECTSTATUSTYPEPART1 + roleBasedStatusTypeValue + Locators.CLOSINGBRACKETS,"css").getOne().isEnabled(), "Role Based Status Type is Enabled");
			assertTrue(this.page.element(Locators.SELECTSTATUSTYPEPART1 + roleBasedStatusTypeValue + Locators.CLOSINGBRACKETS,"css").getOne().isSelected(), "Role Based Status Type is not Selected");
		} else {
			assertTrue(this.page.element(Locators.SELECTSTATUSTYPEPART1 + roleBasedStatusTypeValue + Locators.CLOSINGBRACKETS, "css").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL));
		}
		System.out.println("Verified Role based StatusType");
		return this;
	} 

	public OtherRegionList verifyShareResourcesOption() throws Exception {
		waitForElement.waitForElements(Locators.SHARERESOURCES, "css");
		assertTrue(this.page.element(Locators.SHARERESOURCES, "css").isElementPresent()
				, "Share Resources button is not exist in other region page");
		return this;
	}

	public OtherRegionList navigateToEditOtherRegionSecurityResourcesPage() throws Exception {
		waitForElement.waitForElements(Locators.SHARERESOURCES, "css");
		this.page.element(Locators.SHARERESOURCES, "css").clickUsingJSE();
		return this;
	}

	public OtherRegionList verifyEditOtherRegionSecurityResourcesPageIsDisplayed() throws Exception {
		waitForElement.waitForElements(Locators. EDIT_OTHERREGION_SECURITY_RESOURCES, "xpath");
		assertTrue(this.page.element(Locators. EDIT_OTHERREGION_SECURITY_RESOURCES, "xpath").isElementPresent()
				, "Edit Other Region Security - Resources page is not displayed");
		return this;
	}

	public OtherRegionList selectResourceUnderEditOtherRegionSecurityResources(String[] resourcevalues) throws Exception {
		waitForElement.waitForElements(Locators.RESOURCECHECKBOX + resourcevalues[0] +Locators.CLOSINGBRACKETS, "css");
		for (int resourceNumber = 0; resourceNumber < resourcevalues.length; resourceNumber++) {
			this.page.element(Locators.RESOURCECHECKBOX + resourcevalues[resourceNumber] +Locators.CLOSINGBRACKETS, "css").getOne().sendKeys(Keys.SPACE);
			if(this.page.element(Locators.RESOURCECHECKBOX + resourcevalues[resourceNumber] +Locators.CLOSINGBRACKETS, "css").getOne().isSelected() == false) {
				this.page.element(Locators.RESOURCECHECKBOX + resourcevalues[resourceNumber] +Locators.CLOSINGBRACKETS, "css").getOne().click();
			}
			if(this.page.element(Locators.RESOURCECHECKBOX + resourcevalues[resourceNumber] +Locators.CLOSINGBRACKETS, "css").getOne().isSelected() == false) {
				this.page.element(Locators.RESOURCECHECKBOX + resourcevalues[resourceNumber] +Locators.CLOSINGBRACKETS, "css").Click();
			}
			assertTrue(this.page.element(Locators.RESOURCECHECKBOX + resourcevalues[resourceNumber] +Locators.CLOSINGBRACKETS, "css").getOne().isSelected());
		}
		return this;
	}

	public OtherRegionList verifySaveOptionExistOnEditOtherRegionSecurityResourcesPage() throws Exception {
		waitForElement.waitForElements(Locators.SAVE, "css");
		assertTrue(this.page.element(Locators.SAVE, "css").isElementPresent()
				, "Save button is not displayed on Edit Other Region Security - Resources page ");
		return this;
	}

	public OtherRegionList navigateToOnSaveOptionOnEditOtherRegionSecurityResourcesPage() throws Exception {
		waitForElement.waitForElements(Locators.SAVE, "css");
		this.page.element(Locators.SAVE, "css").clickUsingJSE();
		return this;
	}

	public OtherRegionList verifyResourceUnderEditOtherRegionSecurityResourcesAreSelectedAndDisabled(String[] resourcevalues) throws Exception {
		for (int resourceNumber = 0; resourceNumber < resourcevalues.length; resourceNumber++) {
			waitForElement.waitForElements(Locators.RESOURCECHECKBOX + resourcevalues[resourceNumber] +Locators.CLOSINGBRACKETS+Locators.USER_RESOURCECHECKBOX, "css");
			assertFalse(this.page.element(Locators.RESOURCECHECKBOX + resourcevalues[resourceNumber] +Locators.CLOSINGBRACKETS+Locators.USER_RESOURCECHECKBOX, "css").getOne().isEnabled());
			assertTrue(this.page.element(Locators.RESOURCECHECKBOX + resourcevalues[resourceNumber] +Locators.CLOSINGBRACKETS+Locators.USER_RESOURCECHECKBOX, "css").getOne().isSelected());
		}
		return this;
	}

	public OtherRegionList verifyBackOptionExistOnEditOtherRegionSecurityResourcesPage() throws Exception {
		waitForElement.waitForElements(Locators.BACK, "css");
		assertTrue(this.page.element(Locators.BACK, "css").isElementPresent()
				, "Back button is not displayed on Edit Other Region Security - Resources page ");
		return this;
	}

	public OtherRegionList navigateOnBackOptionOnEditOtherRegionSecurityResourcesPage() throws Exception {
		waitForElement.waitForElements(Locators.BACK, "css");
		this.page.element(Locators.BACK, "css").clickUsingJSE();
		return this;
	}
	
	public OtherRegionList verifyViewOtherRegionSecurityResourcesIsDisplayed() throws Exception {
		waitForElement.waitForElements(Locators.VIEW_OTHER_REGION_SECURITY_RESOURCES, "xpath");
		assertTrue(this.page.element(Locators.VIEW_OTHER_REGION_SECURITY_RESOURCES, "xpath").isElementPresent()
				, "View Other Region Security - Resources page is not displayed");
		return this;
	}
		
	public OtherRegionList VerifySystemAdminCanShareResourcesOnOtherRegionList(String[] resourcevalues ) throws Exception {
		this.verifyShareResourcesOption();
		this.navigateToEditOtherRegionSecurityResourcesPage();
		this.verifyEditOtherRegionSecurityResourcesPageIsDisplayed();
		this.selectResourceUnderEditOtherRegionSecurityResources(resourcevalues);
		this.navigateToOnSaveOptionOnEditOtherRegionSecurityResourcesPage();
		return this;
	}
	public OtherRegionList VerifyUserCannotShareResourcesOnOtherRegionList(String[] resourcevalues) throws Exception {
		this.verifyShareResourcesOption();
		this.navigateToEditOtherRegionSecurityResourcesPage();
		this.verifyViewOtherRegionSecurityResourcesIsDisplayed();
		this.verifyResourceUnderEditOtherRegionSecurityResourcesAreSelectedAndDisabled(resourcevalues);
		this.verifyBackOptionExistOnEditOtherRegionSecurityResourcesPage();
		this.navigateOnBackOptionOnEditOtherRegionSecurityResourcesPage();
		return this;
	}

	public OtherRegionList verifySharedStatusTypeButtonIsAvailable()throws Exception {
		waitForElement.waitForElements(Locators.SHAREDSTATUSTYPEBUTTON, "xpath");
		assertTrue(this.page.element(Locators.SHAREDSTATUSTYPEBUTTON, "xpath").isElementPresent(), "Shared Status Type Button is not available");
		return this;
	}

	public OtherRegionList clickSharedStatusTypeButton()throws Exception {
		waitForElement.waitForElements(Locators.SHAREDSTATUSTYPEBUTTON, "xpath");
		this.page.element(Locators.SHAREDSTATUSTYPEBUTTON, "xpath").clickUsingJSE();
		return this;
	}

	public OtherRegionList navigateBackToOtherRegionListFromViewOtherRegionSecurityStatusTypes() throws Exception {
		waitForElement.waitForElements(Locators.BACK, "css");
		this.page.element(Locators.BACK, "css").clickUsingJSE();
		return this;
	}
	
	public OtherRegionList verifyStatusTypesAreDisabled(String shareStatusValues,String roleStatusValues,String privateStatusValues) throws Exception {
		this.navigateToEditOtherRegionSecurityStatusTypes();
		this.verifySharedStatusTypeIsSelectedAndDisabled(shareStatusValues);
		this.verifyRoleBasedStatusTypeIsSelectedAndDisabled(roleStatusValues);
		this.verifyPrivateStatusTypeIsNotAvailable(privateStatusValues);
		this.navigateBackToOtherRegionListFromViewOtherRegionSecurityStatusTypes();
		return this;
	}
	
	public OtherRegionList verifyRoleBasedStatusTypeIsSelectedAndEnabledAndSave(String roleStatusValues) throws Exception {
		this.navigateToEditOtherRegionSecurityStatusTypes();
		this.verifyRoleBasedStatusTypeIsSelectedAndEnabled(roleStatusValues);
		this.clickOnSave();
		return this;
	}
	
	public OtherRegionList verifyStatusTypesCanSelected(String shareStatusValues,String roleStatusValues,String privateStatusValues) throws Exception {
		this.verifySharedStatusTypeOptionIsAvailable();
		this.navigateToEditOtherRegionSecurityStatusTypes();
		this.verifySharedStatusTypeIsSelectedAndEnabled(shareStatusValues);
		this.verifyRoleBasedStatusTypeIsDeselectedAndEnabled(roleStatusValues);
		this.verifyPrivateStatusTypeIsNotAvailable(privateStatusValues);
		this.selectRoleBasedStatusType(roleStatusValues);
		this.clickOnSave();
		return this;
	}
	
}