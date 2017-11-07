package RequirementGroups.MultiRegion;

import org.testng.annotations.Test;

import EMR.data.LoginData;
import EMR.data.RegionData;
import EMR.pages.ConfigureNewRelationship;
import EMR.pages.Login;
import EMR.pages.OtherRegionList;
import EMR.pages.SelectRegion;
import EMR.pages.Shared;
import qaFramework.Configurations.Configuration;

public class MutualAidRrelationship extends Configuration {

	public MutualAidRrelationship() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	Login login;
	Shared navigateTo;
	OtherRegionList otherRegionList;
	ConfigureNewRelationship configurRelationShip;
	SelectRegion selectRegion;
	
	@Test(groups = {"HappyDay","Multi Region", "HappyDay175342"})
	public void HappyDay175342() throws Exception {

		TCID ="175342";
		TC_DESCRIPTION ="Verify that 'delete' link is available under action column for deactivated and newly created mutual aid regions.";

		/*****
		 * Create Mutual agreement between 2 regions
		 * delete link is present corresponding to region 
		 * deactivate and unverify the agreement verify
		 * delete link is present corresponding to region
		 *****/
		
		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		configurRelationShip=new ConfigureNewRelationship(this.driver);
		otherRegionList = new OtherRegionList(this.driver);
		
		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
		navigateTo.otherRegion();
		configurRelationShip.createMutualAidAgreement(RegionData.REGION_NAME_2);
		otherRegionList.verifyDeleteOptionExists(RegionData.REGION_NAME_2)
					   .verifyAndEnableMutualAidAgreement(RegionData.REGION_NAME_2)
					   .deactivateMutualAgreement(RegionData.REGION_NAME_2)
					   .verifyDeleteOptionExists(RegionData.REGION_NAME_2)
					   .deleteMutualAidRelationship(RegionData.REGION_NAME_2);
		login.logOut();
		Result = "PASS";
	}
	
	@Test(groups = {"HappyDay","Multi Region", "HappyDay175366"})
	public void HappyDay175366() throws Exception {

		TCID ="175366";
		TC_DESCRIPTION ="Verify that when a mutual aid relationship between regions 'RG1' and 'RG2' is deleted "
				+ "from both the regions, regions are no longer available under both sections of 'Other Region List'"
				+ " page in both regions.";
		
		/*****
		 * Create Mutual agreement between 2 regions (Verify And Activate)
		 * verify region name is displayed under Setup>>?Other Regions
		 * delete agreement in region 1  (Deactivate, Unverify And Delete) 
		 * Verify region 2 is not displayed in region 1's Other Regions List page
		 * delete (Deactivate, Unverify And Delete) agreement in region 2
		 * Verify region 2 is not displayed in region 2's Other Regions List page
		 *****/
		
		login= new Login(this.driver);
		navigateTo = new Shared(this.driver);
		otherRegionList = new OtherRegionList(this.driver);		
		configurRelationShip= new ConfigureNewRelationship(this.driver);
		selectRegion= new SelectRegion(this.driver);
		
		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
		configurRelationShip.deleteExistingMutualAidRelationShip(RegionData.REGIONNAME, RegionData.REGION_NAME_2);
		selectRegion.selectRegionAndClickOnNext(RegionData.REGIONNAME);	
		navigateTo.otherRegion();
		configurRelationShip.createNewRelationShip(RegionData.REGION_NAME_2);
		otherRegionList.verifyAndEnableMutualAidAgreement(RegionData.REGION_NAME_2);
		selectRegion.selectRegionAndClickOnNext(RegionData.REGION_NAME_2);	
		navigateTo.otherRegion();
		otherRegionList.verifyAndEnableMutualAidAgreement(RegionData.REGIONNAME);
		
		configurRelationShip.deleteExistingMutualAidRelationShip(RegionData.REGIONNAME, RegionData.REGION_NAME_2);
		otherRegionList.verifyRegionIsNotUnderCanViewSection(RegionData.REGIONNAME)
		               .verifyRegionIsNotUnderThatCanViewSection(RegionData.REGIONNAME);
		selectRegion.selectRegionAndClickOnNext(RegionData.REGIONNAME);	
		otherRegionList.verifyRegionIsNotUnderCanViewSection(RegionData.REGION_NAME_2)
                       .verifyRegionIsNotUnderThatCanViewSection(RegionData.REGION_NAME_2);
		login.logOut();
		Result = "PASS";	
	}
}
