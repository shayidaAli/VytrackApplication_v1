package com.cybertek.tests.components.login_navigation;

import com.cybertek.Pages.LogInPageElements;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest  {


    @Test
    public void PositiveLoginTest(){


        //log in as STORE MANAGER
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        LogInPageElements pageElements=new LogInPageElements();
        pageElements.email.sendKeys(ConfigurationReader.getProperty("driver_username"));
        pageElements.password.sendKeys(ConfigurationReader.getProperty("driver_password"));
        pageElements.loginbutton.click();




       //pageElements.login(ConfigurationReader.getProperty("driver_username"),ConfigurationReader.getProperty("driver_password"));


        //log in as SALES MANAGER


        //log in as DRIVER


    }


    @Test
    public void NegativeLoginTest(){



    }

}
