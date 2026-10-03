import java.util.Scanner;

public class PalindromeChecker {

    // Approach 1: Iterative two-pointer check
    public static boolean isPalindromeIterative(String text) {
        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Approach 2: Recursive check
    public static boolean isPalindromeRecursive(String text) {
        if (text.length() <= 1) {
            return true;
        }
        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    // Approach 3: Array Reversal check
    public static boolean isPalindromeArrayReversal(String text) {
        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];

        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }

        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversed[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text to check: ");
        String text = scanner.nextLine();

        String cleanText = text.toLowerCase();

        String resIterative = isPalindromeIterative(cleanText) ? "Palindrome" : "Not Palindrome";
        String resRecursive = isPalindromeRecursive(cleanText) ? "Palindrome" : "Not Palindrome";
        String resReversal = isPalindromeArrayReversal(cleanText) ? "Palindrome" : "Not Palindrome";

        System.out.printf("Iterative: %s | Recursive: %s | Array Reversal: %s%n",
                resIterative, resRecursive, resReversal);

        scanner.close();
    }
}