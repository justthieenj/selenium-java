package com.github.justthieenj.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    public WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement dropDown() {
        return driver.findElement(By.cssSelector("#content [href$='dropdown']"));
    }

    public WebElement dragAndDrop() {
        return driver.findElement(By.cssSelector("#content [href$='drag_and_drop']"));
    }

    public WebElement boxA() {
        return driver.findElement(By.cssSelector("#column-a"));
    }

    public WebElement boxB() {
        return driver.findElement(By.cssSelector("#column-b"));
    }
}
