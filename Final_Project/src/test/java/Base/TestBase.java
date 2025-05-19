package Base;

import Utilities.JsonReader;
import Utilities.ScreenShot;
import com.automation.remarks.video.annotations.Video;
import com.automation.remarks.video.enums.RecordingMode;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.Map;

public class TestBase {

    public WebDriver driver ;
    public  Map<String, String> testData;
    @Parameters("browser")
    @BeforeClass
    public void preconditions( @Optional("edge") String browser)
    {
        System.setProperty("Video.save.mode", RecordingMode.ALL.toString());

            if(browser.equalsIgnoreCase("chrome"))
        {
            driver = new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("firefox"))
        {
            driver = new FirefoxDriver();
        }
        else if (browser.equalsIgnoreCase("edge"))
        {
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        testData = JsonReader.readJsonFile("UserData.json");

    }

    @Parameters("browser")
    @AfterMethod
    public void takeScreenShot(ITestResult testResult , @Optional("edge") String browser)
    {
        if(ITestResult.FAILURE == testResult.getStatus())
        {
            ScreenShot.takeScreenShot(driver , testResult.getName() , browser);
        }


    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }
}
