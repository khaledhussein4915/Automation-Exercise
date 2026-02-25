package Pages_Automation_Excersize;

import Utils.Framework;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Payment_Page {
    WebDriver browser;
    Framework fr;


    //Locators
    private final By nameOnCard_Locator = By.cssSelector("[name=\"name_on_card\"]");
    private final By cardNumber_Locator = By.cssSelector("[name=\"card_number\"]");
    private final By CVCNumber_Locator = By.cssSelector("[name=\"cvc\"]");
    private final By expirationMonth_Locator = By.cssSelector("[name=\"expiry_month\"]");
    private final By expirationYear_Locator = By.cssSelector("[name=\"expiry_year\"]");
    private final By payOrderButton_Locator = By.cssSelector("[data-qa=\"pay-button\"]");
    private final By successPayMSG_Locator = By.cssSelector("[style=\"font-size: 20px; font-family: garamond;\"]");


    //Constructor
    public Payment_Page (WebDriver browser)
    {
        this.browser=browser;
        fr = new Framework(browser);
    }
    //Functions
    public void addNameOnCard (String cardName)
    {
        fr.sendKeys(nameOnCard_Locator,cardName);
    }
    public void addCardNumber(String cardNumber)
    {
        fr.sendKeys(cardNumber_Locator, cardNumber);
    }
    public void addCVCNumber(String cvcNumber)
    {
        fr.sendKeys(CVCNumber_Locator,(cvcNumber));
    }
    public void addExpiryMonth(String expiryMonth)
    {
        fr.sendKeys(expirationMonth_Locator, (expiryMonth));
    }
    public void addExpiryYear (String expiryYear)
    {
        fr.sendKeys(expirationYear_Locator,(expiryYear));
    }
    public  void clickConfirmPayOrderButton()
    {
        fr.clickonElement(payOrderButton_Locator);
    }
    public String getSuccessPaymentMSG()
    {
        return fr.getText(successPayMSG_Locator);
    }
    public void addPaymentDetails(String cardName , String cardNumber, String cvcNumber, String expiryMonth, String expiryYear)
    {
        addNameOnCard(cardName);
        addCardNumber(cardNumber);
        addCVCNumber(cvcNumber);
        addExpiryMonth(expiryMonth);
        addExpiryYear(expiryYear);
        clickConfirmPayOrderButton();
    }



}
