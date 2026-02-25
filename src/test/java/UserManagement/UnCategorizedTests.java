package UserManagement;
import Pages_Automation_Excersize.ContactUs_Page;
import PojoClass.ContactUs;
import Utils.HelperClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UnCategorizedTests extends BaseClass
{

    @Test
    public void contactUsTest()
    {
        String jsonFilePath = "src/main/java/Json/ContatUs/contactUs.json";
        ContactUs getData = HelperClass.getData(jsonFilePath, ContactUs.class);
        homePage.navigateToHomePage();

        ContactUs_Page contactUsPage = homePage.navigateToContactUs();
        String filePath =  "C:\\Users\\Khaled\\Downloads\\test.jpg";

        contactUsPage.preformContactUsRequest(
                getData.name,getData.email,getData.message,getData.subject,filePath);

        Assert.assertEquals(contactUsPage.isGetInTouchDisplayed(),true);
    }

    @Test //Test Case 7: Verify Test Cases Page
    public void availabilityTestCasesPage()
    {
        homePage.navigateToHomePage();
        homePage.navigateToTestCasesPage();
        String ActualUrl = homePage.getURL();
        String ExpectedURL = "https://automationexercise.com/test_cases";
        Assert.assertEquals(ActualUrl,ExpectedURL);

    }

    @Test //Test Case 10: Verify Subscription in home page
    public void testSuperscribeByEmail()
    {
        homePage.navigateToHomePage();
        homePage.killads();
        homePage.subscribe("email@gmail.com");

        String expectedSubscriptionMSG = "You have been successfully subscribed!";
        String actualSubscriptionMSG = homePage.getsubscriptionSuccessMessage();
        homePage.isSuccessSubscriptionMessage();

        Assert.assertTrue(expectedSubscriptionMSG.contains(actualSubscriptionMSG));
    }
}