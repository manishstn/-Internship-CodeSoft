import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 5;
        int score = 0;

        boolean playAgain = true;
        while (playAgain) {
            int generatedNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            boolean guessed = false;

            System.out.println("Guess a number between " + minRange + " and " + maxRange + ".");

            while (!guessed && attempts < maxAttempts) {
                System.out.print("Enter your guess (" + (maxAttempts - attempts) + " attempts left): ");
                int userGuess = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                attempts++;

                if (userGuess == generatedNumber) {
                    System.out.println("Congratulations! You've guessed the number " + generatedNumber + " correctly!");
                    guessed = true;
                    score++;
                } else if (userGuess < generatedNumber) {
                    System.out.println("Too low! Try a higher number.");
                } else {
                    System.out.println("Too high! Try a lower number.");
                }
            }

            if (!guessed) {
                System.out.println("Sorry, you've run out of attempts. The number was: " + generatedNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playChoice = scanner.nextLine().toLowerCase();
            playAgain = playChoice.equals("yes") || playChoice.equals("y");
        }

        System.out.println("Your final score is: " + score);
        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
