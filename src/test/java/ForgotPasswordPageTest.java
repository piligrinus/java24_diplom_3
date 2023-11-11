import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.Test;
import pageobject.ForgotPasswordPage;
import pageobject.LoginPage;
import user.User;
import user.UserGenerator;

import static config.AppConfig.APP_URL_CONSTRUCTOR_PAGE;

public class ForgotPasswordPageTest extends BaseTest {
    private final UserGenerator generator = new UserGenerator();
    public String accessToken;
    User user;

    @DisplayName("Тест входа в аккаунт по клику на кнопку Войти")
    @Test
    public void enterByLoginButtonClick() {
        user = generator.genericRandom();
        ValidatableResponse creationResponse = createUser(user);
        accessToken = getToken(creationResponse);
        new ForgotPasswordPage(webDriver)
                .enterLoginButtonClick();
        new LoginPage(webDriver)
                .loginUser(user.getName(), user.getPassword());
        Assert.assertTrue(webDriver.getTitle() != null && webDriver.getCurrentUrl().contains(APP_URL_CONSTRUCTOR_PAGE));

    }
}
