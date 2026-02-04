package UserManagement;

import Pages_Automation_Excersize.Home_Page;
import Pages_Automation_Excersize.Register_Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class SuccessRegister {
  String baseURL;
  Home_Page homePage ;
  Register_Page registerPage ;
  WebDriver browser;


    public void killAds() {
        try {
            org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) browser;
            String script =" const elements = document.getElementsByClassName('adsbygoogle');"+

            "for (let el of elements) {"+
               " el.style.display = '';"+
                    "await new Promise((resolve, reject)=>{ setTimeout(()=>resolve(),5000)}); console.log('ad removed')"+
                "el.style.display = 'none';"+
            "}";

            js.executeScript(script);
        } catch (Exception e) {
            System.out.println("Could not remove ads: " + e.getMessage());
        }
    }

    @BeforeMethod
    public void setupPages()throws Exception{

        ChromeOptions options = new ChromeOptions();

        // These arguments help prevent popups and ads
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");

        browser = new ChromeDriver();
        homePage = new Home_Page(browser);
        registerPage = new Register_Page(browser);

    }

    @Test

    public void setSuccessRegisterRequest() {

        SoftAssert soft = new  SoftAssert();
        killAds();
        homePage.navigateToHomePage();

        //Verify that home page is visible successfully
        String actual_URl = homePage.getURL();
        soft.assertEquals(actual_URl,"https://automationexercise.com/");

        //Verify 'New User Signup!' is visible
        killAds();
        homePage.clickSignUpLink();
        String SignupActual_URl = homePage.getURL();
        soft.assertEquals(SignupActual_URl,"https://automationexercise.com/login");


        killAds();
        registerPage.performCreateAccount("ahmed", "123456","useremail","5", "5", "2003", "Fathy", "GizaDevelopment", "in the sky",  1 , "Giza", "007", "01550000");
        String actualValue = registerPage.getsuccessRegister();
        killAds();
        System.out.println(actualValue);
        String expected_Message = "ACCOUNT CREATED!";


        // Verify that 'ACCOUNT CREATED!' is visible
        Assert.assertEquals(actualValue,expected_Message);
        soft.assertAll();

        killAds();
        registerPage.deleteAccount();
        String expectedDeletedMessage =  "ACCOUNT DELETED!";
        String actualdeletedmessage = registerPage.getDeletedMsgRegisterAccount();
        //Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        Assert.assertEquals(actualdeletedmessage,expectedDeletedMessage);
        soft.assertAll();
    }


}
