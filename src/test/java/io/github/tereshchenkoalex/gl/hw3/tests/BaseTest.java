package io.github.tereshchenkoalex.gl.hw3.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.MalformedURLException;

public class BaseTest {

    protected static WebDriver driver;

    @BeforeClass
    public static void setupChromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions().setHeadless(false);
        driver = new ChromeDriver(opt);
    }

    @AfterClass
    public static void stopChromeDriver() {
        driver.quit();
    }

}
