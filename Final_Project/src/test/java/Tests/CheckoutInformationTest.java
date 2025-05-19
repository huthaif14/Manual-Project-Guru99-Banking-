package Tests;

import Base.TestBase;
import Pages.LoginPage;
import Pages.ProductsPage;
import Pages.YourCartPage;
import Pages.CheckoutInformationPage;
import jdk.jfr.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutInformationTest extends TestBase {
    LoginPage loginPage;
    CheckoutInformationPage checkoutInformationPage;
    ProductsPage productsPage;
    YourCartPage yourCartPage;

    @BeforeMethod
    public void setup() {
        loginPage = new LoginPage(driver);
        checkoutInformationPage = new CheckoutInformationPage(driver);
        productsPage = new ProductsPage(driver);
        yourCartPage = new YourCartPage(driver);

        loginPage.Navigate();
        loginPage.login(testData.get("username"), testData.get("password"));
        productsPage.addToCart_sauce_labs_backpack();
        productsPage.addToCart_sauce_labs_bike_light();
        productsPage.clickShoppingCart();
        yourCartPage.clickCheckout();
    }

    @Description("Validate Your Information")
    @Test(priority = 1)
    public void enterYourInformation() {
        checkoutInformationPage.enterData(testData.get("firstName"), testData.get("lastName"), testData.get("postalCode"));
        checkoutInformationPage.clickContinue();
        checkoutInformationPage.validateEnterValidData();
    }

//    @Description("Validate Your Information with empty username field")
//    @Test(priority = 2)
//    public void enterYourInformationWithEmptyFirstName() {
//        checkoutInformationPage.enterData("", "Yasser", "12345");
//        checkoutInformationPage.clickContinue();
//        checkoutInformationPage.validateErrorMessage("Error: First Name is required");
//    }
//
//    @Description("Validate Your Information with empty last name field")
//    @Test(priority = 3)
//    public void enterYourInformationWithEmptyLastName() {
//        checkoutInformationPage.enterData("Huthaifa", "", "12345");
//        checkoutInformationPage.clickContinue();
//        checkoutInformationPage.validateErrorMessage("Error: Last Name is required");
//    }
//
//    @Description("Validate Your Information with empty postal code field")
//    @Test(priority = 4)
//    public void enterYourInformationWithEmptyPostalCode() {
//        checkoutInformationPage.enterData("Huthaifa", "Yasser", "");
//        checkoutInformationPage.clickContinue();
//        checkoutInformationPage.validateErrorMessage("Error: Postal Code is required");
//    }
//
//    @Description("Validate Your Information with empty all fields")
//    @Test(priority = 5)
//    public void enterYourInformationWithEmptyAllFields() {
//        checkoutInformationPage.enterData("", "", "");
//        checkoutInformationPage.clickContinue();
//        checkoutInformationPage.validateErrorMessage("Error: First Name is required");
//    }
//
//    @Description("Validate cancel button functionality")
//    @Test(priority = 6)
//    public void clickCancelButton() {
//        checkoutInformationPage.clickCancel();
//        yourCartPage.returnToYourCartPage();
//    }
}