package com.automation.steps;

import com.automation.pages.CartPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class CartSteps {

    CartPage cartPage = new CartPage();

    @Then("verify product is added on cart page")
    public void verifyProductIsAddedOnCartPage() {
        Assert.assertTrue(cartPage.isProductAvailableOnCart());
    }

    @Then("verify user is on cart page")
    public void verifyUserIsOnCartPage() {
        Assert.assertTrue(cartPage.isCartPageDisplayed());
    }

    @Then("verify product is available on cart page")
    public void verifyProductIsAvailableOnCartPage() {
        Assert.assertTrue(cartPage.isProductAvailableOnCart());
    }
}
