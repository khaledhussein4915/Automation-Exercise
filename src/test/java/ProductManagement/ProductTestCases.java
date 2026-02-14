package ProductManagement;

import Pages_Automation_Excersize.Product_Page;
import UserManagement.BaseClass;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ProductTestCases extends BaseClass {
    Product_Page productPage ;

    @BeforeMethod
    public void setupProductPage() {
        productPage = new Product_Page(browser);
    }

    @Test
    public void testFirstProductAvailability()
    {
        homePage.navigateToHomePage();
        homePage.killads();
        homePage.navigateToProductPage();

        Assert.assertTrue(productPage.isAllProductsAvailable());

        //Verify user is navigated to ALL PRODUCTS page successfully
        String actualURL = productPage.getPageURL();
        String expectedURL = "https://automationexercise.com/products";
        softTest.assertEquals(actualURL,expectedURL);

        homePage.killads();
        productPage.clickOnFirstProductDetails();
        productPage.getAllProductDetails();
        String details = productPage.getAllProductDetails().toString();
        System.out.println(details);

        softTest.assertTrue(productPage.getProductName().contains("Blue Top"),"name");
        softTest.assertTrue(productPage.getProductPrice().contains("\"Rs. 500\""), "price");
        softTest.assertTrue(productPage.getProductCategory().contains("Women > Tops"),"category");
        softTest.assertTrue(productPage.getProductAvailability().contains("In Stock"),"Availability");







        softTest.assertAll();
    }


}
