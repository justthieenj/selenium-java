package theinternet;

import com.github.justthieenj.utils.Utils;
import com.github.justthieenj.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class WaitTest {
    private WebDriver driver;

    @BeforeTest
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize(); // only work when running locally
        driver.get("https://the-internet.herokuapp.com/");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void explicit() {
        WaitUtils.waitForVisible(driver, By.cssSelector("[href*=disappearing_elements]")).click();
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[href*=home]")));
        Utils.sleep(2);
    }

    @Test
    public void fluentWait(){
        var wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(30));
        wait.pollingEvery(Duration.ofMillis(200));
        wait.ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[href*=home]")));
    }
}
