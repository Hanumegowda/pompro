package page;

import java.util.List;

import module.Frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import qaframework.lib.pageObject.PageObject;
import qaframework.lib.userDefinedFunctions.WaitForElement;
import static org.testng.Assert.assertTrue;

public class Groups extends PageObject{
	WebDriver driver;
	WaitForElement objWaitForElement;
	Frames objFrames;
	
	private String addGroup = "//a[text()='Add Group']",
			       addNewGroup = "//b[text()='Add New Group']",
			       groupName = "//input[@name='groupname']",
			       fullGroupName = "//input[@name='readablegroupname']",
			       groupType = "//select[@name='type']",
			       AllowedtoAccessServerCheckbox = "//td[contains(text(),'Allowed to access Server')]/..//input[@type='CHECKBOX']",
			       userFilterstoRestrictCheckbox = "//td[contains(text(),'Use Group/User filters to restrict users study list')]/..//input[@type='CHECKBOX']",
			       copyPermissionsFrom = "//td[contains(text(),'Copy permissions from:')]/..//select",
			       copy = "//input[@type='BUTTON'][@value='Copy']",
			       allowedMTFList = "//input[@type='CHECKBOX'][@name='allowed_mtf_on']",
			       allowedInstitutionNameList = "//input[@type='CHECKBOX'][@name='allowed_inst_name_on']",
			       allowedModalityList = "//input[@type='CHECKBOX'][@name='allowed_by_modality_on']",
			       groups = "img[src='/.cobalt/images/a_group_but_on.gif']",
			       allowedProjectsList = "//input[@type='CHECKBOX'][@name='allowed_projects_on']",
			       showNewStudy = "//input[@type='CHECKBOX'][@name='show_new_study_link']",
			       createNewStudies = "//input[@type='CHECKBOX'][@name='can_new_study']",
			       uploadZipFiles = "//input[@type='CHECKBOX'][@name='analyze75_upload_link']",
			       attachDocuments = "//input[@type='CHECKBOX'][@name='can_attach_documents']",
			       ViewStudyReports = "//input[@type='CHECKBOX'][@name='can_view_reports']",
			       AddNewReports = "//input[@type='CHECKBOX'][@name='can_add_reports']",
			       groupUsertoRestrict = "//input[@type='CHECKBOX'][@name='is_restricted']",
			       qcSandbox = "//input[@type='CHECKBOX'][@name='can_view_studies_QC']",
			       allowedMTFListTextBox = "//input[@type='TEXT'][@name='allowed_mtf']",
			       allowedToModifyStudies = "//input[@type='CHECKBOX'][@name='can_modify_study']",
			       allowedModalityListTextBox = "//input[@type='TEXT'][@name='allowed_by_modality']",
			       allowedInstitutionNameListTextBox = "//input[@type='TEXT'][@name='allowed_inst_name']",
			       allowedProjectsListTextBox = "//input[@type='TEXT'][@name='allowed_projects']",
			       allowedByUserReferringMDFilter = "//input[@type='CHECKBOX'][@name='allowed_by_referring_on']",
			       allowedToSignReports = "//input[@type='CHECKBOX'][@name='can_sign_reports']",
			       uploadDicomFiles = "//input[@type='CHECKBOX'][@name='dcm_upload_link']",
			       allowedToChangeReadUnreadStatusOfStudyChexckBox = "//input[@type='CHECKBOX'][@name='can_mark_study']",
			       saveChanges = "//a[text()='Save Changes']",
			       allowedToEditDICOMData = "//input[@type='CHECKBOX'][@name='can_edit_dicom_data']",
			       allowedToSplitMoveAndMergeQCStudies = "//input[@type='CHECKBOX'][@name='can_handle_studies_QC']",
			       allowedToSplitMoveAndMergeAnyStudy = "//input[@type='CHECKBOX'][@name='can_qc_modify_studies']",
			       allowedToReleaseStudiesFromQCSandbox = "//input[@type='CHECKBOX'][@name='can_release_studies_QC']",
			       allowedToBurnStudyToCDROM = "//td[contains(text(),'Allowed to burn study to CD ROM')]/following-sibling::td/input",
			       allowedToAddReplies = "input[name='can_reply_reports']",
			       allowedToAddAddendums = "//input[@type='CHECKBOX'][@name='can_create_addendum']",
			       allowedToViewAllUsersStatistics = "can_view_statistics",
			       UseGroupUserFiltersToRestrictUsersStudyListChkbx = "//input[@type='CHECKBOX'][@name='is_restricted']",
			       allowedByUserConsultingMDFilterChkbx = "//input[@type='CHECKBOX'][@name='allowed_by_consulting_on']"; 
			       
			     
	
	public Groups(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
		objFrames = new Frames(this.driver);
	}
	
	/**********************************************************************************
	  * Description : This function is to click on 'save changes' button.
	  * Date        : 15-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public Groups clickOnSaveChanges() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
			objWaitForElement.waitForElements(saveChanges, "xpath");
			this.page.element(saveChanges, "xpath").getOne().click();
			
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify Group page is displayed or not.
	* Date 		  : 22-Jun-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Groups verGroupsPage() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(addGroup, "xpath");
		assertTrue(this.page.element(addGroup, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click On AddGroup button.
	* Date 		  : 22-Jun-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Groups clickOnAddGroup() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(addGroup, "xpath");
		this.page.element(addGroup, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify Add New Group page is displayed or not.
	* Date 		  : 22-Jun-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Groups verAddNewGroup() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(addNewGroup, "xpath");
		assertTrue(this.page.element(addNewGroup, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter group name.
	* Date 		  : 22-Jun-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Groups enterGroupName(String groupname) throws Exception {
		objWaitForElement.waitForElements(groupName, "xpath");
		this.page.element(groupName, "xpath").clearInputValue().sendKeys(groupname);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter full group name.
	* Date 		  : 22-Jun-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Groups enterFullGroupName(String fullgroupname) throws Exception {
		objWaitForElement.waitForElements(fullGroupName, "xpath");
		this.page.element(fullGroupName, "xpath").clearInputValue().sendKeys(fullgroupname);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select group type.
	* Date 		  : 22-Jun-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Groups selectGroupType(String grouptype) throws Exception {
		objWaitForElement.waitForElements(groupType, "xpath");
		this.page.element(groupType, "xpath").webElementToSelect().selectByVisibleText(grouptype);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select Allowed to access Server checkbox.
	* Date 		  : 22-Jun-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Groups selectAllowedtoAccessServerCheckbox() throws Exception {
		objWaitForElement.waitForElements(AllowedtoAccessServerCheckbox, "xpath");
		if(this.page.element(AllowedtoAccessServerCheckbox, "xpath").getOne().isSelected()==false){
		this.page.element(AllowedtoAccessServerCheckbox, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select Use Group/User filters to restrict users study list checkbox.
	* Date 		  : 22-Jun-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Groups selectUserFilterstoRestrictCheckbox() throws Exception {
		objWaitForElement.waitForElements(userFilterstoRestrictCheckbox, "xpath");
		this.page.element(userFilterstoRestrictCheckbox, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify Group name in group list page.
	* Date 		  : 02-Jul-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Groups verGroupNameInGroupList(String group) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements("//td[text()='"+group+"']", "xpath");
		assertTrue(this.page.element("//td[text()='"+group+"']", "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify error message is displayed when duplicate Group name is entered.
	* Date 		  : 02-Jul-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Groups verErrMsgForDuplicateGroupName(String group) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMessageInRightFrame();
		objWaitForElement.waitForElements("//font[contains(text(),'Group "+group+" already exists')]", "xpath");
		assertTrue(this.page.element("//font[contains(text(),'Group "+group+" already exists')]", "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select option from 'Copy permissions from' field.
	* Date 		  : 06-Jul-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Groups selectCopyPermissionsFromOption(String option) throws Exception {
		objWaitForElement.waitForElements(copyPermissionsFrom, "xpath");
		this.page.element(copyPermissionsFrom, "xpath").webElementToSelect().selectByVisibleText(option);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click On Copy button.
	* Date 		  : 06-Jul-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Groups clickOnCopy() throws Exception {
		objWaitForElement.waitForElements(copy, "xpath");
		this.page.element(copy, "xpath").getOne().click();
		return this;
	}

	/**********************************************************************************
	* Description : This function is to select 'Allowed MTF list' checkbox.
	* Date 		  : 06-Jul-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Groups selectAllowedMTFListCheckBox() throws Exception {
		objWaitForElement.waitForElements(allowedMTFList, "xpath");
		if(this.page.element(allowedMTFList, "xpath").getOne().isSelected()==false){
			this.page.element(allowedMTFList, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Allowed Institution name list' checkbox.
	* Date 		  : 06-Jul-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Groups selectAllowedInstitutionNameListCheckBox() throws Exception {
		objWaitForElement.waitForElements(allowedInstitutionNameList, "xpath");
		this.page.element(allowedInstitutionNameList, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Allowed Modality list' checkbox.
	* Date 		  : 06-Jul-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Groups selectAllowedModalityListCheckBox() throws Exception {
		objWaitForElement.waitForElements(allowedModalityList, "xpath");
		if(this.page.element(allowedModalityList, "xpath").getOne().isSelected()==false){
			this.page.element(allowedModalityList, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Allowed Projects list' checkbox.
	* Date 		  : 06-Jul-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Groups selectAllowedProjectsListCheckBox() throws Exception {
		objWaitForElement.waitForElements(allowedProjectsList, "xpath");
		this.page.element(allowedProjectsList, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select users in 'Group Users' list.
	* Date 		  : 06-Jul-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Groups selectGroupUsers(String username) throws Exception {
		objWaitForElement.waitForElements("//input[@type='CHECKBOX'][@value='"
				+ username + "']", "xpath");
		this.page
				.element(
						"//input[@type='CHECKBOX'][@value='" + username + "']",
						"xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify Group Name And Group Member In Group List.
	* Date 		  : 06-Jul-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Groups verGroupNameAndGroupMemberInGroupList(String groupname,
			String username) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements("//td[text()='" + groupname
				+ "']/..//font[contains(text(),'" + username + "')]", "xpath");
		assertTrue(this.page
				.element(
						"//td[text()='" + groupname
								+ "']/..//font[contains(text(),'" + username
								+ "')]", "xpath").getOne().isDisplayed());
		return this;
	}

	/**********************************************************************************
	* Description : This function is to verify 'Administrator' is not present in 'Copy permissions from:' dropdown.
	* Date 		  : 06-Jul-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Groups verAdministratorNotPresentINCopyPermissionsFromOption(
			String option) throws Exception {
		objWaitForElement.waitForElements(copyPermissionsFrom, "xpath");
		WebElement element = driver
				.findElement(By
						.xpath("//td[contains(text(),'Copy permissions from:')]/..//select"));
		List<WebElement> list = element.findElements(By.tagName("option"));
		for (WebElement str : list) {
			assertTrue(!(option.equals(str.getText())));

		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify Group name in group list page.
	* Date 		  : 02-Jul-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Groups deleteGroup(String group) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		String str = "//table/tbody//tr//td[contains(text(),'" + group
				+ "')]/..//td//img[@src='/.cobalt/images/delete.gif']";
		objWaitForElement.waitForElements(str, "xpath");
		this.page.element(str, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'Groups' button in 'Add New Group' page.
	* Date 		  : 22-Jun-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Groups clickOnGroups() throws Exception {
		objFrames.switchToDefaultFrame().switchToLeftFrame()
		.switchToMainMenuInLeftFrame();
		objWaitForElement.waitForElements(groups, "css");
		this.page.element(groups, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Show New Study link on Patient Page' checkbox.
	* Date 		  : 07-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Groups selectShowNewStudyLinkOnPatientPageCheckBox() throws Exception {
		objWaitForElement.waitForElements(showNewStudy, "xpath");
		if (this.page.element(showNewStudy, "xpath").getOne().isSelected() == false) {
			this.page.element(showNewStudy, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Allowed to create new studies' checkbox.
	* Date 		  : 07-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Groups selectAllowedCreateNewStudiesCheckBox() throws Exception {
		objWaitForElement.waitForElements(createNewStudies, "xpath");
		if (this.page.element(createNewStudies, "xpath").getOne().isSelected() == false) {
			this.page.element(createNewStudies, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Show Upload Zip files link on Patient Page' checkbox.
	* Date 		  : 10-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Groups selectShowUploadZipFilesCheckBox() throws Exception {
		objWaitForElement.waitForElements(uploadZipFiles, "xpath");
		if (this.page.element(uploadZipFiles, "xpath").getOne().isSelected() == false) {
			this.page.element(uploadZipFiles, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Allowed to attach documents to reports' checkbox.
	* Date 		  : 11-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Groups selectAttachDocumentsToReportsCheckBox() throws Exception {
		objWaitForElement.waitForElements(attachDocuments, "xpath");
		if (this.page.element(attachDocuments, "xpath").getOne().isSelected() == false) {
			this.page.element(attachDocuments, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Allowed to view study reports' checkbox.
	* Date 		  : 11-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Groups selectAllowedToViewStudyReportsCheckBox() throws Exception {
		objWaitForElement.waitForElements(ViewStudyReports, "xpath");
		if (this.page.element(ViewStudyReports, "xpath").getOne().isSelected() == false) {
			this.page.element(ViewStudyReports, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Allowed to add new reports' checkbox.
	* Date 		  : 12-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Groups selectAllowedToAddNewReportsCheckBox() throws Exception {
		objWaitForElement.waitForElements(AddNewReports, "xpath");
		if (this.page.element(AddNewReports, "xpath").getOne().isSelected() == false) {
			this.page.element(AddNewReports, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click On Modify group icon.
	* Date 		  : 12-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Groups clickOnModifyGroupIcon(String group) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements("//td[contains(text(),'"+group+"')]/..//a[1]", "xpath");
		this.page.element("//td[contains(text(),'"+group+"')]/..//a[1]", "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to deselect 'Allowed to add new reports' checkbox.
	* Date 		  : 12-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Groups deSelectAllowedToAddNewReportsCheckBox() throws Exception {
		objWaitForElement.waitForElements(AddNewReports, "xpath");
		if (this.page.element(AddNewReports, "xpath").getOne().isSelected() == true) {
			this.page.element(AddNewReports, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Use Group/User filters to restrict users 
	*               study list' checkbox.
	* Date 		  : 19-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Groups selectUseGroupUsertoRestrictUsersStudylistCheckBox() throws Exception {
		objWaitForElement.waitForElements(groupUsertoRestrict, "xpath");
		if (this.page.element(groupUsertoRestrict, "xpath").getOne().isSelected() == false) {
			this.page.element(groupUsertoRestrict, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Allowed to view studies in QC sandbox' checkbox.
	* Date 		  : 19-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Groups selectAllowedToViewStudiesInQcSandboxCheckBox() throws Exception {
		objWaitForElement.waitForElements(qcSandbox, "xpath");
		if (this.page.element(qcSandbox, "xpath").getOne().isSelected() == false) {
			this.page.element(qcSandbox, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in Allowed MTF list field.
	* Date 		  : 19-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Groups enterTextInAllowedMTFListField(String mtf) throws Exception {
		objWaitForElement.waitForElements(allowedMTFListTextBox, "xpath");
		this.page.element(allowedMTFListTextBox, "xpath").clearInputValue()
				.sendKeys(mtf);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Allowed to modify studies' checkbox.
	* Date 		  : 19-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Groups selectAllowedToModifyStudiesCheckBox() throws Exception {
		objWaitForElement.waitForElements(allowedToModifyStudies, "xpath");
		if(this.page.element(allowedToModifyStudies, "xpath").getOne().isSelected()==false){
			this.page.element(allowedToModifyStudies, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in Allowed Modality list field.
	* Date 		  : 20-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Groups enterTextInAllowedModalityListField(String modality) throws Exception {
		objWaitForElement.waitForElements(allowedModalityListTextBox, "xpath");
		this.page.element(allowedModalityListTextBox, "xpath").clearInputValue()
				.sendKeys(modality);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to deselect 'Use Group/User filters to restrict users 
	*               study list' checkbox.
	* Date 		  : 20-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Groups deSelectUseGroupUsertoRestrictUsersStudylistCheckBox() throws Exception {
		objWaitForElement.waitForElements(groupUsertoRestrict, "xpath");
		if (this.page.element(groupUsertoRestrict, "xpath").getOne().isSelected() == true) {
			this.page.element(groupUsertoRestrict, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'Allowed Institution name list' field.
	* Date 		  : 21-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Groups enterTextInAllowedInstitutionNameListField(String mtf) throws Exception {
		objWaitForElement.waitForElements(allowedInstitutionNameListTextBox, "xpath");
		this.page.element(allowedInstitutionNameListTextBox, "xpath").clearInputValue()
				.sendKeys(mtf);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'Allowed Projects list' field.
	* Date 		  : 22-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Groups enterTextInAllowedProjectsListField(String project) throws Exception {
		objWaitForElement.waitForElements(allowedProjectsListTextBox, "xpath");
		this.page.element(allowedProjectsListTextBox, "xpath").clearInputValue()
				.sendKeys(project);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Allowed by user Referring MD filter' checkbox.
	* Date 		  : 22-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Groups selectAllowedByUserReferringMDFilterCheckBox() throws Exception {
		objWaitForElement.waitForElements(allowedByUserReferringMDFilter, "xpath");
		if(this.page.element(allowedByUserReferringMDFilter, "xpath").getOne().isSelected()==false){
			this.page.element(allowedByUserReferringMDFilter, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Allowed to sign reports' checkbox.
	* Date 		  : 04-Nov-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Groups selectAllowedToSignReportsCheckBox() throws Exception {
		objWaitForElement.waitForElements(allowedToSignReports, "xpath");
		if (this.page.element(allowedToSignReports, "xpath").getOne().isSelected() == false) {
			this.page.element(allowedToSignReports, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Show Upload DICOM  files link on Patient Page' checkbox.
	* Date 		  : 09-Nov-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Groups selectShowUploadDICOMFilesCheckBox() throws Exception {
		objWaitForElement.waitForElements(uploadDicomFiles, "xpath");
		if (this.page.element(uploadDicomFiles, "xpath").getOne().isSelected() == false) {
			this.page.element(uploadDicomFiles, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Allowed to change Read/Unread status of Study' checkbox.
	* Date 		  : 09-Nov-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Groups selectAllowedToChangeReadUnreadStatusOfStudyCheckBox() throws Exception {
		objWaitForElement.waitForElements(allowedToChangeReadUnreadStatusOfStudyChexckBox, "xpath");
		if (this.page.element(allowedToChangeReadUnreadStatusOfStudyChexckBox, "xpath").getOne().isSelected() == false) {
			this.page.element(allowedToChangeReadUnreadStatusOfStudyChexckBox, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Allowed to edit DICOM data' checkbox.
	* Date 		  : 07-Jul-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Groups selectAllowedToEditDICOMDataCheckBox() throws Exception {
		objWaitForElement.waitForElements(allowedToEditDICOMData, "xpath");
		if (this.page.element(allowedToEditDICOMData, "xpath").getOne().isSelected() == false) {
			this.page.element(allowedToEditDICOMData, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Allowed to split, move and merge QC studies' checkbox.
	* Date 		  : 07-Jul-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Groups selectAllowedToSplitMoveAndMergeQCStudiesCheckBox() throws Exception {
		objWaitForElement.waitForElements(allowedToSplitMoveAndMergeQCStudies, "xpath");
		if (this.page.element(allowedToSplitMoveAndMergeQCStudies, "xpath").getOne().isSelected() == false) {
			this.page.element(allowedToSplitMoveAndMergeQCStudies, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Allowed to split, move and merge ANY study' checkbox.
	* Date 		  : 07-Jul-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Groups selectAllowedToSplitMoveAndMergeAnyStudyCheckBox() throws Exception {
		objWaitForElement.waitForElements(allowedToSplitMoveAndMergeAnyStudy, "xpath");
		if (this.page.element(allowedToSplitMoveAndMergeAnyStudy, "xpath").getOne().isSelected() == false) {
			this.page.element(allowedToSplitMoveAndMergeAnyStudy, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Allowed to release studies from QC sandbox' checkbox.
	* Date 		  : 08-Jul-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Groups selectAllowedToReleaseStudiesFromQCSandboxCheckBox() throws Exception {
		objWaitForElement.waitForElements(allowedToReleaseStudiesFromQCSandbox, "xpath");
		if (this.page.element(allowedToReleaseStudiesFromQCSandbox, "xpath").getOne().isSelected() == false) {
			this.page.element(allowedToReleaseStudiesFromQCSandbox, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify Group name is not displaying in group list page.
	* Date 		  : 08-Jul-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Groups verGroupNameIsNotDisplayingInGroupList(String group) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements("//td[text()='"+group+"']", "xpath");
		assertTrue(!(this.page.element("//td[text()='"+group+"']", "xpath").isElementPresent()));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Allowed to burn study to CD ROM' checkbox.
	* Date 		  : 13-Jul-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Groups selectAllowedToBurnStudyToCDROMCheckBox() throws Exception {
		objWaitForElement.waitForElements(allowedToBurnStudyToCDROM, "xpath");
		if (this.page.element(allowedToBurnStudyToCDROM, "xpath").getOne().isSelected() == false) {
			this.page.element(allowedToBurnStudyToCDROM, "xpath").getOne().click();
		}
		return this;
	}
		
	/**********************************************************************************
	 * Description : This function is to select 'Allowed to send study to remote device' checkbox.
     * Date 	   : 14-Jul-2016
	 * Author 	   : Hanumegowda
	 **********************************************************************************/
		public Groups selectAllowedToSendStudyToRemoteDeviceCheckBox() throws Exception {
			objWaitForElement.waitForElements(allowedToBurnStudyToCDROM, "xpath");
			if (this.page.element(allowedToBurnStudyToCDROM, "xpath").getOne().isSelected() == false) {
				this.page.element(allowedToBurnStudyToCDROM, "xpath").getOne().click();
			}
			return this;
	}
		
	/**********************************************************************************
	 * Description : This function is to select 'Allowed to add replies' checkbox.
	 * Date 	   : 29-Aug-2016
	 * Author 	   : Hanumegowda
	 **********************************************************************************/
		public Groups selectAllowedToAddRepliesCheckBox() throws Exception {
			objWaitForElement.waitForElements(allowedToAddReplies, "css");
			if (this.page.element(allowedToAddReplies, "css").getOne().isSelected() == false) {
				this.page.element(allowedToAddReplies, "css").getOne().click();
			}
			return this;
		}
		
	/**********************************************************************************
	 * Description : This function is to click On View icon of a group.
	 * Date 	   : 20-Sep-2016
	 * Author 	   : Hanumegowda
	 **********************************************************************************/
		public Groups clickOnViewGroupIcon(String group) throws Exception {
			objFrames.switchToDefaultFrame().switchToRightFrame()
			.switchToMainInRightFrame();
			String str = "//td[text()='"+group+"']/..//a/img[@src='/.cobalt/images/search_icon_small.gif']";
			objWaitForElement.waitForElements(str, "xpath");
			this.page.element(str, "xpath").getOne().click();
			return this;
		}
		
	/**********************************************************************************
	* Description : This function is to verify 'Allowed to add addendums' checkbox is selected.
	* Date 		  : 20-Sep-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
		public Groups verAllowedToAddAddendumsChkbxSelected() throws Exception {
			objFrames.switchToDefaultFrame().switchToRightFrame()
			.switchToMainInRightFrame();
			objWaitForElement.waitForElements(allowedToAddAddendums, "xpath");
			assertTrue(this.page.element(allowedToAddAddendums, "xpath").getOne().isSelected());
			return this;
		}
		
	/**********************************************************************************
	 * Description : This function is to select 'Allowed to view All Users Statistics' checkbox.
	 * Date 	   : 26-Sep-2016
	 * Author 	   : Hanumegowda
	 **********************************************************************************/
		public Groups selectAllowedToViewAllUsersStatisticsCheckBox() throws Exception {
			objWaitForElement.waitForElements(allowedToViewAllUsersStatistics, "name");
			if (this.page.element(allowedToViewAllUsersStatistics, "name").getOne().isSelected() == false) {
				this.page.element(allowedToViewAllUsersStatistics, "name").getOne().click();
			}
			return this;
		}
		
	/**********************************************************************************
	 * Description : This function is to select 'Allowed to add addendums' checkbox.
	 * Date 	   : 05-Oct-2016
	 * Author 	   : Hanumegowda
	 **********************************************************************************/
		public Groups selectAllowedToAddAddendumsCheckBox() throws Exception {
			objWaitForElement.waitForElements(allowedToAddAddendums, "xpath");
			if (this.page.element(allowedToAddAddendums, "xpath").getOne().isSelected() == false) {
				this.page.element(allowedToAddAddendums, "xpath").getOne().click();
			}
			return this;
		}
		
	/**********************************************************************************
	 * Description : This function is to select 'Use Group/User filters to restrict users study list' checkbox.
	 * Date 	   : 09-Dec-2016
	 * Author 	   : Hanumegowda
	 **********************************************************************************/
	public Groups selectUseGroupUserFiltersToRestrictUsersStudyListCheckBox()
			throws Exception {
		objWaitForElement.waitForElements(
				UseGroupUserFiltersToRestrictUsersStudyListChkbx, "xpath");
		if (this.page
				.element(UseGroupUserFiltersToRestrictUsersStudyListChkbx,
						"xpath").getOne().isSelected() == false) {
			this.page
					.element(UseGroupUserFiltersToRestrictUsersStudyListChkbx,
							"xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select 'Allowed by user Consulting MD filter' checkbox.
	 * Date 	   : 09-Dec-2016
	 * Author 	   : Hanumegowda
	 **********************************************************************************/
	public Groups selectAllowedByUserConsultingMDFilterCheckBox()
			throws Exception {
		objWaitForElement.waitForElements(allowedByUserConsultingMDFilterChkbx,
				"xpath");
		if (this.page.element(allowedByUserConsultingMDFilterChkbx, "xpath")
				.getOne().isSelected() == false) {
			this.page.element(allowedByUserConsultingMDFilterChkbx, "xpath")
					.getOne().click();
		}
		return this;
	}

}
