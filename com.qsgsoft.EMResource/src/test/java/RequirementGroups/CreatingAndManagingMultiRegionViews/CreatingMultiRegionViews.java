package RequirementGroups.CreatingAndManagingMultiRegionViews;

import org.testng.annotations.Test;
import qaFramework.Configurations.Configuration;

public class CreatingMultiRegionViews extends Configuration {

	public CreatingMultiRegionViews() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/*@Test(groups = {"HappyDay","Creating And Managing Multi Region Views", "HappyDay179586"})
	public void HappyDay179586() throws Exception {

		TCID ="179586";
		TC_DESCRIPTION ="Verify that user with ‘Setup Region Views’ can update‘Region Default’ view.";

		*//*****
		 * loginAsAdmin to regionName
		 * createResource(RT_from_precondition, Any6_ST_from_precondition)
		 * createUserWithRight(Setup Region Views)
		 * loginAsNewUser
		 * navigateToViews
		 * addResourceToRegionDefaultView(Resource, StatusTypes)
		 * navigateToParticularView(region default)
		 * verifyResourceAndResourceWithSTs(RT, Res, STs)
		 * logout
		 *****//*
		
		Result = "PASS";
	}

	@Test(groups = {"HappyDay","Creating And Managing Multi Region Views", "HappyDay179606"})
	public void HappyDay179606() throws Exception {

		TCID ="179606";
		TC_DESCRIPTION ="Verify that appropriate region name is displayed for resource under 'Resources tab' while creating or editing view.";

		*//*****
		 * loginAsUser from precondition (user from regionWithMutualAidAgreement_Region1)
		 * navigateToViews
		 * clickOnCreateNewView
		 * enterViewNameAndDescription
		 * includeRegionsForMultiRegionView(String[] regionNames) (all 3 region names)
		 * navigateToResourcesTab
		 * verifyRegionOfResource(resourceOfRG1, RG1_Name)
		 * verifyRegionOfResource(resourceOfRG2, RG2_Name)
		 * verifyRegionOfResource(resourceOfRG3, RG3_Name)
		 * cancelProcessOfCreatingView()
		 * clickOnEditOfView(region default)
		 * navigateToRegionsTab
		 * includeRegionsForMultiRegionView(String[] regionNames) (all 3 region names)
		 * navigateToResourcesTab
		 * verifyRegionOfResource(resourceOfRG1, RG1_Name)
		 * verifyRegionOfResource(resourceOfRG2, RG2_Name)
		 * verifyRegionOfResource(resourceOfRG3, RG3_Name)
		 * logout
		 *****//*

		Result = "PASS";
	}
	
	@Test(groups = {"HappyDay","Creating And Managing Multi Region Views", "HappyDay179607"})
	public void HappyDay179607() throws Exception {

		TCID ="179607";
		TC_DESCRIPTION ="Verify that appropriate region name is displayed for status types under 'Status Types tab' while creating or editing views.";

		*//*****
		 * loginAsUser from precondition (user from regionWithMutualAidAgreement_Region1)
		 * navigateToViews
		 * clickOnCreateNewView
		 * enterViewNameAndDescription
		 * includeRegionsForMultiRegionView(String[] regionNames) (all 3 region names)
		 * navigateToResourcesTab
		 * includeResource(String[] resourceOfRGs (RG1, RG2, RG3))
		 * verifyRegionOfStatusTypes(String[] sharedSTOfRG1, RG1_Name)
		 * verifyRegionOfStatusTypes(String[] sharedSTOfRG2, RG2_Name)
		 * verifyRegionOfStatusTypes(String[] sharedSTOfRG3, RG3_Name)
		 * cancelProcessOfCreatingView()
		 * clickOnEditOfView(region default)
		 * includeResource(String[] resourceOfRGs (RG1, RG2, RG3))
		 * verifyRegionOfStatusTypes(String[] sharedSTOfRG1, RG1_Name)
		 * verifyRegionOfStatusTypes(String[] sharedSTOfRG2, RG2_Name)
		 * verifyRegionOfStatusTypes(String[] sharedSTOfRG3, RG3_Name)
		 * logout
		 *****//*

		Result = "PASS";
	}
	
	@Test(groups = {"HappyDay","Creating And Managing Multi Region Views", "HappyDay179608"})
	public void HappyDay179608() throws Exception {

		TCID ="179608";
		TC_DESCRIPTION ="Verify that appropriate region name is displayed for status types under 'Sort Status Types' while creating or editing views.";

		*//*****
		 * loginAsUser from precondition (user from regionWithMutualAidAgreement_Region1)
		 * navigateToViews
		 * clickOnCreateNewView
		 * enterViewNameAndDescription
		 * includeRegionsForMultiRegionView(String[] regionNames) (all 3 region names)
		 * navigateToResourcesTab
		 * includeResource(String[] resourceOfRGs (RG1, RG2, RG3))
		 * includeStatusTypes(String[] sharedSTNamesOfAll3Regions)
		 * navigate to SortStatusTypes tab
		 * verifyRegionOfStatusTypes(String[] sharedSTOfRG1, RG1_Name)
		 * verifyRegionOfStatusTypes(String[] sharedSTOfRG2, RG2_Name)
		 * verifyRegionOfStatusTypes(String[] sharedSTOfRG3, RG3_Name)
		 * cancelProcessOfCreatingView()
		 * clickOnEditOfView(region default)
		 * includeResource(String[] resourceOfRGs (RG1, RG2, RG3))
		 * includeStatusTypes(String[] sharedSTNamesOfAll3Regions)
		 * navigate to SortStatusTypes tab
		 * verifyRegionOfStatusTypes(String[] sharedSTOfRG1, RG1_Name)
		 * verifyRegionOfStatusTypes(String[] sharedSTOfRG2, RG2_Name)
		 * verifyRegionOfStatusTypes(String[] sharedSTOfRG3, RG3_Name)
		 * logout
		 *****//*

		Result = "PASS";
	}
	
	@Test(groups = {"HappyDay","Creating And Managing Multi Region Views", "HappyDay179609"})
	public void HappyDay179609() throws Exception {

		TCID ="179609";
		TC_DESCRIPTION ="Verify that appropriate region name is displayed for status types under 'Sort Status Types' while creating or editing views.";

		*//*****
		 * loginAsUser from precondition (user from regionWithMutualAidAgreement_Region1)
		 * navigateToViews
		 * clickOnCreateNewView
		 * enterViewNameAndDescription
		 * includeRegionsForMultiRegionView(String[] regionNames) (all 3 region names)
		 * navigateToResourcesTab
		 * includeResource(String[] resourceOfRGs (RG1, RG2, RG3))
		 * includeStatusTypes(String[] sharedSTNamesOfAll3Regions)
		 * navigate to Advanced tab
		 * verifyRegionOfResourceTypes(String RTOfRG1, RG1_Name)
		 * verifyRegionOfResourceTypes(String RTOfRG2, RG2_Name)
		 * verifyRegionOfResourceTypes(String RTOfRG3, RG3_Name)
		 * cancelProcessOfCreatingView()
		 * clickOnEditOfView(region default)
		 * navigateToResourcesTab
		 * includeResource(String[] resourceOfRGs (RG1, RG2, RG3))
		 * includeStatusTypes(String[] sharedSTNamesOfAll3Regions)
		 * navigate to Advanced tab
		 * verifyRegionOfResourceTypes(String RTOfRG1, RG1_Name)
		 * verifyRegionOfResourceTypes(String RTOfRG2, RG2_Name)
		 * verifyRegionOfResourceTypes(String RTOfRG3, RG3_Name)
		 * logout
		 *****//*

		Result = "PASS";
	}
	
	@Test(groups = {"HappyDay","Creating And Managing Multi Region Views", "HappyDay179807"})
	public void HappyDay179807() throws Exception {

		TCID ="179807";
		TC_DESCRIPTION ="Verify that appropriate region name is displayed for status types under 'Sort Status Types' while creating or editing views.";

		*//*****
		 * loginAsAdmin
		 * navigateTo statusTypes
		 * createStatusType (any 1 ST, say NST)
		 * createResourceType(RT)
		 * createResource(RT, ST)
		 * createSubResource (say SRS)
		 * navigateToViews
		 * navigate to create new view
		 * enterViewNameAndDescription
		 * includeRegions(RG1)
		 * navigateTo Resource tab
		 * verifyResourceNotresent(SRS Name)
		 * logout
		 *****//*

		Result = "PASS";
	}
	
	@Test(groups = {"HappyDay","Creating And Managing Multi Region Views", "HappyDay179864"})
	public void HappyDay179864() throws Exception {

		TCID ="179864";
		TC_DESCRIPTION ="Verify that Summary totals of the numeric status types that are created selecting 'Display Summary Totals' are displayed under each Resource Type added to ‘Region default View’.";

		*//*****
		 * DONNO STEPS, DOUBT
		 *****//*

		Result = "PASS";
	}
	
	@Test(groups = {"HappyDay","Creating And Managing Multi Region Views", "HappyDay179865"})
	public void HappyDay179865() throws Exception {

		TCID ="179865";
		TC_DESCRIPTION ="Verify that Summary totals is not displayed under each Resource Type if the numeric status types added to ‘Region default View’ is created by deselecting 'Display Summary Totals'";

		*//*****
		 * DONNO STEPS, DOUBT
		 *****//*

		Result = "PASS";
	}
	
	@Test(groups = {"HappyDay","Creating And Managing Multi Region Views", "HappyDay179866"})
	public void HappyDay179866() throws Exception {

		TCID ="179866";
		TC_DESCRIPTION ="Verify that Summary totals of the event only numeric status types that are created selecting 'Display Summary Totals' are displayed under each Resource Type added to ‘Region default View’ only when there is an active event created selecting them";

		*//*****
		 * DONNO STEPS, DOUBT
		 *****//*

		Result = "PASS";
	}
	
	@Test(groups = {"HappyDay","Creating And Managing Multi Region Views", "HappyDay180272"})
	public void HappyDay180272() throws Exception {

		TCID ="180272";
		TC_DESCRIPTION ="Verify that newly created view appears in the user's View Menu immediately.";

		*//*****
		 * DONNO STEPS, DOUBT
		 * IS IT RELATED TO MULTIPLE BROWSERS??
		 *****//*

		Result = "PASS";
	}
	
	@Test(groups = {"HappyDay","Creating And Managing Multi Region Views", "HappyDay180297"})
	public void HappyDay180297() throws Exception {

		TCID ="180297";
		TC_DESCRIPTION ="Verify that appropriate view name provided is displayed as a page title on 'Create / Edit' view screen.";

		*//*****
		 * loginAsUser
		 * navigateTo views
		 * click on create new view
		 * enterViewNameAndDescription(viewName_1, description)
		 * verifyPageTitleAsViewName("Create View: viewName_1")
		 * logout
		 *****//*

		Result = "PASS";
	}*/
}
