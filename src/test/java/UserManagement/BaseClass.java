package UserManagement;

import Pages_Automation_Excersize.Home_Page;
import Pages_Automation_Excersize.Login_Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class BaseClass {
    protected WebDriver browser;
    protected Home_Page homePage;
    protected Login_Page loginPage;
    SoftAssert softTest;

    @BeforeMethod
    public void setupBeforeMethods()
    {
        browser = new ChromeDriver();
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        softTest = new SoftAssert();
        homePage = new Home_Page(browser);
        loginPage = new Login_Page(browser);
    }
    @AfterMethod
    public void tearDownAfterMethod()
    {
        browser.quit();
    }
}
