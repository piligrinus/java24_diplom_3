package pageobject;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static config.AppConfig.APP_URL_CONSTRUCTOR_PAGE;

public class ConstructorPage {
    private final By enterAccountButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By enterProfileButton = By.xpath("/html/body/div/div/header/nav/a/p");
    private final By bunHeader = By.xpath(".//div[1]/span");
    private final By sourceHeader = By.xpath(".//div[2]/span");
    private final By fillingHeader = By.xpath(".//div[3]/span");
    private final By activeTab = By.className("tab_tab_type_current__2BEPc");
    WebDriver webDriver;

    public ConstructorPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.get(APP_URL_CONSTRUCTOR_PAGE);
    }

    @Step("Клик по кнопке Войти в аккаунт")
    public ConstructorPage enterAccountButtonClick() {
        new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(enterAccountButton));
        webDriver.findElement(enterAccountButton).click();

        return this;
    }

    @Step("Клик по кнопке Личный кабинет")
    public ConstructorPage enterProfileButtonClick() {
        new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(enterProfileButton));
        webDriver.findElement(enterProfileButton).click();

        return this;
    }

    @Step("Клик заголовку Булки")
    public ConstructorPage bunHeaderClick() {
        webDriver.findElement(bunHeader).click();
        new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.attributeContains(activeTab, "class", "current"));
        return this;
    }

    @Step("Клик заголовку Соусы")
    public ConstructorPage sourceHeaderClick() {
        webDriver.findElement(sourceHeader).click();
        new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.attributeContains(activeTab, "class", "current"));

        return this;
    }

    @Step("Клик заголовку Начинки")
    public ConstructorPage fillingHeaderClick() {
        webDriver.findElement(fillingHeader).click();
        new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.attributeContains(activeTab, "class", "current"));

        return this;
    }

    @Step("Проверка перемещения активного элемента заголовка")
    public ConstructorPage activeTabAssertion(String category) {

        Assert.assertTrue(webDriver.findElement(activeTab).isDisplayed());
        Assert.assertEquals(webDriver.findElement(activeTab).getText(), category);

        return this;
    }


}
