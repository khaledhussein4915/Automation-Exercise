package UserManagement;

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
    }
}
