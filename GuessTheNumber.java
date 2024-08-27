import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Random random = new Random();
            int numberToGuess = random.nextInt(100) + 1;
            int numberOfTries = 0;
            int userGuess;

            System.out.println("Guess the number (between 1 and 100):");

            do {
                userGuess = scanner.nextInt();
                numberOfTries++;

                if (userGuess < numberToGuess) {
                    System.out.println("Too low!");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Congratulations! You've guessed the number in " + numberOfTries + " tries.");
                }
            } while (userGuess != numberToGuess);
        }
    }
}
