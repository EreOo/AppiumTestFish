package ru.wiley.appium;


import io.appium.java_client.android.AndroidDriver;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * Created by vshekhavtsov on 10/27/2016.
 */
public class FirstSteps {

    private static AndroidDriver driver;

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
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        Thread.sleep(10000);

        driver.findElement(By.id("com.google.android.gms:id/account_display_name")).click();

        driver.findElement(By.id("com.wiley.jas.acie:id/get_access_browse_free_content")).click();

    }

    @After
    public void tearDown(){
        if(driver != null){
           driver.quit();
        }
    }



    @Test
    public void testButtonSearch(){
        Assert.assertEquals(driver.findElement(By.id("com.wiley.jas.acie:id/global_search_tab")).getText(), "Search");
    }

    @Test
    public void testButton(){
        Assert.assertEquals(driver.findElement(By.id("com.wiley.jas.acie:id/early_view_tab")).getText(), "Early View");
    }



}
