import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SafeInput {
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = "";
        do {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();
        } while (retString.length() == 0);
        return retString;
    }

    public static int getInt(Scanner pipe, String prompt) {
        int intValue = 0;
        boolean validInput = false;
        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextInt()) {
                intValue = pipe.nextInt();
                validInput = true;
            } else {
                pipe.next(); // Read and discard invalid input
                System.out.println("Invalid input. Please enter an integer.");
            }
        } while (!validInput);
        return intValue;
    }

    public static double getDouble(Scanner pipe, String prompt) {
        double doubleValue = 0.0;
        boolean validInput = false;
        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextDouble()) {
                doubleValue = pipe.nextDouble();
                validInput = true;
            } else {
                pipe.next(); // Read and discard invalid input
                System.out.println("Invalid input. Please enter a double.");
            }
        } while (!validInput);
        return doubleValue;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int intValue;
        do {
            intValue = getInt(pipe, prompt + " [" + low + " - " + high + "]");
        } while (intValue < low || intValue > high);
        return intValue;
    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double doubleValue;
        do {
            doubleValue = getDouble(pipe, prompt + " [" + low + " - " + high + "]");
        } while (doubleValue < low || doubleValue > high);
        return doubleValue;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String input;
        boolean b;
        do {
            System.out.print("\n" + prompt + " [Y/N]: ");
            input = pipe.next();
            input = input.toUpperCase();
        } while (!(input.equals("Y") || input.equals("N")));
        return input.equals("Y");
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String inputValue;
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher;
        do {
            inputValue = getNonZeroLenString(pipe, prompt);
            matcher = pattern.matcher(inputValue);
            if (!matcher.matches()) {
                System.out.println("Input does not match the required pattern.");
            }
        } while (!matcher.matches());
        return inputValue;
    }

    public static void prettyHeader(String msg) {
        int totalWidth = 60;
        int msgWidth = msg.length();

        // Calculate the number of stars on each side of the message
        int starsOnEachSide = (totalWidth - msgWidth - 6) / 2; // 6 = 3 stars on each side of the message

        // Print the top row of stars
        for (int i = 0; i < totalWidth; i++) {
            System.out.print("*");
        }
        System.out.println();

        // Print the second row with centered message
        System.out.print("***");
        for (int i = 0; i < starsOnEachSide; i++) {
            System.out.print(" ");
        }
        System.out.print(msg);
        for (int i = 0; i < starsOnEachSide; i++) {
            System.out.print(" ");
        }
        // If the message length is odd, add one more space
        if (msgWidth % 2 == 1) {
            System.out.print(" ");
        }
        System.out.println("***");

        // Print the bottom row of stars
        for (int i = 0; i < totalWidth; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}