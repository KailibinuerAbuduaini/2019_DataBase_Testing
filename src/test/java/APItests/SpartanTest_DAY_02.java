package APItests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import static org.testng.Assert.*;

import java.io.FilenameFilter;

public class SpartanTest_DAY_02 {
    String spartanAllUrl="http://54.235.231.47:8000/api/spartans";


    @Test
    public void viewAllSpartans(){
        Response response = RestAssured.get(spartanAllUrl);
        //print the status
        System.out.println(response.statusCode());
        //print response body
        System.out.println(response.body().asString());
       //print prettyPrint
        System.out.println(response.body().prettyPrint());
    }

    /* when user send GET request to /api/spartans end point
       Then status code must be 200
       And body should contains Orion
    */
    @Test
    public void viewSpartansTest1(){
        Response response=RestAssured.get(spartanAllUrl);
        Assert.assertEquals(response.statusCode(),200);
        // verify body include orion
        Assert.assertTrue(response.body().asString().contains("Orion"));
    }
  /* Given accept type application/json;

  when user send GET request to /api/spartans end point
        Then status code must be 200
        Then reponse content type must be json
        And body should contains Orion
     */
  @Test
  public void viewSpartansTest2(){

      Response response = RestAssured.given().accept(ContentType.JSON).when().get(spartanAllUrl);
      Assert.assertEquals(response.statusCode(),200);
      Assert.assertEquals(response.contentType(),"application/json;charset=UTF-8");
      Assert.assertTrue(response.body().asString().contains("Orion"));
  }
    //  /* Given accept type applicaton/xml
    //        when user send GET request to /api/spartans end point
    //        Then status code must be 200
    //        And Response Content type must be xml
    //        And body should contains Orion
    //     */

    @Test
    public void viewSpartansTest3(){
      Response response=RestAssured.given().accept(ContentType.XML).when().get(spartanAllUrl);
        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(response.contentType(),"application/xml;charset=UTF-8");
        Assert.assertTrue(response.body().asString().contains("Orion"));
    }

    //  /* Given accept type application/xml
    //        when user send GET request to /api/spartans end point
    //        Then status code must be 200
    //        And Response Content type must be xml
    //     */
    @Test
    public void viewSpartansTest4() {
    //REQUEST START HERE
        given().accept(ContentType.XML).when().get(spartanAllUrl).//REPONSE START HERE
         then().statusCode(200).and().contentType("application/xml;charset=UTF-8");
    }

 /*
        Given the accept type Json
        When I send get request to /api/spartans/3
        Then status code must be 200
        And Content type should be json
        and body should contains Fidole
     */
 @Test
 public void viewSpartansTest5() {


     Response response = given().accept(ContentType.JSON).when().get(spartanAllUrl + "/3");
     assertEquals(response.statusCode(), 200);
     assertEquals(response.contentType(), "application/json;charset=UTF-8");
     assertTrue(response.body().asString().contains("Fidole"));
 }



    /*
        Given the accept type XML
        When I send get request to /api/spartans/3
        Then status code must be 406
     */

    @Test
    public void negativeContentType(){

        Response response = given().accept(ContentType.XML)
                .when().get(spartanAllUrl + "/3");

        assertEquals(response.getStatusCode(),406);

    }



 }

