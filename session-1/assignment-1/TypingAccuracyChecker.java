import java.util.Scanner;

public class TypingAccuracyChecker {

    public static void checkTypingAccuracy(String original, String typed) {
        int length = Math.min(original.length(), typed.length());
        int matched = 0;
        int firstMismatchPos = -1;
        char origChar = '\0';
        char typedChar = '\0';

        for (int i = 0; i < length; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatchPos == -1) {
                firstMismatchPos = i + 1; // 1-based index
                origChar = original.charAt(i);
                typedChar = typed.charAt(i);
            }
        }

        if (firstMismatchPos == -1 && original.length() != typed.length()) {
            firstMismatchPos = length + 1;
        }

        int totalChars = original.length();
        double accuracy = ((double) matched / totalChars) * 100.0;

        System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | ", matched, totalChars, accuracy);

        if (firstMismatchPos == -1 && original.length() == typed.length()) {
            System.out.println("No Mismatches");
        } else if (firstMismatchPos <= length) {
            System.out.printf("First Mismatch at position %d ('%c' vs '%c')%n",
                    firstMismatchPos, origChar, typedChar);
        } else {
            System.out.printf("First Mismatch at position %d (Length mismatch)%n", firstMismatchPos);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter original passage: ");
        String original = scanner.nextLine();

        System.out.print("Enter typed text: ");
        String typed = scanner.nextLine();

        checkTypingAccuracy(original, typed);
        scanner.close();
    }
}