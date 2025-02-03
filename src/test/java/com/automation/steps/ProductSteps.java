package com.automation.steps;

import com.automation.pages.ProductPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductSteps {
    ProductPage productPage = new ProductPage();
    @Then("verify user is on product page")
    public void verifyUserIsOnProductPage() {
        Assert.assertTrue(productPage.isProductPageDisplayed());
    }

    @When("user click on add to cart button and click on go to cart button")
    public void userClickOnAddToCartButtonAndClickOnGoToCartButton() {
        productPage.clickOnAddToCartBtn();
    }

    @And("verify all necessary information is displayed")
    public void verifyAllNecessaryInformationIsDisplayed() {
        Assert.assertTrue(productPage.isAllNecessaryInformationDisplayed());
    }

    @When("user scroll till sponsored products")
    public void userScrollTillSponsoredProducts() {
        productPage.scrollTillSponsoredProducts();
    }

    @Then("verify sponsored products are displayed")
    public void verifySponsoredProductsAreDisplayed() {
        Assert.assertTrue(productPage.isSponsoredProductsDisplayed());
    }

    @When("user swipe right till last sponsored product")
    public void userSwipeRightTillLastSponsoredProduct() {
        productPage.swipeRightTillLastSponsoredProduct();
    }

    @Then("verify user reached in last product")
    public void verifyUserReachedInLastProduct() {
        Assert.assertTrue(productPage.isUserReachedLastProduct());
    }

    @And("verify seller information is displayed")
    public void verifySellerInformationIsDisplayed() {
        Assert.assertTrue(productPage.isSellerInformationAvailable());
    }
}
