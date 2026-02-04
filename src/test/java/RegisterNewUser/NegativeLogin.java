package RegisterNewUser;

import Pages_Automation_Excersize.Home_Page;
import Pages_Automation_Excersize.Login_Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;



public class NegativeLogin {
    Home_Page homePage ;
    Login_Page loginPage;
    WebDriver browser;
    String URL;




    @BeforeTest
    public void setUp()
    {
        browser = new ChromeDriver();
        loginPage = new Login_Page(browser);
        homePage = new Home_Page(browser,URL);
    }

    @Test
    // 3-Test Case 3: Login User with incorrect email and password
    public void nigativeLogin ()
    {
        homePage.navigateToLoginPage();
        loginPage.performLogin("x@email.com" , "password");
        loginPage.getWrongLoginMessage();
        System.out.println(loginPage.getWrongLoginMessage());
        String failLoginMessage = loginPage.getWrongLoginMessage();
        Assert.assertTrue(failLoginMessage.contains("Your email or password is incorrect!"));

    }
}
