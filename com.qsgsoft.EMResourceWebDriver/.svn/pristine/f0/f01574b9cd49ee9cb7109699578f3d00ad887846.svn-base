package qaframework.lib.testngExtensions;

import java.util.Date;
import java.util.Properties;
import qaframework.lib.WaitTimeConstants;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.UserDefinedFunctions.OfficeCommonFunctions;
import qaframework.lib.UserDefinedFunctions.PathsProperties;

public class TestNG_UI_EXTENSIONSThreeBrowser {

	public WebDriver driver, driver1, driver2;
	
	public String wd_host = "http://localhost:4444/wd/hub"; 
	public String wd_browser = "firefox";
	public String wd_browser1 = "iexplore";
	public String wd_browser2 = "iexplore";
	
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
	public TestNG_UI_EXTENSIONSThreeBrowser() throws Exception {
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void setUp() throws Exception {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setJavascriptEnabled(true);
		
		//Firefox Driver
		this.driver = new FirefoxDriver(cap);
		this.driver.manage().deleteAllCookies();
		this.driver.get("https://emresource.qa.intermedix.com/login.jsp");
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
		
		//IE Driver1
		System.setProperty("webdriver.ie.driver", System.getProperty(
			    "webdriver.ie.driver", "./BrowserDrivers/IEDriverServer.exe"));
				driver1 = new InternetExplorerDriver(cap);
			  driver1.manage().window().maximize();
			  
		this.driver1.manage().deleteAllCookies();
		this.driver1.get("https://emresource.qa.intermedix.com/login.jsp");
		this.driver1
				.manage()
				.timeouts()
				.implicitlyWait(WaitTimeConstants.WAIT_TIME_LONG,
						TimeUnit.SECONDS);
		this.driver1
				.manage()
				.timeouts()
				.pageLoadTimeout(WaitTimeConstants.WAIT_TIME_LONG,
						TimeUnit.SECONDS);
		this.driver1.manage().window().maximize();
		
		//IE Driver2
		System.setProperty("webdriver.ie.driver", System.getProperty(
			    "webdriver.ie.driver", "./BrowserDrivers/IEDriverServer.exe"));
				driver2 = new InternetExplorerDriver(cap);
				driver2.manage().window().maximize();
			  
		this.driver2.manage().deleteAllCookies();
		this.driver2.get("https://emresource.qa.intermedix.com/login.jsp");
		this.driver2
				.manage()
				.timeouts()
				.implicitlyWait(WaitTimeConstants.WAIT_TIME_LONG,
						TimeUnit.SECONDS);
		this.driver2
				.manage()
				.timeouts()
				.pageLoadTimeout(WaitTimeConstants.WAIT_TIME_LONG,
						TimeUnit.SECONDS);
		this.driver2.manage().window().maximize();
		
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
		
		this.driver1.close();
		this.driver1.quit();
		this.driver1 = null;
		
		this.driver2.close();
		this.driver2.quit();
		this.driver2 = null;

		gdbTimeTaken = objOFC.TimeTaken(gdtStartDate);
		
		String Resultpath = pathProps.getProperty("Resultpath");
		strResultPath = System.getProperty("user.dir")+Resultpath;
		
		objOFC.WriteResultdb_Excel(gstrTCID, gstrTO, gstrResult, gstrReason,
				gdbTimeTaken, strResultPath, blnwriteres, gstrTimetake, gstrdate,
				gslsysDateTime, gstrBrowserName, gstrBuild, strSessionId);
	}
}
