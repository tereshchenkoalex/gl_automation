package io.github.tereshchenkoalex.gl.hw3.tests;

import io.github.tereshchenkoalex.gl.hw3.objects.CalculatorPage;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MultiplicationOperationTest extends BaseTest {

    static CalculatorPage calculatorPage = new CalculatorPage(driver);

    @BeforeClass
    public static void openPage() {
        calculatorPage.open();
    }

    @Before
    public void cleanup() {
        calculatorPage.clear();
    }

    @Test
    public void multiplicationOfTwoIntegers() {
        //WHEN
        calculatorPage.click_5();
        calculatorPage.click_7();
        calculatorPage.click_multiply();
        calculatorPage.click_2();
        calculatorPage.click_equal();

        //THEN
        assertThat(calculatorPage.getResult()).isEqualTo("114");
    }

    @Test
    public void multiplicationOfIntegerAndFloat() {
        //WHEN
        calculatorPage.click_3();
        calculatorPage.click_0();
        calculatorPage.click_multiply();
        calculatorPage.click_1();
        calculatorPage.click_dot();
        calculatorPage.click_9();
        calculatorPage.click_equal();

        //THEN
        assertThat(calculatorPage.getResult()).isEqualTo("57");
    }

    @Test
    public void multiplicationOfFloatAndFloat() {
        //WHEN
        calculatorPage.click_8();
        calculatorPage.click_3();
        calculatorPage.click_multiply();
        calculatorPage.click_9();
        calculatorPage.click_dot();
        calculatorPage.click_1();
        calculatorPage.click_equal();

        //THEN
        assertThat(calculatorPage.getResult()).isEqualTo("755.3");
    }

    @Test
    public void multiplicationOfIntegerAndZero() {
        //WHEN
        calculatorPage.click_5();
        calculatorPage.click_5();
        calculatorPage.click_multiply();
        calculatorPage.click_0();
        calculatorPage.click_equal();

        //THEN
        assertThat(calculatorPage.getResult()).isEqualTo("0");
    }

    @Test
    public void multiplicationOfIntegerAndFloatZero() {
        //WHEN
        calculatorPage.click_5();
        calculatorPage.click_5();
        calculatorPage.click_multiply();
        calculatorPage.click_0();
        calculatorPage.click_dot();
        calculatorPage.click_0();
        calculatorPage.click_equal();

        //THEN
        assertThat(calculatorPage.getResult()).isEqualTo("0");
    }
}
