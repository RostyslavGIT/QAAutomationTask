package tests;

import api.GetApi;
import entities.LocationData;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ApiTest {
    private static final float CURRENT_LATITUDE = 53.57872116088867f;
    private static final float CURRENT_LONGITUDE = 9.6888633351171875f;


    @Test
    public void verifyLocationData(){
        SoftAssert softAssert = new SoftAssert();
        LocationData location = GetApi.getLocation();
        softAssert.assertEquals(location.getLatitude(),CURRENT_LATITUDE, 0.01, "Latitude assertion failed");
        softAssert.assertEquals(location.getLongitude(),CURRENT_LONGITUDE, 0.01, "Longitude assertion failed");
        softAssert.assertAll();
    }

}
