package Pages_Automation_Excersize;

import Utils.Framework;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Cart_Page {

    WebDriver browser;
    Framework fr ;

    //Locators//
    private final By subscriptionByEmail_Locator = By.id("susbscribe_email");
    private final By subscriptionButton_Locator = By.id("subscribe");
    private final By SubscriptionSuccessMessage_Locator = By.id("success-subscribe");
    private final By priceProduct1_Locator = By.cssSelector("tr#product-1 [class=\"cart_price\"]");
    private final By priceProduct2_Locator = By.cssSelector("tr#product-2 [class=\"cart_price\"]");
    private final By quantityProduct1_Locator = By.cssSelector("[id=\"product-1\"] > [class=\"cart_quantity\"]");
    private final By quantityProduct2_Locator = By.cssSelector("[id=\"product-2\"] > [class=\"cart_quantity\"]");
    private final By totalProduct1_Locator = By.cssSelector("[id=\"product-1\"]>td p[class=\"cart_total_price\"]");
    private final By totalProduct2_Locator = By.cssSelector("[id=\"product-2\"]>td p[class=\"cart_total_price\"]");
    private final By proceedToCheckout_Locator = By.cssSelector("[class=\"btn btn-default check_out\"]");
    private final By registerLoginButton_Locator = By.linkText("Register / Login");
    private final By textArea_Locator = By.cssSelector("[class=\"form-control\"]");
    private final By placeOrderButton_Locator = By.cssSelector("a[href='/payment']");



    //Constructors//
        public Cart_Page(WebDriver browser) {
            fr = new Framework(browser);
            this.browser = browser;
        }

    // Functions//

    public void addSubscribeEmail (String email) {
            fr.sendKeys(subscriptionByEmail_Locator, email);
    }
    public void clickSubscriptionButton() {
        fr.clickonElement(subscriptionButton_Locator);
    }

    public void subscribeByEmail (String email) {
            addSubscribeEmail(email);
            clickSubscriptionButton();
    }

    public String getsubscriptionSuccessMessage ()
    {
        return fr.getText(SubscriptionSuccessMessage_Locator);
    }

    public boolean isPriceProduct1 ()
    {
        fr.textIsDisplayed(priceProduct1_Locator);
        return true;
    }

    public boolean isPriceProduct2 ()
    {
        fr.textIsDisplayed(priceProduct2_Locator);
        return true;
    }
    public boolean isQuantityProduct1 ()
    {
        fr.textIsDisplayed(quantityProduct1_Locator);
        return true;
    }
    public boolean isQuantityProduct2 ()
    {
        fr.textIsDisplayed(quantityProduct2_Locator);
        return true;
    }
    public boolean isTotalProduct1 ()
    {
        fr.textIsDisplayed(totalProduct1_Locator);
        return true;
    }
    public boolean isTotalProduct2 ()
    {
        fr.textIsDisplayed(totalProduct2_Locator);
        System.out.println(fr.getText(totalProduct2_Locator));
        return true;
    }
    public String getQuantityAmount ()
    {
        System.out.println(fr.getText(quantityProduct1_Locator));
        return fr.getText(quantityProduct1_Locator);
    }
    public void clickProceedToCheckout ()
    {
        fr.clickonElement(proceedToCheckout_Locator);
    }
    public  void clickRegisterLoginButton ()
    {
        fr.clickonElement(registerLoginButton_Locator);
    }

    public void addDescription (String description)
    {
        fr.sendKeys(textArea_Locator, description);
    }

    public void clickPlaceOrderButton ()
    {
        fr.clickonElement(placeOrderButton_Locator);

    }
    public Payment_Page navigateToPaymentPage ()
    {
        clickPlaceOrderButton();
        return new Payment_Page(browser);
    }

    public String getCurrentCartURL ()
    {
        return fr.getpageURL();
    }

}
