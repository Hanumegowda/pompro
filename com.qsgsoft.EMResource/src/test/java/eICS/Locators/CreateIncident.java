package eICS.Locators;

public class CreateIncident {

	public static class Locators {
		public static final String CLOSING_BRACKETS = "']",
				CREATE_INCIDENT_PAGE= "//span[@id='navbar_Navigation2_contentTitle'][text()='Create Incident']",
				FACILITY			= "#body_createIncidentFacilities",
				IRG_PART1			= "//table[@id='irgList']//td[text()='",
				NEXT				= "#nextPage",
				INCIDENT_NAME		= "#incidentName",
				INCIDENT_DESCRIPTION= "#incidentDescription",
				SELECT_NOTIFICATION_CONTACTS= "#selectNotificationMethodButton",
				VOICE_NOTIFICATION  = "#notifyByVoiceMaster",
				MAIL_NOTIFICATION_	= "#notifyByEmailMaster",
				OK_BUTTON			= "//span[text()='Select Notification Contacts']/parent::div/following-sibling::div//span[text()='OK']",
				ACTIVATE_INCIDENT	= "input[value='Activate Incident']",
				CREATED_INCIDENT_NAME = "//span[@id='body_headerIncidentName'][text()='";
	}
}