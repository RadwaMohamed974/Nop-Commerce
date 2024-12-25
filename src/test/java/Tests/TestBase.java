package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

public class TestBase {
        public WebDriver driver;

    @BeforeSuite
    @Parameters({"browser"})
        public void StartDriver( @Optional("chrome") String browserName)// اوبشن دي عشان فايل اكس م ال ياخد من اكس ام فايل
    {
if (browserName.equalsIgnoreCase("chrome"))
{
    driver=new ChromeDriver();
}
else if (browserName.equalsIgnoreCase("Firefox"))
{
    driver=new FirefoxDriver();
}
else if (browserName.equalsIgnoreCase("Edge"))
{
    driver=new EdgeDriver();
}


            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        driver.navigate().to("https://demo.nopcommerce.com/");
        }

        @AfterSuite
        public void StopDriver(){
            driver.quit();
        }


    }


