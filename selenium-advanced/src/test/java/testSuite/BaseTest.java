package testSuite;

import com.titusfortner.logging.SeleniumLogger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import java.util.logging.Level;

public class BaseTest {
    protected static WebDriver driver;
    protected SeleniumLogger seleniumLogger;


    @BeforeAll
    public static void allStart(){
        System.out.println("Test output start");

    }

    @BeforeEach
    public void startDriver() throws MalformedURLException {
        seleniumLogger = selectSeleniumLogLevel(System.getenv("SEL_LOG_LEVEL"));
        driver = selectDriver(System.getenv("BROWSER"));
    }

    @AfterEach
    public void quitDriver(){
        if(driver != null){
            driver.quit();
        }
    }

    @AfterAll
    public static void allDone(){
        System.out.println("Test output end");
    }

    public WebDriver selectDriver(String desiredWebDriver) throws MalformedURLException {
        switch (desiredWebDriver.toUpperCase(Locale.US)) {
            case "CHROME": {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--verbose");
//                options.addArguments("--headless");
                options.addArguments("--no-sandbox");
                options.addArguments("--window-size=1920,1080");
                if (System.getenv("TESTHOST").equals("GRADLE")) {
                    driver = new ChromeDriver(options);
                } else if (System.getenv("TESTHOST").equals("DOCKER")) {
                    driver = new RemoteWebDriver(new URL("http://selenium-hub-intel:4444/wd/hub"), options);
                }
                break;
            }
            case "EDGE": {
                EdgeOptions options = new EdgeOptions();
                options.addArguments("--verbose");
//                options.addArguments("--headless");
                options.addArguments("--no-sandbox");
                options.addArguments("--window-size=1920,1080");
                if (System.getenv("TESTHOST").equals("GRADLE")) {
                    driver = new EdgeDriver(options);
                } else if (System.getenv("TESTHOST").equals("DOCKER")) {
                    driver = new RemoteWebDriver(new URL("http://selenium-hub-intel:4444/wd/hub"), options);
                }
                break;
            }

            case "FIREFOX": {
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--verbose");
//                options.addArguments("--headless");
                options.addArguments("--no-sandbox");
                options.addArguments("--window-size=1920,1080");
                if (System.getenv("TESTHOST").equals("GRADLE")) {
                    driver = new FirefoxDriver(options);
                } else if (System.getenv("TESTHOST").equals("DOCKER")) {
                    driver = new RemoteWebDriver(new URL("http://selenium-hub-intel:4444/wd/hub"), options);
                    break;
                }
            }
        }
        return driver;
    }

    public SeleniumLogger selectSeleniumLogLevel(String desiredLogLevel){
        seleniumLogger = new SeleniumLogger();
        seleniumLogger.setLevel(Level.parse(desiredLogLevel));
        return seleniumLogger;
    }
}
