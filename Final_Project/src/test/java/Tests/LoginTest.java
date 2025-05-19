package Tests;

import Base.TestBase;
import Pages.LoginPage;
import Pages.ProductsPage;
import com.automation.remarks.testng.UniversalVideoListener;
import com.automation.remarks.video.annotations.Video;
import jdk.jfr.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(UniversalVideoListener.class)
public class LoginTest extends TestBase {
    LoginPage loginPage;
    ProductsPage productsPage;

    @Video
    @Description("Validate Login with valid credentials")
    @Test(priority = 1)
    public void LoginWithValidData() {
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        loginPage.Navigate();
        loginPage.login(testData.get("username"), testData.get("password"));
        productsPage.validateSuccessfulLogin();
    }

    @Video
    @Description("Validate Login With Invalid Password")
    @Test(priority = 2)
    public void enterInvalidPassword() {
        loginPage = new LoginPage(driver);
        loginPage.Navigate();
        loginPage.login(testData.get("username"), "invalid");

        loginPage.validateErrorMessage("Epic sadface: Username and password do not match any user in this service");
    }
    @Video
    @Description("Validate Login With Invalid Username")
    @Test(priority = 3)
    public void enterInvalidUsername() {
        loginPage = new LoginPage(driver);
        loginPage.Navigate();
        loginPage.login("invalid", testData.get("password"));
        loginPage.validateErrorMessage("Epic sadface: Username and password do not match any user in this service");
    }

    @Video
    @Description("Leaving Username field empty")
    @Test(priority = 4)
    public void usernameIsEmpty() {
        loginPage = new LoginPage(driver);
        loginPage.Navigate();
        loginPage.login("", testData.get("password"));
        loginPage.validateErrorMessage("Epic sadface: Username is required");
    }

    @Video
    @Description("Leaving Password field empty")
    @Test(priority = 5)
    public void passwordIsEmpty() {
        loginPage = new LoginPage(driver);
        loginPage.Navigate();
        loginPage.login(testData.get("username"), "");
        loginPage.validateErrorMessage("Epic sadface: Password is required");
    }


    @Video
    @Description("Leaving both fields empty")
    @Test(priority = 6)
    public void fieldsIsEmpty() {
        loginPage = new LoginPage(driver);
        loginPage.Navigate();
        loginPage.login("", "");
        loginPage.validateErrorMessage("Epic sadface: Username is required");
    }
}
