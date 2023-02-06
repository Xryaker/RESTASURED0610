import apiMethods.GetRestApi;
import data.Exchange;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.http.ContentType;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static specifications.SpecificationsRest.*;

@DisplayName("REST ASSURED TESTS")
public class TestProg {
    @BeforeClass
    public static void bf(){
        setForRickAndMorty(setReqSpecForSimple(), setResSpec());
    }
    static String url = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?valcode=USD&json";

    @DisplayName("GET CURRENT EXCHANGE")
    @Test
    public void simple1() {
        when()
                .get(url)//running  query
                .then().log().all();//write response ALL in console
    }

    @Test
    public void simole2() {
        when()
                .get(url)
                .then().log().body();//only body data
       // Assert.assertEquals("l","jj");
    }

    @Test
    public void simple3() {
        String body = given()
                .when()
                .get(url)
                .then()
                .extract().body().jsonPath().get().toString();//get string from json body
        System.out.println(body);
    }

    @Test
    public void simple4() {
        String body = given()
                .when()
                .contentType(ContentType.JSON)//optionals when we want to get data type JSON
                .get(url)
                .then()
                .extract().body().jsonPath().get().toString();//get string from json body
        System.out.println(body);
    }

    @Test
    public void simple5() {
        List<Exchange> exchange = given()
                .when()
                .get(url)
                .then().log().body()
                .extract().body().jsonPath().getList(".", Exchange.class);//extract data to list<Exchange.class>
    }

    @Test
    public void simple6() {
        System.out.println(GetRestApi.getBodyFromURL(url));
    }
}
