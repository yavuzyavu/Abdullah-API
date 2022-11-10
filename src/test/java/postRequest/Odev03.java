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

public class Odev03 extends ReqresBaseUrl {
    @Test
    public void odev03Map() {

    spec.pathParams("1","users","2",2);

    //Set the expectedData
        ReqresInTestData obj = new ReqresInTestData();
        Map<String,String> expectedData = obj.expectedDataMethod("morpheus","zion president");
        System.out.println("expectedData = " + expectedData);

         //request Response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).
                when().put("/{1}/{2}");
        response.prettyPrint();

        //do assertion
        Map<String,String> actualData = response.as(HashMap.class);
        System.out.println("actualData = " + actualData);
                assertEquals(200,response.statusCode());
                assertEquals(expectedData.get("name"),actualData.get("name"));
                assertEquals(expectedData.get("jop"),actualData.get("jop"));
    }

    @Test
    public void odev03Pojo() {

        //Set the url
        spec.pathParams("first","users","second",2);

        //set the expected data
        Odev2Pojo expectedData = new Odev2Pojo("morpheus","zion president");
        System.out.println("expectedData = " + expectedData);

        //Send the put request and get the response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().put("/{first}/{second}");

        //Do Assertion
        Odev2Pojo actualData = response.as(Odev2Pojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getName(),actualData.getName());
        assertEquals(expectedData.getJop(),actualData.getJop());
    }
}

