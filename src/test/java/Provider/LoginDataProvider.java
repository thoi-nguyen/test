package Provider;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {
    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][]{
                {"testusername", "testusername", "Successfully logged in"},
        };
    }

    @DataProvider(name = "loginInvalidData")
    public Object[][] loginInvalidData() {
        return new Object[][]{
                {"testusername12", "testusername", "User does not exist for this username\n"},
        };
    }
}