package UserManagement;

import Pages_Automation_Excersize.ContactUs_Page;
import Pages_Automation_Excersize.Home_Page;
import Pages_Automation_Excersize.Login_Page;
import Pages_Automation_Excersize.Register_Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class BaseClass {
    protected WebDriver browser;
    protected Home_Page homePage;
    protected Login_Page loginPage;
    protected ContactUs_Page contactUsPage;
    protected SoftAssert softTest;
    Register_Page registerPage ;

    @BeforeMethod
    public void setupBeforeMethods()
    {
        browser = new ChromeDriver();
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        ChromeOptions options = new ChromeOptions();
        // السطر ده بيقفل الـ popups والـ Ads بشكل أقوى
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        softTest = new SoftAssert();
        homePage = new Home_Page(browser);
        loginPage = new Login_Page(browser);
        registerPage = new Register_Page(browser);
        contactUsPage = new ContactUs_Page(browser);
        homePage.killads();
    }
    @AfterMethod
    public void tearDownAfterMethod()
    {
        homePage.killads();
        browser.quit();
    }
}
