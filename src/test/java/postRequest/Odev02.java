package postRequest;

import base_url.ReqresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.Odev2Pojo;
import utilities.ReqresInTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Odev02 extends ReqresBaseUrl {

   /* Map ve Pojo Class ile ayrı ayrı yapınız.

        Given
            1) https://reqres.in/api/users
            2) {
                "name": "morpheus",
                "job": "leader"
                }
        When
            I send POST Request to the Url
        Then
            Status code is 201
            And response body should be like {
                                                "name": "morpheus",
                                                "job": "leader",
                                                "id": "496",
                                                "createdAt": "2022-10-04T15:18:56.372Z"

 */

    @Test
    public void odev02() {

        //Set the url
        spec.pathParams("first", "users");

        // Set the expectedData
        Odev2Pojo expectedData = new Odev2Pojo("morpheus", "leader", "2022-10-04T15:18:56.372Z");

        //request response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("first");
        response.prettyPrint();

        //do Assert
        Odev2Pojo actualData = response.as(Odev2Pojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(201, response.getStatusCode());
        assertEquals(expectedData.getName(), actualData.getName());
        assertEquals(expectedData.getJop(), actualData.getJop());

    }

    @Test
    public void odev2Map() {

        //Set The URL
        spec.pathParams("first","users");

        //Set the expectedData
        ReqresInTestData obj = new ReqresInTestData();
        Map<String,String> expectedData = obj.expectedDataMethod("marpheus","leader");
        System.out.println("expectedData = " + expectedData);

        //Request response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).
                when().post("/{first}");
        response.prettyPrint();

        //Do assert
        Map<String,String> actualData = response.as(HashMap.class);

        assertEquals(201,response.statusCode());
        assertEquals(expectedData.get("name"),actualData.get("name"));
        assertEquals(expectedData.get("jop"),actualData.get("jop"));


    }
}
