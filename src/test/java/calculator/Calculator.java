package calculator;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
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
        desiredCapabilities.setCapability("platformVersion", "10.0");
        desiredCapabilities.setCapability("automationName", "UIAutomator2");
        desiredCapabilities.setCapability("appPackage", "com.google.android.calculator");
        desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        desiredCapabilities.setCapability("deviceName", "emulator-5558");
        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);
    }

    @Test
    public void shouldSumTwoNumbers() {
        MobileElement number2 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_2");
        number2.click();
        MobileElement btnPlus = (MobileElement) driver.findElementByAccessibilityId("plus");
        btnPlus.click();
        MobileElement number3 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_3");
        number3.click();
        MobileElement btnEquals = (MobileElement) driver.findElementByAccessibilityId("equals");
        btnEquals.click();
        MobileElement result = (MobileElement) driver.findElementById("com.google.android.calculator:id/result_final");
        result.click();
        Assert.assertEquals("5", result.getText());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
