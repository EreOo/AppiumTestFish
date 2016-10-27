package ru.wiley.appium.test.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by vshekhavtsov on 10/27/2016.
 */
//EarlyView
public class EarlyView {
    @AndroidFindBy(id ="com.wiley.jas.acie:id/early_view_tab")
    private WebElement buttonEarlyView ;
    @AndroidFindBy(id ="com.wiley.jas.acie:id/issues_tab")
    private WebElement buttonIssues ;
    @AndroidFindBy(id ="com.wiley.jas.acie:id/saved_articles_tab")
    private WebElement buttonSavedArticles ;
    @AndroidFindBy(id ="com.wiley.jas.acie:id/global_search_tab")
    private WebElement buttonSearch ;
    @AndroidFindBy(id ="com.wiley.jas.acie:id/settings_tab")
    private WebElement buttonSettings ;
    @AndroidFindBy(id ="com.wiley.jas.acie:id/info_tab")
    private WebElement buttonInfo ;
    @AndroidFindBy(id ="com.wiley.jas.acie:id/articleRefContent")
    private WebElement content;
    @AndroidFindBy(id ="com.wiley.jas.acie:id/society_button")
    private WebElement buttonChemistryViews ;
    @AndroidFindBy(id ="com.wiley.jas.acie:id/journal_button")
    private WebElement buttonJournal ;
    @AndroidFindBy(id ="com.wiley.jas.acie:id/menu_button")
    private WebElement buttonRightMenu;

    protected final AppiumDriver driver;

    public EarlyView(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickButtonEarlyView(){
        buttonEarlyView.click();
    }
    public void clickButtonIssues(){
        buttonIssues.click();
    }
    public void clickButtonSavedArticles(){
        buttonSavedArticles.click();
    }
    public void clickButtonSearch(){
        buttonSearch.click();
    }
    public void clickButtonSettings(){
        buttonSettings.click();
    }
    public void clickButtonInfo(){
        buttonInfo.click();
    }
    public void clickButtonChemistryViews(){
        buttonChemistryViews.click();
    }
    public void clickButtonJournal(){
        buttonJournal.click();
    }
    public void clickButtonRightMenu(){
       buttonRightMenu.click();
    }

    public boolean isDisplaiedButtonEarlyView(){
       return buttonEarlyView.isDisplayed();
    }
    public Integer getCountViewsContent(){
        clickButtonEarlyView();
        return driver.findElements(By.className("android.view.View")).size();
    }
}
