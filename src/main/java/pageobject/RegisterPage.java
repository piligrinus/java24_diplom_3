package pageobject;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static config.AppConfig.APP_URL_REGISTER_PAGE;

public class RegisterPage {
    WebDriver webDriver;

    public RegisterPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.get(APP_URL_REGISTER_PAGE);
    }

    private By nameRegField = By.xpath(".//fieldset[1]/div/div/input");
    private By emailRegField = By.xpath(".//fieldset[2]/div/div/input");
    private By passwordRegField = By.xpath(".//fieldset[3]/div/div/input");
    private By registerButton = By.xpath(".//form/button");
    private By passwordError = By.className("input__error");
    private By authLink = By.className("Auth_link__1fOlj");

    @Step
    public RegisterPage nameRegFieldInput(String name){
        webDriver.findElement(nameRegField).sendKeys(name);
        return this;
    }
    @Step
    public RegisterPage emailRegFieldInput(String email) {
        webDriver.findElement(emailRegField).sendKeys(email);
        return this;
    }

    @Step
    public RegisterPage passwordRegFieldInput(String password) {
        webDriver.findElement(passwordRegField).sendKeys(password);
        return this;
    }

    @Step
    public RegisterPage registerButtonClick() {
        webDriver.findElement(registerButton).click();
        return this;
    }

    @Step
    public RegisterPage passwordErrorAssertion(){
       Assert.assertTrue(webDriver.findElement(passwordError).isDisplayed());
        return this;
    }
    @Step
    public RegisterPage authLinkClick(){
        webDriver.findElement(authLink).click();
        return this;
    }






}