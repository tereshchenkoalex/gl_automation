package io.github.tereshchenkoalex.gl.hw3.tests;

import io.github.tereshchenkoalex.gl.hw3.objects.CalculatorPage;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AdditionOperationTest extends BaseTest {

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
    public void addTwoIntegers() {
        //WHEN
        calculatorPage.click_2();
        calculatorPage.click_plus();
        calculatorPage.click_2();
        calculatorPage.click_equal();

        //THEN
        assertThat(calculatorPage.getResult()).isEqualTo("4");
    }


    @Test
    public void additionOfIntegerAndNegInteger() {
        //WHEN
        calculatorPage.click_8();
        calculatorPage.click_plus();
        calculatorPage.click_minus();
        calculatorPage.click_7();
        calculatorPage.click_equal();

        //THEN
        assertThat(calculatorPage.getResult()).isEqualTo("1");
    }

    @Test
    public void additionOfIntegerAndFloat() {
        //WHEN
        calculatorPage.click_3();
        calculatorPage.click_plus();
        calculatorPage.click_7();
        calculatorPage.click_dot();
        calculatorPage.click_9();
        calculatorPage.click_equal();

        //THEN
        assertThat(calculatorPage.getResult()).isEqualTo("10.9");
    }

    @Test
    public void additionOfFloatAndFloat() {
        //WHEN
        calculatorPage.click_8();
        calculatorPage.click_dot();
        calculatorPage.click_3();
        calculatorPage.click_plus();
        calculatorPage.click_9();
        calculatorPage.click_dot();
        calculatorPage.click_9();
        calculatorPage.click_equal();

        //THEN
        assertThat(calculatorPage.getResult()).isEqualTo("18.2");
    }

    @Test
    public void additionOfZeroAndFloatZero() {
        //WHEN
        calculatorPage.click_0();
        calculatorPage.click_plus();
        calculatorPage.click_0();
        calculatorPage.click_dot();
        calculatorPage.click_0();
        calculatorPage.click_equal();

        //THEN
        assertThat(calculatorPage.getResult()).isEqualTo("0");
    }
}
