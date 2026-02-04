package UserManagement;

import org.testng.Assert;
import org.testng.annotations.Test;


public class NegativeLogin extends BaseClass{


    @Test
    // 3-Test Case 3: Login User with incorrect email and password
    public void negativeLogin()
    {
        homePage.navigateToLoginPage();
        loginPage.performLogin("x@email.com" , "password");
        loginPage.getWrongLoginMessage();
        System.out.println(loginPage.getWrongLoginMessage());
        String failLoginMessage = loginPage.getWrongLoginMessage();
        Assert.assertTrue(failLoginMessage.contains("Your email or password is incorrect!"));

    }
}
