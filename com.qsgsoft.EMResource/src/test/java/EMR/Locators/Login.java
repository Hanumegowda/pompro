package EMR.Locators;

public class Login {

	public static class Locators {
		
		public static final String USERNAME = "input[name='loginName']",
				PASSWORD 							= "input[name='password']",
				LOGIN 								= "input[value='Log In']",
				CURRENTPASSWORD						= "#currentPassword",
				NEWPASSWORD 						= "#newPassword",
				CONFIRMPASSWORD 					= "#confirmPassword",
				SUBMIT 								= "submitButton",
				LOGOUT 								= "//ul[@id='subNavList']/li/a[contains(text(),'Log')]",
				RESPONSE 							= "#response",
				CANCEL 								= "input[value='Cancel']",
				FRAME 								= "Data",
				ACKNOWLWDGENOTIFICATION 			= "//button[text()='Acknowledge All Notifications']",
				WEBNOTIFICATIONFRAME 				= "TB_iframeContent",
				FRAME_DATA 							= "//frame[@name='Data']",
				WHEN_WEB_NOTIFICATION_IS_PRESENT	= "//div[@id='TB_overlay']",
				WEBNOTIFICATIONS_TITLE				= "//div[@id='TB_title']",
				CLOSE_OF_WEB_NOTIFICATION           = "TB_closeWindowButton",
			    SUCCESS_MESSAGE_SAVING_SECURITY_QUEST= "//div[@id='headingSubtitle'][text()='Your security question and answer have been saved.']";
	}
}
