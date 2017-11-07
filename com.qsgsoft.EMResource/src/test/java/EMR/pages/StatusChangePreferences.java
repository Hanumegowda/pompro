package EMR.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import java.util.ArrayList;
import java.util.Iterator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import qaFramework.WaitTimeConstants;
import qaFramework.UserDefinedFunctions.WaitForElement;
import qaFramework.pageObject.PageObject;
import EMR.Locators.StatusChangePreferences.Locators;

public class StatusChangePreferences extends PageObject {
	WebDriver driver;
	WaitForElement waitForElement ;
	WebDriverWait wait;
	
	public StatusChangePreferences(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		
		waitForElement = new WaitForElement(this.driver);
		wait = new WebDriverWait(this.driver, WaitTimeConstants.WAIT_TIME_LONG);
	}
	
	public StatusChangePreferences clickOnAdd() throws Exception {
		waitForElement.waitForElements(Locators.ADD, "css");
		this.page.element(Locators.ADD, "css").getOne().click();
		return this;
	}
	
	public StatusChangePreferences enterResourceNameInWhatField(String resource) throws Exception {
		waitForElement.waitForElements(Locators.SEARCHRESOURCE, "id");
		this.page.element(Locators.SEARCHRESOURCE, "id").clearInputValue().sendKeys(resource);
		return this;
	}
	
	public StatusChangePreferences clickOnSearch() throws Exception {
		waitForElement.waitForElements(Locators.SEARCH, "css");
		this.page.element(Locators.SEARCH, "css").getOne().click();
		return this;
	}
	
	public StatusChangePreferences verResourceDisplayedInFindResourceScreen(
			String strResource) throws Exception {
		String findResource=Locators.VERIFYRESOURCE+ strResource + Locators.CLOSINGBRACKETS;
		waitForElement.waitForElements(findResource, "xpath");
		assertTrue(this.page.element(findResource, "xpath").isElementPresent());
		assertTrue(this.page.element(findResource, "xpath").getOne().isDisplayed());
		return this;
	}
	
	public StatusChangePreferences selectResource(String resourceValue)
			throws Exception {
		String selectResource=Locators.SELECTRESOURCE+resourceValue+Locators.CLOSINGBRACKETS;
		waitForElement.waitForElements(selectResource, "xpath");
		this.page.element(selectResource, "xpath").getOne().click();
		  return this;
	 }
	
	public StatusChangePreferences clickOnNotifications() throws Exception {
		waitForElement.waitForElements(Locators.NOTIFIACTIONS, "css");
		this.page.element(Locators.NOTIFIACTIONS, "css").getOne().click();
		return this;
   }
	
	
	public StatusChangePreferences verifyStatusChangePreferancePageDisplayedForUser(String user)
			throws Exception {
		waitForElement.waitForElements(Locators.HEADERNAME+user+Locators.CLOSINGBRACKETS, "xpath");
		assertEquals("Status Change Preferences for "+user+"",
				this.page.element(Locators.HEADERNAME+user+Locators.CLOSINGBRACKETS, "xpath").getOne().getText());
		return this;
	 }
	
	public StatusChangePreferences verifyEditMyStatusChangePrefPageDisplayed()
			throws Exception {
		waitForElement.waitForElements(Locators.HEADERNAME, "css");
		assertEquals("Edit My Status Change Preferences",
				this.page.element(Locators.HEADERNAME, "css").getOne().getText());
		return this;
	 }
	
	public StatusChangePreferences verifyResourceAndResourceTypeInEditMyStatusChangePrefPage(String resource, String resourceType)
			throws Exception {
		String resourc=Locators.RESOURCETYPE+resourceType+Locators.RESOURCETYPE1+resource+Locators.CLOSINGBRACKETS;
		System.out.println(resourc);
		waitForElement.waitForElements(resourc, "xpath");
		assertTrue(this.page.element(resourc, "xpath").isElementPresent());
		assertTrue(this.page.element(resourc, "xpath").getOne().isDisplayed());
		return this;
	 }

	public StatusChangePreferences expandUncategorizedSection() throws Exception {
		waitForElement.waitForElements(Locators.UNCATEGORIZE, "xpath");
		this.page.element(Locators.UNCATEGORIZE, "xpath").getOne().click();
		return this;
	 }
	
	public StatusChangePreferences verifyStatusTypesUnderUncategorizedSection(
			String statusTypesNames[]) throws Exception {
		for(int i =0; i<=statusTypesNames.length-1;i++){
		String verifyStatusTypes=Locators.VERIFYSTATUSTYPES+statusTypesNames[i]+Locators.CLOSINGBRACKETS;
		waitForElement.waitForElements(verifyStatusTypes, "xpath");
		assertTrue(this.page.element(verifyStatusTypes, "xpath").isElementPresent());
		assertTrue(this.page.element(verifyStatusTypes, "xpath").getOne().isDisplayed());
		}
		return this;
	 }
	
	public StatusChangePreferences enterAboveValues(String resourceValue,String statusTypesValues, String value) throws Exception {
		String aboveValue=Locators.ABOVEVALUE+resourceValue+Locators.ABOVEVALUE1+statusTypesValues+Locators.ABOVEVALUE2;
		System.out.println(aboveValue);
		waitForElement.waitForElements(aboveValue, "css");
		this.page.element(aboveValue, "css").clearInputValue().sendKeys(value);
		return this;
	 }
	
	public StatusChangePreferences enterBelowValues(String resourceValue,String statusTypesValues, String value) throws Exception {
		String belowValue=Locators.BELOWVALUE+resourceValue+Locators.ABOVEVALUE1+statusTypesValues+Locators.BELOWVALUE2;
		System.out.println(belowValue);
		waitForElement.waitForElements(belowValue, "css");
		this.page.element(belowValue, "css").clearInputValue().sendKeys(value);
		return this;
	 }
	
	public StatusChangePreferences selectEmailChkBoxForAboveAndBelowValue(String resourceValue,String statusTypesValues) throws Exception {
			String emailAbove=Locators.EMAIL+resourceValue+Locators.ABOVEVALUE1+statusTypesValues+Locators.ABOVEVALUE2;
			String emailBelow=Locators.EMAIL+resourceValue+Locators.ABOVEVALUE1+statusTypesValues+Locators.BELOWVALUE2;
			System.out.println(emailAbove);
			System.out.println(emailBelow);
			waitForElement.waitForElements(emailAbove, "css");
		   this.page.element(emailAbove, "css").getOne().click();
		   this.page.element(emailBelow, "css").getOne().click();
		   return this;
	 }
	
	public StatusChangePreferences selectPagerChkBoxForAboveAndBelowValue(String resourceValue,String statusTypesValues) throws Exception {
	        String pagerAbove=Locators.PAGER+resourceValue+Locators.ABOVEVALUE1+statusTypesValues+Locators.ABOVEVALUE2;
	        String pagerBelow=Locators.PAGER+resourceValue+Locators.ABOVEVALUE1+statusTypesValues+Locators.BELOWVALUE2;
			waitForElement.waitForElements(pagerAbove, "css");
			this.page.element(pagerAbove, "css").getOne().click();
			this.page.element(pagerBelow, "css").getOne().click();
			return this;
	 }
		
		public StatusChangePreferences selectWebChkBoxForAboveAndBelowValue(String resourceValue,
				String statusTypesValues) throws Exception {
			String webAbove=Locators.WEB+resourceValue+Locators.ABOVEVALUE1+statusTypesValues+Locators.ABOVEVALUE2;
		    String webBelow=Locators.WEB+resourceValue+Locators.ABOVEVALUE1+statusTypesValues+Locators.BELOWVALUE2;
			waitForElement.waitForElements(webAbove , "css");
			this.page.element(webAbove, "css").getOne().click();
			this.page.element(webBelow, "css").getOne().click();
			return this;
	  }
		
		public StatusChangePreferences clickOnSave() throws Exception {
			waitForElement.waitForElements(Locators.SAVE, "css");
			this.page.element(Locators.SAVE, "css").getOne().click();
			return this;
	  }
		
		public StatusChangePreferences selectEmailPagerWebNotificationsWithAboveAndBelowValues(
				String resourceVal, String statusTypesValues)
				throws Exception {
			this.selectEmailChkBoxForAboveAndBelowValue(resourceVal, statusTypesValues);
			this.selectPagerChkBoxForAboveAndBelowValue(resourceVal, statusTypesValues);
			this.selectWebChkBoxForAboveAndBelowValue(resourceVal, statusTypesValues);
			return this;
		}
		
		public StatusChangePreferences selectEmailChkBoxForStatuses(String resourcesValue,String statusTypeValue,String statusValue) throws Exception {
			String statusEmail=Locators.EMAIL+resourcesValue+Locators.ABOVEVALUE1+statusTypeValue+Locators.EMAILSTATUS+statusValue+Locators.CLOSINGBRACKETS;
			System.out.println("statusEmail"  + statusEmail);
			waitForElement.waitForElements(statusEmail, "css");
			this.page.element(statusEmail, "css").getDisplayedOne().click();			
			return this;
		}
		
		public StatusChangePreferences selectWebChkBoxForStatuses(String resourcesValue,String statusTypeValue,String statusValue) throws Exception {
		String statusWeb=Locators.WEB+resourcesValue+Locators.ABOVEVALUE1+statusTypeValue+Locators.EMAILSTATUS+statusValue+Locators.CLOSINGBRACKETS;
			waitForElement.waitForElements(statusWeb, "css");
			waitForElement.waitForElements(statusWeb, "css");
			this.page.element(statusWeb, "css").getDisplayedOne().click();
			if(!this.page.element(statusWeb, "css").getOne().isSelected())
			{
			this.page.element(statusWeb, "css").getOne().click();
			}
			if(!this.page.element(statusWeb, "css").getOne().isSelected())
			{
			this.page.element(statusWeb, "css").getOne().sendKeys(Keys.SPACE);
			}
			return this;
		}
		
	public StatusChangePreferences selPagerChkBoxForStatuses(String resourcesValue,String statusTypeValue,String statusValue)throws Exception {
		String statusPager = Locators.PAGER + resourcesValue+ Locators.ABOVEVALUE1 + statusTypeValue + Locators.EMAILSTATUS+ statusValue + Locators.CLOSINGBRACKETS;
		waitForElement.waitForElements(statusPager, "css");
		this.page.element(statusPager, "css").getDisplayedOne().click();
		if(!this.page.element(statusPager, "css").getOne().isSelected())
		{
		this.page.element(statusPager, "css").getOne().click();
		}
		if(!this.page.element(statusPager, "css").getOne().isSelected())
		{
		this.page.element(statusPager, "css").getOne().sendKeys(Keys.SPACE);
		}
		return this;
	    }
	
	public StatusChangePreferences selectEmailCheckBoxForTextStatusType(String resourceValue,String statusTypesValues) throws Exception {
		String emailText=Locators.EMAIL+resourceValue+Locators.ABOVEVALUE1+statusTypesValues+Locators.TEXTVALUE1+Locators.CLOSINGBRACKETS;
		System.out.println("TextemailAbove"  + emailText );
		waitForElement.waitForElements(emailText, "css");
		this.page.element(emailText, "css").getOne().click();
		return this;
       }
	
	public StatusChangePreferences selectPagerCheckBoxForTextStatusType(String resourceValue,String statusTypesValues) throws Exception {
		String emailText=Locators.PAGER+resourceValue+Locators.ABOVEVALUE1+statusTypesValues+Locators.TEXTVALUE1+Locators.CLOSINGBRACKETS;
		waitForElement.waitForElements(emailText, "css");
		this.page.element(emailText, "css").getOne().click();
		return this;
       }
	
	public StatusChangePreferences selectWebCheckBoxForTextStatusType(String resourceValue,String statusTypesValues) throws Exception {
		String emailText=Locators.WEB+resourceValue+Locators.ABOVEVALUE1+statusTypesValues+Locators.TEXTVALUE1+Locators.CLOSINGBRACKETS;
		waitForElement.waitForElements(emailText, "css");
		this.page.element(emailText, "css").getOne().click();
		return this;
       }
	
		public StatusChangePreferences assignUserToStatusChangeNotifications(String resource,String resourceValue,String user,
				String resourceType) throws Exception {
			this.verifyStatusChangePreferancePageDisplayedForUser(user);
			this.clickOnAdd();
			this.enterResourceNameInWhatField(resource);
			this.clickOnSearch();
			this.verResourceDisplayedInFindResourceScreen(resource);
			this.selectResource(resourceValue);
			this.clickOnNotifications();
		//	this.verifyResourceAndResourceTypeInEditMyStatusChangePrefPage(resource,resourceType);
			return this;
	   }	
		
		public StatusChangePreferences provideReceiveStatusChangeNotificationsToNumberStatusType(String resourcesValue,String statusTypeValue,String aboveValue,
				String belowValue) throws Exception {
			enterAboveValues(resourcesValue, statusTypeValue,aboveValue);
			enterBelowValues(resourcesValue, statusTypeValue,belowValue);
			selectEmailPagerWebNotificationsWithAboveAndBelowValues(resourcesValue,statusTypeValue);
			return this;
	   }
		
		public StatusChangePreferences provideReceiveStatusChangeNotificationsToSStStatusType(String resourcesValue,String statusTypeValue,String aboveValue,
				String belowValue) throws Exception {
			enterAboveValues(resourcesValue, statusTypeValue,aboveValue);
			enterBelowValues(resourcesValue, statusTypeValue,belowValue);
			selectEmailPagerWebNotificationsWithAboveAndBelowValues(resourcesValue,statusTypeValue);
			return this;
	   }
		
		public StatusChangePreferences provideReceiveStatusChangeNotificationsToStatusUnderMultiStatusType(String resourcesValue,String statusTypeValue,String statusValue1,String statusValue2)throws Exception {
			selectEmailChkBoxForStatuses(resourcesValue,statusTypeValue,statusValue1);
			selectWebChkBoxForStatuses(resourcesValue,statusTypeValue,statusValue1);
			selPagerChkBoxForStatuses(resourcesValue,statusTypeValue,statusValue1);
			
			selectEmailChkBoxForStatuses(resourcesValue,statusTypeValue,statusValue2);
			selectWebChkBoxForStatuses(resourcesValue,statusTypeValue,statusValue2);
			selPagerChkBoxForStatuses(resourcesValue,statusTypeValue,statusValue2);
			return this;
	   }	
		
		public StatusChangePreferences provideReceiveStatusChangeNotificationsToTextStatusType(String resourcesValue,String statusTypeValue)throws Exception {
			selectEmailCheckBoxForTextStatusType(resourcesValue,statusTypeValue);
			selectPagerCheckBoxForTextStatusType(resourcesValue,statusTypeValue);
			selectWebCheckBoxForTextStatusType(resourcesValue,statusTypeValue);
			return this;
	   }
		
		public StatusChangePreferences provideReceiveStatusChangeNotificationsToNedocsStatusType(String resourcesValue,String statusTypeValue,String aboveValue,
				String belowValue) throws Exception {
			enterAboveValues(resourcesValue, statusTypeValue,aboveValue);
			enterBelowValues(resourcesValue, statusTypeValue,belowValue);
			selectEmailPagerWebNotificationsWithAboveAndBelowValues(resourcesValue,statusTypeValue);
			return this;
	   }
		
		public StatusChangePreferences expandAndverifyStatusTypesUnderUncategorizedSection(String[] statusTypesNames) throws Exception {
			expandUncategorizedSection();
			verifyStatusTypesUnderUncategorizedSection(statusTypesNames);
			return this;
	  }	
		
		public StatusChangePreferences provideReceiveStatusChangeNotificationsToDateStatusType(String resourcesValue,String statusTypeValue)throws Exception {
			selectEmailCheckBoxForTextStatusType(resourcesValue,statusTypeValue);
			selectPagerCheckBoxForTextStatusType(resourcesValue,statusTypeValue);
			selectWebCheckBoxForTextStatusType(resourcesValue,statusTypeValue);
			 return this;
	  }
		
		public StatusChangePreferences verifyStatusTypesUnderResourceInStatusChangePreferncsPage(String resource,
				String statusTypesNames[]) throws Exception {
			for(int i =0; i<=statusTypesNames.length-1;i++){
			String verifyStatusTypes=Locators.STATUSTYPESUNDERRESOURC+resource+Locators.CLOSINGBRACKETS+Locators.STATUSTYPESUNDERRESOURC1+statusTypesNames[i]+Locators.CLOSINGBRACKETS;
			waitForElement.waitForElements(verifyStatusTypes, "xpath");
			assertTrue(this.page.element(verifyStatusTypes, "xpath").isElementPresent());
			assertTrue(this.page.element(verifyStatusTypes, "xpath").getOne().isDisplayed());
			}
			return this;
		 }
		
		public StatusChangePreferences verifyMyStatusChangePreferencesPage() throws Exception {
			waitForElement.waitForElements(Locators.MY_STATUS_CHANGE_PREFERENCES_PAGE, "xpath");
			assertTrue(this.page.element(Locators.MY_STATUS_CHANGE_PREFERENCES_PAGE, "xpath").isElementPresent());
			assertTrue(this.page.element(Locators.MY_STATUS_CHANGE_PREFERENCES_PAGE, "xpath").getOne().isDisplayed());
			return this;
		}
		
		public StatusChangePreferences verifyStatusTypesUnderSection(String statusTypesNames[], String sectionName) throws Exception {
			for(int i =0; i<=statusTypesNames.length-1;i++){
			String verifyStatusTypesUnderSection=Locators.VERIFYSTATUSTYPES+statusTypesNames[i]+Locators.CLOSINGBRACKETS+Locators.SECTION +sectionName+Locators.CLOSINGBRACKETS;
			waitForElement.waitForElements(verifyStatusTypesUnderSection, "xpath");
			assertTrue(this.page.element(verifyStatusTypesUnderSection, "xpath").isElementPresent());
			assertTrue(this.page.element(verifyStatusTypesUnderSection, "xpath").getOne().isDisplayed());
			}
			return this;
		 }
		
		public StatusChangePreferences setStatusChangeNotifications(String resource,String resourceValue,
				String resourceType) throws Exception {
			this.verifyMyStatusChangePreferencesPage();
			this.clickOnAdd();
			this.enterResourceNameInWhatField(resource);
			this.clickOnSearch();
			this.verResourceDisplayedInFindResourceScreen(resource);
			this.selectResource(resourceValue);
			this.clickOnNotifications();
			this.verifyResourceAndResourceTypeInEditMyStatusChangePrefPage(resource,resourceType);
			return this;
	   }
		
		public StatusChangePreferences expandAndverifyStatusTypesUnderSection(ArrayList<String> statusTypesName, String sectionName) throws Exception {
			this.expandUncategorizedSection();
			this.verifyStatusTypesUnderSection(statusTypesName, sectionName);
			return this;
	  }	
		
		public StatusChangePreferences editPreference(String resourceName) throws Exception {
			waitForElement.waitForElements(Locators.STATUSTYPESUNDERRESOURC+ resourceName + Locators.CLOSINGBRACKETS + Locators.EDIT_PREFERENCE, "xpath");
			this.page.element(Locators.STATUSTYPESUNDERRESOURC+ resourceName + Locators.CLOSINGBRACKETS + Locators.EDIT_PREFERENCE, "xpath").getDisplayedOne().click();
			return this;
		}
		
		public StatusChangePreferences verifyStatusTypesUnderSection(ArrayList<String> statusTypesName, String sectionName) throws Exception {
			for (String statusTypesNames : statusTypesName) {
				waitForElement.waitForElements(Locators.VERIFYSTATUSTYPES+statusTypesNames+Locators.CLOSINGBRACKETS+Locators.SECTION +sectionName+Locators.CLOSINGBRACKETS, "xpath");
				assertTrue(this.page.element(Locators.VERIFYSTATUSTYPES+statusTypesNames+Locators.CLOSINGBRACKETS+Locators.SECTION +sectionName+Locators.CLOSINGBRACKETS, "xpath").isElementPresent());
				assertTrue(this.page.element(Locators.VERIFYSTATUSTYPES+statusTypesNames+Locators.CLOSINGBRACKETS+Locators.SECTION +sectionName+Locators.CLOSINGBRACKETS, "xpath").getOne().isDisplayed());
			}
			return this;
		 }
		
		public StatusChangePreferences verifyStatusTypesUnderResourceInStatusChangePreferencesPage(String resourceName,
				ArrayList<String> statusTypesName) throws Exception {
			for (String statusTypesNames : statusTypesName) {
				waitForElement.waitForElements(Locators.STATUSTYPESUNDERRESOURC+resourceName+Locators.CLOSINGBRACKETS+Locators.STATUS_TYPES_UNDER_RESOURCE_PART2+statusTypesNames+Locators.CLOSINGBRACKETS, "xpath");
				assertTrue(this.page.element(Locators.STATUSTYPESUNDERRESOURC+resourceName+Locators.CLOSINGBRACKETS+Locators.STATUS_TYPES_UNDER_RESOURCE_PART2+statusTypesNames+Locators.CLOSINGBRACKETS, "xpath").isElementPresent());
				assertTrue(this.page.element(Locators.STATUSTYPESUNDERRESOURC+resourceName+Locators.CLOSINGBRACKETS+Locators.STATUS_TYPES_UNDER_RESOURCE_PART2+statusTypesNames+Locators.CLOSINGBRACKETS, "xpath").getOne().isDisplayed());
			}
			return this;
		 }
		
		public StatusChangePreferences clickOnCancel() throws Exception {
			waitForElement.waitForElements(Locators.CANCEL, "css");
			this.page.element(Locators.CANCEL, "css").getOne().click();
			return this;
	  }
		
		public StatusChangePreferences verifyStatusTypesNotUnderSection(ArrayList<String> statusTypesName, String sectionName) throws Exception {
			for (String statusTypesNames : statusTypesName) {
				assertFalse(this.page.element(Locators.VERIFYSTATUSTYPES+statusTypesNames+Locators.CLOSINGBRACKETS+Locators.SECTION +sectionName+Locators.CLOSINGBRACKETS, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL));
			}
			return this;
		 }

		public StatusChangePreferences expandAndverifyStatusTypesNotUnderSection(ArrayList<String> statusTypesName, String sectionName) throws Exception {
			this.expandUncategorizedSection();
			this.verifyStatusTypesNotUnderSection(statusTypesName, sectionName);
			return this;
	  }	
		
		public StatusChangePreferences verifyStatusChangeNotificationPreferencesAreDeleted(String resourceName,
				ArrayList<String> statusTypesName) throws Exception {
			for (String statusTypesNames : statusTypesName) {
				assertFalse(this.page.element(Locators.STATUSTYPESUNDERRESOURC+resourceName+Locators.CLOSINGBRACKETS+Locators.STATUS_TYPES_UNDER_RESOURCE_PART2+statusTypesNames+Locators.CLOSINGBRACKETS, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL));
			}
			return this;
		 }
		
		public StatusChangePreferences verifyRetainedStatusUnderMultiStatusType(String statusTypeName,String BelowValue) throws Exception {
			String belowValue =Locators.TABLE_ROW_FOLLOWED_BY_TABLE_DATA+ statusTypeName + Locators.RETAINED_MULTI_STATUS_VALUE+BelowValue+Locators.CLOSINGBRACKETS; 
			waitForElement.waitForElements(belowValue, "xpath");
			assertTrue(this.page.element(belowValue, "xpath").isElementPresent(),belowValue +" value is not retained under My Status Change Preferences page");
			assertTrue(this.page.element(belowValue, "xpath").getOne().isDisplayed(),belowValue +" value is not retained under My Status Change Preferences page");
			return this;
		}
		
		public StatusChangePreferences verifyAboveValue(String statusTypeName,String AboveValue) throws Exception {
			String aboveValue =Locators.TABLE_ROW_FOLLOWED_BY_TABLE_DATA+ statusTypeName + Locators.RETAINED_ABOVE_VALUE+AboveValue+Locators.CLOSINGBRACKETS; 
			waitForElement.waitForElements(aboveValue, "xpath");
			assertTrue(this.page.element(aboveValue, "xpath").isElementPresent(),AboveValue +" value is not retained under My Status Change Preferences page");
			assertTrue(this.page.element(aboveValue, "xpath").getOne().isDisplayed(),AboveValue +" value is not retained under My Status Change Preferences page");
			return this;
		}
		
		public StatusChangePreferences verifyBelowValue(String statusTypeName,String BelowValue) throws Exception {
			String belowValue =Locators.TABLE_ROW_FOLLOWED_BY_TABLE_DATA+ statusTypeName + Locators.RETAINED_BELOW_VALUE+BelowValue+Locators.CLOSINGBRACKETS; 
			waitForElement.waitForElements(belowValue, "xpath");
			assertTrue(this.page.element(belowValue, "xpath").isElementPresent(),belowValue +" value is not retained under My Status Change Preferences page");
			assertTrue(this.page.element(belowValue, "xpath").getOne().isDisplayed(),belowValue +" value is not retained under My Status Change Preferences page");
			return this;
		}
		
		public StatusChangePreferences verifyRetainedAboveAndBelowValuesOfNumberOrSaturationOrNedocsStatustype(String statusTypeName,String AboveValue,String BelowValue) throws Exception {
			this.verifyAboveValue(statusTypeName, AboveValue);
			this.verifyBelowValue(statusTypeName, BelowValue);
			return this;	
		}
		
		public StatusChangePreferences verifyRetainedAboveAndBelowValuesOfStatustypes(String statusTypeName1,String AboveValue1,String BelowValue1,String statusTypeName2,String AboveValue2,String BelowValue2,String statusTypeName3,String AboveValue3) throws Exception {
			
			this.verifyAboveValue(statusTypeName1, AboveValue1);
			this.verifyBelowValue(statusTypeName1, BelowValue1);
			this.verifyAboveValue(statusTypeName2, AboveValue2);
			this.verifyBelowValue(statusTypeName2, BelowValue2);
			this.verifyRetainedStatusUnderMultiStatusType(statusTypeName3,AboveValue3);
			return this;	
		}
		
		public StatusChangePreferences provideReceiveStatusChangeNotificationsToSingleStatusUnderMultiStatusType(String resourcesValue,String statusTypeValue,String statusValue1)throws Exception {
			this.selectEmailChkBoxForStatuses(resourcesValue,statusTypeValue,statusValue1);
			this.selectWebChkBoxForStatuses(resourcesValue,statusTypeValue,statusValue1);
			this.selPagerChkBoxForStatuses(resourcesValue,statusTypeValue,statusValue1);
			return this;
        }
      
		public StatusChangePreferences EditAndNavigateToEditMyStatusChangeNotifications(String resource) throws Exception {
			this.verifyMyStatusChangePreferencesPage();
			this.editPreference(resource);
			return this;
	   }	
		
		public StatusChangePreferences verifyStatusTypesUnderUncategorizedSection(
				ArrayList<String>  statusTypesNames) throws Exception {
			for(int i =0; i<statusTypesNames.size();i++){
			String verifyStatusTypes=Locators.VERIFYSTATUSTYPES+statusTypesNames.get(i)+Locators.CLOSINGBRACKETS;
			waitForElement.waitForElements(verifyStatusTypes, "xpath");
			assertTrue(this.page.element(verifyStatusTypes, "xpath").isElementPresent());
			assertTrue(this.page.element(verifyStatusTypes, "xpath").getOne().isDisplayed());
			}
			return this;
		 }
		
		public StatusChangePreferences expandAndverifyStatusTypesUnderUncategorizedSection(ArrayList<String>  statusTypesNames) throws Exception {
			expandUncategorizedSection();
			verifyStatusTypesUnderUncategorizedSection(statusTypesNames);
			return this;
	  }	
		
		public StatusChangePreferences verifyStatusTypesUnderResourceInStatusChangePreferncsPage(String resource,
				ArrayList <String> statusTypesNames) throws Exception {
			
			Iterator<String> itr=statusTypesNames.iterator();
			while(itr.hasNext()){
			String STNames=itr.next();
			String statusTypeNames = Locators.STATUSTYPESUNDERRESOURC+resource+Locators.CLOSINGBRACKETS+Locators.STATUSTYPESUNDERRESOURC1+STNames+Locators.CLOSINGBRACKETS;
			waitForElement.waitForElements(statusTypeNames, "xpath");
			assertTrue(this.page.element(statusTypeNames, "xpath").isElementPresent());
			assertTrue(this.page.element(statusTypeNames, "xpath").getOne().isDisplayed());
			}
			return this;
		}	
		
		public StatusChangePreferences savePreferences() throws Exception {
			this.clickOnSave();
			return this;
	  }
		
		public StatusChangePreferences deselectEmailChkBoxForAboveAndBelowValue(String resourceValue,String statusTypesValues) throws Exception {
			String emailAbove=Locators.EMAIL+resourceValue+Locators.ABOVEVALUE1+statusTypesValues+Locators.ABOVEVALUE2;
			String emailBelow=Locators.EMAIL+resourceValue+Locators.ABOVEVALUE1+statusTypesValues+Locators.BELOWVALUE2;
			System.out.println(emailAbove);
			System.out.println(emailBelow);
			waitForElement.waitForElements(emailAbove, "css");
			if(this.page.element(emailAbove, "css").getOne().isSelected() && this.page.element(emailBelow, "css").getOne().isSelected())
			{
			this.page.element(emailAbove, "css").getDisplayedOne().click();
			this.page.element(emailBelow, "css").getDisplayedOne().click();
			}
			
			if(this.page.element(emailAbove, "css").getOne().isSelected() && this.page.element(emailBelow, "css").getOne().isSelected())
			{
			this.page.element(emailAbove, "css").getDisplayedOne().sendKeys(Keys.SPACE);
			this.page.element(emailBelow, "css").getDisplayedOne().sendKeys(Keys.SPACE);
			}
			
			if(this.page.element(emailAbove, "css").getOne().isSelected() && this.page.element(emailBelow, "css").getOne().isSelected())
			{
			this.page.element(emailAbove, "css").clickUsingJSE();
			this.page.element(emailBelow, "css").clickUsingJSE();
			}
			assertTrue(this.page.element(emailAbove, "css").getOne().isSelected()==false && this.page.element(emailBelow, "css").getOne().isSelected()==false);
			return this;
	  }
	
	public StatusChangePreferences deselectPagerChkBoxForAboveAndBelowValue(String resourceValue,String statusTypesValues) throws Exception {
	        String pagerAbove=Locators.PAGER+resourceValue+Locators.ABOVEVALUE1+statusTypesValues+Locators.ABOVEVALUE2;
	        String pagerBelow=Locators.PAGER+resourceValue+Locators.ABOVEVALUE1+statusTypesValues+Locators.BELOWVALUE2;
			waitForElement.waitForElements(pagerAbove, "css");
			
			if(this.page.element(pagerAbove, "css").getOne().isSelected() && this.page.element(pagerBelow, "css").getOne().isSelected())
			{
			this.page.element(pagerAbove, "css").getDisplayedOne().sendKeys(Keys.SPACE);
			this.page.element(pagerBelow, "css").getDisplayedOne().sendKeys(Keys.SPACE);
			}
			
			if(this.page.element(pagerAbove, "css").getOne().isSelected() && this.page.element(pagerBelow, "css").getOne().isSelected())
			{
			this.page.element(pagerAbove, "css").getDisplayedOne().click();
			this.page.element(pagerBelow, "css").getDisplayedOne().click();
			}
			
			if(this.page.element(pagerAbove, "css").getOne().isSelected() && this.page.element(pagerBelow, "css").getOne().isSelected())
			{
			this.page.element(pagerAbove, "css").clickUsingJSE();
			this.page.element(pagerBelow, "css").clickUsingJSE();
			}
			assertTrue(this.page.element(pagerAbove, "css").getOne().isSelected()==false && this.page.element(pagerBelow, "css").getOne().isSelected()==false);
			return this;
	 }
		
	public StatusChangePreferences deselectWebChkBoxForAboveAndBelowValue(String resourceValue,
				String statusTypesValues) throws Exception {
			String webAbove=Locators.WEB+resourceValue+Locators.ABOVEVALUE1+statusTypesValues+Locators.ABOVEVALUE2;
		    String webBelow=Locators.WEB+resourceValue+Locators.ABOVEVALUE1+statusTypesValues+Locators.BELOWVALUE2;
			waitForElement.waitForElements(webAbove , "css");
			
			if(this.page.element(webAbove, "css").getOne().isSelected() && this.page.element(webBelow, "css").getOne().isSelected())
			{
			this.page.element(webAbove, "css").getDisplayedOne().sendKeys(Keys.SPACE);
			this.page.element(webBelow, "css").getDisplayedOne().sendKeys(Keys.SPACE);
			}
			
			if(this.page.element(webAbove, "css").getOne().isSelected() && this.page.element(webBelow, "css").getOne().isSelected())
			{
			this.page.element(webAbove, "css").getDisplayedOne().click();
			this.page.element(webBelow, "css").getDisplayedOne().click();
			}
			
			if(this.page.element(webAbove, "css").getOne().isSelected() && this.page.element(webBelow, "css").getOne().isSelected())
			{
			this.page.element(webAbove, "css").clickUsingJSE();
			this.page.element(webBelow, "css").clickUsingJSE();
			}
			assertTrue(this.page.element(webAbove, "css").getOne().isSelected()==false && this.page.element(webBelow, "css").getOne().isSelected()==false);
			return this;
	  }
		
	public StatusChangePreferences changeAboveAndBelowValuesForNumberStatusType(String resourcesValue,String statusTypeValue,String aboveValue,
				String belowValue) throws Exception {
			enterAboveValues(resourcesValue, statusTypeValue,aboveValue);
			enterBelowValues(resourcesValue, statusTypeValue,belowValue);
			return this;
		}
		
	public StatusChangePreferences changeAboveAndBelowValuesForSaturationStatusType(String resourcesValue,String statusTypeValue,String aboveValue,
				String belowValue) throws Exception {
			enterAboveValues(resourcesValue, statusTypeValue,aboveValue);
			enterBelowValues(resourcesValue, statusTypeValue,belowValue);
			return this;
		}
		
	public StatusChangePreferences deSelectEmailChkBoxForStatuses(String resourcesValue,String statusTypeValue,String statusValue) throws Exception {
			String statusEmail=Locators.EMAIL+resourcesValue+Locators.ABOVEVALUE1+statusTypeValue+Locators.EMAILSTATUS+statusValue+Locators.CLOSINGBRACKETS;
			waitForElement.waitForElements(statusEmail, "css");
			if(this.page.element(statusEmail, "css").getOne().isSelected())
			{
			this.page.element(statusEmail, "css").getDisplayedOne().sendKeys(Keys.SPACE);
			}
			if(this.page.element(statusEmail, "css").getOne().isSelected())
			{
			this.page.element(statusEmail, "css").getDisplayedOne().click();
			}
			if(this.page.element(statusEmail, "css").getOne().isSelected())
			{
			this.page.element(statusEmail, "css").clickUsingJSE();
			}
			assertTrue(this.page.element(statusEmail, "css").getOne().isSelected()==false);
		return this;
       }		
			
	public StatusChangePreferences deSelectWebChkBoxForStatuses(String resourcesValue,String statusTypeValue,String statusValue) throws Exception {
		String statusWeb=Locators.WEB+resourcesValue+Locators.ABOVEVALUE1+statusTypeValue+Locators.EMAILSTATUS+statusValue+Locators.CLOSINGBRACKETS;
			waitForElement.waitForElements(statusWeb, "css");
			if(this.page.element(statusWeb, "css").getOne().isSelected())
			{
			this.page.element(statusWeb, "css").getDisplayedOne().sendKeys(Keys.SPACE);
			}
			if(this.page.element(statusWeb, "css").getOne().isSelected())
			{
			this.page.element(statusWeb, "css").getDisplayedOne().click();
			}
			if(this.page.element(statusWeb, "css").getOne().isSelected())
			{
			this.page.element(statusWeb, "css").clickUsingJSE();
			}
			assertTrue(this.page.element(statusWeb, "css").getOne().isSelected()==false);
			return this;
		}
		
	public StatusChangePreferences deSelectPagerChkBoxForStatuses(String resourcesValue,String statusTypeValue,String statusValue)throws Exception {
		String statusPager = Locators.PAGER + resourcesValue+ Locators.ABOVEVALUE1 + statusTypeValue + Locators.EMAILSTATUS+ statusValue + Locators.CLOSINGBRACKETS;
		waitForElement.waitForElements(statusPager, "css");
		if(this.page.element(statusPager, "css").getOne().isSelected())
		{
		this.page.element(statusPager, "css").getDisplayedOne().sendKeys(Keys.SPACE);
		}
		if(this.page.element(statusPager, "css").getOne().isSelected())
		{
		this.page.element(statusPager, "css").getDisplayedOne().click();
		}
		if(this.page.element(statusPager, "css").getOne().isSelected())
		{
		this.page.element(statusPager, "css").clickUsingJSE();
		}
		assertTrue(this.page.element(statusPager, "css").getOne().isSelected()==false);
		return this;
	}
	
	public StatusChangePreferences deSelectMailWebPagerToSingleStatusUnderMultiStatusType(String resourcesValue,String statusTypeValue,String statusValue1)throws Exception {
		this.deSelectEmailChkBoxForStatuses(resourcesValue,statusTypeValue,statusValue1);
		this.deSelectWebChkBoxForStatuses(resourcesValue,statusTypeValue,statusValue1);
		this.deSelectPagerChkBoxForStatuses(resourcesValue,statusTypeValue,statusValue1);
		return this;
    }
	
	public StatusChangePreferences searchResource(String resourceName) throws Exception {
		this.verifyMyStatusChangePreferencesPage();
		this.clickOnAdd();
		this.enterResourceNameInWhatField(resourceName);
		this.clickOnSearch();
		return this;
   }
	
	public StatusChangePreferences deletePreferences(String resourceName) throws Exception {
		waitForElement.waitForElements(Locators.STATUSTYPESUNDERRESOURC+ resourceName + Locators.CLOSINGBRACKETS + Locators.EDIT_PREFERENCE, "xpath");
		this.page.element(Locators.STATUSTYPESUNDERRESOURC+ resourceName + Locators.CLOSINGBRACKETS + Locators.DELETE_NOTIFICATIONS, "xpath").getDisplayedOne().click();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert;
		try{ 	
		alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		assertTrue(alert.getText().equals("Are you sure you would like to delete all status notification preferences for the selected Resource?"));
		alert.accept();	
		this.page.element_wait(Locators.STATUSTYPESUNDERRESOURC+ resourceName + Locators.CLOSINGBRACKETS + Locators.DELETE_NOTIFICATIONS, "xpath").waitForInvisibilityOfElement();
		waitForElement.waitForElements(Locators.ADD, "css");
		}
		catch(NoAlertPresentException e)
		{
		this.page.element(Locators.STATUSTYPESUNDERRESOURC+ resourceName + Locators.CLOSINGBRACKETS + Locators.DELETE_NOTIFICATIONS, "xpath").clickUsingJSE();	
		wait.until(ExpectedConditions.alertIsPresent());
		alert = driver.switchTo().alert();
		System.out.println(alert.getText());	
		assertTrue(alert.getText().equals("Are you sure you would like to delete all status notification preferences for the selected Resource?"));
		alert.accept();	
		this.page.element_wait(Locators.STATUSTYPESUNDERRESOURC+ resourceName + Locators.CLOSINGBRACKETS + Locators.DELETE_NOTIFICATIONS, "xpath").waitForInvisibilityOfElement();
		waitForElement.waitForElements(Locators.ADD, "css");
		}
		Thread.sleep(3000);
		return this;
	}
	
	public StatusChangePreferences verifyRetainedStatusChangePreferenceValues(String statusTypeName1,String statusTypeName2,String statusTypeName3,String aboveValue,String belowValue,String status) throws Exception {
		this.verifyRetainedAboveAndBelowValuesOfNumberOrSaturationOrNedocsStatustype(statusTypeName1, aboveValue, belowValue);
	    this.verifyRetainedAboveAndBelowValuesOfNumberOrSaturationOrNedocsStatustype(statusTypeName3, aboveValue, belowValue);
	    this.verifyRetainedStatusUnderMultiStatusType(statusTypeName2, status);
	    return this;
	}
	
	public StatusChangePreferences provideReceiveStatusChangeMailNotificationToNumberStatusType(String resourcesValue,String statusTypeValue,String aboveValue,
			String belowValue) throws Exception {
		enterAboveValues(resourcesValue, statusTypeValue,aboveValue);
		enterBelowValues(resourcesValue, statusTypeValue,belowValue);
		this.deselectEmailChkBoxForAboveAndBelowValue(resourcesValue, statusTypeValue);
		this.deselectPagerChkBoxForAboveAndBelowValue(resourcesValue, statusTypeValue);
		this.deselectWebChkBoxForAboveAndBelowValue(resourcesValue, statusTypeValue);
		this.selectEmailChkBoxForAboveAndBelowValue(resourcesValue, statusTypeValue);
		return this;
   }
	
	public StatusChangePreferences provideReceiveStatusChangePagerNotificationsToStatusUnderMultiStatusType(String resourcesValue,String statusTypeValue,String statusValue1,String statusValue2)throws Exception {
		this.deSelectMailWebPagerToSingleStatusUnderMultiStatusType(resourcesValue, statusTypeValue, statusValue1);
		this.deSelectMailWebPagerToSingleStatusUnderMultiStatusType(resourcesValue, statusTypeValue, statusValue2);
	    this.selPagerChkBoxForStatuses(resourcesValue,statusTypeValue,statusValue1);
	    this.selPagerChkBoxForStatuses(resourcesValue,statusTypeValue,statusValue2);
		return this;
   }	
	
	public StatusChangePreferences provideReceiveStatusChangeWebNotificationsToSStStatusType(String resourcesValue,String statusTypeValue,String aboveValue,
			String belowValue) throws Exception {
		this.enterAboveValues(resourcesValue, statusTypeValue,aboveValue);
		this.enterBelowValues(resourcesValue, statusTypeValue,belowValue);
		this.deselectEmailChkBoxForAboveAndBelowValue(resourcesValue, statusTypeValue);
		this.deselectPagerChkBoxForAboveAndBelowValue(resourcesValue, statusTypeValue);
		this.deselectWebChkBoxForAboveAndBelowValue(resourcesValue, statusTypeValue);
		this.selectWebChkBoxForAboveAndBelowValue(resourcesValue, statusTypeValue);
		return this;
   }	
	
	public StatusChangePreferences verifyStatusTypesNotUnderResourceInStatusChangePreferencesPage(String resourceName,
			ArrayList<String> statusTypesName) throws Exception {
		for (String statusTypesNames : statusTypesName) {
			assertFalse(this.page.element(Locators.STATUSTYPESUNDERRESOURC+resourceName+Locators.CLOSINGBRACKETS+Locators.STATUS_TYPES_UNDER_RESOURCE_PART2+statusTypesNames+Locators.CLOSINGBRACKETS, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL));
		}
		return this;
	 }
	
	public StatusChangePreferences verifyStatusTypesNotPresentUnderUncategorizedSection(ArrayList<String> statusTypesNames) throws Exception {
		
		Iterator<String> itr=statusTypesNames.iterator();
		while(itr.hasNext())
		{
		String verifyStatusTypesNotPresent=Locators.VERIFYSTATUSTYPES+itr.next()+Locators.CLOSINGBRACKETS;
		assertFalse(this.page.element(verifyStatusTypesNotPresent, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL));
		}
		return this;
	 }
	
	public StatusChangePreferences verifyEditMyStatusChangePreferancesPage() throws Exception {
		waitForElement.waitForElements(Locators.EDIT_MY_STATUS_CHANGE_PREFERANCES_PAGE, "xpath");
		assertTrue(this.page.element(Locators.EDIT_MY_STATUS_CHANGE_PREFERANCES_PAGE, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.EDIT_MY_STATUS_CHANGE_PREFERANCES_PAGE, "xpath").getOne().isDisplayed());
		return this;
	}
	
	public StatusChangePreferences verifyStatusTypesNotUnderEditMyStatusChangePreferencesPage(ArrayList<String> statusTypesName,String section) throws Exception {
		this.verifyEditMyStatusChangePreferancesPage();
		this.expandAndverifyStatusTypesNotUnderSection(statusTypesName, section);
		return this;
	 }
	
	public StatusChangePreferences verifyStatusTypesDisplayedUnderEditMyStatusChangePreferencesPage(ArrayList<String> statusTypesName,String section) throws Exception {
		this.verifyEditMyStatusChangePreferancesPage();
		this.expandAndverifyStatusTypesUnderSection(statusTypesName, section);
		return this;
	 }
	
	
}

