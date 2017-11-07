package lib.dataObject;

import qaframework.lib.UserDefinedFunctions.Date_Time_settings;

public class IncomingPationtNotificationData {
	
	Date_Time_settings objDate_Time_settings = new Date_Time_settings();
	
	String strTimeText = objDate_Time_settings.getCurrentDate("d");
	
	public String strMale = "MALE",			 	  
	              strFemale="FEMALE",
	              strUnknown="UNKNOWN",
	              strYellow="YELLOW",
	              strRed="RED",
	              strGreen="GREEN",        
	              strBlack="BLACK",
	              strOther="OTHER",
	              strBLS="BLS",
	              strALS="ALS",
	              strAges="20",
	              strunspecified="UNSPECIFIED",
	              strComplaint="CheafComp1" + System.currentTimeMillis(), 
	              strEMSAgency="EmsAgency1" + System.currentTimeMillis(), 
	              strEMSUnits="1",
	              strETAs="5",
	              strAge=strTimeText,
	              strAge1="32",
	              strCheafComp = "CheafComp" + System.currentTimeMillis(), 
	              strEmsAgency = "EmsAgency" + System.currentTimeMillis(), 
	              strEMSUnit="EMSUnit"+ System.currentTimeMillis(), 
        		  strGreenNotifn="Green",
				  strMaleNotifn="Male",
				  strFeMaleNotifn="Female",
				  strRED="Red",
				  strgreen="Green",
				  strSetracRegion="SETRAC";
	public      int  strETA=5,
			         strETA1=10;
	
			 	  
          
           
       
          
           
          
          
            
        
         
          
         
   	     
   	    
   	     

   	            


	              
	

}
