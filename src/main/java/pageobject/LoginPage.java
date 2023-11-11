package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static config.AppConfig.APP_URL_LOGIN_PAGE;

public class LoginPage {
    private final By emailLoginField = By.xpath(".//fieldset[1]/div/div/input");
    private final By passwordLoginField = By.xpath(".//fieldset[2]/div/div/input");
    private final By loginButton = By.xpath(".//form/button");
    WebDriver webDriver;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.get(APP_URL_LOGIN_PAGE);
    }

    @Step("Ввод email")
    public LoginPage emailLoginFieldInput(String email) {
        webDriver.findElement(emailLoginField).sendKeys(email);
        return this;
    }

    @Step("Ввод пароля")
    public LoginPage passwordLoginFieldInput(String password) {
        webDriver.findElement(passwordLoginField).sendKeys(password);
        return this;
    }

    @Step("Клик по кнопке Войти")
    public LoginPage loginButtonClick() {
        new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(loginButton));
        webDriver.findElement(loginButton).click();
        return this;
    }

    @Step("Логин пользователя")
    public LoginPage loginUser(String email, String password) {
        emailLoginFieldInput(email);
        passwordLoginFieldInput(password);
        loginButtonClick();
        return this;

    }

}


