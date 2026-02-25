package Pages_Automation_Excersize;

import Utils.Constants;
import Utils.Framework;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Home_Page {
Framework fr ;
WebDriver browser;

//Locator
    private final By signUp_loginLink_Locator = By.linkText("Signup / Login");
    private final By contactUs_Locator = By.linkText("Contact us");
    private final By testCase_locator = By.linkText("Test Cases");
    private final By product_Locator = By.partialLinkText("Products");
    private final By SubscriptionByEmail_Locator = By.id("susbscribe_email");
    private final By SubscriptionButton_Locator = By.id("subscribe");
    private final By SubscriptionSuccessMessage_Locator = By.id("success-subscribe");
    private final By cart_Locator = By.linkText("Cart");



//Constructor
public Home_Page (WebDriver browser)
{
    this.fr = new Framework(browser);
    this.browser = browser;

}
//Functional
    public Home_Page navigateToHomePage ( ){

    fr.navigatesToURL(Constants.APP_URL);
    fr.removeAds();
    return this;

    }

    public Login_Page navigateToLoginPage()
    {
     fr.clickonElement(signUp_loginLink_Locator);
     fr.removeAds();
    return new Login_Page(browser) ;
    }

    public Register_Page navigateToRegistrationPage()
    {
         fr.clickonElement(signUp_loginLink_Locator);
         fr.removeAds();
         return new Register_Page(browser) ;

    }

    public Product_Page navigateToProductPage ()
    {
        fr.doubleclick(product_Locator);
        fr.removeAds();
        return new Product_Page(browser);
    }

    public ContactUs_Page navigateToContactUs() {
        fr.clickonElement(contactUs_Locator);
        fr.removeAds();
        return new ContactUs_Page(browser);
    }

    public void navigateToTestCasesPage()
    {
        fr.clickonElement(testCase_locator);
        fr.removeAds();
    }

    public Cart_Page navigateToCartPage()
    {
        fr.clickonElement(cart_Locator);
        fr.removeAds();
        return new Cart_Page(browser);
    }

    public String getURL() {
        return fr.getpageURL();
    }

    public void killads()
    {
        fr.killAds();
    }
    public void removeADS()
    {
        fr.removeAds();
    }


    public void subscriptionByEmail (String email)
    {
        fr.sendKeys(SubscriptionByEmail_Locator,email);
    }
    public void clickOnSubscriptionButton()
    {
        fr.clickonElement(SubscriptionButton_Locator);

    }
    public void subscribe (String email)
    {
        subscriptionByEmail(email);
        clickOnSubscriptionButton();
        fr.removeAds();
    }
    public boolean isSuccessSubscriptionMessage ()
    {
        fr.textIsDisplayed(SubscriptionSuccessMessage_Locator);
        String successSubscribitionMsg = fr.getText(SubscriptionSuccessMessage_Locator);
        System.out.println(successSubscribitionMsg);

        return false;
    }
    public String getsubscriptionSuccessMessage ()
    {
       return fr.getText(SubscriptionSuccessMessage_Locator);
    }






}
