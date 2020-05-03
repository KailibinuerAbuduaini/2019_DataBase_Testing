package APItests;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;

import io.restassured.RestAssured;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;



public class homeWork_3 {

@BeforeClass

    public void setUpClass(){
    RestAssured.baseURI= ConfigurationReader.get("uinames.uri");
}
@Test
    public void  NoParamsTest(){
    /*
  Send a get request without providing any parameters
   Verify status code 200, content type application/json; charset=utf-8
   Verify that name, surname, gender, region fields have value
     */


    given().accept(ContentType.JSON).when().get()
            .then().assertThat().statusCode(200)
            .and().contentType("application/json; charset=utf-8").and()
            .body("name",is(notNullValue()),"surname",is(notNullValue()),
                    " gender",is(notNullValue()),"region",is(notNullValue()));


}
    @Test
    public void GenderTest(){
    /*
           Create a request by providing query parameter: gender, male or female
          Verify status code 200, content type application/json; charset=utf-8
          Verify that value of gender field is same from step 1
     */

    given().accept(ContentType.JSON).queryParam("gender","female")
            .when().get().then().assertThat().statusCode(200)
            .and().contentType("application/json; charset=utf-8").and().body("gender",equalTo("female"));
}

@Test
    public void TwoParamsTest(){
    /*
 Create a request by providing query parameters: a valid region and gender
NOTE: Available region values are given in the documentation
2. Verify status code 200, content type application/json; charset=utf-8
3. Verify that value of gender field is same from step 1
4. Verify that value of region field is same from step
     */
    given().accept(ContentType.JSON).queryParam("region","germany").queryParam("gender","female")
            .when().get().then().assertThat().statusCode(200).contentType("application/json; charset=utf-8")
            .and().body("gender",equalTo("female"),"region",equalTo("Germany"));
}


@Test
    public void InvalidGenderTest(){
    /*
    Create a request by providing query parameter: invalid gender
    Verify status code 400 and status line contains Bad Request
    Verify that value of error field is Invalid gender
     */

    given().accept(ContentType.JSON).queryParam("gender","felmale")
            .when().get().then().assertThat().statusCode(400)
            .and().statusLine(containsString("Bad Request")).contentType("application/json; charset=utf-8")
            .and().body("error",equalTo("Invalid gender"));
}



@Test
    public void InvalidRegionTest(){
    /*
 Create a request by providing query parameter: invalid region
 Verify status code 400 and status line contains Bad Request
Verify that value of error field is Region or language not found
     */
             given().accept(ContentType.JSON).queryParam("region","wladd").when().get()
            .then().assertThat().statusCode(400).and().statusLine(containsString("Bad Request"))
            .and().body("error",equalTo("Region or language not found"));


}

@Test
    public void AmountAndRegionsTest() {
    /*
    1. Create request by providing query parameters: a valid region and amount (must be bigger than 1)
    2. Verify status code 200, content type application/json; charset=utf-8
    3. Verify that all objects have different name+surname combination
     */
    Response response =
            given().accept(ContentType.JSON).queryParam("region", "Germany")
                    .queryParam("amount", "20").when().get();

    response.then().assertThat().statusCode(200).and().contentType("application/json; charset=utf-8");
    List<String> names = response.path("name");
    List<String> surname = response.path("surname");
    List<String> fullname = new ArrayList<String>();
    for (int i = 0; i <fullname.size(); i++) {
        fullname.add(names.get(i) + " " + surname.get(i));
    }
    int unique = 0;
    for (int i = 0; i < fullname.size()-1; i++) {
        for (int j = i + 1; j < fullname.size(); j++) {
            if (fullname.get(i).equals(fullname.get(j))) {
                unique++;
            }
        }
    }
    assertEquals(unique, 0);
}

    @Test
    public void ParamsTest(){
     /*
        1. Create a request by providing query parameter: amount (must be bigger than 1)
        2. Verify status code 200, content type application/json; charset=utf-8
        3. Verify that number of objects returned in the response is same as the amount passed in step 1

     */
     Response response=given().accept(ContentType.JSON).queryParam("amount","5").when().get();
     response.then().assertThat().statusCode(200).contentType("application/json; charset=utf-8").
             and().body("gender",hasItem("male"),"region","Germany");


    }

    @Test
    public void AmountCountTest(){
    /*
    1. Create a request by providing query parameter: amount (must be bigger than 1)
    2. Verify status code 200, content type application/json; charset=utf-8
    3. Verify that number of objects returned in the response is same as the amount passed in step 1
     */

    Response response=given().accept(ContentType.JSON).queryParam("amount","20").when().get();
    response.then().assertThat().statusCode(200).contentType("application/json; charset=utf-8");
    List<Object> names=response.path("name");
    assertEquals(names.size(),20);
    }
}





