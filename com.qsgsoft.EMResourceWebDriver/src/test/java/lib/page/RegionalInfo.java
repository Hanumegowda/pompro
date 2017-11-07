package lib.page;

import static org.testng.AssertJUnit.assertTrue;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.Assert.*;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import qaframework.lib.WaitTimeConstants;
import qaframework.lib.UserDefinedFunctions.WaitForElement;
import qaframework.lib.pageObject.PageObject;

public class RegionalInfo extends PageObject{
	
	WebDriver driver;
	WaitForElement objWaitForElement;
	
	private String userListTable = "//table[@id='tblUsers']/tbody/tr/",
			       createNewFolder = "//div[@id='mainContainer']/div[1]//input[@value='Create a New Folder']",
			       folderName = "folderName",
			       createInAllFoldersRadioBtn = "chosenFolderID",
			       addNewDocument = "input[value='Add a New Document']",
			       documentName = "documentTitle",
			       browseDocument = "//div[@id='mainContainer']/form/table/tbody/tr[2]/td[2]/input[@name='document']",
			       strCreatFolder="//input[@value='Create a New Folder']",
				   strDocLib="html/body/div[1]/div[5]/h1",
				   strMove="//input[@value='Move']",
				   strRename="//input[@value='Rename a Folder']",
				   strRenameOk="//input[@value='Rename']",
				   strdeleteFolder="//input[@value='Delete a Folder']",
				   strDeleteTextChkBox="html/body/div[2]/form/table/tbody/tr[2]/td[1]/../td[2]/input[@class='checkbox']",
				   strDelete="//input[@value='Delete']",
				   deleteFolderErrorMessage = "//div[@id='mainContainer']/div/ul/li[text()='Please choose a folder.']",
				   errorMessage = "//li[text()='Please choose the new folder in which to move the document.']",
				   cancelButton = "input[value='Cancel']",
				   saveButton="input[value='Save']";
	
	public RegionalInfo(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
	}
	
	/**********************************************************************************
	 * Description : This function is to verify user details in userlist page of regional info.
	 * Date 	   : 30/07/2014
	 * Author      : Rensuhree
	 **********************************************************************************/
	public RegionalInfo verUserDetailsInUserListPgeOfRegionalInfo(
			String strUserName, String strFullName, String strOrganization,
			String strPhone, String strPrimaryEmail, String strEmail)
			throws Exception {
		objWaitForElement.waitForElements("td[1][@text()='"+strUserName+"']", "xpath");
		this.page.element(userListTable + "td[1][@text()='"+strUserName+"']", "xpath").isElementPresent();
		assertEquals(strUserName,
				this.page.element(userListTable + "td[1]", "xpath").getOne()
						.getText());
		assertEquals(strFullName,
				this.page.element(userListTable + "td[2]", "xpath").getOne()
						.getText());
		assertEquals(strOrganization,
				this.page.element(userListTable + "td[3]", "xpath").getOne()
						.getText());
		assertEquals(strPhone,
				this.page.element(userListTable + "td[4]", "xpath").getOne()
						.getText());
		assertEquals(strPrimaryEmail + "," + strEmail,
				this.page.element(userListTable + "td[5]", "xpath").getOne()
						.getText());
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to verify user details in userlist page of regional info.
	 * Date 	   : 30/07/2014
	 * Author      : Rensuhree
	 **********************************************************************************/
	public RegionalInfo verUserInUserListPgeOfRegionalInfo(String strUserName,
			String strFullName) throws Exception {
		objWaitForElement.waitForElements("td[text()='" + strUserName + "']",
				"xpath");
		assertTrue(this.page.element(
				userListTable + "td[text()='" + strUserName
						+ "']/following-sibling::td[text()='" + strFullName
						+ "']", "xpath").isElementPresent());
		return this;
	}
	
    /**********************************************************************************
	 * Description : This function is to click on 'Create New Folder' in document library
	 * Date        : 10/09/2014 
	 * Author      : Sinchana
	 **********************************************************************************/
	public RegionalInfo clickOnCreateNewFolder()
			throws Exception {
		objWaitForElement.waitForElements(createNewFolder, "xpath");
		this.page.element(createNewFolder, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to enter folder name
	 * Date        : 10/09/2014 
	 * Author      : Sinchana
	 **********************************************************************************/
	public RegionalInfo enterFolderName(String strFolderName) throws Exception {
		objWaitForElement.waitForElements(folderName, "name");
		this.page.element(folderName, "name").clearInputValue().sendKeys(strFolderName);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to enter folder name
	 * Date        : 10/09/2014 
	 * Author      : Sinchana
	 **********************************************************************************/
	public RegionalInfo clickOnCreateInAllFoldersRadioBtn() throws Exception {
		objWaitForElement.waitForElements(createInAllFoldersRadioBtn, "name");
		this.page.element(createInAllFoldersRadioBtn, "name").getOne().click();
		return this;		
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Add a new document'
	 * Date        : 10/09/2014 
	 * Author      : Sinchana
	 **********************************************************************************/
	public RegionalInfo clickOnAddNewDocument() throws Exception {	
		objWaitForElement.waitForElements(addNewDocument, "css");
		this.page.element(addNewDocument, "css").getOne().click();
		return this;		
	}
	
	/**********************************************************************************
	 * Description : This function is to enter 'Document' name
	 * Date        : 10/09/2014 
	 * Author      : Sinchana
	 **********************************************************************************/
	public RegionalInfo enterDocumentName(String strDocumentTitle)
			throws Exception {
		objWaitForElement.waitForElements(documentName, "name");
		this.page.element(documentName, "name").clearInputValue()
				.sendKeys(strDocumentTitle);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to enter folder name
	 * Date        : 10/09/2014 
	 * Author      : Sinchana
	 **********************************************************************************/
	public RegionalInfo clickOnBrowse(String file) throws Exception {
		objWaitForElement.waitForElements(browseDocument, "xpath");
		this.page.element(browseDocument, "xpath").getOne().sendKeys(file);;
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify folder is created and displayed in document library
	 * Date        : 10/09/2014 
	 * Author      : Sinchana
	 **********************************************************************************/
	public RegionalInfo verFolderName(String strFolderName) throws Exception {
		objWaitForElement.waitForElements(
				"//div[@id='mainContainer']//div[2]/a/span[text()='"
						+ strFolderName + "']", "xpath");
		assertTrue(this.page
				.dynamicElement(
						"FolderName",
						"//div[@id='mainContainer']//div[2]/a/span[text()='"
								+ strFolderName + "']", "xpath").getOne()
				.isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify date and time are displayed next to document
	 * Date        : 10/09/2014 
	 * Author      : Sinchana
	 **********************************************************************************/
	public RegionalInfo verifyStartDateAndTimeInDL(String strNewUserName, String strDateTime) throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']/div[2]/table/tbody/tr/td/span[text()='(By: "
				+ strNewUserName + " on " + strDateTime + ")']", "xpath");
		assertTrue(this.page
				.dynamicElement(
						"StartDateAndTime",
						"//div[@id='mainContainer']/div[2]/table/tbody/tr/td/span[text()='(By: "
						+ strNewUserName + " on " + strDateTime + ")']", "xpath")
				.getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Document' name in document library
	 * Date        : 10/09/2014 
	 * Author      : Sinchana
	 **********************************************************************************/
	public RegionalInfo verifyDocumentName(String strDocumentTitle)
			throws Exception {
		objWaitForElement.waitForElements(
				"//div[@id='mainContainer']/div[2]/table/tbody/tr/td/a/span[text()='"
						+ strDocumentTitle + "']", "xpath");
		assertTrue(this.page
				.dynamicElement(
						"DocumentName",
						"//div[@id='mainContainer']/div[2]/table/tbody/tr/td/a/span[text()='"
								+ strDocumentTitle + "']", "xpath").getOne()
				.isDisplayed());
		return this;
	}
	/**********************************************************************************
	* Description : This function is to verify document library screen
	* Date 		  : 6/4/2015
	* Author 	  : Sangappa.k
	**********************************************************************************/
	public RegionalInfo verDocumentLibraryPage() throws Exception {

		objWaitForElement.waitForElements(strDocLib, "xpath");
		assertTrue(this.page.element(strCreatFolder, "xpath")
				.isElementPresent());
		this.page.element(strDocLib, "xpath").isElementPresent();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to sel Folder For Add Doument
	* Date 		  : 6/4/2015
	* Author 	  : Sangappa.k
	**********************************************************************************/
	public RegionalInfo selFolderForAddDoument(String strFoldername)
			throws Exception {
		String folderName = "//span[contains(text(),'" + strFoldername
				+ "')]/input[@type='radio']";
		objWaitForElement.waitForElements(folderName, "xpath");
		assertTrue(this.page.element(folderName, "xpath").isElementPresent());
		this.page.element(folderName, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to expand folder
	* Date 		  : 6/4/2015
	* Author 	  : Sangappa.k
	**********************************************************************************/
	public RegionalInfo expandCreatedFolder(String strFoldername)
			throws Exception {
		String folderName = "//span[contains(text(),'All Folders')]/..//a/span[contains(text(),'"
				+ strFoldername + "')]";
		objWaitForElement.waitForElements(folderName, "xpath");
		this.page.element(folderName, "xpath").isElementPresent();
		this.page.element(folderName, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to sel Folder For Add Doument
	* Date 		  : 6/4/2015
	* Author 	  : Sangappa.k
	**********************************************************************************/
	public RegionalInfo verEditAndDeleteButtonsOfDocUnderFolder(
			String strFoldername) throws Exception {
		Thread.sleep(5000);
		String delete = "//span[contains(text(),'" + strFoldername
				+ "')]/../..//div/table/tbody/tr[1]//input[@value='Delete']";
		String move = "//span[contains(text(),'" + strFoldername
				+ "')]/../..//div/table/tbody/tr[1]//input[@value='Move']";
		objWaitForElement.waitForElements(delete, "xpath");
		assertTrue(this.page.element(delete, "xpath").isElementPresent());
		assertTrue(this.page.element(move, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to sel Folder For Add Doument
	* Date 		  : 6/4/2015
	* Author 	  : Sangappa.k
	**********************************************************************************/
	public RegionalInfo clickOnMoveBtnOfCorrespondingDoc(String strFolderId,
			String strDocName) throws Exception {
		String move = "//div[@id='" + strFolderId
				+ "']/table/tbody/tr/td[3]/a/span[text()='" + strDocName
				+ "']/ancestor::tr/td[2]/form/input[@value='Move']";
		objWaitForElement.waitForElements(move, "xpath");
		this.page.element(move, "xpath").getOne().sendKeys(Keys.SPACE);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to sel Folder For Mov Doument
	* Date 		  : 6/4/2015
	* Author 	  : Sangappa.k
	**********************************************************************************/
	public RegionalInfo selRadioBtnForFolderToMoveDoc(String strFoldername)
			throws Exception {
		String folderName = "//table[@summary='Data Input Form']/tbody/tr/td[2]/span[contains(text(),'"
				+ strFoldername + "')]/input";
		System.out.println(folderName);
		objWaitForElement.waitForElements(folderName, "xpath");
		assertTrue(this.page.element(folderName, "xpath").isElementPresent());
		this.page.element(folderName, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to sel Folder For Mov Doument
	* Date 		  : 6/4/2015
	* Author 	  : Sangappa.k
	**********************************************************************************/
	public RegionalInfo clcikOnMoveOfSelectedFolder() throws Exception {
		
		objWaitForElement.waitForElements(strMove, "xpath");
		assertTrue(this.page.element(strMove, "xpath").isElementPresent());
		this.page.element(strMove, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to ver Moved Doc is not displayed id source folder
	* Date 		  : 6/4/2015
	* Author 	  : Sangappa.k
	**********************************************************************************/
	public RegionalInfo verMovedDocIsNotDispayedInSourceFolder(
			String strFolderId, String strDocName) throws Exception {

		String doc1 = "//div[@id='" + strFolderId
				+ "']/table/tbody/tr/td[3]/a/span[text()='" + strDocName
				+ "']/ancestor::tr/td[1]/form/input[@value='Delete']";
		objWaitForElement.waitForElements(doc1, "xpath");
		assertFalse(this.page.element(doc1, "xpath").isElementPresent(
				WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to ver Moved Doc is not displayed id source folder
	* Date 		  : 6/4/2015
	* Author 	  : Sangappa.k
	**********************************************************************************/
	public RegionalInfo verMovedDocIsDispayedInDestinationFolder(
			String strFolderId, String strDocName) throws Exception {
		String doc1 = "//div[@id='" + strFolderId
				+ "']/table/tbody/tr/td[3]/a/span[text()='" + strDocName
				+ "']/ancestor::tr/td[1]/form/input[@value='Delete']";
		objWaitForElement.waitForElements(doc1, "xpath");
		assertTrue(this.page.element(doc1, "xpath").isElementPresent());
		return this;
	}

	/**********************************************************************************
	* Description : This function is to ver Moved Doc is not displayed id source folder
	* Date 		  : 6/4/2015
	* Author 	  : Sangappa.k
	**********************************************************************************/
	public RegionalInfo verDocInUncategorizedDocSection(String strDocName)
			throws Exception {
		String doc1 = "//span[text()='Uncategorized Documents']/following::table/tbody/tr/td/a/span[text()='"
				+ strDocName + "']";
		objWaitForElement.waitForElements(doc1, "xpath");
		assertTrue(this.page.element(doc1, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to sel Folder For Add Doument
	* Date 		  : 6/4/2015
	* Author 	  : Sangappa.k
	**********************************************************************************/
	public RegionalInfo deleteDocumentUnderFolder(String strFolderId,
			String strDocName) throws Exception {
		Thread.sleep(5000);
		String delete = "//div[@id='" + strFolderId
				+ "']/table/tbody/tr/td[3]/a/span[text()='" + strDocName
				+ "']/ancestor::tr/td[1]/form/input[@value='Delete']";
		objWaitForElement.waitForElements(delete, "xpath");
		this.page.element(delete, "xpath").getOne().sendKeys(Keys.SPACE);
		Thread.sleep(2000);
		Alert popup = this.driver.switchTo().alert();
		popup.accept();
		Thread.sleep(5000);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to clcik on rename folder
	* Date 		  : 6/4/2015
	* Author 	  : Sangappa.k
	**********************************************************************************/
	public RegionalInfo clickOnRename() throws Exception {
		Thread.sleep(5000);
		objWaitForElement.waitForElements(strRename, "xpath");
		this.page.element(strRename, "xpath").getOne().click();	
		return this;	
 }
	/**********************************************************************************
	* Description : This function is to clcik on rename folder
	* Date 		  : 6/4/2015
	* Author 	  : Sangappa.k
	**********************************************************************************/
	public RegionalInfo clickOnRenameBtn() throws Exception {
		
		objWaitForElement.waitForElements(strRenameOk, "xpath");
		this.page.element(strRenameOk, "xpath").getOne().click();	
		return this;	
  }	

	/**********************************************************************************
	* Description : This function is to clcik on Delete a folder btn
	* Date 		  : 6/4/2015
	* Author 	  : Sangappa.k
	**********************************************************************************/
	public RegionalInfo clickOnDeleteFolderBtn() throws Exception {
		
		objWaitForElement.waitForElements(strdeleteFolder, "xpath");
		this.page.element(strdeleteFolder, "xpath").getOne().click();
		return this;	
				
   }	
	/**********************************************************************************
	* Description : This function is to verify Delete documents too text
	* Date 		  : 6/4/2015
	* Author 	  : Sangappa.k
	**********************************************************************************/
	public RegionalInfo verDeleteDocumentsTooText() throws Exception {
		String text="//td[contains(text(),'Delete documents too?')]";
		objWaitForElement.waitForElements(text, "xpath");
		String text1=this.page.element(text, "xpath").getOne().getText();	
		assertTrue(text1.equals("Delete documents too?"));
		return this;	
   }	
	/**********************************************************************************
	* Description : This function is to verify Delete documents too text
	* Date 		  : 6/4/2015
	* Author 	  : Sangappa.k
	**********************************************************************************/
	public RegionalInfo selectDeleteDocumentsTooChkBox() throws Exception {
		objWaitForElement.waitForElements(strDeleteTextChkBox, "xpath");
		this.page.element(strDeleteTextChkBox, "xpath").getOne().click();
		return this;	
		
   }
	/**********************************************************************************
	* Description : This function is to select 2nd folder radio btn to delete
	* Date 		  : 6/4/2015
	* Author 	  : Sangappa.k
	**********************************************************************************/
	public RegionalInfo clickOnDeleteOfFolder() throws Exception {
		objWaitForElement.waitForElements(strDelete, "xpath");
		this.page.element(strDelete, "xpath").getOne().click();
		Thread.sleep(5000);
		Alert popup = this.driver.switchTo().alert();
		popup.accept();
		Thread.sleep(6000);
		return this;
		
   }
	
	/**********************************************************************************
	 * Description : This function is to verify folder is created and displayed in document library
	 * Date        : 10/09/2014 
	 * Author      : Sangappa.k
	 **********************************************************************************/
	public RegionalInfo verFolderNameIsNotDisplayedAfterDelete(String strFolderName) throws Exception {
		objWaitForElement.waitForElements(
				"//div[@id='mainContainer']//div[2]/a/span[text()='"
						+ strFolderName + "']", "xpath");
		assertFalse(this.page
				.dynamicElement(
						"FolderName",
						"//div[@id='mainContainer']//div[2]/a/span[text()='"
								+ strFolderName + "']", "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
				
		return this;
	}	
	
	/**********************************************************************************
	* Description : This function is to clcik on Delete a folder btn
	* Date 		  : 10/6/2015
	* Author 	  : Sangappa.k
	**********************************************************************************/
	public String getFolderValue(String strFolderName) throws Exception {
		String value = "//span[text()='" + strFolderName + "']/parent::a";
		objWaitForElement.waitForElements(value, "xpath");
		String Foldervalue = this.page.element(value, "xpath").getOne()
				.getAttribute("onclick");
		Foldervalue = (Foldervalue.replaceAll("shoh\\('", "")).replaceAll(
				"'\\);", "").trim();
		System.out.println(Foldervalue);
		return Foldervalue;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify SelectFolder page is displayed
	  * Date        : 26/06/2014
	  * Author      : Anitha
	  **********************************************************************************/
	public RegionalInfo verSelectFolderScreenIsDisplayed() throws Exception {
		objWaitForElement.waitForElements(
				"//div[@id='topSubNav']/h1[text()='Select Folder to Rename']",
				"xpath");
		assertTrue(this.page.element("//div[@id='topSubNav']/h1[text()='Select Folder to Rename']",
						"xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify edit Folder page is displayed
	  * Date        : 26/06/2014
	  * Author      : Anitha
	  **********************************************************************************/
	public RegionalInfo verEditFolderScreenIsDisplayed() throws Exception {
		objWaitForElement.waitForElements(
				"//div[@id='topSubNav']/h1[text()='Edit Folder']", "xpath");
		assertTrue(this.page.element(
				"//div[@id='topSubNav']/h1[text()='Edit Folder']", "xpath")
				.isElementPresent());
		return this;
	}
	/**********************************************************************************
	  * Description : This function is to verify edit Folder page is displayed
	  * Date        : 26/06/2014
	  * Author      : Anitha
	  **********************************************************************************/
	public RegionalInfo verDeleteFolderScreenIsDisplayed() throws Exception {
		objWaitForElement.waitForElements(
				"//div[@id='topSubNav']/h1[text()='Delete Folder']", "xpath");
		assertTrue(this.page.element(
				"//div[@id='topSubNav']/h1[text()='Delete Folder']", "xpath")
				.isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify Error message in Delete folder
	 *  Date       : 11/06/2014 
	 *  Author     : Anitha
	 **********************************************************************************/
	public RegionalInfo verifyInfErrorMessageInDeleteFolderPage()
			throws Exception {
		objWaitForElement.waitForElements(deleteFolderErrorMessage, "xpath");
		assertTrue(this.page.element(deleteFolderErrorMessage, "xpath")
				.getOne().isDisplayed());
		return this;
	}

	/**********************************************************************************
	* Description : This function is to select folder radio button
	* Date 		  : 6/4/2015
	* Author 	  : Anil
	**********************************************************************************/
	public RegionalInfo selectFolderToCreateSubFolder(String strFolderName) throws Exception {
		objWaitForElement.waitForElements("//span[contains(text(),'"+strFolderName+"')]/input[@name='chosenFolderID']", "xpath");
		this.page.element("//span[contains(text(),'"+strFolderName+"')]/input[@name='chosenFolderID']", "xpath").getOne().click();
		return this;		
   }
	
	/**********************************************************************************
	* Description : This function is to select folder radio button
	* Date 		  : 6/4/2015
	* Author 	  : Anil
	**********************************************************************************/
	public String getDocumentValue(String strDocumentName) throws Exception {
		objWaitForElement.waitForElements("//span[text()='"+strDocumentName+"']/parent::a/@onclick", "xpath");
		
		String strValue = this.page.element("//span[text()='"+strDocumentName+"']/parent::a", "xpath").getOne().getAttribute("onclick");
		String[] strValues = strValue.split(
				"=");
		System.out.println(strValues);
		String[]strDocValues=strValues[1].split("'");
		String strDocValue=strDocValues[0];	
		return strDocValue;		
	}
	
	/**********************************************************************************
	* Description : This function is to verify error message in move a document page
	* Date 		  : 6/4/2015
	* Author 	  : Anil
	**********************************************************************************/
	public RegionalInfo verifyErrorMessageInMoveDocument() throws Exception {
		objWaitForElement.waitForElements(errorMessage, "xpath");
		this.page.element(errorMessage, "xpath").getOne().click();
		return this;		
   }
	
	/**********************************************************************************
	* Description : This function is to click on move document
	* Date 		  : 6/4/2015
	* Author 	  : Anil
	**********************************************************************************/
	public RegionalInfo clickOnMoveDocument(String strDocValue) throws Exception {
		objWaitForElement.waitForElements("//form[@name='move_document_" + strDocValue
				+ "']/input[@value='Move']", "xpath");
		this.page.element("//form[@name='move_document_" + strDocValue
				+ "']/input[@value='Move']", "xpath").getOne().click();
		return this;		
   }
	
	/**********************************************************************************
	 * Description : This function is to verify 'Document' name is not displayed in document library
	 * Date        : 29/Jun/2015 
	 * Author      : Renushree
	 **********************************************************************************/
	public RegionalInfo verifyDocumentNameNotDisplayed(String strDocumentTitle)
			throws Exception {
		assertFalse(this.page.element(
				"//div[@id='mainContainer']/div[2]/table/tbody/tr/td/a/span[text()='"
						+ strDocumentTitle + "']", "xpath").isElementPresent(
				WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to delete document
	* Date 		  : 29/Jun/2015
	* Author 	  : Renushree 
	**********************************************************************************/
	public RegionalInfo deleteDocument(String strDocName) throws Exception {
		this.page
				.element(
						"//span[text()='"
								+ strDocName
								+ "']/parent::a/parent::td/preceding-sibling::td[2]/form/input[@value='Delete']",
						"xpath").getOne().click();
		Thread.sleep(2000);
		Alert alert = this.driver.switchTo().alert();
		String strVar = alert.getText();
		System.out.println(strVar);
		assertEquals(
				"Are you absolutely sure that you want to delete this document? It will remove the document from the entire region, not just your view.",
				strVar);
		alert.accept();
		Thread.sleep(5000);
		return this;
	}
	
	/******************************************************************
	* Description : This function is to ver created doc under folder
	* Date 		  : 10/01/2015
	* Author 	  : Sowmya
	*******************************************************************/
	public RegionalInfo verCreatedDocUnderFolder(String strFolderId,
			String strDocName) throws Exception {
		assertTrue(this.page
				.element(
						"//span[text()='"
								+ strFolderId
								+ "']/parent::a/following-sibling::div/table/tbody/tr/td[3]/a/span[text()='"
								+ strDocName + "']", "xpath")
				.isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on move document
	* Date 		  : 6/4/2015
	* Author 	  : Anil
	**********************************************************************************/
	public RegionalInfo clickOnMoveDocument1(String strDocName) throws Exception {
		objWaitForElement.waitForElements("//span[text()='"+strDocName+"']/ancestor::td/preceding-sibling::td//input[@value='Move']", "xpath");
		this.page.element("//span[text()='"+strDocName+"']/ancestor::td/preceding-sibling::td//input[@value='Move']", "xpath").getOne().click();
		return this;		
   }
	
	/**********************************************************************************
	* Description : This function is to click on move document
	* Date 		  : 6/4/2015
	* Author 	  : Anil
	**********************************************************************************/
	public RegionalInfo verifyDocumentIsMovedToFolder(String strDocName, String strFolderName) throws Exception {
		objWaitForElement.waitForElements("//span[text()='"+strDocName+"']/ancestor::table/parent::div/preceding-sibling::a//span[text()='"+strFolderName+"']", "xpath");
		assertTrue(this.page.element("//span[text()='"+strDocName+"']/ancestor::table/parent::div/preceding-sibling::a//span[text()='"+strFolderName+"']", "xpath").getOne().isDisplayed());
		return this;		
   }
	
	/**********************************************************************************
	* Description : This function is to click on the tree structure
	* Date 		  : 6/4/2015
	* Author 	  : Anil
	**********************************************************************************/
	public RegionalInfo clickToExpand(String strFolderName) throws Exception {
		objWaitForElement.waitForElements("//span[text()='"+strFolderName+"']/parent::a/preceding-sibling::a/img", "xpath");
		this.page.element("//span[text()='"+strFolderName+"']/parent::a/preceding-sibling::a[1]/img", "xpath").mouseOver();
		this.page.element("//span[text()='"+strFolderName+"']/parent::a/preceding-sibling::a[1]/img", "xpath").getOne().click();
		return this;		
   }
	
	/**********************************************************************************
	 * Description : This function is to click on 'Create Ne
	 * w User' button
	 * Date        : 09/06/2014
	 * Author      : Anil
	 **********************************************************************************/
	public RegionalInfo verRoleIsNotPresentInSearchDropDown(String strRoleName)
			throws Exception {
		assertFalse(this.page.element(
				"//select[@id='tblUsers_ROLE']/option[text()='"
						+ strRoleName + "']", "xpath").isElementPresent(
				WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify document is moved to uncategorized Documents
	* Date 		  : 6/4/2015
	* Author 	  : Anil
	**********************************************************************************/
	public RegionalInfo verifyDocumentIsMovedToUncategorizedFolder(String strDocName) throws Exception {
		objWaitForElement.waitForElements("//span[text()='"+strDocName+"']/ancestor::table/preceding-sibling::span[1][text()='Uncategorized Documents']", "xpath");
		assertTrue(this.page.element("//span[text()='"+strDocName+"']/ancestor::table/preceding-sibling::span[1][text()='Uncategorized Documents']", "xpath").getOne().isDisplayed());
		return this;		
   }
	/**********************************************************************************
	 * Description 	: This function is to click on 'Cancel' button 
	 * Date  		: 24/09/2014
	 *  Author 		: Prasanna Lakshmi
	 **********************************************************************************/
	public RegionalInfo clickOnCancelButton() throws Exception {
		objWaitForElement.waitForElements(cancelButton, "css");
		this.page.element(cancelButton, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to click on 'Cancel' button 
	 * Date  		: 24/09/2014
	 *  Author 		: Prasanna Lakshmi
	 **********************************************************************************/
	public RegionalInfo clickOnSaveButton() throws Exception {
		objWaitForElement.waitForElements(saveButton, "css");
		this.page.element(saveButton, "css").getOne().click();
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to click 'Cancel' button 
	 * Date        : 25-Feb-2016
	 * Author      : Anitha
	 **********************************************************************************/
	public RegionalInfo cancelDeletingFolder() throws Exception {
		objWaitForElement.waitForElements(strDelete, "xpath");
		this.page.element(strDelete, "xpath").getOne().click();
		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert();
		String strVar = alert.getText();
		System.out.println(strVar);
		assertEquals(
				"Are you sure that you want to delete this folder? If it contains"
						+ " documents, they will be removed from the entire region, not just your view.",
				strVar);
		alert.dismiss();
		Thread.sleep(5000);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify user details in userlist page of regional info.
	 * Date 	   : 30/07/2014
	 * Author      : Rensuhree
	 **********************************************************************************/
	public RegionalInfo verUserNotListedInUserListPgeOfRegionalInfo(String strUserName,
			String strFullName) throws Exception {
		assertFalse(this.page.element(
				userListTable + "td[text()='" + strUserName
						+ "']/following-sibling::td[text()='" + strFullName
						+ "']", "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to cancel delete document
	* Date 		  : 26/Feb/2015
	* Author 	  : Anitha 
	**********************************************************************************/
	public RegionalInfo cancelDeletingDocument(String strDocName)
			throws Exception {
		this.page
				.element(
						"//span[text()='"
								+ strDocName
								+ "']/parent::a/parent::td/preceding-sibling::td[2]/form/input[@value='Delete']",
						"xpath").getOne().click();
		Thread.sleep(2000);
		Alert alert = this.driver.switchTo().alert();
		String strVar = alert.getText();
		System.out.println(strVar);
		assertEquals(
				"Are you absolutely sure that you want to delete this document? It will remove the document from the entire region, not just your view.",
				strVar);
		alert.dismiss();
		Thread.sleep(5000);
		return this;
	}
}