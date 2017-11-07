package page;


import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;
import module.Frames;

import org.openqa.selenium.WebDriver;

import qaframework.lib.WaitTimeConstants;
import qaframework.lib.pageObject.PageObject;
import qaframework.lib.userDefinedFunctions.WaitForElement;

public class PersonalProfile extends PageObject{
	WebDriver driver;
	WaitForElement objWaitForElement;
	Frames objFrames;
	
	private String fullName = "//td[contains(text(),'Full Name')]/..//input[@name='fullname_last']",
			       userName = "//td[text()='User Name:']/..//input[@name='username']",
			       aclGroup = "//td[text()='ACL Group:']/..//input[@name='ACL']",
			       aIMScreenName = "//td[text()='AIM Screen name:']/..//input[@name='aimname']",
			       emailAddress = "//td[text()='EMAIL address:']/..//input[@name='email']",
			       confemailAddress = "//td[text()='Video conferencing address:']/..//input[@name='videoconferencing']",
			       pagerAddress = "//td[text()='Pager address:']/..//input[@name='pageraddress']",
			       phone = "//td[text()='Phone:']/..//input[@name='phone']",
			       fax = "//td[text()='Fax:']/..//input[@name='fax']",
			       doctorID = "//td[text()='Doctor ID:']/..//input[@name='doctor_id']",
			       powerScribeID = "//td[text()='PowerScribe User ID:']/..//input[@name='powerscribe_username']",
			       uPIN = "//td[text()='UPIN:']/..//input[@name='upin']",
			       pwdSavedMsg = "//td/font[contains(text(),'Your password has been changed.')]",
			       recentlyUsedPwd = "//td/font[contains(text(),'You can not change password because you have provided password that you have used recently')]",
	               saveChanges = "//a[text()='Save Changes']",
	               location = "//td[text()='Location:']/following-sibling::td",
	               compressionLevel = "//select[@name='compression']",
	               defaultCompressionLevelsChkbox = "//input[@name='resetcompressionlevel']";
	public PersonalProfile(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
		objFrames = new Frames(this.driver);
	}
	
	/**********************************************************************************
	* Description : This function is to verify Personal profile page of a user is displayed.
	* Date 		  : 30-Jul-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PersonalProfile verPersonalProfilePagePfUser(String user)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements("//div[contains(text(),'Personal profile:')]/b[text()='"+user+"']", "xpath");
		assertTrue(this.page.element("//div[contains(text(),'Personal profile:')]/b[text()='"+user+"']", "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify Full Name Of a User.
	* Date 		  : 30-Jul-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PersonalProfile verFullNameOfUser(String fullname)
			throws Exception {
		objWaitForElement.waitForElements(fullName, "xpath");
		String str = (this.page.element(fullName, "xpath")).getOne().getAttribute("value");
		assertTrue(str.equals(fullname));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify User name.
	* Date 		  : 30-Jul-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PersonalProfile verUserName(String username)
			throws Exception {
		objWaitForElement.waitForElements(userName, "xpath");
		String str = (this.page.element(userName, "xpath")).getOne().getAttribute("value");
		assertTrue(str.equals(username));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify acl group.
	* Date 		  : 30-Jul-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PersonalProfile verACLgroup(String aclgroup)
			throws Exception {
		objWaitForElement.waitForElements(aclGroup, "xpath");
		String str = (this.page.element(aclGroup, "xpath")).getOne().getAttribute("value");
		assertTrue(str.equalsIgnoreCase(aclgroup));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify AIM Screen name.
	* Date 		  : 30-Jul-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PersonalProfile verAIMScreenName(String aimscreenname)
			throws Exception {
		objWaitForElement.waitForElements(aIMScreenName, "xpath");
		String str = (this.page.element(aIMScreenName, "xpath")).getOne().getAttribute("value");
		assertTrue(str.equals(aimscreenname));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify EMAIL address.
	* Date 		  : 30-Jul-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PersonalProfile verEmailAddress(String email)
			throws Exception {
		objWaitForElement.waitForElements(emailAddress, "xpath");
		String str = (this.page.element(emailAddress, "xpath")).getOne().getAttribute("value");
		assertTrue(str.equals(email));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify Video conferencing address.
	* Date 		  : 30-Jul-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PersonalProfile verVideoConferencingAddress(String confemail)
			throws Exception {
		objWaitForElement.waitForElements(confemailAddress, "xpath");
		String str = (this.page.element(confemailAddress, "xpath")).getOne().getAttribute("value");
		assertTrue(str.equals(confemail));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify Pager address.
	* Date 		  : 30-Jul-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PersonalProfile verPagerAddress(String confemail)
			throws Exception {
		objWaitForElement.waitForElements(pagerAddress, "xpath");
		String str = (this.page.element(pagerAddress, "xpath")).getOne().getAttribute("value");
		assertTrue(str.equals(confemail));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify Phone number.
	* Date 		  : 30-Jul-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PersonalProfile verPhone(String phonenum)
			throws Exception {
		objWaitForElement.waitForElements(phone, "xpath");
		String str = (this.page.element(phone, "xpath")).getOne().getAttribute("value");
		assertTrue(str.equals(phonenum));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify fax number.
	* Date 		  : 30-Jul-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PersonalProfile verFax(String faxnum)
			throws Exception {
		objWaitForElement.waitForElements(fax, "xpath");
		String str = (this.page.element(fax, "xpath")).getOne().getAttribute("value");
		assertTrue(str.equals(faxnum));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify Doctor ID.
	* Date 		  : 30-Jul-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PersonalProfile verDoctorID(String doctorid)
			throws Exception {
		objWaitForElement.waitForElements(doctorID, "xpath");
		String str = (this.page.element(doctorID, "xpath")).getOne().getAttribute("value");
		assertTrue(str.equals(doctorid));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify PowerScribe User ID.
	* Date 		  : 30-Jul-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PersonalProfile verPowerScribeUserID(String powerScribeid)
			throws Exception {
		objWaitForElement.waitForElements(powerScribeID, "xpath");
		String str = (this.page.element(powerScribeID, "xpath")).getOne().getAttribute("value");
		assertTrue(str.equals(powerScribeid));
		return this;	
    }
	
	/**********************************************************************************
	* Description : This function is to verify UPIN number.
	* Date 		  : 30-Jul-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PersonalProfile verUPIN(String upin)
			throws Exception {
		objWaitForElement.waitForElements(uPIN, "xpath");
		String str = (this.page.element(uPIN, "xpath")).getOne().getAttribute("value");
		assertTrue(str.equals(upin));
		return this;	
    }
	
	/**********************************************************************************
	* Description : This function is to verify location.
	* Date 		  : 30-Jul-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PersonalProfile verLocation(String loc)
			throws Exception {
		objWaitForElement.waitForElements(location, "xpath");
		String str = (this.page.element(location, "xpath")).getOne().getText();
		System.out.println(str+" 1");
		System.out.println(loc+" 2");
		assertTrue(str.contains(loc));
		return this;	
    }
	
	/**********************************************************************************
	  * Description : This function is to verify Your password has been changed message.
	  * Date        : 03-Aug-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public PersonalProfile verPwdSavedMsg() throws Exception {
		objFrames.switchToDefaultFrame();
		objFrames.switchToRightFrame().switchToMessageInRightFrame();
		objWaitForElement.waitForElements(pwdSavedMsg, "xpath");
		assertTrue(this.page.element(pwdSavedMsg, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'You can not change password because you have
	  *               provided password that you have used recently' error message.
	  * Date        : 03-Aug-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public PersonalProfile verUsedRecentPwdErrMsg() throws Exception {
		objFrames.switchToDefaultFrame();
		objFrames.switchToRightFrame().switchToMessageInRightFrame();
		objWaitForElement.waitForElements(recentlyUsedPwd, "xpath");
		assertTrue(this.page.element(recentlyUsedPwd, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify Your password has been changed message.
	  * Date        : 03-Aug-2015 (mod)
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public PersonalProfile clickOnSaveChanges() throws Exception {
		objWaitForElement.waitForElements(saveChanges, "xpath");
		this.page.element(saveChanges, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify Personal profile page of a user is not displayed.
	* Date 		  : 03-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PersonalProfile verPersonalProfilePagePfUserNotDisplayed(String user)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		assertFalse(this.page.element(
				"//div[contains(text(),'Personal profile:')]/b[text()='" + user
						+ "']", "xpath").isElementPresent(
				WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select 'Default viewer compression level' option 
	 *               in Personal profile page.
	 * Date        : 07-Dec-2016
     * Author      : Hanumegowda
     **********************************************************************************/
	public PersonalProfile selCompressionLevelOption(String option) throws Exception {
		objWaitForElement.waitForElements(compressionLevel, "xpath");
		this.page.element(compressionLevel, "xpath").webElementToSelect().selectByVisibleText(option);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select 'Reset compression levels to default' checkbox 
	 *               in Personal profile page.
	 * Date        : 07-Dec-2016
     * Author      : Hanumegowda
     **********************************************************************************/
	public PersonalProfile selResetCompressionLevelsToDefaultChckBox() throws Exception {
		objWaitForElement.waitForElements(defaultCompressionLevelsChkbox, "xpath");
		this.page.element(defaultCompressionLevelsChkbox, "xpath").getOne().click();
		return this;
	}
	
}