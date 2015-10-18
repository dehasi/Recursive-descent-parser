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
public class MulDivTest {
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
    public void testMul() {
        assertEquals(4, calculator.calculate("2 * 2"), DELTA);
        assertEquals(6, calculator.calculate("2 * 3"), DELTA);
        assertEquals(6.25, calculator.calculate("2.5 * 2.5"), DELTA);
        assertEquals(22.848, calculator.calculate("1.2 * 3.4 * 5.6"), DELTA);
        assertEquals(3.0922720000000004, calculator.calculate("1.231 * 2.512"), DELTA);
        assertEquals(27.664375200000002, calculator.calculate("2.541 * 3.1 * 3.512"), DELTA);
    }

}
