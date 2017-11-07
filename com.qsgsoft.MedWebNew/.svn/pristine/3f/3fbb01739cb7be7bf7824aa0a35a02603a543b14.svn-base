package qaframework.lib.testngExtensions;

import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import qaframework.lib.WaitTimeConstants;
import qaframework.lib.userDefinedFunctions.Date_Time_settings;
import qaframework.lib.userDefinedFunctions.OfficeCommonFunctions;
import qaframework.lib.userDefinedFunctions.PathsProperties;

public class TestNG_UI_EXTENSIONSForTwoBrowsers {
	
	public WebDriver driver,driver1 ;

	public String wd_browser = "iexplore";
	public String wd_browser1 = "iexplore";
	
	protected String gstrTCID;
	protected String gstrTO;
	protected String gstrResult;
	protected String gstrReason;
	public static Date gdtStartDate;
	public String gstrBrowserName = wd_browser;
	
	public static String gstrTimetake, gstrdate, gstrtime, gstrBuild,
			 strSessionId,strResultPath;
	protected double gdbTimeTaken;
	protected boolean blnwriteres;
	public static long gslsysDateTime;
	
	// TODO Auto-generated constructor stub
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();
		OfficeCommonFunctions objOFC= new OfficeCommonFunctions();
		
		public TestNG_UI_EXTENSIONSForTwoBrowsers() throws Exception {
			// TODO Auto-generated constructor stub
		}
		
		@BeforeMethod
		public void setUp() throws Exception {

			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setJavascriptEnabled(true);
			
			//IE Driver
			System.setProperty("webdriver.ie.driver", System.getProperty(
				    "webdriver.ie.driver", "./BrowserDrivers/IEDriverServer4.exe"));
					driver = new InternetExplorerDriver(cap);
				  driver.manage().window().maximize();
				  
			this.driver.manage().deleteAllCookies();
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
			
			//IE Driver1
			System.setProperty("webdriver.ie.driver", System.getProperty(
				    "webdriver.ie.driver", "./BrowserDrivers/IEDriverServer4.exe"));
					driver1 = new InternetExplorerDriver(cap);
					driver1.manage().window().maximize();
				  
			this.driver1.manage().deleteAllCookies();
			//this.driver1.get("http://192.168.27.93/cobalt/");
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
			
			gstrResult = "FAIL";
			Date_Time_settings dts = new Date_Time_settings();
			gstrTimetake = dts.timeNow("HH:mm:ss");
			gstrdate = dts.getCurrentDate("yyyy-MM-dd");
			gdtStartDate = new Date();
			blnwriteres = true;
		}

		@AfterMethod
		public void tearDown() throws Exception {
			this.driver.close();
			this.driver.quit();
			this.driver = null;
			
			this.driver1.close();
			this.driver1.quit();
			this.driver1 = null;
			
			gdbTimeTaken = objOFC.TimeTaken(gdtStartDate);
			
			String Resultpath = pathProps.getProperty("Resultpath");
			strResultPath = System.getProperty("user.dir")+Resultpath;
			objOFC.WriteResultdb_Excel(gstrTCID, gstrTO, gstrResult, gstrReason,
					gdbTimeTaken, strResultPath, blnwriteres, gstrTimetake, gstrdate,
					gslsysDateTime, gstrBrowserName, gstrBuild, strSessionId);
		}

	}


