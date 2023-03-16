package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public abstract class BaseTest {
    protected WebDriver dr;

    @BeforeTest
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        dr = new ChromeDriver(options);
        dr.manage().window().maximize();
        dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterTest
    public void tearDown() {
        dr.close();
    }

    protected void login() {
        var username = dr.findElement(By.cssSelector("[name=username]"));
//        username.sendKeys("admin123");
//        username.sendKeys(Keys.CONTROL + "A" + Keys.DELETE);
        username.sendKeys("Admin");
        dr.findElement(By.cssSelector("[name=password]")).sendKeys("admin123");
        dr.findElement(By.cssSelector(".orangehrm-login-button")).click();
    }
}
