import java.util.Scanner;

public class SafeInput {
    private static final Scanner in = new Scanner(System.in);

    public static String getRegExString(String prompt, String regEx) {
        System.out.print(prompt);
        String input;
        while (!(input = in.nextLine()).matches(regEx)) {
            System.out.print("Invalid input. " + prompt);
        }
        return input;
    }

    public static String getNonZeroLenString(String prompt) {
        System.out.print(prompt);
        String input;
        while ((input = in.nextLine()).trim().isEmpty()) {
            System.out.print("Input cannot be empty. " + prompt);
        }
        return input;
    }

    public static int getRangedInt(String prompt, int low, int high) {
        int value;
        while (true) {
            System.out.print(prompt);
            if (in.hasNextInt()) {
                value = in.nextInt();
                in.nextLine(); // clear the newline
                if (value >= low && value <= high) {
                    break;
                }
            } else {
                in.nextLine(); // clear the invalid input
            }
            System.out.println("Enter an integer between " + low + " and " + high + ".");
        }
        return value;
    }

    public static boolean getYNConfirm(String prompt) {
        String response;
        do {
            System.out.print(prompt);
            response = in.nextLine().trim().toLowerCase();
        } while (!response.equals("y") && !response.equals("n"));
        return response.equals("y");
    }
}
