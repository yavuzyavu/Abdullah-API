package getRequest;

import base_url.ReqresBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Soru6 extends ReqresBaseUrl {
    @Test
    public void test06() {

         /*
       Given
              https://reqres.in/api/unknown/
       When
            I send GET Request to the URL
       Then

            1)Status code is 200
            2)Print all pantone_values
            3)Print all ids greater than 3 on the console
              Assert that there are 3 ids greater than 3
            4)Print all names whose ids are less than 3 on the console
              Assert that the number of names whose ids are less than 3 is 2
    */
        spec.pathParams("first","unknown");

        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        //Do Assertion
        JsonPath jsonPath = response.jsonPath();

        assertEquals(200,response.getStatusCode());

        System.out.println(jsonPath.getList("data.pantone_values"));

        List<Integer> ids = jsonPath.getList("data.findAll{it.id>3}.id");
        System.out.println("ids "+ids);

        assertEquals(3,ids.size());

        List<String> names = jsonPath.getList("data.finAll{it.id<3}.name");
        System.out.println("names :"+names);
        assertEquals(2,names.size());





    }

}
