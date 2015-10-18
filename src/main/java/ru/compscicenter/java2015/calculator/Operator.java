package ru.compscicenter.java2015.calculator;


enum Operator {
    ADD('+') {
        @Override
        public double apply(final double left, final double right) {
            return left + right;
        }
    },
    SUB('-') {
        @Override
        public double apply(final double left, final double right) {
            return left - right;
        }
    },
    MUL('*') {
        @Override
        public double apply(final double left, final double right) {
            return left * right;
        }
    },
    DIV('/') {
        @Override
        public double apply(final double left, final double right) {
            return left / right;
        }
    },
    POW('^') {
        @Override
        public double apply(final double left, final double right) {
            return Math.pow(left, right);
        }
    };

    private final char code;

    Operator(final char code) {
        this.code = code;
    }

    public static Operator build(final char code) {
        for (Operator operator: Operator.values()) {
            if (code == operator.code) {
                return operator;
            }
        }
        return null;
    }

    public abstract double apply(final double left, final double right);


}
