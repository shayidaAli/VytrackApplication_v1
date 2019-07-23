package com.cybertek.tests.DataDrivenTest;

import com.cybertek.Pages.HomePageElements;
import com.cybertek.Pages.LogInPageElements;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DataDrivenTest {
    protected WebDriver driver;
    public Workbook workbook;
    public Sheet worksheet;


    @BeforeClass
    public void setUpMethod() {
        WebDriverManager.chromedriver().setup();
        driver = Driver.getDriver();// calling static method from Driver class. to initialize the driver here.
        //driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }



    @BeforeMethod
    public void getTestData() throws IOException {
        driver.get(ConfigurationReader.getProperty("url"));

        //Open filE and convert to stream of data
        FileInputStream inputStream = new FileInputStream("/Users/syd/Downloads/VytrackApplication_v1/src/test/resources/Book1.xlsx");

        //WORKBOOK > WORKSHEET > ROW > CELL

        //Open the WorkBook. Any type
         workbook = WorkbookFactory.create(inputStream);
         worksheet = workbook.getSheetAt(0);



    }

    @Test
    public void LoginTest() throws InterruptedException {

       for (int i=1; i< 4;i++){
            //read cell value using method chaining
            String username = worksheet.getRow(i).getCell(0).toString();
            String password = worksheet.getRow(i).getCell(1).toString();


            LogInPageElements logInPageElements = new LogInPageElements();
            logInPageElements.email.sendKeys(username);
            logInPageElements.password.sendKeys(password);
            logInPageElements.password.sendKeys(Keys.ENTER);

           Thread.sleep(3000);

           HomePageElements homePageElements= new HomePageElements();
           homePageElements.forlogout.click();
           homePageElements.logoutButton.click();

           Thread.sleep(3000);



        }
    }



    @AfterClass
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(1500);

        Driver.closeDriver();


    }
}
