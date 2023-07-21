package org.mmp.patientmodule.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PatientSendMessagesPage {
	protected WebDriver driver;	
	private By messageslinkText = By.linkText("Messages");
	public PatientSendMessagesPage(WebDriver driver)
	{
		this.driver = driver;
	}
	public String sendMessage(String reason,String subject)
	{
		//2. Click on MEssages tab
		driver.findElement(messageslinkText).click();
		//3. Fill the details
		driver.findElement(By.id("subject")).sendKeys(reason);
		driver.findElement(By.id("message")).sendKeys(subject);
		driver.findElement(By.cssSelector("input[value='Send']")).click();
		Alert alrt = driver.switchTo().alert();
		String message = alrt.getText();
		alrt.accept();
		return message;
	}
}
