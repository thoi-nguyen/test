package POM;

import Core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class LoginPage extends BasePage {
    WebDriver driver;
    private WebDriverWait wait;

    By loginBtn = By.xpath("//a[@class='nav-link']");
    By usernameField = By.id("identifier");
    By passwordField = By.id("password");
    By loginButton = By.xpath("//button[text()='Login']");
    By toastSuccessMsg = By.id("toast-1");
    By incorrectCre = By.xpath("//*[@class='invalid-feedback']");

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
    }
    public void login(String username, String password) {
        wait.withTimeout(Duration.ofSeconds(15));
        driver.findElement(loginBtn).click();
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public void verifyLoginSuccess(String successMessage){
        wait.withTimeout(Duration.ofSeconds(15));
        assertTrue(driver.findElement(toastSuccessMsg).getText().contains(successMessage));
    }

    public void verifyLoginFail(String failMessage){
        wait.withTimeout(Duration.ofSeconds(15));
        assertTrue(driver.findElement(incorrectCre).getText().contains(failMessage));
    }
}
