package EMR.Locators;

public class UsersList {
	public static class Locators {
		public static final String CLOSEBRACKETS 					= "']",
				TABLE_CELL_WITH_TEXT								= "//td[text()='",
				CREATENEWUSER 										= "input[value='Create New User']",
				USERNAME 											= "userID",
				INITPASSWORD 										= "newPass",
				CONFIRMPASSWORD 									= "confirmPass",
				FIRSTNAME											= "firstName",
				FULLNAME 											= "fullName",
				LASTNAME											= "lastName",
				ORGANIZATION										= "organization",
				PHONENUMBER											= "phone",
				SAVE 												= "input[value='Save']",
				ADVANCEDOPTIONBUTTON 								= "//table[@class='displayTable']//th[contains(text(),'Advanced Options')]/img",
				RESOURCELISTPART1 									= "//table[@id='tbl_association']/tbody/tr/td[text()='",
				UPDATERIGHT 										= "']/preceding-sibling::td/input[@name='updateRight']",
				VIEWRIGHT											= "']/preceding-sibling::td/input[@name='viewRight']",
				MAINTAINEVENTS 										= "input[name='rightID'][value='13']",
				UPDATESTATUSALL 									= "input[value='updateRight'][name='SELECT_ALL']",
				MAINTAINEVENTTEMPLATE 								= "input[name='rightID'][value='14']",
				SETUPREGIONVIEWS 									= "input[name='rightID'][value='51']",
				CONFIGUREREGIONALUSERACCESS 						= "input[name='rightID'][value='5']",
				SEARCHFIELD 										= "tblUsers_SEARCH_TEXT",
				SEARCH 												= "input[id='tblUsers_SEARCH']",
				USERSTABLE 											= "//table[@id='tblUsers']/tbody/tr/td[2][text()='",
				PRIMARYEMAIL 										= "primaryEMail",
				TEXTPAGER 											= "textPager",
				USERMAYACTIVATEFORM 								= "input[name='rightID'][value='32']",
				USERMAYCREATEANDMODIFYFORMS 						= "input[name='rightID'][value='39']",
				EDITLINKOFUSER 										= "']/parent::tr/td[1]/a[text()='Edit']",
				SELECTROLEPART1 									= "//input[@value='",
				SLECTROLEPART2 										= "'][@name='userRoleID']",
			    FIRSTROLE 											= "//input[@name='userRoleID'][1]",
			    IMPORT_USERS										= "input[value='Import User']",
			    EDIT_USERS_SCREEN									= "//h1[text()='Edit User']",
			    RECEIVEINCOMINGPATIENTNOTIFICATION 					= "input[name='rightID'][value='72']",
                SYSTEMNOTIFICATIONPREFERNCES						= "System Notification Preferences",
                EMAIL 												= "//td/span[text()='Incoming Patient Notifications']/parent::td/parent::tr/td/input[@name='emailInd']",
		        PAGER 												= "//td/span[text()='Incoming Patient Notifications']/parent::td/parent::tr/td/input[@name='pagerInd']",
		        SYSTEMNOTIFICATIONPREFERNCESPGAEFORUSER				= "//div[@id='topSubNav']/h1[text()='System Notification Preferences for ",
		        RESOURCEUPDATERIGHT									= "//tr/td[text()='",
		        STATUSCHANGENOTIFICATIONSPREFERENCES				= "Status Change Notification Preferences",
		        VIEWOTHERREGIONS									= "//tr/td[text()='View Other Regions:']/following-sibling::td[text()='",
		        VIEW_CUSTOM_VIEW_RIHT								= "input[value='26']",
		        SETUP_OTHER_REGION_VIEWS_RIGHT						= "input[value='53']",
		        EDIT_STATUS_CHANGE_NOTIFICATION_PREFERENCES			= "input[value='12']",
		        WEBSERVICE                      					= "webServices",
		        SEND_INCOMING_PATIENT_NOTIFICATIONS					= "input[name='rightID'][value='74']",
		        WEB_SERVICE_ACCOUNT_ERROR							= "//h1[text()='Web Service Account Error']",
		 	    WEB_SERVICE_ACCOUNT_ERROR_MESSAGE_BODY				= "//div[@id='mainContainer']",
		 	    OTHER_REGION_VIEW_SECTION_DISABLED          		= "//td/input[@name='otherRegionViewID'][@checked='checked'][@disabled='disabled'][@value='",
		 	    OTHER_REGION_VIEW_SECTION_ENABLED           		= "//td/input[@name='otherRegionViewID'][@value='",
		 	    REPORT_INCOMING_PATIENT_NOTIFICATION_DETAIL_RIGHT	= "input[name='rightID'][value='73']",
		 	    TABLE_CELL_WITH_TEXT_PART1							= "']/parent::tr/td/a[text()='",
		 	    USER_REGIONS										= "input[name='regionID'][value='",
		 	    EDIT_USERS_REGIONS_SCREEN							= "//h1[text()='Edit User Regions']",
		 	    SETUP_RESOURCES_ADD_AND_EDIT_RIGHT					= "input[value='4']",
		 	    SETUP_RESOURCES_EDIT_ONLY_RIGHT						= "input[value='20']",
		 	    USERS_LIST_SCREEN									= "//h1[text()='Users List']",
		 	    VIEW_RESOURCE_RIGHT_SELECT_ALL						= "input[value='viewRight'][name='SELECT_ALL']",
		 	    MULTI_REGION_EVENT_RIGHTS_LINK						= "//a[contains(text(),'Multi-Region Event Rights')]",
		 	    MULTI_REGION_EVENT_RIGHTS_FOR_USER 					= "input[name='userRegionID'][value='",
		 	    SECONDARY_EMAIL										= "eMail",
		 	    PREFERENCES_EDIT_STATUS_CHANGE_NOTIFICATIONS_RIGHT	= "input[value='12']",
		 	    EVENT_MAINTAIN_AD_HOC_EVENT							= "input[value='15']",
		 	    RUN_REPORT_RIGHT									= "']/preceding-sibling::td/input[@name='reportRight']",
		 	    ASSOCIATE_RIGHT										= "']/preceding-sibling::td/input[@name='association']",
		 	    OVERRIDE_VIEWING_RESTRICTION						= "input[name='rightID'][value='55']",  
		        STATUS_SNAPSHOT_RIGHT                               = "input[name='rightID'][value='43']",
			 	EVENT_SNAPSHOT_RIGHT                                = "input[name='rightID'][value='49']",
		        USER_MAY_CREAT_AND_MODIFY_FORMS					    = "input[value='39']",
				SETUP_STATUS_TYPE_RIGHT					            = "input[value='1']",
				SETUP_ROLES_RIGHT					                = "input[value='11']",
				SETUP_RESOURCE_TYPES_RIGHT                          = "input[value='2']",
				MAINTAIN_EVENT_TEMPLATE_RIGHT					    = "input[value='14']",
				VIEW_OTHER_REGION_SELECT_ALL						= "input[value='otherRegionViewID'][name='SELECT_ALL']",
				STATUS_REASON_RIGHT					                = "input[value='3']",
				REFINE_RESOURCE										= "/preceding-sibling::td/a[text()='Refine']",
				WEB_NOTIFICATION_FRAME 								= "TB_iframeContent",
				STATUS_TYPE_ID 										= "input[name='statusTypeID'][value='",
				SAVE_CHANGES_ON_REFINE_WINDOW 						= "//p[1]//input[@value='Save Changes']",
				VIEW_RESOURCE_RIGHT_OF_RESOURCE 					= "']/preceding-sibling::td/input[@name='viewRight']",
				PREFRENCES_EDIT_EVENT_NOTIFICATION_PREFERENCES		= "input[name='rightID'][value='10']",
				EVENT_NOTIFICATION_PREFERENCES						= "//a[contains(text(),'Event Notification Preferences')]",
				EVENT_NOTIFICATION_PREFERENCES_FOR_USER				= "//h1[text()='Event Notification Preferences for ",
				SEARCH_OPTIONS_ROLE									= "tblUsers_ROLE",
				SEARCH_OPTIONS_RESOURCE_TYPE						= "tblUsers_RESOURCE_TYPE",
				SEARCH_OPTIONS_SEARCH_FIELD							= "tblUsers_SEARCH_FIELD",
				SEARCH_OPTIONS_CONDITION							= "tblUsers_SEARCH_OPERATOR",
				SWITCH_PART2										= "']/preceding-sibling::td/a[text()='Switch']",
				RETURN_TO_SELF										= "//li/a[text()='Return to Self']",
				ALL_ROLES											= "//td[text()='Roles:']/following-sibling::td/input",
				ROLE_VALUE_IN_TABLE       						    = "//input[@value='",
			    ROLE_VALUE_IN_TABLE_PART1 							= "[@name='userRoleID']",
			    CANCEL												= "input[value='Cancel']",
			    ROLE_IN_DROPDOWN									= "//select[@id='tblUsers_ROLE']/option[@value='",
			    INSTANT_MESSAGING_INTIATE_CHAT_SESSION				= "input[value='54']",
			    REPORT_STATUS_SUMMARY								= "input[value='40']",
			    SETUP_STATUS_REASON									= "input[value='3']";
	}
}