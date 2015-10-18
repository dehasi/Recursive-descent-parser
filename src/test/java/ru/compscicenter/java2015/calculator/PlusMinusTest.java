package ru.compscicenter.java2015.calculator;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

import static org.junit.Assert.assertEquals;


public class PlusMinusTest {
    public static final double DELTA = 1E-8;
    Calculator calculator;


    @Before
    public void getInstance() throws ClassNotFoundException, IOException, IllegalAccessException, InstantiationException {
        Properties prop = new Properties();
        prop.load(CalculatorTest.class.getClassLoader().getResourceAsStream("build.properties"));
        Locale.setDefault(Locale.US);
        calculator = (Calculator) CalculatorTest.class.getClassLoader().loadClass(prop.getProperty("IMPLEMENTATION_CLASS")).newInstance();
    }

    @Test
    public void testSum() {
        assertEquals(4, calculator.calculate("2 + 2"), DELTA);
        assertEquals(22, calculator.calculate("10 + 12"), DELTA);
        assertEquals(6, calculator.calculate("1 + 2 + 3"), DELTA);
        assertEquals(10, calculator.calculate("3 + 4 + 1 + 2"), DELTA);
    }

    @Test
    public void testMinus() {
        assertEquals(0, calculator.calculate("2 - 2"), DELTA);
        assertEquals(-2, calculator.calculate("10 - 12"), DELTA);
        assertEquals(-4, calculator.calculate("1 - 2 - 3"), DELTA);
        assertEquals(-4, calculator.calculate("3 - 4 - 1 - 2"), DELTA);
    }
}
