package APITesting.com.org.api;
import APITesting.com.org.classes.Posts;
import APITesting.com.org.classes.postprac;
import com.jayway.restassured.RestAssured.*;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.sun.org.apache.regexp.internal.RE;
import org.testng.annotations.Test;
import org.testng.Assert;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.post;

public class JsonServerRequests {

    @Test
    public void Json_01(){

        Response resp= given().
when().get("http://localhost:3000/posts");
        System.out.println("This is the response" +resp.asString());
    }

    @Test
    public void Json_02(){
        Response resp =
        given().
                body("  {\"id\" :\"4\"," +
                                "\"title\":\"this is  title\"" +
                                ", \"auth\":\"Amma\" }").
                when().
                contentType(ContentType.JSON).
                post("http://localhost:3000/posts");

        System.out.println("this is response" +resp.asString());

    }


   // @Test
    public void Json_03() {
        Posts posts = new Posts();
        posts.setId("6");
        posts.setTitle("Post request by object");
        posts.setAuthor("Ammar Ali");
        Response resp=
        given().when()
                .contentType(ContentType.JSON).body(posts)
                .post("http://localhost:3000/posts");
        System.out.println("this is from the object post response" +resp.asString());
    }

   // @Test
    public void Json_04(){

        postprac postprac = new postprac();
        postprac.setId("7");
        postprac.setTitle("This is the post request from my pracpost class");
        postprac.setAuthor("Asad Ali");

        Response resp = given().
                when()
                .contentType(ContentType.JSON).body(postprac).
                        post("http://localhost:3000/posts");
        System.out.println("this is the result from postprac class for practice" +resp.asString());
    }

   // @Test
    public void Json_05(){
        Response resp = given()
                .when()
                .get("http://localhost:3000/posts/4");
        System.out.println("this is the response of id 4" +resp.asString());

    }
    // this is  a put request test using local JSon Server
  //  @Test
    public void Json_06(){

        Posts posts = new Posts();
        posts.setId("4");
        posts.setAuthor("Mir Saab");
        posts.setTitle("Dhoti mai do Moti");

        Response resp = given().
                when().contentType(ContentType.JSON).body(posts).put("http://localhost:3000/posts/4");
        System.out.println("updated put request" +resp.asString());

    }
    // This is a test to try patch
   // @Test
    public void Json_07(){
        Response resp= given().
                body("{\"title\":\"updated by patch\"}").
                when().contentType(ContentType.JSON).patch("http://localhost:3000/posts/4");
        System.out.println("Patch request" +resp.asString());
    }




}
