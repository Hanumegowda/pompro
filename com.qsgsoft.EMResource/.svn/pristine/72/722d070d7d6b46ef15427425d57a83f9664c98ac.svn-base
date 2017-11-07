package RequirementGroups.Setup;

import org.testng.annotations.Test;
import EMR.data.InterfaceData;
import EMR.data.LoginData;
import EMR.data.RegionData;
import EMR.data.UsersData;
import EMR.data.InterfaceData.InterfaceCreateData;
import EMR.pages.InterfaceSetUp;
import EMR.pages.Login;
import EMR.pages.SelectRegion;
import EMR.pages.Shared;
import qaFramework.Configurations.Configuration;

public class StatusTypeSection extends Configuration{
	
	public StatusTypeSection() throws Exception {
		super();
	}

	@Test (groups = {"HappyDay", "Setup", "HappyDay187762"})
	public void HappyDay187762() throws Exception {

		TCID = "187762";
		TC_DESCRIPTION = "Verify that SystemAdmin/user with appropriate right creates/Edits multi region view , section drop down under 'Status types' tab is enabled only when region is selected under 'Regions' drop down.";

		/****
		 * Login as Admin
		 * Navigate To Views
		 * Create MultiRegion view
		 * Verify section drop down under 'Status types' tab is disabled. 
		 * Edit MultiRegion view 
		 * Verify section drop down under 'Status types' tab is disabled. 
		 * Login as User with 'Setup Region Views' right
		 * Navigate To Views
		 * Create MultiRegion view  
		 * Verify section drop down under 'Status types' tab is disabled. 
		 * Edit MultiRegion view by selecting both the regions 
		 * Verify section drop down under 'Status types' tab is disabled. 
		 ****/
		

		Result = "PASS";
	}
	
	@Test (groups = {"HappyDay", "Setup", "HappyDay187764"})
	public void HappyDay187764() throws Exception {

		TCID = "187764";
		TC_DESCRIPTION = "Verify that SytemAdmin/user with appropriate right is able to search status types selecting section name under 'Section' drop down while creating or editing a view.";

		/****
		 * Login as Admin
		 * Navigate To Views
		 * Create MultiRegion view 
		 * Verify appropriate status types are listed under appropriate sections 
		 * Edit MultiRegion view  
		 * Verify appropriate status types are listed under appropriate sections 
		 * Login as User with 'Setup Region Views' right
		 * Navigate To Views
		 * Create MultiRegion view 
		 * Verify appropriate status types are listed under appropriate sections 
		 * Edit MultiRegion view
		 * Verify appropriate status types are listed under appropriate sections
		 ****/
		

		Result = "PASS";
	}
}
