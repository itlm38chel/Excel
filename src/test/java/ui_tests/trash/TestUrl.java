package ui_tests.trash;

import com.codeborne.selenide.Configuration;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class TestUrl {

    @Test
    public void autotest() {
        Configuration.baseUrl = "https://mail.ru/";
        Configuration.timeout = 10000;
        open("https://mail.ru/");
        sleep(1000);
    }
}
