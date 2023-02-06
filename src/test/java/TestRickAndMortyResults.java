import data.Result;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import specifications.SpecificationsRest;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static specifications.SpecificationsRest.*;
@DisplayName("TestRickAndMortyResults")
public class TestRickAndMortyResults {
    static List<Result> resultList;

    @BeforeClass
    public static void bTest() {
        setForRickAndMorty(setReqSpec("https://rickandmortyapi.com/api/"), setResSpec());
        resultList = given().when()
                .get("character")
                .then()
                .extract().body().jsonPath().getList("results", Result.class);
    }

    @Test
    public void testNames() throws Exception {
        List<String> errorUrl = new ArrayList<>();
        for (Result l : resultList) {
            if (Objects.equals(l.name, "Morty Smith")) {
                errorUrl.add(String.valueOf(l.id));
                continue;
            }
            System.out.println(l.name);
        }
        if (errorUrl.size() > 0) {
            throw new Exception("list empty fields NAME id: " + errorUrl);
        }
    }
}
