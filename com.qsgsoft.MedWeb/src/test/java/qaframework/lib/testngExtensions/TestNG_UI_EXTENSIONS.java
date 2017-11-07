package qaframework.lib.testngExtensions;

import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import qaframework.lib.WaitTimeConstants;
import qaframework.lib.userDefinedFunctions.*;

public class TestNG_UI_EXTENSIONS {
	
public WebDriver driver;
	
	public String wd_host = "http://localhost:4444/wd/hub"; 
	public String wd_browser = "firefox";
	public String wd_browser1 = "iexplore";
	
	protected String gstrTCID;
	protected String gstrTO;
	protected String gstrResult;
	protected String gstrReason;
	public static Date gdtStartDate;
	public String gstrBrowserName = wd_browser1;
	
	public static String gstrTimetake, gstrdate, gstrtime, gstrBuild,
			 strSessionId,strResultPath;
	protected double gdbTimeTaken;
	protected boolean blnwriteres;
	public static long gslsysDateTime;
	
	// TODO Auto-generated constructor stub
	PathsProperties objAP = new PathsProperties();
	Properties pathProps = objAP.Read_FilePath();
	
	OfficeCommonFunctions objOFC= new OfficeCommonFunctions();
	public TestNG_UI_EXTENSIONS() throws Exception {
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void setUp() throws Exception {

		/*DesiredCapabilities cap = new DesiredCapabilities();
		cap.setJavascriptEnabled(true);
*/
		this.driver = new FirefoxDriver();
		//this.driver.manage().deleteAllCookies();
		//this.driver.get("http://192.168.27.93/cobalt/");
		this.driver
				.manage()
				.timeouts()
				.implicitlyWait(WaitTimeConstants.WAIT_TIME_LONG,
						TimeUnit.SECONDS);
		this.driver
				.manage()
				.timeouts()
				.pageLoadTimeout(WaitTimeConstants.WAIT_TIME_LONG,
						TimeUnit.SECONDS);
		this.driver.manage().window().maximize();
		
		
		
		gstrResult = "FAIL";
		Date_Time_settings dts = new Date_Time_settings();
		gstrTimetake = dts.timeNow("HH:mm:ss");
		gstrdate = dts.getCurrentDate("yyyy-MM-dd");
		gdtStartDate = new Date();
		blnwriteres = false;
	}

	@AfterMethod
	public void tearDown() throws Exception {
		this.driver.close();
		this.driver.quit();
		this.driver = null;
		

		gdbTimeTaken = objOFC.TimeTaken(gdtStartDate);
		
		String Resultpath = pathProps.getProperty("Resultpath");
		strResultPath = System.getProperty("user.dir")+Resultpath;
		
		objOFC.WriteResultdb_Excel(gstrTCID, gstrTO, gstrResult, gstrReason,
				gdbTimeTaken, strResultPath, blnwriteres, gstrTimetake, gstrdate,
				gslsysDateTime, gstrBrowserName, gstrBuild, strSessionId);
	}
}


