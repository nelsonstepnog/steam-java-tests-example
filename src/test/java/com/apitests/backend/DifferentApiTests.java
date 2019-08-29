package com.apitests.backend;

import com.jayway.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.json.JSONException;
import org.junit.Assert;

import static com.jayway.restassured.RestAssured.when;

import org.junit.Test;

public class DifferentApiTests {

    @Test
    public void testApiGithubOnline() {
        when().get("https://api.github.com/users/maxkolotilkin")
                .then().statusCode(200);
    }

    /**
     * Позитивный тест (description = "GET").
     */
    @Test
    public void getGithubExampleTest() throws JSONException {
        // curl https://api.github.com/users/maxkolotilkin
        // Keys:
        String login = "login";
        String id = "id";
        String node_id = "node_id";
        String avatar_url = "avatar_url";
        String gravatar_id = "gravatar_id";
        // Expected data:
        String loginData = "maxkolotilkin";
        int idData = 23308668;
        String nodeIdData = "MDQ6VXNlcjIzMzA4NjY4";
        String avatarUrlData = "https://avatars2.githubusercontent.com/u/23308668?v=4";
        String gravatarIdData = "";
        // Actual data from JSON:
        RestAssured.given()
                .baseUri("https://api.github.com")
                .basePath("/users/maxkolotilkin")
                .log().everything()
                .contentType(String.valueOf(ContentType.JSON))
                .body("{\n" +
                        " " + login + "       : " + loginData + ",\n" +
                        " " + id + "          : " + idData + ",\n" +
                        " " + node_id + "     : " + nodeIdData + ",\n" +
                        " " + avatar_url + "  : " + avatarUrlData + ",\n" +
                        " " + gravatar_id + " : " + gravatarIdData + ",\n" +
                        "}")
                .when().get().then()
                .statusCode(200)
                .body(login, Matchers.equalTo(loginData)).and()
                .body(id, Matchers.equalTo(idData)).and()
                .body(node_id, Matchers.equalTo(nodeIdData)).and()
                .body(avatar_url, Matchers.equalTo(avatarUrlData)).and()
                .body(gravatar_id, Matchers.equalTo(gravatarIdData)).and();
    }

    /**
     * Позитивный тест (description = "POST").
     */
    @Test
    public void postRequestExampleTest() {
        int rnd = 5 + (int) (Math.random() * ((7777777 - 55555) + 1));
        String someRandomString = "MyRandomString" + rnd;
        JSONObject requestBody = new JSONObject();
        requestBody.put("FirstName", someRandomString);
        requestBody.put("LastName", someRandomString);
        requestBody.put("UserName", someRandomString);
        requestBody.put("Password", someRandomString);
        requestBody.put("Email", someRandomString + "@gmail.com");
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.body(requestBody.toString());
        Response response = request.post("http://restapi.demoqa.com/customer/register");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(201, statusCode);
        String successCode = response.jsonPath().get("SuccessCode");
        String message = response.jsonPath().get("Message");
        Assert.assertEquals("OPERATION_SUCCESS", successCode);
        Assert.assertEquals("Operation completed successfully", message);
        System.out.println(response.getBody().asString());
        System.out.println("My random string was: " + someRandomString);
    }
}
