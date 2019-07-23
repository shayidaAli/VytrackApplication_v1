package com.cybertek.Pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class HomePageElements {
    public HomePageElements(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //fleet,
    //Vehicles
    //Customer, Account, contact
    //activities
    @FindBy (xpath = "//*[@id=\"main-menu\"]/ul/li[1]/a/span")
    public WebElement fleet;

    @FindBy (xpath ="//li[@class='dropdown-menu-single-item first']//span[@class='title title-level-2'][contains(text(),'Vehicles')]")
    public WebElement Vehicle;

    @FindBy (xpath = "//*[@id=\"user-menu\"]/a")
    public WebElement forlogout;

    @FindBy (xpath = "//*[@id=\"user-menu\"]/ul/li[5]/a")
    public WebElement logoutButton;






}
