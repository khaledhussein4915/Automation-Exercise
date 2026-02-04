package Pages_Automation_Excersize;

import Utils.Constants;
import Utils.Framework;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Home_Page {
Framework fr ;
String URL;
WebDriver browser;

//Locator
    private final By signUpLink_Locator = By.linkText("Signup / Login");

//Constructor
public Home_Page (WebDriver browser)
{
    this.fr = new Framework(browser);
    this.browser = browser;

}
//Functional
public void navigateToHomePage ( ){

    fr.navigatesToURL(Constants.APP_URL);

}

public void  clickSignUpLink()
{
        fr.clickonElement(signUpLink_Locator);
}

public  void navigateToLoginPage()
{
    navigateToHomePage();
    clickSignUpLink();
}

public String getURL() {
        return fr.getpageURL();
    }

public void killads()
    {
        fr.killAds();
    }
}
