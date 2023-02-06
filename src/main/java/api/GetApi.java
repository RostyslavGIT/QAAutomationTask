package api;

import entities.LocationData;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetApi {

    private static String IP = "217.84.62.15";
    private static String ACCESS_KEY = "d146d38e7777faa7a0606aa3ec27bbe2";

    public static LocationData getLocation(){
        LocationData locationData = new LocationData();
        String url = "http://api.ipstack.com/" + IP;
        Response response = given()
                .params("access_key",ACCESS_KEY)
                .get(url);
        response.then().assertThat().statusCode(200);

        JsonPath jsonPath = response.jsonPath();
        locationData.setlLongitude(jsonPath.get("longitude"));
        locationData.setlLatitude(jsonPath.get("latitude"));
        return locationData;
    }
}
