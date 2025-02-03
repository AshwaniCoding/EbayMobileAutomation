package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "com.ebay.mobile:id/edit_text_username")
    WebElement usernameInput;

    @FindBy(id = "com.ebay.mobile:id/password_input_text")
    WebElement passwordInput;

    @FindBy(id = "com.ebay.mobile:id/button_sign_in")
    WebElement signInBtn;

    @FindBy(id = "com.ebay.mobile:id/tv_sign_in_alert")
    WebElement loginAlert;

    @FindBy(id = "com.ebay.mobile:id/bt_maybe_later")
    WebElement skipForNowBtn;

    @FindBy(xpath = "//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_deny_button']")
    WebElement doNotAllowBtn;

    public boolean isLoginPageDisplayed() {
        return usernameInput.isDisplayed() && passwordInput.isDisplayed();
    }

    public void doLogin(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        signInBtn.click();
    }

    public boolean isAlertDisplayed() {
        return isDisplayed(loginAlert);
    }

    public void clickOnSKipForNowAndDoNotAllowBtn() {

        skipForNowBtn.click();

        if (isDisplayed(doNotAllowBtn)) {
            doNotAllowBtn.click();
        }
    }
}
