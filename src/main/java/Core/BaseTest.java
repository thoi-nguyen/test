package Core;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import utility.ExtentManager;

public class BaseTest {
    private WebDriver driver;
    ExtentReports extent = ExtentManager.createInstance();
    ExtentTest test;
    private ConfigReader configReader;
    protected WebDriver getDriver() {
        return driver;
    }
    public BaseTest() {
        configReader = new ConfigReader();
    }

    @BeforeMethod
    @Parameters("browser")
    public void setUp() {
        String browser = System.getenv("BROWSER");
        String driverPath = System.getenv("DRIVER_PATH");

        if (browser == null || driverPath == null) {
            throw new IllegalArgumentException("BROWSER and DRIVER_PATH environment variables must be set");
        }

        switch (browser.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", driverPath);
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless=new");
                driver = new ChromeDriver(options);
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", driverPath);
                driver = new FirefoxDriver();
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver", driverPath);
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
        driver.get(getBaseUrl());
        driver.manage().window().maximize();
//        System.out.println("Browser: " + browser);
//        System.setProperty("webdriver.chrome.driver", "/Users/vanngocthanh/Downloads/chromedriver-mac-x64/chromedriver");
//        driver = new ChromeDriver();
//        driver.get(getBaseUrl());
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
//        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
        if (test != null) {
            test.log(Status.INFO, "Test Done");
        }
        extent.flush();
    }

    protected String getBaseUrl() {
        String environment = System.getProperty("env", "dev"); // Default to "dev" if not specified
        return configReader.getBaseUrl(environment);
    }

}