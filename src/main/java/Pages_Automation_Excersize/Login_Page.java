package Pages_Automation_Excersize;

import Utils.Framework;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;


public class Login_Page {
    private Framework fr;


//--------------------------------------------------------------------------------------------------//
    // Constructor
    public Login_Page (WebDriver browser) {
        fr = new Framework(browser);
         }


//--------------------------------------------------------------------------------------------------//
    //Locators


    private final By exitanceUserEmail_Locator = By.cssSelector("input[data-qa=\"login-email\"]");
    private final By exitanceUserPassword_Locator = By.cssSelector("input[data-qa=\"login-password\"]");
    private final By loginButton_Locator = By.cssSelector("button[data-qa=\"login-button\"]");
    private final By successLoginMessage_Locator = By.cssSelector("ul[class=\"nav navbar-nav\"] :nth-of-type(10)");
    private final By deleteAccountButton_Locator = By.linkText("Delete Account");
    private final By deletedAccountSuccessMessage_Locator = By.cssSelector("[data-qa=\"account-deleted\"] > b");
    private final By wrongCredentialMessage_Locator = By.cssSelector("p[style=\"color: red;\"]");
    private final By logoutButton_Locator = By.linkText("Logout");
//--------------------------------------------------------------------------------------------------//
    // Functions

    public void enterUserEmail(String userEmail) {
        fr.sendKeys(exitanceUserEmail_Locator, userEmail);
    }
    public void enterUserPassword( String password ) {
        fr.sendKeys(exitanceUserPassword_Locator, password);
    }
    public void clickLoginButton( ) {
        fr.clickonElement(loginButton_Locator);
        killads();
    }
    public String getSuccessLoginMessage( ) {
        return fr.getText(successLoginMessage_Locator);
    }
    public void clickOnDeleteAccountButton( ) {
        fr.clickonElement(deleteAccountButton_Locator);
        killads();
    }
    public String getDeletedAccountSuccessMessage( ) {
        return fr.getText(deletedAccountSuccessMessage_Locator);
    }
    public String getWrongLoginMessage( ) {
        fr.explicitlyWaitVoid(Duration.ofSeconds(15),wrongCredentialMessage_Locator);
        return fr.getText(wrongCredentialMessage_Locator);
    }

    public void performLogin ( String email , String password)
    {
        enterUserEmail(email);
        enterUserPassword(password);
        clickLoginButton();
        killads();

    }
    public void preformDeleteAccountAction(){
        clickOnDeleteAccountButton( );
        getDeletedAccountSuccessMessage();
        killads();

    }
    public void killads()
    {
        fr.killAds();
    }
    public void logout(){
        fr.clickonElement(logoutButton_Locator);
    }

    public String getPageURL() {
        return fr.getpageURL();
    }


}