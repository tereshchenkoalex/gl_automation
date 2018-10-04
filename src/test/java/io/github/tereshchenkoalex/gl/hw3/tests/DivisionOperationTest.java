package io.github.tereshchenkoalex.gl.hw3.tests;

import io.github.tereshchenkoalex.gl.hw3.objects.CalculatorPage;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DivisionOperationTest extends BaseTest {

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
    public void divisionOfTwoIntegersWithResultInteger() {
        //WHEN
        calculatorPage.click_8();
        calculatorPage.click_divide();
        calculatorPage.click_2();
        calculatorPage.click_equal();

        //THEN
        assertThat(calculatorPage.getResult()).isEqualTo("4");
    }

    @Test
    public void divisionOfTwoIntegersWithResultWithExponent() {
        //WHEN
        calculatorPage.click_3();
        calculatorPage.click_divide();
        calculatorPage.click_9();
        calculatorPage.click_9();
        calculatorPage.click_9();
        calculatorPage.click_9();
        calculatorPage.click_9();
        calculatorPage.click_9();
        calculatorPage.click_9();
        calculatorPage.click_9();
        calculatorPage.click_9();
        calculatorPage.click_equal();

        //THEN
        assertThat(calculatorPage.getResult()).isEqualTo("3.000000003e-9");
    }

    @Test
    public void divisionOfTwoIntegersWithResultFloat() {
        //WHEN
        calculatorPage.click_9();
        calculatorPage.click_divide();
        calculatorPage.click_2();
        calculatorPage.click_equal();

        //THEN
        assertThat(calculatorPage.getResult()).isEqualTo("4.5");
    }

    @Test
    public void divisionOfIntegerAndFloatWithResInteger() {
        //WHEN
        calculatorPage.click_9();
        calculatorPage.click_divide();
        calculatorPage.click_4();
        calculatorPage.click_dot();
        calculatorPage.click_5();
        calculatorPage.click_equal();

        //THEN
        assertThat(calculatorPage.getResult()).isEqualTo("2");
    }

    @Test
    public void divisionOfIntegerAndFloatWithResultFloat() {
        //WHEN
        calculatorPage.click_9();
        calculatorPage.click_divide();
        calculatorPage.click_4();
        calculatorPage.click_dot();
        calculatorPage.click_0();
        calculatorPage.click_equal();

        //THEN
        assertThat(calculatorPage.getResult()).isEqualTo("2.25");
    }

    @Test
    public void divisionOfFloatAndFloat() {
        //WHEN
        calculatorPage.click_1();
        calculatorPage.click_2();
        calculatorPage.click_dot();
        calculatorPage.click_9();
        calculatorPage.click_divide();
        calculatorPage.click_4();
        calculatorPage.click_dot();
        calculatorPage.click_3();
        calculatorPage.click_equal();

        //THEN
        assertThat(calculatorPage.getResult()).isEqualTo("3");
    }

    @Test
    public void divisionOfIntegerByZero() {
        //WHEN
        calculatorPage.click_8();
        calculatorPage.click_divide();
        calculatorPage.click_0();
        calculatorPage.click_equal();

        //THEN
        assertThat(calculatorPage.getResult()).isEqualTo("Error!");
    }

    @Test
    public void divisionOfFloatByZero() {
        //WHEN
        calculatorPage.click_8();
        calculatorPage.click_dot();
        calculatorPage.click_6();
        calculatorPage.click_divide();
        calculatorPage.click_0();
        calculatorPage.click_equal();

        //THEN
        assertThat(calculatorPage.getResult()).isEqualTo("Error!");
    }

    @Test
    public void divisionOfZeroByInteger() {
        //WHEN
        calculatorPage.click_0();
        calculatorPage.click_divide();
        calculatorPage.click_7();
        calculatorPage.click_7();
        calculatorPage.click_equal();

        //THEN
        assertThat(calculatorPage.getResult()).isEqualTo("0");
    }
}
