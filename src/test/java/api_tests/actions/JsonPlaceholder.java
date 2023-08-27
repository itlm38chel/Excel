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
        JavaType Post = objectMapper.getTypeFactory().constructParametricType(List.class, Post.class);
        List<Post> JsonPost = objectMapper.readValue(response, Post);
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
        JavaType Comment = objectMapper.getTypeFactory().constructParametricType(List.class, Comment.class);
        List<Comment> JsonComment = objectMapper.readValue(response, Comment);
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
        JavaType Album = objectMapper.getTypeFactory().constructParametricType(List.class, Album.class);
        List<Album> JsonAlbum = objectMapper.readValue(response, Album);
        return (JsonAlbum);
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
        JavaType Photo = objectMapper.getTypeFactory().constructParametricType(List.class, Photo.class);
        List<Photo> JsonPhoto = objectMapper.readValue(response, Photo);
        return (JsonPhoto);
    }

}