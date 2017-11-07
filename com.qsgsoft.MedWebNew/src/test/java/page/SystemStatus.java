package page;

import module.Frames;

import org.openqa.selenium.WebDriver;

import qaframework.lib.pageObject.PageObject;
import qaframework.lib.userDefinedFunctions.WaitForElement;
import static org.testng.Assert.assertTrue;


public class SystemStatus extends PageObject{
	WebDriver driver;
	WaitForElement objWaitForElement;
	Frames objFrames;
	
	private String memoryStatus = "//b[text()='Memory Status']",
			       ballIcon = "//td[contains(text(),'of virtual memory is in use')]/..//img[@src='/.cobalt/images/greenball.gif']",
			       cpuStatus = "//td[contains(text(),'CPU')]/preceding-sibling::td//img",
			       memoryUsage = "//img[@src='/.cobalt/images/greenball.gif']/../../following-sibling::td",
			       memoryStatus1 = "//td[contains(text(),'Memory')]/preceding-sibling::td//img",
			       diskStatus = "//td[contains(text(),'Disk')]/preceding-sibling::td//img",
			       cpu = "//img[@src='/.cobalt/images/a_top_system_cpu.gif']",
			       cpuUsage = "//b[contains(text(),'CPU Usage')]",
			       loadGraph = "//td[@class='legendLabel']",
			       disk = "//a[text()='Disk']",
			       operatingSystemAndProgramsMemory = "(//b[text()='Operating system and programs']/../..//p)[2]",
			       usersMemory = "//a[text()='Users']/../../..//p[contains(text(),'MB')]",
			       groupsMemory = "//a[text()='Groups']/../../..//p[contains(text(),'MB')]",
			       freeDiskSpaceMemory = "(//p[contains(text(),'Free disk space')]/../..//p[@align='RIGHT'])",
			       totalSpaceMemory = "(//b[contains(text(),'Total space')]/../..//p)[1]",
			       diskUsageSummary = "//b[text()='Disk Usage Summary']",
			       network = "//img[@src='/.cobalt/images/a_top_system_network.gif']",
			       networkUsage = "//b[text()='Network Usage']",
			       good = "//b[text()='Network Packets']/ancestor::tr/following-sibling::tr//p[contains(text(),'Good')]",
			       error = "//b[text()='Network Packets']/ancestor::tr/following-sibling::tr//p[contains(text(),'Error')]",
			       dropped = "//b[text()='Network Packets']/ancestor::tr/following-sibling::tr//p[contains(text(),'Dropped')]",
			       collisions = "//b[text()='Network Packets']/ancestor::tr/following-sibling::tr//p[contains(text(),'Collisions')]",
			       sent = "//b[text()='Sent']",
			       getSentValue = "//tr//p[contains(text(),'Good')]/../following-sibling::td[1]/p",
			       getReceivedValue = "//tr//p[contains(text(),'Good')]/../following-sibling::td[2]/p",
			       received = "//b[text()='Received']",
			       modem = "//img[@src='/.cobalt/images/a_top_modem.gif']",
			       modemStatusPage = "//b[text()='Modem Status']",
			       status = "//td[contains(text(),'Status')]/following-sibling::td[contains(text(),'Idle')]",
			       timeConnected = "//td[contains(text(),'Time Connected')]",
			       bytesReceived = "//td[contains(text(),'Bytes Received')]",
			       bytesTransmitted = "//td[contains(text(),'Bytes Transmitted')]",
			       uptime = "//img[@src='/.cobalt/images/a_top_uptime.gif']",
			       uptimeSummary = "//b[text()='Uptime Summary']",
			       uptimeRow = "//td[contains(text(),'Uptime:')]/following-sibling::td//font",
			       currentSystemTime = "//td[contains(text(),'Current system time:')]/following-sibling::td";
	
	public SystemStatus(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
		objFrames = new Frames(this.driver);
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'memory status' page is displayed.
	* Date 		  : 25-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public SystemStatus verMemoryStatusPage() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(memoryStatus, "xpath");
		assertTrue(this.page.element(memoryStatus, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify a ball indicating the 'memory in use' is displayed.
	* Date 		  : 25-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public SystemStatus verBallIconIndicatingMemoryInUse() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(ballIcon, "xpath");
		assertTrue(this.page.element(ballIcon, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to get the memory usage percentage.
	* Date 		  : 25-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public String getPercentageOfMemoryUsage() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(memoryUsage, "xpath");
		String str = this.page.element(memoryUsage, "xpath").getOne().getText();
		return str;
	}
	
	/**********************************************************************************
	* Description : This function is to verify CPU status is displayed.
	* Date 		  : 05-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public SystemStatus verCpuStatusIsDisplayed() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(cpuStatus, "xpath");
		assertTrue(this.page.element(cpuStatus, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify Memory status is displayed.
	* Date 		  : 05-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public SystemStatus verMemoryStatusIsDisplayed() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(memoryStatus1, "xpath");
		assertTrue(this.page.element(memoryStatus1, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify Disk status is displayed.
	* Date 		  : 05-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public SystemStatus verDiskStatusIsDisplayed() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(diskStatus, "xpath");
		assertTrue(this.page.element(diskStatus, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on cpu tab.
	* Date 		  : 06-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public SystemStatus clickOnCPU() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToSubMenuInRightFrame();
		objWaitForElement.waitForElements(cpu, "xpath");
		this.page.element(cpu, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'CPU Usage' page is displayed.
	* Date 		  : 06-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public SystemStatus verCPUUsagePage() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(cpuUsage, "xpath");
		assertTrue(this.page.element(cpuUsage, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify change in cpu load.
	* Date 		  : 06-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public SystemStatus verChangeInCPULoad() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(loadGraph, "xpath");
		String str = this.page.element(loadGraph, "xpath").getOne().getText();
		String str1[] = str.split(":");
		String str2[] = str1[1].split("%");
		float str3 = Float.parseFloat(str2[0]);
		assertTrue(str3 >= 0.1);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'Disk' tab.
	* Date 		  : 30-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public SystemStatus clickOnDisk() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToSubMenuInRightFrame();
		objWaitForElement.waitForElements(disk, "xpath");
		this.page.element(disk, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'Operating system and programs' memory usage is displayed.
	* Date 		  : 30-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public SystemStatus verOperatingSystemAndProgramsMemoryUsageDisplayed() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(operatingSystemAndProgramsMemory, "xpath");
		String str = this.page.element(operatingSystemAndProgramsMemory, "xpath").getOne().getText();
		String str1 = str.substring(0, 2);
		System.out.println(str1);
		assertTrue((Integer.parseInt(str1))>1);
		assertTrue(str.contains("MB"));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'Users' memory usage is displayed.
	* Date 		  : 30-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public SystemStatus verUsersMemoryUsageDisplayed() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(usersMemory, "xpath");
		assertTrue(this.page.element(usersMemory, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'Groups' memory usage is displayed.
	* Date 		  : 30-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public SystemStatus verGroupsMemoryUsageDisplayed() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(groupsMemory, "xpath");
		assertTrue(this.page.element(groupsMemory, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'Free disk space' memory is displayed.
	* Date 		  : 30-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public SystemStatus verFreeDiskSpaceMemoryDisplayed() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(freeDiskSpaceMemory, "xpath");
		String str = this.page.element(totalSpaceMemory, "xpath").getOne().getText();
		String str1 = str.substring(0, 2);
		System.out.println(str1);
		assertTrue((Integer.parseInt(str1))>1);
		assertTrue(str.contains("MB"));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'Total space' memory is displayed.
	* Date 		  : 30-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public SystemStatus verTotalSpaceMemoryDisplayed() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(totalSpaceMemory, "xpath");
		String str = this.page.element(totalSpaceMemory, "xpath").getOne().getText();
		String str1 = str.substring(0, 2);
		System.out.println(str1);
		assertTrue((Integer.parseInt(str1))>1);
		assertTrue(str.contains("MB"));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'Disk Usage Summary' page is displayed.
	* Date 		  : 30-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public SystemStatus verDiskUsageSummaryPageDisplayed() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(diskUsageSummary, "xpath");
		assertTrue(this.page.element(diskUsageSummary, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'Network' tab.
	* Date 		  : 30-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public SystemStatus clickOnNetwork() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToSubMenuInRightFrame();
		objWaitForElement.waitForElements(network, "xpath");
		this.page.element(network, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'Network Usage' page is displayed.
	* Date 		  : 30-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public SystemStatus verNetworkUsagePageDisplayed() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(networkUsage, "xpath");
		assertTrue(this.page.element(networkUsage, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'Good' is displayed in 'Network Packets' column.
	* Date 		  : 30-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public SystemStatus verGoodIsDisplayedInNetworkPacketsColumn() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(good, "xpath");
		assertTrue(this.page.element(good, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'Error' is displayed in 'Network Packets' column.
	* Date 		  : 30-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public SystemStatus verErrorIsDisplayedInNetworkPacketsColumn() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(error, "xpath");
		assertTrue(this.page.element(error, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'Dropped' is displayed in 'Network Packets' column.
	* Date 		  : 30-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public SystemStatus verDroppedIsDisplayedInNetworkPacketsColumn() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(dropped, "xpath");
		assertTrue(this.page.element(dropped, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'Collisions' is displayed in 'Network Packets' column.
	* Date 		  : 30-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public SystemStatus verCollisionsIsDisplayedInNetworkPacketsColumn() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(collisions, "xpath");
		assertTrue(this.page.element(collisions, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'Sent' column is displayed.
	* Date 		  : 30-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public SystemStatus verSentColumnIsDisplayed() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(sent, "xpath");
		assertTrue(this.page.element(sent, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to get value from sent column of row good.
	* Date 		  : 30-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public String getValueFromSentColumnOfRowGood() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(getSentValue, "xpath");
		String str = this.page.element(getSentValue, "xpath").getOne().getText();
		return str;
	}
	
	/**********************************************************************************
	* Description : This function is to get value from Received column of row good.
	* Date 		  : 30-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public String getValueFromReceivedColumnOfRowGood() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(getReceivedValue, "xpath");
		String str = this.page.element(getReceivedValue, "xpath").getOne().getText();
		return str;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'Received' column is displayed.
	* Date 		  : 30-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public SystemStatus verReceivedColumnIsDisplayed() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(received, "xpath");
		assertTrue(this.page.element(received, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'Modem' tab.
	* Date 		  : 02-Nov-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public SystemStatus clickOnModem() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToSubMenuInRightFrame();
		objWaitForElement.waitForElements(modem, "xpath");
		this.page.element(modem, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'Modem status' page is displayed.
	* Date 		  : 02-Nov-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public SystemStatus verModemStatusPageDisplayed() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(modemStatusPage, "xpath");
		assertTrue(this.page.element(modemStatusPage, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'Status' row is displayed.
	* Date 		  : 02-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public SystemStatus verStatusRowDisplayed() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(status, "xpath");
		assertTrue(this.page.element(status, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'Status' row is displayed.
	* Date 		  : 02-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public SystemStatus verTimeConnectedRowDisplayed() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(timeConnected, "xpath");
		assertTrue(this.page.element(timeConnected, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'Status' row is displayed.
	* Date 		  : 02-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public SystemStatus verBytesReceivedRowDisplayed() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(bytesReceived, "xpath");
		assertTrue(this.page.element(bytesReceived, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'Status' row is displayed.
	* Date 		  : 02-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public SystemStatus verBytesTransmittedRowDisplayed() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(bytesTransmitted, "xpath");
		assertTrue(this.page.element(bytesTransmitted, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'Uptime' tab.
	* Date 		  : 02-Nov-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public SystemStatus clickOnUptime() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToSubMenuInRightFrame();
		objWaitForElement.waitForElements(uptime, "xpath");
		this.page.element(uptime, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'Uptime Summary' page is displayed.
	* Date 		  : 02-Nov-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public SystemStatus verUptimeSummaryPageDisplayed() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(uptimeSummary, "xpath");
		assertTrue(this.page.element(uptimeSummary, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'Uptime' row is displayed.
	* Date 		  : 02-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public SystemStatus verUptimeRowDisplayed() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(uptimeRow, "xpath");
		assertTrue(this.page.element(uptimeRow, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'Current system time:' row is displayed.
	* Date 		  : 02-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public SystemStatus verCurrentSystemTimeRowDisplayed(String req) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(currentSystemTime, "xpath");
		String str = this.page.element(currentSystemTime, "xpath").getOne().getText();
		String str1 = str.trim();
		System.out.println(str1+" text");
		assertTrue(str1.contains(req));
		return this;
	}
	

}
