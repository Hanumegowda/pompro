package CAM.Locators;

public class Login {
	
	public static class Locators {
		
		public static final String USERNAME		= "input[id='j_username']",
				                   PASSWORD		= "input[id='j_password']",
				                   LOGIN		= "input[value='Login']",
				                   LOGINPAGE	= "//h1[text()='Intermedix: CAM']",
				                   HOME			= "//span[@class='pageTitle'][text()='Common Account Management']",
				                   LOGOUT		= "Log Out",
				                   CAM_URL		= "https://cam.qa.intermedix.com/";
	}

}
