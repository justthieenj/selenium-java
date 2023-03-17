package theinternet;

import base.BaseTest;
import com.github.justthieenj.utils.Utils;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

public class TabsTest extends BaseTest {

    @Test
    public void test() {
        dr.get("https://the-internet.herokuapp.com/iframe");
        dr.switchTo().newWindow(WindowType.TAB).navigate().to("https://google.com");
        dr.switchTo().newWindow(WindowType.WINDOW).navigate().to("https://facebook.com");
        dr.switchTo().newWindow(WindowType.TAB).navigate().to("https://facebook.com");
        dr.close();
        Utils.sleep(2);
    }
}
