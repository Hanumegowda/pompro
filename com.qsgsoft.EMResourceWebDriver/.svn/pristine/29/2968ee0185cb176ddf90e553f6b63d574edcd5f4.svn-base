package lib.page;

import static org.testng.Assert.*;
import lib.module.NavigationToSubMenus;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import qaframework.lib.WaitTimeConstants;
import qaframework.lib.UserDefinedFunctions.WaitForElement;
import qaframework.lib.pageObject.PageObject;

public class OtherRegions extends PageObject {
	
	WebDriver driver;
	WaitForElement objWaitForElement;

	public OtherRegions(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
	}
	
	private String strshareStausTypes = "input[value='Share Status Types']",
			       strheader = "div#topSubNav > h1",
			       strShareResources = "input[value='Share Resources']",
			       backButton =  "input[value='Back']",
			       resourceTableCheckBox = "//table[@id='tbl_resourceID']//input[@value='resourceID'][@name='SELECT_ALL']",
			       userTableCheckBox = "//table[@id='tbl_userID']//input[@value ='userID'][@name='SELECT_ALL']",
			       statusTypeCheckBox = "//div[@id='statusTypeID']//input[@class='toggleAll'][@type='checkbox']",
			       viewOtherRegionStatusTypes = "//div[@id='topSubNav']/h1[text()='View Other Region Security - Status Types']",
			       viewOtherRegionResources = "//div[@id='topSubNav']/h1[text()='View Other Region Security - Resources']",
			       otherRegionListPage = "//div[@id='topSubNav']/h1[text()='Other Region List']",
			       save = "input[value='Save']",
			       otherRegions = "Other Regions";
			    		   
	
	/**********************************************************************************
	  * Description : This function is to click on facilities
	  * Arguments	: strFacilityName
	  * Date        : 03/11/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public OtherRegions clickOnFacility(String strFacilityName)
			throws Exception {
		objWaitForElement.waitForElements("//a[@class='viewDetails'][text()='" + strFacilityName
				+ "']", "xpath");
		this.page
				.element(
						"//a[@class='viewDetails'][text()='" + strFacilityName
						+ "']", "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify incident name in 'Incident command system'
	  * Arguments	: strIncidentName, strIncidentDes
	  * Date        : 03/11/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public OtherRegions verIncidentNameInIncidentCommandSystem(
			String strIncidentName, String strIncidentDes) throws Exception {
		objWaitForElement.waitForElements("//form[@id='form1']/div/h2[text()='" + strIncidentName
				+ "']/following-sibling::div[text()='"
				+ strIncidentDes + "']", "xpath");
		assertTrue(this.page
				.element(
						"//form[@id='form1']/div/h2[text()='" + strIncidentName
								+ "']/following-sibling::div[text()='"
								+ strIncidentDes + "']", "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Shared Status Types' button
	 * Date        : 09/06/2014
	 * Author      : Anil
	 **********************************************************************************/
	public OtherRegions clickSharedStatusTypes() throws Exception {
		objWaitForElement.waitForElements(strshareStausTypes, "css");
		this.page.element(strshareStausTypes, "css").getOne().click();
		return this;
	}
	/*******************************************************************************
	 * Description : This function is to verify event template list screen.
	 * Date        : 13/08/2014
	 * Author      : Renushree
	*******************************************************************************/	
	public OtherRegions verEditOtherRegionSecurityScreenIsDisplayed() throws Exception {
		objWaitForElement.waitForElements(strheader, "css");
		assertEquals("Edit Other Region Security - Status Types", this.page.element(strheader, "css")
				.getOne().getText());
		return this;
	}
	
	/*******************************************************************************
	 * Description : This function is to verify event Associated Icon corresponding 
	 * 				 to the Resource as 'Amber Alert / Missing Child'
	 * Date        : 24-Mar-2015
	 * Author      : Pallavi
	*******************************************************************************/	
	public OtherRegions verEventIconDispCorrespondingToRes(
			String strResourceName, String strEventTempIcon) throws Exception {
		objWaitForElement.waitForElement("//tbody/tr/td/a[text()='"
				+ strResourceName
				+ "']/following-sibling::a/img[@src='"+strEventTempIcon+"']",
				"xpath");
		assertTrue(this.page
				.element(
						"//tbody/tr/td/a[text()='"
								+ strResourceName
								+ "']/following-sibling::a/img[@src='"+strEventTempIcon+"']",
						"xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on  View agreement region link
	 * Date        : 09/06/2014
	 * Author      : Anil
	 **********************************************************************************/
	public OtherRegions clickOnViewAgreement(String strRegionName) throws Exception {
		objWaitForElement.waitForElements("//td[text()='"+strRegionName+"']/preceding-sibling::td/a[text()='view agreement']", "xpath");
		this.page.element("//td[text()='"+strRegionName+"']/preceding-sibling::td/a[text()='view agreement']", "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on  assign users link
	 * Date        : 09/06/2014
	 * Author      : Anil
	 **********************************************************************************/
	public OtherRegions clickOnAssignUsers(String strRegionName) throws Exception {
		objWaitForElement.waitForElements("//td[text()='"+strRegionName+"']/preceding-sibling::td/a[text()='assign users']", "xpath");
		this.page.element("//td[text()='"+strRegionName+"']/preceding-sibling::td/a[text()='assign users']", "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Shared Resources' button
	 * Date        : 09/06/2014
	 * Author      : Anil
	 **********************************************************************************/
	public OtherRegions clickSharedResources() throws Exception {
		objWaitForElement.waitForElements(strShareResources, "css");
		this.page.element(strShareResources, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Back' button
	 * Date        : 09/06/2014
	 * Author      : Anil
	 **********************************************************************************/
	public OtherRegions clickBackButton() throws Exception {
		objWaitForElement.waitForElements(backButton, "css");
		this.page.element(backButton, "css").mouseOver();
		this.page.element(backButton, "css").getOne().sendKeys(Keys.ENTER);
		return this;
	}
	
	/*******************************************************************************
	 * Description : This function is to verify resource table checkbox is enabled
	 * Date        : 24-Mar-2015
	 * Author      : Anil
	*******************************************************************************/	
	public OtherRegions verifyResourceTable() throws Exception {
		objWaitForElement.waitForElement(resourceTableCheckBox,
				"xpath");
		assertTrue(this.page
				.element(resourceTableCheckBox,
						"xpath").getOne().isDisplayed());
		return this;
	}
	
	
	/*******************************************************************************
	 * Description : This function is to verify user table checkbox is enabled
	 * Date        : 24-Mar-2015
	 * Author      : Anil
	*******************************************************************************/	
	public OtherRegions verifyUserTableCheckBox() throws Exception {
		objWaitForElement.waitForElement(userTableCheckBox,
				"xpath");
		assertTrue(this.page
				.element(userTableCheckBox,
						"xpath").getOne().isDisplayed());
		return this;
	}
	
	/*******************************************************************************
	 * Description : This function is to verify user table checkbox is enabled
	 * Date        : 24-Mar-2015
	 * Author      : Anil
	*******************************************************************************/	
	public OtherRegions verifyStatusTypeTableCheckBox() throws Exception {
		objWaitForElement.waitForElement(statusTypeCheckBox,
				"xpath");
		assertTrue(this.page
				.element(statusTypeCheckBox,
						"xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify Other Region Shared Status Type Page
	  * Date        : 03/11/2014
	  * Author      : Anil
	  **********************************************************************************/
	public OtherRegions verifyOtherRegionSharedStatusTypePage() throws Exception {
		objWaitForElement.waitForElements(viewOtherRegionStatusTypes, "xpath");
		assertTrue(this.page
				.element(viewOtherRegionStatusTypes, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify Other Region Shared resource Page
	  * Date        : 03/11/2014
	  * Author      : Anil
	  **********************************************************************************/
	public OtherRegions verifyOtherRegionSharedResourcesPage() throws Exception {
		objWaitForElement.waitForElements(viewOtherRegionResources, "xpath");
		assertTrue(this.page
				.element(viewOtherRegionResources, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify Other Region Shared resource Page
	  * Date        : 03/11/2014
	  * Author      : Anil
	  **********************************************************************************/
	public OtherRegions verifyOtherRegionListPage() throws Exception {
		objWaitForElement.waitForElements(otherRegionListPage, "xpath");
		assertTrue(this.page
				.element(otherRegionListPage, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify Other Region Shared user Page
	  * Date        : 03/11/2014
	  * Author      : Anil
	  **********************************************************************************/
	public OtherRegions verifyOtherRegionUsersPage(String strRegionName)
			throws Exception {
		objWaitForElement.waitForElements(
				"//div[@id='topSubNav']/h1[text()='Assign Users to "
						+ strRegionName + "']", "xpath");
		assertTrue(this.page
				.element(
						"//div[@id='topSubNav']/h1[text()='Assign Users to view "
								+ strRegionName + " region']", "xpath")
				.getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify Other Region Shared user Page
	  * Date        : 03/11/2014
	  * Author      : Anil
	  **********************************************************************************/
	public OtherRegions verifyOtherRegionUsersPage(String strRegionName1, String strRegionName2) throws Exception {
		String strOne = this.page
		.element("//pre", "xpath").getOne().getText();
		assertEquals(strOne,strRegionName1+"/"+strRegionName2+" contract on file." );
		
//		objWaitForElement.waitForElements("//pre[text()='"+strRegionName1+"/"+strRegionName2+" contract on file.']", "xpath");
//		assertTrue(this.page
//				.element("//pre[text()='"+strRegionName1+"/"+strRegionName2+" contract on file.']", "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Shared Resources' button is present
	 * Date        : 16/Jun/2015
	 * Author      : Renushree
	 **********************************************************************************/
	public OtherRegions verSharedResourcesBtnPresent() throws Exception {
		objWaitForElement.waitForElements(strShareResources, "css");
		assertTrue(this.page.element(strShareResources, "css")
				.isElementPresent(),
				"Shared Resources button is not dispalyed.");
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify 'Shared Status Types' button is present
	 * Date        : 16/Jun/2015
	 * Author      : Renushree
	 **********************************************************************************/
	public OtherRegions verSharedStatusTypesBtnPresent() throws Exception {
		objWaitForElement.waitForElements(strshareStausTypes, "css");
		assertTrue(this.page.element(strshareStausTypes, "css")
				.isElementPresent(),
				"Shared Status Types button is not dispalyed.");
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify update agreement link available.
	 * Date        : 16/Jun/2015
	 * Author      : Renushree
	 **********************************************************************************/
	public OtherRegions verUpdateAgreementAvailable(String strOtherRegion)
			throws Exception {
		objWaitForElement
				.waitForElements(
						"//table[@summary='Other Regions']/tbody/tr/td[text()='"
								+ strOtherRegion
								+ "']/preceding-sibling::td/a[text()='update agreement']",
						"xpath");
		assertTrue(
				this.page
						.element(
								"//table[@summary='Other Regions']/tbody/tr/td[text()='"
										+ strOtherRegion
										+ "']/preceding-sibling::td/a[text()='update agreement']",
								"xpath").isElementPresent(),
				"Shared Status Types button is not dispalyed.");
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify view agreement link available.
	 * Date        : 16/Jun/2015
	 * Author      : Renushree
	 **********************************************************************************/
	public OtherRegions verViewAgreementAvailable(String strOtherRegion)
			throws Exception {
		objWaitForElement
				.waitForElements(
						"//table[@summary='Other Regions']/tbody/tr/td[text()='"
								+ strOtherRegion
								+ "']/preceding-sibling::td/a[text()='view agreement']",
						"xpath");
		assertTrue(
				this.page
						.element(
								"//table[@summary='Other Regions']/tbody/tr/td[text()='"
										+ strOtherRegion
										+ "']/preceding-sibling::td/a[text()='view agreement']",
								"xpath").isElementPresent(),
				"Shared Status Types button is not dispalyed.");
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify update agreement link available.
	 * Date        : 16/Jun/2015
	 * Author      : Renushree
	 **********************************************************************************/
	public OtherRegions verAssignUsersAvailable(String strOtherRegion)
			throws Exception {
		objWaitForElement
				.waitForElements(
						"//table[@summary='Other Regions']/tbody/tr/td[text()='"
								+ strOtherRegion
								+ "']/preceding-sibling::td/a[text()='assign users']",
						"xpath");
		assertTrue(
				this.page
						.element(
								"//table[@summary='Other Regions']/tbody/tr/td[text()='"
										+ strOtherRegion
										+ "']/preceding-sibling::td/a[text()='assign users']",
								"xpath").isElementPresent(),
				"Shared Status Types button is not dispalyed.");
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify update agreement link not available.
	 * Date        : 16/Jun/2015
	 * Author      : Renushree
	 **********************************************************************************/
	public OtherRegions verUpdateAgreementNotAvailable(String strOtherRegion)
			throws Exception {
		assertFalse(
				this.page
						.element(
								"//table[@summary='Other Regions']/tbody/tr/td[text()='"
										+ strOtherRegion
										+ "']/preceding-sibling::td/a[text()='update agreement']",
								"xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE),
				"Shared Status Types button is dispalyed.");
		return this;
	}
	
	/*******************************************************************************
	 * Description : This function is to verify Edit Other Region Security - Resources
	 * Date        : 16/Jun/2015
	 * Author      : Renushree
	*******************************************************************************/	
	public OtherRegions verEditOtherRegionSecurityResourcesScreenIsDisplayed() throws Exception {
		objWaitForElement.waitForElements(strheader, "css");
		assertEquals("Edit Other Region Security - Resources", this.page.element(strheader, "css")
				.getOne().getText());
		return this;
	}
	
	/*******************************************************************************
	 * Description : This function is to verify resource listed in Edit Other Region Security - Resources
	 * Argument	   : strResource, strResorceType
	 * Date        : 16/Jun/2015
	 * Author      : Renushree
	*******************************************************************************/	
	public OtherRegions verResourcesListedInEditOtherRegionSecResScreen(
			String strResource, String strResorceType) throws Exception {
		assertTrue(
				this.page.element(
						"//table[@id='tbl_resourceID']/tbody/tr/td[text()='"
								+ strResource
								+ "']/following-sibling::td[text()='"
								+ strResorceType + "']", "xpath")
						.isElementPresent(),
				"Resource not listed in Edit Other Region Security - Resources.");
		return this;
	}
	
	/*******************************************************************************
	 * Description : This function is to select resource in Edit Other Region Security - Resources
	 * Argument	   : strResourceVal
	 * Date        : 16/Jun/2015
	 * Author      : Renushree
	*******************************************************************************/	
	public OtherRegions selResourceInEditOtherRegionSecResScreen(
			String strResourceValue) throws Exception {
		objWaitForElement.waitForElements("input[value='" + strResourceValue
				+ "'][name='resourceID']", "css");
		if(this.page
				.element(
						"input[value='" + strResourceValue
								+ "'][name='resourceID']", "css").getOne().isSelected()==false){
			this.page
			.element(
					"input[value='" + strResourceValue
							+ "'][name='resourceID']", "css").getOne()
			.click();
		}
		return this;
	}
	
	/*******************************************************************************
	 * Description : This function is to click on save
	 * Date        : 16/Jun/2015
	 * Author      : Renushree
	*******************************************************************************/	
	public OtherRegions clickOnSave() throws Exception {
		objWaitForElement.waitForElements(save, "css");
		this.page.element(save, "css").getOne().click();
		return this;
	}
	
	/*******************************************************************************
	 * Description : This function is to verify resource in Edit Other Region Security - Resources selected
	 * Argument	   : strResourceVal
	 * Date        : 16/Jun/2015
	 * Author      : Renushree
	*******************************************************************************/	
	public OtherRegions verResourceInEditOtherRegionSecResScreenSelected(
			String strResourceValue) throws Exception {
		objWaitForElement.waitForElements("input[value='" + strResourceValue
				+ "'][name='resourceID']", "css");
		assertTrue(
				this.page
						.element(
								"input[value='" + strResourceValue
										+ "'][name='resourceID']", "css")
						.getOne().isSelected(), "Resource not selected");
		return this;
	}
	
	/*******************************************************************************
	 * Description : This function is to verify resource selected and disabled in in View Other Region Security - Resources
	 * Argument	   : strResourceVal
	 * Date        : 16/Jun/2015
	 * Author      : Renushree
	*******************************************************************************/	
	public OtherRegions verResSelectedAndDisabledInViewOtherRegionSecurityRes(
			String strResourceValue) throws Exception {
		objWaitForElement.waitForElements("input[value='" + strResourceValue
				+ "'][name='resourceID']", "css");
		assertTrue(
				this.page.element(
						"input[value='" + strResourceValue
								+ "'][name='resourceID'][disabled='disabled']",
						"css").isElementPresent(),
				"Resource not slected and not disabled");
		return this;
	}
	
	/*******************************************************************************
	 * Description : This function is to verify status type listed in Edit Other Region Security - Status Types
	 * Argument	   : strStatusType
	 * Date        : 16/Jun/2015
	 * Author      : Renushree
	*******************************************************************************/	
	public OtherRegions verStatusTypeInEditOtherRegionSecurityStatusTypes(
			String strStatusType) throws Exception {
		assertTrue(
				this.page.element(
						"//div[@id='statusTypeID']/div/table/tbody/tr/td/a[contains(text(),'"
								+ strStatusType + "')]", "xpath")
						.isElementPresent(),
				"status type not listed in Edit Other Region Security - Status Types.");
		return this;
	}

	/*******************************************************************************
	 * Description : This function is to verify status type in Edit Other Region Security - Status Types selected
	 * Argument	   : strResourceVal
	 * Date        : 16/Jun/2015
	 * Author      : Renushree
	*******************************************************************************/	
	public OtherRegions verStatusTypeInEditOtherRegionSecurityStatusTypesSelected(
			String strStatusTypeValue) throws Exception {
		objWaitForElement.waitForElements("input[value='" + strStatusTypeValue
				+ "'][name='statusTypeID']", "css");
		assertTrue(
				this.page
						.element(
								"input[value='" + strStatusTypeValue
										+ "'][name='statusTypeID']", "css")
						.getOne().isSelected(), "Resource not selected");
		return this;
	}
	
	/*******************************************************************************
	 * Description : This function is to verify status type not listed in Edit Other Region Security - Status Types
	 * Argument	   : strStatusType
	 * Date        : 16/Jun/2015
	 * Author      : Renushree
	*******************************************************************************/	
	public OtherRegions verStatusTypeNotInEditOtherRegionSecurityStatusTypes(
			String strStatusType) throws Exception {
		assertFalse(
				this.page.element(
						"//div[@id='statusTypeID']/div/table/tbody/tr/td/a[contains(text(),'"
								+ strStatusType + "')]", "xpath")
						.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE),
				"Status type listed in Edit Other Region Security - Status Types.");
		return this;
	}
	
	/*******************************************************************************
	 * Description : This function is to select status type in Edit Other Region Security - Status Types
	 * Argument	   : strResourceVal
	 * Date        : 16/Jun/2015
	 * Author      : Renushree
	*******************************************************************************/	
	public OtherRegions selStatusTypeInEditOtherRegionSecurityStatusTypes(
			String strStatusTypeValue) throws Exception {
		objWaitForElement.waitForElements("input[value='" + strStatusTypeValue
				+ "'][name='statusTypeID']", "css");
		if (this.page
				.element(
						"input[value='" + strStatusTypeValue
								+ "'][name='statusTypeID']", "css").getOne()
				.isSelected() == false) {
			this.page
					.element(
							"input[value='" + strStatusTypeValue
									+ "'][name='statusTypeID']", "css")
					.getOne().click();
		}
		return this;
	}
	
	/*******************************************************************************
	 * Description : This function is to verify status types selected and disabled in in View Other Region Security - Resources
	 * Argument	   : strSTValue
	 * Date        : 16/Jun/2015
	 * Author      : Renushree
	*******************************************************************************/	
	public OtherRegions verSTSelectedAndDisabledInViewOtherRegionSecurityS(
			String strSTValue) throws Exception {
		objWaitForElement.waitForElements("input[value='" + strSTValue
				+ "'][name='statusTypeID']", "css");
		assertTrue(
				this.page.element(
						"input[value='" + strSTValue
								+ "'][name='statusTypeID'][disabled='disabled']",
						"css").isElementPresent(),
				"ST not slected and not disabled");
		return this;
	}
	
	/*******************************************************************************
	 * Description : This function is to select status type in Edit Other Region Security - Status Types
	 * Argument	   : strResourceVal
	 * Date        : 16/Jun/2015
	 * Author      : Renushree
	*******************************************************************************/	
	public OtherRegions verifyOtherRegionViewsRegionList(
			String[] strRegionValue) throws Exception {
		objWaitForElement.waitForElements(strRegionValue[1], "linkText");
		for(int intCount=0; intCount<strRegionValue.length; intCount++){
			assertTrue(this.page
			.element(strRegionValue[intCount], "linktext").getOne().isDisplayed());
		}
		return this;
	}
	
	
	/**********************************************************************************
	  * Description : This function is to navigate to Region under other regions menu
	  * Date        : 07/10/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public OtherRegions navigateToRegUnderOtherRegions() throws Exception {
		objWaitForElement.waitForElements(otherRegions, "linktext");
		this.page.element(otherRegions, "linktext").getOne().click();
		return this;
	}
	
	/*******************************************************************************
	 * Description : This function is to select region for manage users
	 * Argument	   : strResourceVal
	 * Date        : 12/May/2016
	 * Author      : Sangappa k
	*******************************************************************************/	
	public OtherRegions selRegionToManageUsers(String strRegion)
			throws Exception {

		String manageRegion = "//td[text()='"+strRegion+"']/preceding-sibling::td/a[text()='manage users']";
		objWaitForElement.waitForElements(manageRegion, "xpath");
		this.page.element(manageRegion, "xpath").mouseOver();
		this.page.element(manageRegion, "xpath").getOne().click();

		return this;
	}
	
	/*******************************************************************************
	 * Description : This function is to assign users region page is displayed
	 * Argument	   : strStatusType
	 * Date        : 12/May/2016
	 * Author      : Sangappa k
	*******************************************************************************/	
	public OtherRegions assgnUserToRegion(String strRegion)
			throws Exception {

		String manageRegion = "//td[text()='"+strRegion+"']/preceding-sibling::td/input";
		objWaitForElement.waitForElements(manageRegion, "xpath");

		if (this.page.element(manageRegion, "xpath").getOne().isSelected() == false) {
			this.page.element(manageRegion, "xpath").getOne().click();
		}
		return this;
	
	}	
}