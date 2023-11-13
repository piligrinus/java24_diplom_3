import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pageobject.ConstructorPage;
import pageobject.LoginPage;
import user.User;
import user.UserGenerator;

import static config.AppConfig.APP_URL_CONSTRUCTOR_PAGE;
import static config.AppConfig.APP_URL_PROFILE_PAGE;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ConstructorPageTest extends BaseTest {
    private final UserGenerator generator = new UserGenerator();
    public String accessToken;
    User user;

    @DisplayName("Тест скролла при нажатии на Соусы")
    @Test
    public void asourceActiveTabTest() {
        new ConstructorPage(webDriver)
                .sourceHeaderClick()
                .activeTabAssertion("Соусы");
    }

    @DisplayName("Тест скролла при нажатии на Начинки")
    @Test
    public void bfillingActiveTabTest() {
        new ConstructorPage(webDriver)
                .fillingHeaderClick()
                .activeTabAssertion("Начинки");
    }

    @DisplayName("Тест скролла при нажатии на Булки")
    @Test
    public void cbunActiveTabTest() {
        new ConstructorPage(webDriver)
                .sourceHeaderClick()
                .bunHeaderClick()
                .activeTabAssertion("Булки");
    }

    @Step("Проверка успешного логина")
    private void checkLoginSuccessfully() {
        new LoginPage(webDriver)
                .loginUser(user.getName(), user.getPassword());
        Assert.assertTrue(webDriver.getTitle() != null && webDriver.getCurrentUrl().contains(APP_URL_CONSTRUCTOR_PAGE));

    }

    @DisplayName("Тест входа в аккаунт по клику на кнопку Войти в аккаунт")
    @Test
    public void denterWithAccountButtonClick() {
        user = generator.genericRandom();
        ValidatableResponse creationResponse = createUser(user);
        accessToken = getToken(creationResponse);
        new ConstructorPage(webDriver)
                .enterAccountButtonClick();
        checkLoginSuccessfully();
    }

    @DisplayName("Тест входа в аккаунт по клику на кнопку Личный кабинет")
    @Test
    public void enterWithProfileButtonClick() {
        user = generator.genericRandom();
        ValidatableResponse creationResponse = createUser(user);
        accessToken = getToken(creationResponse);
        new ConstructorPage(webDriver)
                .enterProfileButtonClick();
        checkLoginSuccessfully();
    }

    @DisplayName("Тест входа в профиль зарегистрированного пользователя")
    @Test
    public void goingToProfilePageByProfileButtonClick() {
        user = generator.genericRandom();
        ValidatableResponse creationResponse = createUser(user);
        accessToken = getToken(creationResponse);
        new LoginPage(webDriver)
                .loginUser(user.getEmail(), user.getPassword());
        new ConstructorPage(webDriver)
                .enterProfileButtonClick();
        Assert.assertTrue(webDriver.getTitle() != null && webDriver.getCurrentUrl().contains(APP_URL_PROFILE_PAGE));

    }
}
