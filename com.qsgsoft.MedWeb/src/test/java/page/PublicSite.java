package page;

import module.Frames;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import qaframework.lib.pageObject.PageObject;
import qaframework.lib.userDefinedFunctions.WaitForElement;

public class PublicSite extends PageObject {
	WebDriver driver;
	WaitForElement objWaitForElement;
	Frames objFrames;
	 
	private String link = "//a[text()='Medical License']",
			       doctorsMedicalLicenses = "//div[text()=\"Doctors' Medical Licenses\"]",
			       homePageNote = "//td//i[contains(text(),'Note: You may construct a personalized home page by accessing the Administrator Site > Control Panel > Local Site Info.')]",
			       homePageNote1 = "//td//p[contains(text(),'The Medweb PACS/Telemedicine server provides a single workspace for physicians and radiologists to report anytime, anywhere."
			       		+ "  These solutions offer integrated advanced visualization, 3D rendering, dictation, telemedicine workflows and critical results notifications. Medweb combines DICOM imaging, "
			       		+ "wavelet compression and HL7 protocols to foster instant collaboration.')]",
			       homePageNote2 = "//td//p[contains(text(),'Medweb PACS/Telemedicine storage servers are scalable, user-friendly, fast, modular and affordable image archives. These "
			       		+ "storage servers are designed to work as a fully functioning PACS, as well as a central repository for radiology imaging.  Medweb is intuitive and simple to "
			       		+ "configure, deploy and maintain within any IT environment.')]",
			       homePageNote3 = "//td//p[contains(text(),'An ideal solution for expanding medical enterprises, Medweb Telemedicine solutions increase the quality of care with "
			       				+ "immediate access to specialists to speed up diagnosis and treatment, provides encrypted web-based solutions and enhance practice management via workload balancing.')]",
			       homePageNote4 = "//td//p[contains(text(),'The toolbar to the left provides access to the full functionality of the Medweb server. To access user manuals log into the view patients page "
			       		+ "and select the manuals link.')]",
			       		logoImage = "//img[@src='/cobalt/facility.jpg']";
			     
	
	public PublicSite(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
		objFrames = new Frames(this.driver);
	}
	
	/**********************************************************************************
	  * Description : This function is to click On link in public site Page.
	  * Date        : 19-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public PublicSite clickOnLink () throws Exception {
		//objWaitForElement.waitForElements(link, "xpath");
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		this.page.element(link, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify Doctors Medical Licenses Page is displayed.
	  * Date        : 19-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public PublicSite verDoctorsMedicalLicensesPage() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		//objWaitForElement.waitForElements(doctorsMedicalLicenses, "xpath");
		this.page.element(doctorsMedicalLicenses, "xpath").getOne().isDisplayed();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify uploaded file is displayed.
	  * Date        : 19-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public PublicSite verUploadedFile(String userName, String fileName) throws Exception {
		this.page.element("//tr/td[contains(text(),'"+userName+"')]/..//a[text()='"+fileName+"']", "xpath").getOne().isDisplayed();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify home page note is displayed.
	  * Date        : 24-Aug-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public PublicSite verHomePageNote() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(homePageNote, "xpath");
		assertTrue(this.page.element(homePageNote, "xpath").getOne()
				.isDisplayed());
		objWaitForElement.waitForElements(homePageNote1, "xpath");
		assertTrue(this.page.element(homePageNote1, "xpath").getOne()
				.isDisplayed());
		objWaitForElement.waitForElements(homePageNote2, "xpath");
		assertTrue(this.page.element(homePageNote2, "xpath").getOne()
				.isDisplayed());
		objWaitForElement.waitForElements(homePageNote3, "xpath");
		assertTrue(this.page.element(homePageNote3, "xpath").getOne()
				.isDisplayed());
		objWaitForElement.waitForElements(homePageNote4, "xpath");
		assertTrue(this.page.element(homePageNote4, "xpath").getOne()
				.isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify warning banner text is displayed.
	  * Date        : 29-Jul-2016
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public PublicSite verWarningBannerText(String wbtext) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		assertTrue((this.page.element("//td[text()='"+wbtext+"']", "xpath")).isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify logo image is displayed.
	  * Date        : 29-Jul-2016
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public PublicSite verLogoImageDisplaying() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		assertTrue((this.page.element(logoImage, "xpath")).isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify Local site info is displayed.
	  * Date        : 29-Jul-2016
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public PublicSite verLocalSiteInfoDisplaying(String contact,String bh,String announce) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		assertTrue((this.page.element("//b[text()='Contacts:']/../following-sibling::td[contains(text(),'"+contact+"')]", "xpath")).isElementPresent());
		assertTrue((this.page.element("//b[text()='Business hours:']/../following-sibling::td[contains(text(),'"+bh+"')]", "xpath")).isElementPresent());
		assertTrue((this.page.element("//b[text()='Announcements:']/../following-sibling::td[contains(text(),'"+announce+"')]", "xpath")).isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify link name is displayed.
	  * Date        : 29-Jul-2016
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public PublicSite verLinkNameText(String ltext) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		assertTrue((this.page.element("//a[text()='"+ltext+"']", "xpath")).isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'Address and driving directions' info is displayed.
	  * Date        : 29-Jul-2016
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public PublicSite verAddressAndDrivingDirectionsDisplaying(String addrexplaination,String htr) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		String str = (this.page.element("//b[contains(text(),'Address:')]/../following-sibling::td", "xpath")).getOne().getText();
		System.out.println(str.trim()+"  hhh");
		assertTrue((str.trim()).contains(addrexplaination));
		assertTrue((str.trim()).contains(htr));
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify how to reach us field is displayed.
	  * Date        : 29-Jul-2016
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public PublicSite verHowToReachUs(String htrtext) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		assertTrue((this.page.element("//td[contains(text(),'"+htrtext+"')]", "xpath")).isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify all New Consult Request buttons are displayed.
	  * Date        : 29-Jul-2016
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public PublicSite verAllNewConsultRequestButtons(String[] htrtext) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		for(int i=0;i<htrtext.length;i++){
		assertTrue((this.page.element("//table/tbody//button[text()='"+htrtext[i]+"']", "xpath")).isElementPresent());
		}
		return this;
	}

}
