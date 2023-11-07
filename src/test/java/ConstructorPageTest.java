import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.Test;
import pageobject.ConstructorPage;
import pageobject.LoginPage;
import user.User;
import user.UserGenerator;

import static config.AppConfig.*;

public class ConstructorPageTest extends BaseTest {
    private final UserGenerator generator = new UserGenerator();
    User user;
    public String accessToken;


   @Test
   public void FillingActiveTabTest () throws InterruptedException {
       new ConstructorPage(webDriver)
                .fillingHeaderClick()
               .activeTabAssertion("Начинки");
   }
    @Test
    public void SourceActiveTabTest () throws InterruptedException {
        new ConstructorPage(webDriver)
                .sourceHeaderClick()
                .activeTabAssertion("Соусы");
    }
    @Test
    public void BunActiveTabTest () throws InterruptedException {
        new ConstructorPage(webDriver)
                .fillingHeaderClick()
                .bunHeaderClick()
                .activeTabAssertion("Булки");
            }

    @Step
    private void checkLoginSuccessfully() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue(webDriver.getTitle() != null && webDriver.getCurrentUrl().contains(APP_URL_LOGIN_PAGE));
        new LoginPage(webDriver)
                .LoginUser(user.getName(), user.getPassword());
        Thread.sleep(1000);
        Assert.assertTrue(webDriver.getTitle() != null && webDriver.getCurrentUrl().contains(APP_URL_CONSTRUCTOR_PAGE));
        deleteUser(accessToken);
    }

   @Test
   public void EnterWithAccountButtonClick() throws InterruptedException {
       user = generator.genericRandom();
       ValidatableResponse creationResponse = createUser(user);
       accessToken = getToken(creationResponse);
       new ConstructorPage(webDriver)
               .enterAccountButtonClick();
                checkLoginSuccessfully();
   }

    @Test
    public void EnterWithProfileButtonClick() throws InterruptedException {
       user = generator.genericRandom();
       ValidatableResponse creationResponse = createUser(user);
       accessToken = getToken(creationResponse);
       new ConstructorPage(webDriver)
               .enterProfileButtonClick();
                checkLoginSuccessfully();
    }
    @Test
    public void goingToProfilePageByProfileButtonClick() throws InterruptedException{
        user = generator.genericRandom();
        ValidatableResponse creationResponse = createUser(user);
        accessToken = getToken(creationResponse);
        new LoginPage(webDriver)
                .LoginUser(user.getEmail(), user.getPassword());
                Thread.sleep(1000);
        new ConstructorPage(webDriver)
                .enterProfileButtonClick();
                 Thread.sleep(300);
                 Assert.assertTrue(webDriver.getTitle() != null && webDriver.getCurrentUrl().contains(APP_URL_PROFILE_PAGE));
                 deleteUser(accessToken);
    }
}
