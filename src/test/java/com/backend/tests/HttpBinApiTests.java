package com.backend.tests;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.when;

import org.junit.Test;

public class HttpBinApiTests {

    public static String originData = "109.124.12.97, 109.124.12.97";
    public static String urlDataGet = "https://httpbin.org/get";
    public static String urlDataPost = "https://httpbin.org/post";
    public static String urlDataPut = "https://httpbin.org/put";
    public static String stringText = "My string text";
    public static String newData = "New data in JSON";

    /**
     * Позитивный тест (description = "GET").
     */
    @Test
    public void testHttpBinOnlineGet() {
        when().get("http://httpbin.org/get")
                .then().log().body()
                .assertThat().statusCode(HttpStatus.SC_OK).and()
                .body("origin", Matchers.equalTo(originData)).and()
                .body("url", Matchers.equalTo(urlDataGet));
    }

    /**
     * Позитивный тест (description = "POST").
     */
    @Test
    public void testHttpBinOnlinePost() {
        given().log().body()
                .contentType("application/json").body(stringText)
                .when().post("http://httpbin.org/post")
                .then().log().body()
                .assertThat().statusCode(HttpStatus.SC_OK).and()
                .body("data", Matchers.equalTo(stringText)).and()
                .body("json", Matchers.equalTo(null)).and()
                .body("origin", Matchers.equalTo(originData)).and()
                .body("url", Matchers.equalTo(urlDataPost));
    }

    /**
     * Позитивный тест (description = "PUT").
     */
    @Test
    public void testHttpBinOnlinePut() {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        // JSONObject requestBody = new JSONObject();
        // requestBody.put("newData", newData);
        // requestBody.put("nameData", nameData);
        // requestBody.put("phoneData", phoneData);
        // request.body(requestBody);
        request.body(newData);
        request.when().put("http://httpbin.org/put")
                .then().log().body()
                .assertThat().statusCode(HttpStatus.SC_OK).and()
                .body("data", Matchers.equalTo(newData)).and()
                .body("json", Matchers.equalTo(null)).and()
                .body("origin", Matchers.equalTo(originData)).and()
                .body("url", Matchers.equalTo(urlDataPut));
    }


}
