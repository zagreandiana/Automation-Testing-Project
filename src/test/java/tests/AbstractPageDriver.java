package tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractPageDriver {

    public static WebDriver driver = new ChromeDriver();
    public static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public AbstractPageDriver(){

    }

    public static void navigateToLandingPage(){
        driver.navigate().to("https://www.libhumanitas.ro/");
    }

    @BeforeClass
    public static void setup(){
        driver.manage().window().maximize();
        navigateToLandingPage();
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
}
