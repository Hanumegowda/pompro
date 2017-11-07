package EMR.Locators;

public class InterfaceSetUp {
	
	public static class Locators
	{
		
		public static final String CLOSINGBRACKETS 					= "']",
				   CLOSINGBRACKETS_WITHOUT_QUOTE					= "]",
		           CREATE_NEW_INTERFACE								= "//input[@value='Create New Interface']",
				   INTERFACELISTPAGE								= "//h1[text()='Interface List']",
				   SELECTINTERFACETYPE								= "interfaceID",
				   NEXT												= "//input[@value='Next']",
				   CREATE_REGION_INTERFACE_PAGE						= "//h1[text()='Create Region Interface']",
				   NAME_FOR_MULTIREGION_INTERFACE					= "productInterfaceName",
				   DESCRIPTION 										= "description",
				   CONTACTINFO 										= "contactInfo",
				   ACTIVE 											= "active",
				   WEBSERVICEACTION 								= "actionName",
				   SAVE 											= "input[value='Save']",
				   INTERFACE_NAME_IN_TABLE							= "//tr/td[text()='",
				   FOLLOWING_COLUMNS_OF_INTERFACE_NAME				= "/following-sibling::td[text()='",
				   EDITLINKPART2									= "/preceding-sibling::td/a[text()='Edit']",
				   DELETELINK										= "/preceding-sibling::td/a[text()='Delete']",
				   PARAMETRESLINK									= "/preceding-sibling::td/a[text()='Parameters']",
				   USERSLINK										= "/preceding-sibling::td/a[text()='Users']",
				   STATUSTYPESLINK									= "/preceding-sibling::td/a[text()='Status Types']",
				   RESOURCELINK										= "/preceding-sibling::td/a[text()='Resources']",
				   PRODUCT_INTERFACE_USERS_LIST_PAGE				= "//h1[text()='Product Interface Users List']",
				   ACTIVE_STATUS									= "/following-sibling::td[text()='Active']",
				   PARAMETER_LIST_FOR_INTERFACE_HEADER  			= "//h1[text()='Parameter List for Interface: ",
				   PARAMETER_NAME                       			= "parmName",
				   PARAMETER_VALUE                      			= "parmValue",
				   CREATE_NEW_PARAMETER                 			= "input[Value='Create New Parameter']",
				   ACTIVE_STATUS_CORRESPONDING_TO_WEBSERVICEACTION	= "/preceding-sibling::td[text()='Active']",
				   PARAMETER_LIST_FOR_REGION_INTERFACE_PAGE			= "//h1[text()='Parameter List for Region Interface: ",
				   CANCEL											= "input[value='Cancel']",
				   SELECT_INTERFACE_STATUS_TYPES_PAGE               = "//h1[text()='Select Interface Status Types']",
				   REQUIRED_STATUS_TYPE_MAPPING_HEADER              = "//td[text()='Required Status Type Mappings'][@class='hdr']",
				   REGIONAL_STATUS_TYPE_COLUMN                      = "Regional Status Type",
				   EDITINTERFACE_SELECTRESOURCES_PAGE				= "//h1[text()='Edit Interface -- Select Resources']",
				   NAME_FOR_REGION_INTERFACE 						= "regionInterfaceName",
				   REGION_INTERFACE_USERS_LIST_PAGE					= "//h1[text()='Region Interface Users List']",
				   EDIT_REGION_INTERFACE_PAGE						= "//h1[text()='Edit Region Interface']",
				   EDIT_PRODUCT_INTERFACE_PAGE                      = "//h1[text()='Edit Product Interface']",
				   CREATE_REGION_INTERFACE_PARAMETER_PAGE			= "//h1[text()='Create Region Interface Parameter']",
				   CREATE_PRODUCT_INTERFACE_PAGE 					= "//h1[text()='Create Product Interface']",
		 		   OPTIONAL_STATUS_TYPE_MAPPINGS					= "//td[text()='Optional Status Type Mappings'][@class='hdr']",
				   CUSTOM_STATUS_TYPE_MAPPING						= "//td[text()='Custom Status Type Mappings'][@class='hdr']",
				   STATUS_TYPES_MAPPING_1							= "//table[@summary='",
				   COLUMN_HEADERS									= "']/thead/tr/th[",
				   ANCHOR_TAG										= "/a",
				   ALLOWED_RESOURCES_PART1							= "//td[text()='",
				   ALLOWED_RESOURCES_PART2							= "']/parent::tr/td/input[@class='checkbox']",
				   EDIT_PARAMETER									= "/preceding-sibling::td/a[text()='edit']",
				   DELETE_PARAMETER									= "/preceding-sibling::td/a[text()='delete']",
				   PRODUCT_INTERFACE_KEY                            ="interfaceKey",
				   PRODUCT_INTERFACE_KEY_IN_EDIT_INTERFACE_PAGE     ="input[disabled='disabled'][value='";
	}
}
