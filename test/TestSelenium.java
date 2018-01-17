import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestSelenium {

    public String baseUrl = "http://demo.guru99.com/selenium/newtours/";
    String driverPath = "H:\\My Documents\\Test Bench\\IdeaProjects\\local jars\\IEDriverServer.exe";
    public WebDriver driver ;
    public String expected = null;
    public String actual = null;

    @BeforeTest
    public void startBrowser() {
        System.out.println("launching browser");
        System.setProperty("webdriver.ie.driver", driverPath);
        driver = new InternetExplorerDriver();
        driver.get(baseUrl);
    }

    @BeforeMethod
    public void verifyHomepageTitle() {
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    @Test(priority = 0)
    public void register(){
        driver.findElement(By.linkText("REGISTER")).click() ;
        expected = "Register: Mercury Tours";
        actual = driver.getTitle();
        Assert.assertEquals(actual, expected);
    }
    @Test(priority = 1)
    public void support() {
        driver.findElement(By.linkText("SUPPORT")).click() ;
        expected = "Under Construction: Mercury Tours";
        actual = driver.getTitle();
        Assert.assertEquals(actual, expected);
    }

    @AfterMethod
    public void goBackToHomepage ( ) {
        driver.findElement(By.linkText("Home")).click() ;
    }

    @AfterTest
    public void endSession(){
        driver.close();
    }

}
