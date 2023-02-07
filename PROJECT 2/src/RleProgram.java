
import java.util.Scanner;

import static java.lang.System.exit;

public class RleProgram {

    public static void menuOptions(){

        System.out.println("RLE Menu");
        System.out.println("--------");
        System.out.println("0. Exit");
        System.out.println("1. Load File");
        System.out.println("2. Load Test Image");
        System.out.println("3. Read RLE String");
        System.out.println("4. Read RLE Hex String");
        System.out.println("5. Read Data Hex String");
        System.out.println("6. Display Image");
        System.out.println("7. Display RLE String");
        System.out.println("8. Display Hex RLE Data");
        System.out.println("9. Display Hex Flat Data");

        System.out.println("Select a Menu Option:");
        // displays menu options available
        // dictates what method will be called

    }
    public static String toHexString (byte [] data){
        String result = "";
        for (int i = 0; i < data.length; i++){
            if (data[i] == 10){
                result +=  'a';
            }
            else if (data[i] == 11){
                result += 'b';
            }
            else if (data[i] == 12){
                result += 'c';
            }
            else if (data[i] == 13){
                result += 'd';
            }
            else if (data[i] == 14){
                result += 'e';
            }
            else if (data[i] == 15){
                result += 'f';
            }
            else{
                result += data[i];
            }
        }
        return result;
        // reads the individual elements w/in an array
        // translates those elements into a String
        // ensures  the numbers are properly translated into hex
    }
    public static int countRuns (byte [] flatData){
        int count = 1;
        int group = 1;
        for (int i = 0; i < flatData.length - 1; i++){
            if (flatData[i] == flatData[i + 1]){
                count++;
            }
            else {
                group++;
                count = 1;
            }
            if (count >= 15){
                group++;
                count = 1;
            }
        }
        return group;
        // keeps track of how many consecutive numbers there are
        // the consecutive number is part of a larger group
        // when the consecutive number count is over 15, a new group is created
    }
    public static byte [] encodeRle ( byte [] flatData){
        int size = 2*countRuns(flatData);
        byte [] resultingArray = new byte[size];
        int count = 1;
        int num;
        int index = 0;
        for (int i = 0; i < flatData.length; i++){
            if (i != flatData.length-1 && flatData[i] == flatData[i + 1]){
                count++;
                if (count >= 15){
                    num = flatData[i];
                    resultingArray[index] = (byte) count;
                    index++;
                    count = 1;
                    resultingArray[index] = (byte) num;
                    index++;
                    i++;
                    // the i++ ensures that you move on to the next element
                    // necessary when starting to count for next group
                }
            }
            else{
                num = flatData[i];
                resultingArray[index] = (byte) count;
                index++;
                resultingArray[index] = (byte) num;
                index++;
                count = 1;
            }
        }
        return resultingArray;
        // reads in an array of flat data
        // reads elements, keeps track of consecutive numbers and # of groups
        // assigns value of the consecutive numbers and the amount to new array
    }
    public static int getDecodedLength (byte[] rleData){
        int length = 0;
        for (int i = 0; i < rleData.length; i++){
            if (i % 2 == 0){
               length += rleData[i];
            }
        }
        return length;
        // gives the decompressed size of data given by user
    }
    public static byte [] decodeRle (byte [] rleData){
        int size = getDecodedLength(rleData);
        byte [] res = new byte [size];
        int index = 0;
        for (int i = 0; i < rleData.length; i = i + 2){
            int repeats = rleData[i];
            int value = rleData[i + 1];
            for (int j = 0; j < repeats; j++){
                res[index] = (byte) value;
                index++;
            }
        }
        return res;
        // takes in the amount of repetitions of elements
        // prints that element the given number of times
        // decompresses RLE data
    }
    public static byte [] stringToData (String dataString){
        int size = dataString.length();
        byte [] resultingArray = new byte [size];
        for (int i = 0; i < dataString.length(); i++){
            String temp = "";
            temp += dataString.charAt(i);
            resultingArray[i] = Byte.parseByte(temp, 16);
        }
        return resultingArray;
        //reads in a string character by character
        // translates hex nature of elements to traditional numbers
        // adds each newly translated element to an array
    }
    public static String toRleString (byte [] rleData){
        String rleString = "";
        for (int i = 0; i < rleData.length; i++){
            rleString += rleData[i];
            i++;
            byte [] temp = {rleData[i]};
            rleString += toHexString(temp);

            if (i <= rleData.length - 2){
                rleString += ':';
            }
        }
        return rleString;
        //reads in the elements of an array
        // translates them to be understood by user
        // written as count and value
        // the value of the element turns to hex representation
    }
    public static byte [] stringToRle (String rleString){
        String [] separated = rleString.split(":");
        byte [] arr = new byte[separated.length*2];
        int index = 0;

        for ( String substring : separated ){
            if (substring.length() == 2){
                arr[index] = (byte) Character.getNumericValue(substring.charAt(0));
                index++;
                arr[index] = Byte.parseByte(String.valueOf(substring.charAt(1)), 16);
                index++;
            }
            else if (substring.length() == 3){
                arr[index] = (byte) (10+ Character.getNumericValue(substring.charAt(1)));
                index++;
                arr[index] = Byte.parseByte(String.valueOf(substring.charAt(2)), 16);
                index++;
            }
        }
        return arr;
        // reads in a string and separates it by :
        // determines the length of the substrings
        // keeps the count the same but translates hex values to numbers
        // add both to an array
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userInt;
        String userInput;
        String res;

        System.out.println("Welcome to the RLE image encoder!");

        System.out.println("Displaying Spectrum Image:");
        ConsoleGfx.displayImage(ConsoleGfx.testRainbow);

        byte[] imageData = null;

        while(true) {
            menuOptions();
            userInt = scanner.nextInt();

            if (userInt == 0) {
                exit(0);
            }else if (userInt == 1) {
                System.out.println("Enter name of file to load:");
                userInput = scanner.next();
                imageData = ConsoleGfx.loadFile(userInput);
            }else if (userInt == 2) {
                imageData = ConsoleGfx.testImage;
                System.out.println("Test image data loaded.");
            }else if (userInt == 3) {
                System.out.println("Enter an RLE string to be decoded:");
                userInput = scanner.next();
                imageData = decodeRle(stringToRle(userInput));
            }else if (userInt == 4){
                System.out.println("Enter the hex string holding RLE data:");
                userInput = scanner.next();
                imageData = decodeRle(stringToData(userInput));
            }else if (userInt == 5){
                System.out.println("Enter the hex string holding flat data:");
                userInput = scanner.next();
                imageData = stringToData(userInput);
            }else if (userInt == 6) {
                System.out.println("Displaying image...");
                ConsoleGfx.displayImage(imageData);
            }else if (userInt == 7){
                System.out.println("RLE representation:");
                res = toRleString(encodeRle(imageData));
                System.out.println(res);
            }else if (userInt == 8){
                System.out.println("RLE hex values:");
                res = toHexString(encodeRle(imageData));
                System.out.println(res);
            }else if (userInt == 9){
                System.out.println("Flat hex values:");
                res = toHexString(imageData);
                System.out.println(res);
                // calls on the designated methods
            }
        }

        /*citations:
        - debug stringToData TA Ying
        - i++ in encodeRle if branch Professor Zhou
        - issues w display of main menu TA Gabriella Gonzalez
        - logic error in method 8 TA Mateusz
        - using scanner.next instead of scanner.nextLine TA Sunny*/
    }
}
