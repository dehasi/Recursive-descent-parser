package ru.compscicenter.java2015.calculator;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

import static org.junit.Assert.assertEquals;

public class FullTest {

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
    public void testExp() {
        assertEquals(1000, calculator.calculate("1e3"), DELTA);
        assertEquals(1000, calculator.calculate("1E+3"), DELTA);
        assertEquals(0.001, calculator.calculate("1E-3"), DELTA);
        assertEquals(-15.99999930685258, calculator.calculate("2^1E-3^2+1-3*6"), DELTA);
        assertEquals(20, calculator.calculate("2.e1"), DELTA);
        assertEquals(0.2, calculator.calculate("2.e-1"), DELTA);
        assertEquals(0.253502404055967, calculator.calculate("2.e-1--2^---3+2*sin(-1e5)"), DELTA);
        assertEquals(0, calculator.calculate("2e10 - 2e10"), DELTA);
        assertEquals(-0.1, calculator.calculate("1e-1-1e-1-1e-1"), DELTA);
        assertEquals(-2.555e-10, calculator.calculate("-2.555E-10"), DELTA);
        assertEquals(30.00002, calculator.calculate("AbS(-2e-5+-3e1)"), DELTA);
    }

    @Test
    public void testComplex() {
        assertEquals(99999990.03703703, calculator.calculate("1e1 ^ (2 ^ 3) - 10 + 3^-3"), DELTA);
        assertEquals(-0.9862062778608816, calculator.calculate("sin(1e1 ^ (2 ^ 3) - 10 + 3^-3)"), DELTA);
        assertEquals(0.04, calculator.calculate("--(-5)^-2"), DELTA);
        assertEquals(-3.2, calculator.calculate("-5^-1-3"), DELTA);
        assertEquals(-1.763530332073266, calculator.calculate("2 * --sin(5)^3"), DELTA);
        assertEquals(-2.25, calculator.calculate("-3-2^-2--1"), DELTA);
        assertEquals(-1.75, calculator.calculate("-3+2^-2++1"), DELTA);
        assertEquals(0.24453765688679133, calculator.calculate("---sin(cos(-1^3 + 4) * cos (2 -- 3^2^2))"), DELTA);
        assertEquals(-1000, calculator.calculate("-1e3--2e5^-3"), DELTA);
        assertEquals(0.6695230751461708, calculator.calculate("cos(sin(cos(--2^-3)))"), DELTA);
        assertEquals(2.909297426825682, calculator.calculate("sin(2) + 2"), DELTA);
        assertEquals(1048576.0, calculator.calculate("2^2e1"), DELTA);
        assertEquals(-0.8705505632961241, calculator.calculate("-2^-2e-1"), DELTA);
        assertEquals(-397, calculator.calculate("3-2e1^2"), DELTA);
    }
}
