package theinternet;

import base.BaseTest;
import com.github.justthieenj.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsTest extends BaseTest {

    @Test
    public void hover() {
        dr.get("https://the-internet.herokuapp.com/hovers");
        for (int i = 1; i <= 3; i++) {
            hoverToAvatar(i);
            Utils.sleep(1);
        }
    }

    private WebElement getAvatar(int index) {
        return dr.findElement(By.xpath("//div[@class='figure'][%d]/img".formatted(index)));
    }

    private void hoverToAvatar(int index) {
        new Actions(dr)
                .moveToElement(getAvatar(index))
                .build()
                .perform();
    }

    @Test
    public void dragAndDrop() {
        dr.get("https://the-internet.herokuapp.com/drag_and_drop");
        var source = dr.findElement(By.id("column-a"));
        var target = dr.findElement(By.id("column-b"));
        new Actions(dr)
                .dragAndDrop(source, target)
                .build()
                .perform();
    }

    @Test
    public void dragTo() {
        dr.get("https://the-internet.herokuapp.com/drag_and_drop");
        var element = dr.findElement(By.id("column-b"));
        var actions = new Actions(dr).clickAndHold(element);
        actions.moveByOffset(-200, 500);
        actions.build().perform();
        Utils.sleep(2);
    }

    @Test
    public void scroll(){
        dr.get("https://the-internet.herokuapp.com/");
        var element = dr.findElement(By.cssSelector("[href*='redirector']"));
        new Actions(dr).scrollToElement(element).build().perform();
        Utils.sleep(2);
    }
}
