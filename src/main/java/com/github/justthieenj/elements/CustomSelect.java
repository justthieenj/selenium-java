package com.github.justthieenj.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class CustomSelect extends Select {
    public CustomSelect(WebElement element) {
        super(element);
    }

    public List<String> getAllOptionsText() {
        return getOptions()
                .stream()
                .collect(ArrayList::new, (list, o) -> list.add(o.getText()), ArrayList::addAll);
    }

    public List<String> getAllOptionsValue() {
        return getOptions()
                .stream()
                .collect(ArrayList::new, (list, o) -> list.add(o.getAttribute("value")), ArrayList::addAll);
    }
}
