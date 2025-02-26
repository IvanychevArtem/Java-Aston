package org.example;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostmanEcho {
    private final String BaseUrl = "https://postman-echo.com";
    private final String bodyTest = "This is expected to be sent back as part of response body.";

    @BeforeEach
    public void before() {
        RestAssured.baseURI = BaseUrl;

    }

        @Test
        void testGetRequest() {
            given()
                    .when()
                    .get("/get?foo1=bar1&foo2=bar2")
                    .then()
                    .statusCode(200)
                    .and().body("args.foo1", is("bar1"))
                    .and().body("args.foo2", is("bar2"));
        }

    @Test
    void testPostRaw() {
        given()
                .body(bodyTest)
                .when() .post("/post")
                .then()
                .statusCode(200)
                .and().body("data", is(bodyTest));

    }

    @Test
    void testPostForm() {
    given()
            .formParam("foo1", "bar1")
            .formParam("foo2", "bar2")
            .header("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8")
            .when().post("/post")
            .then()
            .statusCode(200)
            .and().body("form.foo1", is("bar1"))
            .and().body("form.foo2", is("bar2"));
    }

    @Test
    public void putRequest() {
        given()
                .body(bodyTest)
                .when().put("/put")
                .then()
                .assertThat().statusCode(200)
                .and().body("data", is(bodyTest));
    }

    @Test
    public void patchRequest() {
        given()
                .body(bodyTest)
                .when().patch("/patch")
                .then()
                .assertThat().statusCode(200)
                .and().body("data", is(bodyTest));
    }

    @Test
    public void deleteRequest() {
        given()
                .body(bodyTest)
                .when().delete("/delete")
                .then()
                .assertThat().statusCode(200)
                .and().body("data", is(bodyTest));
    }

}
