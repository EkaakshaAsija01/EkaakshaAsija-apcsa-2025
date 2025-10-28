package piglatin;

import java.util.Scanner;

public class PigLatinTranslator {
    
    public static Book translate(Book input) {
        // Create a new book that will hold the translated version
        Book translatedBook = new Book();

        // Loop through each line of the input book and translate it
        for (int i = 0; i < input.getLineCount(); i++) {
            translatedBook.appendLine(translateLine(input.getLine(i)));
        }

        // Return the finished translated book
        return translatedBook;
    }

    // Helper method to translate a single line
    private static String translateLine(String line) {
        return translate(line);
    }

    public static String translate(String input) {
        String result = "";

        // Handle empty or null input
        if (input == null || input.equals("") || input.equals("    ")) return "";

        // Use Scanner to go word by word
        Scanner sc = new Scanner(input);
        while (sc.hasNext()) {
            String word = sc.next();
            result += translateWord(word);
            if (sc.hasNext()) result += " "; // add space between words
        }
        sc.close();

        return result;
    }

    // Method to translate one individual word into Pig Latin
    private static String translateWord(String input) {
        // Make sure the string isn't empty or just spaces
        if (input == null || input.trim().length() == 0) {
            return input;
        }

        // Handle punctuation at the end of a word
        String punctuation = "";
        if (input.length() > 0) {
            String last = input.substring(input.length() - 1);
            if (!Character.isLetter(last.charAt(0))) {
                punctuation = last;
                input = input.substring(0, input.length() - 1);
            }
        }

        // If the word is now empty (like "." or "!"), return it directly
        if (input.length() == 0) {
            return punctuation;
        }

        // Check if the first letter is uppercase
        boolean firstUpper = Character.isUpperCase(input.charAt(0));

        // Lowercase only the first letter
        input = input.substring(0, 1).toLowerCase() + input.substring(1);

        // Find the first vowel in the word
        int vowelLocation = -1;
        for (int i = 0; i < input.length(); i++) {
            String letter = input.substring(i, i + 1).toLowerCase();
            if (letter.equals("a") || letter.equals("e") || letter.equals("i") ||
                letter.equals("o") || letter.equals("u")) {
                vowelLocation = i;
                break;
            }
        }

        String result;
        if (vowelLocation == 0) {
            result = input + "ay";
        } else if (vowelLocation != -1) {
            String start = input.substring(0, vowelLocation);
            String end = input.substring(vowelLocation);
            result = end + start + "ay";
        } else {
            result = input + "ay";
        }

        // Reapply capitalization if the original started uppercase
        if (firstUpper && result.length() > 0) {
            result = result.substring(0, 1).toUpperCase() + result.substring(1);
        }

        // Add punctuation back
        result = result + punctuation;

        return result;
    }
}
