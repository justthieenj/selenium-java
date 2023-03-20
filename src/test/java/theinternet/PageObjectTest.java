package theinternet;

import base.BaseTest;
import com.github.justthieenj.pageobject.HomePage;
import com.github.justthieenj.utils.ActionsUtil;
import com.github.justthieenj.utils.Utils;
import com.github.justthieenj.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageObjectTest extends BaseTest {
    HomePage homePage;

    @Test
    public void dragAndDropTest() {
        homePage = new HomePage(dr);
        dr.get("https://the-internet.herokuapp.com/");
        WaitUtils.waitForVisible(dr, homePage.dragAndDrop()).click();
        WaitUtils.waitForVisible(dr, homePage.boxA());
        ActionsUtil.dragAndDrop(dr, homePage.boxA(), homePage.boxB());
        Assert.assertEquals("A", homePage.boxB().getText());
        Utils.sleep(2);
    }
}
