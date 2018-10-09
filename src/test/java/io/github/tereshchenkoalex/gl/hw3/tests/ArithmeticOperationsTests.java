package io.github.tereshchenkoalex.gl.hw3.tests;

import io.github.tereshchenkoalex.gl.hw3.objects.CalculatorPageDD;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ArithmeticOperationsTests extends BaseTest {

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
        assertEquals(expected, calc.calculate(expression));
    }

    @Parameterized.Parameters(name = "Test: {0}={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"2+2", "4"},
                {"8+-7", "1"},
                {"3+7.9", "10.9"},
                {"8.3+9.9", "18.2"},
                {"0+0.0", "0"},
                {"0-18+3", "-15"},
                {"0-18+18", "0"},
                {"0-18+385", "367"},
                {"8/2", "4"},
                {"3/999999999", "3.000000003e-9"},
                {"9/2", "4.5"},
                {"9/4.5", "2"},
                {"9/4.0", "2.25"},
                {"12.9/4.3", "3"},
                {"8/0", "Error!"},
                {"8.6/0", "Error!"},
                {"0/77", "0"},
                {"57x2", "114"},
                {"30x1.9", "57"},
                {"83x9.1", "755.3"},
                {"55x0", "0"},
                {"55x0.0", "0"},
                {"5x/2", "2.5"},
                {"10/2x3-8", "7"},
                {"2-2", "0"},
                {"9-7.9", "1.1"},
                {"9.3-3.1", "6.2"},
                {"0-7", "-7"},
                {"0-7-85", "-92"},
                {"0-7+0", "-7"},
                {"0-7-0", "-7"}
        });
    }

    @AfterClass
    public static void stop() {
        driver.quit();
    }
}
