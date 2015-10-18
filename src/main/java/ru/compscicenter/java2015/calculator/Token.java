package ru.compscicenter.java2015.calculator;

/**
 * Token and its types
 */
public class Token {

    private TokenType type;
    private String name;
    private double value;

    public Token(final TokenType type, final String name) {
        this.type = type;
        this.name = name;
    }

    public Token(final TokenType type, final String name, final double value) {
        this.type = type;
        this.name = name;
        this.value = value;
    }

    public double apply(final double leftOperand, final double rightOperand) {
        return type.build(name).apply(leftOperand, rightOperand);
    }

    public double apply(final double x) {
        return type.build(name).apply(x);
    }

    boolean isPow() {
        return name.equals(Constants.POWER);
    }

    boolean isFirstTypeOperator() {
        return name.equals(Constants.MULTIPLY)
                || name.equals(Constants.DIVIDE)
                || name.equals(Constants.POWER);
    }

    boolean isSecondTypeOperator() {
        return name.equals(Constants.PLUS)
                || name.equals(Constants.MINUS);
    }

    public TokenType getType() {
        return type;
    }

    public double getValue() {
        return value;
    }

}






