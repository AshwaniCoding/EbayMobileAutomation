package com.automation.steps;

import com.automation.pages.SettingPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SettingSteps {

    SettingPage settingPage = new SettingPage();

    @Then("verify user is on setting page")
    public void verifyUserIsOnSettingPage() {
        Assert.assertTrue(settingPage.isSettingsPageDisplayed());
    }

    @When("user click on sign out button")
    public void userClickOnSignOutButton() {
        settingPage.clickOnSignOutBtn();
    }
}
