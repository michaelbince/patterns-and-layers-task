package tests.ui;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import utils.DriverManager;

public class BaseTest {
    protected final static String baseURL = "https://www.saucedemo.com/";

    protected WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser){
        if (browser == null || browser.isBlank()){
            browser = "chrome";
        }
        DriverManager.setDriver(browser);
        driver = DriverManager.getDriver();
        driver.get(baseURL);
    }

    @AfterMethod
    public void tearDown(){
        DriverManager.quitDriver();
    }
}
