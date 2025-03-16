package Tests;

import Core.BaseTest;
import POM.LoginPage;
import Provider.LoginDataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test(dataProvider = "loginData", dataProviderClass = LoginDataProvider.class)
    public void loginTest(String username, String password, String successMessage) {
        LoginPage Login = new LoginPage(getDriver());
        getDriver().get(getBaseUrl());
        Login.login(username, password);
        Login.verifyLoginSuccess(successMessage);
    }

    @Test(dataProvider = "loginInvalidData", dataProviderClass = LoginDataProvider.class)
    public void loginTestFail(String username, String password, String failMessage) {
        LoginPage Login = new LoginPage(getDriver());
        getDriver().get(getBaseUrl());
        Login.login(username, password);
        Login.verifyLoginFail(failMessage);
    }
}