package ru.compscicenter.java2015.calculator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Character.isDigit;
import static java.lang.Character.isLetter;

/**
 * Convert expression string to list of tokens
 */
public final class Tokenizer {

    private static String expression;
    private static List<Token> tokens;
    private static int len;
    private static int pos;


    public static List<Token> getTokens(final String expression) {
        Tokenizer.expression = expression;
        Tokenizer.len = expression.length();
        parseTokens();
        return new ArrayList<>(tokens);
    }

    private static void parseTokens() {
        pos = 0;
        tokens = new LinkedList<>();
        while (pos < len) {
            char c = expression.charAt(pos++);
            Token token;
            if (isDigit(c)) {
                token = parseNumber();
            } else if (isLetter(c)) {
                token = parseFunction();
            } else if (isBracket(c)) {
                token = parseBracket(c);
            } else if (isOperator(c)) {
                token = parseOperator(c);
            } else {
                continue;
            }
            tokens.add(token);
        }
    }

    private static Token parseFunction() {
        --pos;
        char c = expression.charAt(pos++);
        StringBuilder function = new StringBuilder();
        while (isLetter(c)) {
            function.append(c);
            c = expression.charAt(pos++);
        }
        String f = function.toString().toLowerCase();
        --pos;
        return new Token(TokenType.FUNCTION.build(f), f);
    }

    private static Token parseNumber() {
        int start = pos - 1;
        while (pos < len) {
            char c = expression.charAt(pos++);
            if (isE(c)) {
                ++pos;
            } else if (!isDigit(c) && !isDot(c)) {
                --pos;
                break;
            }
        }
        String num = expression.substring(start, pos);
        return new Token(TokenType.NUMBER.build(num), num, Double.valueOf(num));
    }

    private static boolean isBracket(final char c) {
        return "()[]{}".indexOf(c) != -1;
    }

    private static boolean isOperator(final char c) {
        return "+-/*^".indexOf(c) != -1;
    }

    private static boolean isE(final char c) {
        return (c == 'E' || c == 'e');
    }

    /**
     * I'm alwas not sure about decimal mark :(
     * . or , ?
     *
     * @param c character
     * @return is c decimal mark
     */
    private static boolean isDot(final char c) {
        return (c == '.' || c == ',');
    }

    private static Token parseBracket(final char c) {
        return new Token(TokenType.BRACKET.build(String.valueOf(c)), String.valueOf(c));
    }

    private static Token parseOperator(final char c) {
        return new Token(TokenType.OPERATOR.build(String.valueOf(c)), String.valueOf(c));
    }

    private Tokenizer() {

    }
}
