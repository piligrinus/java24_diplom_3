package pageobject;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static config.AppConfig.APP_URL_REGISTER_PAGE;

public class RegisterPage {
    private final By nameRegField = By.xpath(".//fieldset[1]/div/div/input");
    private final By emailRegField = By.xpath(".//fieldset[2]/div/div/input");
    private final By passwordRegField = By.xpath(".//fieldset[3]/div/div/input");
    private final By registerButton = By.xpath(".//form/button");
    private final By passwordError = By.className("input__error");
    private final By authLink = By.className("Auth_link__1fOlj");
    WebDriver webDriver;

    public RegisterPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.get(APP_URL_REGISTER_PAGE);
    }

    @Step("Ввод имени")
    public RegisterPage nameRegFieldInput(String name) {
        webDriver.findElement(nameRegField).sendKeys(name);
        return this;
    }

    @Step("Ввод email")
    public RegisterPage emailRegFieldInput(String email) {
        webDriver.findElement(emailRegField).sendKeys(email);
        return this;
    }

    @Step("Ввод пароля")
    public RegisterPage passwordRegFieldInput(String password) {
        webDriver.findElement(passwordRegField).sendKeys(password);
        return this;
    }

    @Step("Клик по кнопке Зарегистрироваться")
    public RegisterPage registerButtonClick() {
        new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(registerButton));
        webDriver.findElement(registerButton).click();
        return this;
    }

    @Step("Проверка ошибки при вводе невалидного пароля")
    public RegisterPage passwordErrorAssertion() {
        Assert.assertTrue(webDriver.findElement(passwordError).isDisplayed());
        return this;
    }

    @Step("Клик по кнопке войти")
    public RegisterPage authLinkClick() {
        new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(authLink));
        webDriver.findElement(authLink).click();
        return this;
    }


}