package EMR.Locators;

public class ViewResourceDetail {

	public static class Locators {

		public static final String CLOSEBRACKET    		= "']",
				VIEW_RESOURCE_DETAIL_PAGE				= "//div[@id='topSubNav']/h1[text()='Detail View']",
				VIEW_RESOURCE_DETAIL_OF_RESOURCE_PART1	= "//h1[@id='r_name'][text()='",
				INCIDENT_COMMAND_SYSTEM					= "//div[@id='hics']/div/h1[text()='Incident Command System']",
				INCIDENT_IN_ICS_SECTION_PART1			= "//form[@id='form1']/div/h2[text()='",
				INCIDENT_IN_ICS_SECTION_PART2			= "']/following-sibling::div[text()='",
				HICS_FRAME								= "hicsframe",
				VIEW_RESOURCE_DETAIL                    = "//h1[text()='Detail View']",
				RESOURCE_IN_RESOURCE_DETAIL             = "//h1[@id='r_name']",
				STATUSTYPES_UNDER_SECTION               = "//a[text()='",
				STATUSTYPES_UNDER_SECTION_PART1         = "//ancestor::tbody/ancestor::table/thead/tr/th[2]/a[text()='",
				TABLE_DATA_TEXT                         = "//td/a[text()='", 
				FOLLOWING_TABLE_DATA                    = "/following::td[1]",
				SHOW_ALL                                = ".selectionLink.showAll>b",
				VERIFY_UPDATED_VALUES                   = "/following::td[text()='",
				RESOURCE_NAME_IN_VIEW_RESOURCE_DETAIL	= "//div[@id='resource_summary']//h1[text()='",
				EDIT_LINK_OF_RESOURCE					= "']/following-sibling::a[text()='edit']",
				STATUSTYPES_VALUES_UNDER_SECTION        = "//td/a[@class='st_",
				TRAFFIC_IN_MAP							= "//div[text()='Traffic']",
				MAP_TAG_IN_MAP							= "//div[text()='Map']",
				SATELLITE_IN_MAP						= "//div[text()='Satellite']",
				RESOURCE_TYPE							= "rt";
	}
}



