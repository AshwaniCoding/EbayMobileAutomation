package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyEbayPage extends BasePage {

    @FindBy(xpath = "(//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]//android.widget.TextView)[2]")
    WebElement usernameMyEbayPage;

    @FindBy(xpath="//android.widget.TextView[@text='Settings']")
    WebElement settingBtn;

    public boolean isUsernameValueDisplayed() {
        return isDisplayed(usernameMyEbayPage);
    }

    public void clickOnSettings() {
        while(!isDisplayed(settingBtn)){
            scrollPage();
        }
        settingBtn.click();
    }


    public boolean isMyEbayPageDisplayed() {
        return isDisplayed(usernameMyEbayPage);
    }
}
