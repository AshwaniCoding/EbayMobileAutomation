package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {

    @FindBy(xpath = "//android.widget.TextView[contains(@text,'Qty')]/../(android.widget.TextView)[2]")
    List<WebElement> productTitles;

    @FindBy(xpath = "//android.widget.TextView[contains(@text,'Your cart')]")
    WebElement cartText;

    @FindBy(xpath = "//android.widget.TextView[@text='Go to checkout']")
    WebElement goToCheckoutBtn;

    public boolean isCartPageDisplayed() {
        return isDisplayed(cartText);
    }

    List<String> titles = new ArrayList<>();

    public boolean isProductAvailableOnCart() {
        getTitlesOfProductOnCart();
        for (String title : titles){
            if(title.equals(ConfigReader.getConfigValue("product.title"))){
                return true;
            }
        }
        return false;
    }

    private void getTitlesOfProductOnCart() {
        List<String> titles = new ArrayList<>();
        while (!isDisplayed(goToCheckoutBtn)) {
            for (WebElement element : productTitles) {
                titles.add(element.getText());
            }
            scrollPage();
        }

        this.titles = titles;
    }
}
