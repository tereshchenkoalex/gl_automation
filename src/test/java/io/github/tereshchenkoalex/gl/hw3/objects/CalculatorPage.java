package io.github.tereshchenkoalex.gl.hw3.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class CalculatorPage {

    private By button_0 = By.name("0");
    private By button_1 = By.name("1");
    private By button_2 = By.name("2");
    private By button_3 = By.name("3");
    private By button_4 = By.name("4");
    private By button_5 = By.name("5");
    private By button_6 = By.name("6");
    private By button_7 = By.name("7");
    private By button_8 = By.name("8");
    private By button_9 = By.name("9");
    private By button_plus = By.name("+");
    private By button_minus = By.name("-");
    private By button_divide = By.name("/");
    private By button_multiply = By.name("x");
    private By button_clear = By.name("C");
    private By button_dot = By.name(".");
    private By button_equal = By.name("=");
    private By result_box = By.id("resultsbox");

    private WebDriver driver;

    public CalculatorPage(WebDriver driver) {
        this.driver = driver;
    }


    public void click(String button) {
        driver.findElement(By.name(button)).click();
    }


    public void click(Keys key) {
        click(key.toString());
    }

    public void click_0() {
        driver.findElement(button_0).click();
    }

    public void click_1() {
        driver.findElement(button_1).click();
    }

    public void click_2() {
        driver.findElement(button_2).click();
    }

    public void click_3() {
        driver.findElement(button_3).click();
    }

    public void click_4() {
        driver.findElement(button_4).click();
    }

    public void click_5() {
        driver.findElement(button_5).click();
    }

    public void click_6() {
        driver.findElement(button_6).click();
    }

    public void click_7() {
        driver.findElement(button_7).click();
    }

    public void click_8() {
        driver.findElement(button_8).click();
    }

    public void click_9() {
        driver.findElement(button_9).click();
    }

    public void click_plus() {
        driver.findElement(button_plus).click();
    }

    public void click_minus() {
        driver.findElement(button_minus).click();
    }

    public void click_divide() {
        driver.findElement(button_divide).click();
    }

    public void click_multiply() {
        driver.findElement(button_multiply).click();
    }

    public void click_dot() {
        driver.findElement(button_dot).click();
    }

    public void click_equal() {
        driver.findElement(button_equal).click();
    }

    public void clear() {
        driver.findElement(button_clear).click();
    }

    public String getResult() {
        return driver.findElement(result_box).getAttribute("value");
    }

    public void open() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("calc.html").getFile());
        driver.get("file:///" + file.getAbsolutePath());
    }

}