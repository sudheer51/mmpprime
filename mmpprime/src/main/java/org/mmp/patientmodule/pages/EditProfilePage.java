package org.mmp.patientmodule.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditProfilePage {

	protected WebDriver driver;	
	private By profileLinkText = By.linkText("Profile");
	public EditProfilePage(WebDriver driver)
	{
		this.driver = driver;
	}
	public String fetchPatientUserName()
	{
		driver.findElement(profileLinkText).click();
		String patientFName = driver.findElement(By.id("fname")).getAttribute("value");
		return patientFName;
		 
	}
}
