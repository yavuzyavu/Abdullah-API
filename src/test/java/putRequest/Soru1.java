package putRequest;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import utilities.JsonPlaceHolderTestData;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class Soru1 extends JsonplaceholderBaseUrl {

    /*
    Given
     1) https://jsonplaceholder.typicode.com/todos/198
     2) {
             "userId": 21,
             "title": "Wash the dishes",
             "completed": false
           }
    When
I send PUT Request to the Url
 Then
      Status code is 200
      And response body is like   {
                   "userId": 21,
                   "title": "Wash the dishes",
                   "completed": false
                  }
 */

    @Test
    public void name() {
        //Set the Url
        spec.pathParams("1","todos","2",198);

        //Set The Expected Data
        JsonPlaceHolderTestData obj = new JsonPlaceHolderTestData();
        Map<String,Object> expectedData = obj.expectedDataMethod(21,"Wash the dishes", false);
        ////Send the Request and Get the Response
        Response response = given().spec(spec).contentType(ContentType.JSON).when().put("/{1}/{2}");
        response.prettyPrint();
    }
}
