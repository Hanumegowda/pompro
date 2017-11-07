package qaFramework.Configurations;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import qaFramework.UserDefinedFunctions.Date_Time_settings;
import qaFramework.UserDefinedFunctions.OfficeCommonFunctions;
import qaFramework.UserDefinedFunctions.PathsProperties;

public class Configuration extends ConfigSetting {

	public Configuration() throws Exception {
		// TODO Auto-generated constructor stub
	}
	
	// TODO Auto-generated constructor stub
	PathsProperties objAP = new PathsProperties();
	Properties pathProps = objAP.Read_FilePath();
	
	OfficeCommonFunctions objOFC= new OfficeCommonFunctions();
	Date_Time_settings dts = new Date_Time_settings();
	@BeforeMethod
	public void setResultToFalse() throws Exception {
		Result = "FAIL";
	}
	
	@BeforeClass
	public void setUpMethod() throws Exception {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName(wd_browser);

		//Actual browser
		switch (wd_browser) {
		case "iexplore":
			System.setProperty("webdriver.ie.driver", System.getProperty(
					"webdriver.ie.driver", "./BrowserDrivers/IEDriverServer.exe"));
			driver = new InternetExplorerDriver(cap);
			break;

		case "chrome":
			System.setProperty("webdriver.chrome.driver", System.getProperty(
					"webdriver.chrome.driver", "./BrowserDrivers/chromedriver.exe"));

			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.prompt_for_download", true);
			ChromeOptions options = new ChromeOptions();
			HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
			options.setExperimentalOption("prefs", chromePrefs);
			options.addArguments("--test-type");
			options.addArguments("chrome.switches","--disable-extensions");
			cap.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			cap.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new ChromeDriver(cap);
			break;

		case "firefox":
			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
			profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/msword, application/csv, application/ris, text/csv, image/png, application/pdf, text/html, text/plain, application/zip, application/x-zip, application/x-zip-compressed, application/download, application/octet-stream");
			profile.setPreference("browser.download.manager.showWhenStarting", false);
			profile.setPreference("browser.download.manager.focusWhenStarting", false);  
			profile.setPreference("browser.download.useDownloadDir", false);
			profile.setPreference("browser.helperApps.alwaysAsk.force", true);
			profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
			profile.setPreference("browser.download.manager.closeWhenDone", true);
			profile.setPreference("browser.download.manager.showAlertOnComplete", false);
			profile.setPreference("browser.download.manager.useWindow", false);
			profile.setPreference("services.sync.prefs.sync.browser.download.manager.showWhenStarting", false);
			profile.setPreference("pdfjs.disabled", true);

			driver = new FirefoxDriver(profile);
			break;

		case "edge":
			System.setProperty("webdriver.edge.driver", "driver/MicrosoftWebDriver.exe");
			cap = DesiredCapabilities.edge();
			driver = new EdgeDriver(cap);
		}
		this.driver.manage().window().maximize();
		gstrTimetake = dts.timeNow("HH:mm:ss");
		gstrdate = dts.getCurrentDate("yyyy-MM-dd");
		gdtStartDate = new Date();
	}

	
	@AfterMethod
	public void tearDown(ITestResult result) throws Exception {
		
		if(ITestResult.FAILURE == result.getStatus()) {
			   TakesScreenshot ts = (TakesScreenshot)driver;
			   File source = ts.getScreenshotAs(OutputType.FILE);
			   String FailedTC_ID = "";
			   if(result.getName().contains("HappyDay")){
			    FailedTC_ID = (result.getName()).replace("HappyDay", "");
			    FailedTC_ID = FailedTC_ID + "_HD" + "_"+ dts.getCurrentDate("d_M_yyyy_HH_mm");
			   } else if(result.getName().contains("Smoke")) {
			    FailedTC_ID = (result.getName()).replace("Smoke", "");
			    FailedTC_ID = FailedTC_ID + "_Smoke" + "_"+ dts.getCurrentDate("d_M_yyyy_HH_mm");
			   } else {
			    FailedTC_ID = (result.getName()).replace("EdgeCase", "");
			    FailedTC_ID = FailedTC_ID + "_EC" + "_"+ dts.getCurrentDate("d_M_yyyy_HH_mm");
			   }

			   FileUtils.copyFile(source, new File("./src/test/resources/Screenshots/"+ FailedTC_ID +".png"));
			  }
		gdbTimeTaken = objOFC.TimeTaken(gdtStartDate);
		if(ITestResult.SKIP == result.getStatus()) {
			Result = "FAIL";
		}
		String Resultpath = pathProps.getProperty("Resultpath");
		strResultPath = System.getProperty("user.dir")+Resultpath;
		objOFC.WriteResultdb_Excel(TCID, TC_DESCRIPTION, Result, Reason,
				gdbTimeTaken, strResultPath, writeToTool, gstrTimetake, gstrdate,
				gslsysDateTime, gstrBrowserName, gstrBuild, strSessionId);
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDownClass() throws Exception {	
		this.driver.close();
		try{
			this.driver.quit();
			this.driver = null;
		} catch (Exception e) {
			
		}
	}
}