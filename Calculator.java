package com.tuma;

import java.util.Stack;

public class Calculator {

    private double result;

    private double myNumber;
    private char myOperator;
    private String myUnitMeasure;
    private Stack<Double> values = new Stack<>();
    private Stack<Character> operators = new Stack<>();
    private Stack<String> unitOfMeasurement = new Stack<>();

    public double calculate (String expression, String desiredOutput)  {

        String[] splitExpression = expression.split(" ");

        for (int i = 0; i < splitExpression.length; i++) {

            if (splitExpression[i].matches("[0-9]+")) {
                myNumber = Double.parseDouble(splitExpression[i]);
                values.push(transform(myNumber, desiredOutput));
            }
            else if (splitExpression[i].matches("[A-Za-z]+")) {
                myUnitMeasure = splitExpression[i];
                double resConvert = transform(values.pop(),myUnitMeasure);
                unitOfMeasurement.push(Double.toString(resConvert));
                values.push(resConvert);
            }
            else if (splitExpression[i].matches("[+-]")) {
                myOperator = splitExpression[i].charAt(0);
                operators.push(myOperator);
            }
        }
        result = returnMyValue(operators, values);
        return result;
    }

    public double applyOp(char op, double b, double a) {

        switch (op) {
            case '+':
                return a + b;

            case '-':

                double result = a - b;
                if (result >= 0) {
                    return result;
                } else {
                    return b - a;
                }
        }
        return 0;
    }

    public double transform (double myNumber, String desiredUnit) {

        switch (desiredUnit) {

            case "km":
                return myNumber * 1000000;
            case "m":
                return myNumber * 1000;
            case "dm":
                return myNumber * 100;
            case "cm":
                return myNumber * 10;
            case "mm":
                return myNumber;
        }
        return 0;
    }

    private double returnMyValue (Stack<Character> myStackList, Stack<Double> myValuesList) {

        while (!myStackList.empty()) {
            myValuesList.push(applyOp(myStackList.pop(), myValuesList.pop(), myValuesList.pop()));
        }
        return myValuesList.pop();
    }

    public double getResult() {
        return result;
    }
}
