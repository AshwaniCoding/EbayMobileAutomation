package com.automation.steps;

import com.automation.pages.HomePage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HomeSteps {

    HomePage homePage = new HomePage();

    @Given("user open application")
    public void userOpenApplication() {
        homePage.openApplication();
    }

    @When("user click on sign in link")
    public void userClickOnSignInLink() {
        homePage.clickOnSignLink();
    }

    @Then("verify user is on homepage")
    public void verifyUserIsOnHomepage() {
        Assert.assertTrue(homePage.isHomePageDisplayed());
    }

    @When("user click on My eBay icon")
    public void userClickOnMyEBayIcon() {
        homePage.clickOnMyEbayIcon();
    }

    @When("user click on home icon")
    public void userClickOnHomeIcon() {
        homePage.clickOnHomeIcon();
    }

    @When("user search for product {string}")
    public void userSearchForProduct(String product) {
        homePage.searchForProduct(ConfigReader.getConfigValue("product.name"));
    }

    @When("user click on cart icon")
    public void userClickOnCartIcon() {
        homePage.clickOnCartIcon();
    }
}
