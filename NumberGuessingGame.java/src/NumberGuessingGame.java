import java.util.Random;
import java.util.Scanner;
public class NumberGuessingGame {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        Random random=new Random();
        int lowerBound=1;
        int upperBound=100;
        int maxAttempts=10;
        int score=0;
        boolean playAgain=true;
        while(playAgain){
            int targetNumber= random.nextInt(upperBound-lowerBound+1)+lowerBound;
            int attempts=0;
            boolean guessedCorrectly=false;
            System.out.println("Guess the Number bet."+lowerBound+"and"+upperBound+".");
            while(attempts <maxAttempts && !guessedCorrectly){
                System.out.print("Enter your Guess: ");
                int userGuess=scanner.nextInt();
                attempts++;
                if (userGuess==targetNumber){
                    System.out.println("WellDone! You guessed the right No."+attempts+"attempts.");
                    guessedCorrectly=true;
                    score++;
                } else if (userGuess<targetNumber) {
                    System.out.println("Too low! Try Again.");
                } else if (userGuess>targetNumber) {
                    System.out.println("Too High! Try Again.");
                }
            }
            if (!guessedCorrectly){
                System.out.println("BAD LUCK,You have reached the max.limit of attempts. The Correct no.was:"+targetNumber);
            }
            System.out.print("Do you want to play again? (yes/no):");
            String playAgainInput= scanner.next().toLowerCase();
            playAgain=playAgainInput.equals("yes");
            if (playAgain){
                System.out.println("Your current score is:"+score);
            }
        }
        System.out.println("Thanks for Playing! Final Score is:"+score);
        scanner.close();
    }
}