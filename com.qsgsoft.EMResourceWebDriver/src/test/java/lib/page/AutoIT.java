package lib.page;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import qaframework.lib.UserDefinedFunctions.GetProcessList;
import qaframework.lib.pageObject.PageObject;
import static org.testng.Assert.*;

public class AutoIT extends PageObject {

	public AutoIT(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
	}
	
	/**************************************************
	' Description  : Function to download the reports
	' Arguments    : driver, strAutoItPath, strDownloadPath,  strAutoItName
	' Date         : 10/04/2014
	' Author       : Renushree 
	***************************************************/
	public AutoIT DownloadTheReports(String strAutoItPath, String strDownloadPath, String strAutoItName)
			throws Exception {
		RegionDefault objRegionDefault = new RegionDefault(this.driver);
		Thread.sleep(15000);
		String mainWindowHandle = driver.getWindowHandle();
		String url = "";
		Thread.sleep(15000);
		try{
			Set<String> a = driver.getWindowHandles();
			Iterator<String> ite = a.iterator();

			while (ite.hasNext()) {
				String popupHandle = ite.next().toString();

				if (!popupHandle.contains(mainWindowHandle)) {
					driver.switchTo().window(popupHandle);
					url = driver.getCurrentUrl();
					driver.close();
					driver.switchTo().window(mainWindowHandle);
					driver.navigate().to(url);
				}
			}
			
		} catch (Exception e) {
			System.out.println("file download window not retained.");
		}
		System.out.println(url);
		driver.switchTo().defaultContent();
//		String strArgs[] = {strAutoItPath, strDownloadPath};
		objRegionDefault.selectFrame();
		driver.manage().window().maximize();
		System.out.println(strDownloadPath);
//		Runtime.getRuntime().exec(strArgs);
		this.downloadFileInIE(strDownloadPath);
		
		File file1 = new File(strDownloadPath);
		boolean fileExists = file1.exists();
		assertTrue(fileExists, strDownloadPath+" file does not exist.");
		
//		driver.getWindowHandle();
//		Thread.sleep(15000);
//		String strProcess = "";
//		int intCnt = 0;
//		do {
//		GetProcessList objGPL = new GetProcessList();
//		strProcess = objGPL.GetProcessName();
//		intCnt++;
//		Thread.sleep(1000);
//		} while (strProcess.contains(strAutoItName) && intCnt < 240);
		return this;
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
			// Auto it to upload the file
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
	
	public void setClipBoardData(String fileName)throws Exception{
		StringSelection ss =new StringSelection(fileName);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	}
	
	public void downloadFileInIE(String fileNameToChange)throws Exception{
		this.setClipBoardData(fileNameToChange);

		Robot robot = new Robot();
			
		Thread.sleep(2000);
				
		robot.keyPress(KeyEvent.VK_ALT);
		robot.keyPress(KeyEvent.VK_N);
		robot.keyRelease(KeyEvent.VK_N);
		robot.keyRelease(KeyEvent.VK_ALT);
		
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		
		Thread.sleep(2000);
		
		robot.keyPress(KeyEvent.VK_UP);
		robot.keyRelease(KeyEvent.VK_UP);
		
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(2000);

		robot.keyPress(KeyEvent.VK_CONTROL);    
		robot.keyPress(KeyEvent.VK_V);
		     
		robot.keyRelease(KeyEvent.VK_V);    
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
		Thread.sleep(2000);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(7000);
	}
	
	public void fileDownloadInIE(String fileNameToChange)throws Exception{
		Robot robot = new Robot();
		
		Thread.sleep(2000);
				
		robot.keyPress(KeyEvent.VK_ALT);
		robot.keyPress(KeyEvent.VK_N);
		robot.keyRelease(KeyEvent.VK_N);
		robot.keyRelease(KeyEvent.VK_ALT);
		
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		
		Thread.sleep(2000);
		
		robot.keyPress(KeyEvent.VK_UP);
		robot.keyRelease(KeyEvent.VK_UP);
		
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(2000);

		robot.keyPress(KeyEvent.VK_CONTROL);    
		robot.keyPress(KeyEvent.VK_V);
		     
		robot.keyRelease(KeyEvent.VK_V);    
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
		Thread.sleep(2000);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(4000);
		
	}
	
	public String renameFile1(String dirPath,String fileName, String fileExtension){
	    File dir = new File(dirPath);
	    File[] files = dir.listFiles();
	    
	    if (files == null || files.length == 0) {
	        return null;
	    }
	
	    File lastModifiedFile = files[0];
	    for (int i = 1; i < files.length; i++) {
	       if (lastModifiedFile.lastModified() < files[i].lastModified()) {
	           lastModifiedFile = files[i];
	       }
	    }
	     lastModifiedFile.renameTo(new File(dirPath+fileName+"."+fileExtension));
	     return dirPath+fileName;
	}
}