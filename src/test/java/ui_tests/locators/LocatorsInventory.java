package ui_tests.locators;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class LocatorsInventory {
    //Локаторы для страницы логина
    By userName = By.id("user-name");
    By passwd = By.id("password");
    By loginButton = By.id("login-button");

    //Локаторы для страницы с товарами
    By invItemName = By.className("inventory_item_name");
    By tagName = By.tagName("img");

    //Локаторы для проверки корзины
    By checkCart = By.id("shopping_cart_container");
    By qtyCart = By.className("cart_quantity");


    public void Login(String user_name, String pass) {
        //Входим в аккаунт
        $(userName).setValue(user_name);
        $(passwd).setValue(pass);
        $(loginButton).click();
    }

    public int InventoryItemName() {
        //Проверяем, что кол-во товаров на странице равно 6
        int count = $$(invItemName).size();
        return count;
    }

    public String checkUrlImg(int count) {
        //Проверка наличия картинок у товара
        $(By.id("item_" + count + "_img_link")).findElement(tagName).getAttribute("src");
        String name = ($(By.id("item_" + count + "_img_link")).findElement(tagName).getAttribute("alt"));
        return name;
    }

    public void addItemToCart(String name) {
        //Проверка что кнопка добавления в корзину активна
        $(By.id("add-to-cart-" + name)).shouldBe(enabled);
        //Добавление товара в корзину
        $(By.id("add-to-cart-" + name)).click();
    }

    public int checkCart() {
        //Проверка кол-ва товаров в корзине
        $(checkCart).click();
        int count = $$(qtyCart).size();
        return count;
    }
}
