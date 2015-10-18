package ru.compscicenter.java2015.calculator;

enum Function {
    SIN("sin") {
        @Override
        public double apply(final double x) {
            return Math.sin(x);
        }
    },
    COS("cos") {
        @Override
        public double apply(final double x) {
            return Math.cos(x);
        }
    },
    ABS("abs") {
        @Override
        public double apply(final double x) {
            return Math.abs(x);
        }
    };
    private final String code;

    Function(final String code) {
        this.code = code;
    }

    public static Function build(final String code) {
        for (Function function: Function.values()) {
            if (code.equalsIgnoreCase(function.code)) {
                return function;
            }
        }
        return null;
    }

    public abstract double apply(double x);
}
