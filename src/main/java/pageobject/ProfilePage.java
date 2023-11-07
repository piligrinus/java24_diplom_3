package pageobject;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static config.AppConfig.APP_URL_PROFILE_PAGE;

public class ProfilePage {
    WebDriver webDriver;

    public ProfilePage (WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.get(APP_URL_PROFILE_PAGE);
    }

    private By exitButton = By.className("Account_button__14Yp3");
    private By enterConstructorButton = By.xpath(".//p[text()='Конструктор']");
    private By logoButton = By.className("AppHeader_header__logo__2D0X2");


    @Step
    public ProfilePage exitButtonClick() {
        webDriver.findElement(exitButton).click();
        return this;
    }
    @Step
    public ProfilePage enterConstructorButtonClick() throws InterruptedException {
        Thread.sleep(3000);
        webDriver.findElement(enterConstructorButton).click();
        return this;
    }
    @Step
    public ProfilePage logoButtonClick(){
        webDriver.findElement(logoButton).click();
        return this;
    }

}