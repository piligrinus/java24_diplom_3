import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import pageobject.LoginPage;
import pageobject.RegisterPage;
import org.junit.Assert;
import user.User;
import user.UserGenerator;

import static config.AppConfig.APP_URL_CONSTRUCTOR_PAGE;
import static config.AppConfig.APP_URL_LOGIN_PAGE;

public class RegisterPageTest extends BaseTest {
    private final UserGenerator generator = new UserGenerator();
    User user;
    public String accessToken;
        DataTestGenerator dataTestGenerator = new DataTestGenerator();
       @Test
    public void registerPositiveTest() throws InterruptedException {
           new RegisterPage(webDriver)
                   .nameRegFieldInput(dataTestGenerator.name)
                   .emailRegFieldInput(dataTestGenerator.email)
                   .passwordRegFieldInput(dataTestGenerator.password)
                   .registerButtonClick();
                    Thread.sleep(1000);
                    Assert.assertTrue(webDriver.getTitle() != null && webDriver.getCurrentUrl().contains(APP_URL_LOGIN_PAGE));
           new LoginPage(webDriver)
                    .LoginUser(dataTestGenerator.email, dataTestGenerator.password);
                    Thread.sleep(1000);
                    LocalStorage localStorage = ((WebStorage) webDriver).getLocalStorage();
                    accessToken = localStorage.getItem("accessToken");
                    System.out.println(accessToken);
                    deleteUser(accessToken);
           }

    @Test
    public void registerNegativeTest() {
        new RegisterPage(webDriver)
                .nameRegFieldInput(dataTestGenerator.name)
                .emailRegFieldInput(dataTestGenerator.email)
                .passwordRegFieldInput(dataTestGenerator.wrongPassword)
                .registerButtonClick()
                .passwordErrorAssertion();
                 deleteUser(accessToken);
    }

    @Test
    public void enterByAuthLink() throws InterruptedException {
        user = generator.genericRandom();
        ValidatableResponse creationResponse = createUser(user);
        accessToken = getToken(creationResponse);
           new RegisterPage(webDriver)
                   .authLinkClick();
                    Thread.sleep(300);
                     Assert.assertTrue(webDriver.getTitle() != null && webDriver.getCurrentUrl().contains(APP_URL_LOGIN_PAGE));
           new LoginPage(webDriver)
                   .LoginUser(user.getName(), user.getPassword());
                    Thread.sleep(300);
                     Assert.assertTrue(webDriver.getTitle() != null && webDriver.getCurrentUrl().contains(APP_URL_CONSTRUCTOR_PAGE));
                     deleteUser(accessToken);
    }

    }



