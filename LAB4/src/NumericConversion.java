import java.util.Scanner;

import static java.lang.System.exit;

public class NumericConversion {

    public static void menu(){
        System.out.println("Decoding Menu");
        System.out.println("-------------");
        System.out.println("1. Decode hexadecimal");
        System.out.println("2. Decode binary");
        System.out.println("3. Convert binary to hexadecimal");
        System.out.println("4. Quit");
        System.out.println("Please enter an option:");
    }
    // provides the user with the available options
    public static long hexStringDecode(String hex){
        double decimal;
        double finalDecimal = 0;
        if (hex.substring(0,2).equals("0x")){
            hex = hex.substring(2);
        }
        for (short i = 0; i < hex.length(); i++){
            decimal = hexCharDecode(hex.charAt(i)) * Math.pow(16, hex.length()-i-1);

            finalDecimal += decimal;
        }
        return (long) finalDecimal;
    }
    // converts hexadecimals to decimals
    // uses the specifications of the single hex char decoder
    // adds the char decoded after every loop and returns it to the main method
    public static short hexCharDecode(char digit){
        short actualValue;
        if (digit == 'A' || digit == 'a'){
            actualValue = 10;
        }
        else if (digit == 'B' || digit == 'b'){
            actualValue = 11;
        }
        else if (digit == 'C' || digit == 'c'){
            actualValue = 12;
        }
        else if (digit == 'D' || digit == 'd'){
            actualValue = 13;
        }
        else if (digit == 'E' || digit == 'e'){
            actualValue = 14;
        }
        else if (digit == 'F' || digit == 'f'){
            actualValue = 15;
        }
        else{
            actualValue = (short) (digit - '0');
        }
        return actualValue;
    }
    // decodes the individual hex chars
    // makes sure the letters are converted to numbers
    // by subtracting '0' makes sure that even the numbers have their correct
    // prevents taking in ASCII values
    public static short binaryStringDecode(String binary){
        double decimal;
        double finalDecimal = 0;

        if (binary.substring(0, 2).equals("0b")){
            binary = binary.substring(2);
        }
        for (int i = 0; i < binary.length(); i++){
            decimal = (binary.charAt(i) - '0') * Math.pow(2, binary.length()-i-1);
            finalDecimal += decimal;
        }
        return (short) finalDecimal;
        // decodes binary string and returns value
        // by subtracting the '0' surpasses the ASCII values
    }
    public static String binaryToHex(String binary){
        double remainder = 1;
        double decimal;
        String hex = null;
        decimal = binaryStringDecode(binary);
        while (remainder !=0){
            remainder = decimal / 16;
            if (remainder == 10){
                remainder = 'A';
            }
            else if (remainder == 11){
                remainder = 'B';
            }
            else if (remainder == 12){
                remainder = 'C';
            }
            else if (remainder == 13){
                remainder = 'D';
            }
            else if (remainder == 14){
                remainder = 'E';
            }
            else if (remainder == 15){
                remainder = 'F';
            }
            else {
                remainder = remainder + '0';
            }
            decimal = decimal % 16;
            hex = remainder + hex;
        }
        return hex;
        //decodes binary string, re-encodes it as hexadecimal, and returns the hexadecimal
        // does this by using the binaryStringDecode method
        // then turns the decimal into a hexadecimal
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input;
        String numericInput;
        while(true){
            menu();
            input = scanner.nextInt();
            if (input == 1){
                System.out.println("Please enter the numeric string to convert:");
                numericInput = scanner.next();
                long result;
                result = hexStringDecode(numericInput);
                System.out.println("Result:" + result);
            }
            else if (input == 2){
                System.out.println("Please enter the numeric string to convert:");
                numericInput = scanner.next();
                long result;
                result = binaryStringDecode(numericInput);
                System.out.println("Result:" + result);
            }
            else if (input == 3){
                System.out.println("Please enter the numeric string to convert:");
                numericInput = scanner.next();
                String result;
                result = binaryToHex(numericInput);
                System.out.println("Result:" + result);
            }
            else if (input == 4){
                System.out.println("Goodbye!");
                exit(0);
            }
        }
        // takes into consideration the user' input
        //calls the appropriate decoder from the methods
        // prints the respective returned value

    }
}
