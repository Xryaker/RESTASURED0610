package specifications;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecificationsRest {
    public static RequestSpecification setReqSpec(String url){
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .setContentType(ContentType.JSON)
                .addFilter(new AllureRestAssured())
                .build();
    }
    public static RequestSpecification setReqSpecForSimple(){
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addFilter(new AllureRestAssured())
                .build();
    }
    public static ResponseSpecification setResSpec(){
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }
    public static  void setForRickAndMorty(RequestSpecification rickAndMortyRequest,ResponseSpecification rickANDMortyresponse){
        RestAssured.requestSpecification=rickAndMortyRequest;
        RestAssured.responseSpecification=rickANDMortyresponse;
    }
}
