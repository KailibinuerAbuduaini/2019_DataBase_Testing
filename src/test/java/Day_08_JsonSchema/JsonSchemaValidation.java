package Day_08_JsonSchema;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.testng.Assert.*;

public class JsonSchemaValidation {
    @BeforeClass
    public void setUp(){
        RestAssured.baseURI = ConfigurationReader.get("spartanapi.uri");
    }

    @Test
    public void jsonSchemaValidation(){
        given().accept(ContentType.JSON).pathParam("id",5).when().get("spartans/{id}")
                .then().statusCode(200).body(matchesJsonSchemaInClasspath("SingleSpartanSchema.json"));
    }
}
