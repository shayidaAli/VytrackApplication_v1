package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class TestBase {

    protected WebDriver driver;
    protected SoftAssert softAssert;
    protected Actions actions;


    @BeforeMethod
    public void setUpMethod() {
        WebDriverManager.chromedriver().setup();
        driver = Driver.getDriver();// calling static method from Driver class. to initialize the driver here.
        //driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        actions = new Actions(driver);
        softAssert = new SoftAssert();
    }


    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(1500);

        Driver.closeDriver();


    }
}