package getRequest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Soru1 {
    /*
   Given
       https://reqres.in/api/users/3
   When
       User sends a GET Request to the url
   Then
       HTTP Status Code should be 200
   And
       Content Type should be JSON
   And
       Status Line should be HTTP/1.1 200 OK
*/

    @Test
    public void test01() {
        String url = "https://reqres.in/api/users/3";
        Response response = given().when().get(url);
        response.prettyPrint();
        response.then().statusCode(200).contentType(ContentType.JSON).statusLine("HTTP/1.1 200 OK");
    }
}
