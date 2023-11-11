package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static config.AppConfig.APP_URL_FORGOT_PASSWORD_PAGE;

public class ForgotPasswordPage {
    private final By enterLoginButton = By.className("Auth_link__1fOlj");
    WebDriver webDriver;

    public ForgotPasswordPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.get(APP_URL_FORGOT_PASSWORD_PAGE);
    }

    @Step("Клик по кнопке Войти")
    public ForgotPasswordPage enterLoginButtonClick() {
        new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(enterLoginButton));
        webDriver.findElement(enterLoginButton).click();
        return this;
    }
}