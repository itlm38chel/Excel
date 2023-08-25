package ui_tests.actions;

import com.codeborne.selenide.Configuration;
import org.junit.Assert;
import ui_tests.locators.LocatorsInventory;

import static com.codeborne.selenide.Selenide.open;

public class ActionsInventory {
    String starturl = "https://www.saucedemo.com/";
    String user_name = "standard_user";
    String pass = "secret_sauce";

    LocatorsInventory locatorsInventory = new LocatorsInventory();

    public void login() {
        //Входим в аккаунт
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
    public void checkCart(){
        //Проверка кол-ва товаров в корзине
        int count = locatorsInventory.checkCart();
        int x=6;
        Assert.assertEquals(x,count);
    }

}

