import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class GoogleMainPageTest {
    private WebDriver driver;

    @Before
    public void openChrome() {
        driver = new ChromeDriver();
        //Timeout for locating elements
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void openGoogleMainPageAndSearch() throws Exception {
        driver.get("http://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium WebDriver");

        WebElement searchButton = driver.findElement(By.name("btnK"));
        //Can not click the element because it has a type input
        searchButton.submit();
        //Wait for some time to observe the result
        Thread.sleep(5000);
    }

    @After
    public void quitChrome() {
        driver.quit();
    }
}
