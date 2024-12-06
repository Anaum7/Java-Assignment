1import java.util.Scanner;

public class StringManipulation {

    // Method to reverse a string
    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    // Method to convert a string to uppercase
    public static String toUpperCase(String str) {
        return str.toUpperCase();
    }

    // Method to convert a string to lowercase
    public static String toLowerCase(String str) {
        return str.toLowerCase();
    }

    // Method to check if a string is a palindrome
    public static boolean isPalindrome(String str) {
        String reversed = reverseString(str);
        return str.equalsIgnoreCase(reversed);
    }

    // Method to count vowels and consonants
    public static void countVowelsAndConsonants(String str) {
        int vowels = 0, consonants = 0;
        String lowerStr = str.toLowerCase();
        
        for (char c : lowerStr.toCharArray()) {
            if (Character.isLetter(c)) {
                if ("aeiou".indexOf(c) != -1) {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        int choice;

        do {
            System.out.println("String Manipulation Menu:");
            System.out.println("1. Reverse a String");
            System.out.println("2. Convert to Uppercase");
            System.out.println("3. Convert to Lowercase");
            System.out.println("4. Check for Palindrome");
            System.out.println("5. Count Vowels and Consonants");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");

            // Handle invalid input for choice
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 1 and 6.");
                scanner.next(); // Clear the invalid input
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (choice >= 1 && choice <= 5) {
                System.out.print("Enter a string: ");
                input = scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("Reversed String: " + reverseString(input));
                        break;
                    case 2:
                        System.out.println("Uppercase String: " + toUpperCase(input));
                        break;
                    case 3:
                        System.out.println("Lowercase String: " + toLowerCase(input));
                        break;
                    case 4:
                        if (isPalindrome(input)) {
                            System.out.println(input + " is a palindrome.");
                        } else {
                            System.out.println(input + " is not a palindrome.");
                        }
                        break;
                    case 5:
                        countVowelsAndConsonants(input);
                        break;
                }
            } else if (choice != 6) {
                System.out.println("Invalid choice. Please select a number between 1 and 6.");
            }

        } while (choice != 6);

        System.out.println("Exiting the program. Goodbye!");
        scanner.close();
    }
}