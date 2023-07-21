package org.mmp.adminmodule.pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminSendMessagesPage {

	protected WebDriver driver;	
	private By messagesLinkText = By.linkText("Messages");
	public AdminSendMessagesPage(WebDriver driver)
	{
		this.driver = driver;
	}
	public HashMap<String, String> fetchMessagedetails()
	{
		//6. Click on Messages tab
		driver.findElement(messagesLinkText).click();
		HashMap<String,String> actualHMap = new HashMap<String,String>();
		actualHMap.put("firstName",driver.findElement(By.xpath("//table[@class='table']/tbody/tr[2]/td[1]")).getText().trim());
		actualHMap.put("reason",driver.findElement(By.xpath("//table[@class='table']/tbody/tr[2]/td[2]")).getText().trim());
		actualHMap.put("subject",driver.findElement(By.xpath("//table[@class='table']/tbody/tr[3]/td[2]")).getText().trim());
		return actualHMap;
		 
	}
}
