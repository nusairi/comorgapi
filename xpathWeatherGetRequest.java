package APITesting.com.org.api;
import com.jayway.restassured.RestAssured.*;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.Assert;

import static com.jayway.restassured.RestAssured.given;


public class xpathWeatherGetRequest {


   // @Test
    public void Test_08() {

        java.lang.String weatherReport= given().
                param("id", "2172797").
                param("appid", "f3a5332e1a4f8dca5536b965fdf0e52c").
                when().get("http://api.openweathermap.org/data/2.5/weather").
                then().contentType(ContentType.JSON).
                extract().path("weather[0].description");
        System.out.println("weatherReport :"+weatherReport);
    }
    //checking the expected and actual resuts When you are testing the api you need to find expected value from developer than you can compare with actual

   // @Test
    public void Test_09(){

        Response resp =given().
                param("id", "2172797").
                param("appid", "f3a5332e1a4f8dca5536b965fdf0e52c").
                when().get("http://api.openweathermap.org/data/2.5/weather");

        String actualweatherReport= resp.
                then().contentType(ContentType.JSON).extract().path("weather[0].description");


        String expectedweatherReport = "few clouds";
        if(actualweatherReport.equalsIgnoreCase(expectedweatherReport)){

            System.out.println("testcase pass");
        }

        else {
            System.out.println("Test fail");
        }


    }

    @Test
    public void Test_10(){
        //this is the response hitting the api by the given params
        Response resp= given().
                param("id","2172797").
                param("appid","f3a5332e1a4f8dca5536b965fdf0e52c").
                when().
                get("http://api.openweathermap.org/data/2.5/weather");

        // this is getting report by id

        String reportbyID = resp.
                then().
contentType(ContentType.JSON).extract().path("weather[0].description");

        System.out.println("weather description by ID:" +reportbyID);

        String lon =  String.valueOf(resp.
                then().
                contentType(ContentType.JSON).
                extract().
                path("coord.lon"));
        System.out.println("Longitude is :" +lon);


        String lat = String.valueOf(resp.
        then().
        contentType(ContentType.JSON).extract().path("coord.lat"));
        System.out.println("Latitude is :" +lat);


        String reportbycoordinates= given().
                param("lat",lat).
                param("lon",lon).
                param("appid","f3a5332e1a4f8dca5536b965fdf0e52c").
                when().
                get("http://api.openweathermap.org/data/2.5/weather").
           then().contentType(ContentType.JSON).extract().path("weather[0].description");

        System.out.println("weather description by coordinates:" +reportbycoordinates);
        Assert.assertEquals(reportbyID,reportbycoordinates);

//          Assert.assertEquals(reportbyID,reportbycoordinates);

//
//      String lon =  String.valueOf( resp.
//                then().
//contentType(ContentType.JSON).extract().path("coord.lon"));
//
//
//       System.out.println("longitute is", +lon);
//
//        String lat = String.valueOf(resp.then().
//                contentType(ContentType.JSON).extract().path("coor.lat"));
//        System.out.println("latitude is :",+ lat);
//
//
//        String reportbycoordinates= given().
//                param("lat",lat).
//                param("lon",lon).
//                param("appid","f3a5332e1a4f8dca5536b965fdf0e52c").
//                when().
//                get("http://api.openweathermap.org/data/2.5/weather").
//                then().contentType(ContentType.JSON).extract().path("weather[0].description");
//
//        // this is getting report by id
//
//
//        System.out.println("weather description by coordinates:" +reportbycoordinates);
//
//        Assert.assertEquals(reportbyID,reportbycoordinates);

    }

}
