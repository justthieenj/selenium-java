package orangehrm;

import base.BaseTest;
import com.github.justthieenj.elements.CustomSelect;
import com.github.justthieenj.utils.Utils;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class BasicMethodsTest extends BaseTest {
    @Test
    public void basicMethods() {
        login();
        dr.findElement(By.cssSelector("ul.oxd-main-menu>li>a[href$='RecruitmentModule']")).click();
        var checkboxAll = dr.findElement(By.cssSelector(".oxd-table-header input[type=checkbox]"));
        Utils.sleep(2);
    }
}
