package com.automation.pages;

import com.automation.utils.ConfigReader;
import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends BasePage {

    @FindBy(xpath = "(//android.widget.TextView[@resource-id='com.ebay.mobile:id/textview_header_0'])[1]")
    WebElement firstProduct;

    @FindBy(id = "com.ebay.mobile:id/text_slot_1")
    WebElement favouritesTab;

    @FindBy(id = "com.ebay.mobile:id/ui_bottom_nav_menu_action_search")
    WebElement searchTab;

    @FindBy(id = "com.ebay.mobile:id/button_filter")
    WebElement filterBtn;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.ebay.mobile:id/title' and @text='Price']")
    WebElement priceFilterBtn;

    @FindBy(id = "com.ebay.mobile:id/minimum_price_view")
    WebElement minPriceInput;

    @FindBy(id = "com.ebay.mobile:id/maximum_price_view")
    WebElement maxPriceInput;

    @FindBy(id = "com.ebay.mobile:id/call_to_action_button")
    WebElement showResultBtn;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.ebay.mobile:id/textview_header_title' and @text='Related Searches']")
    WebElement relatedSearchText;

    @FindBy(xpath = "//android.widget.TextView[contains(@resource-id,'textview_primary_0')]")
    List<WebElement> productPriceList;

    public void clickOnFirstProduct() {
        favouritesTab.click();
        firstProduct.click();
    }

    public void navigateToSearchPage() {
        driver.navigate().back();
        driver.navigate().back();
    }

    public boolean isSearchPageDisplayed() {
        return searchTab.isSelected();
    }

    public void applyPriceFilter(int min, int max) {
        favouritesTab.click();
        filterBtn.click();
        priceFilterBtn.click();

        minPriceInput.sendKeys(String.valueOf(min));
        maxPriceInput.click();
        maxPriceInput.sendKeys(String.valueOf(max));

        ConfigReader.setConfigValue("min.price", String.valueOf(min));
        ConfigReader.setConfigValue("max.price", String.valueOf(max));

        driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "done"));

        showResultBtn.click();
    }

    List<Double> priceList = new ArrayList<>();

    public boolean isAllProductBetweenSelectedPrice() {

        int min = Integer.parseInt(ConfigReader.getConfigValue("min.price"));
        int max = Integer.parseInt(ConfigReader.getConfigValue("max.price"));

        getAllProductPrices(min, max);

        for (Double price : priceList) {
            if (price < min || price > max) {
                return false;
            }
        }
        return true;
    }

    private void getAllProductPrices(int min, int max) {
        while (!isDisplayed(relatedSearchText)) {

            for (WebElement element : productPriceList) {

                String price = element.getText().replace("$", "");
                if (price.contains("to")) {
                    String[] priceArray = price.split(" to ");
                    if (Double.parseDouble(priceArray[0]) < min){
                        price = priceArray[1];
                    }else{
                        price = priceArray[0];
                    }
                }
                priceList.add(Double.parseDouble(price));
            }

            scrollPage();

            productPriceList = driver.findElements(By.xpath("//android.widget.TextView[contains(@resource-id,'textview_primary_0')]"));
        }
    }
}
