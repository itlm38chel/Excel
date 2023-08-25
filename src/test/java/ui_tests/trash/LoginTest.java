package ui_tests.trash;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.tngtech.java.junit.dataprovider.DataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class LoginTest {
    //Проверка всех позитивных пользователей
    //Проверка всех негативных пользователей через дата провайдер
    String positive_login_su = "standard_user";
    String pwd = "secret_sauce";
    String starturl = "https://www.saucedemo.com/";


    @Test
    //@RunWith(DataProviderRunner.class)
    public void autotest() {
        checkPositiveAuth(positive_login_su, pwd);
    }

    @DataProvider
    public static Object[][] testExampleProvider() {
        return new Object[][]{
                {"locked_out_user", "secret_sauce"},
                {"problem_user", "secret_sauce"},
                {"performance_glitch_user", "secret_sauce"}
        };
    }

    public void checkPositiveAuth(String positive_login, String pwd) {
        Configuration.baseUrl = starturl;
        Configuration.timeout = 10000;
        open(starturl);
        $(By.id("user-name")).setValue(positive_login);
        $(By.id("user-name")).shouldNotBe(Condition.empty);
        $(By.id("password")).setValue(pwd);
        $(By.id("password")).shouldNotBe(Condition.empty);
        $(By.id("login-button")).click();
        sleep(1000);
        String pageUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        Assert.assertNotEquals(pageUrl, starturl);
    }
}
