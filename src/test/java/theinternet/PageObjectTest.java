package theinternet;

import base.BaseTest;
import com.github.justthieenj.pageobject.TheInternet;
import com.github.justthieenj.utils.ActionsUtil;
import com.github.justthieenj.utils.Utils;
import com.github.justthieenj.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageObjectTest extends BaseTest {
    TheInternet theInternet;

    @Test
    public void dragAndDropTest() {
        theInternet = new TheInternet(dr);
        dr.get("https://the-internet.herokuapp.com/");
        WaitUtils.waitForVisible(dr, theInternet.drag_and_drop()).click();
        WaitUtils.waitForVisible(dr, theInternet.boxA());
        ActionsUtil.dragAndDrop(dr, theInternet.boxA(), theInternet.boxB());
        Assert.assertEquals("A", theInternet.boxB().getText());
        Utils.sleep(2);
    }
}
