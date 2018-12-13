package com.tuma;

import java.util.logging.Logger;

public class Main {

    private static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        double result = calculator.calculate("10 cm + 1 m - 10 mm", "mm");

        System.out.println(result);

        logger.info("The result is " + result);


    }
}
