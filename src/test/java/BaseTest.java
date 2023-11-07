import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
import io.restassured.http.ContentType;
import user.User;


import static config.AppConfig.*;
import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.HTTP_OK;
import static org.hamcrest.CoreMatchers.is;

public class BaseTest {
    WebDriver webDriver = WebDriverFactory.get();

    @Before
    public void init() {
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


    }

    @After
    public void clean() {
        webDriver.manage().deleteAllCookies();
        webDriver.quit();
    }

    public void deleteUser(String accessToken) {
        if (accessToken != null) {
            given()
                    .log()
                    .all()
                    .contentType(ContentType.JSON)
                    .header("Authorization", accessToken)
                    .when()
                    .delete(API_DELETE_USER)
                    .then()
                    .log()
                    .all();
        }
    }
    public ValidatableResponse createUser(User user){
        return given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post(API_CREATE_USER)
                .then()
                .log()
                .all();
    }
    public String getToken(ValidatableResponse response){
        return response.assertThat()
                .body("success", is(true))
                .and()
                .statusCode(HTTP_OK)
                .and()
                .extract().path("accessToken");

    }

    }

