package API;

import Core.BaseTestAPI;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Login extends BaseTestAPI {

    @Test
    public void testLoginSuccessful() {
        Response response = RestAssured
                .given()
                .contentType("application/json")
                .body("{\"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\"}")
                .post("/login");

        assertEquals(response.getStatusCode(), 200);
        assertEquals(response.jsonPath().getString("token"), token);
    }

    @Test
    public void testLoginUnsuccessful() {
        Response response = RestAssured
                .given()
                .contentType("application/json")
                .body("{\"email\": \"peter@klaven\"}")
                .post("/login");

        assertEquals(response.getStatusCode(), 400);
        assertEquals(response.jsonPath().getString("error"), "Missing password");
    }
}