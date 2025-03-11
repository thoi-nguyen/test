package POM;

import Core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {
    WebDriver driver;
    private WebDriverWait wait;

    By loginBtn = By.xpath("//a[@class='nav-link']");
    By usernameField = By.id("identifier");
    By passwordField = By.id("password");
    By loginButton = By.xpath("//button[text()='Login']");

    public LoginPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 30);
    }
    public void login(String username, String password) {
        wait.withTimeout(Duration.ofSeconds(15));
        driver.findElement(loginBtn).click();
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public void navigateToLoginPage() {
        driver.findElement(loginBtn).click();
    }
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
}
