package pageobject;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static config.AppConfig.APP_URL_LOGIN_PAGE;
public class LoginPage {
    WebDriver webDriver;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.get(APP_URL_LOGIN_PAGE);
    }

    private By emailLoginField = By.xpath(".//fieldset[1]/div/div/input");
    private By passwordLoginField = By.xpath(".//fieldset[2]/div/div/input");
    private By loginButton = By.xpath(".//form/button");

    @Step
    public LoginPage emailLoginFieldInput(String email){
        webDriver.findElement(emailLoginField).sendKeys(email);
        return this;
    }
    @Step
    public LoginPage passwordLoginFieldInput(String password){
        webDriver.findElement(passwordLoginField).sendKeys(password);
        return this;
    }
    @Step
    public LoginPage loginButtonClick(){
        webDriver.findElement(loginButton).click();
        return this;
    }

    @Step
    public LoginPage LoginUser(String email,String password){
        emailLoginFieldInput(email);
        passwordLoginFieldInput(password);
        loginButtonClick();
        return this;

    }

    }


