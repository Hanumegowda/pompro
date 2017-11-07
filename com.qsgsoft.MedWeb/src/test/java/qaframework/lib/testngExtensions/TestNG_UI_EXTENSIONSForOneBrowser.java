package qaframework.lib.testngExtensions;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import qaframework.lib.WaitTimeConstants;
import qaframework.lib.userDefinedFunctions.Date_Time_settings;
import qaframework.lib.userDefinedFunctions.PathsProperties;
import qaframework.lib.userDefinedFunctions.OfficeCommonFunctions;

public class TestNG_UI_EXTENSIONSForOneBrowser {

	public WebDriver driver;

    public String wd_browser = "iexplore";
	//public String wd_browser = "chrome";
	 //public String wd_browser = "";
	/*browser names
	chrome 
	internet explorer
	MicrosoftEdge
	*/
	

	protected String gstrTCID;
	protected String gstrTO;
	protected String gstrResult;
	protected String gstrReason;
	public static Date gdtStartDate;
	public String gstrBrowserName = wd_browser;

	public static String gstrTimetake, gstrdate, gstrtime, gstrBuild,
			strSessionId, strResultPath;
	protected double gdbTimeTaken;
	protected boolean blnwriteres;
	public static long gslsysDateTime;

	public static String sf;
	public static String bp1;
	public static String bp2 = "";

	// TODO Auto-generated constructor stub
	PathsProperties objAP = new PathsProperties();
	Properties pathProps = objAP.Read_FilePath();

	OfficeCommonFunctions objOFC = new OfficeCommonFunctions();

	public TestNG_UI_EXTENSIONSForOneBrowser() throws Exception {
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	
	// For IE browser
	public void setUp() throws Exception {
		if (wd_browser == "iexplore") {

			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setJavascriptEnabled(true);
			System.setProperty("webdriver.ie.driver", System.getProperty(
					"webdriver.ie.driver",
					"./BrowserDrivers/IEDriverServer4.exe"));
			driver = new InternetExplorerDriver(cap);
			this.driver.manage().deleteAllCookies();
		}

		// For Chrome browser
		else if (wd_browser == "chrome") {
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setJavascriptEnabled(true);
			System.setProperty("webdriver.chrome.driver", System.getProperty(
					"webdriver.chrome.driver",
					"./BrowserDrivers/chromedriver.exe"));

			
			String bp = pathProps.getProperty("BackUpPath");
		    File f = new File(System.getProperty("user.dir")+ bp+"\\"+System.currentTimeMillis());
		    bp1 = f.toString();
			/*File f = new File(System.getProperty("user.dir"));
			String s = f+bp+"\\"+"abc";
		    bp1 = s.toString();*/
			 
			//to handle alert
			System.out.println(bp1 + " this is the download path");
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", bp1);
			ChromeOptions options = new ChromeOptions();
		    //options.setExperimentalOption("safebrowsing.enabled", true);
			//HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
			options.setExperimentalOption("prefs", chromePrefs);
			//options.addArguments("--test-type");
			DesiredCapabilities cap1 = DesiredCapabilities.chrome();
			//cap1.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
			cap1.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			cap1.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new ChromeDriver(cap1);	
			//this.driver.manage().deleteAllCookies();

		}

		// For Edge browser
		else {
			DesiredCapabilities cap = new DesiredCapabilities();
			cap = DesiredCapabilities.edge();
			cap.setJavascriptEnabled(true);
			System.setProperty("webdriver.edge.driver", System.getProperty(
					"webdriver.edge.driver",
					"./BrowserDrivers/MicrosoftWebDriver.exe"));

			driver = new EdgeDriver(cap);
		}

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

	@AfterMethod(alwaysRun = true)
	public void tearDown() throws Exception {

		Thread.sleep(2000);
		// this.driver.close();
		this.driver.quit();
		this.driver = null;

		gdbTimeTaken = objOFC.TimeTaken(gdtStartDate);
		String Resultpath = pathProps.getProperty("Resultpath");
		strResultPath = System.getProperty("user.dir") + Resultpath;
		objOFC.WriteResultdb_Excel(gstrTCID, gstrTO, gstrResult, gstrReason,
				gdbTimeTaken, strResultPath, blnwriteres, gstrTimetake,
				gstrdate, gslsysDateTime, gstrBrowserName, gstrBuild,
				strSessionId);
	}

}
