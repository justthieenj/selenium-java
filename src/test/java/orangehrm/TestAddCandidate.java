package orangehrm;

import base.BaseTest;
import com.github.justthieenj.utils.Utils;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.File;

public class TestAddCandidate extends BaseTest {
    @Test
    public void addCandidate() {
        dr.findElement(By.cssSelector("[name=username]")).sendKeys("Admin");
        dr.findElement(By.cssSelector("[name=password]")).sendKeys("admin123");
        dr.findElement(By.cssSelector(".orangehrm-login-button")).click();
        dr.findElement(By.cssSelector("ul.oxd-main-menu>li>a[href$='RecruitmentModule']")).click();
        dr.findElement(By.xpath("//div[@class='oxd-topbar-body']//a[text()='Candidates']")).click();
        dr.findElement(By.xpath("//div[@class='orangehrm-header-container']/button[normalize-space()='Add']")).click();
        dr.findElement(By.cssSelector("[name='firstName']")).sendKeys("Nguyen");
        dr.findElement(By.cssSelector("[name='middleName']")).sendKeys("Hoang");
        dr.findElement(By.cssSelector("[name='lastName']")).sendKeys("Lan");
        dr.findElement(By.cssSelector(".oxd-select-text-input")).click();
        dr.findElement(By.xpath("//*[contains(text(), 'Senior QA Lead')]")).click();
        dr.findElement(By.xpath("//label[text()='Email']/parent::div/following-sibling::div/input")).sendKeys("test1@gmail.com");
        dr.findElement(By.xpath("//label[text()='Contact Number']/parent::div/following-sibling::div/input")).sendKeys("0123456789");
        dr.findElement(By.xpath("//label[text()='Keywords']/parent::div/following-sibling::div/input")).sendKeys("Lan, test, Selenium");
        dr.findElement(By.xpath("//label[contains(text(),'Notes')]/parent::div/following-sibling::div/textarea")).sendKeys("Lan testing automation: Add candidate");
        File file = new File("");
        dr.findElement(By.cssSelector(".oxd-file-input")).sendKeys(file.getAbsolutePath());
        dr.findElement(By.cssSelector("button[type='submit']")).click();
        Utils.sleep(2);
    }
}
