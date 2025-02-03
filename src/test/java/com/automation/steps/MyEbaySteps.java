package com.automation.steps;

import com.automation.pages.MyEbayPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class MyEbaySteps {

    MyEbayPage myEbayPage = new MyEbayPage();

    @Then("verify username is displayed on the top")
    public void verifyUsernameIsDisplayedOnTheTop() {
        Assert.assertTrue(myEbayPage.isUsernameValueDisplayed());
    }

    @When("user click on settings")
    public void userClickOnSettings() {
        myEbayPage.clickOnSettings();
    }

    @Then("verify user is on MyEbay page")
    public void verifyUserIsOnMyEbayPage() {
        Assert.assertTrue(myEbayPage.isMyEbayPageDisplayed());
    }
}
