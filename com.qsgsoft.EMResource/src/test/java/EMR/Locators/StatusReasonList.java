package EMR.Locators;

public class StatusReasonList {

	public static class Locators {
		
		public static final String 
		   CLOSING_BRACKET	= "']",
		   CREATESTATUSREASON	= "input[value='Create Status Reason']",
		   REASONNAME			= "input[name='reasonName']",
		   DEFINITION			= "textarea[name='description']",
		   ABBREVATION			= "input[name='abbreviation']",
		   SAVE					= "input[value='Save']",
		   DISPLAY				= "input[name='display']",
		   REASONVALUE_PART1	= "//tr/td[2][text()='",
		   REASONVALUE_PART2	= "']/parent::tr/td[1]/a",
		   STATUS_REASON_PART1	= "//table[@summary='Status Reasons']//td[text()='",
		   ABBREVIATION_DESCRIPTION	= "']/following-sibling::td[text()='",
		   STATUS_REASON_LIST	= "//div[@id='topSubNav']/h1[text()='Status Reason List']",
		   REASON_NAME_DISABLED	= "input[name='reasonName'][disabled='disabled']";
	}
}
