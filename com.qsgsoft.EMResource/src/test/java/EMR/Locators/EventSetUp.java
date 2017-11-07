package EMR.Locators;

public class EventSetUp {

	public static class Locators {

		public static final String CLOSINGBRACKET 					= "']",
				CREATEEVENTTEMPLATE 								= "input[value='Create New Event Template']",
				TEMPLATENAME 										= "eventTypeName",
				TEMPLATEDESCRIPTION 								= "definition",
				SAVE 												= "input[value='Save']",
				WEBMAILSELECTALL 									= "//table[@id='tbl_emailInd']//th[contains(text(),'Web')]/input[@name='SELECT_ALL']",
				RESOURCETYPEINPUT 									= "input[name='rt'][value='",
				STATUSTYPEINPUT 									= "input[name='st'][value='",
				WEBNOTIFICATIONINPUT 								= "/preceding-sibling::td/input[@name='webInd']",
				PAGERNOTIFICATIONINPUT 								= "/preceding-sibling::td/input[@name='pagerInd']",
				EMAILNOTIFICATIONINPUT								= "/preceding-sibling::td/input[@name='emailInd']",
				TABLECELLWITHTEXT_PART1								= "//td[text()='",
				ADDRESS_REQUIRED									= "input[name='addressRequired'][class='checkbox']",
				TABLECELLWITHTEXT_PART2								= "/parent::tr/td/a[text()='",
				EVENT_TEMPLATE_LIST_PAGE							= "//h1[text()='Event Template List']",
				MULTI_REGION_CHECKBOX								= "input[name='multiRegion'][class='checkbox']",
				EVENT_ICON 											= "eventIcon",
				EVENT_COLOR 										= "select[name='color']",
				EDIT_LINK                   						= "/preceding-sibling::td/a[text()='Edit']",
                EVENT_SETUP_TABLE 									= "//div[@id='mainContainer']/table/tbody/tr",
                TABLECELL 											= "/td[text()='",
                PAGERSELECTALL										= "//table[@id='tbl_emailInd']//th[contains(text(),'Pager')]/input[@name='SELECT_ALL']",
        		EMAILSELECTALL										= "//table[@id='tbl_emailInd']//th[contains(text(),'Email')]/input[@name='SELECT_ALL']",
        		MY_RESOURCE_SELECT_ALL 								= "//table[@id='tbl_emailInd']//th[contains(text(),'Res?')]/input[@name='SELECT_ALL']",
        		MY_RESOURCE_NOTIFICATION_INPUT						= "/preceding-sibling::td/input[@name='resInd']",
        		CRETAE_NEW_EVENT_TEMPLATE_PAGE 						= "//h1[text()='Create New Event Template']",
        		RESOURCE_TYPES_SECTION 								= "//td[text()='Resource Types:']/parent::tr/td/input[@value='",
        		STATUS_TYPES_SECTION 								= "//td[text()='Status Types:']/parent::tr/following-sibling::tr//tbody//input[@name='st'][@value='",
        		EVENT_NOTIFICATION_PREFERENCES_FOR_EVENT_TEMPLATE	= "//h1[text()='Event Notification Preferences for ",
        		SECURITY 											= "input[name='secured'][class='checkbox']",
        		EVENT_SECURITY_TABLE 								= "//table[@id='tbl_userID']/tbody",
        		SELECT_USER 										= "input[value='",
        		EVENT_TEMPLATE_ICON 								= "/preceding-sibling::td/img[contains(@src,'",
        		CLOSING_BRACKET_WITH_QUOTE							= "')]",
        		COLOUR_ON_EVENT_BANNER								= "//div[@id='eventsBanner']/table//td[contains(@class,'",
        		TABLE_CELL_WITH_TEXT 								= "/a[text()='",
        		ACTIVE_EVENT_TEMPLATE 								= "input[name='active']",
        		INACTIVE_EVENT_TYPES								= "inactive_et",
        		TABLE_CELL_WITH_TEXT_PART1 							= "/following-sibling::td[text()='";
	}
}
