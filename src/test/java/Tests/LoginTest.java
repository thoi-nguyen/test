package Tests;

import Core.BaseTest;
import POM.ChallengePage;
import POM.LoginPage;
import POM.SignUpPage;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    Faker faker = new Faker();
    String baseUrl = "https://ctflearn.com";
    String user_name = faker.name().firstName();
    String password = faker.internet().password();
    String email = faker.internet().emailAddress();

    @Test
    public void AC1_Sign_Up_Account() {
        SignUpPage signUpPage = new SignUpPage(getDriver());
        getDriver().get(baseUrl);
        signUpPage.signUp(user_name, email, password);
    }

    @Test
    public void AC2_Create_Challenge() {
        LoginPage loginPage = new LoginPage(getDriver());
        ChallengePage challengePage = new ChallengePage(getDriver());
        getDriver().get(baseUrl);
        loginPage.login(user_name, password);
    }
}