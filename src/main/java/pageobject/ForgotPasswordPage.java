package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static config.AppConfig.APP_URL_FORGOT_PASSWORD_PAGE;

public class ForgotPasswordPage {
    WebDriver webDriver;

    public ForgotPasswordPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.get(APP_URL_FORGOT_PASSWORD_PAGE);
    }

    private By enterLoginButton = By.className("Auth_link__1fOlj");


    @Step
    public ForgotPasswordPage enterLoginButtonClick() {
        webDriver.findElement(enterLoginButton).click();
        return this;
    }
}