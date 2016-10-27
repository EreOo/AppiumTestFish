package ru.wiley.appium.test;

import io.appium.java_client.NetworkConnectionSetting;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
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
public class TestActionClass {
//C:\Users\vshekhavtsov\Android\sdk    for appium SDK
    private static AndroidDriver driver;
    private static LoginPage loginPage;
    private static EarlyView earlyView;

    public static void main(String[] args) throws MalformedURLException, InterruptedException{


        DesiredCapabilities capa = new DesiredCapabilities();
        capa.setCapability(CapabilityType.BROWSER_NAME, "");
        capa.setCapability("deviceName", "TestAndroid");
        capa.setCapability("platformVersion", "4.4.2");
        capa.setCapability("platformName", "Android");
        capa.setCapability("appPackage", "com.wiley.jas.acie");
        capa.setCapability("appActivity", "com.wiley.android.journalApp.activity.SplashScreenActivity");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capa);
        loginPage = new LoginPage(driver);
        earlyView = new EarlyView(driver);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);

        //driver.findElement(By.id("com.google.android.gms:id/account_display_name")).click();
        Thread.sleep(10000);


        loginPage.clickAccountButton();
        loginPage.clickFreeTrial();

     // driver.findElement(By.id("com.wiley.jas.acie:id/get_access_browse_free_content")).click();
      driver.findElement(By.id("com.wiley.jas.acie:id/early_view_tab")).click();

        System.out.println(driver.findElement(By.id("com.wiley.jas.acie:id/global_search_tab")).getText());

        NetworkConnectionSetting networkConnection = new NetworkConnectionSetting(false, true, false);
        networkConnection.setData(false);
        networkConnection.setWifi(false);
        driver.setNetworkConnection(networkConnection); // wifi off
        driver.rotate(ScreenOrientation.PORTRAIT);//FI4IIIIIIIIIIIIIIIIIIII
        driver.rotate(ScreenOrientation.LANDSCAPE);


        Thread.sleep(10000);
//        driver.findElement(By.id("com.wiley.jas.acie:id/saved_articles_tab")).click();
//        driver.findElement(By.id("com.wiley.jas.acie:id/menu_button")).click();

        //driver.findElement(By.T("Search")).click(); @!!@!@!^#%!@ RAZBOR NE RABOTAEET
        //driver.close();
        //com.wiley.jas.acie:id/early_view_tab
    }


}
