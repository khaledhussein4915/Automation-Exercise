package Pages_Automation_Excersize;

import Utils.Constants;
import Utils.Framework;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Home_Page {
Framework fr ;
String URL;
WebDriver browser;

//Locator
    private final By signUpLink_Locator = By.linkText("Signup / Login");

//Constructor
public Home_Page (WebDriver browser, String URL)
{
    fr = new Framework(browser);
    this.URL=URL;

}
//Functional
public void navigateToHomePage ( WebDriver browser, String URL){
    this.URL=URL;
    fr.navigatesToURL(Constants.APP_URL);

}

public void  clickSignUpLink()
{
        fr.clickonElement(signUpLink_Locator);
}

public  void navigateToLoginPage()
{
    navigateToHomePage(browser,URL);
    clickSignUpLink();
}

    public String getURL() {
        return fr.getpageURL();
    }
}
