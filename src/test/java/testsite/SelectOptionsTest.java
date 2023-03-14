package testsite;

import com.github.justthieenj.elements.CustomSelect;
import com.github.justthieenj.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SelectOptionsTest {
    private static WebDriver driver;

    public static void main(String[] args) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://127.0.0.1:3000/testsite/index.html");
        var select = new CustomSelect(driver.findElement(By.cssSelector("#abc")));
        select.selectByValue("B");
        Utils.sleep(2);
        driver.close();
    }
}
