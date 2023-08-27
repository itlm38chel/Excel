package api_tests.test;

import api_tests.actions.JsonPlaceholder;
import api_tests.pojo.Post;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Data;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class JsonTest {

    int posts = 100;
    int comments = 500;
    int albums = 100;
    int photos = 5000;
    String url = "https://jsonplaceholder.typicode.com";
    JsonPlaceholder jsonplaceholder = new JsonPlaceholder();

    @Test
    public void posts() throws JsonProcessingException {
        List<Post> obj = jsonplaceholder.posts(url);
        System.out.println(obj.get(1).getId());
        Assert.assertEquals(obj.size(), posts);
    }

    @Test
    public void comments() throws JsonProcessingException {
        List<CommentClass> obj = jsonplaceholder.comments(url);
        for (int i = 0; i < obj.size(); i++) {
            Assert.assertNotNull(obj.get(i).getPostId());
            Assert.assertNotNull(obj.get(i).getId());
            Assert.assertNotNull(obj.get(i).getName());
            Assert.assertNotNull(obj.get(i).getBody());
            Assert.assertNotNull(obj.get(i).getEmail());
        }
        Assert.assertEquals(obj.size(), comments);
    }

    @Test
    public void albums() throws JsonProcessingException {
        List<AlbumClass> obj = jsonplaceholder.albums(url);
        for (int i = 0; i < obj.size(); i++) {
            Assert.assertNotNull(obj.get(i).getUserId());
            Assert.assertNotNull(obj.get(i).getId());
            Assert.assertNotNull(obj.get(i).getTitle());
        }
        Assert.assertEquals(obj.size(), albums);
    }

    @Test
    public void photos() throws JsonProcessingException {
        List<PhotoClass> obj = jsonplaceholder.photos(url);
        for (int i = 0; i < obj.size(); i++) {
            Assert.assertNotNull(obj.get(i).getAlbumId());
            Assert.assertNotNull(obj.get(i).getId());
            Assert.assertNotNull(obj.get(i).getTitle());
            Assert.assertNotNull(obj.get(i).getUrl());
            Assert.assertNotNull(obj.get(i).getThumbnailUrl());
        }
        Assert.assertEquals(obj.size(), photos);
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
