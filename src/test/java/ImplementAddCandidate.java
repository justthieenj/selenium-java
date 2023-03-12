import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplementAddCandidate {
    private WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void addCandidate() {
        driver.findElement(By.cssSelector("[name=username]")).sendKeys("Admin");
        driver.findElement(By.cssSelector("[name=password]")).sendKeys("admin123");
        driver.findElement(By.cssSelector(".orangehrm-login-button")).click();
        driver.findElement(By.cssSelector("ul.oxd-main-menu>li>a[href$='RecruitmentModule']")).click();
        driver.findElement(By.xpath("//div[@class='oxd-topbar-body']//a[text()='Candidates']")).click();
        driver.findElement(By.xpath("//div[@class='orangehrm-header-container']/button[normalize-space()='Add']")).click();
        driver.findElement(By.cssSelector("[name='firstName']")).sendKeys("Nguyen");
        driver.findElement(By.cssSelector("[name='middleName']")).sendKeys("Hoang");
        driver.findElement(By.cssSelector("[name='lastName']")).sendKeys("Lan");
//        new Select(driver.findElement(By.cssSelector(".oxd-select-text-input"))).selectByVisibleText("Senior QA Lead");
        driver.findElement(By.xpath("//label[text()='Email']/parent::div/following-sibling::div/input")).sendKeys("test1@gmail.com");
        driver.findElement(By.xpath("//label[text()='Contact Number']/parent::div/following-sibling::div/input")).sendKeys("0123456789");
        driver.findElement(By.xpath("//label[text()='Keywords']/parent::div/following-sibling::div/input")).sendKeys("Lan, test, Selenium");
        driver.findElement(By.xpath("//label[contains(text(),'Notes')]/parent::div/following-sibling::div/textarea")).sendKeys("Lan testing automation: Add candidate");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
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
