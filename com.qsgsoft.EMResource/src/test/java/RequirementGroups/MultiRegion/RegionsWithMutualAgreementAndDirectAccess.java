package RequirementGroups.MultiRegion;

import org.testng.annotations.Test;

import qaFramework.Configurations.Configuration;

public class RegionsWithMutualAgreementAndDirectAccess extends Configuration {

	public RegionsWithMutualAgreementAndDirectAccess() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test(groups = {"HappyDay","Multi Region", "HappyDay71256"})
	public void HappyDay71256() throws Exception {

		TCID ="71256";
		TC_DESCRIPTION ="Verify that custom view can be created by selecting region RG1's resource"
				+ " from RG2 when user has access to only RG2 and RG3; other region view agreement"
				+ " is done between RG3 and RG1.";

		/***********
		 * LoginAsAdmin(RegionData.REGIONNAME)
		 * verifyAndDeleteAgreementBetweenRegions(REGIONNAME, REGION_WITH_MUTUAL_AGREEMENT2)
		 * createUserWithViewCustomViewRight(userA) provide email
		 * Give access to REGION_WITH_MUTUAL_AGREEMENT2
		 * LoginAsUser(UserInMutualAidRegion1_WithAdditionalRights)
		 * EndAllExistingEventsUsingEventTemplate(eventTemplateInMutualAidRegion1)
		 * ArrayList ResNames = {sharedResourceNAME1_MutualAgreement_RG1, sharedResourceNAME2_MutualAgreement_RG1, resourceNAME_MutualAgreement_RG1}
		 * createEvent(EventNameA, eventTemplateInMutualAidRegion1, ResNames)
		 * LoginAsNewUser(userA)
		 * navigate to CustomUnderViews
		 * searchResource(resourceNAME_MutualAgreement_RG1)
		 * verifyValidationMessage(Resource Not Found) -- NEW
		 * createCustomView(sharedResourceNAME1_MutualAgreement_RG1, sharedResourceNAME2_MutualAgreement_RG1, shareSTs_RG1)
		 * verifyStatusTypesPresent(shared STs) -- new
		 * verifyStatusTypesNOTPresent(role STs, private STs, shared event STs) -- new
		 * clickOnShowMap() -- new
		 * selectResource(sharedResourceNAME1_MutualAgreement_RG1) -- new
		 * verifyStatusTypesNotPresentInMap(role STs, private STs)
		 * verifyStatusTypesPresentInMap(shared event STs, shared STs) -- new
		 * EndEvent(EventNameA)
		 ***********/

	}
}
