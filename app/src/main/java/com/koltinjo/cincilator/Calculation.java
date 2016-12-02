package com.koltinjo.cincilator;

import org.javia.arity.Symbols;
import org.javia.arity.SyntaxException;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by colt on 30.11.2016.
 */

// Model.
public class Calculation {

    private final int EXPRESSION_LENGTH_MAX = 100;
    private final Symbols symbols;
    private static String currentExpression;
    private CalculationResult calculationResult;
    private DecimalFormat decimalFormat;

    // Constructor.
    public Calculation() {
        symbols = new Symbols();
        decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(Locale.US);
        decimalFormat.applyPattern("###,##0.##########");
    }

    // Interface.
    interface CalculationResult {
        void onExpressionChange(String result, boolean successful);
    }

    // Delete a single character from currentExpression, unless empty.
    public void deleteCharacter() {
        if (currentExpression.length() > 0) {
            currentExpression = currentExpression.substring(0, currentExpression.length() - 1);
            calculationResult.onExpressionChange(currentExpression, true);
        } else {
            calculationResult.onExpressionChange(App.getContext().getString(R.string.input_invalid), false);
        }
    }

    // Delete entire expression, unless empty.
    public void deleteExpression() {
        if (currentExpression.isEmpty()) {
            calculationResult.onExpressionChange(App.getContext().getString(R.string.input_invalid), false);
        }
        currentExpression = "";
        calculationResult.onExpressionChange(currentExpression, true);
    }

    // Append number to currentExpression if valid.
    public void appendNumber(String number) {
        if (currentExpression.equals("0") && number.equals("0")) {
            calculationResult.onExpressionChange(App.getContext().getString(R.string.input_invalid), false);
        } else {
            if (currentExpression.length() > EXPRESSION_LENGTH_MAX) {
                calculationResult.onExpressionChange(App.getContext().getString(R.string.expression_long), false);
            } else {
                currentExpression += number;
                calculationResult.onExpressionChange(currentExpression, true);
            }
        }
    }

    // Append operator "+-*/" to currentExpression.
    public void appendOperator(String operator) {
        if (validateExpression(operator)) {
            currentExpression += operator;
            calculationResult.onExpressionChange(currentExpression, true);
        }
    }

    // Append decimal sign to currentExpression.
    public void appendDecimal() {
        if (validateExpression("")) {
            currentExpression += ".";
            calculationResult.onExpressionChange(currentExpression, true);
        }
    }

    // If currentExpression passes checks, pass currentExpression to symbols object, and return the result.
    public void performEvaluate() {
        if (validateExpression("")) {
            try {
                currentExpression = currentExpression.replace(",", "");
                Double result = symbols.eval(currentExpression);
                currentExpression = decimalFormat.format(result);
                calculationResult.onExpressionChange(currentExpression, true);
            } catch (SyntaxException e) {
                calculationResult.onExpressionChange(App.getContext().getString(R.string.input_invalid), false);
                e.printStackTrace();
            }
        }
    }

    // Helper method to validate expression.
    private boolean validateExpression(String symbol) {
        if (currentExpression.length() > EXPRESSION_LENGTH_MAX) {
            calculationResult.onExpressionChange(App.getContext().getString(R.string.expression_long), false);
            return false;
        } else if (symbol.equals("sin") ||
                symbol.equals("cos") ||
                symbol.equals("tan") ||
                symbol.equals("ln") ||
                symbol.equals("log") ||
                symbol.equals("!") ||
                symbol.equals("π") ||
                symbol.equals("e") ||
                symbol.equals("^") ||
                symbol.equals("(") ||
                symbol.equals(")") ||
                symbol.equals("√")) {
            return true;
        } else if (currentExpression.endsWith("+") ||
                currentExpression.endsWith("-") ||
                currentExpression.endsWith("*") ||
                currentExpression.endsWith("/")) {
            calculationResult.onExpressionChange(App.getContext().getString(R.string.input_invalid), false);
            return false;
        } else if (currentExpression.isEmpty() && !symbol.equals("-")) {
            calculationResult.onExpressionChange(App.getContext().getString(R.string.expression_empty), false);
            return false;
        } else {
            return true;
        }
    }

    // Setter.
    public void setCalculationResultListener(CalculationResult calculationResult) {
        this.calculationResult = calculationResult;
        currentExpression = "";
    }

}