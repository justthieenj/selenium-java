package testngsample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    @Test
    public void loginSuccessfully() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("[name=username]")).sendKeys("Admin");
        driver.findElement(By.cssSelector("[name=password]")).sendKeys("admin123");
        driver.findElement(By.cssSelector(".orangehrm-login-button")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector(".oxd-topbar-header-breadcrumb")).isDisplayed());
        sleep(2);
        driver.close();
    }

    private static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
