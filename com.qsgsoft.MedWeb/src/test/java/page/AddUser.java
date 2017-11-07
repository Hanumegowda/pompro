package page;

import static org.testng.Assert.assertTrue;
import module.Frames;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;

import qaframework.lib.pageObject.PageObject;
import qaframework.lib.userDefinedFunctions.WaitForElement;

public class AddUser extends PageObject {
	WebDriver driver;
	WaitForElement objWaitForElement;
	Frames objFrames;

	private String aclGroup = "//select[@name='group']",
			fullNameLast = "//input[@type='TEXT'][@name='fullname_last']",
			saveChanges = "//a[text()='Save Changes']",
			saveChanges1 = "//img[@src='/.cobalt/images/save_but.gif']",
			passWord = "//input[@type ='PASSWORD'][@name='password1']",
			stationName = "//input[@name='allowed_by_station']",
			refferingName = "allowed_by_referring",
			passWordagain = "//input[@type ='PASSWORD'][@name='password2']",
			AIMScreenName = "//td[text()='AIM Screen name:']/..//input",
			emailAddress = "//td[text()='EMAIL address:']/..//input",
			additionalEmailAddress = "//td[text()='Additional EMAIL addresses:']/..//input",
			videoConferencingAddress = "//td[text()='Video conferencing address:']/..//input",
			pagerAddress = "//td[text()='Pager address:']/..//input",
			phoneNo = "//td[text()='Phone:']/..//input",
			fax = "//td[text()='Fax:']/..//input",
			doctorID = "//td[text()='Doctor ID:']/..//input",
			powerScribeUserID = "//td[text()='PowerScribe User ID:']/..//input",
			UPIN = "//td[text()='UPIN:']/..//input",
			browse = "//input[@id='SIGNATURE_FILE'][@type='file']",
			signatureFile = "//div[@id='upload_target']/img[@id='img']",
			addNewUser = "//div[text()='Add New User']",
			medicalLicenses = "//a[text()='Medical Licenses']",
			add = "//img[@src='/.cobalt/images/add_but.gif']",
			browse1 = "//input[@name='file1'][@type='FILE']",
			back = "//img[@src='/.cobalt/images/back_but.gif']",
			medicalLicenseschkbox = "//a[text()='Medical Licenses']/../following-sibling::td/input[@type='checkbox']",
			cancel = "//a[text()='Cancel']",
			upload = "//img[@src='/.cobalt/images/upload_but.gif']",
			byReferring = "//td[text()='By Referring:']/..//img[@src='/.cobalt/images/modify.gif']",
			selectReferringPhysicians = "//td[contains(text(),' Select Referring Physicians')]",
			firstPhysician = "(//td[contains(text(),'q.')])[1]/preceding-sibling::td//input",
			physicianName = "(//td[contains(text(),'q.')])[1]/preceding-sibling::td//input/../following-sibling::td[1]",
			save = "//input[@value='Save']",
			byConsulting = "//td[text()='By Consulting:']/..//img[@src='/.cobalt/images/modify.gif']",
			selectConsultingPhysicians = "//td[contains(text(),' Select Consulting Physicians')]",
			errmsg1 = "//td/font[contains(text(),'You do not have permissions to create/modify users for group of Administrators')]",
			errmsg2 = "//td/font[contains(text(),'You do not have permissions to create/modify users from group of Administrators.')]",
			pwdObviousErrorMsg = "//font[contains(text(),'The password must be 3 to 25 characters.')]",
			byMTF = "//td[text()='By MTF:']/..//img[@src='/.cobalt/images/modify.gif']",
			getMTF = "//tr[35]//td[2]",
			byInstName = "//td[text()='By Inst Name:']/..//img[@src='/.cobalt/images/modify.gif']",
			mtf = "//tr[35]//td[2]/preceding-sibling::td//input",
			institution = "(//td[contains(text(),'RH6')])[1]/..//input",
			byStation = "//td[text()='By Station Name:']/..//img[@src='/.cobalt/images/modify.gif']",
			station = "(//input)[1]",
			getStation = "(//input)[1]/../following-sibling::td",
			userName = "//input[@type='TEXT'][@name='username']",
			byServiceLocation = "//td[text()='By Service Location:']/..//img[@src='/.cobalt/images/modify.gif']",
			fullNameEssentialErrMsg = "//font[contains(text(),'Full name is essential. Please fill at least one of Full Name fields.')]",
		    fullNameFirst = "//input[@type='TEXT'][@name='fullname_first']",
		    fullNameMiddle = "//input[@type='TEXT'][@name='fullname_middle']",
		    strongPwdSecurityPolicyErrorMsg = "//font[contains(text(),'Strong password must include at least two digits, two lower case letters, "
		    		+ "two upper case letters, at least one special character (#,@,$, etc.).')]";

	public AddUser(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
		objFrames = new Frames(this.driver);
	}

	/**********************************************************************************
	* Description : This function is to select option in 'ACL group' Drop Down.
	* Date 		  : 15-Jun-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public AddUser selectOptionInACLgroupDropDown(String option)
			throws Exception {
		objWaitForElement.waitForElements(aclGroup, "xpath");
		this.page.element(aclGroup, "xpath").webElementToSelect()
				.selectByVisibleText(option);
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to enter fullname in last text box.
	  * Date        : 15-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public AddUser enterFullNameLast(String fullname) throws Exception {
		Thread.sleep(5000);
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(fullNameLast, "xpath");
		this.page.element(fullNameLast, "xpath").clearInputValue()
				.sendKeys(fullname);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to enter password.
	  * Date        : 15-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public AddUser enterPassWord(String password) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(passWord, "xpath");
		boolean unfound = true;
		int a=0;
		while(unfound && a<5){
			try{
				this.page.element(passWord, "xpath").clearInputValue()
				.sendKeys(password);
				unfound = false;
			}
			catch(StaleElementReferenceException e){
				unfound = true;
			}
			
			catch(ElementNotVisibleException e){
				unfound = true;
			}
		}
		/*this.page.element(passWord, "xpath").clearInputValue()
				.sendKeys(password);*/
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to enter text in By Station Name field.
	  * Date        : 15-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public AddUser enterByStationName(String sn) throws Exception {
		objWaitForElement.waitForElements(stationName, "xpath");
		this.page.element(stationName, "xpath").clearInputValue()
				.sendKeys(sn);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to enter text in 'By Referring' Name field.
	  * Date        : 15-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public AddUser enterByReferringName(String rpn) throws Exception {
		objWaitForElement.waitForElements(refferingName, "id");
		this.page.element(refferingName, "id").clearInputValue()
				.sendKeys(rpn);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to enter password in 'confirm password' field.
	  * Date        : 15-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public AddUser confirmPassWord(String password) throws Exception {
		objWaitForElement.waitForElements(passWordagain, "xpath");
		this.page.element(passWordagain, "xpath").clearInputValue()
				.sendKeys(password);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on 'save changes' button.
	  * Date        : 15-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public AddUser clickOnSaveChanges() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		try {
		objWaitForElement.waitForElements(saveChanges, "xpath");
		//this.page.element(saveChanges, "xpath").clickUjse();
		this.page.element(saveChanges, "xpath").getOne().click();
		}
		catch (NoSuchElementException e){
			objWaitForElement.waitForElements(saveChanges1, "xpath");
			this.page.element(saveChanges1, "xpath").getOne().click();
			
		}
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on 'save changes' button.
	  * Date        : 15-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public AddUser clickOnSaveChanges1() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
			objWaitForElement.waitForElements(saveChanges1, "xpath");
			this.page.element(saveChanges1, "xpath").getOne().click();

		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to enter AIM Screen name.
	  * Date        : 16-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public AddUser enterAIMScreenName(String ScreenName) throws Exception {
		objWaitForElement.waitForElements(AIMScreenName, "xpath");
		this.page.element(AIMScreenName, "xpath").clearInputValue()
				.sendKeys(ScreenName);
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to enter email address.
	  * Date        : 16-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public AddUser enterEmailAddress(String mailAddress) throws Exception {
		objWaitForElement.waitForElements(emailAddress, "xpath");
		this.page.element(emailAddress, "xpath").clearInputValue()
				.sendKeys(mailAddress);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to enter additionalemail address.
	  * Date        : 16-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public AddUser enterAdditionalEmailAddress(String mailAddress)
			throws Exception {
		objWaitForElement.waitForElements(additionalEmailAddress, "xpath");
		this.page.element(additionalEmailAddress, "xpath").clearInputValue()
				.sendKeys(mailAddress);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to enter Video conferencing address.
	  * Date        : 16-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public AddUser enterVideoConferencingAddress(String ConferencingAddress)
			throws Exception {
		objWaitForElement.waitForElements(videoConferencingAddress, "xpath");
		this.page.element(videoConferencingAddress, "xpath").clearInputValue()
				.sendKeys(ConferencingAddress);
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to enter Pager address.
	  * Date        : 16-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public AddUser enterPagerAddress(String PagerAddress) throws Exception {
		objWaitForElement.waitForElements(pagerAddress, "xpath");
		this.page.element(pagerAddress, "xpath").clearInputValue()
				.sendKeys(PagerAddress);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to enter Phone number.
	  * Date        : 16-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public AddUser enterPhoneNum(String PhoneNum) throws Exception {
		objWaitForElement.waitForElements(phoneNo, "xpath");
		this.page.element(phoneNo, "xpath").clearInputValue()
				.sendKeys(PhoneNum);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to enter text in Fax field.
	  * Date        : 16-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public AddUser enterFax(String Fax) throws Exception {
		objWaitForElement.waitForElements(fax, "xpath");
		this.page.element(fax, "xpath").clearInputValue().sendKeys(Fax);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to enter Doctor ID.
	  * Date        : 16-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public AddUser enterDoctorID(String DoctorID) throws Exception {
		objWaitForElement.waitForElements(doctorID, "xpath");
		this.page.element(doctorID, "xpath").clearInputValue()
				.sendKeys(DoctorID);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to enter PowerScribe User ID.
	  * Date        : 16-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public AddUser enterPowerScribeUserID(String ScribeUserID) throws Exception {
		objWaitForElement.waitForElements(powerScribeUserID, "xpath");
		this.page.element(powerScribeUserID, "xpath").clearInputValue()
				.sendKeys(ScribeUserID);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to enter text in UPIN field.
	  * Date        : 16-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public AddUser enterUPIN(String strUPIN) throws Exception {
		objWaitForElement.waitForElements(UPIN, "xpath");
		this.page.element(UPIN, "xpath").clearInputValue().sendKeys(strUPIN);
		return this;
	}
		
	/**********************************************************************************
	  * Description : This function is to upload the file.
	  * Date        : 19-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public AddUser uploadFile1(String path) throws Exception {
		objWaitForElement.waitForElements(browse, "xpath");
		this.page.element(browse, "xpath").getOne()
				.sendKeys(path);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify uploaded signature file is present.
	  * Date        : 19-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public AddUser verUploadedSignatureFile() throws Exception {
		objWaitForElement.waitForElements(signatureFile, "xpath");
		assertTrue(this.page.element(signatureFile, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify Add New User page is displayed.
	  * Date        : 19-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public AddUser verAddNewUserPage() throws Exception {
		objWaitForElement.waitForElements(addNewUser, "xpath");
		assertTrue(this.page.element(addNewUser, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click On MedicalLicenses Link.
	  * Date        : 19-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public AddUser clickOnMedicalLicensesLink() throws Exception {
		objWaitForElement.waitForElements(medicalLicenses, "xpath");
		this.page.element(medicalLicenses, "xpath").getOne().click();
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to click On add button in Medical Licenses for user Page.
	  * Date        : 19-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public AddUser clickOnAddInMedicalLicensesPage () throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(add, "xpath");
		this.page.element(add, "xpath").getOne().click();
		return this;
	}
	
//	/**********************************************************************************
//	  * Description : This function is to click On Browse In Upload Medical License File.
//	  * Date        : 19-Jun-2015
//	  * Author      : Hanumegowda
//	  **********************************************************************************/
//	public AddUser clickOnBrowseInUploadMedicalLicenseFile1 () throws Exception {
//		objWaitForElement.waitForElements(browse1, "xpath");
//		this.page.element(browse1, "xpath").getOne()
//		.sendKeys("C:\\Users\\Hanumegowda\\Medweb.pdf");
//		return this;
//	}
	
	/**********************************************************************************
	  * Description : This function is to click On Browse In Upload Medical License File.
	  * Date        : 19-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public AddUser clickOnBrowseInUploadMedicalLicenseFile (String path) throws Exception {
		objWaitForElement.waitForElements(browse1, "xpath");
		//this.page.element(browse1, "xpath").mouseOver();
		this.page.element(browse1, "xpath").getOne()
		.sendKeys(path);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on back button in Medical Licenses for user page.
	  * Date        : 19-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public AddUser clickOnBackButton() throws Exception {
		objWaitForElement.waitForElements(back, "xpath");
		this.page.element(back, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to select Medical Licenses CheckBox in add user page.
	  * Date        : 19-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public AddUser selMedicalLicensesCheckBox() throws Exception {
		objWaitForElement.waitForElements(medicalLicenseschkbox, "xpath");
		if(!(this.page.element(medicalLicenseschkbox, "xpath").getOne().isSelected())){
			this.page.element(medicalLicenseschkbox, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on cancel button.
	  * Date        : 15-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public AddUser clickOnCancel() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(cancel, "xpath");
		this.page.element(cancel, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on upload button.
	  * Date        : 19-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public AddUser clickOnUploadButton() throws Exception {
		objWaitForElement.waitForElements(upload, "xpath");
		this.page.element(upload, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on Edit Of By Referring Field.
	  * Date        : 22-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public AddUser clickOnEditOfByReferringField() throws Exception {
		objWaitForElement.waitForElements(byReferring, "xpath");
		this.page.element(byReferring, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify Select Referring Physicians window.
	  * Date        : 22-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public AddUser verSelectReferringPhysiciansWindow() throws Exception {
		objWaitForElement.waitForElements(selectReferringPhysicians, "xpath");
		this.page.element(selectReferringPhysicians, "xpath").isElementPresent();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to select a Physician in Select Referring Physicians window and to get his name.
	  * Date        : 22-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public String selAPhysicianAndGetHisName() throws Exception {
		objWaitForElement.waitForElements(firstPhysician, "xpath");
		if(this.page.element(firstPhysician, "xpath").getOne().isSelected()==false){
		this.page.element(firstPhysician, "xpath").getOne().click();
		}
		objWaitForElement.waitForElements(physicianName, "xpath");
		String str = this.page.element(physicianName, "xpath").getOne().getText();
		String str1 = str.trim();
		System.out.println(str1);
		return str1;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on save in Select Referring Physicians window.
	  * Date        : 22-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public AddUser clickOnSave() throws Exception {
		objWaitForElement.waitForElements(save, "xpath");
		this.page.element(save, "xpath").getOne().click();
		
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on Edit Of By Consulting Field.
	  * Date        : 23-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public AddUser clickOnEditOfByConsultingField() throws Exception {
		objWaitForElement.waitForElements(byConsulting, "xpath");
		this.page.element(byConsulting, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify Select Consulting Physicians window.
	  * Date        : 23-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public AddUser verSelectConsultingPhysiciansWindow() throws Exception {
		objWaitForElement.waitForElements(selectConsultingPhysicians, "xpath");
		this.page.element(selectConsultingPhysicians, "xpath").isElementPresent();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to Select Consulting Physicians.
	  * Date        : 23-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public AddUser selConsultingPhysician(String physician) throws Exception {
		String str = "//td[contains(text(),'"+physician+"')]/..//input[@type='CHECKBOX']";
		objWaitForElement.waitForElements(str, "xpath");
		this.page.element(str, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify error message is displayed when administrator group
	  *               user try to add user or try to modify user of administrator group while creating user.
	  * Date        : 24-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public AddUser verAdministratorErrorMsg() throws Exception {
		objFrames.switchToDefaultFrame();
		objFrames.switchToRightFrame().switchToMessageInRightFrame();
		objWaitForElement.waitForElements(errmsg1, "xpath");
		assertTrue(this.page.element(errmsg1, "xpath").getOne().isDisplayed());
		return this;
	}
	
//	/**********************************************************************************
//	  * Description : This function is to verify 'modify user' page of corresponding user is displayed or not.
//	  * Date        : 25-Jun-2015
//	  * Author      : Hanumegowda
//	  **********************************************************************************/
//	public AddUser verModifyUserPage(String username) throws Exception {
//		String str = "//div[text()='Modify user "+username+"']";
//		objWaitForElement.waitForElements(str, "xpath");
//		assertTrue(this.page.element(str, "xpath").getOne().isDisplayed());
//		return this;
//	}
	
	/**********************************************************************************
	  * Description : This function is to verify error message is displayed when administrator group
	  *               user try to add user to 'administrator ACL group' while creating user.
	  * Date        : 26-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public AddUser verAdministratorACLGroupErrorMsg() throws Exception {
		objFrames.switchToDefaultFrame();
		objFrames.switchToRightFrame().switchToMessageInRightFrame();
		objWaitForElement.waitForElements(errmsg2, "xpath");
		assertTrue(this.page.element(errmsg2, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify error message is displayed when password entered is containing
	  *               lessthan three characters.
	  * Date        : 29-Jul-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public AddUser verPwdObviousErrorMsg() throws Exception {
		objFrames.switchToDefaultFrame();
		objFrames.switchToRightFrame().switchToMessageInRightFrame();
		objWaitForElement.waitForElements(pwdObviousErrorMsg, "xpath");
		assertTrue(this.page.element(pwdObviousErrorMsg, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on Edit Of By MTF Field.
	  * Date        : 19-Oct-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public AddUser clickOnEditOfByMTF() throws Exception {
		objWaitForElement.waitForElements(byMTF, "xpath");
		this.page.element(byMTF, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to get MTF code.
	  * Date        : 19-Oct-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public String getMTF() throws Exception {
		objWaitForElement.waitForElements(getMTF, "xpath");
		String str = this.page.element(getMTF, "xpath").getOne().getText();
		String str1 = str.trim();
		return str1;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on Edit Of 'By Inst Name' Field.
	  * Date        : 21-Oct-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public AddUser clickOnEditOfByInstName() throws Exception {
		objWaitForElement.waitForElements(byInstName, "xpath");
		this.page.element(byInstName, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to select a MTF in Select MTF window and to get its name.
	  * Date        : 26-Oct-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public String selMTFName() throws Exception {
		objWaitForElement.waitForElements(mtf, "xpath");
		if(this.page.element(mtf, "xpath").getOne().isSelected()==false){
		this.page.element(mtf, "xpath").getOne().click();
		}
		objWaitForElement.waitForElements(getMTF, "xpath");
		String str = this.page.element(getMTF, "xpath").getOne().getText();
		String str1 = str.trim();
		System.out.println(str1);
		return str1;
	}
	
	/**********************************************************************************
	  * Description : This function is to select a MTF in Select MTF window and to get its name.
	  * Date        : 26-Oct-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public AddUser selAMTFName(String mtff) throws Exception {
		//String str = "//td[contains(text(),'"+mtff+"')]/..//input[@type='CHECKBOX']";
		String str = "//input[@type='CHECKBOX'][@value='"+mtff+"']";
		objWaitForElement.waitForElements(str, "xpath");
		if(this.page.element(str, "xpath").getOne().isSelected()==false){
			this.page.element(str, "xpath").mouseOver();
		this.page.element(str, "xpath").getOne().click();
		}
		return this;
	
	}
	
	/**********************************************************************************
	  * Description : This function is to select a institution and to get its name.
	  * Date        : 27-Oct-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public String selInstitutionAndGetItsName() throws Exception {
		objWaitForElement.waitForElements(institution, "xpath");
		if(this.page.element(institution, "xpath").getOne().isSelected()==false){
		this.page.element(institution, "xpath").getOne().click();
		}
		String insname = this.getInstitutionName();
		return insname;
	}
	
	/**********************************************************************************
	  * Description : This function is to select a institution and to get its name.
	  * Date        : 27-Oct-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public AddUser selAInstitutionAndGetItsName(String inst) throws Exception {
		String str = "//td[contains(text(),'"+inst+"')]/..//input[@type='CHECKBOX']";
		objWaitForElement.waitForElements(str, "xpath");
		if(this.page.element(str, "xpath").getOne().isSelected()==false){
			this.page.element(str, "xpath").mouseOver();
		this.page.element(str, "xpath").getOne().click();
		Thread.sleep(3000);
		}
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on Edit Of 'By Station Name' Field.
	  * Date        : 27-Oct-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public AddUser clickOnEditOfByStationName() throws Exception {
		objWaitForElement.waitForElements(byStation, "xpath");
		this.page.element(byStation, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to select a first station and to get its name.
	  * Date        : 27-Oct-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public String selFirstStationAndGetItsName() throws Exception {
		objWaitForElement.waitForElements(station, "xpath");
		if(this.page.element(station, "xpath").getOne().isSelected()==false){
		this.page.element(station, "xpath").getOne().click();
		}
		objWaitForElement.waitForElements(getStation, "xpath");
		String str = this.page.element(getStation, "xpath").getOne().getText();
		String str1 = str.trim();
		System.out.println(str1);
		return str1;
	}
	
	/**********************************************************************************
	  * Description : This function is to get institution name.
	  * Date        : 28-Oct-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public String getInstitutionName() throws Exception {
		objWaitForElement.waitForElements(institution, "xpath");
		String str = this.page.element(institution, "xpath").getOne().getAttribute("value");
		String str1 = str.trim();
		System.out.println(str1);
		return str1;
	}
	
	/**********************************************************************************
	  * Description : This function is to enter text in username text box.
	  * Date        : 11-Dec-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public AddUser enterUserName(String username) throws Exception {
		Thread.sleep(5000);
		objWaitForElement.waitForElements(userName, "xpath");
		this.page.element(userName, "xpath").clearInputValue()
				.sendKeys(username);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on Edit Of 'By Service Location' Field.
	  * Date        : 13-Jun-2016
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public AddUser clickOnEditOfByServiceLocation() throws Exception {
		objWaitForElement.waitForElements(byServiceLocation, "xpath");
		this.page.element(byServiceLocation, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'full name is essential'error message is displayed. 
	  * Date        : 19-Sep-2016
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public AddUser verFullNameEssentialErrorMsg() throws Exception {
		objFrames.switchToDefaultFrame();
		objFrames.switchToRightFrame().switchToMessageInRightFrame();
		objWaitForElement.waitForElements(fullNameEssentialErrMsg, "xpath");
		assertTrue(this.page.element(fullNameEssentialErrMsg, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify the text present in user name text field.
	  * Date        : 19-Sep-2016
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public AddUser verUserNameFieldText(String username) throws Exception {
		objWaitForElement.waitForElements(userName, "xpath");
		String str = this.page.element(userName, "xpath").getOne().getAttribute("value");
		assertTrue(str.equals(username));
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to enter first name in user full name text field.
	  * Date        : 22-Sep-2016
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public AddUser enterFullNameFirst(String firstname) throws Exception {
		Thread.sleep(5000);
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(fullNameFirst, "xpath");
		this.page.element(fullNameFirst, "xpath").clearInputValue()
				.sendKeys(firstname);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to enter middle name in user full name text field.
	  * Date        : 22-Sep-2016
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public AddUser enterFullNameMiddle(String middlename) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(fullNameMiddle, "xpath");
		this.page.element(fullNameMiddle, "xpath").clearInputValue()
				.sendKeys(middlename);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'Strong password must include at least two digits,
	  *               two lower case letters, two upper case letters, at least one special character 
	  *               (#,@,$, etc.)' error message is displaying.
	  * Date        : 23-Sep-2016
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public AddUser verStrongPwdSecurityPolicyErrorMsg() throws Exception {
		Thread.sleep(5000);
		objFrames.switchToDefaultFrame();
		objFrames.switchToRightFrame().switchToMessageInRightFrame();
		objWaitForElement.waitForElements(strongPwdSecurityPolicyErrorMsg, "xpath");
		assertTrue(this.page.element(strongPwdSecurityPolicyErrorMsg, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to select Service Location and get its name in 'Select
	  *               Service Locations' page.
	  * Date        : 06-Oct-2016
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public String selServiceLocationAndGetItsName(int i) throws Exception {
		String str = "(//input[@type='CHECKBOX'])["+i+"]";
		objWaitForElement.waitForElements(str, "xpath");
		if(this.page.element(str, "xpath").getOne().isSelected()==false){
			this.page.element(str, "xpath").mouseOver();
		this.page.element(str, "xpath").getOne().click();
		}
		String value = (this.page.element(str, "xpath")).getOne().getAttribute("value");
		return value;
	
	}
	
}
