package qaframework.lib.testngExtensions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import qaframework.lib.WaitTimeConstants;
import qaframework.lib.UserDefinedFunctions.*;

public class TestNG_UI_EXTENSIONS {

	public WebDriver driver, driver1;
	
	public String wd_host = "http://localhost:4444/wd/hub"; 
	public String wd_browser = "firefox";
	public String wd_browser1 = "iexplore";
	
	protected String gstrTCID;
	protected String gstrTO;
	protected String gstrResult;
	protected String gstrReason;
	private static StringBuilder report;
	public static Date gdtStartDate;
	public String gstrBrowserName = wd_browser1;
	
	public static String gstrTimetake, gstrdate, gstrtime, gstrBuild,
			 strSessionId,strResultPath, strScreenshot_Path;
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
	Date_Time_settings dts = new Date_Time_settings();
	@BeforeMethod
	public void setUp() throws Exception {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setJavascriptEnabled(true);

//		this.driver = new FirefoxDriver(cap);
//		this.driver.manage().deleteAllCookies();
//		this.driver.get("https://emresource.qa.intermedix.com/login.jsp");
//		this.driver
//				.manage()
//				.timeouts()
//				.implicitlyWait(WaitTimeConstants.WAIT_TIME_LONG,
//						TimeUnit.SECONDS);
//		this.driver
//				.manage()
//				.timeouts()
//				.pageLoadTimeout(WaitTimeConstants.WAIT_TIME_LONG,
//						TimeUnit.SECONDS);
//		this.driver.manage().window().maximize();
		
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
		driver = driver1;
		gstrResult = "FAIL";
		gstrTimetake = dts.timeNow("HH:mm:ss");
		gstrdate = dts.getCurrentDate("yyyy-MM-dd");
		gdtStartDate = new Date();
		blnwriteres = true;
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws Exception {
//		this.driver.close();
//		this.driver.quit();
//		this.driver = null;
		String screenshotPath = pathProps.getProperty("ScreenShotFolder");
		strScreenshot_Path = System.getProperty("user.dir")+screenshotPath;
		System.out.println(strScreenshot_Path);
		
		if(ITestResult.FAILURE == result.getStatus()) {
			TakesScreenshot ts = (TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			String FailedTC_ID = "";
			if(result.getName().contains("testHappyDay")){
				FailedTC_ID = (result.getName()).replace("testHappyDay", "");
				FailedTC_ID = FailedTC_ID + "_HD" + "_"+ dts.getCurrentDate("d_M_yyyy_HH_mm");
			} else {
				FailedTC_ID = (result.getName()).replace("testEdgeCase", "");
				FailedTC_ID = FailedTC_ID + "_EC" + "_"+ dts.getCurrentDate("d_M_yyyy_HH_mm");
			}
			 
			FileUtils.copyFile(source, new File(strScreenshot_Path + "/"+ FailedTC_ID +".png"));
		}
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