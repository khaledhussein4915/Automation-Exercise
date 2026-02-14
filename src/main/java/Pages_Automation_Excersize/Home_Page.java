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



//Constructor
public Home_Page (WebDriver browser)
{
    this.fr = new Framework(browser);
    this.browser = browser;

}
//Functional
    public Home_Page navigateToHomePage ( ){

    fr.navigatesToURL(Constants.APP_URL);
    return this;

    }

    public Login_Page navigateToLoginPage()
    {
     fr.clickonElement(signUp_loginLink_Locator);
    return new Login_Page(browser) ;
    }

    public Register_Page navigateToRegistrationPage()
    {
         fr.clickonElement(signUp_loginLink_Locator);
         return new Register_Page(browser) ;

    }

    public Product_Page navigateToProductPage ()
    {
        fr.clickonElement(product_Locator);
        return new Product_Page(browser);
    }

    public ContactUs_Page navigateToContactUs() {
        fr.clickonElement(contactUs_Locator);

        return new ContactUs_Page(browser);
    }

    public void navigateToTestCasesPage()
    {
        fr.clickonElement(testCase_locator);
    }

    public String getURL() {
        return fr.getpageURL();
    }

    public void killads()
    {
        fr.killAds();
    }




}
