package com.example;

import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        boolean playAgain = true;

        System.out.println("🎯 Welcome to the Number Guessing Game!");

        while (playAgain) {
            int lowerBound = 1;
            int upperBound = 100;
            int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attemptsLeft = 5; // Limit attempts per round
            boolean guessedCorrectly = false;

            System.out.println("\nI have chosen a number between " + lowerBound + " and " + upperBound + ".");
            System.out.println("You have " + attemptsLeft + " attempts to guess it!");

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess: ");
                int guess;

                // Input validation
                if (sc.hasNextInt()) {
                    guess = sc.nextInt();
                } else {
                    System.out.println("❌ Invalid input. Please enter a number.");
                    sc.next(); // clear invalid input
                    continue;
                }

                if (guess == numberToGuess) {
                    System.out.println("✅ Correct! You guessed the number!");
                    guessedCorrectly = true;
                    totalScore += attemptsLeft * 10; // Score based on remaining attempts
                    break;
                } else if (guess > numberToGuess) {
                    System.out.println("📉 Too high! Try again.");
                } else {
                    System.out.println("📈 Too low! Try again.");
                }

                attemptsLeft--;
                System.out.println("Attempts left: " + attemptsLeft);
            }

            if (!guessedCorrectly) {
                System.out.println("❌ You ran out of attempts! The number was: " + numberToGuess);
            }

            System.out.println("Current Score: " + totalScore);

            // Ask for another round
            System.out.print("\nDo you want to play again? (yes/no): ");
            String response = sc.next().trim().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("\n🎮 Game Over! Your final score is: " + totalScore);
        sc.close();
    }
}

