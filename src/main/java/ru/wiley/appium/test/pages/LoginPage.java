package ru.wiley.appium.test.pages;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by vshekhavtsov on 10/27/2016.
 */
public class LoginPage  {


    @AndroidFindBy(id = "com.google.android.gms:id/account_display_name")
    WebElement accountButton;
    @AndroidFindBy(id ="com.wiley.jas.acie:id/get_access_browse_free_content")
    WebElement freeTrialButton;


    protected final AppiumDriver driver;

    public LoginPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickAccountButton(){
        accountButton.click();
    }

    public void clickFreeTrial(){
        freeTrialButton.click();
    }


}
