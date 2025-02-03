package com.automation.steps;

import com.automation.pages.SearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SearchSteps {
    SearchPage searchPage =  new SearchPage();
    @And("click on the first product")
    public void clickOnTheFirstProduct() {
        searchPage.clickOnFirstProduct();
    }

    @When("user navigate back to search page")
    public void userNavigateBackToSearchPage() {
        searchPage.navigateToSearchPage();
    }

    @Then("verify user is on search product page")
    public void verifyUserIsOnSearchProductPage() {
        Assert.assertTrue(searchPage.isSearchPageDisplayed());
    }

    @When("user click on filter link and select minimum price {int} and maximum price {int}")
    public void userClickOnFilterLinkAndSelectMinimumPriceAndMaximumPrice(int min, int max) {
        searchPage.applyPriceFilter(min,max);
    }

    @Then("verify user getting all the product between selected price")
    public void verifyUserGettingAllTheProductBetweenSelectedPrice() {
        Assert.assertTrue(searchPage.isAllProductBetweenSelectedPrice());
    }
}
