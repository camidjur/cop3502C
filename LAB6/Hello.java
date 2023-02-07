import java.util.Scanner;

public class Hello {

    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);
        String firstName;
        String age;
        String place;

        System.out.print("Hello. What is your name?");
        firstName = scnr.next();

        System.out.print("It's nice to meet you," + firstName + ". ");

        System.out.print("How old are you?");
        age = scnr.next();

        System.out.println("I see that you are still quite young at only "+ age + ".");

        System.out.print("Where do you live?");
        place = scnr.next();

        System.out.print("Wow! I've always wanted to go to " + place + ".");
        System.out.println(" Thanks for chatting with me. Bye!");

        // gitHub changes!
        // this is my comment

    }
}
