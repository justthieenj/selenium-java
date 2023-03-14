package testsite;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AlertTest {
    private static WebDriver driver;

    public static void main(String[] args) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://127.0.0.1:3000/testsite/index.html");
        Alert alert = driver.switchTo().alert();
        alert.accept();
        driver.switchTo().defaultContent();
    }
}
