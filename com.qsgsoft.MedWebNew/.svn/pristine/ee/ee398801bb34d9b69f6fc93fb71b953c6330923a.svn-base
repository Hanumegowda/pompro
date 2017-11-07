package page;

import org.openqa.selenium.WebDriver;

import qaframework.lib.userDefinedFunctions.GetProcessList;
import qaframework.lib.pageObject.PageObject;

public class AutoIT extends PageObject{
	public AutoIT(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		
	}
	
	/*******************************************************************************************
	' Description: Check the upload option is available under setup
	' Precondition: N/A 
	' Arguments: selenium
	' Returns: String 
	' Date: 05-11-2012
	' Author: QSG 
	'--------------------------------------------------------------------------------- 
	' Modified Date: 
	' Modified By: 
	*******************************************************************************************/

	public AutoIT downloadUploadTemplate(
			String strAutoFilePath,String strAutoFileName,String strDownloadPath) throws Exception {

			String strArgs[] = { strAutoFilePath, strDownloadPath};
			Runtime.getRuntime().exec(strArgs);
			driver.getWindowHandle();
			Thread.sleep(15000);
			// click on Upload Template
			this.page.element("Upload Template", "linktext").getOne().click();
			// wait for pop up to appear
			Thread.sleep(5000);
			// Wait for autoit file to finish execution
			String strProcess = "";

			int intCnt = 0;
			do {

				GetProcessList objGPL = new GetProcessList();
				strProcess = objGPL.GetProcessName();
				intCnt++;
				Thread.sleep(1000);
			} while (strProcess.contains(strAutoFileName) && intCnt < 240);

		return this;
	}
	
	/**************************************************
	' Description  : Function to download the reports
	' Arguments    : driver, strAutoItPath, strDownloadPath,  strAutoItName
	' Date         : 10/04/2014
	' Author       : QSG 
	***************************************************/
	public AutoIT DownloadTheReports1(String strAutoItPath,
			String strDownloadPath,String strAutoItName) throws Exception {
		//Thread.sleep(8000);
		String strArgs[] = { strAutoItPath,strDownloadPath };
		Runtime.getRuntime().exec(strArgs);
		driver.getWindowHandle();
		Thread.sleep(5000);
		return this;
	}
	
	/**************************************************
	' Description  : Function to download the reports
	' Arguments    : driver, strAutoItPath, strDownloadPath,  strAutoItName
	' Date         : 10/04/2014
	' Author       : QSG 
	(Not used anywhere just reference)
	***************************************************/
	public AutoIT DownloadTheReports(String strAutoItPath,
			String strDownloadPath, String strAutoItName) throws Exception {
		//Thread.sleep(5000);
		String strArgs[] = { strAutoItPath, strDownloadPath };
		Runtime.getRuntime().exec(strArgs);
		driver.getWindowHandle();
		Thread.sleep(15000);
		String strProcess = "";
		int intCnt = 0;
		do {
			GetProcessList objGPL = new GetProcessList();
			strProcess = objGPL.GetProcessName();
			intCnt++;
			Thread.sleep(1000);
		} while (strProcess.contains(strAutoItName) && intCnt < 240);
		return this;
	}
	
	/**************************************************
	' Description  : Function to create study.
	' Arguments    : driver, strAutoItPath, strDownloadPath,  strAutoItName
	' Date         : 10/04/2014
	' Author       : QSG 
	***************************************************/
	public AutoIT CreateStudy(String strAutoItPath,
			String study,String study1, String image,String modality) throws Exception {
		Thread.sleep(5000);
		String strArgs[] = { strAutoItPath, study,study1,image,modality };
		Runtime.getRuntime().exec(strArgs);
		//driver.getWindowHandle();
		Thread.sleep(10000);
		return this;
	}
	
	/**************************************************
	' Description  : Function to create study.
	' Arguments    : driver, strAutoItPath, strDownloadPath,  strAutoItName
	' Date         : 10/04/2014
	' Author       : QSG 
	***************************************************/
	public AutoIT addImagesToTheExistingStudyOrOrder(String strAutoItPath,
			String image) throws Exception {
		Thread.sleep(5000);
		String strArgs[] = { strAutoItPath,image };
		Runtime.getRuntime().exec(strArgs);
		//driver.getWindowHandle();
		Thread.sleep(10000);
		return this;
	}
	
	/**************************************************
	' Description  : Function to create study.
	' Arguments    : driver, strAutoItPath, strDownloadPath,  strAutoItName
	' Date         : 05/05/2016
	' Author       : QSG 
	***************************************************/
	public AutoIT CreateStudy1(String strAutoItPath,
			String study,String study1, String image,String modality,String rp) throws Exception {
		Thread.sleep(5000);
		String strArgs[] = { strAutoItPath, study,study1,image,modality,rp };
		Runtime.getRuntime().exec(strArgs);
		Thread.sleep(10000);
		return this;
	}
	
	/**************************************************
	' Description  : Function to create study and also used to execute any autoit files.
	' Arguments    : driver, strAutoItPath, strDownloadPath,  strAutoItName
	' Date         : 10/04/2014
	' Author       : QSG 
	***************************************************/
	public AutoIT executeAutoItFile(String[] str) throws Exception {
		Thread.sleep(5000);
		Runtime.getRuntime().exec(str);
		Thread.sleep(10000);
		return this;
	}

}
