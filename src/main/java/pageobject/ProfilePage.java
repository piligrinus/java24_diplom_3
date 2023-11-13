package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static config.AppConfig.APP_URL_PROFILE_PAGE;

public class ProfilePage {
    private final By exitButton = By.className("Account_button__14Yp3");
    private final By enterConstructorButton = By.xpath(".//p[text()='Конструктор']");
    private final By logoButton = By.className("AppHeader_header__logo__2D0X2");
    WebDriver webDriver;

    public ProfilePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.get(APP_URL_PROFILE_PAGE);
    }

    @Step("Клик по кнопке Выход")
    public ProfilePage exitButtonClick() {
        new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(exitButton));
        webDriver.findElement(exitButton).click();
        return this;
    }

    @Step("Клик по кнопке Конструктор")
    public ProfilePage enterConstructorButtonClick() {
        new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(enterConstructorButton));

        webDriver.findElement(enterConstructorButton).click();
        return this;
    }

    @Step("Клик по логотипу")
    public ProfilePage logoButtonClick() {
        new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(logoButton));
        webDriver.findElement(logoButton).click();
        return this;
    }

}