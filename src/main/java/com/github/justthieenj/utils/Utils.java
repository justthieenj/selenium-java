package com.github.justthieenj.utils;

import org.openqa.selenium.WebDriver;

public class Utils {
    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
