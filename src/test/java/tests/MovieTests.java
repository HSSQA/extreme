package tests;

import common.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.sleep;

public class MovieTests extends BaseTest {



    @BeforeMethod
    public void setup(){
        login
                .open()
                .with("Helder@extreme.com", "helder123");
        sleep(2000);

        side.loggedUser().shouldHave(text("Helder"));
        sleep(2000);

    }

    @Test
    public void shouldRegisterANewMovie(){
        String title = "Jumanji - Próxima fase";
        String status = "Pré-venda";
        String year = "2020";
        String releaseDate = "16/01/2020";
        List<String> cast = Arrays.asList("The Rock", "Jack Black", "Kevin Hart", "Karen Gillan", "Danny DeVito");
        String plot = "tentado a revisitar o mundo de Jumanji, Spencer decide consertar o bug do jogo do game que permite...";

        movie.add().create(title, status, year, releaseDate, cast, plot);
    }
}
