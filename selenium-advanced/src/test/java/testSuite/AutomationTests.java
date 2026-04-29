package testSuite;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

@Execution(ExecutionMode.CONCURRENT)
public class AutomationTests extends BaseTest{

    @Test
    @Tag("TEST1")
    @Tag("TESTS")
    public void test1() throws InterruptedException {
        driver.navigate().to("https://www.google.com");
        Thread.sleep(1000);
        String PageURL = driver.getCurrentUrl();
        System.out.println("The current URL is " +PageURL);
        driver.findElement(By.cssSelector("textarea[class='gLFyf']")).sendKeys("The Expanse", Keys.ENTER);
        Thread.sleep(5000);
        System.out.println("I made it to Google!");
        System.out.println("WHOHOO");
    }

    @Test
    @Tag("TEST2")
    @Tag("TESTS")
    public void test2() throws InterruptedException {
        driver.navigate().to("https://www.espn.com");
        Thread.sleep(1000);
        String PageURL = driver.getCurrentUrl();
        System.out.println("The current URL is " +PageURL);
        Thread.sleep(5000);
        System.out.println("I made it to ESPN!");
        System.out.println("WHOHOO");
    }

    @Test
    @Tag("TEST3")
    @Tag("TESTS")
    public void test3() throws InterruptedException {
        driver.navigate().to("https://www.bing.com");
        Thread.sleep(1000);
        String PageURL = driver.getCurrentUrl();
        System.out.println("The current URL is " +PageURL);
        Thread.sleep(5000);
        System.out.println("I made it to Bing!");
        System.out.println("WHOHOO");
    }
}
