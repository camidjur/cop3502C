import java.util.Scanner;

import static java.lang.System.exit;

public class PakuriProgram {

    public static void menu() {
        System.out.println("Pakudex Main Menu");
        System.out.println("-----------------");
        System.out.println("1. List Pakuri");
        System.out.println("2. Show Pakuri");
        System.out.println("3. Add Pakuri");
        System.out.println("4. Evolve Pakuri");
        System.out.println("5. Sort Pakuri");
        System.out.println("6. Exit");

        System.out.println("What would you like to do?");
        // displays menu
        // in method to avoid repetition
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = -1;
        String temporaryInput;
        String names;
        Pakudex species;
        String[] temp;


        System.out.println("Welcome to Pakudex: Tracker Extraordinaire!");
        System.out.println("Enter max capacity of the Pakudex:");


        while (input < 0) {
            temporaryInput = scanner.next();
            try {
                input = Integer.parseInt(temporaryInput);
                if (input > 0) {
                   continue;
                }
                else {
                    System.out.println("Please enter a valid size.");
                    System.out.println("Enter max capacity of the Pakudex:");
                }
            }
            catch (Exception Ignored) {
                System.out.println("Please enter a valid size.");
                System.out.println("Enter max capacity of the Pakudex:");

            }
        }
        // try and catch block created in order to prevent erroneous input from user
        // while loop allows for multiple tries by the user



        species = new Pakudex(input);

        System.out.println("The Pakudex can hold " + input + " species of Pakuri.");

        while (true) {
            menu();
            try{
                input = scanner.nextInt();
                while (input < 1 || input > 6) {
                    System.out.println("Unrecognized menu selection!");
                    menu();
                    input = scanner.nextInt();
                }
            }
            catch(Exception e){
                System.out.println("Unrecognized menu selection!");
                menu();
                scanner.next();
                input = scanner.nextInt();
            }
            // same as before, try and catch blocks used to prevent erroneous input


            if (input == 1) {
                if (species.getSpeciesArray() == null) {
                    System.out.println("No Pakuri in Pakudex yet!");

                } else {
                    System.out.println("Pakuri In Pakudex:");
                    temp = species.getSpeciesArray();
                    for (int i = 0; i < species.getSize(); i++) {
                        System.out.println("" + (i+1) + ". " + temp[i]);
                    }
                }
            // if else statements checks if the Pakudex is null and acts accordingly
            }

            else if (input == 2) {
                int [] statsTemporary;
                System.out.println("Enter the name of the species to display: ");
                names = scanner.next();
                boolean var = false;

                temp = species.getSpeciesArray();

                for (String s : temp) {
                    if (s.equals(names)) {
                        System.out.println("Species: " + names);

                        statsTemporary = species.getStats(names);
                        if (statsTemporary == null){
                            System.out.println("Error: No such Pakuri!");
                        }
                        for (int i = 0; i < statsTemporary.length; i++){
                            System.out.println("Attack: " + statsTemporary[i]);
                            i++;
                            System.out.println("Defense: " + statsTemporary[i]);
                            i++;
                            System.out.println("Speed: " + statsTemporary[i]);
                            var = true;
                        }

                    }
                }
                if (!var) {
                    System.out.println("Error: No such Pakuri!");
                }
                // multiple loops used to print statements correctly
                // will it print correctly w just the get stats
            }

            else if (input == 3) {

                if (species.getSize() == species.getCapacity()) {
                    System.out.println("Error: Pakudex is full!");
                }
                else {
                    System.out.println("Enter the name of the species to add: ");
                    names = scanner.next();
                    if (species.addPakuri(names)) {
                        System.out.println("Pakuri species " + names + " successfully added!");
                    }
                    else {
                        System.out.println("Error: Pakudex already contains this species!");
                    }
                }
            }
                // two else statements needed due to the possibility of different false results

            else if (input == 4) {
                System.out.println("Enter the name of the species to evolve: ");
                names = scanner.next();
                temp = species.getSpeciesArray();
                for (String s : temp) {
                    if (s.equals(names)) {
                        species.evolveSpecies(names);
                        System.out.println(names + "has evolved!");
                    } else {
                        System.out.println("Error: No such Pakuri!");
                    }
                }
            }

            else if (input == 5) {
                species.sortPakuri();
                System.out.println("Pakuri have been sorted!");
            }

            else if (input == 6) {
                System.out.println("Thanks for using Pakudex! Bye!");
                exit(0);
            }
            // manually exits the program

        }
    }
    /* citations
    - objectively understanding how to work on main TA Alexander
    - fixing error with implementation of addPakuri in main TA Kevin Z
    - fixing try and catch block for capacity TA Kevin Z
    - fixing null point exception TA Kevin A
    - output error in addPakuri method TA William
     */

}

