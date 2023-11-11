import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.LoginPage;
import pageobject.RegisterPage;
import user.User;
import user.UserGenerator;

import java.time.Duration;

import static config.AppConfig.APP_URL_CONSTRUCTOR_PAGE;
import static config.AppConfig.APP_URL_LOGIN_PAGE;

public class RegisterPageTest extends BaseTest {
    private final UserGenerator generator = new UserGenerator();
    public String accessToken;
    User user;
    DataTestGenerator dataTestGenerator = new DataTestGenerator();

    @DisplayName("Тест успешной регистрации пользователя ")
    @Test
    public void registerPositiveTest() {
        new RegisterPage(webDriver)
                .nameRegFieldInput(dataTestGenerator.name)
                .emailRegFieldInput(dataTestGenerator.email)
                .passwordRegFieldInput(dataTestGenerator.password)
                .registerButtonClick();
        new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.urlContains(APP_URL_LOGIN_PAGE));
        Assert.assertTrue(webDriver.getTitle() != null && webDriver.getCurrentUrl().contains(APP_URL_LOGIN_PAGE));
        new LoginPage(webDriver)
                .loginUser(dataTestGenerator.email, dataTestGenerator.password);
        LocalStorage localStorage = ((WebStorage) webDriver).getLocalStorage();
        accessToken = localStorage.getItem("accessToken");


    }

    @DisplayName("Тест неуспешной регистрации пользователя ")
    @Test
    public void registerNegativeTest() {
        new RegisterPage(webDriver)
                .nameRegFieldInput(dataTestGenerator.name)
                .emailRegFieldInput(dataTestGenerator.email)
                .passwordRegFieldInput(dataTestGenerator.wrongPassword)
                .registerButtonClick()
                .passwordErrorAssertion();

    }

    @DisplayName("Тест входа по кнопке Войти")
    @Test
    public void enterByAuthLink() {
        user = generator.genericRandom();
        ValidatableResponse creationResponse = createUser(user);
        accessToken = getToken(creationResponse);
        new RegisterPage(webDriver)
                .authLinkClick();
        new LoginPage(webDriver)
                .loginUser(user.getName(), user.getPassword());
        Assert.assertTrue(webDriver.getTitle() != null && webDriver.getCurrentUrl().contains(APP_URL_CONSTRUCTOR_PAGE));

    }

}



