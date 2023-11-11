import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import user.User;

import static config.AppConfig.API_CREATE_USER;
import static config.AppConfig.API_DELETE_USER;
import static io.restassured.RestAssured.given;

public class BaseTest {
    public String accessToken;
    WebDriver webDriver = WebDriverFactory.get();


    @After
    public void clean() {

        deleteUser(accessToken);
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

    public ValidatableResponse createUser(User user) {
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

    public String getToken(ValidatableResponse response) {
        return accessToken =

                response.extract().path("accessToken");

    }

}

