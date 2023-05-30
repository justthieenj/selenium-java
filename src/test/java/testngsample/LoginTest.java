package testngsample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {
    @Test(dataProvider = "newName")
    public void loginSuccessfully(String username) {
        System.out.println("username: " + username);
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.cssSelector("[name=username]")).sendKeys("Admin");
        driver.findElement(By.cssSelector("[name=password]")).sendKeys("admin123");
        driver.findElement(By.cssSelector(".orangehrm-login-button")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector(".oxd-topbar-header-breadcrumb")).isDisplayed());
        sleep(2);
        driver.close();
    }

    @DataProvider(name = "newName")
    public Object[] loginData() {
        return new Object[]{"Admin", "User1", "User2"};
    }

    private static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
