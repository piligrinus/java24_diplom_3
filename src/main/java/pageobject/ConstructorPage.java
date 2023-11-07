package pageobject;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static config.AppConfig.APP_URL_CONSTRUCTOR_PAGE;

public class ConstructorPage {
    WebDriver webDriver;
    public ConstructorPage (WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.get(APP_URL_CONSTRUCTOR_PAGE);
    }

    private By enterAccountButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private By enterProfileButton = By.xpath("/html/body/div/div/header/nav/a/p");
    private By bunHeader = By.xpath(".//div[1]/span");
    private By sourceHeader = By.xpath(".//div[2]/span");
    private By fillingHeader = By.xpath(".//div[3]/span");
    private By activeTab = By.className("tab_tab_type_current__2BEPc");



    @Step
    public ConstructorPage enterAccountButtonClick() throws InterruptedException {
        webDriver.findElement(enterAccountButton).click();
        Thread.sleep(1000);
        return this;
    }
    @Step
    public ConstructorPage enterProfileButtonClick() throws InterruptedException {
        webDriver.findElement(enterProfileButton).click();
        Thread.sleep(10000);
        return this;
    }
    @Step
    public ConstructorPage bunHeaderClick() throws InterruptedException{
        webDriver.findElement(bunHeader).click();
        Thread.sleep(1000);
        return this;
    }
    @Step
    public ConstructorPage sourceHeaderClick() throws InterruptedException{
        webDriver.findElement(sourceHeader).click();
        Thread.sleep(1000);
        return this;
    }
    @Step
    public ConstructorPage fillingHeaderClick () throws InterruptedException {
        webDriver.findElement(fillingHeader).click();
        Thread.sleep(1000);
        return this;
    }
    @Step
    public ConstructorPage activeTabAssertion(String category){
        Assert.assertTrue(webDriver.findElement(activeTab).isDisplayed());
        Assert.assertTrue(webDriver.findElement(activeTab).getText().equals(category));

        return this;
            }


}
