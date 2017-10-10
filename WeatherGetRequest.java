package APITesting.com.org.api;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.jayway.restassured.response.Response;
import com.sun.org.apache.regexp.internal.RE;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.jayway.restassured.RestAssured.*;

public class WeatherGetRequest {


    //Simple get request for getting weather request by City
    //Status Code :200
    //@Test
    public void Test_01(){

        Response resp= when().get("http://api.openweathermap.org/data/2.5/weather?q=London&appid=f3a5332e1a4f8dca5536b965fdf0e52c");

       System.out.println(resp.getStatusCode());
        Assert.assertEquals(resp.getStatusCode(),200);
    }

    //Status Code :401
 //   @Test
    public void Test_02(){

        Response resp= when().get("http://api.openweathermap.org/data/2.5/weather?q=London&appid=f3a5332e1a4f8dca5536b965fdf0ec");

        System.out.println(resp.getStatusCode());
        Assert.assertEquals(resp.getStatusCode(),200);
    }

    // How To Use Parameters with rest assured
    //@Test
     public void Test_03(){
        Response resp= given().
                        param("q","London").
                param("appid","f3a5332e1a4f8dca5536b965fdf0e52c").
                when().get("http://api.openweathermap.org/data/2.5/weather")       ;
       System.out.println(resp.getStatusCode());
       Assert.assertEquals(resp.getStatusCode(),200);

       if(resp.getStatusCode()==200){System.out.println("API is Working Fine");
       }
       else {
           System.out.println("API is broken");
       }

    }

    // Assert our testcase in Rest Assured api
    //@Test
    public void Test_04(){
         given().
                 param("q","London").
                 param("appid","f3a5332e1a4f8dca5536b965fdf0e52c").
                 when().get("http://api.openweathermap.org/data/2.5/weather").
                 then().
                 assertThat().statusCode(200);


    }
    //@Test
    public void Test_05(){

        Response resp= given().
                param("q","London").
                param("appid","f3a5332e1a4f8dca5536b965fdf0e52c").
                when().get("http://api.openweathermap.org/data/2.5/weather");

        System.out.println(resp.asString());

    }

//@Test
    public void Test_06(){

        Response resp= given().
              parameter("id","2172797").
                param("appid", "f3a5332e1a4f8dca5536b965fdf0e52c").
                get("http://api.openweathermap.org/data/2.5/weather");

        Assert.assertEquals(resp.getStatusCode(),200);
System.out.println(resp.asString());
    }

    @Test
    public void Test_07(){

        Response resp= given().
                param("zip", "94040").
                param("appid","f3a5332e1a4f8dca5536b965fdf0e52c").
                get("http://api.openweathermap.org/data/2.5/weather");
        Assert.assertEquals(resp.getStatusCode(),200);
        System.out.println(resp.asString());
    }





}
