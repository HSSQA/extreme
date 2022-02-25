package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static com.codeborne.selenide.WebDriverRunner.isChrome;
import static org.testng.Assert.assertEquals;

public class HelloSelenideTest {

    @Test
    public void testSoma(){

        Configuration.browser = "chrome";
        Configuration.baseUrl = "http://ninjaplus-web:5000";
        assertEquals(title(), "Ninja+");
    }
}
