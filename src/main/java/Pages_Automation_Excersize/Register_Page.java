package Pages_Automation_Excersize;

import Utils.Framework;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.Duration;


public class Register_Page {
WebDriver browser;

private final Framework fr;



    // Register page constructor

public Register_Page (WebDriver browser ) {
 fr = new Framework(browser);

}



    // Locator
 private final By NewUserNameLocator = By.cssSelector("input[name=\"name\"]");
 private final By NewUserEmailLocator = By.cssSelector("input[data-qa=\"signup-email\"]");
 private final By SignupButton = By.cssSelector("button[data-qa=\"signup-button\"]");
 private final By titleMRinput_locator = By.cssSelector("input[id=\"id_gender1\"]");
 private final By titleMRsinput_locator = By.id("id_gender2");
 private final By newusername_locator = By.id("name");
 private final By addemail_locator = By.id("email");
 private final By addpassword_locator = By.id("password");
 private final By dayOfBirthList_locator = By.id("days");
 private final By monthOfBirthList_locator = By.id("months");
 private final By yearOfBirthList_locator = By.id("years");
 private final By newslettercheckbox_locator = By.id("newsletter");
 private final By optinSpecialOffers_locator = By.id("optin");

 private final By enterfirstname_locator = By.id("first_name");
 private final By enterlastname_locator = By.id("last_name");
 private final By entercompany_locator = By.id("company");
 private final By enteraddress1_locator = By.id("address1");
 private final By enteraddress2_locator = By.id("address2");
 private final By selectCountryList_locator = By.id("country");
 private final By enterState_locator = By.id("state");
 private final By enterCity_locator = By.id("city");
 private final By enterzipcode_locator = By.id("zipcode");
 private final By entermobileNumber_locator = By.id("mobile_number");

 private final By clickCreateaccountButton = By.cssSelector("button[data-qa=\"create-account\"]");

 private final By getSuccessMessage_locator = By.cssSelector("h2.title >b");

 private final By clickContinueButton_Locator = By.cssSelector("[data-qa=\"continue-button\"]");
 private final By deleteAccountButton_Locator = By.linkText("Delete Account");
 private final By deletedAccountSuccessMessage_Locator = By.cssSelector("[data-qa=\"account-deleted\"] > b");
 private final By existingEmailRegister_Locator = By.cssSelector("p[style=\"color: red;\"]");






 // functionalities



 public void enterDesiredUserName( String userName ) {
  fr.sendKeys(NewUserNameLocator, userName);
 }
 public void enterUserEmail( String userEmail )
 {

  userEmail = fr.generateRandomEmail();
  fr.sendKeys(NewUserEmailLocator, userEmail);
  String generatedUserEmail =  userEmail;
  System.out.println("generatedUserEmail: " + generatedUserEmail);
 }

 public void enterUserEmailNormal(String email ) {
  fr.sendKeys(NewUserEmailLocator, email);
 }
 public String getEmailUsed() {
  return browser.findElement(NewUserEmailLocator).getAttribute("value");
 }

 public void clickSignupButton( ) {
  fr.clickonElement(SignupButton);}


 public void clickOnTitleMR()
 {
  fr.clickonElement(titleMRinput_locator);
 }
 public void clickOnTitleMRs()
 {
  fr.clickonElement(titleMRsinput_locator);
 }
 public void add_username (String new_username)
 {
  fr.sendKeys(newusername_locator  , new_username);
 }
 public void add_email(String email)
 {
  fr.sendKeys(addemail_locator , email);
 }
public  void add_password (String password) {
 fr.sendKeys(addpassword_locator, password);
 String GeneratedPassword = password;
 System.out.println("Generated Password: " + GeneratedPassword);
}
  public String getPasswordUsed() {
  return browser.findElement(addpassword_locator).getAttribute("value");

 }
 public void selectDayOfBirth (String days)
  {
  fr.selectdropdownbyValue(dayOfBirthList_locator, days);
  }
 public void selectMonthOfBirth (String month)
 {
  fr.selectdropdownbyValue( monthOfBirthList_locator , month);
 }
 public void selectYearOfBirth(String year)
 {
  fr.selectdropdownbyValue( yearOfBirthList_locator , year);
 }
 public void selectNewsletter ()
 {
  fr.checkCheckbox(newslettercheckbox_locator);
 }
 public  void selectOptinSpecialOffers ()
 {
  fr.checkCheckbox(optinSpecialOffers_locator);
 }
  public void addFirstName (String firstname)
  {
  fr.sendKeys(enterfirstname_locator , firstname);
  }
  public void addLastName (String lastname)
  {
  fr.sendKeys(enterlastname_locator , lastname);
  }
  public void addCompanyName (String company)
  {
  fr.sendKeys(entercompany_locator , company);
  }
  public void addAddress1 (String address1)
  {
   fr.sendKeys(enteraddress1_locator , address1);
  }
  public void addAddress2 (String address2)
  {
   fr.sendKeys(enteraddress2_locator , address2);
  }
  public void SelectCountryList( int country)
  {
   fr.selectdropdownbyIndex(selectCountryList_locator , country);
  }
  public  void addState(String state)
  {
   fr.sendKeys(enterState_locator , state);
  }
  public void addCity (String city)
  {
   fr.sendKeys(enterCity_locator  , city);
  }
  public void addZipcode (int zipcode)
  {
   fr.sendKeysInt (enterzipcode_locator , zipcode );
  }
  public void addMobileNumber (int mobileNumber)
  {
   fr.sendKeysInt (entermobileNumber_locator , mobileNumber);
  }
  public void clickCreateaccountButton()
  {
   fr.clickonElement(clickCreateaccountButton);
  }
  public String getsuccessRegister()
  {
   fr.explicitlyWaitVoid(Duration.ofSeconds(20) , getSuccessMessage_locator);
   return fr.getText(getSuccessMessage_locator);
  }

 public String getDeletedMsgRegisterAccount ()
 {
  fr.explicitlyWaitVoid(Duration.ofSeconds(20) , deletedAccountSuccessMessage_Locator);
  return fr.getText(deletedAccountSuccessMessage_Locator);
 }


  public void performCreateAccount(String username, String password , String userEmail, String day , String month , String year , String lastname , String companyName , String address12 , int country , String state, String zipcode, String mobileNumber)
  {

   enterDesiredUserName(username) ;
   enterUserEmail( userEmail );
   clickSignupButton ();

   clickOnTitleMR();
   add_username(username);
   add_password(password);
   selectDayOfBirth(day);
   selectMonthOfBirth(month);
   selectYearOfBirth(year);
   selectNewsletter();
   selectOptinSpecialOffers();
   addFirstName (username);
   addLastName(lastname);
   addCompanyName(companyName);
   addAddress1(address12);
   addAddress2(address12);
   SelectCountryList (country);
   addState(state);
   addCity(state);
   addZipcode(Integer.parseInt(zipcode));
   addMobileNumber(Integer.parseInt(mobileNumber));
   clickCreateaccountButton();
   getsuccessRegister();
  }

  public void deleteAccount()
  {
    fr.clickonElement(clickContinueButton_Locator);
    fr.clickonElement(deleteAccountButton_Locator);
    fr.getText(deletedAccountSuccessMessage_Locator);
    System.out.println(fr.getText(deletedAccountSuccessMessage_Locator));

  }
/*
Test Case 5: Register User with existing email
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible
6. Enter name and already registered email address
7. Click 'Signup' button
8. Verify error 'Email Address already exist!' is visible
 */

 public void registerExistingEmail(String userName , String userEmail){
  enterDesiredUserName(userName);
  enterUserEmailNormal(userEmail);
  clickSignupButton ();


 }
 public String getExistingEmailMessage (){
  return fr.getText(existingEmailRegister_Locator);
 }
}

