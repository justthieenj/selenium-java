package com.github.justthieenj.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DragAndDropPage {
    public WebDriver driver;

    public DragAndDropPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement boxA() {
        return driver.findElement(By.cssSelector("#column-a"));
    }
}
