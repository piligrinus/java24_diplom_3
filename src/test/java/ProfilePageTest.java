import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.Test;
import pageobject.ConstructorPage;
import pageobject.LoginPage;
import pageobject.ProfilePage;
import user.User;
import user.UserGenerator;

import static config.AppConfig.APP_URL_CONSTRUCTOR_PAGE;
import static config.AppConfig.APP_URL_LOGIN_PAGE;

public class ProfilePageTest extends BaseTest {
    private final UserGenerator generator = new UserGenerator();
    public String accessToken;
    User user;

    @DisplayName("Тест перехода на страницу Конструктора по клику на кнопку Конструктор ")
    @Test
    public void goingToConstructorPageByConstructorButtonClick() {
        user = generator.genericRandom();
        ValidatableResponse creationResponse = createUser(user);
        accessToken = getToken(creationResponse);
        webDriver.manage().window().maximize();
        new LoginPage(webDriver)
                .loginUser(user.getEmail(), user.getPassword());
        new ConstructorPage(webDriver)
                .enterProfileButtonClick();
        new ProfilePage(webDriver)
                .enterConstructorButtonClick();
        Assert.assertTrue(webDriver.getTitle() != null && webDriver.getCurrentUrl().contains(APP_URL_CONSTRUCTOR_PAGE));

    }

    @DisplayName("Тест перехода на страницу Конструктора по клику на логотип ")
    @Test
    public void goingToConstructorPageByLogoButtonClick() {
        user = generator.genericRandom();
        ValidatableResponse creationResponse = createUser(user);
        accessToken = getToken(creationResponse);
        webDriver.manage().window().maximize();
        new LoginPage(webDriver)
                .loginUser(user.getEmail(), user.getPassword());
        new ConstructorPage(webDriver)
                .enterProfileButtonClick();
        new ProfilePage(webDriver)
                .logoButtonClick();
        Assert.assertTrue(webDriver.getTitle() != null && webDriver.getCurrentUrl().contains(APP_URL_CONSTRUCTOR_PAGE));

    }

    @DisplayName("Тест перехода на страницу входа по клику на кнопку Выйти ")
    @Test
    public void goingTLoginPageByExitButtonClick() {
        user = generator.genericRandom();
        ValidatableResponse creationResponse = createUser(user);
        accessToken = getToken(creationResponse);
        webDriver.manage().window().maximize();
        new LoginPage(webDriver)
                .loginUser(user.getEmail(), user.getPassword());
        new ConstructorPage(webDriver)
                .enterProfileButtonClick();
        new ProfilePage(webDriver)
                .exitButtonClick();
        Assert.assertTrue(webDriver.getTitle() != null && webDriver.getCurrentUrl().contains(APP_URL_LOGIN_PAGE));

    }
}