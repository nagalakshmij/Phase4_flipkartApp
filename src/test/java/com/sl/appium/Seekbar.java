package com.sl.appium;



import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Seekbar {


  private AndroidDriver driver;
  TouchAction touchAction;

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
    touchAction = new TouchAction(driver);
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
    
    (new TouchAction(driver))
    .press(PointOption.point(252, 1154))
    .moveTo(PointOption.point(262, 229))
    .release()
    .perform();
    
    (new TouchAction(driver))
    .press(PointOption.point(252, 1154))
    .moveTo(PointOption.point(262, 229))
    .release()
    .perform();
    
    (new TouchAction(driver))
    .press(PointOption.point(252, 1154))
    .moveTo(PointOption.point(262, 229))
    .release()
    .perform();
    MobileElement el3 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Seek Bar\"]");
    el3.click();
    
    MobileElement seekBar= (MobileElement) driver.findElementById("io.appium.android.apis:id/seek");
    int startXPos = seekBar.getLocation().getX();
    int yPos = seekBar.getLocation().getY();
    int lastXPos = startXPos + seekBar.getSize().getWidth();
    int centerXPos = seekBar.getCenter().getX();
    System.out.println("startXPos= "+startXPos);
    System.out.println("yPos= "+yPos);
    System.out.println("lastXPos= "+lastXPos);
    System.out.println("centerXPos= "+centerXPos);


    //move to start posistion =0
    touchAction.press(ElementOption.element(seekBar))
    .moveTo(PointOption.point(startXPos,yPos))
    .release()
    .perform();

    Thread.sleep(1000);

    //move to last position
    touchAction.press(ElementOption.element(seekBar))
    .moveTo(PointOption.point(lastXPos,yPos))
    .release()
    .perform();

    // wnat to move to to 30th postion
    int delta= 30;
    int point30 = 30* (startXPos+ seekBar.getSize().getWidth() / 100)+delta;

    touchAction.press(ElementOption.element(seekBar))
    .moveTo(PointOption.point(point30,yPos))
    .release()
    .perform();



    int point70 = 70* (startXPos+ seekBar.getSize().getWidth() / 100)+delta;

    touchAction.press(ElementOption.element(seekBar))
    .moveTo(PointOption.point(point70,yPos))
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
