package getRequest;

import base_url.RestfulBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasLength;
import static org.junit.Assert.*;
import org.junit.Test;

import static io.restassured.RestAssured.given;



public class Soru4 extends RestfulBaseUrl {

    /*
    Given
        https://restful-booker.herokuapp.com/booking?firstname=Almedin&lastname=Alikadic
    When
        User sends get request to the URL
    Then
        Status code is 200
And
   Among the data there should be someone whose firstname is "Almedin" and lastname is "Alikadic"

 */

    @Test
    public void test04() {
        spec.pathParams("first","booking").queryParams("firstname","Almedin","lastname","Alikadic");

        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        response.then().statusCode(200).contentType(ContentType.JSON);
        assertTrue(response.asString().contains(" "));
       // response.then().body(String.valueOf(response.asString().replaceAll( "\\s","").length()),hasLength(2));

    }
}
