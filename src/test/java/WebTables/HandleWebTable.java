package WebTables;

import com.cybertek.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HandleWebTable {

    protected WebDriver driver;


 @BeforeMethod
    public void setup(){
     WebDriverManager.chromedriver().setup();
     driver = Driver.getDriver();// calling static method from Driver class. to initialize the driver here.
     driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
 }


 @Test
    public void test1(){

     //go to the url
     driver.get("https://www.toolsqa.com/automation-practice-table/");


     //get all the headers from the webtable
     List<WebElement> headers= driver.findElements(By.xpath("//table[@class='tsc_table_s13']//thead"));

     for (WebElement headName: headers){
         System.out.println("table headers:"  +headName.getText());
     }


     //get all the cell information for first row under tbody
     List<WebElement> first_row= driver.findElements(By.xpath("//table[@class='tsc_table_s13']//tbody//tr[1]"));

     for (WebElement cellname : first_row){
         System.out.println("table row 1:"  +cellname.getText());
     }


     // print out Dubai
     WebElement jgdjfg= driver.findElement(By.xpath("//table[@class='tsc_table_s13']//tbody//tr[1]//td[2]"));
     System.out.println(jgdjfg.getText());




     //print out all the rank for each city:
     // tips:
     // 1. go to each line get city name, city1, city2, city3.., create an arraylist with all city name.
     // 2. go to each line again get the rank , rank1, rank2, rank3..., create arraylist with all ranks.
     //
     //
     // each arraylist




 }


 @AfterMethod
    public void closing(){
     Driver.closeDriver();
 }


}
