package RegisterNewUser;

import Pages_Automation_Excersize.Home_Page;
import Pages_Automation_Excersize.Login_Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SuccessLogin {
    Home_Page homePage;
    Login_Page loginPage;
    String baseURL;
    WebDriver browser;
    SoftAssert soft ;



    @BeforeMethod
    public void initialise()
    {
        browser = new ChromeDriver();
        homePage = new Home_Page(browser,baseURL);
        loginPage = new Login_Page(browser);
        soft= new SoftAssert();

        }


    @Test // Test Case 2: Login User with correct email and password
    public void successLoginTest( )
    {
        homePage.navigateToLoginPage();
        String actual_URl = homePage.getURL();
        soft.assertEquals(actual_URl,"https://automationexercise.com/");

        loginPage.performLogin("priscila.heller@yahoo.com","123456");

        String actualSuccessLoginMessage = loginPage.getSuccessLoginMessage( );
        System.out.println(actualSuccessLoginMessage);
        loginPage.killads();
        String expectedSuccessLoginMessage = "Logged in as";
        Assert.assertEquals(actualSuccessLoginMessage.contains(expectedSuccessLoginMessage),true);

        //9. Click 'Delete Account' button
        loginPage.preformDeleteAccountAction();
        String expectedDeletedMessage =  "ACCOUNT DELETED!";
        String actualdeletedmessage = loginPage.getDeletedAccountSuccessMessage();
        loginPage.killads();
        //Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        Assert.assertEquals(actualdeletedmessage,expectedDeletedMessage);
        soft.assertAll();


    }



}
