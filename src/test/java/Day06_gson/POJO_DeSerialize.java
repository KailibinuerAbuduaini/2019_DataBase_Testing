package Day06_gson;

import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.*;

public class POJO_DeSerialize {

    @Test
    public void oneSpartanWithPOJO(){
        Response response = given()
                .accept(ContentType.JSON).pathParam("id",15)
                .when().get("http://54.161.128.36:8000/api/spartans/{id}");

        assertEquals(response.statusCode(),200);
        assertEquals(response.contentType(),"application/json;charset=UTF-8");
        //JSON to My Custom Class (POJO)
        //deserialize json to pojo java object
        //taking response and converting to Spartan object
        Spartan spartan15 = response.body().as(Spartan.class);

        System.out.println("spartan1.toString() = " + spartan15.toString());

        System.out.println("spartan15.getId() = " + spartan15.getId());
        System.out.println("spartan15.getName() = " + spartan15.getName());
        System.out.println("spartan15.getGender() = " + spartan15.getGender());
        System.out.println("spartan15.getPhone() = " + spartan15.getPhone());

        assertEquals(spartan15.getId(),15);
        assertEquals(spartan15.getName(),"Meta");
        assertEquals(spartan15.getGender(),"Female");
        assertEquals(spartan15.getPhone(),new Long(1938695106));
    }


    @Test
    public void regionWithPojo(){


            //request
            Response response = get("http://54.161.128.36:1000/ords/hr/regions");
            assertEquals(response.statusCode(),200);
       //json to Region class
        //Deserialization

        Region regions = response.body().as(Region.class);

        System.out.println(regions.getCount());

        List<Item> regionList =  regions.getItems();
        System.out.println(regionList.get(0).getRegionName());
        System.out.println("regionList.get(1).getRegionId() = " + regionList.get(1).getRegionId());

        System.out.println(regions.getItems().get(0).getRegionName());

        for (Item item : regionList) {
            System.out.println(item.getRegionName());
        }


    }

@Test
    public void GsonExample(){
        Gson gson=new Gson();
    //De-Serialize and serialize with gson object
    //Deseriailze -->JSON TO Java Object

    String myjson = "{\n" +
            "    \"id\": 15,\n" +
            "    \"name\": \"Meta\",\n" +
            "    \"gender\": \"Female\",\n" +
            "    \"phone\": 1938695106\n" +
            "}";

gson.fromJson(myjson,Spartan.class);


//JAVA object to JSON 
    Spartan spartanEU=new Spartan(10,"Mike","Male",5714788554L);
    Object src;
    String jsonSpartanEU=gson.toJson(spartanEU);

    System.out.println("jsonSpartanEU = " + jsonSpartanEU);






}
}


