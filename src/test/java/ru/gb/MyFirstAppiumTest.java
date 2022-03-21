package ru.gb;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.print.DocFlavor;
import java.net.MalformedURLException;
import java.net.URL;

public class MyFirstAppiumTest {

@Test
    public void checkEmail () throws Exception {
    DesiredCapabilities capabilities = new DesiredCapabilities();

    capabilities.setCapability("platformName", "Android");
    capabilities.setCapability("deviceName", "Pixel 3");
    capabilities.setCapability("platformVersion", "9");
    capabilities.setCapability("udid", "emulator-5554");
    capabilities.setCapability("automationName", "UiAutomator2");
    capabilities.setCapability("app", "/Users/rustamsafikov/Downloads/Android-NativeDemoApp-0.2.1.apk");
    MobileDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("Login");
    el1.click();
    Thread.sleep(2000);

    MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("input-email");
    el2.click();
    el2.sendKeys("Rustam");

    MobileElement el3 = (MobileElement) driver.findElementByAccessibilityId("input-password");
    el3.click();
    el3.sendKeys("220437");

    MobileElement el4 = (MobileElement) driver.findElementByAccessibilityId("button-LOGIN");
    el4.click();

    Thread.sleep(2000);
    MobileElement errorText = (MobileElement) driver.findElementByXPath("//android.widget.ScrollView[@content-desc=\"Login-screen\"]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.TextView[1]");
    Assert.assertEquals(errorText.getText(), "Please enter a valid email address");



}




}
