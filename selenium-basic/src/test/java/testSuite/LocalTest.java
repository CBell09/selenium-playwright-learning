package testSuite;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocalTest {
    WebDriver driver;

    @BeforeEach
    public void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=2560x1440");
        options.addArguments("--remote-debugging-pipe");
//        options.addArguments("--headless=new");
        driver = new ChromeDriver(options);
    }

    @AfterEach
    public void teardown(){
        driver.quit();
    }

    @Test
    public void testGoogle(){
        driver.get("https://www.google.com");
        System.out.println("Title: " + driver.getTitle());
    }
}
