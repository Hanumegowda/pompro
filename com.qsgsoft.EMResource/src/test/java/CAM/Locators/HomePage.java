package CAM.Locators;

public class HomePage {
	
	public static class Locators{
		
		public static final String HOME="//span[@class='pageTitle'][text()='Common Account Management']",
				                   SEARCHFIELD="input[id='find-user-query']",
				                   CLOSINGBRACKETS = "']",
				                   SEARCHBTN="#find-user-submit",
				                   DISPLAYNAME = "//table[@id='userResults']/tbody/tr/td[@aria-describedby='userResults_displayName'][text()='",			
				                   LOGINNAME="//table[@id='userResults']/tbody/tr/td[@aria-describedby='userResults_login'][text()='",
		                           PRODUCT = "//table[@id='userResults']/tbody/tr/td[@aria-describedby='userResults_product'][text()='",
		                           LOGIN="//tr/td/span[text()='Login:']/parent::td/following-sibling::td[text()='",
				                   DISPLAYNAME1="//tr/td/span[text()='Display Name:']/parent::td/following-sibling::td[text()='",
				                   ENABLED="//tr/td/span[text()='Enabled?']/parent::td/following-sibling::td[text()='",
				                   WORKEMAIL="//tr/td/span[text()='Work EMail:']/parent::td/following-sibling::td[text()='",
		                           PRODUCTACCESS="//tr/td/span/a[text()='Product Access: ']/parent::span/parent::td/following-sibling::td/ul/li[text()='",
	                               LOCKED="//tr/td/span[text()='Locked?']/parent::td/following-sibling::td[text()='";

}
}