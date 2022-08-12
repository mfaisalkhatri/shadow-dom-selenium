package setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class DriverManager {
    private static WebDriver driver;
    public static void quitDriver() {
        if (null != getDriver()) {
            getDriver().quit();
        }
    }

    public static void createDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            setupChromeDriver();
        } else if(browser.equalsIgnoreCase("firefox"))  {
            setupFirefoxDriver();
        } else {
            System.out.println("Browser driver is not available!");
        }
        setupBrowserTimeouts();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    private static void setupChromeDriver() {
        final ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1050,600");
        options.addArguments("--safebrowsing-disable-download-protection");
        driver = WebDriverManager.chromedriver()
                .capabilities(options)
                .create();
    }

    private static void setupFirefoxDriver() {

        final FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1050,600");
        driver = WebDriverManager.firefoxdriver()
                .capabilities(options)
                .create();
    }


    private static void setupBrowserTimeouts() {
        driver.manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(30));
        driver.manage()
                .timeouts()
                .pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage()
                .timeouts()
                .scriptTimeout(Duration.ofSeconds(30));
    }

}
