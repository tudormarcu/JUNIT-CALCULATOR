package com.tuma.tests;

import com.iopo.Calculator;
import org.junit.*;
import static junit.framework.Assert.assertEquals;


public class CalculatorTest {

    private Calculator myCalculator;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("before class");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("after class");
    }

    @Before
    public void setup() {
        System.out.println("in setup");
        myCalculator = new Calculator();
    }

    @After
    public void after() {
        System.out.println("after");
    }

    @Test
    public void testWhenCalculateReturnValue() {
        myCalculator.calculate("10 cm + 1 m - 10 mm", "mm");
        assertEquals(1090.0, myCalculator.getResult());
    }

    @Test
    public void testWhenConvertValueBasedOnUnitMeasure() {
        double getValue = myCalculator.transform(10.00, "cm");
        assertEquals(100.0, getValue);
    }

    @Test
    public void testWhenApplyAdditionOrSubstraction() {

        double getValue = myCalculator.applyOp('+',10.00, 9.00);
        double getValue2 = myCalculator.applyOp('-',10.00, 9.00);

        assertEquals(19.0, getValue);
        assertEquals(1.0, getValue2);
    }

}
