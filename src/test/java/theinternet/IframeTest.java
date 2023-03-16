package theinternet;

import base.BaseTest;
import com.github.justthieenj.utils.Utils;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class IframeTest extends BaseTest {

    @Test
    public void test() {
        dr.get("https://the-internet.herokuapp.com/iframe");
        dr.switchTo().frame("mce_0_ifr");
        var textarea = dr.findElement(By.id("tinymce"));
        textarea.click();
        textarea.sendKeys("Hello World!");
        dr.switchTo().defaultContent();
        dr.findElement(By.xpath("//button[@role='menuitem'][1]")).click();
        Utils.sleep(2);
        // read more about Cross-Origin Resource Sharing (CORS)
    }
}
