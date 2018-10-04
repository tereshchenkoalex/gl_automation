package io.github.tereshchenkoalex.gl.hw3.tests;

import io.github.tereshchenkoalex.gl.hw3.objects.CalculatorPage;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberManipulationTest extends BaseTest {

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
    public void secondInputOfZeroAfterInitialZeroIsIgnored() {
        //WHEN
        calculatorPage.click_0();
        calculatorPage.click_0();

        //THEN
        assertThat(calculatorPage.getResult()).isEqualTo("0");
    }

    @Test
    public void inputOfSecondDotAfterDotIsIgnored() {
        //WHEN
        calculatorPage.click_7();
        calculatorPage.click_dot();
        calculatorPage.click_dot();
        calculatorPage.click_3();

        //THEN
        assertThat(calculatorPage.getResult()).isEqualTo("7.3");
    }

    @Test
    public void moreThanOneDivisionMarkIsIgnoredInTheEditField() {
        //WHEN
        calculatorPage.click_7();
        calculatorPage.click_divide();
        calculatorPage.click_divide();

        //THEN
        assertThat(calculatorPage.getResult()).isEqualTo("7/");
    }

    @Test
    public void initialZeroIsClearedIfNumberInputStarted() {
        //WHEN
        calculatorPage.click_0();
        calculatorPage.click_6();
        calculatorPage.click_5();

        //THEN
        assertThat(calculatorPage.getResult()).isEqualTo("65");
    }

    @Test
    public void onlyLastMathematicalOperationIsPerformed() {
        //WHEN
        calculatorPage.click_5();
        calculatorPage.click_divide();
        calculatorPage.click_multiply();
        calculatorPage.click_2();
        calculatorPage.click_equal();
        //THEN
        assertThat(calculatorPage.getResult()).isEqualTo("2.5");
    }

    @Test
    public void exampleWithLongArithmeticalCombinationCountsPrecise() {
        //WHEN
        calculatorPage.click_1();
        calculatorPage.click_0();
        calculatorPage.click_divide();
        calculatorPage.click_2();
        calculatorPage.click_multiply();
        calculatorPage.click_3();
        calculatorPage.click_minus();
        calculatorPage.click_8();
        calculatorPage.click_equal();
        //THEN
        assertThat(calculatorPage.getResult()).isEqualTo("7");
    }

    @Test
    public void dotIsIgnoredIfIsMoreThanInOnePlace() {
        //WHEN
        calculatorPage.click_7();
        calculatorPage.click_dot();
        calculatorPage.click_8();
        calculatorPage.click_dot();
        calculatorPage.click_3();
        //THEN
        assertThat(calculatorPage.getResult()).isEqualTo("7.83");
    }
}
