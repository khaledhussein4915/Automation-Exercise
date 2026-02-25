package CartAndCheckout;

import Pages_Automation_Excersize.Cart_Page;
import Pages_Automation_Excersize.Payment_Page;
import Pages_Automation_Excersize.Product_Page;
import Pages_Automation_Excersize.Register_Page;
import PojoClass.PaymentDetails;
import PojoClass.RegisterNewUserData;
import UserManagement.BaseClass;
import Utils.HelperClass;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCart extends BaseClass {

    Cart_Page cartPage ;
    Product_Page productPage ;
    Register_Page registerPage ;
    Payment_Page paymentPage ;

    @BeforeMethod
    public void beforeMethod() {
        cartPage = new Cart_Page(browser);
        productPage = new Product_Page(browser);
        registerPage = new Register_Page(browser);
        paymentPage = new Payment_Page(browser);


    }

    @Test
    public void subscribeInsideCart() {
        homePage.navigateToHomePage();
        homePage.killads();
        homePage.navigateToCartPage();
        cartPage.subscribeByEmail("email@email.com");

        String expectedSubscriptionMSG = "You have been successfully subscribed!";
        String actualSubscriptionMSG = cartPage.getsubscriptionSuccessMessage();


        Assert.assertTrue(expectedSubscriptionMSG.contains(actualSubscriptionMSG));
    }

    @Test //Test Case 14: Place Order: Register while Checkout
    public void PlaceOrder_Register_Checkout()
    {
        homePage.navigateToHomePage();
        homePage.navigateToProductPage();
        productPage.addFirstProductToCart();
        productPage.addSecondProductToCart();
        homePage.navigateToCartPage();
        cartPage.clickProceedToCheckout();
        cartPage.clickRegisterLoginButton();

        String registerjsonfilepath = "src/main/java/Json/UserData/RegistrationData.json";
        RegisterNewUserData registerData = HelperClass.getData(registerjsonfilepath,RegisterNewUserData.class);
        registerPage.performCreateAccount
                (registerData.username, registerData.password, registerData.userEmail, registerData.day, registerData.month, registerData.year, registerData.lastname, registerData.companyName, registerData.address12, registerData.country, registerData.state, registerData.zipcode, registerData.mobileNumber);

        homePage.navigateToCartPage();
        cartPage.clickProceedToCheckout();
        cartPage.addDescription("I need this order as soon as possible and be caution its fragile");


        String jsonfilepathPayment = "src/main/java/Json/PaymentDetails/paymentDetails.json";
        PaymentDetails paymentData = HelperClass.getData( jsonfilepathPayment, PaymentDetails.class);

        cartPage.navigateToPaymentPage();
        paymentPage.addPaymentDetails(paymentData.cardName, paymentData.cardNumber,  paymentData.cvcNumber, paymentData.expiryMonth, paymentData.expiryYear);

        String expectedSuccessPaymentMSG = "Congratulations! Your order has been confirmed!";
        String actualSuccessPaymentMSG = paymentPage.getSuccessPaymentMSG();
        Assert.assertTrue(expectedSuccessPaymentMSG.contains(actualSuccessPaymentMSG));

        registerPage.deleteAccount();
        String expectedSuccessDeletedAccount = "ACCOUNT DELETED!";
        String actualSuccessDeletedAccount = registerPage.getDeletedMsgRegisterAccount();
        Assert.assertEquals(actualSuccessDeletedAccount, expectedSuccessDeletedAccount);



        }
        @Test //Test Case 15: Place Order: Register before Checkout

        public void Register_PlaceOrder_Checkout ()
        {
            homePage.navigateToHomePage();
            homePage.navigateToRegistrationPage();

            String registerjsonfilepath = "src/main/java/Json/UserData/RegistrationData.json";
            RegisterNewUserData registerData = HelperClass.getData(registerjsonfilepath,RegisterNewUserData.class);
            registerPage.performCreateAccount
                    (registerData.username, registerData.password, registerData.userEmail, registerData.day, registerData.month, registerData.year, registerData.lastname, registerData.companyName, registerData.address12, registerData.country, registerData.state, registerData.zipcode, registerData.mobileNumber);

            String expectedSuccessRegister = "ACCOUNT CREATED!";
            registerPage.getsuccessRegister();
            Assert.assertEquals(registerPage.getsuccessRegister(), expectedSuccessRegister);

            registerPage.clickContinueAfterRegister();

            String actualSuccessLoginMSG = loginPage.getSuccessLoginMessage();
            String expectedSuccessLoginMSG = "Logged in as";
            Assert.assertTrue(actualSuccessLoginMSG.contains(expectedSuccessLoginMSG));

            homePage.navigateToProductPage();
            productPage.addFirstProductToCart();
            productPage.addSecondProductToCart();

            homePage.navigateToCartPage();

            String actualCartURL = "https://automationexercise.com/view_cart";
            Assert.assertEquals( cartPage.getCurrentCartURL(),actualCartURL );

            cartPage.clickProceedToCheckout();
            cartPage.addDescription("I need this order as soon as possible and be caution its fragile");

            String jsonfilepathPayment = "src/main/java/Json/PaymentDetails/paymentDetails.json";
            PaymentDetails paymentData = HelperClass.getData( jsonfilepathPayment, PaymentDetails.class);

            cartPage.navigateToPaymentPage();
            paymentPage.addPaymentDetails(paymentData.cardName, paymentData.cardNumber,  paymentData.cvcNumber, paymentData.expiryMonth, paymentData.expiryYear);


            String expectedSuccessPaymentMSG = "Congratulations! Your order has been confirmed!";
            String actualSuccessPaymentMSG = paymentPage.getSuccessPaymentMSG();
            Assert.assertTrue(expectedSuccessPaymentMSG.contains(actualSuccessPaymentMSG));







        }



}


