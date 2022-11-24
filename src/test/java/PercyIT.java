import io.percy.selenium.Percy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PercyIT {

    private ChromeDriver driver;
    private Percy percy;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver(new ChromeOptions());
        percy = new Percy(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.close();
        }
    }

    @Test
    public void testName() {
        driver.get("https://github.com/percy/percy-selenium-java");
        percy.snapshot("github");
    }
}
