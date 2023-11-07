import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import pageobject.ForgotPasswordPage;
import pageobject.LoginPage;
import org.junit.Assert;
import user.User;
import user.UserGenerator;

import static config.AppConfig.APP_URL_CONSTRUCTOR_PAGE;
import static config.AppConfig.APP_URL_LOGIN_PAGE;

public class ForgotPasswordPageTest extends BaseTest{
    private final UserGenerator generator = new UserGenerator();
    User user;
    public String accessToken;

    @Test
    public void enterByLoginButtonClick() throws InterruptedException {
        user = generator.genericRandom();
        ValidatableResponse creationResponse = createUser(user);
        accessToken = getToken(creationResponse);
        new ForgotPasswordPage(webDriver)
                .enterLoginButtonClick();
        Thread.sleep(300);
        Assert.assertTrue(webDriver.getTitle() != null && webDriver.getCurrentUrl().contains(APP_URL_LOGIN_PAGE));
        new LoginPage(webDriver)
                .LoginUser(user.getName(), user.getPassword());
        Thread.sleep(300);
        Assert.assertTrue(webDriver.getTitle() != null && webDriver.getCurrentUrl().contains(APP_URL_CONSTRUCTOR_PAGE));
        deleteUser(accessToken);
    }
}
