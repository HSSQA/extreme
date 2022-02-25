package tests;

import common.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.sleep;

public class LoginTests extends BaseTest {


    @DataProvider(name = "login-alerts")
    public Object[][] loginProvider() {
        return new Object[][]{
                {"Helder@extreme.com", "helder1234", "Usuário e/ou senha inválidos"},
                {"Helder12@extreme.com", "helder123", "Usuário e/ou senha inválidos"},
                {"", "helder123", "Opps. Cadê o email?"},
                {"Helder@extreme.com", "", "Opps. Cadê a senha?"}
        };
    }

    @Test
    public void shouldSeeLoggedUser() {
        login
                .open()
                .with("Helder@extreme.com", "helder123");
                sleep(2000);
        side.loggedUser().shouldHave(text("Helder"));
                sleep(2000);
    }

    // DDT (Data Driven Testing)
    @Test(dataProvider = "login-alerts")
    public void shouldSeeLoginAlerts(String email, String pass, String expectAlert) {
        login.open();
        login.with(email, pass);
        sleep(1000);
        login.alert().shouldHave(text(expectAlert));
        sleep(1000);
    }

    @AfterMethod
    public void cleanup() {
        login.clearSession();
    }
}
