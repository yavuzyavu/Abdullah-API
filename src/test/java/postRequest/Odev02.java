package postRequest;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Odev02 {

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

        String url = "https://reqres.in/api/users";
        Response response = given().when().post(url);
        response.prettyPrint();




    }
}
