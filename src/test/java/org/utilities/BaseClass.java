package org.utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
			
		public static WebDriver driver;
		public static Actions a;
		public static Robot r;
		public static Alert al;
		//1 driver launch
		public static void launchChrome() {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		//2 maximize
		public static void winMax() {
			driver.manage().window().maximize();

		}
		//3 browser launch
		public static void loadUrl(String url) {
		driver.get(url);	
		}
		//4 get title
		public static void printTitle() {
			System.out.println(driver.getTitle());

		}
		//5 get url
		public static void printCurrentUrl() {
		System.out.println(driver.getCurrentUrl());

		}
		//6 send keys
		public static void sendName(WebElement elm,String value) {
			elm.sendKeys(value);	

		}
		//7 context click
		public static void rightClick(WebElement elm) {
			a=new Actions(driver);
			a.contextClick().perform();
		}
		//8 double click
		public static void dClick() {
			a=new Actions(driver);
			a.doubleClick().perform();

		}
		//9 click
		public static void btnClick(WebElement elm) {
			elm.click();

		}
		//10 get text
		public static void printText(WebElement elm) {
			String txt = elm.getText();
			System.out.println(txt);
		}
		//11 get attribute
		public static void displayText(WebElement elm) {
			String txt = elm.getAttribute("value");
			System.out.println(txt);

		}
		//12 movetoelement
		public static void mouseMove(WebElement elm) {
			a=new Actions(driver);
			a.moveToElement(elm).perform();

		}
		//13 dranganddrop
		public static void takeandPut(WebElement src, WebElement dest) {
			a=new Actions(driver);
			a.dragAndDrop(src, dest).perform();

		}
		//14 15 keyup and down
		public static void kDown(WebElement elm) {
			a=new Actions(driver);
			a.keyDown(Keys.SHIFT).perform();
			a.sendKeys(elm, "greens");
			a.keyUp(Keys.SHIFT).perform();
		}
		//16  key press in robot
		public static void kDown() throws AWTException {
			r=new Robot();
		for(int i=0;i<3;i++)
		{
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
		}
		
		}
		//17 enter robot
		public static void kEnter() throws AWTException {
			r=new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);

		}
		
		
		//18 copy robot
		public static void copyR() throws AWTException {
			r=new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_C);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_C);
		}
		//19 paste robot
		public static void pasteR() throws AWTException {
			r=new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_V);

		}
		//20 cut robot
		public static void cutR() throws AWTException {
			r=new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_X);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_X);	

		}
		//21 accept
		public static void acceptAlert() {
			al=driver.switchTo().alert();
			al.accept();

		}
		//22 dismiss
		public static void dismissAlert() {
			al=driver.switchTo().alert();
			al.dismiss();
		}
		//23 alert sendkeys
		public static void passvalAlert(String value) {
			al=driver.switchTo().alert();
			al.sendKeys(value);

		}
		//24 alert get text
		public static void gettxtAlert() {
			al=driver.switchTo().alert();
			al.getText();

		}
		//25
		public static void screenShot(String name) {
			TakesScreenshot tk=(TakesScreenshot)driver;
			File src = tk.getScreenshotAs(OutputType.FILE);
			File des=new File("");

		}
		
}
