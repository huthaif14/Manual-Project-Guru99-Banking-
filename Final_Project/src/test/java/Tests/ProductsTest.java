package Tests;

import Base.TestBase;
import Pages.LoginPage;
import Pages.ProductsPage;
import Pages.YourCartPage;
import jdk.jfr.Description;
import org.testng.annotations.Test;

public class ProductsTest extends TestBase {
    ProductsPage productsPage;
    LoginPage loginPage;
    YourCartPage yourCartPage;

    @Description("Validate Products Sorting")
    @Test(priority = 1)
    public void sorting() {
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        loginPage.Navigate();
        loginPage.login(testData.get("username"), testData.get("password"));
        productsPage.sortingProducts_ZToA();
        productsPage.sortingProducts_AtoZ();
        productsPage.selectPriceSortLowToHigh();
        productsPage.selectPriceSortHighToLow();
    }


    @Description("Adding Products to Cart")
    @Test(priority = 2)
    public void addProducts() {
        productsPage.addToCart_sauce_labs_backpack();
        productsPage.addToCart_sauce_labs_bike_light();
        productsPage.validateProductsAddedToCart_sauce_labs_backpack();
        productsPage.validateProductsAddedToCartSauceLabsBikeLight();
    }


    @Description("Removing Products from Cart")
    @Test(priority = 3)
    public void removeProducts() {
        productsPage.removeFromCart_sauce_labs_backpack();
        productsPage.removeFromCart_sauce_labs_bike_light();
        productsPage.validateProductsRemovedFromCart_sauce_labs_backpack();
        productsPage.validateProductsRemovedFromCart_sauce_labs_bike_light();
    }
    @Description("Validation Shopping Cart Button  ")
    @Test(priority = 4)
    public void clickShoppingCart() {
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        yourCartPage = new YourCartPage(driver);
        loginPage.Navigate();
        loginPage.login(testData.get("username"), testData.get("password"));
        productsPage.addToCart_sauce_labs_backpack();
        productsPage.clickShoppingCart();
        yourCartPage.returnToYourCartPage();
    }
}
