package api_tests.trash;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GetListFromSite {
    String url = "https://jsonplaceholder.typicode.com";
   public List<PostClass> tes() throws JsonProcessingException {
        String response = given()
                .baseUri(url )
                .basePath( "/posts")
                .when()
                .get()
                .then()
                .extract()
                .response().asString();
        ObjectMapper objectMapper = new ObjectMapper();
        List<PostClass> listCar = objectMapper.readValue(response, objectMapper.getTypeFactory().constructParametricType(List.class, PostClass.class));
        return listCar;
    }
    @Test
    public void backendTest() throws JsonProcessingException {
        for (int i = 0; i < tes().size(); i++) {
            Assert.assertNotNull(tes().get(i).userId);
            Assert.assertNotNull(tes().get(i).id);
            Assert.assertNotNull(tes().get(i).title);
            Assert.assertNotNull(tes().get(i).body);
        }
        Assert.assertEquals(tes().size(),100);
    }

    @Data
    public static class PostClass {
        private Integer userId;
        private Integer id;
        private String title;
        private String body;
    }
}
