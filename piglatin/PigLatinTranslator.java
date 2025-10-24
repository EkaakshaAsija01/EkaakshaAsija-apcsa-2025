package piglatin;
import java.util.Scanner;

public class PigLatinTranslator {
    public static Book translate(Book input) {
        Book translatedBook = new Book();

        // TODO: translate the book later
        return translatedBook;
    }

    public static String translate(String input) {
        String result = "";

        if (input == null || input.equals("") || input.equals("    ")) return "";

        Scanner sc = new Scanner(input);
        while (sc.hasNext()) {
            String word = sc.next();
            result += translateWord(word);
            if (sc.hasNext()) result += " ";
        }
        sc.close();

        return result;
    }

    private static String translateWord(String input) {
        if (input.length() == 0) return input;

        // handle punctuation
        String punctuation = "";
        String last = input.substring(input.length() - 1);
        if (!Character.isLetter(last.charAt(0))) {
            punctuation = last;
            input = input.substring(0, input.length() - 1);
        }

        // check if first letter is uppercase
        boolean firstUpper = Character.isUpperCase(input.charAt(0));

        // lowercase first letter only
        input = input.substring(0,1).toLowerCase() + input.substring(1);

        // find first vowel
        int vowelLocation = -1;
        for (int i = 0; i < input.length(); i++) {
            String letter = input.substring(i, i+1).toLowerCase();
            if (letter.equals("a") || letter.equals("e") || letter.equals("i") || letter.equals("o") || letter.equals("u")) {
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

        // apply capitalization to first letter if needed
        if (firstUpper && result.length() > 0) {
            result = result.substring(0,1).toUpperCase() + result.substring(1);
        }

        // add punctuation back
        result = result + punctuation;

        return result;
    }
}
