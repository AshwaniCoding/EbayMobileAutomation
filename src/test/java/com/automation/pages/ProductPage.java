package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//android.widget.TextView[@text='Item']")
    WebElement itemText;

    @FindBy(xpath = "//android.view.ViewGroup[@resource-id='com.ebay.mobile:id/vi_shared_inline_image_layout']/following-sibling::androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.TextView")
    WebElement itemTitle;

    @FindBy(id = "com.ebay.mobile:id/cta_button_plus")
    WebElement addToCartBtn;

    @FindBy(id = "com.ebay.mobile:id/call_to_action_button")
    WebElement goToCartBtn;

    @FindBy(xpath = "//android.widget.TextView[contains(@resource-id,'textview_header_title') and @text='About this item']")
    WebElement aboutThisItemHeading;

    @FindBy(xpath = "//android.widget.LinearLayout[contains(@resource-id,'stat_layout')]/android.widget.TextView[contains(@resource-id,'stat_key')]")
    List<WebElement> productInformationKeys;

    @FindBy(xpath = "//android.widget.LinearLayout[contains(@resource-id,'stat_layout')]//android.widget.TextView[contains(@resource-id,'stat_value') or contains(@resource-id,'stat_timer')]")
    List<WebElement> productInformationValues;

    @FindBy(xpath = "(//android.widget.TextView[@text='Sponsored'])[1]")
    WebElement sponsoredText;

    @FindBy(xpath = "(//androidx.recyclerview.widget.RecyclerView[contains(@resource-id,'recyclerview_items')])[1]")
    WebElement sponsoredTab;

    @FindBy(xpath = "//android.widget.TextView[contains(@resource-id,'merch_ic_title')]")
    List<WebElement> sponsoredProductTitles;

    @FindBy(xpath="//android.widget.TextView[@resource-id='com.ebay.mobile:id/textview_header_title' and @text='About this seller']")
    WebElement aboutThisSellerHeading;

    @FindBy(xpath="(//android.view.ViewGroup[@resource-id='com.ebay.mobile:id/profile_layout']//android.widget.TextView[contains(@resource-id,'stat_key')])[1]")
    WebElement sellerNameText;

    public boolean isProductPageDisplayed() {
        ConfigReader.setConfigValue("product.title", itemTitle.getText());
        return isDisplayed(itemText);
    }


    public void clickOnAddToCartBtn() {
        while (!isDisplayed(addToCartBtn)) {
            scrollPage();
        }
        addToCartBtn.click();
        goToCartBtn.click();
    }

    public boolean isAllNecessaryInformationDisplayed() {
        getProductDetails();
        return !productInformation.isEmpty();
    }

    Map<String, String> productInformation = new HashMap<>();

    private void getProductDetails() {
        Map<String, String> productInformation = new HashMap<>();
        while (!isDisplayed(aboutThisItemHeading)) {
            scrollPage();
            for (int i = 0; i < productInformationKeys.size(); i++) {
                productInformation.put(productInformationKeys.get(i).getAttribute("content-desc"), productInformationValues.get(i).getAttribute("content-desc"));
            }
        }

        this.productInformation = productInformation;
    }

    public void scrollTillSponsoredProducts() {
        while (!isDisplayed(sponsoredText)) {
            scrollPage();
        }
    }

    public boolean isSponsoredProductsDisplayed() {
        return isDisplayed(sponsoredTab) && isDisplayed(sponsoredProductTitles.getFirst());
    }

    List<String> currentSponsoredTitles = new ArrayList<>();

    String current = "";
    String previous = "";

    public void swipeRightTillLastSponsoredProduct() {

        for (WebElement element : sponsoredProductTitles) {
            currentSponsoredTitles.add(element.getText());
        }

        current = currentSponsoredTitles.getLast();

        while (!current.equals(previous)) {

            swipeElement(sponsoredTab);

            previous = current;
            sponsoredProductTitles = driver.findElements(By.xpath("//android.widget.TextView[contains(@resource-id,'merch_ic_title')]"));

            for (WebElement element : sponsoredProductTitles) {
                currentSponsoredTitles.add(element.getText());
            }

            current = currentSponsoredTitles.getLast();

        }


    }

    public boolean isUserReachedLastProduct() {
        return current.equals(previous);
    }

    public boolean isSellerInformationAvailable() {
        while (!isDisplayed(aboutThisSellerHeading)){
            scrollPage();
        }
        return isDisplayed(sellerNameText) && isDisplayed(aboutThisSellerHeading);
    }
}
