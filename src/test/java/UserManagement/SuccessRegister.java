package UserManagement;



import PojoClass.RegisterNewUserData;
import Utils.HelperClass;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class SuccessRegister extends BaseClass{

@Ignore
    @Test

    public void SuccessRegisterTest()  {

        SoftAssert soft = new  SoftAssert();
        homePage.navigateToHomePage();

        //Verify that home page is visible successfully
        String actual_URl = homePage.getURL();
        soft.assertEquals(actual_URl,"https://automationexercise.com/");

        //Verify 'New User Signup!' is visible
        homePage.killads();
        homePage.navigateToRegistrationPage();
        String SignupActual_URl = homePage.getURL();
        soft.assertEquals(SignupActual_URl,"https://automationexercise.com/login");


        homePage.killads();
        String jsonfilepath = "src/main/java/Json/UserData/RegistrationData.json";

        RegisterNewUserData registerData = HelperClass.getData(jsonfilepath,RegisterNewUserData.class);
        registerPage.performCreateAccount
                (registerData.username, registerData.password, registerData.userEmail, registerData.day, registerData.month, registerData.year, registerData.lastname, registerData.companyName, registerData.address12, registerData.country, registerData.state, registerData.zipcode, registerData.mobileNumber);

        String actualValue = registerPage.getsuccessRegister();
        homePage.killads();
        System.out.println(actualValue);
        String expected_Message = "ACCOUNT CREATED!";
        // Verify that 'ACCOUNT CREATED!' is visible
        Assert.assertEquals(actualValue,expected_Message);
        soft.assertAll();


        homePage.killads();

        String actualdeletedmessage = registerPage.deleteAccount();
        String expectedDeletedMessage =  "ACCOUNT DELETED!";
        //Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        Assert.assertEquals(actualdeletedmessage,expectedDeletedMessage);
        soft.assertAll();
    }

    @Test // Test Case 5: Register User with existing email
    public void performExistingRegisterRequest() {
        homePage.navigateToHomePage();
        homePage.navigateToRegistrationPage();
        registerPage.registerExistingEmail("Ahmed", "ahmed.khamis@gmail.com");
        String actualValue = registerPage.getExistingEmailMessage();
        String expectedValue = "Email Address already exist!";
        Assert.assertEquals(actualValue.contains(expectedValue),true);
    }


}
