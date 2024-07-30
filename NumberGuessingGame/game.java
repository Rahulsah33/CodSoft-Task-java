import java.util.Random;
import java.util.*;

public class NumberGame {

    private static final int MAX_ATTEMPTS = 6;
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {
        boolean playAgain;
        do {
            playAgain = playRound();
        } while (playAgain);

        System.out.println("Thanks for playing!");
    }

    private static boolean playRound() {
        int numberToGuess = generateRandomNumber(1, 100);
        int attempts = 0;
        boolean hasGuessedCorrectly = false;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have generated a number between 1 and 100. Try to guess it!");

        while (attempts < MAX_ATTEMPTS) {
            System.out.print("Enter your guess: ");
            int userGuess = getUserGuess();
            attempts++;

            if (userGuess == numberToGuess) {
                hasGuessedCorrectly = true;
                break;
            } else if (userGuess < numberToGuess) {
                System.out.println("It's too low! Try again.");
            } else {
                System.out.println("It's too high! Try again.");
            }
        }

        if (hasGuessedCorrectly) {
            System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
        } else {
            System.out.println("Sorry, you've used all your attempts. The number was " + numberToGuess + ".");
        }

        return promptPlayAgain();
    }

    private static int generateRandomNumber(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    private static int getUserGuess() {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a number: ");
            scanner.next(); // Clear invalid input
        }
        return scanner.nextInt();
    }

    private static boolean promptPlayAgain() {
        System.out.print("Do you want to play again? (yes/no): ");
        String response = scanner.next().trim().toLowerCase();
        return response.equals("yes");
    }
}
