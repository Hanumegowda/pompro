package DatabaseRefresh_DataCreation.HappyDay;

import org.testng.annotations.Test;

import qaFramework.Configurations.Configuration;
import EMR.data.InterfaceData;
import EMR.data.InterfaceData.InterfaceCreateData;
import EMR.data.InterfaceData.InterfaceTags;
import EMR.data.LoginData;
import EMR.data.RegionData;
import EMR.data.UsersData;
import EMR.data.UsersData.UsersCreateData;
import EMR.data.UsersData.UsersTags;
import EMR.pages.Login;
import EMR.pages.RegionDefault;
import EMR.pages.RegionList;
import EMR.pages.SelectRegion;
import EMR.pages.Shared;
import EMR.pages.UsersList;

public class PreCondtionForSettingRegionInterfaces extends Configuration {
	
	UsersCreateData userDataCreation;
	UsersData usersData;
	InterfaceData interfaceData;
	InterfaceCreateData interfaceDataCreation;
	
	Login login;
	UsersList usersList;
	SelectRegion selectRegion;
	RegionDefault regionDefault;
	Shared navigateTo;
	RegionList regionList;
	
	
	public PreCondtionForSettingRegionInterfaces() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Test(description ="Precondition for setting Region Interfaces")
	public void Precondition_188869() throws Exception {

		TCID = "188869";
	    TC_DESCRIPTION = "Precondition for 188019,188022,188025 and 188028";
	    
		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);
		regionDefault = new RegionDefault(this.driver);
		navigateTo = new Shared(this.driver);
		usersList= new UsersList(this.driver);
		regionList= new RegionList(this.driver);
		
		usersData=new UsersData();
		interfaceData= new InterfaceData();
		interfaceDataCreation = interfaceData.new InterfaceCreateData();
		userDataCreation = usersData.new UsersCreateData();
	
		login.loginToApplication(
				LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD);
		selectRegion.selectRegionAndClickOnNext(RegionData.REGIONNAME);
		
		navigateTo.users();
		usersList.createUserBySelectingFirstRole(userDataCreation.name, UsersData.INITIAL_PASSWORD,
				userDataCreation.fullName, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID);
		
		usersList.createWebServiceUserBySelectingFirstRole(userDataCreation.webServiceName, UsersData.INITIAL_PASSWORD,
				userDataCreation.webServiceFullName, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID,UsersData.ORGANIZATION);
		navigateTo.regions();
		String interfaceKey = regionList.editRegionAndEnterInterfaceKeyIfNotFound(RegionData.REGIONNAME, interfaceDataCreation.interface_Key);
		login.logOut();
		login.loginAsNewUser(userDataCreation.name, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD)
		 .logOut();
		
		userDataCreation.writeUsersDataToXml(userDataCreation.name, UsersTags.INTERFACE_RELATED_USER);
		userDataCreation.writeUsersDataToXml(userDataCreation.fullName, UsersTags.INTERFACE_RELATED_USER_FULLNAME);
		userDataCreation.writeUsersDataToXml(userDataCreation.webServiceName, UsersTags.INTERFACE_RELATED_WEB_SERVICE_USER);
		userDataCreation.writeUsersDataToXml(userDataCreation.webServiceFullName, UsersTags.INTERFACE_RELATED_WEB_SERVICE_USER_FULLNAME);
		interfaceDataCreation.writeInterfaceDataToXml(interfaceKey, InterfaceTags.INTERFACE_KEY);
		Result = "PASS";
	}

}
