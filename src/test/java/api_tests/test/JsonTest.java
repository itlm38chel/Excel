package api_tests.test;

import api_tests.actions.JsonPlaceholder;
import api_tests.pojo.Album;
import api_tests.pojo.Comment;
import api_tests.pojo.Photo;
import api_tests.pojo.Post;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class JsonTest {

    int posts = 100;
    int comments = 500;
    int albums = 100;
    int photos = 5000;
    String PATH_TO_PROPERTIES = "src/test/resources/Prop.properties";
    JsonPlaceholder jsonplaceholder = new JsonPlaceholder();
    FileInputStream fileInputStream;
    Properties prop = new Properties();

    @Test
    public void posts() throws IOException {
        fileInputStream = new FileInputStream(PATH_TO_PROPERTIES);
        prop.load(fileInputStream);
        String url = prop.getProperty("hostJsonPlaceHolder");
        List<Post> obj = jsonplaceholder.posts(url);
        for (int i = 0; i < obj.size(); i++) {
            Assert.assertNotNull(obj.get(i).getUserId());
            Assert.assertNotNull(obj.get(i).getId());
            Assert.assertNotNull(obj.get(i).getTitle());
            Assert.assertNotNull(obj.get(i).getBody());
        }
        Assert.assertEquals(obj.size(), posts);
    }

    @Test
    public void comments() throws IOException {
        fileInputStream = new FileInputStream(PATH_TO_PROPERTIES);
        prop.load(fileInputStream);
        String url = prop.getProperty("hostJsonPlaceHolder");
        List<Comment> obj = jsonplaceholder.comments(url);
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
    public void albums() throws IOException {
        fileInputStream = new FileInputStream(PATH_TO_PROPERTIES);
        prop.load(fileInputStream);
        String url = prop.getProperty("hostJsonPlaceHolder");
        List<Album> obj = jsonplaceholder.albums(url);
        for (int i = 0; i < obj.size(); i++) {
            Assert.assertNotNull(obj.get(i).getUserId());
            Assert.assertNotNull(obj.get(i).getId());
            Assert.assertNotNull(obj.get(i).getTitle());
        }
        Assert.assertEquals(obj.size(), albums);
    }

    @Test
    public void photos() throws IOException {
        fileInputStream = new FileInputStream(PATH_TO_PROPERTIES);
        prop.load(fileInputStream);
        String url = prop.getProperty("hostJsonPlaceHolder");
        List<Photo> obj = jsonplaceholder.photos(url);
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
