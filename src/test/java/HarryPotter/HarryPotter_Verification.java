package HarryPotter;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HarryPotter_Verification {
    /*
Verify sorting hat
1. Send a get request to /sortingHat. Request includes :
2. Verify status code 200, content type application/json; charset=utf-8
3. Verify that response body contains one of the following houses:
"Gryffindor", "Ravenclaw", "Slytherin", "Hufflepuff"
     */

  String key="$2a$10$KZ52.73agnWBlQ4uPl8flughiMEhv2QsMHt3XaPNSIbfi.3SC0C72";
  @BeforeClass
    public void setUpClass(){
      RestAssured.baseURI= ConfigurationReader.get("harryPotterApiUrl");

  }
@Test
    public void VerifySortingHat(){

    Response response=given().accept(ContentType.JSON).when().get("sortingHat");
               response.then().assertThat().statusCode(200).
               and().contentType("application/json; charset=utf-8");
       String[] list={"\"Gryffindor\"","\"Ravenclaw\"","\"Slytherin\"","\"Hufflepuff\""};

       List<String> expectedList= Arrays.asList(list);

      assertTrue(expectedList.contains(response.body().asString()));


}

@Test
    public void VerifyBadKey(){
      /*
      1. Send a get request to /characters. Request includes :
      • Header Accept with value application/json
      • Query param key with value invalid
      2. Verify status code 401, content type application/json; charset=utf-8
      3. Verify response status line include message Unauthorized
      4. Verify that response body says "error": "API Key Not Found"
       */
      Response response=given().accept(ContentType.JSON).and().header("Accept","application/json")
              .queryParam("key","5694").when().get("characters");

              response.then().assertThat().statusCode(401).and().contentType("application/json; charset=utf-8");
              assertTrue(response.statusLine().contains("Unauthorized"));
              assertEquals(response.body().path("error"),"API Key Not Found");

}

@Test
    public void verifyNoKey(){
      /*
      Verify no key
      1. Send a get request to /characters. Request includes :
      • Header Accept with value application/json
      2. Verify status code 409, content type application/json; charset=utf-8
      3. Verify response status line include message Conflict
      4. Verify that response body says "error": "Must pass API key for request"
       */
    Response response=given().accept(ContentType.JSON)
        . when().get("characters");
         response.then().assertThat().statusCode(409).and().contentType("application/json; charset=utf-8");
         assertTrue(response.statusLine().contains("Conflict"));
         assertEquals(response.body().path("error"),"Must pass API key for request");

}

@Test
    public void VerifyNumberofCharacters(){
      /*
      1. Send a get request to /characters. Request includes :
          Header Accept with value application/json
           Query param key with value {{apiKey}}
           2. Verify status code 200, content type application/json; charset=utf-8
           3. Verify response contains 194 characters
       */

      Response response=given().accept(ContentType.JSON)
              .and().header("Accept","application/json")
              .queryParam("key",key).when().get("characters/");
               response.then().assertThat().statusCode(200)
              .contentType("application/json; charset=utf-8");
    //to create List of Character use this method. more info https://github.com/google/gson/blob/master/UserGuide.md
    // or watch this video https://www.youtube.com/watch?v=ZZddxpxGQPE&list=PLpUMhvC6l7AOy4UEORSutzFus98n-Es_l&index=3

    String bodyString = response.body().asString();
    Type CharacterListType = new TypeToken<ArrayList<Character>>() {}.getType();
    List<Character> characterList=new Gson().fromJson(bodyString,CharacterListType);
    //this method gives us size of characters but not gives object
    List<Character> characters=response.body().as(List.class);
    System.out.println("characters.size() = " + characters.size());
    System.out.println("characters = " + characters);
    //like this we can not reach directly object of list
    //it gives java.lang.ClassCastException: class java.util.LinkedHashMap cannot be cast to class
    //System.out.println("characters.get(0).toString() = " + characters.get(0).toString());
    //System.out.println("characterList.size() = " + characterList.size());
    assertEquals(characterList.size(),195);


}

    @Test
    public void Verify_number_of_characters() {
        Response response = given().accept(ContentType.JSON).queryParam("key",key).get("characters/");
        assertEquals(response.statusCode(),200);
        assertEquals(response.contentType(),"application/json; charset=utf-8");
        Character character=response.body().as((Type) Character[].class);
        System.out.println(character.getName().toString());
//        System.out.println("character.getId().toString() = " + character.getId().toString());
        System.out.println("character.getName().toString() = " + character.getName().toString());
//        System.out.println(response.body().path("_id[10]").toString());
    }

@Test
    public void VerifyIdandHouse(){
      /*
      1. Send a get request to /characters. Request includes :
       • Header Accept with value application/json
      • Query param key with value {{apiKey}}
      2. Verify status code 200, content type application/json; charset=utf-8
      3. Verify all characters in the response have id field which is not empty
      4. Verify that value type of the field dumbledoresArmy is a boolean in all characters in the response
      5. Verify value of the house in all characters in the response is one of the following:
       "Gryffindor", "Ravenclaw", "Slytherin", "Hufflepuff"
       */
    }

}
