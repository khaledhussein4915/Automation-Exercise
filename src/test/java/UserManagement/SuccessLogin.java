package UserManagement;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SuccessLogin extends BaseClass{





    @Test // Test Case 2: Login User with correct email and password
    public void successLoginTest( )
    {
        homePage.navigateToLoginPage();
        String actual_URl = homePage.getURL();

        softTest.assertEquals(actual_URl,"https://automationexercise.com/");

        loginPage.performLogin("rusty.runte@yahoo.com","123456");

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
        softTest.assertAll();


    }



}
