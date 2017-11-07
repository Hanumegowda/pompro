package EMR.data;

import qaFramework.UserDefinedFunctions.Date_Time_settings;
import qaFramework.UserDefinedFunctions.ReadAndWriteFromXMLFile;

public class UsersData {
	
	public UsersData() throws Exception {
		
	}
	ReadAndWriteFromXMLFile xml = new ReadAndWriteFromXMLFile();
	static final String FILEPATH = "UsersDataXml";
	
	public static final String INITIAL_PASSWORD  	= "Abcd@1234",
			   PASSWORD   			= "Abc@1234",
			   RESET_PASSWORD_1  	= "Qsg@2015",
			   PRIMARY_EMAILID   	= "autoemres@outlook.com",
			   EMAILPASSWORD   		= "Qsg@2006",
			   EMAILID1    			= "autoemres_1@outlook.com",
			   EMAILID2    			= "autoemre_2@outlook.com",
			   ORGANIZATION         = "QSG",
			   USER					= "Setracuser2",
			   REGION_LINK			= "Regions",
			   SECURITY_ANSWER		= "1234",
			   SEARCH_ROLE			= "(Any Role)",
			   SEARCH_RT			= "(Any Resource Type)",
			   SEARCH_FIELD_USERNAME= "Username",
			   SEARCH_CRITERIA		= "Contains";
	
	public final String eventsUserName										= xml.read(UsersTags.EVENTS_USERNAME, FILEPATH),
			eventsUserFullName												= xml.read(UsersTags.EVENTS_USERFULLNAME, FILEPATH),
	        setracIPNUser               									= xml.read(UsersTags.SETRAC_IPN_USER, FILEPATH),
	        userToFillOut               									= xml.read(UsersTags.USER_TO_FILLOUT_FORM, FILEPATH),
	        userToActivateForm          									= xml.read(UsersTags.USER_TO_ACTIVATE_FORM, FILEPATH),
	        userToReceiveCompletedForm  									= xml.read(UsersTags.USER_TO_RECEIVE_COMPLETED_FORM, FILEPATH),
	        userWithUpdateRightOnFreemanWest								= xml.read(UsersTags.USER_WITH_UPDATE_RIGHT_ON_FRREMAN_WEST, FILEPATH),
	        userFullnameToActivateForm      								= xml.read(UsersTags.USERFULLNAME_TO_ACTIVATE_FORM, FILEPATH),
	        userFullnameToFillOutForm       								= xml.read(UsersTags.USERFULLNAME_TO_FILLOUT_FORM, FILEPATH),
	        userFullnameToReceiveCompletedForm  							= xml.read(UsersTags.USERFULLNAME_TO_RECEIVE_COMPLETED_FORM, FILEPATH),
	        userInMutualAgreementRegion2									= xml.read(UsersTags.USER_IN_MUTUAL_AID_REGION2, FILEPATH),
	        preferanceUser                      							= xml.read(UsersTags.STATUS_CHANGE_PREFERNCEUSER, FILEPATH),
	        preferanceUserFullName              							= xml.read(UsersTags.STATUS_CHANGE_PREFERNCEFULLNAME, FILEPATH),
	        interfaceRelatedUser                  							= xml.read(UsersTags.INTERFACE_RELATED_USER, FILEPATH),
	        interfaceRelatedUserFullName									= xml.read(UsersTags.INTERFACE_RELATED_USER_FULLNAME, FILEPATH),
	        interfaceRelatedWebSerivceUser									= xml.read(UsersTags.INTERFACE_RELATED_WEB_SERVICE_USER, FILEPATH),
	        interfaceRelatedWebSerivceUserFullName							= xml.read(UsersTags.INTERFACE_RELATED_WEB_SERVICE_USER_FULLNAME, FILEPATH),
	        SetracUserWithSendIncomingPatientNotificationsRight				= xml.read(UsersTags.SETRAC_USER_WITH_SEND_INCOMING_PATIENT_NOTIFICATION_RIGHT, FILEPATH),
	        SetracUserWithSendIncomingPatientNotificationsRightFullname		= xml.read(UsersTags.SETRAC_USER_WITH_SEND_INCOMING_PATIENT_NOTIFICATION_RIGHT_FULLNAME, FILEPATH),
	        SetracUserWithReceiveIncomingPatientNotificationsRight			= xml.read(UsersTags.SETRAC_USER_WITH_RECEIVE_INCOMING_PATIENT_NOTIFICATION_RIGHT, FILEPATH),
	    	SetracUserWithReceiveIncomingPatientNotificationsRightFullname	= xml.read(UsersTags.SETRAC_USER_WITH_RECEIVE_INCOMING_PATIENT_NOTIFICATION_RIGHT_FULLNAME, FILEPATH),
	    	userWithViewCustomViewRight										= xml.read(UsersTags.USER_WITH_VIEW_CUTOM_VIEW_RIGHT, FILEPATH),
	    	UserInMutualAidRegion1_WithAdditionalRights						= xml.read(UsersTags.USER_IN_MUTUAL_AID_REGION_1, FILEPATH),
	    	UserInMutualAidRegion2_WithAdditionalRights						= xml.read(UsersTags.USER_IN_MUTUAL_AID_REGION_2, FILEPATH),
	    	UserInMutualAidRegion3_WithNoRights								= xml.read(UsersTags.USER_IN_MUTUAL_AID_REGION_3, FILEPATH),
	    	MultiRegionEventUser											= xml.read(UsersTags.MULTI_REGION_EVENT_USER, FILEPATH),
	    	MultiRegionEventUserFullName									= xml.read(UsersTags.MULTI_REGION_EVENT_USER_FULLNAME, FILEPATH),
	    	UserWithSetUpOtherRegionViewRight								= xml.read(UsersTags.USER_WITH_SETUP_OTHER_REGION_VIEW_RIGHT_IN_REGION, FILEPATH),
	    	UserFullNameWithSetUpOtherRegionViewRight						= xml.read(UsersTags.USER_FULLNAME_WITH_SETUP_OTHER_REGION_VIEW_RIGHT_IN_REGION, FILEPATH);
	        
	public class UsersCreateData {
		
	Date_Time_settings dts = new Date_Time_settings();
	String timeText = dts.getCurrentDate("MM-dd-yyyy-hhmmss"),
			timeStamp = "" + System.currentTimeMillis();
 
	public void writeUsersDataToXml(String value, String node) throws Exception {
		xml.write(FILEPATH, value, node);
	}
	
	public String 	name      			= "User"  + timeStamp,
			        name1 	  			= "User1" + timeStamp,
			        name2     			= "User2" + timeStamp,
			        name3     			= "User3" + timeStamp,
			        name4				= "user4" + timeStamp,
			        webServiceName		= "WebService"+timeStamp,
					fullName  			= "FN"    + name,
					fullName1 			= "FN1"   + name,
					fullName2 			= "FN2"   + name,
					fullName3 			= "FN3"   + name,
					fullName4 			= "FN4"   + name,
					webServiceFullName	= "WebServiceFullName"+timeStamp,
					name5				= "user5" + timeStamp,
					fullName5			= "FN5"   + name,
					MRE_name5			= "MREuser5" + timeStamp,
					MRE_fullName5		= "MREFN5"   + name,
					MRE_name6			= "MREuser6" + timeStamp,
					MRE_fullName6		= "MREFN6"   + name,
					name6				= "user6" + timeStamp,
					name7				= "user7" + timeStamp,
					name8				= "user8" + timeStamp,
					fullName6			= "FN6"   + name,
					fullName7			= "FN7"   + name,
					fullName8			= "FN8"   + name,
					name9				= "user9" + timeStamp,
					name10				= "user10" + timeStamp,
					name11				= "user11" + timeStamp,
					name12				= "user12" + timeStamp,
					fullName9			= "FN9"   + name,
					fullName10			= "FN10"   + name,
					fullName11			= "FN11"   + name,
					fullName12			= "FN12"   + name;
	}
	
	public static class UsersTags {
	public static final String 
					EVENTS_USERNAME				           									= "SmokeEventsUserName",
					EVENTS_USERFULLNAME			           									= "SmokeEventsUserFullName",
					USER_TO_ACTIVATE_FORM			      									= "userToActivate",
				    USER_TO_FILLOUT_FORM				   									= "userToFillOut",
					SETRAC_IPN_USER             		   									= "SetracIpnUser",
					USER_TO_RECEIVE_COMPLETED_FORM         									= "userToReceiveCompletedForm",
					USER_WITH_UPDATE_RIGHT_ON_FRREMAN_WEST 									= "UserWithUpdateRightOnFreemanWest",
					STATUS_CHANGE_PREFERNCEUSER            									= "PreferanceUserName",
					STATUS_CHANGE_PREFERNCEFULLNAME 	   									= "PreferanceUserFullName",
					USER_IN_MUTUAL_AID_REGION2            									= "MutualAidUserName",
					USERFULLNAME_IN_MUTUAL_AID_REGION2      								= "MutualAidUserFullName",
					USERFULLNAME_TO_ACTIVATE_FORM           								= "userFullnameToActivateForm",
					USERFULLNAME_TO_FILLOUT_FORM            								= "userFullnameToFillOutForm",
					USERFULLNAME_TO_RECEIVE_COMPLETED_FORM  								= "userFullnameToReceiveCompletedForm",
					SETRAC_IPN_USER_FULLNAME                								= "SetracIpnUserFullName",
					INTERFACE_RELATED_USER			        								= "InterfaceUser",
					INTERFACE_RELATED_USER_FULLNAME	        								= "InterfaceUserFullName",
					INTERFACE_RELATED_WEB_SERVICE_USER      								= "InterfacewebServiceUserName",
					INTERFACE_RELATED_WEB_SERVICE_USER_FULLNAME								= "InterfacewebServiceUserFullName",
					USER_WITH_VIEW_CUTOM_VIEW_RIGHT											= "UserWithViewCustomViewRight",
					USER_FULLNAME_VIEW_CUTOM_VIEW_RIGHT										= "FullNameOfUserWithViewCustomViewRight",
					SETRAC_USER_WITH_SEND_INCOMING_PATIENT_NOTIFICATION_RIGHT				= "SetracUserWithSendIncomingPatientNotificationsRight",
				    SETRAC_USER_WITH_SEND_INCOMING_PATIENT_NOTIFICATION_RIGHT_FULLNAME		= "SetracUserWithSendIncomingPatientNotificationsRightFullname",
				    SETRAC_USER_WITH_RECEIVE_INCOMING_PATIENT_NOTIFICATION_RIGHT			= "SetracUserWithReceiveIncomingPatientNotificationsRight",
				    SETRAC_USER_WITH_RECEIVE_INCOMING_PATIENT_NOTIFICATION_RIGHT_FULLNAME	= "SetracUserWithReceiveIncomingPatientNotificationsRightFullname",
				    USER_IN_MUTUAL_AID_REGION_1												= "UserInMutualAidRegion1_WithAdditionalRights",
				    USER_IN_MUTUAL_AID_REGION_2												= "UserInMutualAidRegion2_WithAdditionalRights",
				    USER_IN_MUTUAL_AID_REGION_3												= "UserInMutualAidRegion3_WithNoRights",
				    USER_WITH_SETUP_OTHER_REGION_VIEW_RIGHT_IN_REGION						= "userWithSetupOtherRegionViewRightInRegion",
				    USER_FULLNAME_WITH_SETUP_OTHER_REGION_VIEW_RIGHT_IN_REGION				= "userFullNameWithSetupOtherRegionViewRightInRegion",
				    MULTI_REGION_EVENT_USER													= "multiRegionEventUser",
				    MULTI_REGION_EVENT_USER_FULLNAME										= "multiRegionEventUserFullName";
	}
}