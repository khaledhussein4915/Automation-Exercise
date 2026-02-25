package ProductManagement;

import Pages_Automation_Excersize.Cart_Page;
import Pages_Automation_Excersize.Product_Page;
import UserManagement.BaseClass;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;


public class ProductTestCases extends BaseClass {
    Product_Page productPage ;
    Cart_Page cartPage;

    @BeforeMethod
    public void setupProductPage() {
        productPage = new Product_Page(browser);
        cartPage = new Cart_Page(browser);
    }


    @Ignore
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
        softTest.assertTrue(productPage.getProductPrice().contains("Rs. 500"), "price");
        softTest.assertTrue(productPage.getProductCategory().contains("Women > Tops"),"category");
        softTest.assertTrue(productPage.getProductAvailability().contains("In Stock"),"Availability");

            softTest.assertAll();
    }
    @Test
        public void testSearchProduct ()
    {
        homePage.navigateToHomePage();
        homePage.killads();
        homePage.navigateToProductPage();

        Assert.assertTrue(productPage.isAllProductsAvailable());

        productPage.searchForProduct("Blue Top");

        Assert.assertTrue(productPage.isSearchedProductAvailable(),"the product is available");


    }

    @Test
        public void addProductToCart ()
    {
        homePage.navigateToHomePage();
        homePage.navigateToProductPage();
        productPage.addFirstProductToCart();
        productPage.addSecondProductToCart();
        homePage.navigateToCartPage();
        Assert.assertTrue(cartPage.isPriceProduct1(),"true");
        Assert.assertTrue(cartPage.isPriceProduct2(),"true");
        Assert.assertTrue(cartPage.isQuantityProduct1(),"true");
        Assert.assertTrue(cartPage.isQuantityProduct2(),"true");
        Assert.assertTrue(cartPage.isTotalProduct1(),"true");
        Assert.assertTrue(cartPage.isTotalProduct2(),"true");


    }

    @Test //13: Verify Product quantity in Cart
    public void addQuantityToCart ()
    {
        homePage.navigateToHomePage();
        homePage.navigateToProductPage();
        productPage.clickViewProductButton();
        productPage.increaseProductQuantity(5);
        productPage.clickAddQuantityCart();
        productPage.clickOnContinueButton();
        homePage.navigateToCartPage();
        String actualQuantity = "5";
        String expectedQuantity = cartPage.getQuantityAmount();
        Assert.assertEquals(expectedQuantity, actualQuantity);
    }





}
