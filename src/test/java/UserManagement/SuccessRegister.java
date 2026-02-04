package UserManagement;

import Pages_Automation_Excersize.Home_Page;
import Pages_Automation_Excersize.Register_Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class SuccessRegister extends BaseClass{


@Ignore
    @Test

    public void setSuccessRegisterRequest() {

        SoftAssert soft = new  SoftAssert();
        homePage.killads();
        homePage.navigateToHomePage();

        //Verify that home page is visible successfully
        String actual_URl = homePage.getURL();
        soft.assertEquals(actual_URl,"https://automationexercise.com/");

        //Verify 'New User Signup!' is visible
        homePage.killads();
        homePage.clickSignUpLink();
        String SignupActual_URl = homePage.getURL();
        soft.assertEquals(SignupActual_URl,"https://automationexercise.com/login");


        homePage.killads();
        registerPage.performCreateAccount("ahmed", "123456","useremail","5", "5", "2003", "Fathy", "GizaDevelopment", "in the sky",  1 , "Giza", "007", "01550000");
        String actualValue = registerPage.getsuccessRegister();
        homePage.killads();
        System.out.println(actualValue);
        String expected_Message = "ACCOUNT CREATED!";


        // Verify that 'ACCOUNT CREATED!' is visible
        Assert.assertEquals(actualValue,expected_Message);
        soft.assertAll();

        homePage.killads();
        registerPage.deleteAccount();
        String expectedDeletedMessage =  "ACCOUNT DELETED!";
        String actualdeletedmessage = registerPage.getDeletedMsgRegisterAccount();
        //Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        Assert.assertEquals(actualdeletedmessage,expectedDeletedMessage);
        soft.assertAll();
    }

    @Test // Test Case 5: Register User with existing email
    public void performExistingRegisterRequest() {
        homePage.navigateToLoginPage();
        registerPage.registerExistingEmail("Ahmed", "ahmed.khamis@gmail.com");
        String actualValue = registerPage.getExistingEmailMessage();
        String expectedValue = "Email Address already exist!";
        Assert.assertEquals(actualValue.contains(expectedValue),true);
    }


}
