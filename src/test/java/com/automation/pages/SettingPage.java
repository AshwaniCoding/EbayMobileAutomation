package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SettingPage extends BasePage {

    @FindBy(xpath="//android.widget.TextView[@text='Settings']")
    WebElement settingsHeading;

    @FindBy(xpath="//android.widget.TextView[@resource-id='android:id/title' and @text='Sign out']")
    WebElement signOutBtn;

    public boolean isSettingsPageDisplayed() {
        return isDisplayed(settingsHeading);
    }

    public void clickOnSignOutBtn() {
        signOutBtn.click();
    }
}
