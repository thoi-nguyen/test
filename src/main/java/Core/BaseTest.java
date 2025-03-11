package Core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {
    private WebDriver driver;
    protected WebDriver getDriver() {
        return driver;
    }
    public BaseTest() {
    }

    @BeforeClass
//    @Parameters("browser")
    public void setUp() {
//        System.out.println("Browser: " + browser);
        System.setProperty("webdriver.chrome.driver", "/Users/vanngocthanh/Downloads/chromedriver-mac-x64/chromedriver");
        driver = new ChromeDriver();

//        if (browser.equalsIgnoreCase("chrome")) {
//            System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
//            driver = new ChromeDriver();
//        } else if (browser.equalsIgnoreCase("firefox")) {
//            System.setProperty("webdriver.gecko.driver", "/Users/vanngocthanh/Downloads/geckodriver");
//            driver = new FirefoxDriver();
//        } else if (browser.equalsIgnoreCase("edge")) {
//            System.setProperty("webdriver.edge.driver", ".\\drivers\\msedgedriver.exe");
//            driver = new EdgeDriver();
//        }
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}