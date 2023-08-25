package api_tests.actions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.util.List;

import static io.restassured.RestAssured.given;

public class JsonPlaceholder {


    public List<PostClass> posts(String url) throws JsonProcessingException {
        String response = given()
                .baseUri(url)
                .basePath("/posts")
                .when()
                .get()
                .then()
                .extract()
                .response().asString();
        ObjectMapper objectMapper = new ObjectMapper();
        List<PostClass> JsonPost = objectMapper.readValue(response, objectMapper.getTypeFactory().constructParametricType(List.class, PostClass.class));
        return JsonPost;
    }

    public List<CommentClass> comments(String url) throws JsonProcessingException {
        String response = given()
                .baseUri(url)
                .basePath("/comments")
                .when()
                .get()
                .then()
                .extract()
                .response().asString();
        ObjectMapper objectMapper = new ObjectMapper();
        List<CommentClass> JsonComment = objectMapper.readValue(response, objectMapper.getTypeFactory().constructParametricType(List.class, CommentClass.class));
        return (JsonComment);
    }

    public List<AlbumClass> albums(String url)  throws JsonProcessingException {
        String response = given()
                .baseUri(url)
                .basePath("/albums")
                .when()
                .get()
                .then()
                .extract()
                .response().asString();
        ObjectMapper objectMapper = new ObjectMapper();
        List<AlbumClass> JsonComment = objectMapper.readValue(response, objectMapper.getTypeFactory().constructParametricType(List.class, AlbumClass.class));
        return (JsonComment);
    }

    public List<PhotoClass>  photos(String url)   throws JsonProcessingException {
        String response = given()
                .baseUri(url)
                .basePath("/photos")
                .when()
                .get()
                .then()
                .extract()
                .response().asString();
        ObjectMapper objectMapper = new ObjectMapper();
        List<PhotoClass> JsonComment = objectMapper.readValue(response, objectMapper.getTypeFactory().constructParametricType(List.class, PhotoClass.class));
        return (JsonComment);
    }

    @Data
    public static class PostClass {
        private Integer userId;
        private Integer id;
        private String title;
        private String body;
    }
    @Data
    public static class CommentClass {
        private Integer postId;
        private Integer id;
        private String name;
        private String email;
        private String body;
    }
    @Data
    public static class AlbumClass {
        private Integer userId;
        private Integer id;
        private String title;
    }
    @Data
    public static class PhotoClass {
        private Integer albumId;
        private Integer id;
        private String title;
        private String url;
        private String thumbnailUrl;
    }
}