package getRequest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Odev01 {
    /*
        Given
            https://automationexercise.com/api/brandsList
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be "text/html; charset=utf-8"
        And
            Status Line should be HTTP/1.1 200 OK
        And
             Number of H&M brands must be equal to Polo(H&M marka sayısı Polo marka sayısına eşit olmalı)
*/

    @Test
    public void odev01() {
        String url = "https://automationexercise.com/api/brandsList";

        Response response = given().when().get(url);
        response.prettyPrint();


        //Do Assertion
        response.then().statusCode(200).contentType("text/html; charset=utf-8").statusLine("HTTP/1.1 200 OK");

        List<String> brandList = response.htmlPath().getList("brands.brand");
        int numOfHM = 0;
        int numOfPolu = 0;
        for (String w : brandList) {
            if (w.equals("H&M")){
                numOfHM++;
            }
            if(w.equals("Polo")){
                numOfPolu++;
            }
        }

        assertEquals(numOfHM,numOfPolu);

    }
}
