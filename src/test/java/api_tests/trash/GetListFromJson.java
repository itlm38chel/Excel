package api_tests.trash;

import api_tests.pojo.Post;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GetListFromJson {
    @Data
    static class Postt {
        private String userId;
        private String id;
        private String title;
        private String body;
    }

    // Я вернул list объектов
    @Test
    public void nuok() throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonCarArray =
                "[{ \"userId\" : \"1\", \"id\" : \"1\" , \"title\" : \"sunt aut facere\" , \"body\" : \"quia et suscipit\" }, { \"userId\" : \"1\", \"id\" : \"2\" , \"title\" : \"qui est esse\" , \"body\" : \"est rerum tempore vitae\" },{ \"userId\" : \"1\", \"id\" : \"3\" , \"title\" : \"ea molestias quasi\" , \"body\" : \"facere\" }]";
        List<Postt> listCar = objectMapper.readValue(jsonCarArray, new TypeReference<List<Postt>>() {
        });
        for (int i = 0; i < listCar.size(); i++) {
            Assert.assertNotNull(listCar.get(i).userId);
            Assert.assertNotNull(listCar.get(i).id);
            Assert.assertNotNull(listCar.get(i).title);
            Assert.assertNotNull(listCar.get(i).body);
            System.out.println(listCar.get(i));
        }
        Assert.assertEquals(listCar.size(),3);
        System.out.println(listCar.size());
    }
@Test
    public void posts() throws JsonProcessingException {
        String response = given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .basePath("/posts")
                .when()
                .get()
                .then()
                .extract()
                .response().asString();
        ObjectMapper objectMapper = new ObjectMapper();
        List<Post> JsonPost = objectMapper.readValue(response, List.class);
        System.out.println(JsonPost.size());
     //   return JsonPost;
    }
}

