// Gracie Hackworth, ALC, February 24th

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserInput input = new UserInput();
        int num1 = input.promptInt("Enter an integer.");
        System.out.println("Twice your number is " + num1 * 2);

        double num2 = input.promptDouble("Enter a double.");
        System.out.println("Twice your number is " + num2 * 2);

        String string1 = input.promptString("Enter a string.");
        System.out.println("Your string is " + string1);
    }
}

//collects user input
class UserInput {
    Scanner scanner = new Scanner(System.in);

// // turns output from userInput as a string, then checks if it's a integer
    public int promptInt(String message) {
        System.out.println(message);
        String userInput = scanner.nextLine();

        int userInt = 0;
        boolean isInt = false;
        while (!isInt) {
            try {
                userInt = Integer.parseInt(userInput);
                isInt = true;
            } catch (NumberFormatException e) {
                System.out.println(userInput + " is not a valid integer. " + message);
                userInput = scanner.nextLine();
            } finally {
                System.out.println("This line is always executed.");
            }
        }

        return userInt;
    }

// turns output from userInput as a string, then checks if it's a double
    public double promptDouble(String message) {
        System.out.println(message);
        String userInput = scanner.nextLine();

        double userDouble = 0;
        boolean isDouble = false;
        while (!isDouble) {
            try {
                userDouble = Double.parseDouble(userInput);
                isDouble = true;
            } catch (NumberFormatException e) {
                System.out.println(userInput + " is not a valid integer. " + message);
                userInput = scanner.nextLine();
            } finally {
                System.out.println("This line is always executed.");
            }
        }
        return userDouble;
    }

//// turns output from userInput as a string, then checks if it's a double, if it's a double it's not a string
    //repeats process until it is a string
    public String promptString(String message) {
        System.out.println(message);
        String userInput = scanner.nextLine();

        while (true) {
            try {
                Double.parseDouble(userInput);
                System.out.println(userInput + " is not a valid string. " + message);
                userInput = scanner.nextLine();
            } catch (NumberFormatException e) {
                return userInput;
            } finally {
                System.out.println("This line is always executed.");
            }
        }
    }
}
