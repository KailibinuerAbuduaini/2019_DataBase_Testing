package APItests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;

import static org.testng.Assert.*;

public class HRAPItest_DAY_03 {

    //TASK
    /*
        Create a new class HRApiTests
        create a @Test getALLRegionsTest
        send a get request to AllRegions API endpoint
        -print status code
        -print content type
        -pretty print response JSON
        verify that status code is 200
        verify that content type is "application/json"
        verify that json response body contains "Americas"
        verify that json response body contains "Europe"
        *try to use static imports for both RestAssured and testng
        *store response inside the Response type variable
     */
    @Test
    public void getAllRegions(){
        String hrbaseurl="http://54.235.231.47:1000/ords/hr";
        Response response = when().get(hrbaseurl + "/regions");
        System.out.println("statusCode"+response.statusCode());
        System.out.println("content type"+response.contentType());
        System.out.println(response.prettyPrint());

        assertEquals(response.statusCode(),200);
        assertEquals(response.contentType(),"application/json");
        assertTrue(response.body().asString().contains("Europe"));
        assertTrue(response.asString().contains("Americas"));



    }

}
