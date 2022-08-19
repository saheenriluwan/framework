package org.baseproj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.utilities.BaseClass;

public class BrowserLaunch extends BaseClass {
public static void main(String[] args) {
	launchChrome();
	loadUrl("https://www.facebook.com");
	winMax();
	printTitle();
	printCurrentUrl();

WebElement uname = driver.findElement(By.id("email"));
	sendName(uname, "greens");

WebElement pwd = driver.findElement(By.id("pass"));
sendName(pwd, "dfs243");

displayText(uname);

}

}