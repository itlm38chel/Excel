package api_tests.test;

import api_tests.actions.JsonPlaceholder;
import com.fasterxml.jackson.core.JsonProcessingException;
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
        List<JsonPlaceholder.PostClass> obj = jsonplaceholder.posts(url);
        for (int i = 0; i < obj.size(); i++) {
            Assert.assertNotNull(obj.get(i).getUserId());
            Assert.assertNotNull(obj.get(i).getId());
            Assert.assertNotNull(obj.get(i).getTitle());
            Assert.assertNotNull(obj.get(i).getBody());
        }
        Assert.assertEquals(obj.size(), posts);
    }

    @Test
    public void comments() throws JsonProcessingException {
        List<JsonPlaceholder.CommentClass> obj = jsonplaceholder.comments(url);
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
        List<JsonPlaceholder.AlbumClass> obj = jsonplaceholder.albums(url);
        for (int i = 0; i < obj.size(); i++) {
            Assert.assertNotNull(obj.get(i).getUserId());
            Assert.assertNotNull(obj.get(i).getId());
            Assert.assertNotNull(obj.get(i).getTitle());
        }
        Assert.assertEquals(obj.size(), albums);
    }

    @Test
    public void photos() throws JsonProcessingException {
        List<JsonPlaceholder.PhotoClass> obj = jsonplaceholder.photos(url);
        for (int i = 0; i < obj.size(); i++) {
            Assert.assertNotNull(obj.get(i).getAlbumId());
            Assert.assertNotNull(obj.get(i).getId());
            Assert.assertNotNull(obj.get(i).getTitle());
            Assert.assertNotNull(obj.get(i).getUrl());
            Assert.assertNotNull(obj.get(i).getThumbnailUrl());
        }
        Assert.assertEquals(obj.size(), photos);
    }

}
