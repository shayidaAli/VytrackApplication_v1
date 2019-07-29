package extendReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class extendReportTest {
//
//    static ExtentTest test;
//
//    static ExtentReports report;
//
//    @BeforeClass
//
//    public static void startTest() {
//
//        report = new ExtentReports(System.getProperty("user.dir") + "\\ExtentReportResults.html");
//
//        test = report.startTest("ExtentDemo");
//
//    }
//
//    @Test
//
//    public void extentReportsDemo() {
//
//        System.setProperty("webdriver.chrome.driver", "D:\\SubmittalExchange_TFS\\QA\\Automation\\3rdparty\\chrome\\chromedriver.exe");
//
//        WebDriver driver = new ChromeDriver();
//
//        driver.get("https://www.google.co.in");
//
//        if (driver.getTitle().equals("Google")) {
//
//            test.log(LogStatus.PASS, "Navigated to the specified URL");
//
//        } else {
//
//            test.log(LogStatus.FAIL, "Test Failed");
//
//        }
//
//    }
//
//    @AfterClass
//
//    public static void endTest()
//
//    {
//
//        report.endTest(test);
//
//        report.flush();
//
//    }
//
}


/*
#1) getScreenShotAs() method is used to capture the screenshot of the current WebDriver instance and store it in various output forms.

File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

#2) getScreenShotAs method returns a file object which needs to be stored onto a file variable. Please note that casting the web driver instance to Take Screenshot is mandatory if you want to use the method.

#3) File Dest = new File(“src/../ErrImages/” + System.currentTimeMillis()+ “.png”);

#4) The above statement creates a folder named ‘ErrImages’ within the ‘src’ folder and stores the file name as the current system time.

#5) String errflpath = Dest.getAbsolutePath();
FileUtils.copyFile(scrFile, Dest);
returnerrflpath;

#6) The above statements copy the error images to the destination folder.


 */