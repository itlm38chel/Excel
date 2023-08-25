package ui_tests.trash;

import com.codeborne.selenide.Configuration;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.*;

public class InventoryTest {
    //Логин
    //Проверка количества эл-тов на странице должно равным 6
    //Проверка, что у каждого эл-та есть картинка
    //Проверка, что у каждого эл-та есть кнопка добавить в корзину
    //Проверка добавления товара в корзину
    String positive_login_su = "standard_user";
    String pwd = "secret_sauce";
    String starturl = "https://www.saucedemo.com/";

    @Test
    public void autotest() {
        login(positive_login_su, pwd);
        checkInventoryList();
        checkImgBtnClick();
        checkCart();
    }

    public void login(String positive_login, String pwd) {
        Configuration.baseUrl = starturl;
        Configuration.timeout = 10000;
        open(starturl);
        $(By.id("user-name")).setValue(positive_login);
        $(By.id("password")).setValue(pwd);
        $(By.id("login-button")).click();
    }

    public void checkInventoryList() {
        int count = $$(By.className("inventory_item_name")).size();
        int x = 6;
        Assert.assertEquals(count, x);
    }


    public void checkImgBtnClick() {
        int x;
        String name;
        for (x = 0; x < 6; x++) {
            //проверка на наличие ссылки в src
            $(By.id("item_" + x + "_img_link")).findElement(By.tagName("img")).getAttribute("src");
            name = ($(By.id("item_" + x + "_img_link")).findElement(By.tagName("img")).getAttribute("alt"));
            name = name.replaceAll(" ", "-");
            name = name.toLowerCase();
            //проверка на доступность кнопки добавления в корзину
            $(By.id("add-to-cart-" + name)).shouldBe(enabled);
            //добавление в корзину
            $(By.id("add-to-cart-" + name)).click();
        }
    }

    public void checkCart() {
        $(By.id("shopping_cart_container")).click();
        int count = $$(By.className("cart_quantity")).size();
        int x = 6;
        Assert.assertEquals(count, x);
    }
}
