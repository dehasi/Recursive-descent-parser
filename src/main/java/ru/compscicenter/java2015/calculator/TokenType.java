package ru.compscicenter.java2015.calculator;

enum TokenType {
    NUMBER ,
    FUNCTION {
        public double apply(final double x) {
            return Function.build(getName()).apply(x);
        }
    },
    OPERATOR {
        public double apply(final double leftOperand, final double rightOperand) {
            return Operator.build(getOperator()).apply(leftOperand, rightOperand);
        }
    },
    BRACKET;

    private String name;

    public TokenType build(final String name) {
        this.name = name;
        return this;
    }

    public double apply(final double leftOperand, final double rightOperand) {
        return 0;
    }

    public double apply(final double x) {
        return 0;
    }

    public String getName() {
        return name;
    }

    public char getOperator() {
        return name.charAt(0);
    }

}
