package ui_tests.test;

import org.junit.Test;
import ui_tests.actions.ActionsInventory;

import java.io.IOException;

public class TestInventory {
    ActionsInventory actionsInventory = new ActionsInventory();
    @Test
    public void sauceDemoAutotest() throws IOException {
        actionsInventory.login(); //Входим в аккаунт
        actionsInventory.invItemNumb(); //Проверяем, что кол-во товаров на странице равно 6
        actionsInventory.checkImgUrl();//Проверка наличия картинок у товара, проверка, что кнопка добавления в корзину активна, добавление товара в корзину
        actionsInventory.checkCart(); //Проверка кол-ва товаров в корзине
    }
}
