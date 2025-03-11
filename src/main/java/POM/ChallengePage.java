package POM;

import Core.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChallengePage extends BaseTest {
    WebDriver driver;
    private WebDriverWait wait;

    By dropdown = By.id("profileDropdown");
    By myChallenge = By.xpath("identifier");
    By passwordField = By.id("password");
    By loginButton = By.xpath("//button[text()='Login']");

    public ChallengePage(WebDriver driver) {
//        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
    }
    public void createChallenge(String username, String password) {
        driver.findElement(loginBtn).click();
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }


}
