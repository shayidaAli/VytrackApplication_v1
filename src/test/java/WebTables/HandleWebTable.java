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

import java.util.*;
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
    public void test1() {

  //go to the url
  driver.get("https://www.toolsqa.com/automation-practice-table/");


  //get all the headers from the webtable
  List<WebElement> headers = driver.findElements(By.xpath("//table[@class='tsc_table_s13']//thead"));

  for (WebElement headName : headers) {
   System.out.println("table headers:" + headName.getText());
  }


  //get all the cell information for first row under tbody
  List<WebElement> first_row = driver.findElements(By.xpath("//table[@class='tsc_table_s13']//tbody//tr[1]"));

  for (WebElement cellname : first_row) {
   System.out.println("table row 1:" + cellname.getText());
  }


  // print out Dubai
  WebElement jgdjfg = driver.findElement(By.xpath("//table[@class='tsc_table_s13']//tbody//tr[1]//td[2]"));
  System.out.println(jgdjfg.getText());


  //print out all the rank for each city:
  // tips:
  // 1. go to each line get city name, city1, city2, city3.., create an arraylist with all city name.
  // 2. go to each line again get the rank , rank1, rank2, rank3..., create arraylist with all ranks.
  //
  //
  // each arraylist

  //get all the cities name in one list
  List<String> city_name = new ArrayList<>();

  String city1 = driver.findElement(By.xpath("//*[@id=\"content\"]/table/tbody/tr[1]/td[2]")).getText();
  String city2 = driver.findElement(By.xpath("//*[@id=\"content\"]/table/tbody/tr[2]/td[2]")).getText();
  String city3 = driver.findElement(By.xpath("//*[@id=\"content\"]/table/tbody/tr[3]/td[2]")).getText();
  String city4 = driver.findElement(By.xpath("//*[@id=\"content\"]/table/tbody/tr[4]/td[2]")).getText();
  city_name.add(city1);
  city_name.add(city2);
  city_name.add(city3);
  city_name.add(city4);
  System.out.println(city_name.toString());


  //get all the ranks in one list
  List<String> city_rank = new ArrayList<>();

  String rank1 = driver.findElement(By.xpath("//*[@id=\"content\"]/table/tbody/tr[1]/td[5]")).getText();
  String rank2 = driver.findElement(By.xpath("//*[@id=\"content\"]/table/tbody/tr[2]/td[5]")).getText();
  String rank3 = driver.findElement(By.xpath("//*[@id=\"content\"]/table/tbody/tr[3]/td[5]")).getText();
  String rank4 = driver.findElement(By.xpath("//*[@id=\"content\"]/table/tbody/tr[4]/td[5]")).getText();
  city_rank.add(rank1);
  city_rank.add(rank2);
  city_rank.add(rank3);
  city_rank.add(rank4);
  System.out.println(city_rank.toString());


// get all the countries in one list
  List<String> country = new ArrayList<>();

  String country1 = driver.findElement(By.xpath("//*[@id=\"content\"]/table/tbody/tr[1]/td[1]")).getText();
  String country2 = driver.findElement(By.xpath("//*[@id=\"content\"]/table/tbody/tr[2]/td[1]")).getText();
  String country3 = driver.findElement(By.xpath("//*[@id=\"content\"]/table/tbody/tr[3]/td[1]")).getText();
  String country4 = driver.findElement(By.xpath("//*[@id=\"content\"]/table/tbody/tr[4]/td[1]")).getText();
  country.add(country1);
  country.add(country2);
  country.add(country3);
  country.add(country4);


// get all the built years in one list
  List<String> built_years = new ArrayList<>();

  String year1 = driver.findElement(By.xpath("//*[@id=\"content\"]/table/tbody/tr[1]/td[4]")).getText();
  String year2 = driver.findElement(By.xpath("//*[@id=\"content\"]/table/tbody/tr[2]/td[4]")).getText();
  String year3 = driver.findElement(By.xpath("//*[@id=\"content\"]/table/tbody/tr[3]/td[4]")).getText();
  String year4 = driver.findElement(By.xpath("//*[@id=\"content\"]/table/tbody/tr[4]/td[4]")).getText();
  built_years.add(year1);
  built_years.add(year2);
  built_years.add(year3);
  built_years.add(year4);


  //GET ALL THE STRUCTURES NAME
  List<String> structures = new ArrayList<>();
  String s1 = driver.findElement(By.xpath("//*[@id=\"content\"]/table/tbody/tr[1]/th")).getText();
  String s2 = driver.findElement(By.xpath("//*[@id=\"content\"]/table/tbody/tr[2]/th")).getText();
  String s3 = driver.findElement(By.xpath("//*[@id=\"content\"]/table/tbody/tr[3]/th")).getText();
  String s4 = driver.findElement(By.xpath("//*[@id=\"content\"]/table/tbody/tr[4]/th")).getText();
  structures.add(s1);
  structures.add(s2);
  structures.add(s3);
  structures.add(s4);


  //CREATING MAP FOR WEB TABLE
  Map<String, List> table = new TreeMap<>();
  // table head== key
  // table body == value

  table.put("structures", structures);
  table.put("cities", city_name);
  table.put("ranks", city_rank);
  table.put("countries", country);
  table.put("built_years", built_years);

  System.out.println(table.toString());





  //for the city name:
  List<String> cities = new ArrayList<>();
  for (int i = 1; i <= 4; i++) {

   cities.add( driver.findElement(By.xpath("//*[@id=\"content\"]/table/tbody/tr[" + i + "]/td[2]")).getText()  );

  }

  List<String> ranks = new ArrayList<>();
  for (int i = 1; i <= 4; i++) {

   ranks.add( driver.findElement(By.xpath("//*[@id=\"content\"]/table/tbody/tr[" + i + "]/td[5]")).getText()  );

  }



 }
 @AfterMethod
    public void closing(){
     Driver.closeDriver();
 }


}
