package Tests;

import Base.TestBase;
import Pages.*;
import com.automation.remarks.testng.UniversalVideoListener;
import com.automation.remarks.video.annotations.Video;
import jdk.jfr.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(UniversalVideoListener.class)
public class E2ETest extends TestBase {
    LoginPage loginPage;
    ProductsPage productsPage;
    YourCartPage yourCartPage;
    CheckoutInformationPage checkoutInformationPage;
    OverviewPage overviewPage;
    ComplatePage complatePage;

    @BeforeMethod
    public void setup() {
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        yourCartPage = new YourCartPage(driver);
        checkoutInformationPage = new CheckoutInformationPage(driver);
        overviewPage = new OverviewPage(driver);
        complatePage = new ComplatePage(driver);


        loginPage.Navigate();
        loginPage.login(testData.get("username"), testData.get("password"));
    }
    @Video
    @Description("End to End Test")
    @Test(priority = 1)
    public void endToEndTest() {
        productsPage.addToCart_sauce_labs_backpack();
        productsPage.addToCart_sauce_labs_bike_light();
        productsPage.clickShoppingCart();
        yourCartPage.clickCheckout();
        checkoutInformationPage.enterData(testData.get("firstNme"), testData.get("lastName"), testData.get("postalCode"));
        checkoutInformationPage.clickContinue();
        overviewPage.clickFinishButton();
        complatePage.validateCompleteText();

    }
    @Video
    @Description("End to End Test with empty fields")
    @Test(priority = 2)
    public void endToEndTestWithEmptyFields() {
        productsPage.addToCart_sauce_labs_backpack();
        productsPage.addToCart_sauce_labs_bike_light();
        productsPage.clickShoppingCart();
        yourCartPage.clickCheckout();
        checkoutInformationPage.enterData("", "", "");
        checkoutInformationPage.clickContinue();
        checkoutInformationPage.validateErrorMessage("Error: First Name is required");
    }


}
