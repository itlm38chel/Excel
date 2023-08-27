package api_tests.actions;

import api_tests.pojo.Album;
import api_tests.pojo.Comment;
import api_tests.pojo.Photo;
import api_tests.pojo.Post;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

import static io.restassured.RestAssured.given;

public class JsonPlaceholder {
    public List<Post> posts(String url) throws JsonProcessingException {
        String response = given()
                .baseUri(url)
                .basePath("/posts")
                .when()
                .get()
                .then()
                .extract()
                .response().asString();
        ObjectMapper objectMapper = new ObjectMapper();
        JavaType post = objectMapper.getTypeFactory().constructParametricType(List.class, Post.class);
        List<Post> JsonPost = objectMapper.readValue(response, post);
        return JsonPost;
    }

    public List<Comment> comments(String url) throws JsonProcessingException {
        String response = given()
                .baseUri(url)
                .basePath("/comments")
                .when()
                .get()
                .then()
                .extract()
                .response().asString();
        ObjectMapper objectMapper = new ObjectMapper();
        JavaType comment = objectMapper.getTypeFactory().constructParametricType(List.class, Comment.class);
        List<Comment> JsonComment = objectMapper.readValue(response, comment);
        return JsonComment;
    }

    public List<Album> albums(String url) throws JsonProcessingException {
        String response = given()
                .baseUri(url)
                .basePath("/albums")
                .when()
                .get()
                .then()
                .extract()
                .response().asString();
        ObjectMapper objectMapper = new ObjectMapper();
        JavaType album = objectMapper.getTypeFactory().constructParametricType(List.class, Album.class);
        List<Album> JsonComment = objectMapper.readValue(response, album);
        return (JsonComment);
    }

    public List<Photo> photos(String url) throws JsonProcessingException {
        String response = given()
                .baseUri(url)
                .basePath("/photos")
                .when()
                .get()
                .then()
                .extract()
                .response().asString();
        ObjectMapper objectMapper = new ObjectMapper();
        JavaType photo = objectMapper.getTypeFactory().constructParametricType(List.class, Photo.class);
        List<Photo> JsonComment = objectMapper.readValue(response, photo);
        return (JsonComment);
    }

}