package com.cybertek.tests.components.activities;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class activities_test {
    public activities_test() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath= "xx")
    public WebElement username;

}
