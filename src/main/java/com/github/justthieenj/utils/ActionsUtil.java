package com.github.justthieenj.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsUtil {
    public static void dragAndDrop(WebDriver webDriver, WebElement source, WebElement target) {
        new Actions(webDriver)
                .dragAndDrop(source, target)
                .build()
                .perform();
    }
}
