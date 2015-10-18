package ru.compscicenter.java2015.calculator;

import java.util.List;

/**
 * Recursive descent parser
 */
public class CalculatorImpl implements Calculator {

    private List<Token> tokens;
    private int len;
    private int pos;

    @Override
    public double calculate(final String expression) {

        this.tokens = Tokenizer.getTokens(expression);
        this.len = tokens.size();
        this.pos = 0;
        return calcExpression();
    }

    private double calcExpression() {
        double result = calcTerm();
        while (pos < len) {
            Token token = tokens.get(pos++);
            if (token.isSecondTypeOperator()) {
                result = token.apply(result, calcTerm());
                continue;
            }
            --pos;
            break;
        }
        return result;
    }

    private double calcTerm() {
        double result = calcMultiplier();
        while (pos < len) {
            Token token = tokens.get(pos++);
            if (token.isFirstTypeOperator()) {
                result = token.apply(result, calcMultiplier());
                continue;
            }
            --pos;
            break;
        }
        return result;
    }

    private double calcMultiplier() {
        Token token = tokens.get(pos++);
        double result = 0;
        switch (token.getType()) {
            case OPERATOR:
                return token.apply(result, calcMultiplier());
            case NUMBER:
                result = token.getValue();
                break;
            case FUNCTION:
                result = calcFunction(token);
                break;
            case BRACKET:
                result = calcExpression();
            default:
                ++pos;
                break;
        }
        return Math.pow(result, calcDegree());
    }

    private double calcDegree() {
        double result = 1.;
        if (pos < len) {
            Token token = tokens.get(pos++);
            if (token.isPow()) {
                result = calcMultiplier();
            } else {
                --pos;
            }
        }
        return result;
    }

    private double calcFunction(final Token function) {
        ++pos;
        double result = function.apply(calcExpression());
        ++pos;
        return result;
    }

}
