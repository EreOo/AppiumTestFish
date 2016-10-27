package ru.wiley.appium;

import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.wiley.appium.test.pages.LoginPage;
import ru.wiley.appium.test.pages.EarlyView;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by vshekhavtsov on 10/27/2016.
 */
public class PageObjectTry {

    private static AndroidDriver driver;
    private static LoginPage loginPage;
    private static EarlyView earlyView;

    @Before
    public void setUp() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capa = new DesiredCapabilities();
        capa.setCapability(CapabilityType.BROWSER_NAME, "");
        capa.setCapability("deviceName", "TestAndroid");
        capa.setCapability("platformVersion", "4.4.2");
        capa.setCapability("platformName", "Android");
        capa.setCapability("appPackage", "com.wiley.jas.acie");
        capa.setCapability("appActivity", "com.wiley.android.journalApp.activity.SplashScreenActivity");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capa);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        earlyView = new EarlyView(driver);
        //VERY IMP!!!!
        Thread.sleep(10000);
        loginPage.clickAccountButton();
        loginPage.clickFreeTrial();

    }

    @After
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }

    @Test
    public void isDisplaied(){
       Assert.assertTrue(earlyView.isDisplaiedButtonEarlyView());
    }
    @Test
    public void isCountViewsMoreOne(){
        Assert.assertTrue(earlyView.getCountViewsContent() > 1);
    }


}
