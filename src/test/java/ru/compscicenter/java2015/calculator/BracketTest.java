package ru.compscicenter.java2015.calculator;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

import static org.junit.Assert.assertEquals;

public class BracketTest {
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
    public void testBracket() {
        assertEquals(99999990.03703703, calculator.calculate("1e1 ^ ((((2 ^ 3)))) - 10 + 3^-3"), DELTA);
        assertEquals(-0.9862062778608816, calculator.calculate("sin([1e1] ^ (2 ^ 3) - 10 + {3^-3})"), DELTA);
    }
}
