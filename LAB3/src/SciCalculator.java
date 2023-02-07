import java.util.Scanner;

import static java.lang.System.exit;

public class SciCalculator {

    public static void menuOptions() {
        System.out.println("Calculator Menu");
        System.out.println("---------------");
        System.out.println("0. Exit Program");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Exponentiation");
        System.out.println("6. Logarithm");
        System.out.println("7. Display Average");
        // declares all the options of the calculator
    }

    public static double calculations(double input, double operand1, double operand2) {
        double currentResult = 0.0;

        if (input == 1) {
            currentResult = (operand1 + operand2);
        } else if (input == 2) {
            currentResult = (operand1 - operand2);
        } else if (input == 3) {
            currentResult = (operand1 * operand2);
        } else if (input == 4) {
            currentResult = (operand1 / operand2);
        } else if (input == 5) {
            currentResult = Math.pow(operand1, operand2);
        } else if (input == 6) {
            currentResult = Math.log(operand1) / Math.log(operand2);
        }
        return currentResult;
        // provides the response depending on the chosen method
        // returns the currentResult to the main method
    }

    public static void average(double numOfCalc, double sumOfCalc) {
        double averageCalc;
        System.out.println("Sum of calculations: " + sumOfCalc);
        System.out.println("Number of calculations: " + (numOfCalc - 1));
        averageCalc = sumOfCalc / (numOfCalc - 1);
        System.out.println("Average of calculations: " + averageCalc);
        // had to be created separate
        // dependent on different variables
    }

    public static void main(String[] args) {
        double currentResult = 0.0;
        double input;
        double operand1;
        double operand2;
        double sumOfCalc = 0.0;
        double numOfCalc = 0.0;
        // declares and initializes all variables for main

        System.out.println("Current Result: " + currentResult);
        Scanner scnr = new Scanner(System.in);

        while (true) {

            numOfCalc++;
            menuOptions();
            System.out.println("Enter Menu Selection: ");

            input = scnr.nextDouble();
            if (input == 7) {
                if (sumOfCalc == 0) {
                    System.out.println("Error: No calculations yet to average!");
                } else {
                    average(numOfCalc, sumOfCalc);
                }
                System.out.println("Enter Menu Selection: ");
                input = scnr.nextDouble();
                // had to be placed separate
                // has to keep track of different variables
            } if (input < 0 || input > 7) {
                System.out.println("Error: Invalid selection!");
                System.out.println("Enter Menu Selection: ");
                input = scnr.nextDouble();
            } if (input == 0) {
                System.out.println("Thanks for using this calculator. Goodbye!");
                exit(0);
                // exists program manually
            }

            System.out.println("Enter first operand: ");
            operand1 = scnr.nextDouble();
            System.out.println("Enter second operand: ");
            operand2 = scnr.nextDouble();

            calculations(input, operand1, operand2);
            currentResult = calculations(input, operand1, operand2);
            System.out.println("Current Result: " + currentResult);
            sumOfCalc += currentResult;
            // calls to action the methods
            // sumOfCalc will be needed for future calculations
        }
    }
}