package setup;

import static java.text.MessageFormat.format;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class DriverManager {
    private static       WebDriver driver;
    private static final String    LT_USERNAME     = System.getProperty ("username");
    private static final String    LT_ACCESS_TOKEN = System.getProperty ("accessKey");
    private static final String    GRID_URL        = "@hub.lambdatest.com/wd/hub";

    public static void quitDriver () {
        if (null != getDriver ()) {
            getDriver ().quit ();
        }
    }

    public static void createDriver (String browser) {
        if (browser.equalsIgnoreCase ("chrome")) {
            setupChromeDriver ();
        } else if (browser.equalsIgnoreCase ("firefox")) {
            setupFirefoxDriver ();
        } else if (browser.equalsIgnoreCase ("remote-chrome")) {
            setupRemoteChromeDriver ();
        } else {
            System.out.println ("Browser driver is not available!");
        }
        setupBrowserTimeouts ();
    }

    public static WebDriver getDriver () {
        return driver;
    }

    private static void setupChromeDriver () {
        final ChromeOptions options = new ChromeOptions ();
        options.addArguments ("--no-sandbox");
        options.addArguments ("--disable-dev-shm-usage");
        options.addArguments ("--window-size=1050,600");
        options.addArguments ("--safebrowsing-disable-download-protection");
        driver = WebDriverManager.chromedriver ()
            .capabilities (options)
            .create ();
    }

    private static void setupFirefoxDriver () {

        final FirefoxOptions options = new FirefoxOptions ();
        options.addArguments ("--no-sandbox");
        options.addArguments ("--disable-dev-shm-usage");
        options.addArguments ("--window-size=1050,600");
        driver = WebDriverManager.firefoxdriver ()
            .capabilities (options)
            .create ();
    }

    private static void setupRemoteChromeDriver () {
        ChromeOptions browserOptions = new ChromeOptions ();
        browserOptions.setPlatformName ("Windows 10");
        browserOptions.setBrowserVersion ("104.0");
        HashMap<String, Object> ltOptions = new HashMap<String, Object> ();
        ltOptions.put ("username", LT_USERNAME);
        ltOptions.put ("accessKey", LT_ACCESS_TOKEN);
        ltOptions.put ("selenium_version", "4.0.0");
        ltOptions.put ("build", "Shadow DOM Selenium Chrome Tests");
        ltOptions.put ("w3c", true);
        ltOptions.put ("plugin", "java-testNG");
        browserOptions.setCapability ("LT:Options", ltOptions);
        try {
            driver = new RemoteWebDriver (
                new URL (format ("https://{0}:{1}{2}", LT_USERNAME, LT_ACCESS_TOKEN, GRID_URL)), browserOptions);
        } catch (MalformedURLException e) {
            throw new Error (e);
        }
    }

    private static void setupBrowserTimeouts () {
        driver.manage ()
            .timeouts ()
            .implicitlyWait (Duration.ofSeconds (30));
        driver.manage ()
            .timeouts ()
            .pageLoadTimeout (Duration.ofSeconds (30));
        driver.manage ()
            .timeouts ()
            .scriptTimeout (Duration.ofSeconds (30));
    }

}
