package EMR.Locators;

public class RolesList {
	public static class Locators {
		public static final String CLOSEBRACKETS	= "']",
				TABLECELLWITHTEXT 			= "//td[text()='",
				CREATENEWROLEBTN 			= "input[value='Create New Role']",
				ROLENAME 					= "description",
				SAVE 						= "input[value='Save']",
				ROLE 						= "//div[@id='mainContainer']/table/tbody/tr/td[3][text()='",
				EDITOFROLE 					= "/parent::tr/td[1]/a[text()='Edit']",
				TABLE_CELL_WITH_TEXT_PART1	= "/preceding-sibling::td/a[text()='Edit']",
				EDIT_ROLE_PAGE				= "//h1[text()='Edit Role']",
				CANCEL 						= "input[value='Cancel']",
				ROLE_MAY_VIEW_OR_UPDATE     = "//input[@value='",
				ROLE_MAY_UPDATE             = "'][@data-name='updateRightIDs[]'][@checked='checked']",
		        ROLE_MAY_VIEW               = "'][@data-name='viewRightIDs[]'][@checked='checked'][@disabled='disabled']",
		        UPDATE_RIGHT 				= "//th/span/input[@data-name='updateRightIDs[]']",
				DELETE_ROLE 				= "/preceding-sibling::td/a[text()='Delete']",
				DELETE_LINK_OF_DEFAULT_ROLE = "//td[text()='Yes']/preceding-sibling::td/a[text()='Delete']",
				ROLES_LIST_PAGE             = "//div[@id='topSubNav']/h1[text()='Roles List']",
			    STATUS_TYPES_UNDER_EDIT_ROLE= "'][data-name='viewRightIDs[]']",
		        CLOSINGTWOBRACES 			= "')]",
		        DEFAULT_ROLE                ="//td[text()='Yes']/preceding-sibling::td/a[text()='Edit']",
		        ROLE_NAME_IN_TABLE 			= "//tr/td[text()='",
		        MAKE_DEFAULT				= "/preceding-sibling::td/a[text()='Make Default']",
		        USER_LINK_CORRESPONDING_TO_ROLE = "/preceding-sibling::td/a[text()='Users']",
		        SELECT_ROLE_CHECKBOX		= "/preceding-sibling::td/input[@name='userID']",
		        ASSIGN_USERS_PART1			= "//h1[text()='Assign Users to ",
		        ASSIGN_USER_PART2			= " role",
		        CREATE_ROLE_PAGE			= "//h1[text()='Create Role']";
	}
}