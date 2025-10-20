package piglatin;

public class PigLatinTranslator {
    public static Book translate(Book input) {
        Book translatedBook = new Book();

        // TODO: Add code here to populate translatedBook with a translation of the
        // input book.
        // Current do-nothing code will return an empty book.
        // Your code will need to call translate(String input) many times.

        return translatedBook;
    }

    public static String translate(String input) {
        System.out.println("  -> translate('" + input + "')");

        String result = "";

        // TODO: translate a string input, store in result.
        // The input to this function could be any English string.
        // It may be made up of many words.
        // This method must call translateWord once for each word in the string.
        result = translateWord(input);

        return result;
    }

    private static String translateWord(String input) {
        System.out.println("  -> translateWord('" + input + "')");

        String result = "";

        // handle empty strings
        if (input.length() == 0) return input;

        // handle punctuation at the end
        String punctuation = "";
        String last = input.substring(input.length() - 1);
        if (!Character.isLetter(last.charAt(0))) {
            punctuation = last;
            input = input.substring(0, input.length() - 1);
        }

        // check if first letter is uppercase
        boolean startsUpper = Character.isUpperCase(input.charAt(0));

        // make the word lowercase to work with
        String lower = input.toLowerCase();

        String first = lower.substring(0, 1);

        boolean startsWithVowel =
            first.equals("a") || first.equals("A") ||
            first.equals("e") || first.equals("E") ||
            first.equals("i") || first.equals("I") ||
            first.equals("o") || first.equals("O") ||
            first.equals("u") || first.equals("U");
// this is so i could commit.
        if (startsWithVowel) {
            result = lower + "ay";
        } else {
            // find where the first vowel is
            int vowelLocation = -1;
            int i = 0;
            while (i < lower.length() && vowelLocation == -1) {
                String letter = lower.substring(i, i + 1);
                if (letter.equals("a") || letter.equals("A") ||
                    letter.equals("e") || letter.equals("E") ||
                    letter.equals("i") || letter.equals("I") ||
                    letter.equals("o") || letter.equals("O") ||
                    letter.equals("u") || letter.equals("U")) {
                    vowelLocation = i;
                }
                i = i + 1;
            }

            if (vowelLocation != -1) {
                String start = lower.substring(0, vowelLocation);
                String end = lower.substring(vowelLocation);
                result = end + start + "ay";
            } else {
                // if no vowels at all
                result = lower + "ay";
            }
        }

        // make first letter uppercase again if original started uppercase
        if (startsUpper && result.length() > 0) {
            result = result.substring(0, 1).toUpperCase() + result.substring(1);
        }

        // put punctuation back
        result = result + punctuation;

        return result;
    }
}
