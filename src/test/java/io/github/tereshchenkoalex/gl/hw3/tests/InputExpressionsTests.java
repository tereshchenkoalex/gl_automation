package io.github.tereshchenkoalex.gl.hw3.tests;

import io.github.tereshchenkoalex.gl.hw3.objects.CalculatorPageDD;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class InputExpressionsTests extends BaseTest {

    private static CalculatorPageDD calc;

    @Parameterized.Parameter
    public String expression;

    @Parameterized.Parameter(1)
    public String expected;

    @BeforeClass
    public static void setup() {
        calc = new CalculatorPageDD(driver);
        calc.open();
    }

    @Before
    public void cleanup() {
        calc.clear();
    }

    @Test
    public void calculator_DataDrivenTest() {
        calc.inputExpression(expression);
        assertEquals(expected, calc.readDisplay());
    }

    @Parameterized.Parameters(name = "Test: {0}={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"0000.0000=", "0.0000"},
                {"7..3", "7.3"},
                {"7///", "7/"},
                {"065", "65"},
                {"7.8.3", "7.83"},
        });
    }

    @AfterClass
    public static void stop() {
        driver.quit();
    }
}
