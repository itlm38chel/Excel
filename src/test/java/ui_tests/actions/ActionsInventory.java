package ui_tests.actions;

import com.codeborne.selenide.Configuration;
import org.junit.Assert;
import ui_tests.locators.LocatorsInventory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.open;

public class ActionsInventory {
    FileInputStream fileInputStream;
    Properties prop = new Properties();
    String PATH_TO_PROPERTIES = "src/test/resources/Prop.properties";
    LocatorsInventory locatorsInventory = new LocatorsInventory();

    public void login() throws IOException {
        fileInputStream = new FileInputStream(PATH_TO_PROPERTIES);
        prop.load(fileInputStream);
        String starturl = prop.getProperty("hostSauceDemo");
        String user_name = prop.getProperty("userSauceDemo");
        String pass = prop.getProperty("passSauceDemo");
        System.out.println(starturl);
        Configuration.baseUrl = starturl;
        open(starturl);
         locatorsInventory.Login(user_name, pass);
    }

    public void invItemNumb() {
        //Проверяем, что кол-во товаров на странице равно 6
        int x = 6;
        int sum = locatorsInventory.InventoryItemName();
        Assert.assertEquals(sum, x);
    }

    public void checkImgUrl() {
        int x;
        String name;
        for (x = 0; x < 6; x++) {
            //Проверка наличия картинок у товара
            name = locatorsInventory.checkUrlImg(x);
            name = name.replaceAll(" ", "-");
            name = name.toLowerCase();
            //Проверка, что кнопка добавления в корзину активна, добавление товара в корзину
            locatorsInventory.addItemToCart(name);
        }
    }

    public void checkCart() {
        //Проверка кол-ва товаров в корзине
        int count = locatorsInventory.checkCart();
        int x = 6;
        Assert.assertEquals(x, count);
    }

}

