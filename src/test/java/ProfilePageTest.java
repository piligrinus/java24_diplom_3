import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.Test;
import pageobject.ConstructorPage;
import pageobject.LoginPage;
import pageobject.ProfilePage;
import user.User;
import user.UserGenerator;
import static config.AppConfig.*;

public class ProfilePageTest extends BaseTest {
    private final UserGenerator generator = new UserGenerator();
    User user;
    public String accessToken;

    @Test
    public void goingToConstructorPageByConstructorButtonClick() throws InterruptedException {
        user = generator.genericRandom();
        ValidatableResponse creationResponse = createUser(user);
        accessToken = getToken(creationResponse);
        webDriver.manage().window().maximize();
        new LoginPage(webDriver)
                .LoginUser(user.getEmail(), user.getPassword());
        Thread.sleep(1000);
        new ConstructorPage(webDriver)
                .enterProfileButtonClick();
        Thread.sleep(300);
        new ProfilePage(webDriver)
                .enterConstructorButtonClick();
        Thread.sleep(1000);
        Assert.assertTrue(webDriver.getTitle() != null && webDriver.getCurrentUrl().contains(APP_URL_CONSTRUCTOR_PAGE));
        deleteUser(accessToken);
    }

    @Test
    public void goingToConstructorPageByLogoButtonClick() throws InterruptedException {
        user = generator.genericRandom();
        ValidatableResponse creationResponse = createUser(user);
        accessToken = getToken(creationResponse);
        webDriver.manage().window().maximize();
        new LoginPage(webDriver)
                .LoginUser(user.getEmail(), user.getPassword());
        Thread.sleep(1000);
        new ConstructorPage(webDriver)
                .enterProfileButtonClick();
        Thread.sleep(300);
        new ProfilePage(webDriver)
                .logoButtonClick();
        Thread.sleep(1000);
        Assert.assertTrue(webDriver.getTitle() != null && webDriver.getCurrentUrl().contains(APP_URL_CONSTRUCTOR_PAGE));
        deleteUser(accessToken);
    }
    @Test
    public void goingTLoginPageByExitButtonClick() throws InterruptedException {
        user = generator.genericRandom();
        ValidatableResponse creationResponse = createUser(user);
        accessToken = getToken(creationResponse);
        webDriver.manage().window().maximize();
        new LoginPage(webDriver)
                .LoginUser(user.getEmail(), user.getPassword());
        Thread.sleep(1000);
        new ConstructorPage(webDriver)
                .enterProfileButtonClick();
        Thread.sleep(300);
        new ProfilePage(webDriver)
                .exitButtonClick();
        Thread.sleep(1000);
        Assert.assertTrue(webDriver.getTitle() != null && webDriver.getCurrentUrl().contains(APP_URL_LOGIN_PAGE));
        deleteUser(accessToken);
    }
}