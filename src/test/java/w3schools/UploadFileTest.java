package w3schools;

import com.github.justthieenj.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class UploadFileTest {

    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized", "--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_input_multiple");
        driver.switchTo().frame("iframeResult");
        driver.findElement(By.id("files")).sendKeys("D:/test.xlsx \n C:/Users/ngkha/OneDrive/Desktop/junk/gandalf.gif");
        Utils.sleep(2);
        driver.quit();
    }
}
