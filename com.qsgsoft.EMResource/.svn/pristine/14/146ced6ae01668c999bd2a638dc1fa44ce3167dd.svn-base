package EMR.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import qaFramework.WaitTimeConstants;
import qaFramework.UserDefinedFunctions.Date_Time_settings;
import qaFramework.UserDefinedFunctions.WaitForElement;
import qaFramework.pageObject.PageObject;
import EMR.Locators.ConfigureNewRelationship.Locators;

public class ConfigureNewRelationship extends PageObject {
	
	WebDriver driver;
	WaitForElement waitForElement ;
	Login login;
	OtherRegionList otherRegion;
	Shared navigateTo;
	Date_Time_settings dts;
	SelectRegion selectRegion;
	
	public ConfigureNewRelationship(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		waitForElement = new WaitForElement(this.driver);
		login = new Login(this.driver);
		otherRegion=new OtherRegionList(this.driver);
		navigateTo= new Shared(this.driver);
		dts= new Date_Time_settings();
		selectRegion = new SelectRegion(this.driver);
	}
	
	public ConfigureNewRelationship verifyConfigureNewRelationShipPage()
			throws Exception {
		waitForElement.waitForElements(Locators.CONFIGNEWRELTION, "xpath");
		assertTrue(this.page.element(Locators.CONFIGNEWRELTION, "xpath").getOne()
				.isDisplayed(), "Conifgure New ");
		return this;

	}
	
	public ConfigureNewRelationship verifyReciprocalCheckBoxIsSelected() throws Exception {
		waitForElement.waitForElements(Locators.RECIPROCAL, "css");
		assertTrue(this.page.element(Locators.RECIPROCAL, "css").getOne()
				.isDisplayed(), "Reciprocal cheack box is not present");
		assertTrue(
				this.page.element(Locators.RECIPROCAL, "css").getOne().isSelected(),
				"By default RECIPROCAL check box is not selected");
		return this;

	}
	
	public ConfigureNewRelationship selectRegionForMutualAidAgreement(
			String region) throws Exception {
		waitForElement.waitForElements(Locators.SELECT_REGION_DROP_DOWN, "id");
		this.page.element(Locators.SELECT_REGION_DROP_DOWN, "id").webElementToSelect()
				.selectByVisibleText(region);
		String selectedRegion = this.page.element(Locators.SELECT_REGION_DROP_DOWN, "id")
				.webElementToSelect().getFirstSelectedOption().getText();
		System.out.println(selectedRegion);
		assertEquals(region, selectedRegion,
				"Region name is not same as selected one");
		return this;
	}
	
	public ConfigureNewRelationship clickOnSave() throws Exception {
		waitForElement.waitForElements(Locators.SAVE, "css");
		this.page.element(Locators.SAVE, "css").getOne().click();
		waitForElement.waitForElements(Locators.NOTIFICATION, "css");
		return this;
	}

	public ConfigureNewRelationship verifyMutualAidRelationshipNotification(
			String region) throws Exception {

		String notification = Locators.MUTUALAIDCREATEDMESSAGEPART1
				+ region + Locators.MUTUALAIDCREATEDMESSAGEPART2;
		waitForElement.waitForElements(notification, "xpath");
		assertTrue(this.page.element(notification, "xpath").getOne()
				.isDisplayed(),
				"Thier is no succesfull notification is displayed in HEADER for mutual aid");
		return this;
	}
	
	public ConfigureNewRelationship verifyNewMutualAidAgreementText() throws Exception {
		String mutualAidText = Locators.NEW_MUTUAL_AID_AGREEMENT_TEXT;
		waitForElement.waitForElements(mutualAidText, "xpath");
		assertTrue(this.page.element(mutualAidText, "xpath").isElementPresent());
		assertTrue(this.page.element(mutualAidText, "xpath").getOne().isDisplayed());
		return this;
	}
	
	public ConfigureNewRelationship createMutualAidAgreement(
			String region) throws Exception {
		otherRegion.clickOnCreatNewRelation();
		this.verifyConfigureNewRelationShipPage();
		this.selectRegionForMutualAidAgreement(region);
		this.verifyReciprocalCheckBoxIsSelected();
		this.clickOnSave();
		this.verifyMutualAidRelationshipNotification(region);
		return this;
	}
	
	public String createNewRelationShip(String region2) throws Exception {
		otherRegion.clickOnCreatNewRelation();
		this.verifyConfigureNewRelationShipPage();
		this.verifyNewMutualAidAgreementText();
		this.verifyReciprocalCheckBoxIsSelected();
		this.selectRegionForMutualAidAgreement(region2);
		this.clickOnSave();
		this.verifyMutualAidRelationshipNotification(region2);
		String applicationTime = navigateTo.getApplicationTime();
		String currentYear = dts.getCurrentDate("yyyy");
		applicationTime = applicationTime + " " + currentYear;
		applicationTime = dts.converDateFormat(applicationTime,
				"dd MMM HH:mm yyyy", "yyyy-MM-dd");
		System.out.println("added time"+   applicationTime);
		return applicationTime;
	}
	
	public ConfigureNewRelationship verifyOtherRegionDetailes(String columnNames1[],String columnNames2[]) throws Exception {
		navigateTo.otherRegion();
		otherRegion.verifyOtherRegionPage();
		otherRegion.verifyColumnNamesUnderRegionCanViewSection(columnNames1);
		otherRegion.verifyColumnNamesUnderCanViewSection(columnNames2);
		otherRegion.verifyCreatNewRelationButton();
		return this;
	}
	
	public ConfigureNewRelationship deleteMutualAidRelation(String regionName1,
			String regionName2) throws Exception {

		selectRegion.selectRegionAndClickOnNext(regionName1);
		navigateTo.otherRegion();
		String mutualRegion = Locators.TABLE_HEADERS_OF_REGIONS_CAN_VIEW_SECTION
				+ regionName2 + Locators.CLOSEBRACKETS;
		waitForElement.waitForElements(Locators.CREATE_RELATION, "css");
		if (this.page.element(mutualRegion, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_TOO_SMALL)) {
			String previousLink = Locators.TABLE_HEADERS_OF_REGIONS_CAN_VIEW_SECTION + regionName2 + Locators.PREVIOUSLINK_OF_REGION_UNDER_REGION_CAN_VIEW_SECTION;
			
			String links = this.page.element(previousLink, "xpath").getOne().getText();
			final String unverify = "unverify", verify = "verify", deactivate = "deactivate";

			switch (links) {
			case unverify:
				otherRegion.unverifyRegionAgreements(regionName2)
						.deleteMutualAidRelationship(regionName2)
						.verifyMutualAidRelationDeletedTextHeader(regionName2);
				break;
			case verify:
				otherRegion.deleteMutualAidRelationship(regionName2)
						   .verifyMutualAidRelationDeletedTextHeader(regionName2);
				break;
			case deactivate:
				otherRegion.deactivateRegionAgreement(regionName2)
						.unverifyRegionAgreements(regionName2)
						.deleteMutualAidRelationship(regionName2)
						.verifyMutualAidRelationDeletedTextHeader(regionName2);
				break;
			}
		}
		assertFalse(this.page.element(mutualRegion, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	public ConfigureNewRelationship deleteExistingMutualAidRelationShip(
			String regionName1, String regionName2) throws Exception {

		this.deleteMutualAidRelation(regionName1, regionName2);
		this.deleteMutualAidRelation(regionName2, regionName1);
		return this;
	}
	
	public ConfigureNewRelationship verifyRegionIsUnavailabUnderSelectRegionOfConfigureNewRelationShip(String regionName2) throws Exception {
	navigateTo.otherRegion();	
	otherRegion.clickOnCreatNewRelation();
	waitForElement.waitForElements(Locators.SELECT_REGION_DROP_DOWN, "id");
	assertFalse(this.page.element(Locators.SELECT_REGION_DROPDOWN_VALUE+regionName2+Locators.CLOSEBRACKETS, "xpath").isElementPresent(
				WaitTimeConstants.WAIT_TIME_FOR_FALSE));
	   return this;
	}
	
	public ConfigureNewRelationship createNewRelationShipWithoutReciprocal(String region2) throws Exception {
		navigateTo.otherRegion();	
		otherRegion.clickOnCreatNewRelation();
		this.verifyConfigureNewRelationShipPage();
		this.verifyReciprocalCheckBoxIsSelected();
		this.selectRegionForMutualAidAgreement(region2);
		this.deselectReciprocal();
		this.clickOnSave();
		this.verifyMutualAidRelationshipNotification(region2);
		return this;
		
	}
	
	public ConfigureNewRelationship deselectReciprocal() throws Exception {
		
		waitForElement.waitForElements(Locators.RECIPROCAL, "css");
		this.page.element(Locators.RECIPROCAL, "css").mouseOver();
		this.page.element(Locators.RECIPROCAL, "css").getOne().sendKeys(Keys.SPACE);
		
		if (this.page.element(Locators.RECIPROCAL, "css").getOne().isSelected()) {
			this.page.element(Locators.RECIPROCAL, "css").mouseOver();
			this.page.element(Locators.RECIPROCAL, "css").getOne().click();
		}
		if (this.page.element(Locators.RECIPROCAL, "css").getOne().isSelected()) {
			this.page.element(Locators.RECIPROCAL, "css").mouseOver();
			this.page.element(Locators.RECIPROCAL, "css").clickUsingJSE();
			
		}
		assertTrue((!this.page.element(Locators.RECIPROCAL, "css").getOne().isSelected()), "reciprocal selected");
		return this;
	}

	public ConfigureNewRelationship createMutualAgreementIfNotCreated(String region) throws Exception {
		String mutualRegion = Locators.TABLE_HEADERS_OF_REGIONS_CAN_VIEW_SECTION + region + Locators.CLOSEBRACKETS;
		if(this.page.element(mutualRegion, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE)== false){
			otherRegion.clickOnCreatNewRelation();
			this.verifyConfigureNewRelationShipPage();
			this.selectRegionForMutualAidAgreement(region);
			this.verifyReciprocalCheckBoxIsSelected();
			this.clickOnSave();
			this.verifyMutualAidRelationshipNotification(region);
		}
		waitForElement.waitForElements(Locators.CREATE_RELATION, "css");
		if (this.page.element(mutualRegion, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_TOO_SMALL)) {
			String previousLink = Locators.TABLE_HEADERS_OF_REGIONS_CAN_VIEW_SECTION + region + Locators.PREVIOUSLINK_OF_REGION_UNDER_REGION_CAN_VIEW_SECTION;
			String links = this.page.element(previousLink, "xpath").getOne().getText();
			final String unverify = "unverify", verify = "verify", deactivate = "deactivate";
			switch (links) {
			case verify:
				otherRegion.clickOnVerify(region)
				.verifyMutualAidRelationVerifiedTextHeader(region)
				.verifyActivateOptionExists(region)
				.activateMutualAgreementWithRegion(region)
				.verifyMutualAidRelationActivatedTextHeader(region);
				break;
			case unverify:
				otherRegion.activateMutualAgreementWithRegion(region)
				.verifyMutualAidRelationActivatedTextHeader(region);
				break;
			case deactivate:
				System.out.println("Mutual agreement exists between regions.");
				break;
			}
		}
		return this;
	}
	
	public ConfigureNewRelationship deleteMutualAidRelation(String regionName) throws Exception {
		String mutualRegion = Locators.TABLE_HEADERS_OF_REGIONS_CAN_VIEW_SECTION + regionName + Locators.CLOSEBRACKETS;
		waitForElement.waitForElements(Locators.CREATE_RELATION, "css");
		if (this.page.element(mutualRegion, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_TOO_SMALL)) {
			String previousLink = Locators.TABLE_HEADERS_OF_REGIONS_CAN_VIEW_SECTION + regionName + Locators.PREVIOUSLINK_OF_REGION_UNDER_REGION_CAN_VIEW_SECTION;
			
			String links = this.page.element(previousLink, "xpath").getOne().getText();
			final String unverify = "unverify", verify = "verify", deactivate = "deactivate";

			switch (links) {
			case unverify:
				otherRegion.unverifyRegionAgreements(regionName)
						.deleteMutualAidRelationship(regionName)
						.verifyMutualAidRelationDeletedTextHeader(regionName);
				break;
			case verify:
				otherRegion.deleteMutualAidRelationship(regionName)
						   .verifyMutualAidRelationDeletedTextHeader(regionName);
				break;
			case deactivate:
				otherRegion.deactivateRegionAgreement(regionName)
						.unverifyRegionAgreements(regionName)
						.deleteMutualAidRelationship(regionName)
						.verifyMutualAidRelationDeletedTextHeader(regionName);
				break;
			}
		}
		assertFalse(this.page.element(mutualRegion, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	public ConfigureNewRelationship createNewRelationshipAndVerifyAgreement(String region) throws Exception {
		this.deleteMutualAidRelation(region);
		this.createMutualAidAgreement(region);
		otherRegion.clickOnVerify(region);
		return this;
	}
	
	public ConfigureNewRelationship unverifyRegionAgreement(String regionName) throws Exception {
		String mutualRegion = Locators.TABLE_HEADERS_OF_REGIONS_CAN_VIEW_SECTION + regionName + Locators.CLOSEBRACKETS;
		waitForElement.waitForElements(Locators.CREATE_RELATION, "css");
		if (this.page.element(mutualRegion, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_TOO_SMALL)) {
			String previousLink = Locators.TABLE_HEADERS_OF_REGIONS_CAN_VIEW_SECTION + regionName + Locators.PREVIOUSLINK_OF_REGION_UNDER_REGION_CAN_VIEW_SECTION;
			
			String links = this.page.element(previousLink, "xpath").getOne().getText();
			final String unverify = "unverify", verify = "verify", deactivate = "deactivate";

			switch (links) {
			case unverify:
				otherRegion.unverifyRegionAgreements(regionName)
						   .verifyMutualAidRelationUnverifiedTextHeader(regionName)
						   .verifyVerifyOptionExists(regionName);
				break;
			case verify:
				break;
			case deactivate:
				otherRegion.deactivateRegionAgreement(regionName)
						   .verifyMutualAidRelationDeactivateTextHeader(regionName)
						   .verifyUnVerifyOptionExists(regionName)
						   .unverifyRegionAgreements(regionName)
						   .verifyMutualAidRelationUnverifiedTextHeader(regionName)
						   .verifyVerifyOptionExists(regionName);
				break;
			}
		}
		return this;
	}
}