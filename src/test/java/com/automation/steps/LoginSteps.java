package com.automation.steps;

import com.automation.pages.LoginPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();

    @Then("verify user is on login page")
    public void verifyUserIsOnLoginPage() {
        Assert.assertTrue(loginPage.isLoginPageDisplayed());
    }

    @When("user login with username {string} and password {string}")
    public void userLoginWithUsernameAndPassword(String username, String password) {
        if (username.equals("login.username")) {
            loginPage.doLogin(ConfigReader.getConfigValue(username), ConfigReader.getConfigValue(password));
        } else {
            loginPage.doLogin(username, password);
        }
    }

    @Then("verify user cannot login")
    public void verifyUserCannotLogin() {
        Assert.assertTrue(loginPage.isAlertDisplayed());
    }

    @And("click on skip for now and do not allow button")
    public void clickOnSkipForNowAndDoNotAllowButton() {
        loginPage.clickOnSKipForNowAndDoNotAllowBtn();
    }
}
