package ru.compscicenter.java2015.calculator;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

import static org.junit.Assert.assertEquals;

/**
 * Created by Rafa on 17.10.2015.
 */
public class PowerTest {
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
    public void testPow() {
        assertEquals(4, calculator.calculate("2 ^ 2"), DELTA);
        assertEquals(8, calculator.calculate("2 ^ 3"), DELTA);
        assertEquals(1024, calculator.calculate("2 ^ 10"), DELTA);
        assertEquals(512, calculator.calculate("2 ^ 3 ^ 2"), DELTA);
        assertEquals(-4, calculator.calculate("-2 ^ 2"), DELTA);
        assertEquals(4, calculator.calculate("(-2) ^ 2"), DELTA);
        assertEquals(16, calculator.calculate("(-2) ^ 2 ^ 2"), DELTA);
        assertEquals(0.25, calculator.calculate("2 ^ -2"), DELTA);
        assertEquals(-1.189207115002721, calculator.calculate("-2 ^ [2] ^ -2"), DELTA);
        assertEquals(0.8455460222649002, calculator.calculate("sin(5) ^ 2 ^ 2"), DELTA);
    }

}
