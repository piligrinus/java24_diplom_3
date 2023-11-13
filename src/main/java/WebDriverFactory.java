import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static constans.BrowserProperty.YANDEX_BROWSER_LOCAL_PATH;

public class WebDriverFactory {
    public static WebDriver get() {
        WebDriver webDriver;
        String browserName = System.getProperty("browserName");

        switch (browserName) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=* ");
                webDriver = new ChromeDriver(options);

                break;
            case "yandex":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                ChromeOptions options1 = new ChromeOptions();
                options1.setBinary(YANDEX_BROWSER_LOCAL_PATH);
                options1.addArguments("--remote-allow-origins=* ");
                webDriver = new ChromeDriver(options1);

                break;
            default:
                throw new RuntimeException("Browser is not detected");
        }
        return webDriver;
    }
}
