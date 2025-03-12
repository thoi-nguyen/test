package API;

import Core.BaseTestAPI;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class UserTest extends BaseTestAPI {

    @Test
    public void testGetUserSuccessful() {
        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .get("/users/2");

        assertEquals(response.getStatusCode(), 200);
        assertEquals(response.jsonPath().getString("data.id"), "2");
    }

    @Test
    public void testGetUserNotFound() {
        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .get("/users/23");

        assertEquals(response.getStatusCode(), 404);
    }

    @Test
    public void testUpdateUserSuccessful() {
        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body("{\"name\": \"morpheus\", \"job\": \"zion resident\"}")
                .put("/users/2");

        assertEquals(response.getStatusCode(), 200);
        assertEquals(response.jsonPath().getString("name"), "morpheus");
        assertEquals(response.jsonPath().getString("job"), "zion resident");
    }

    @Test
    public void testUpdateUserNotFound() {
        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body("{\"name\": \"morpheus\", \"job\": \"zion resident\"}")
                .put("/users/23");

        assertEquals(response.getStatusCode(), 404);
    }
}