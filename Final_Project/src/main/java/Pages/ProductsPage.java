package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductsPage {

    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }
//    locators
    private final By shopping_cart= By.className("shopping_cart_link");
    private final By sortList =By.className("product_sort_container");
    private final By za =By.xpath("//option[@value=\"za\"]");
    private final By az =By.xpath("//option[@value=\"az\"]");
    private final By price_low_to_high =By.xpath("//option[@value=\"lohi\"]");
    private final By price_high_to_low =By.xpath("//option[@value=\"hilo\"]");
    private final By addToCart_sauce_labs_backpack =By.xpath("//button[@id=\"add-to-cart-sauce-labs-backpack\"]");
    private final By addToCart_sauce_labs_bike_light =By.xpath("//button[@id=\"add-to-cart-sauce-labs-bike-light\"]");
    private final By removeFromCart_sauce_labs_bike_light= By.xpath("//button[@id=\"remove-sauce-labs-bike-light\"]");
    private final By removeFromCart_sauce_labs_backpack =By.xpath("//button[@id=\"remove-sauce-labs-backpack\"]");

    // Actions
//    public void navigate ()
//    {
//        driver.get("https://www.saucedemo.com/inventory.html");
//    }

    // Sorting
    public void clickShoppingCart()
    {
        driver.findElement(shopping_cart).click();
    }
    public void sortingProducts_ZToA()
    {
        driver.findElement(sortList).click();
        driver.findElement(za).click();
    }

    public void sortingProducts_AtoZ()
    {
        driver.findElement(sortList).click();
        driver.findElement(az).click();
    }

    public void selectPriceSortHighToLow()
    {
        driver.findElement(sortList).click();
        driver.findElement(price_high_to_low).click();
    }
    public void selectPriceSortLowToHigh()
    {
        driver.findElement(sortList).click();
        driver.findElement(price_low_to_high).click();
    }


    // Add to Cart
    public void addToCart_sauce_labs_backpack()
    {
        driver.findElement(addToCart_sauce_labs_backpack).click();
    }

    public void addToCart_sauce_labs_bike_light()
    {
        driver.findElement(addToCart_sauce_labs_bike_light).click();
    }

    public void removeFromCart_sauce_labs_bike_light()
    {
        driver.findElement(removeFromCart_sauce_labs_bike_light).click();
    }
    public void removeFromCart_sauce_labs_backpack()
    {
        driver.findElement(removeFromCart_sauce_labs_backpack).click();
    }




    // Assertion
    public void validateSuccessfulLogin()
    {
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
    }

    public void validateProductsAddedToCartSauceLabsBikeLight()
    {
       Assert.assertTrue( driver.findElement(removeFromCart_sauce_labs_bike_light).isDisplayed());
    }

    public void validateProductsAddedToCart_sauce_labs_backpack()
    {
        driver.findElement(removeFromCart_sauce_labs_backpack).isDisplayed();
    }
    public void validateProductsRemovedFromCart_sauce_labs_backpack()
    {
        Assert.assertTrue(driver.findElement(addToCart_sauce_labs_backpack).isDisplayed());
    }
    public void validateProductsRemovedFromCart_sauce_labs_bike_light()
    {
        Assert.assertTrue(driver.findElement(addToCart_sauce_labs_bike_light).isDisplayed());
    }


}
