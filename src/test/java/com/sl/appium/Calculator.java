package com.sl.appium;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Calculator {

	private AndroidDriver driver;

	@Before
	public void setUp() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("appium:platformVersion", "11");
		desiredCapabilities.setCapability("appium:deviceName", "CT40");
		desiredCapabilities.setCapability("appium:appPackage", "com.google.android.calculator");
		desiredCapabilities.setCapability("appium:appActivity", "com.android.calculator2.Calculator");
		desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
		desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
		desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
		desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

		URL remoteUrl = new URL("http://localhost:4723/wd/hub");

		driver = new AndroidDriver(remoteUrl, desiredCapabilities);
	}

	@Test
	public void sampleTest() {
		MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("8");
		el1.click();
		MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("9");
		el2.click();
	}
	
	@Test
	public void textview()
	{
		MobileElement menuOptionText= (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Text\"]");
        menuOptionText.click();
        
        MobileElement menuOption_LogTextBox =(MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"LogTextBox\"]");
        menuOption_LogTextBox.click();
        
        MobileElement txtBox_logtxtbox =(MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView");
        txtBox_logtxtbox.sendKeys(" Hello Day 4 Phase 4");
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}

