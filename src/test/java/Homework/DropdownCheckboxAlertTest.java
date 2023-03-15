package Homework;

import base.BaseTest;
import com.github.justthieenj.elements.CustomSelect;
import com.github.justthieenj.utils.Utils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropdownCheckboxAlertTest extends BaseTest {

    @Test
    public void dropdownInteraction() {
        dr.get("https://the-internet.herokuapp.com/");
        dr.findElement(By.cssSelector("#content [href$='dropdown']")).click();
        Select dropdown = new CustomSelect(dr.findElement(By.cssSelector("#dropdown")));
        dropdown.selectByVisibleText("Option 2");
        Utils.sleep(2);
    }

    @Test
    public void checkboxInteraction() {
        dr.get("https://the-internet.herokuapp.com/");
        dr.findElement(By.cssSelector("#content [href$='checkboxes']")).click();

        //Check all checkboxes
        var checkboxes = dr.findElements(By.cssSelector("[type=checkbox]"));
        checkboxes.forEach(o -> {
            if (!o.isSelected()) {
                o.click();
            }
        });
        Utils.sleep(2);

        //Uncheck checkbox 2
        var checkbox2 = dr.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));
        if (checkbox2.isSelected()) { checkbox2.click(); }
        Utils.sleep(2);
    }

    @Test
    public void alertInteraction() {
        dr.get("https://the-internet.herokuapp.com/");
        dr.findElement(By.cssSelector("#content [href$='alerts']")).click();

        //Accept alert
        dr.findElement(By.cssSelector("button[onclick='jsAlert()']")).click();
        Utils.sleep(2);
        Alert alert = dr.switchTo().alert();
        alert.accept();
        dr.switchTo().defaultContent();
        Utils.sleep(2);
    }
}
