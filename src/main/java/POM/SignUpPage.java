package POM;

import Core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpPage extends BasePage {
    private WebDriver driver;
    private WebDriverWait wait;

    By usernameField = By.id("username");
    By emailField = By.id("email");
    By passwordField = By.id("password");
    By confirmPasswordField = By.id("confirm");
    By signUpButton = By.xpath("//button[text()='Register']");

    public SignUpPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
    }

    public void signUp(String username, String email, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(confirmPasswordField).sendKeys(password);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(signUpButton).click();
        wait.withTimeout(Duration.ofSeconds(15));
    }
}