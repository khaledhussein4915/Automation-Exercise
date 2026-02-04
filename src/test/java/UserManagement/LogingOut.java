package UserManagement;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LogingOut extends BaseClass{




    @Test
    public void LogOut() {
        homePage.navigateToHomePage();
        homePage.killads();
        homePage.navigateToLoginPage();
        loginPage.performLogin("ahmed.khamis@gmail.com","ahmed.khamis@gmail.com");
        loginPage.killads();
        loginPage.logout();
        String actualURL = loginPage.getPageURL();
        String expectedURL="https://automationexercise.com/login";
        Assert.assertEquals(actualURL,expectedURL);
    }
}
