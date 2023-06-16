package org.mmp.methods;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class MMPUtil {

	WebDriver driver;

	public MMPUtil(WebDriver driver)
	{
		this.driver=driver;
	}

	public void lauchBrowser(String url)
	{
		driver.get(url);
	}
 
	 
	public static WebElement explicitTimeOut(WebDriver driver, int timeinSecs,By locator)
	{
		//Explicit Wait
		Duration d = Duration.ofSeconds(timeinSecs);
		WebDriverWait wait = new WebDriverWait(driver,d);
		WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return e;
	}
}
























