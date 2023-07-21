package org.mmp.patientmodule.tests;

import java.util.HashMap;

import org.mmp.adminmodule.pages.AdminSendMessagesPage;
import org.mmp.methods.BaseClass;
import org.mmp.methods.HelperClass;
import org.mmp.methods.MMPUtil;
import org.mmp.patientmodule.pages.EditProfilePage;
import org.mmp.patientmodule.pages.PatientSendMessagesPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SendMessages extends BaseClass {

	MMPUtil mmpUtil ;
	PatientSendMessagesPage patientMessagePage;
	AdminSendMessagesPage adminMessagePage;
	HelperClass helperObj;
	
	@BeforeMethod
	public void preRequisite()
	{
		mmpUtil = new MMPUtil(driver);
		mmpUtil.lauchBrowser(pro.getProperty("patientURL"));
		helperObj = new HelperClass(driver);
		//1. Login to Patient module
		helperObj.login(pro.getProperty("patientUsername"), pro.getProperty("patientPassword"));
		patientMessagePage = new PatientSendMessagesPage(driver);
	}
 
	@Test
	public void TC_004_validateSendMessages()
	{
 
		String expectedMsg="Messages Successfully sent.";
		String actualMsg= patientMessagePage.sendMessage("To meet doctor from AUT","Having cold");
		SoftAssert sa = new SoftAssert();
		
		//4. Validate the message displayed in the Alert
		sa.assertEquals(actualMsg,expectedMsg);
		
		EditProfilePage profilePage = new EditProfilePage(driver);
		HashMap<String,String> expectedHMap = new HashMap<String,String>();
		expectedHMap.put("firstName", 	profilePage.fetchPatientUserName());
		expectedHMap.put("reason","To meet doctor from AUT");
		expectedHMap.put("subject","Having cold");
		
		//Login to Admin
		mmpUtil.lauchBrowser(pro.getProperty("adminURL"));
		
		//5. login to Admin module
		helperObj.login(pro.getProperty("adminUsername"), pro.getProperty("adminPassword"));
		adminMessagePage = new AdminSendMessagesPage(driver);
		HashMap<String,String> actualHMap=adminMessagePage.fetchMessagedetails();
		
		
		//7. validate the firstname and details sent from patient module
		sa.assertEquals(actualHMap,expectedHMap);
		sa.assertAll();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
