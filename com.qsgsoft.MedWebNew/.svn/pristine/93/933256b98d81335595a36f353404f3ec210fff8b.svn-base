package qaframework.lib.testngExtensions;

import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import dataObject.User_data;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import qaframework.lib.WaitTimeConstants;
import qaframework.lib.userDefinedFunctions.Date_Time_settings;
import qaframework.lib.userDefinedFunctions.OfficeCommonFunctions;
import qaframework.lib.userDefinedFunctions.PathsProperties;

public class TestNG_UI_EXTENSIONSchrome {
	
public WebDriver driver;
	
	public String wd_browser = "chromeexplore";
	
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
	
	public static String sf;
	public static String bp1="";
	
	// TODO Auto-generated constructor stub
	PathsProperties objAP = new PathsProperties();
	Properties pathProps = objAP.Read_FilePath();
	User_data objUser_data = new User_data();

	OfficeCommonFunctions objOFC= new OfficeCommonFunctions();
	public TestNG_UI_EXTENSIONSchrome() throws Exception {
		// TODO Auto-generated constructor stub
	}
		
	@BeforeMethod
	public void setUp() throws Exception {
		System.out.println();

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setJavascriptEnabled(true);
      System.setProperty("webdriver.chrome.driver", System.getProperty(
				"webdriver.chrome.driver", "./BrowserDrivers/chromedriver.exe"));
     /* driver = new ChromeDriver();
		driver.manage().window().maximize();
		this.driver.manage().deleteAllCookies();*/
		//==========================================================================
		/*HashMap<String, Object> cp = new HashMap<String, Object>();
		cp.put("profile.default_content_settings.popups", 0);
		cp.put("download.default_directory", bp1);
		ChromeOptions opts = new ChromeOptions();
		opts.setExperimentalOption("prefs", cp);
		new DesiredCapabilities();
		DesiredCapabilities dc = DesiredCapabilities.chrome();
		dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		dc.setCapability(ChromeOptions.CAPABILITY, opts);
		 driver = new ChromeDriver(dc);
			driver.manage().window().maximize();
			this.driver.manage().deleteAllCookies();*/
		
  //==========================================================================
      sf = objUser_data.strFile;
	     String bp = pathProps.getProperty("BackUpPath");
	  	// File f = new File(System.getProperty("user.dir")+ bp);
	   	  bp1 = System.getProperty("user.dir")+bp +"\\"+sf
	  			/*+ ".csv"*/;
     
 	 System.out.println(bp1+" this is the download path");
     HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
     chromePrefs.put("profile.default_content_settings.popups", 0);
     chromePrefs.put("download.default_directory", bp1);
     ChromeOptions options = new ChromeOptions();
    // options.setExperimentalOption("safebrowsing.enabled", true);
     HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
     options.setExperimentalOption("prefs", chromePrefs);
     options.addArguments("--test-type");
     DesiredCapabilities cap1 = DesiredCapabilities.chrome();
     cap1.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
     cap1.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
     cap1.setCapability(ChromeOptions.CAPABILITY, options);
     driver = new ChromeDriver(cap1); 
     driver.manage().window().maximize();
		this.driver.manage().deleteAllCookies();
		
			
	//======================================================================
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



