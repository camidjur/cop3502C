import java.util.Scanner;

import static java.lang.System.exit;

public class Blackjack {

    public static void options() {
        System.out.println("1. Get another card");
        System.out.println("2. Hold hand");
        System.out.println("3. Print statistics");
        System.out.println("4. Exit");

        System.out.println("Choose an option: ");
    }
    // this puts the options' menu as a method
    // allows it to be called throughout the code
    // prevents crowding within the if else statements

    public static int cardValues(int hand) {
        if (hand == 1) {
            System.out.println("Your card is a ACE!");
        } else if (hand == 11) {
            System.out.println("Your card is a JACK!");
            hand = 10;
        } else if (hand == 12) {
            System.out.println("Your card is a QUEEN!");
            hand = 10;
        } else if (hand == 13) {
            System.out.println("Your card is a KING!");
            hand = 10;
        } else {
            System.out.println("Your card is a " + hand + "!");
        }
        return hand;
    }
    //allows for the change between card numbers and individual values
    // also allows for specific cards to be labeled by their formal names

    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);
        P1Random rand = new P1Random();

        int valueTotal = 0;
        int hand = 0;
        int input = 0;
        int dealerHand;
        int gameNum = 1;
        int gamesWon = 0;
        int gamesLost = 0;
        int gamesTied = 0;
        double percentWins;
        // declared and initialized all variables

        while (input != 4) {

            boolean gameNotOver = true;
            System.out.println("START GAME #" + gameNum++);

            hand = rand.nextInt(13) + 1;

            hand = cardValues(hand);
            valueTotal += hand;
            System.out.println("Your hand is: " + valueTotal);

            options();
            input = scnr.nextInt();

            // above is the initial and outer loop used for the whole game
            // below is an inner loop, necessary for the repetition of inputs

            while (gameNotOver) {
                if (input == 1) {
                    while (input == 1) {
                        hand = rand.nextInt(13) + 1;

                        hand = cardValues(hand);
                        valueTotal += hand;
                        System.out.println("Your hand is: " + valueTotal);

                        if (valueTotal == 21) {
                            System.out.println("BLACKJACK! You win!");
                            ++gamesWon;
                            valueTotal = 0;
                            gameNotOver = false;
                            break;
                        } else if (valueTotal > 21) {
                            System.out.println("You exceeded 21! You lose.");
                            ++gamesLost;
                            valueTotal = 0;
                            gameNotOver = false;
                            break;
                            // the breaks in the above two branches were necessary
                            // otherwise the loop was not closing and starting a new game
                        } else {
                            gameNotOver = true;
                        }
                        options();
                        input = scnr.nextInt();
                    }
                    // allows player to keep drawing cards

                } else if (input == 2) {
                    dealerHand = rand.nextInt(11) + 16;
                    System.out.println("Dealer's hand: " + dealerHand);
                    System.out.println("Your hand is: " + valueTotal);

                    if (dealerHand > valueTotal && dealerHand <= 21) {
                        System.out.println("Dealer wins!");
                        ++gamesLost;
                        valueTotal = 0;
                        gameNotOver = false;
                    } else if (dealerHand < valueTotal) {
                        System.out.println("You win!");
                        ++gamesWon;
                        valueTotal = 0;
                        gameNotOver = false;
                    } else if (dealerHand > 21) {
                        System.out.println("You win!");
                        ++gamesWon;
                        valueTotal = 0;
                        gameNotOver = false;
                    } else {
                        System.out.println("It's a tie! No one wins!");
                        ++gamesTied;
                        valueTotal = 0;
                        gameNotOver = false;
                    }
                    // determines hand of the dealer and who wins
                    // in the cases above, bool = false was enough
                    // to break the loop and start a new game

                } else if (input == 3) {
                    System.out.println("Number of Player wins: " + gamesWon);
                    System.out.println("Number of Dealer wins: " + gamesLost);
                    System.out.println("Number of tie games: " + gamesTied);
                    System.out.println("Total # of games played is: " + (gameNum - 2));
                    percentWins = (gamesWon / (gameNum - 2.0) * 100.0);
                    System.out.println("Percentage of Player wins: " + percentWins + "%");
                    // have to be really careful about division with ints
                    // had to make 2.0 and 100.0 a double to preserve the #s

                    options();
                    input = scnr.nextInt();
                    // provides the stats of the game
                    // each had to be kept track of within the other branches

                } else if (input < 1 || input > 4) {
                    System.out.println("Invalid input!");
                    System.out.println("Please enter an integer value between 1 and 4.");
                    options();
                    input = scnr.nextInt();
                    // limits the input of the player to that of the options' menu

                } else if (input == 4) {
                    exit(0);
                }
                // this manually exits the game
                // had to be imported
            }
        }
        // citations
        // Alexander Ng (TA) - boolean loop
        // Syed Hasan (TA) - hand = cardValues(hand);
    }
}