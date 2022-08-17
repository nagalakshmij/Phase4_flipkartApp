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

public class DragandDrop {

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

	@Test
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

		MobileElement el3 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Drag and Drop\"]");
		el3.click();

		MobileElement SRC =driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
				
		MobileElement TRG =driver.findElement(By.id("io.appium.android.apis:id/drag_dot_3"));
		
		Point pntSRC=SRC.getCenter();
		Point pntTRG=TRG.getCenter();
	
		(new TouchAction(driver))
		.longPress(PointOption.point(pntSRC))
		.moveTo(PointOption.point(pntTRG))
		.release()
		.perform();
		
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
