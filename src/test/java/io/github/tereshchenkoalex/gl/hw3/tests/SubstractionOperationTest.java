package io.github.tereshchenkoalex.gl.hw3.tests;

import io.github.tereshchenkoalex.gl.hw3.objects.CalculatorPage;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SubstractionOperationTest extends BaseTest {

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
    public void subtractionOfTwoIntegers() {
        //WHEN
        calculatorPage.click_2();
        calculatorPage.click_minus();
        calculatorPage.click_2();
        calculatorPage.click_equal();

        //THEN
        assertThat(calculatorPage.getResult()).isEqualTo("0");
    }

    @Test
    public void subtractionOfIntegerAndFloat() {
        //WHEN
        calculatorPage.click_9();
        calculatorPage.click_minus();
        calculatorPage.click_7();
        calculatorPage.click_dot();
        calculatorPage.click_9();
        calculatorPage.click_equal();

        //THEN
        assertThat(calculatorPage.getResult()).isEqualTo("1.1");
    }

    @Test
    public void subtractionOfFloatAndFloat() {
        //WHEN
        calculatorPage.click_9();
        calculatorPage.click_dot();
        calculatorPage.click_3();
        calculatorPage.click_minus();
        calculatorPage.click_3();
        calculatorPage.click_dot();
        calculatorPage.click_1();
        calculatorPage.click_equal();

        //THEN
        assertThat(calculatorPage.getResult()).isEqualTo("6.2");
    }

    @Test
    public void subtractionOfZeroAndInteger() {
        //WHEN
        calculatorPage.click_0();
        calculatorPage.click_minus();
        calculatorPage.click_7();
        calculatorPage.click_equal();

        //THEN
        assertThat(calculatorPage.getResult()).isEqualTo("-7");
    }
}
