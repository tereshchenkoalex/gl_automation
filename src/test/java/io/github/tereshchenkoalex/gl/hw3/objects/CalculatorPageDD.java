package io.github.tereshchenkoalex.gl.hw3.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class CalculatorPageDD {

    private WebDriver driver;

    private By resultBox = By.id("resultsbox");
    private By equal = By.name("=");
    private By clean = By.name("C");

    public CalculatorPageDD(WebDriver driver) {
        this.driver = driver;
    }


    public String calculate(String expression) {
        inputExpression(expression);
        driver.findElement(equal).click();
        return readDisplay();
    }

    public void inputExpression(String expression) {
        for (int i = 0; i < expression.length(); i++) {
            driver.findElement(By.name("" + expression.charAt(i) + "")).click();
        }
    }

    public String readDisplay() {
        return driver.findElement(resultBox).getAttribute("value");
    }

    public void open() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("calc.html").getFile());
        driver.get("file:///" + file.getAbsolutePath());
    }


    public void clear() {
        driver.findElement(clean).click();
    }
}
