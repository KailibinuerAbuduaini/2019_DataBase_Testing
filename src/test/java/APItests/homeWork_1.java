package APItests;

import io.restassured.RestAssured;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;


import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;


public class homeWork_1 {

    @BeforeClass
    public void setUpClass(){
        RestAssured.baseURI = ConfigurationReader.get("spartanapi.uri");

    }


    @Test
    public void  getCountriesWithPath() {
        /*
        Given accept type is Json
- Path param value- US
- When users sends request to /countries
- Then status code is 200
- And Content - Type is Json
- And country_id is US
- And Country_name is United States of America
- And Region_id is 2
         */

        given().accept(ContentType.JSON).pathParam("country_id", "US").
                    when().get("/countries/{country_id}").then().assertThat()
                .statusCode(200).and().assertThat().contentType("application/json")
                .and().body("country_id",equalTo("US"),"country_name",
                equalTo("United States of America"),"region_id",equalTo(2));

    }
@Test
    public void getEmployeesWithParam(){
       /*
- Given accept type is Json
- Query param value - q={"department_id":80}
- When users sends request to /employees
- Then status code is 200
- And Content - Type is Json
- And all job_ids start with 'SA'
- And all department_ids are 80
- Count is 25
 */



  given().accept(ContentType.JSON).queryParam("q","{\"department_id\":80}")
            .when().get("/employees").then().assertThat().statusCode(200)
          .and().contentType("application/json")
          .and()
          .body("items.job_id",hasItem(startsWith("SA")),
          "items.department_id",hasItem(80),
          "count",equalTo(25));



}

@Test
    public void requestToCountry(){
        /*
        - Given accept type is Json
-Query param value q= region_id 3
- When users sends request to /countries
- Then status code is 200
- And all regions_id is 3
- And count is 6
- And hasMore is false
- And Country_name are;
Australia,China,India,Japan,Malaysia,Singapore
         */

   given().accept(ContentType.JSON).queryParam("q","{\"region_id\": 3}")

           .when().get("/countries").then().assertThat().statusCode(200)
           .and().contentType("application/json")
           .and().body("items.region_id",hasItem(3),"count",equalTo(6),
           "hasMore",equalTo(false),
           "items.country_name",hasItems("Australia","China","India","Japan","Malaysia","Singapore"));




}
}
