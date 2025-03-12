package Tests;

import Core.BaseTest;
import POM.ChallengePage;
import POM.LoginPage;
import POM.SignUpPage;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    // Generate random data to user
    Faker faker = new Faker();
    String user_name = faker.name().firstName()+ faker.name().lastName();
    String password = faker.internet().password();
    String email = faker.internet().emailAddress();

    // Generate random data to challenge
    String title = faker.book().title();
    String flag = String.format("CTFlearn{4m_%s}", faker.lorem().characters(5));;
    String file = System.getProperty("user.dir") + "/fixtures/new-img.jpeg";
    String description = faker.lorem().sentence();
    String howtosolve = faker.lorem().paragraph();



    @Test
    public void AC1_Sign_Up_Account() {
        SignUpPage signUpPage = new SignUpPage(getDriver());
        getDriver().get(getBaseUrl());
        signUpPage.signUp(user_name, email, password);
        System.out.println("User Name: " + user_name);
        System.out.println("Password: " + password);
    }

    @Test
    public void AC2_Create_Challenge() {
        ChallengePage challengePage = new ChallengePage(getDriver());
        getDriver().get(getBaseUrl());
        challengePage.navigateToCreateChallenge();
        challengePage.createChallenge(title, flag, file, description, howtosolve);
        challengePage.viewMyChallenge(user_name, title);
    }
}