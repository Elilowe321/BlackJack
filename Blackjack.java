import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Blackjack {

    static Boolean playAgain = true;

    static int numsPlayed = 1;
    static int currentTotal;
    static Boolean continueHand;
    static int playerWins;
    static int dealerWins;
    static int ties;
    static P1Random Random;

	public static void main( String args[] ) {
        Random = new P1Random();
	
		while( playAgain == true ) {
			System.out.println( "Start Game #" + numsPlayed );
            firstCard();
            System.out.println("");
            continueHand = true;

            while( continueHand ) {
                options();
            } 

            int dealersHand = dealerHand();

            if( currentTotal < 21 ) {
                System.out.println( "Dealer's hand:" + dealersHand );
                System.out.println( "Your hand is:" + currentTotal );
                System.out.println( "" );
            } 

            if ( dealersHand > currentTotal && dealersHand <= 21 ) {
                System.out.println( "Dealer Wins :(" );
                System.out.println( "" );
                dealerWins++;
            } 
            if ( dealersHand < currentTotal && currentTotal <= 21 ) {
                System.out.println( "You Win :)" );
                System.out.println( "" );
                playerWins++;
            }
             if ( dealersHand == currentTotal ) {
                System.out.println( "Nobody Wins.. Tie" );
                System.out.println( "" );
                ties++;
            }

            numsPlayed++;
		}
	}

    static void firstCard() {
        int firstCard = Random.nextInt(13) + 1;

        System.out.println("");

        System.out.println("Your card is a " + firstCard + "!");
        System.out.println("Your hand is: " + firstCard + "!");

        currentTotal = firstCard;
    }

    static void options(  ) {
        Scanner choose = new Scanner(System.in); 
        System.out.println("1. Get another card");
        System.out.println("2. Hold hand");
        System.out.println("3. Print statistics");
        System.out.println("4. Exit");
        System.out.println("");
        System.out.print("Choose an option: " );
        Integer s = choose.nextInt();
        System.out.println("");

        //P1Random Random = new P1Random();

        if( s == 1 ) {
            int x = newCard();

            if( x == 11 ) {
                System.out.println("Your card is a Jack!");
                x = 10;
            } else if( x == 12 ) {
                System.out.println("Your card is a Queen!");
                x = 10;
            } else if( x == 13 ) {
                System.out.println("Your card is a King!");
                x = 10;
            } else if( x == 1 ) {
                System.out.println("Your card is an Ace!");
            } else {
                System.out.println("Your card is a " + x + "!");
            }
            int newTotal = currentTotal + x;
            System.out.println("Your hand is: " + newTotal + "!");
            currentTotal = newTotal;

            if( currentTotal > 21 ) {
                System.out.println( "" );
                System.out.println( "You exceeded 21! You lose." );
                dealerWins++;
                continueHand = false;
            }

            if( currentTotal == 21 ) {
                    System.out.println( "BLACKJACK! You win!" );
                    System.out.println( "" );
                } 
        }

        if( s == 2 ) {
            continueHand = false;
        }

        if( s == 3 ) {
            System.out.println( "Number of Player wins: " + playerWins );
            System.out.println( "Number of Dealer wins: " + dealerWins );
            System.out.println( "Number of Ties: " + ties );
            System.out.println( "Total # of games played is: " + (numsPlayed - 1) );

            Double winRate = ( (double)playerWins/ (double)( numsPlayed - 1 ) ) * 100;
            System.out.println( "Percentage of Player wins: " + winRate + "%" );

        }

        if( s == 4 ) {
            continueHand = false;
            playAgain = false;
        }

        System.out.println("");
    }

    public static int newCard() {
        int newCard = Random.nextInt(13) + 1;

        return newCard;
    }

    public static int dealerHand() {
        int dealerCard = Random.nextInt(11) + 16;

        return dealerCard;
    }


}