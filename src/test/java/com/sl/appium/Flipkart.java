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
import org.openqa.selenium.remote.DesiredCapabilities;

public class Flipkart {

	private AndroidDriver driver;

	@Before
	public void setUp() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("appium:platformVersion", "11");
		desiredCapabilities.setCapability("appium:deviceName", "CT40");
		desiredCapabilities.setCapability("appium:appPackage", "com.flipkart.android");
		desiredCapabilities.setCapability("appium:appActivity", "com.flipkart.android.activity.HomeFragmentHolderActivity");
		desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
		desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
		desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
		desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

		URL remoteUrl = new URL("http://localhost:4723/wd/hub");

		driver = new AndroidDriver(remoteUrl, desiredCapabilities);
	}

	public void SwipeUpLong() {
		new TouchAction(driver)
		.press(PointOption.point(362,2200))
		.moveTo(PointOption.point(362,432))  
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
	public void sampleTest() throws Exception 
	{
		Thread.sleep(5000);
		driver.findElementById("com.flipkart.android:id/button").click();
		driver.findElementById("com.flipkart.android:id/custom_back_icon").click();
		driver.findElementById("com.flipkart.android:id/search_widget_textbox").click();
		MobileElement searchtext = (MobileElement) driver.findElementByAccessibilityId("Search grocery products");
		searchtext.sendKeys("samsung phones");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
