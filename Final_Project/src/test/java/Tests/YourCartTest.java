package Tests;

import Base.TestBase;
import Pages.LoginPage;
import Pages.ProductsPage;
import Pages.YourCartPage;
import com.automation.remarks.testng.UniversalVideoListener;
import com.automation.remarks.video.annotations.Video;
import jdk.jfr.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(UniversalVideoListener.class)
public class YourCartTest extends TestBase {
    LoginPage loginPage;
    YourCartPage yourCartPage;
    ProductsPage productsPage;

    @Video
    @Description("Validate Checkout")
    @Test(priority = 1)
    public void checkout() {
        loginPage = new LoginPage(driver);
        yourCartPage = new YourCartPage(driver);
        productsPage = new ProductsPage(driver);

        loginPage.Navigate();
        loginPage.login(testData.get("username"), testData.get("password"));
        productsPage.addToCart_sauce_labs_backpack();
        productsPage.addToCart_sauce_labs_bike_light();
        productsPage.clickShoppingCart();
        yourCartPage.clickCheckout();
        yourCartPage.validateCheckout();
    }
    @Video
    @Description("Validate Continue Shopping")
    @Test(priority = 2)
    public void continueShopping() {
        loginPage = new LoginPage(driver);
        yourCartPage = new YourCartPage(driver);
        productsPage = new ProductsPage(driver);

        loginPage.Navigate();
        loginPage.login(testData.get("username"), testData.get("password"));
        productsPage.addToCart_sauce_labs_backpack();
        productsPage.addToCart_sauce_labs_bike_light();
        productsPage.clickShoppingCart();
        yourCartPage.clickContinueShopping();
        yourCartPage.validateContinueShopping();
    }
}
