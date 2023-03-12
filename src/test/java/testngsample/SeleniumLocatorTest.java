package testngsample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SeleniumLocatorTest {
    @Test
    public void testLocators() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://steamcommunity.com/login/home/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertTrue(driver.findElement(By.cssSelector("input.newlogindialog_TextInput_2eKVn")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("input[type=password]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("button[type=submit]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector(".newlogindialog_Checkbox_3tTFg")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector(".qrcode_QRBits_3FhhK.qrlogin_LoginQR_1wtS3")).isDisplayed());
        driver.close();
    }
}
