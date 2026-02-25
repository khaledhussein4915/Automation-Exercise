package Pages_Automation_Excersize;

import Utils.Framework;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class Product_Page {
    WebDriver browser;
    private Framework fr;

    //------------------------------------------------------------------//
    // Locators
    private final By searchProduct_Locator = By.cssSelector("[id=\"search_product\"]");
    private final By confirmSearchButton_locator = By.cssSelector("[id=\"submit_search\"]");
    private final By imageForProduct = By.cssSelector("[alt=\"Website for practice\"]");
    private final By allProductText_Locator = By.cssSelector("h2[class=\"title text-center\"]");
    private final By viewFirstProductDetails_Locator = By.cssSelector("ul[class=\"nav nav-pills nav-justified\"] > li > a[href=\"/product_details/1\"]");
    //product name, category, price, availability, condition, brand
    private final By productName_Locator = By.cssSelector("div.product-information > h2");
    private final By productCategory_Locator =By.cssSelector("div.product-information > p:nth-of-type(1)");
    private final By productPrice_Locator = By.cssSelector("div.product-information > span");
    private final By productAvailability_Locator = By.cssSelector("div.product-information > p:nth-of-type(2)");
    private final By productCondition_Locator = By.cssSelector("div.product-information > p:nth-of-type(3)");
    private final By productBrand_Locator =By.cssSelector("div.product-information > p:nth-of-type(4)");
    private final By searchedProduct = By.cssSelector("h2[class=\"title text-center\"]");
    private final By firstProductCart_Locator = By.cssSelector("div[class=\"productinfo text-center\"] > [data-product-id=\"1\"]");
    private final By secondProductCart_Locator = By.cssSelector("div[class=\"productinfo text-center\"] > [data-product-id=\"2\"]");
    private final By continueButtonAfterAdd_Locator = By.cssSelector("[class=\"btn btn-success close-modal btn-block\"]");
    private final By viewProduct_Locator =By.cssSelector(" [href=\"/product_details/1\"] > [class=\"fa fa-plus-square\"]");
    private final By increaseQuantity_Locator = By.id("quantity");
    private final By addQuantityToCart_Locator = By.cssSelector("[class=\"btn btn-default cart\"]");
    //------------------------------------------------------------------//
    // Constructors
    public Product_Page(WebDriver browser) {
        this.browser = browser;
        this.fr = new Framework(browser);
    }

    //------------------------------------------------------------------//
    // Functions
    public void clickOnSearchBar(String text) {
        fr.sendKeys(searchProduct_Locator, text);
    }

    public void confirmSearchButton() {
        fr.clickonElement(confirmSearchButton_locator);
    }

    public void searchForProduct(String productName) {
        clickOnSearchBar(productName);
        confirmSearchButton();
    }

    public boolean isAllProductsAvailable() {
        fr.textIsDisplayed(imageForProduct);
        return true;
    }
    public boolean isAllProductTextAvailable(){
        fr.textIsDisplayed(allProductText_Locator);
        return true;
    }

    public boolean isSearchedProductAvailable() {
        fr.textIsDisplayed(searchProduct_Locator);
        return true;
    }

    public String getPageURL() {
        return fr.getpageURL();
    }


    public void clickOnFirstProductDetails() {
        // 1. حول الـ Locator لـ WebElement
        WebElement element = browser.findElement(viewFirstProductDetails_Locator);

        // 2. استخدم الـ JavaScript Click على الـ WebElement
        JavascriptExecutor js = (JavascriptExecutor) browser;
        js.executeScript("arguments[0].click();", element);

        // 3. تخطي الإعلان (Vignette) لو ظهر بعد الكليك
        try {
            if (browser.getCurrentUrl().contains("#google_vignette")) {
                browser.get(browser.getCurrentUrl().split("#")[0]);
            }
        } catch (Exception e) {
            // أحياناً المتصفح بياخد وقت عقبال ما الـ URL يتحدث
        }
    }
    //product name, category, price, availability, condition, brand
    public String getProductName()
    {
       return fr.getText (productName_Locator);

    }
    public String getProductCategory()
    {
        return fr.getText (productCategory_Locator);

    }
    public String getProductPrice()
    {
        return fr.getText (productPrice_Locator);

    }
    public String getProductAvailability()
    {
        return fr.getText (productAvailability_Locator);

    }
    public String getProductCondition()
    {
        return fr.getText (productCondition_Locator);

    }
    public String getProductPrand()
    {
        return fr.getText (productBrand_Locator);

    }
    //product name, category, price, availability, condition, brand

    public List<String> getAllProductDetails() {
        return Arrays.asList(
                getProductName(),
                getProductCategory(),
                getProductPrice(),
                getProductAvailability(),
                getProductCondition(),
                getProductPrand()
        );

    }

    public void hoverOnFirstProductDetails() {
        fr.hoverelement(viewFirstProductDetails_Locator);
    }
    public void clickAddToCartOnFirstProduct() {
        fr.scrollToElement(firstProductCart_Locator);
        fr.removeAds();
        fr.clickonElement(firstProductCart_Locator);

    }

    public void clickOnContinueButton() {
        fr.clickonElement(continueButtonAfterAdd_Locator);
    }
    public void addFirstProductToCart() {
        hoverOnFirstProductDetails();
        clickAddToCartOnFirstProduct();
        clickOnContinueButton();
    }
    public void addSecondProductToCart() {
        fr.scrollToElement(secondProductCart_Locator);
        fr.removeAds();
        fr.clickonElement(secondProductCart_Locator);

        clickOnContinueButton();
    }
    public void clickViewProductButton() {
        fr.removeAds();
        fr.clickonElement(viewProduct_Locator);
    }

    public void increaseProductQuantity(int quantity) {
        fr.clearTextArea(increaseQuantity_Locator);
        fr.sendKeys(increaseQuantity_Locator, String.valueOf(quantity));
    }
    public void clickAddQuantityCart ()
        {
        fr.clickonElement(addQuantityToCart_Locator);
        }




}
