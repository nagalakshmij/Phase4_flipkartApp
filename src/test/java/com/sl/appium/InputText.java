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

public class InputText {

  private AndroidDriver driver;

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
  }

  @Test
  public void sampleTest() 
  {
    (new TouchAction(driver))
      .press(PointOption.point(216, 594))
      .moveTo(PointOption.point(227, 727))
      .release()
      .perform();
    (new TouchAction(driver))
      .press(PointOption.point(280, 507))
      .moveTo(PointOption.point(184, 1160))
      .release()
      .perform();
    (new TouchAction(driver))
      .press(PointOption.point(193, 830))
      .moveTo(PointOption.point(362, 649))
      .release()
      .perform();
    MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("Text");
    el1.click();
    (new TouchAction(driver))
      .press(PointOption.point(128, 1133))
      .moveTo(PointOption.point(163, 401))
      .release()
      .perform();
    MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("LogTextBox");
    el2.click();
    MobileElement el3 = (MobileElement) driver.findElementById("io.appium.android.apis:id/text");
    el3.sendKeys("hello");
  }

  
  @Test()
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
