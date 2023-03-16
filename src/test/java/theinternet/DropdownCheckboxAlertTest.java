package theinternet;

import base.BaseTest;
import com.github.justthieenj.elements.CustomSelect;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropdownCheckboxAlertTest extends BaseTest {

    @Test
    public void dropdownInteraction() {
        dr.get("https://the-internet.herokuapp.com/");
        dr.findElement(By.cssSelector("#content [href$='dropdown']")).click();
        Select dropdown = new CustomSelect(dr.findElement(By.cssSelector("#dropdown")));
        dropdown.selectByVisibleText("Option 2");
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "Option 2");
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
                Assert.assertTrue(o.isSelected());
            }
        });

        //Uncheck checkbox 2
        var checkbox2 = dr.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));
        if (checkbox2.isSelected()) {
            checkbox2.click();
            Assert.assertFalse(checkbox2.isSelected());
        }
    }

    @Test
    public void alertInteraction() {
        dr.get("https://the-internet.herokuapp.com/");
        dr.findElement(By.cssSelector("#content [href$='alerts']")).click();

        //Accept alert
        dr.findElement(By.cssSelector("button[onclick='jsAlert()']")).click();
        Alert jsAlert = dr.switchTo().alert();
        System.out.println(jsAlert.getText());
        jsAlert.accept();
        dr.switchTo().defaultContent();

        //Dísmiss alert
        dr.findElement(By.cssSelector("button[onclick='jsConfirm()']")).click();
        Alert jsConfirm = dr.switchTo().alert();
        System.out.println(jsConfirm.getText());
        jsConfirm.dismiss();
        dr.switchTo().defaultContent();

        //Send key to alert
        dr.findElement(By.cssSelector("button[onclick='jsPrompt()']")).click();
        Alert jsPrompt = dr.switchTo().alert();
        System.out.println(jsPrompt.getText());
        jsPrompt.sendKeys("Lan Nguyen testing");
        jsPrompt.dismiss();
        dr.switchTo().defaultContent();
    }
}
