import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);
        double input1;
        double input2;
        int input3;

        System.out.print("Enter first operand: ");
        input1 = scnr.nextDouble();

        System.out.print("Enter second operand: ");
        input2 = scnr.nextDouble();
        // all the floating numbers and integers were declared
        // the scanner was imported to receive the input of the user

        System.out.println("Calculator Menu");
        System.out.println("---------------");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");

        System.out.print("Which operation do you want to perform?");
        input3 = scnr.nextInt();
        // the options are presented to the user
        // depending on their answer the code will execute differently

        if (input3 == 1) {
            System.out.print("The result of the operation is " + (input1 + input2));
            System.out.println(". Goodbye!");
        }
        else if (input3 == 2) {
            System.out.println("The result of the operation is " + (input1 - input2));
            System.out.println(". Goodbye!");
        }
        else if (input3 == 3) {
            System.out.println("The result of the operation is " + (input1 * input2));
            System.out.println(". Goodbye!");
        }
        else if (input3 == 4) {
            System.out.println("The result of the operation is " + (input1 / input2));
            System.out.println(". Goodbye!");
        }
        else{
            System.out.println("Error: Invalid selection! Terminating program.");
        }
        // the if else statements allow the code to execute different operations
        // depending on the input of the user


    }
}
