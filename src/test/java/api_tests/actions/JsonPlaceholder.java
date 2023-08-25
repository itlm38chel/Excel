package api_tests.actions;

import api_tests.test.JsonTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

import static io.restassured.RestAssured.given;

public class JsonPlaceholder {


    public List<JsonTest.PostClass> posts(String url) throws JsonProcessingException {
        String response = given()
                .baseUri(url)
                .basePath("/posts")
                .when()
                .get()
                .then()
                .extract()
                .response().asString();
        ObjectMapper objectMapper = new ObjectMapper();
        List<JsonTest.PostClass> JsonPost = objectMapper.readValue(response, objectMapper.getTypeFactory().constructParametricType(List.class, JsonTest.PostClass.class));
        return JsonPost;
    }

    public List<JsonTest.CommentClass> comments(String url) throws JsonProcessingException {
        String response = given()
                .baseUri(url)
                .basePath("/comments")
                .when()
                .get()
                .then()
                .extract()
                .response().asString();
        ObjectMapper objectMapper = new ObjectMapper();
        List<JsonTest.CommentClass> JsonComment = objectMapper.readValue(response, objectMapper.getTypeFactory().constructParametricType(List.class, JsonTest.CommentClass.class));
        return (JsonComment);
    }

    public List<JsonTest.AlbumClass> albums(String url)  throws JsonProcessingException {
        String response = given()
                .baseUri(url)
                .basePath("/albums")
                .when()
                .get()
                .then()
                .extract()
                .response().asString();
        ObjectMapper objectMapper = new ObjectMapper();
        List<JsonTest.AlbumClass> JsonComment = objectMapper.readValue(response, objectMapper.getTypeFactory().constructParametricType(List.class, JsonTest.AlbumClass.class));
        return (JsonComment);
    }

    public List<JsonTest.PhotoClass>  photos(String url)   throws JsonProcessingException {
        String response = given()
                .baseUri(url)
                .basePath("/photos")
                .when()
                .get()
                .then()
                .extract()
                .response().asString();
        ObjectMapper objectMapper = new ObjectMapper();
        List<JsonTest.PhotoClass> JsonComment = objectMapper.readValue(response, objectMapper.getTypeFactory().constructParametricType(List.class, JsonTest.PhotoClass.class));
        return (JsonComment);
    }

}