package apiMethods;

import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;

import java.net.URL;

import static io.restassured.RestAssured.given;

public class GetRestApi {
    @Step(" getBodyFromURL {url}")
    @Description("    public static String getBodyFromURL(String url){\n" +
            "        String body=given()\n" +
            "                .when()\n" +
            "                .contentType(ContentType.JSON)//optionals when we want to get data type JSON\n" +
            "                .get(url)\n" +
            "                .then()\n" +
            "                .extract().body().jsonPath().get().toString();//get string from json body\n" +
            "        return body;" )
    @Attachment
    public static String getBodyFromURL(String url){
        String body=given()
                .when()
                .contentType(ContentType.JSON)//optionals when we want to get data type JSON
                .get(url)
                .then()
                .extract().body().jsonPath().get().toString();//get string from json body
        return body;
    }
    public static String getBodyFromURL(URL url){
        String body=given()
                .when()
                .contentType(ContentType.JSON)//optionals when we want to get data type JSON
                .get(url)
                .then()
                .extract().body().jsonPath().get().toString();//get string from json body
        return body;
    }
}
