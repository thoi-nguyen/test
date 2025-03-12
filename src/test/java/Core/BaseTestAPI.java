package Core;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;

public class BaseTestAPI {
    protected String token;

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "https://reqres.in/api";
        token = getToken();
    }

    private String getToken() {
        Response response = RestAssured
                .given()
                .contentType("application/json")
                .body("{\"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\"}")
                .post("/login");

        return response.jsonPath().getString("token");
    }
}