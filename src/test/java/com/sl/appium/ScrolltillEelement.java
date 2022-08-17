package com.sl.appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ScrolltillEelement {

	private AndroidDriver<MobileElement> driver;

	@Before
	public void setUp() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("appium:platformVersion", "11");
		desiredCapabilities.setCapability("appium:deviceName", "CT40");
		desiredCapabilities.setCapability("appium:appPackage", "io.appium.android.apis");
		desiredCapabilities.setCapability("appium:appActivity", "io.appium.android.apis.ApiDemos");
		desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
		desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
		desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
		desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

		URL remoteUrl = new URL("http://localhost:4723/wd/hub");

		driver = new AndroidDriver(remoteUrl, desiredCapabilities);
		System.out.println(driver.getSessionId());
	}
	

	public void SwipeUpLong() {
		(new TouchAction(driver))
		.press(PointOption.point(252, 1154))
		.moveTo(PointOption.point(262, 229))
		.release()
		.perform();
	}

	public void SwipeUpSmall() {
		new TouchAction(driver)
		.press(PointOption.point(930,2200))
		.moveTo(PointOption.point(930,1900))  
		.release()
		.perform();
	}

	public void ScrollUPYear() {
		MobileElement MEListYEAR =
		driver.findElement(By.id("android:id/date_picker_year_picker"));
		int x = MEListYEAR.getLocation().getX();
		int y = MEListYEAR.getLocation().getY();
		// PRINT H AND W
		int H = MEListYEAR.getSize().getHeight();
		int W = MEListYEAR.getSize().getWidth();
		int strtX = (int) (x+ (W*0.5));
		int startY = (int) (y + H*0.9);
		int endX = strtX;
		int endY = (int) (y + H*0.1);
		TouchAction action = new TouchAction(driver);
		action
		.longPress(PointOption.point(strtX,startY))
		.moveTo(PointOption.point(endX,endY))
		.release()
		.perform();
		}
	
	public void ScrolldownYear() {
		MobileElement MEListYEAR =
		driver.findElement(By.id("android:id/date_picker_year_picker"));
		int x = MEListYEAR.getLocation().getX();
		int y = MEListYEAR.getLocation().getY();
		// PRINT H AND W
		int H = MEListYEAR.getSize().getHeight();
		int W = MEListYEAR.getSize().getWidth();
		int strtX = (int) (x+ (W*0.5));
		int endY = (int) (y + H*0.9);
		int endX = strtX;
		int startY = (int) (y + H*0.1);
		TouchAction action = new TouchAction(driver);
		action
		.longPress(PointOption.point(strtX,startY))
		.moveTo(PointOption.point(endX,endY))
		.release()
		.perform();
		}
	

	@Test
    public void testScrolldown() throws InterruptedException 
	{
		(new TouchAction(driver))
		.press(PointOption.point(520, 830))
		.moveTo(PointOption.point(520, 649))
		.release()
		.perform();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Views']")).click();
//        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Date Widgets']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Date Widgets']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='1. Dialog']")).click();
//        
//        io.appium.android.apis:id/pickDate
        driver.findElement(By.id("io.appium.android.apis:id/pickDate")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("android:id/date_picker_header_year")).click();
        MobileElement MEYear = driver.findElement(By.id("android:id/date_picker_header_year"));
        String strCrYear = MEYear.getAttribute("text");
        int crYear = Integer.parseInt(strCrYear);
        String strReqYear = "2012";
        int reqYear = Integer.parseInt(strReqYear);
        
        if (reqYear > crYear) 
        {
//            Scroll Up
//            PRINT THE VALES -> TOP LEFT
        	 Boolean flgFound = false;
             
             while (!flgFound) {
                 List<MobileElement> allYYears = driver.findElements(By.xpath("//android.widget.TextView"));
                 for (MobileElement year : allYYears) {
                     System.out.println(year.getAttribute("text"));
                 }
                 
                 List<MobileElement> lstReqYr = driver.findElements(By.xpath("//android.widget.TextView[@text='2012']"));
                 if (lstReqYr.size()>0) {
                     flgFound = true;
                     break;
                 }
                 ScrolldownYear();
                 
             }
             
             driver.findElement(By.xpath("//android.widget.TextView[@text='2030']")).click();
             
             Thread.sleep(5000);
             
              
              
              
             
         }
         
         else{
//             scrollDown
             
         }
         
        	
   
	}
	
	
	
	@Test
    public void testScroll() throws InterruptedException 
	{
		(new TouchAction(driver))
		.press(PointOption.point(520, 830))
		.moveTo(PointOption.point(520, 649))
		.release()
		.perform();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Views']")).click();
//        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Date Widgets']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Date Widgets']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='1. Dialog']")).click();
//        
//        io.appium.android.apis:id/pickDate
        driver.findElement(By.id("io.appium.android.apis:id/pickDate")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("android:id/date_picker_header_year")).click();
        MobileElement MEYear = driver.findElement(By.id("android:id/date_picker_header_year"));
        String strCrYear = MEYear.getAttribute("text");
        int crYear = Integer.parseInt(strCrYear);
        String strReqYear = "2028";
        int reqYear = Integer.parseInt(strReqYear);
        
        if (reqYear > crYear) 
        {
//            Scroll Up
//            PRINT THE VALES -> TOP LEFT
        	 Boolean flgFound = false;
             
             while (!flgFound) {
                 List<MobileElement> allYYears = driver.findElements(By.xpath("//android.widget.TextView"));
                 for (MobileElement year : allYYears) {
                     System.out.println(year.getAttribute("text"));
                 }
                 
                 List<MobileElement> lstReqYr = driver.findElements(By.xpath("//android.widget.TextView[@text='2030']"));
                 if (lstReqYr.size()>0) {
                     flgFound = true;
                     break;
                 }
                 ScrollUPYear();
                 
             }
             
             driver.findElement(By.xpath("//android.widget.TextView[@text='2030']")).click();
             
             Thread.sleep(5000);
             
              
              
              
             
         }
         
         else{
//             scrollDown
             
         }
         
        	
   
	}
	
	public void sampleTest() throws InterruptedException 
	{
		//SwipeUpLong();
		//SwipeUpLong();
		//SwipeUpSmall();
		(new TouchAction(driver))
		.press(PointOption.point(520, 830))
		.moveTo(PointOption.point(520, 649))
		.release()
		.perform();
		MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("Views");
		el1.click();

		MobileElement el3 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Date Widgets\"]");
		el3.click();


		MobileElement dialog= (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"1. Dialog\"]");
		dialog.click();

		MobileElement changedate= (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"change the date\"]");
		changedate.click();
		driver.findElement(By.id("android:id/date_picker_header_year")).click();
		
        }



	public void inputext()
	{
		MobileElement menuOptionText= (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Text\"]");
		menuOptionText.click();

		MobileElement menuOption_LogTextBox =(MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"LogTextBox\"]");
		menuOption_LogTextBox.click();

		MobileElement txtBox_logtxtbox =(MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView");
		txtBox_logtxtbox.sendKeys(" Hello Day 4 Phase 4");

	}


	@After
	public void tearDown()
	{
		driver.quit();
	}
}
