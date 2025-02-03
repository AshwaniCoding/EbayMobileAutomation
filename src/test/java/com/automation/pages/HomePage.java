package com.automation.pages;

import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(id = "com.ebay.mobile:id/identity_app_onboarding_screen_close")
    WebElement exclusiveSavingCloseBtn;

    @FindBy(id = "com.ebay.mobile:id/button_sign_in")
    WebElement signInLink;

    @FindBy(id = "com.ebay.mobile:id/ui_bottom_nav_menu_action_my_ebay")
    WebElement myEbayIcon;

    @FindBy(id = "com.ebay.mobile:id/navigation_bar_item_large_label_view")
    WebElement homeIcon;

    @FindBy(id = "com.ebay.mobile:id/search_box")
    WebElement searchBox;

    @FindBy(id = "com.ebay.mobile:id/search_src_text")
    WebElement searchInput;

    @FindBy(id = "com.ebay.mobile:id/menu_action_view_icon")
    WebElement cartIcon;


    public void openApplication() {
        if (exclusiveSavingCloseBtn.isDisplayed()) {
            exclusiveSavingCloseBtn.click();
        }
    }

    public void clickOnSignLink() {
        signInLink.click();
    }

    public boolean isHomePageDisplayed() {
        return isDisplayed(myEbayIcon);
    }

    public void clickOnMyEbayIcon() {
        myEbayIcon.click();
    }

    public void clickOnHomeIcon() {
        homeIcon.click();
    }

    public void searchForProduct(String product) {
        searchBox.click();
        searchInput.sendKeys(product);
        driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "search"));
    }

    public void clickOnCartIcon() {
        cartIcon.click();
    }
}
