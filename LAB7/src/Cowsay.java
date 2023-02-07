public class Cowsay {
    private static void listCows(Cow[] cows){
        System.out.println("Cows available: ");
        for (int i = 0; i < cows.length; i++){
            System.out.println(cows[i].getName() + "");
        }
    }
    // lists the cows available to get called

    private static Cow findCow(String name, Cow[] cows){
        for (Cow i : cows){
            if (i.getName().equals(name)){
                return i;
            }
            // returns the cow requested if it was found within the array
        }
        return null;
    }
    public static void main(String[] args) {
        Cow [] cows = HeiferGenerator.getCows();

        if (args[0].equals("-l")){
            listCows(cows);
        }
        // lists the available cows
        // gets called when the command is "java Cowsay -l"

        else if (args[0].equals("-n")) {
            Cow anotherCow = findCow(args[1], cows);
            // uses args[1] to avoid the -n being used as the name

            if (anotherCow == null) {
                System.out.println("Could not find" + args[1] + " cow!");
            }

            else {
                for (int i = 2; i < args.length; i++) {
                    System.out.print(args[i] + " ");
                }
                // iterates to get the message
                // starts at 2 to avoid getting the -n or the name into the message printed

                System.out.println(anotherCow.getImage());
                // prints out the cow that was asked for
            }
            // gets called when the command is "java Cowsay -n COW MESSAGE"
            // the "COW" and "MESSAGE" represent the name of the cow and a text respectively

            if (anotherCow instanceof Dragon) {
                if (((Dragon)anotherCow).canBreatheFire()) {
                    System.out.println("This dragon can breathe fire.");
                } else {
                    System.out.println("This dragon cannot breathe fire.");
                }
            }
            // checks if the cow is a dragon
            // depending on the dragon it declares if it can breathe fire or not (T or F)
        }
        else{
            for (String i : args){
                System.out.print(i + " ");
                // prints out the intended message
            }
            System.out.println(cows[0].getImage());
            // prints default cow since they didn't clarify
            // option gets called when the command was "java Cowsay MESSAGE"
            // the MESSAGE representing the requested text
        }
    }
    /* citations:
    - casting correctly to call canBreatheFire method in main TA Paul Wei
     */
}
