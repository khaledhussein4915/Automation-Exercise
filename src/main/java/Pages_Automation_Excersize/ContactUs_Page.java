package Pages_Automation_Excersize;

import Utils.Framework;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUs_Page {
    private Framework fr;
    WebDriver browser;

    //Constructor
    public ContactUs_Page (WebDriver browser)
    {
        this.browser=browser;
        this.fr =new Framework(browser);
    }

    //Locators
    private final By getInTouch_Locator = By.cssSelector("div.contact-form>h2[class=\"title text-center\"]");
    private final By nameField_Locator = By.cssSelector("input[data-qa=\"name\"]");
    private final By emailField_Locator = By.cssSelector("input[name=\"email\"]");
    private final By subjectField_locator = By.cssSelector("input[name=\"subject\"]");
    private final By enterMessageArea_Locator = By.id("message");
    private final By uploadFileButton_Locator = By.cssSelector("input[type=\"file\"]");
    private final By submitButton_Locator = By.cssSelector("input[data-qa=\"submit-button\"]");






    //Function
    public boolean isGetInTouchDisplayed()
    {
        return fr.textIsDisplayed(getInTouch_Locator);
    }
    public void enterContactName(String name)
    {
        fr.explicitlyWaitElementVisibility(10,nameField_Locator);
        fr.sendKeys(nameField_Locator, name);
    }
    public void enterContactEmail(String email)
    {
        fr.sendKeys(emailField_Locator, email);
    }
    public void enterContactSubject(String subject)
    {
        fr.sendKeys(subjectField_locator, subject);
    }
    public void enterContactMessage (String message)
    {
        fr.sendKeys(enterMessageArea_Locator , message);
    }
    public void  uploadFileButton ( String filePath)
    {
        fr.uploadFile(uploadFileButton_Locator,filePath);
    }

    public void submitButton_Click ()
    {
        fr.clickonElement(submitButton_Locator);
        fr.acceptAlert();
    }

    public void preformContactUsRequest(String name,String email, String subject, String message ,String filePath)
    {
        enterContactName(name);
        enterContactEmail(email);
        enterContactSubject(subject);
        enterContactMessage(message);
        uploadFileButton(filePath);
        submitButton_Click();
    }


}
