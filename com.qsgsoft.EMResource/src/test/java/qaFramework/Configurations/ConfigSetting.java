package qaFramework.Configurations;

import java.util.Date;

import org.openqa.selenium.WebDriver;

public class ConfigSetting {

	public WebDriver driver;
	
	public String wd_host = "http://localhost:4444/wd/hub"; 
	public String wd_browser = "iexplore";
	
	protected String TCID;
	protected String TC_DESCRIPTION;
	protected String Result;
	protected String Reason;
	protected boolean writeToTool = false;
	
	public static Date gdtStartDate;
	public String gstrBrowserName = wd_browser;
	
	public static String gstrTimetake, gstrdate, gstrtime, gstrBuild,
			 strSessionId,strResultPath;
	protected double gdbTimeTaken;
	
	public static long gslsysDateTime;
}