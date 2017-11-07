package lib.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import static org.testng.Assert.*;
import qaframework.lib.WaitTimeConstants;
import qaframework.lib.UserDefinedFunctions.WaitForElement;
import qaframework.lib.pageObject.PageObject;

public class Calendar  extends PageObject {

	WebDriver driver;
	WaitForElement objWaitForElement;
	
	public Calendar(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
	}

	//Locators
	private String createNewMessage = "input[value='Create New Message']",
				   headerName = "div#topSubNav > h1",
				   eventDate = "#event_date",
				   title = "input[name='title']",
				   message = "textarea[name='content']",
				   contact = "input[name='contact']",
				   save = "input[value='Save']",
				   previousYear = "//a/img[@alt='Previous Year']",
				   cancel = "input[value='Cancel']",
				   selectYear = ".ui-datepicker-year"; 
	
	/**********************************************************************************
	  * Description : This function is to click On CreateNewMessage button.
	  * Date        : 10/09/2014
	  * Author      : Rensuhree
	  **********************************************************************************/
	public Calendar clickOnCreateNewMessage() throws Exception {
		objWaitForElement.waitForElements(createNewMessage, "css");
		assertTrue(this.page.element(createNewMessage, "css")
				.isElementPresent());
		this.page.element(createNewMessage, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify create bulletin message page is displayed.
	  * Date        : 10/09/2014
	  * Author      : Rensuhree
	  **********************************************************************************/
	public Calendar verCreateBulletinMessagePgeIsDispalyed() throws Exception {
		objWaitForElement.waitForElements(headerName, "css");
		assertEquals("Create Bulletin Message",
				this.page.element(headerName, "css").getOne().getText());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to enter date.
	  * Date        : 10/09/2014
	  * Author      : Rensuhree
	  **********************************************************************************/
	public Calendar enterDate(String strDate) throws Exception {
		int intMonth;
		int strDay;
		String strDateToEnter;
		String[] strMonthAndDate = strDate.split("/");
		int intMonth1 = Integer.parseInt(strMonthAndDate[0]);

		String strMonthFirstDigit = strMonthAndDate[0].substring(0, 1);
		intMonth = Integer.parseInt(strMonthFirstDigit);

		String strDayFirstDigit = strMonthAndDate[1].substring(0, 1);
		String strDaySecDigit = strMonthAndDate[1].substring(1);
		strDay = Integer.parseInt(strDayFirstDigit);
		strDateToEnter = strMonthAndDate[1];

		if (intMonth == 0) {
			if (strDay == 0) {
				strDateToEnter = strDaySecDigit;
			}
			String strMonth = strMonthAndDate[0].substring(1);
			intMonth = Integer.parseInt(strMonth);
			objWaitForElement.waitForElements(eventDate, "css");
			this.page.element(eventDate, "css").getOne().click();
			if(this.page.element("//td[@data-month='" + (intMonth - 1) + "'][@data-year='" + strMonthAndDate[2] + "']/a[text()='" + strDateToEnter + "']","xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_TOO_SMALL) == false) {
				this.page.element("//a/span[text()='Next']", "xpath").getDisplayedOne().click();
			}
			this.page
					.element(
							"//td[@data-month='" + (intMonth - 1)
									+ "'][@data-year='" + strMonthAndDate[2]
									+ "']/a[text()='" + strDateToEnter + "']",
							"xpath").getOne().click();
			this.page.element("//td[@class='emsLabel']", "xpath").getOne()
					.click();
		} else {
			if (strDay == 0) {
				strDateToEnter = strDaySecDigit;
			}
			this.page.element(eventDate, "css").getOne().click();
			if(this.page.element("//td[@data-month='" + (intMonth - 1) + "'][@data-year='" + strMonthAndDate[2] + "']/a[text()='" + strDateToEnter + "']","xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_TOO_SMALL) == false) {
				this.page.element("//a/span[text()='Next']", "xpath").getDisplayedOne().click();
			}
			this.page
					.element(
							"//td[@data-month='" + (intMonth1 - 1)
									+ "'][@data-year='" + strMonthAndDate[2]
									+ "']/a[text()='" + strDateToEnter + "']",
							"xpath").getOne().click();
			this.page.element("//td[@class='emsLabel']", "xpath").getOne()
					.click();
		}
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to enter title.
	  * Date        : 10/09/2014
	  * Author      : Rensuhree
	  **********************************************************************************/
	public Calendar enterTitle(String strTitle) throws Exception {
		objWaitForElement.waitForElements(title, "css");
		this.page.element(title, "css").clearInputValue().sendKeys(strTitle);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to enter message.
	  * Date        : 10/09/2014
	  * Author      : Rensuhree
	  **********************************************************************************/
	public Calendar enterMessage(String strMessage) throws Exception {
		objWaitForElement.waitForElements(message, "css");
		this.page.element(message, "css").clearInputValue()
				.sendKeys(strMessage);
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to enter contact.
	  * Date        : 10/09/2014
	  * Author      : Rensuhree
	  **********************************************************************************/
	public Calendar enterContact(String strContact) throws Exception {
		objWaitForElement.waitForElements(contact, "css");
		this.page.element(contact, "css").clearInputValue()
				.sendKeys(strContact);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on save.
	  * Date        : 10/09/2014
	  * Author      : Rensuhree
	  **********************************************************************************/
	public Calendar clickOnSave() throws Exception {
		objWaitForElement.waitForElements(save, "css");
		this.page.element(save, "css").getOne().click();;
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to enter contact.
	  * Date        : 10/09/2014
	  * Author      : Rensuhree
	  **********************************************************************************/
	public Calendar createMessgae(String strDate, String strTitle,
			String strMessage, String strContact) throws Exception {
		this.enterTitle(strTitle);
		this.enterMessage(strMessage);
		this.enterContact(strContact);
		this.enterDate(strDate);
		this.clickOnSave();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify action column
	  * Date        : 10/09/2014
	  * Author      : Rensuhree
	  **********************************************************************************/
	public Calendar verActionColumn() throws Exception {
		objWaitForElement
				.waitForElements(
						"//table[@summary='Calendar Entries']/thead/tr/th[1][text()='Action']/ancestor::table/tbody/tr/td/a[text()='Delete']",
						"xpath");
		assertTrue(this.page
				.element(
						"//table[@summary='Calendar Entries']/thead/tr/th[1][text()='Action']/ancestor::table/tbody/tr/td/a[text()='Delete']",
						"xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify title of message
	  * Arguments	: strTitle
	  * Date        : 10/09/2014
	  * Author      : Rensuhree
	  **********************************************************************************/
	public Calendar verTitleOfMessage(String strTitle) throws Exception {
		objWaitForElement
				.waitForElements(
						"//table[@summary='Calendar Entries']/thead/tr/th[2]/a[text()='Title']/ancestor::table/tbody/tr/td[2][text()='"
								+ strTitle + "']", "xpath");
		assertTrue(this.page
				.element(
						"//table[@summary='Calendar Entries']/thead/tr/th[2]/a[text()='Title']/ancestor::table/tbody/tr/td[2][text()='"
								+ strTitle + "']", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify date of message
	  * Arguments	: *
	  * Date        : 10/09/2014
	  * Author      : Rensuhree
	  **********************************************************************************/
	public Calendar verDateOfMessage(String strDate) throws Exception {
		objWaitForElement
				.waitForElements(
						"//table[@summary='Calendar Entries']/thead/tr/th[3]/a[text()='Date']/ancestor::table/tbody/tr/td[3][text()='"
								+ strDate + "']", "xpath");
		assertTrue(this.page
				.element(
						"//table[@summary='Calendar Entries']/thead/tr/th[3]/a[text()='Date']/ancestor::table/tbody/tr/td[3][text()='"
								+ strDate + "']", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify date of message
	  * Arguments	: strTitle
	  * Date        : 10/09/2014
	  * Author      : Rensuhree
	  **********************************************************************************/
	public Calendar verMessage(String strMessage) throws Exception {
		objWaitForElement
				.waitForElements(
						"//table[@summary='Calendar Entries']/thead/tr/th[4]/a[text()='Message']/ancestor::table/tbody/tr/td[4][text()='"
								+ strMessage + "']", "xpath");
		assertTrue(this.page
				.element(
						"//table[@summary='Calendar Entries']/thead/tr/th[4]/a[text()='Message']/ancestor::table/tbody/tr/td[4][text()='"
								+ strMessage + "']", "xpath")
				.isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify date of message
	  * Arguments	: strTitle
	  * Date        : 10/09/2014
	  * Author      : Rensuhree
	  **********************************************************************************/
	public Calendar verContactOfMessage(String strMessage) throws Exception {
		objWaitForElement
				.waitForElements(
						"//table[@summary='Calendar Entries']/thead/tr/th[5][text()='Contact']/ancestor::table/tbody/tr/td[5]/a[text()='"
								+ strMessage + "']", "xpath");
		assertTrue(this.page
				.element(
						"//table[@summary='Calendar Entries']/thead/tr/th[5][text()='Contact']/ancestor::table/tbody/tr/td[5]/a[text()='"
								+ strMessage + "']", "xpath")
				.isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This click on edit created Msg 
	  * Arguments	: strTitle
	  * Date        : 04/Jun/2014
	  * Author      : Sangappa.k
	  **********************************************************************************/
	public Calendar clickOnEditMsg(String strTittle) throws Exception {
		
		String strEdit="//td[contains(text(),'"+strTittle+"')]/..//a[contains(text(),'Edit')]";
        assertTrue(this.page.element(strEdit, "xpath").isElementPresent());
        this.page.element(strEdit, "xpath").getOne().click();
		return this;
	}	
	
	/**********************************************************************************
	  * Description : This click on delete created Msg 
	  * Arguments	: strTitle
	  * Date        :04/Jun/2014
	  * Author      : Sangappa.k
	  **********************************************************************************/
	public Calendar clickOnDeleteMsg(String strTittle) throws Exception {
		
		String strEdit="//td[contains(text(),'"+strTittle+"')]/..//a[contains(text(),'Delete')]";
       assertTrue(this.page.element(strEdit, "xpath").isElementPresent());
       this.page.element(strEdit, "xpath").getOne().click();
       Thread.sleep(5000);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify title of message
	  * Arguments	: strTitle
	  * Date        : 10/09/2014
	  * Author      : Sangappa.k
	  **********************************************************************************/
	public Calendar verTitleOfMessageIsNotDispalyed(String strTitle) throws Exception {
		assertFalse(this.page
				.element(
						"//table[@summary='Calendar Entries']/thead/tr/th[2]/a[text()='Title']/ancestor::table/tbody/tr/td[2][text()='"
								+ strTitle + "']", "xpath").isElementPresent(
						WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify title of message
	  * Arguments	: strTitle
	  * Date        : 10/09/2014
	  * Author      : Sangappa.k
	  **********************************************************************************/
	public Calendar entereFutureYear(String strCurrentYear,String strPickDate,String strMonth,String strFutureYear) throws Exception {
		
		
		String datefield="//input[@id='event_date']";
		
		String calander="//div[@id='ui-datepicker-div'][@class='ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all']";
		
		String presentyear="//select[@data-handler='selectYear']/option[@selected='selected'][@value='"+strCurrentYear+"']";
		
		String dropdown="//select[@data-handler='selectYear']";
		
		String pickdate ="//table[@class='ui-datepicker-calendar']/tbody/tr[2]/td[2]/a";
		
		 this.page.element(datefield, "xpath").getOne().sendKeys(Keys.SPACE);
		
		objWaitForElement.waitForElements(calander, "xpath");
		
		assertTrue(this.page.element(calander, "xpath").isElementPresent());
		
		assertTrue(this.page.element(presentyear, "xpath").isElementPresent());
		
		Select dropdown1 = new Select(driver.findElement(By.xpath(dropdown)));
		
		Thread.sleep(2000);
	
		dropdown1.selectByValue(strFutureYear);
		
		Thread.sleep(2000);
		
		this.page.element(pickdate, "xpath").getOne().click();
		
		//assertEquals(this.page.element(pickdate, "xpath").getOne().getAttribute("value"), , pickdate); 
		
		
		
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify Msg is not displayed under current year which is created with future year date
	  * Arguments	: strTitle
	  * Date        : 10/06/2014
	  * Author      : Sangappa.k
	  **********************************************************************************/
	public Calendar verMsgTittleisNotDisplayed(String strTitle) throws Exception {
		objWaitForElement
				.waitForElements(
						"//table[@summary='Calendar Entries']/thead/tr/th[2]/a[text()='Title']/ancestor::table/tbody/tr/td[2][text()='"
								+ strTitle + "']", "xpath");
		assertFalse(this.page
				.element(
						"//table[@summary='Calendar Entries']/thead/tr/th[2]/a[text()='Title']/ancestor::table/tbody/tr/td[2][text()='"
								+ strTitle + "']", "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_TOO_SMALL));
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify Message bulletin board page is displayed.
	  * Arguments	: strYear
	  * Date        : 26/Jun/2015
	  * Author      : Rensuhree
	  **********************************************************************************/
	public Calendar verMessageBulletinBoardPgeIsDispalyed(String strYear) throws Exception {
		objWaitForElement.waitForElements(headerName, "css");
		assertEquals("Message Bulletin Board "+strYear+"",
				this.page.element(headerName, "css").getOne().getText());
		return this;
	}	
	
	/**********************************************************************************
	  * Description : This function is to verify Edit Message bulletin page is displayed.
	  * Date        : 26/Jun/2015
	  * Author      : Rensuhree
	  **********************************************************************************/
	public Calendar verEditMessageBulletinPgeIsDispalyed() throws Exception {
		objWaitForElement.waitForElements(headerName, "css");
		assertEquals("Edit Bulletin Message",
				this.page.element(headerName, "css").getOne().getText());
		return this;
	}	
	
	/**********************************************************************************
	  * Description : This function is to verify title is retained.
	  * Date        : 26/Jun/2015
	  * Author      : Rensuhree
	  **********************************************************************************/
	public Calendar verTitleRetained(String strTitle) throws Exception {
		objWaitForElement.waitForElements(title, "css");
		String strRetainedTitle = this.page.element(title, "css").getOne()
				.getAttribute("value");
		assertEquals(strTitle, strRetainedTitle);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to enter message.
	  * Date        : 10/09/2014
	  * Author      : Rensuhree
	  **********************************************************************************/
	public Calendar verMessageRetained(String strMessage) throws Exception {
		objWaitForElement.waitForElements(message, "css");
		String strRetainedMessage = this.page.element(message, "css").getOne()
				.getText();
		assertEquals(strMessage, strRetainedMessage);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to enter contact.
	  * Date        : 10/09/2014
	  * Author      : Rensuhree
	  **********************************************************************************/
	public Calendar verContactRetained(String strContact) throws Exception {
		objWaitForElement.waitForElements(contact, "css");
		String strRetainedContact = this.page.element(contact, "css").getOne()
				.getAttribute("value");
		assertEquals(strContact, strRetainedContact);
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to enter contact.
	  * Date        : 10/09/2014
	  * Author      : Rensuhree
	  **********************************************************************************/
	public Calendar verDateRetianed(String strDate) throws Exception {
		objWaitForElement.waitForElements(eventDate, "css");
		String strRetainedDate = this.page.element(eventDate, "css").getOne()
				.getAttribute("value");
		assertEquals(strDate, strRetainedDate);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to enter contact.
	  * Date        : 10/09/2014
	  * Author      : Rensuhree
	  **********************************************************************************/
	public Calendar verAllDetailsRetained(String strTitle, String strMessage,
			String strContact, String strDate) throws Exception {
		this.verTitleRetained(strTitle);
		this.verMessageRetained(strMessage);
		this.verContactRetained(strContact);
		this.verDateRetianed(strDate);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on 'Previous Year' Link on Message Bulletin Board Page 
	  * Date        : 25-Feb-2016
	  * Author      : Pallavi
	  **********************************************************************************/
	public Calendar clickOnPreviousYearLink() throws Exception {
		assertTrue(this.page.element(previousYear, "xpath").isElementPresent());
		this.page.element(previousYear, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on Cancel.
	  * Date        : 25-Feb-2016
	  * Author      : Pallavi
	  **********************************************************************************/
	public Calendar clickOnCancel() throws Exception {
		objWaitForElement.waitForElements(cancel, "css");
		this.page.element(cancel, "css").getOne().click();;
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify Message Bulletin Board for a particular year is displayed.
	  * Date        : 25-Feb-2016
	  * Author      : Pallavi
	  **********************************************************************************/
	public Calendar verTitleIsNotPresent(String strTitle)
			throws Exception {
		assertFalse(this.page
				.element(
						"//td[text()='"+ strTitle + "']",
						"xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to select Year while entering the date
	  * Date        : 25-Feb-2016
	  * Author      : Pallavi
	  **********************************************************************************/
	public Calendar selectYear(String strYear) throws Exception {
		objWaitForElement.waitForElements(eventDate, "css");
		this.page.element(eventDate, "css").getOne().click();
		objWaitForElement.waitForElements(selectYear, "css");
		this.page.element(selectYear, "css").webElementToSelect()
				.selectByVisibleText(strYear);
		assertTrue(this.page.element(selectYear, "css").webElementToSelect()
				.getFirstSelectedOption().getText().equals(strYear));
		return this;
	}
}
