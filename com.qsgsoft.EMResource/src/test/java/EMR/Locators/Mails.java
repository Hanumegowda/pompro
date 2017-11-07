package EMR.Locators;

public class Mails {

	public static class Locators {
		public static final String CLOSING_BRACKETS = "']",
				URL				= "http://www.outlook.com",
				USERID			= "input[id='i0116'][type='email']",
				PASSWORD		= "input[id='i0118'][type='password']",
				LOGIN 			= "input[id='idSIButton9'][type='submit']",
				INBOX			= "//span[@title='Inbox']",
				MESSAGEBODY		= "div[class='PlainText']",
				PROFILE 		= "//div[@id='O365_TopMenu']/div/div/div[1]/div[14]/button",
				SIGNOUT			= "https://outlook.live.com/owa/logoff.owa",
				CLOSE			= "//button[@title='Close']/span[1]",
				URLLINK			= "//div[@class='PlainText']/a",
//				SUBJECT_PART1	= "//div[@class='_lvv2_r _lvv2_d']/span[@class='ms-fwt-sb ms-fcl-tp']/preceding-sibling::span[text()='",//"//div[contains(@aria-label,'Unread, ')]/div/div/span[text()='",
				SUBJECT_PART1	= "//div[@class='_lvv2_s _lvv2_e']/span[@class='ms-fwt-sb ms-fcl-tp']/preceding-sibling::span[text()='",//"//div[contains(@aria-label,'Unread, ')]/div/div/span[text()='",
				READING_PANE	= "//div[@aria-label='Reading Pane']//div/span[text()='",
				REPLY_ALL		= "//button[@title='Reply all']/span[text()='Reply all']",
				SUBJECT_PART2	= "']",
				EXPAND_MESSAGES	= "//button[@title='Expand messages']",
				SIGN_IN         = "//div[@class='buttonLargeBlue']";
	}
}
