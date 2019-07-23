package com.cybertek.Pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInPageElements {

    public LogInPageElements(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // Webelement element= driver.findElement(By.id/xpath/css/className...
    @FindBy(name = "_username")
    public WebElement email;

    @FindBy(name = "_password")
    public  WebElement password;

    @FindBy(name = "_submit")
    public  WebElement loginbutton;




    public  void login(String userName, String password){
        this.email.sendKeys(userName);
        this.password.sendKeys(password);
        loginbutton.click();
    }

}
