package com.cybertek.tests.smoke_tests;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MenuOptionTest extends TestBase {


//    @Test(groups = {"driver"})
//    public void test1(){
//        Assert.assertFalse(false);
//    }

    //test: Menu options, driver
    @Test(groups = {"driver"})
    public void test1() {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        //Navigate to Dashbord, verify title
        driver.get(ConfigurationReader.getProperty("url"));
        driver.findElement(By.name("_username")).sendKeys(ConfigurationReader.getProperty("driver_username"));
        driver.findElement(By.name("_password")).sendKeys(ConfigurationReader.getProperty("driver_password"));
        driver.findElement(By.name("_password")).sendKeys(Keys.ENTER);
        String title = driver.getTitle();
        softAssert.assertEquals(title, "Dashboard");


        //Navigate to Fleet, verify the title
        Actions actions=new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Fleet')]"))).build().perform();
        driver.findElement(By.xpath("//li[@class='dropdown-menu-single-item first']//span[@class='title title-level-2'][contains(text(),'Vehicles')]")).click();
        String title2=driver.getTitle();
        softAssert.assertEquals(title2,"Car - Entities - System - Car - Entities – System");



    }

    //test: Menu options, manager
    @Test
    public void test2(){
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        //Navigate to Dashbord, verify title
        driver.get(ConfigurationReader.getProperty("url"));
        driver.findElement(By.name("_username")).sendKeys(ConfigurationReader.getProperty("manager_username"));
        driver.findElement(By.name("_password")).sendKeys(ConfigurationReader.getProperty("manager_username"));
        driver.findElement(By.name("_password")).sendKeys(Keys.ENTER);

        //navigate to fleet


    }

}
